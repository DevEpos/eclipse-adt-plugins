package com.devepos.adt.cst.ui.internal.codesearch.client;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

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
import com.devepos.adt.cst.ui.internal.codesearch.AbstractCodeSearchQuery;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuerySpecification;
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
  private Set<SearchObjectFolder> folderSet = Collections.synchronizedSet(new HashSet<>());
  private final Set<SearchObjectFolder> tmpBigFolders = Collections
      .synchronizedSet(new HashSet<>());

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
  public boolean canContinue() {
    return false;
  }

  @Override
  public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
    searchResult.reset();
    searchableObjects = new HashSet<>();
    start();
    finished = false;

    monitor.beginTask("", 100);

    var numJobs = CodeSearchUIPlugin.getDefault()
        .getPreferenceStore()
        .getInt(ICodeSearchPrefs.MAX_CLIENT_SEARCH_JOBS);

    var executor = Executors.newFixedThreadPool(numJobs);

    try {
      var findFoldersStatus = findFolders(monitor, executor);
      if (!findFoldersStatus.isOK()) {
        return findFoldersStatus;
      }
      var expandBigFoldersStatus = expandBigFolders(monitor, executor);
      if (!expandBigFoldersStatus.isOK()) {
        return expandBigFoldersStatus;
      }
      var getObjectsStatus = getObjectsInFolders(monitor, executor);
      if (!getObjectsStatus.isOK()) {
        return getObjectsStatus;
      }
      if (searchableObjects.size() == 0) {
        finished = true;
        searchResult.setNoObjectsInScope();
        return Status.OK_STATUS;
      }

      var searchStatus = searchObjects(monitor, executor);
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
      return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID, "ABAP Code Search failed", e);
    } finally {
      executor.shutdownNow();
    }

  }

  private IStatus findFolders(final IProgressMonitor monitor, ExecutorService executor)
      throws InterruptedException, ExecutionException {
    // fetch packages for current scope
    var packageSearchMonitor = monitor.slice(5);
    packageSearchMonitor.beginTask("", 5);
    monitor.setTaskName("Determine Scope...");
    if (searchConfig.getObjectNames().length > 1) {
      var status = runFindFoldersJob(packageSearchMonitor, executor);
      if (!status.isOK()) {
        return status;
      }
    } else {
      var folders = searchService.findFolders(packageSearchMonitor, searchConfig);
      if (folders != null) {
        folderSet = new HashSet<>(folders);
      }
    }
    packageSearchMonitor.worked(5);
    return Status.OK_STATUS;
  }

  private IStatus runFindFoldersJob(final IProgressMonitor monitor, ExecutorService executor)
      throws InterruptedException, ExecutionException {
    var job = new ParallelJob();
    for (var objectPattern : searchConfig.getObjectNames()) {
      job.addTask(executor.submit(() -> {
        var foundFolders = searchService.findFolders(monitor, searchConfig, objectPattern);
        if (foundFolders != null) {
          folderSet.addAll(foundFolders);
          return Status.OK_STATUS;
        }
        return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID,
            String.format("Folder search for pattern %s failed", objectPattern));
      }));
    }
    return job.awaitResult();
  }

  private IStatus expandBigFolders(final IProgressMonitor monitor, final ExecutorService executor)
      throws InterruptedException, ExecutionException {

    var expandMonitor = monitor.slice(5);
    expandMonitor.beginTask("", 5);
    monitor.setTaskName("Expanding folders...");
    var bigFolders = extractBigFolders(folderSet);
    while (bigFolders != null && !bigFolders.isEmpty()) {
      var status = runExpandFoldersJob(bigFolders, expandMonitor, executor);
      if (!status.isOK()) {
        return status;
      }
      if (!tmpBigFolders.isEmpty()) {
        bigFolders = extractBigFolders(tmpBigFolders);
        folderSet.addAll(tmpBigFolders);
        tmpBigFolders.clear();
      }
    }
    expandMonitor.worked(5);
    return Status.OK_STATUS;
  }

  private IStatus runExpandFoldersJob(final List<SearchObjectFolder> folderToExpand,
      final IProgressMonitor expandMonitor, final ExecutorService executor)
      throws InterruptedException, ExecutionException {
    var job = new ParallelJob();
    for (var f : folderToExpand) {
      job.addTask(executor.submit(() -> {
        var expandedFolders = searchService.expandFolder(f, searchConfig, expandMonitor);
        if (expandedFolders != null) {
          tmpBigFolders.addAll(expandedFolders);
          return Status.OK_STATUS;
        }
        return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID,
            String.format("Expansion of folder %s failed", f.getName()));
      }));
    }
    return job.awaitResult();
  }

  private List<SearchObjectFolder> extractBigFolders(final Collection<SearchObjectFolder> folders) {
    var maxFolderSize = 20000;
    var bigFolders = folders.stream()
        .filter(f -> f.getObjectCount() >= maxFolderSize)
        .collect(Collectors.toList());
    if (bigFolders.size() > 0) {
      folders.removeAll(bigFolders);
      return bigFolders;
    }
    return null;
  }

  private IStatus searchObjects(final IProgressMonitor monitor, final ExecutorService executor)
      throws InterruptedException, ExecutionException {
    var objectMonitor = monitor.slice(85);
    objectMonitor.beginTask("", searchableObjects.size());
    monitor.setTaskName(
        String.format("Searching %s objects...", DEFAULT_FORMAT.format(searchableObjects.size())));
    searchResult.setObjectScopeCount(searchableObjects.size());
    var searchStatus = runSearchObjectsJob(executor, objectMonitor);
    return searchStatus;
  }

  private IStatus runSearchObjectsJob(final ExecutorService executor,
      final IProgressMonitor monitor) throws InterruptedException, ExecutionException {
    var objectsCount = searchableObjects.size();
    var chunks = splitList(new ArrayList<>(searchableObjects),
        objectsCount > 1000 ? 50 : (objectsCount > 500 ? 20 : 5));
    var job = new ParallelJob();
    for (var chunk : chunks) {
      job.addTask(
          executor.submit(() -> searchService.searchObjects(monitor, chunk, searchConfig, this)));
    }

    return job.awaitResult();
  }

  private IStatus getObjectsInFolders(final IProgressMonitor monitor,
      final ExecutorService executor) throws InterruptedException, ExecutionException {

    var loadObjMonitor = monitor.slice(5);
    loadObjMonitor.beginTask("", folderSet.size());
    monitor.setTaskName(String.format("Retrieving objects in %s folders...",
        DEFAULT_FORMAT.format(folderSet.size())));

    var job = new ParallelJob();

    for (var chunk : folderSet) {
      job.addTask(executor.submit(() -> {
        var objects = searchService.getObjectsInFolder(chunk, searchConfig, loadObjMonitor);
        loadObjMonitor.worked(1);
        synchronized (searchableObjects) {
          if (objects != null) {
            searchableObjects.addAll(objects);
          }
        }
        return Status.OK_STATUS;
      }));
    }

    return job.awaitResult();
  }

  public static <T> List<List<T>> splitList(final List<T> list, final int chunkSize) {
    List<List<T>> chunks = new ArrayList<>();
    for (var i = 0; i < list.size(); i += chunkSize) {
      chunks.add(list.subList(i, Math.min(list.size(), i + chunkSize)));
    }
    return chunks;
  }

  @Override
  public void notify(final ICodeSearchResult result) {
    searchResult.addResult(result);
  }

  private static class ParallelJob {
    private final List<Future<IStatus>> futures = new ArrayList<>();

    public void addTask(final Future<IStatus> task) {
      futures.add(task);
    }

    public int size() {
      return futures.size();
    }

    public IStatus awaitResult() throws InterruptedException, ExecutionException {
      for (var future : futures) {
        var result = future.get(); // Wait for each to finish
        if (!result.isOK()) {
          return result; // Fail fast
        }
      }
      return Status.OK_STATUS;
    }
  }

}