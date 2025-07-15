package com.devepos.adt.cst.ui.internal.codesearch;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
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

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.content.PlainTextContentHandler;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchFactory;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.codesearch.result.CodeSearchResult;
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
    ((CodeSearchResult) getSearchResult()).reset();

    var startTime = System.currentTimeMillis();

    var destination = DestinationUtil.getDestinationId(getProject());
    var params = AdtRisVirtualFoldersServiceFactory.createVirtualFolderRequestParameters();
    params.setObjectSearchPattern("*");
    params.addPreselection("package", "/AIF/STRUC");
    // params.addPreselection("package", "/AIF/ANALYZER");
    params.addPreselection("type", "CLAS");
    // params.setWantedFacets(Arrays.asList("type"));
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destination);
    try {
      // monitor.beginTask("Loading scope for code search...", 1);
      var service = AdtRisVirtualFoldersServiceFactory
          .createVirtualFoldersSearchService(destination);
      monitor.beginTask("Determine objects", 1);
      folderContent = service.getContent(params, monitor);
      monitor.worked(1);
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

    ExecutorService executor = Executors.newFixedThreadPool(10);
    List<Future<IStatus>> futures = new ArrayList<>();
    monitor.beginTask("Searching", folderContent.getObjectCount());

    try {
      for (var chunk : chunks) {
        futures.add(executor.submit(() -> runSearchTask(monitor, destination, chunk)));
      }

      for (Future<IStatus> future : futures) {
        IStatus result = future.get(); // Wait for each to finish
        if (!result.isOK()) {
          return result; // Fail fast
        }
      }

      System.out.println("Duration: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
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

  private static <T> List<List<T>> splitList(List<T> list, int chunkSize) {
    List<List<T>> chunks = new ArrayList<>();
    for (int i = 0; i < list.size(); i += chunkSize) {
      chunks.add(list.subList(i, Math.min(list.size(), i + chunkSize)));
    }
    return chunks;
  }

  private IStatus runSearchTask(IProgressMonitor m, String destination, List<IObject> chunk) {
    var codeSearchResult = ICodeSearchFactory.eINSTANCE.createCodeSearchResult();
    var startTime = System.currentTimeMillis();
    try {

      final var session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destination);
      var pattern = Pattern.compile(getQuerySpecs().getPatterns().split(System.lineSeparator())[0]);

      var matchCount = 0;

      for (var o : chunk) {
        var searchObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
        searchObject.setUri(
            "/sap/bc/adt/oo/classes/" + URLEncoder.encode(o.getName(), StandardCharsets.UTF_8));
        var adtMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
        adtMainObj.setType(IAdtObjectTypeConstants.CLASS);
        adtMainObj.setName(o.getName());
        adtMainObj.setUri(
            "/sap/bc/adt/oo/classes/" + URLEncoder.encode(o.getName(), StandardCharsets.UTF_8));
        searchObject.setAdtMainObject(adtMainObj);

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

        var sourceLines = source.split("\r\n");
        for (int i = 0; i < sourceLines.length; i++) {
          var line = sourceLines[i];
          final var matcher = pattern.matcher(line);
          while (matcher.find()) {
            var begin = matcher.start();
            var endOffset = matcher.end();
            var match = ICodeSearchFactory.eINSTANCE.createCodeSearchMatch();
            match
                .setUri(String.format("/sap/bc/adt/oo/classes/%s/source/main#start=%d,%d;end=%d,%d",
                    URLEncoder.encode(o.getName(), StandardCharsets.UTF_8), i + 1, begin, i + 1,
                    endOffset));
            match.setSnippet(line);
            searchObject.getMatches().add(match);
            matchCount++;
          }
        }
        // final var matcher = pattern.matcher(source);
        // while (matcher.find()) {
        // var group = matcher.group();
        // var begin = matcher.start();
        // var endOffset = matcher.end();
        // matchCount.set(matchCount.get() + 1);
        // }
        m.worked(1);
        if (!searchObject.getMatches().isEmpty()) {
          codeSearchResult.getSearchObjects().add(searchObject);
        }
      }
      codeSearchResult.setNumberOfResults(matchCount);
    } finally {
      ((CodeSearchResult) getSearchResult()).addResult(codeSearchResult,
          System.currentTimeMillis() - startTime);
    }
    return Status.OK_STATUS;
  }

}
