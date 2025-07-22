package com.devepos.adt.cst.ui.internal.codesearch;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.search.client.IClientBasedCodeSearchService;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.ISearchResultReporter;
import com.devepos.adt.cst.search.client.SearchObjectFolder;
import com.devepos.adt.cst.search.client.SearchableObject;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.codesearch.result.CodeSearchResult;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;

/**
 * Code search query that is using only available ADT API's from SAP
 */
public class ClientBasedCodeSearchQuery extends AbstractCodeSearchQuery
    implements ISearchResultReporter {

  private static final DecimalFormat DEFAULT_FORMAT = new DecimalFormat("###,###");
  private final IClientBasedCodeSearchService searchService;
  private final IClientCodeSearchConfig searchConfig;
  private Set<SearchableObject> searchableObjects;

  public ClientBasedCodeSearchQuery(final CodeSearchQuerySpecification querySpecs) {
    super(querySpecs);
    searchResult = new CodeSearchResult(this);
    searchService = CodeSearchFactory.getClientCodeSearchService(getProject());
    searchConfig = searchService.createConfig();
    querySpecs.convertToClientSearchConfig(searchConfig);
  }

  @Override
  public boolean canRerun() {
    return super.canRerun();
  }

  @Override
  public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
    searchResult.reset();
    searchableObjects = new HashSet<>();
    start();
    finished = false;

    monitor.beginTask("", 100);

    // fetch packages for current scope
    var packageSearchMonitor = monitor.slice(5);
    packageSearchMonitor.beginTask("", 5);
    monitor.setTaskName("Determine Scope...");
    var folders = searchService.findFolders(packageSearchMonitor, searchConfig);
    logDeterminedFolders(folders);

    packageSearchMonitor.worked(5);

    var numJobs = CodeSearchUIPlugin.getDefault()
        .getPreferenceStore()
        .getInt(ICodeSearchPrefs.MAX_CLIENT_SEARCH_JOBS);

    var executor = Executors.newFixedThreadPool(numJobs);

    try {
      var expandMonitor = monitor.slice(5);
      expandMonitor.beginTask("", 5);
      monitor.setTaskName(
          String.format("Expanding %s folders...", DEFAULT_FORMAT.format(folders.size())));
      var expandStatus = getObjectsInFolders(folders, executor, expandMonitor);
      if (!expandStatus.isOK()) {
        return expandStatus;
      }
      // expandMonitor.worked(5);
      if (searchableObjects.size() == 0) {
        finished = true;
        searchResult.setNoObjectsInScope();
        return Status.OK_STATUS;
      }

      var objectMonitor = monitor.slice(90);
      objectMonitor.beginTask("", searchableObjects.size());
      monitor.setTaskName(String.format("Searching %s objects...",
          DEFAULT_FORMAT.format(searchableObjects.size())));
      searchResult.setObjectScopeCount(searchableObjects.size());
      var searchStatus = searchObjects(executor, objectMonitor);
      if (!searchStatus.isOK()) {
        return searchStatus;
      }
      finished = true;
      return Status.OK_STATUS;
    } catch (InterruptedException | ExecutionException e) {
      Thread.currentThread().interrupt();
      if (e.getCause() instanceof OperationCanceledException) {
        return Status.CANCEL_STATUS;
      }
      return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID,
          "Error during parallel execution", e);
    } finally {
      executor.shutdownNow();
    }

  }

  private IStatus getObjectsInFolders(List<SearchObjectFolder> folders, ExecutorService executor,
      IProgressMonitor monitor) throws InterruptedException, ExecutionException {
    var futures = new ArrayList<Future<IStatus>>();

    for (var chunk : folders) {
      futures.add(executor.submit(() -> {
        var objects = searchService.expandFolder(chunk, searchConfig, monitor);
        monitor.worked(1);
        synchronized (searchableObjects) {
          searchableObjects.addAll(objects);
        }
        return Status.OK_STATUS;
      }));
    }

    for (var future : futures) {
      var result = future.get(); // Wait for each to finish
      if (!result.isOK()) {
        return result; // Fail fast
      }
    }
    return Status.OK_STATUS;
  }

  private IStatus searchObjects(ExecutorService executor, IProgressMonitor monitor)
      throws InterruptedException, ExecutionException {
    var chunks = splitList(new ArrayList<>(searchableObjects), 50);
    var futures = new ArrayList<Future<IStatus>>();
    for (var chunk : chunks) {
      futures.add(
          executor.submit(() -> searchService.searchObjects(monitor, chunk, searchConfig, this)));
    }

    System.out.printf("%d pending tasks\n", futures.size());

    for (var future : futures) {
      var result = future.get(); // Wait for each to finish
      if (!result.isOK()) {
        return result; // Fail fast
      }
    }
    return Status.OK_STATUS;
  }

  private void logDeterminedFolders(List<SearchObjectFolder> folders) {
    System.out.println("Found the following folders");
    for (var f : folders) {
      System.out.printf("Folder %s with object count %d\n", f.getName(), f.getObjectCount());
    }
  }

  public static <T> List<List<T>> splitList(List<T> list, int chunkSize) {
    List<List<T>> chunks = new ArrayList<>();
    for (int i = 0; i < list.size(); i += chunkSize) {
      chunks.add(list.subList(i, Math.min(list.size(), i + chunkSize)));
    }
    return chunks;
  }

  @Override
  public void notify(final ICodeSearchResult result) {
    searchResult.addResult(result);
  }

}