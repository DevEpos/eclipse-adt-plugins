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

import com.devepos.adt.base.model.adtbase.IResponseMessage;
import com.devepos.adt.base.util.ResponseMessageUtil;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.search.NetworkException;
import com.devepos.adt.cst.search.client.IClientBasedCodeSearchService;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.ISearchResultReporter;
import com.devepos.adt.cst.search.client.SearchObjectFolder;
import com.devepos.adt.cst.search.client.SearchableObject;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.codesearch.AbstractCodeSearchQuery;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuerySpecification;
import com.devepos.adt.cst.ui.internal.codesearch.result.CodeSearchResult;
import com.devepos.adt.cst.ui.internal.messages.Messages;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;

/**
 * Code search query that is using only available ADT API's from SAP
 *
 * @author stockbal
 */
public class ClientBasedCodeSearchQuery extends AbstractCodeSearchQuery
    implements ISearchResultReporter {

  private static final DecimalFormat DEFAULT_FORMAT = new DecimalFormat("###,###");
  private static final int MAX_FOLDER_PACKAGE_SIZE = 15000;

  private final IClientBasedCodeSearchService searchService;
  private final IClientCodeSearchConfig searchConfig;

  private final Set<SearchableObject> searchableObjects = Collections
      .synchronizedSet(new HashSet<>());
  private final Set<SearchObjectFolder> folderSet = Collections.synchronizedSet(new HashSet<>());
  private final List<IResponseMessage> searchErrors = Collections
      .synchronizedList(new ArrayList<>());
  private final Set<SearchObjectFolder> tmpBigFolders = Collections
      .synchronizedSet(new HashSet<>());
  private final List<List<SearchObjectFolder>> folderPackages = new ArrayList<>();

  private boolean foldersAreLoaded = false;
  private int remainingOverallWork = 100;
  private int processedObjectCount = 0;
  private int objectCount = 0;

  public ClientBasedCodeSearchQuery(final CodeSearchQuerySpecification querySpecs) {
    super(querySpecs);
    searchResult = new CodeSearchResult(this);
    searchService = CodeSearchFactory.getClientCodeSearchService(getProject());
    searchConfig = searchService.createConfig();
    querySpecs.convertToClientSearchConfig(searchConfig);
  }

  @Override
  public boolean canContinue() {
    return foldersAreLoaded && (!folderPackages.isEmpty() || !searchableObjects.isEmpty());
  }

  @Override
  public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
    initQuery();
    start();

    remainingOverallWork = 100;
    monitor.beginTask("", 100);

    var numJobs = CodeSearchUIPlugin.getDefault()
        .getPreferenceStore()
        .getInt(ICodeSearchPrefs.MAX_CLIENT_SEARCH_JOBS);

    var executor = Executors.newFixedThreadPool(numJobs);

    try {
      if (!isContinueForCurrentExecution) {
        var findFoldersStatus = findFolders(monitor, executor);
        updateClientRuntime();
        if (!findFoldersStatus.isOK()) {
          return findFoldersStatus;
        }
        objectCount = getObjectScopeCount();
        if (objectCount == 0) {
          finished = true;
          searchResult.setNoObjectsInScope();
          return Status.OK_STATUS;
        }
        searchResult.setObjectScopeCount(objectCount);

        // expansion is always required
        var expandBigFoldersStatus = expandBigFolders(monitor, executor);
        if (!expandBigFoldersStatus.isOK()) {
          return expandBigFoldersStatus;
        }

        buildFolderPackages();
      }

      var objectSearchMonitor = newSubMonitor(monitor, remainingOverallWork, objectCount);
      objectSearchMonitor.worked(processedObjectCount);

      while (!isSearchCompleted()) {
        var searchStatus = searchNextPackage(monitor, objectSearchMonitor, executor);
        if (!searchStatus.isOK()) {
          return searchStatus;
        }
      }

      finished = true;
      return Status.OK_STATUS;
    } catch (InterruptedException | ExecutionException | NetworkException e) {
      Thread.currentThread().interrupt();
      if (e.getCause() instanceof OperationCanceledException) {
        return Status.CANCEL_STATUS;
      }
      return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID,
          Messages.ClientBasedCodeSearchQuery_UnknownSearchError_xmsg, e);
    } finally {
      updateClientRuntime();
      executor.shutdownNow();
      writeLogs();
      removeSearchedObjects();
      searchResult.getRuntimeInfo().setQuerySubTaskName("-");
    }
  }

  @Override
  public void reportResult(final ICodeSearchResult result) {
    var logs = result.getResponseMessageList();
    if (logs != null) {
      searchErrors.addAll(logs.getMessages());
      logs.getMessages().clear();
    }
    searchResult.addResult(result);
  }

  @Override
  public void logMessage(final IResponseMessage message) {
    searchErrors.add(message);
  }

  private void initQuery() {
    finished = false;
    isContinueForCurrentExecution = continueQuery;
    continueQuery = false;

    if (!isContinueForCurrentExecution) {
      searchResult.reset();
      searchableObjects.clear();
      tmpBigFolders.clear();
      folderSet.clear();
      foldersAreLoaded = false;
      processedObjectCount = 0;
    } else {
      searchResult.getRuntimeInfo().updateOverallClientTime();
    }

    searchErrors.clear();
  }

  private IStatus searchNextPackage(final IProgressMonitor monitor,
      final IProgressMonitor subMonitor, final ExecutorService executor)
      throws InterruptedException, ExecutionException {
    if (searchableObjects.isEmpty()) {
      var nextPackage = folderPackages.get(0);
      var status = getObjectsInFolders(monitor, subMonitor, nextPackage, executor);
      if (!status.isOK()) {
        return status;
      }
      folderPackages.remove(0);
    }
    // first we search the objects that are in the tmp package
    var status = searchObjects(monitor, subMonitor, executor);
    if (!status.isOK()) {
      return status;
    }
    processedObjectCount += searchableObjects.size();
    searchableObjects.clear();
    return Status.OK_STATUS;
  }

  private void buildFolderPackages() {
    var objectsInPackage = 0;
    List<SearchObjectFolder> currentPackage = new ArrayList<>();

    for (var folder : folderSet) {
      objectsInPackage += folder.getObjectCount();
      currentPackage.add(folder);
      if (objectsInPackage >= MAX_FOLDER_PACKAGE_SIZE) {
        folderPackages.add(currentPackage);
        currentPackage = new ArrayList<>();
        objectsInPackage = 0;
      }
    }
    if (!currentPackage.isEmpty()) {
      folderPackages.add(currentPackage);
    }
    folderSet.clear();
  }

  private boolean isSearchCompleted() {
    return folderPackages.isEmpty() && searchableObjects.isEmpty();
  }

  private IStatus findFolders(final IProgressMonitor monitor, final ExecutorService executor)
      throws InterruptedException, ExecutionException {
    var packageSearchMonitor = newSubMonitor(monitor, 1);
    monitor.setTaskName(Messages.ClientBasedCodeSearchQuery_DetermineScopeJob_xmsg);
    searchResult.getRuntimeInfo()
        .setQuerySubTaskName(Messages.ClientBasedCodeSearchQuery_DetermineScopeSubTask_xmsg);
    if (searchConfig.getObjectNames().length > 1) {
      var status = runFindFoldersJob(packageSearchMonitor, executor);
      if (!status.isOK()) {
        return status;
      }
    } else {
      var folders = searchService.findFolders(packageSearchMonitor, searchConfig);
      if (folders != null) {
        folderSet.addAll(folders);
      }
    }
    packageSearchMonitor.worked(1);
    return Status.OK_STATUS;
  }

  private IStatus runFindFoldersJob(final IProgressMonitor monitor, final ExecutorService executor)
      throws InterruptedException, ExecutionException {
    var job = new ParallelJob();
    for (var objectPattern : searchConfig.getObjectNames()) {
      job.addTask(executor.submit(() -> {
        var foundFolders = searchService.findFolders(monitor, searchConfig, objectPattern);
        updateClientRuntime();
        if (foundFolders != null) {
          folderSet.addAll(foundFolders);
          return Status.OK_STATUS;
        }
        return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID, String
            .format(Messages.ClientBasedCodeSearchQuery_FolderSearchFailed_xmsg, objectPattern));
      }));
    }
    return job.awaitResult();
  }

  private IStatus expandBigFolders(final IProgressMonitor monitor, final ExecutorService executor)
      throws InterruptedException, ExecutionException {

    var expandMonitor = newSubMonitor(monitor, 1);
    monitor.setTaskName(Messages.ClientBasedCodeSearchQuery_ExpandingFoldersJob_xmsg);
    searchResult.getRuntimeInfo()
        .setQuerySubTaskName(Messages.ClientBasedCodeSearchQuery_ExpandingFoldersSubTask_xmsg);

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
    expandMonitor.worked(1);
    foldersAreLoaded = true;
    return Status.OK_STATUS;
  }

  private IStatus runExpandFoldersJob(final List<SearchObjectFolder> folderToExpand,
      final IProgressMonitor expandMonitor, final ExecutorService executor)
      throws InterruptedException, ExecutionException {
    var job = new ParallelJob();
    for (var f : folderToExpand) {
      job.addTask(executor.submit(() -> {
        var expandedFolders = searchService.expandFolder(f, searchConfig, expandMonitor);
        updateClientRuntime();
        if (expandedFolders != null) {
          tmpBigFolders.addAll(expandedFolders);
          return Status.OK_STATUS;
        }
        return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID, String
            .format(Messages.ClientBasedCodeSearchQuery_FolderExpansionFailed_xmsg, f.getName()));
      }));
    }
    return job.awaitResult();
  }

  private List<SearchObjectFolder> extractBigFolders(final Collection<SearchObjectFolder> folders) {
    var maxFolderSize = 15000;
    var bigFolders = folders.stream()
        // we cannot reduce non package folders or folders that do not contain other packages
        .filter(f -> f.getObjectCount() >= maxFolderSize && f.isPackageFacet()
            && f.isHasChildrenOfSameFacet())
        .collect(Collectors.toList());
    if (bigFolders.size() > 0) {
      folders.removeAll(bigFolders);
      return bigFolders;
    }
    return null;
  }

  private IStatus searchObjects(final IProgressMonitor monitor, final IProgressMonitor subMonitor,
      final ExecutorService executor) throws InterruptedException, ExecutionException {

    searchResult.getRuntimeInfo()
        .setQuerySubTaskName(Messages.ClientBasedCodeSearchQuery_ObjectSearchSubTask_xmsg);
    monitor.setTaskName(String.format(Messages.ClientBasedCodeSearchQuery_ObjectSearchJob_xmsg,
        DEFAULT_FORMAT.format(objectCount)));

    var objectsCount = searchableObjects.size();
    var chunks = splitList(new ArrayList<>(searchableObjects),
        objectsCount > 1000 ? 50 : objectsCount > 500 ? 20 : 5);
    var job = new ParallelJob();

    for (var chunk : chunks) {
      job.addTask(executor.submit(() -> {
        if (subMonitor.isCanceled()) {
          return Status.CANCEL_STATUS;
        }
        var objectStatus = searchService.searchObjects(subMonitor, chunk, searchConfig, this);
        updateClientRuntime();
        return objectStatus;
      }));
    }

    return job.awaitResult();
  }

  private IStatus getObjectsInFolders(final IProgressMonitor monitor,
      final IProgressMonitor subMonitor, final Collection<SearchObjectFolder> folders,
      final ExecutorService executor) throws InterruptedException, ExecutionException {

    monitor.setTaskName(String.format(Messages.ClientBasedCodeSearchQuery_ObjectRetrievalJob_xmsg,
        DEFAULT_FORMAT.format(folders.size())));
    searchResult.getRuntimeInfo()
        .setQuerySubTaskName(Messages.ClientBasedCodeSearchQuery_ObjectRetrievalSubTask_xmsg);

    var job = new ParallelJob();

    for (var chunk : folders) {
      job.addTask(executor.submit(() -> {
        if (subMonitor.isCanceled()) {
          return Status.CANCEL_STATUS;
        }
        var objects = searchService.getObjectsInFolder(chunk, searchConfig, subMonitor);
        updateClientRuntime();
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

  private void removeSearchedObjects() {
    var searchedObjects = searchableObjects.stream()
        .filter(SearchableObject::isSearched)
        .collect(Collectors.toList());
    searchableObjects.removeAll(searchedObjects);
    // include the count of these objects in the processed count
    processedObjectCount += searchedObjects.size();
  }

  private <T> List<List<T>> splitList(final List<T> list, final int chunkSize) {
    List<List<T>> chunks = new ArrayList<>();
    for (var i = 0; i < list.size(); i += chunkSize) {
      chunks.add(list.subList(i, Math.min(list.size(), i + chunkSize)));
    }
    return chunks;
  }

  private void updateClientRuntime() {
    searchResult.getRuntimeInfo().updateClientTime();
  }

  private static class ParallelJob {
    private final List<Future<IStatus>> futures = new ArrayList<>();

    public void addTask(final Future<IStatus> task) {
      futures.add(task);
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

  private int getObjectScopeCount() {
    return folderSet.stream().mapToInt(SearchObjectFolder::getObjectCount).sum();
  }

  private void writeLogs() {
    var searchStatus = ResponseMessageUtil.toStatus(
        CodeSearchUIPlugin.PLUGIN_ID, String.format("%s: %s",
            Messages.CodeSearchResult_codeSearchProblemsLogTitle_xmsg, getQuerySpecs()),
        searchErrors);
    if (searchStatus != null) {
      CodeSearchUIPlugin.getDefault().getLog().log(searchStatus);
    }
  }

  private IProgressMonitor newSubMonitor(final IProgressMonitor monitor, final int work) {
    return newSubMonitor(monitor, work, work);
  }

  private IProgressMonitor newSubMonitor(final IProgressMonitor monitor, final int work,
      final int totalWork) {
    var subMonitor = monitor.slice(work);
    remainingOverallWork -= work;
    subMonitor.beginTask("", totalWork);
    return subMonitor;
  }
}