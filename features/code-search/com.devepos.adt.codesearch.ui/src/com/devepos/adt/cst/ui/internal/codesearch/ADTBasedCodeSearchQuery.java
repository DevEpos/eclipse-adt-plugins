package com.devepos.adt.cst.ui.internal.codesearch;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;

import com.devepos.adt.base.content.PlainTextContentHandler;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.sap.adt.communication.message.HeadersFactory;
import com.sap.adt.communication.message.IHeaders;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.ris.model.virtualfolders.IObject;
import com.sap.adt.ris.model.virtualfolders.IVirtualFoldersResult;
import com.sap.adt.ris.search.virtualfolders.AdtRisVirtualFoldersServiceFactory;
import com.sap.adt.tools.core.model.util.ServiceNotAvailableException;

public class ADTBasedCodeSearchQuery extends CodeSearchQuery {

  private IVirtualFoldersResult folderContent;
  private AtomicInteger matchCount = new AtomicInteger();

  public ADTBasedCodeSearchQuery(CodeSearchQuerySpecification querySpecs) {
    super(querySpecs);
  }

  @Override
  public boolean canRerun() {
    return super.canRerun();
  }

  @Override
  public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
    var destination = DestinationUtil.getDestinationId(getProject());
    var params = AdtRisVirtualFoldersServiceFactory.createVirtualFolderRequestParameters();
    params.setObjectSearchPattern("*");
    params.addPreselection("package", "/AIF/STRUC");
    params.addPreselection("type", "CLAS");
    // params.setWantedFacets(Arrays.asList("type"));
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destination);
    try {
      var service = AdtRisVirtualFoldersServiceFactory
          .createVirtualFoldersSearchService(destination);
      folderContent = service.getContent(params, monitor);

    } catch (ServiceNotAvailableException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (folderContent == null || folderContent.getObjectCount() == 0) {
      return Status.OK_STATUS;
    }

    var numJobs = 10;
    var chunks = splitList(folderContent.getObject(),
        (int) Math.ceil((double) folderContent.getObjectCount() / numJobs));

    ExecutorService executor = Executors.newFixedThreadPool(numJobs);
    List<Future<IStatus>> futures = new ArrayList<>();
    SubMonitor subMonitor = SubMonitor.convert(monitor, "", folderContent.getObjectCount());

    try {
      for (var chunk : chunks) {
        // var workLoad = chunk.size() / numJobs;
        var workLoad = chunk.size();
        futures.add(
            executor.submit(() -> runSearchTask(subMonitor.split(workLoad), destination, chunk)));
      }

      for (Future<IStatus> future : futures) {
        IStatus result = future.get(); // Wait for each to finish
        if (!result.isOK()) {
          return result; // Fail fast
        }
      }

      return Status.OK_STATUS;

    } catch (InterruptedException | ExecutionException e) {
      Thread.currentThread().interrupt();
      if (e.getCause() instanceof OperationCanceledException) {
        return Status.CANCEL_STATUS;
      }
      return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID,
          "Error during parallel execution", e);
    } finally {
      executor.shutdown();
    }

  }

  private void getFolderObjectsForPackage(String destination) {
    /*
     * System.out.println("Duration of content loading and search: " +
     * (System.nanoTime() - startTime) / 1_000_000_000.0 + "s");
     * System.out.println(
     * "Duration of string search: " + (searchDuration.get()) / 1_000_000_000.0 + "s");
     * System.out.println("Found matches: " + matchCount.get());
     */

    var readVirtualFolderContents = Job.create("Loading Source Content", (m) -> {
      var params = AdtRisVirtualFoldersServiceFactory.createVirtualFolderRequestParameters();
      params.setObjectSearchPattern("*");
      params.addPreselection("package", "/AIF/STRUC");
      params.addPreselection("type", "CLAS");
      // params.setWantedFacets(Arrays.asList("type"));
      final var session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destination);
      try {
        var service = AdtRisVirtualFoldersServiceFactory
            .createVirtualFoldersSearchService(destination);
        folderContent = service.getContent(params, m);
        m.done();
      } catch (ServiceNotAvailableException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    readVirtualFolderContents.addJobChangeListener(new JobChangeAdapter() {

      @Override
      public void done(IJobChangeEvent event) {
        ADTBasedCodeSearchQuery.this.runParallelJobs(destination);
      }

    });
    readVirtualFolderContents.schedule();
  }

  private static <T> List<List<T>> splitList(List<T> list, int chunkSize) {
    List<List<T>> chunks = new ArrayList<>();
    for (int i = 0; i < list.size(); i += chunkSize) {
      chunks.add(list.subList(i, Math.min(list.size(), i + chunkSize)));
    }
    return chunks;
  }

  private IStatus runSearchTask(IProgressMonitor m, String destination, List<IObject> chunk) {
    try {
      m.beginTask("Searching code chunk with size ", chunk.size());
      final var session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destination);
      for (var o : chunk) {
        // System.out.println("Searching class include " + o.getName());
        var pattern = Pattern.compile("DATA");
        var getClassContent = URI.create("/sap/bc/adt/oo/classes/" +
            URLEncoder.encode(o.getName(), StandardCharsets.UTF_8) + "/source/main");
        var resource = AdtRestResourceFactory.createRestResourceFactory()
            .createRestResource(getClassContent, session);
        resource.addContentHandler(new PlainTextContentHandler());
        IHeaders.IField headerField = HeadersFactory.newField("Accept",
            new String[] { "text/plain" });
        IHeaders requestHeaders = HeadersFactory.newHeaders();
        requestHeaders.addField(headerField);
        var source = resource.get(m, requestHeaders, String.class);
        final var matcher = pattern.matcher(source);
        while (matcher.find()) {
          matchCount.set(matchCount.get() + 1);
        }
        m.worked(1);
      }
    } finally {
      m.done();
    }
    return Status.OK_STATUS;
  }

  private void runParallelJobs(String destination) {
    int numJobs = 10;
    System.out.println("Processing folder with " + folderContent.getObjectCount() + " classes");
    var chunks = splitList(folderContent.getObject(),
        (int) Math.ceil((double) folderContent.getObjectCount() / numJobs));
    var countdownLatch = new CountDownLatch(chunks.size());
    var matchCount = new AtomicInteger();

    var jobCount = 0;

    for (var chunk : chunks) {
      var job = new Job("Processing Chunk") {
        @Override
        protected IStatus run(IProgressMonitor m) {
          try {
            System.out.println("Started new chunk job with obj count: " + chunk.size());
            final var session = AdtSystemSessionFactory.createSystemSessionFactory()
                .createStatelessSession(destination);
            m.beginTask("Loading Chunk with Size ", chunk.size());
            for (var o : chunk) {
              // var searchDuration = new AtomicLong(0L);
              var pattern = Pattern.compile("DATA");
              var getClassContent = URI.create("/sap/bc/adt/oo/classes/" +
                  URLEncoder.encode(o.getName(), StandardCharsets.UTF_8) + "/source/main");
              var resource = AdtRestResourceFactory.createRestResourceFactory()
                  .createRestResource(getClassContent, session);
              resource.addContentHandler(new PlainTextContentHandler());
              IHeaders.IField headerField = HeadersFactory.newField("Accept",
                  new String[] { "text/plain" });
              IHeaders requestHeaders = HeadersFactory.newHeaders();
              requestHeaders.addField(headerField);
              var source = resource.get(m, requestHeaders, String.class);
              final var matcher = pattern.matcher(source);
              while (matcher.find()) {
                matchCount.set(matchCount.get() + 1);
              }
              m.worked(1);
            }
          } finally {
            countdownLatch.countDown();
          }
          return Status.OK_STATUS;
        }
      };

      long queue = jobCount++ % numJobs;
      var parallelExecutionRule = new NumberedQueueSchedulingRule(queue);
      job.setRule(parallelExecutionRule);
      job.schedule();
    }

    try {
      var startTime = System.nanoTime();
      countdownLatch.await();
      System.out.println(
          "Content search completed in " + (System.nanoTime() - startTime) / 1_000_000_000.0 + "s");
    } catch (InterruptedException exc) {
      Thread.currentThread().interrupt();
    }
  }

}

class NumberedQueueSchedulingRule implements ISchedulingRule {
  private long queueNumber;

  public NumberedQueueSchedulingRule(long queueNumber) {
    this.queueNumber = queueNumber;
  }

  public boolean contains(ISchedulingRule rule) {
    return rule == this;
  }

  public boolean isConflicting(ISchedulingRule rule) {
    if (rule instanceof NumberedQueueSchedulingRule) {
      var otherRule = (NumberedQueueSchedulingRule) rule;
      return otherRule.queueNumber == queueNumber;
    }
    return false;
  }
}