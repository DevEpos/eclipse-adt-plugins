package com.devepos.adt.cst.ui.internal.codesearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutionException;
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
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.codesearch.result.CodeSearchResult;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;

/**
 * Code search query that is using only available ADT API's from SAP
 */
public class ClientBasedCodeSearchQuery extends AbstractCodeSearchQuery
    implements ISearchResultReporter {

  private final IClientBasedCodeSearchService searchService;
  private final IClientCodeSearchConfig searchConfig;

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
    ((CodeSearchResult) getSearchResult()).reset();
    finished = false;

    monitor.beginTask("", 100);
    var startTime = System.currentTimeMillis();

    // fetch packages for current scope
    var packageSearchMonitor = monitor.slice(5);
    packageSearchMonitor.beginTask("", 5);
    monitor.setTaskName("Determine Scope...");
    var folders = searchService.findFolders(monitor, searchConfig);
    System.out.println("Found the following folders");
    for (var f : folders) {
      System.out.printf("Folder %s with object count %d\n", f.getName(), f.getObjectCount());
    }
    packageSearchMonitor.worked(5);
    int objectCount = folders.stream()
        .reduce(0, (subTotal, p) -> subTotal + p.getObjectCount(), Integer::sum);
    searchResult.setObjectScopeCount(objectCount);

    var numJobs = CodeSearchUIPlugin.getDefault()
        .getPreferenceStore()
        .getInt(ICodeSearchPrefs.MAX_CLIENT_SEARCH_JOBS);
    // var chunks = splitList(folders, (int) Math.ceil((double) folders.size() / numJobs));

    var executor = Executors.newFixedThreadPool(numJobs);
    List<Future<IStatus>> futures = new ArrayList<>();
    // monitor.beginTask("Searching Objects", objectCount);

    var objectMonitor = monitor.slice(95);
    objectMonitor.beginTask("", objectCount);
    // monitor.setTaskName(String.format("Searching objects... (%d packages)", chunks.size()));
    monitor.setTaskName(String.format("Searching objects... (%d packages)", folders.size()));

    try {
      // for (var chunk : chunks) {
      for (var chunk : folders) {
        futures.add(executor.submit(
            () -> searchService.searchFolder(objectMonitor, List.of(chunk), searchConfig, this)));
      }

      System.out.printf("%d pending tasks\n", futures.size());

      for (Future<IStatus> future : futures) {
        var result = future.get(); // Wait for each to finish
        if (!result.isOK()) {
          return result; // Fail fast
        }
      }

      System.out.println("Duration: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
      finished = true;
      return Status.OK_STATUS;
    } catch (InterruptedException | ExecutionException e) {
      Thread.currentThread().interrupt();
      if (e.getCause() instanceof OperationCanceledException) {
        return Status.CANCEL_STATUS;
      }
      System.out.println("Error during parallel execution");

      return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID,
          "Error during parallel execution", e);
    } finally {
      executor.shutdownNow();
    }

  }

  private static List<SearchChunk> splitList(final List<SearchObjectFolder> list,
      final int chunkSize) {
    // List<List<T>> chunks = new ArrayList<>();
    // for (var i = 0; i < list.size(); i += chunkSize) {
    // chunks.add(list.subList(i, Math.min(list.size(), i + chunkSize)));
    // }
    // return chunks;
    // Sort items in descending order by size
    list.sort((a, b) -> Integer.compare(b.getObjectCount(), a.getObjectCount()));

    // Initialize chunks
    var minHeap = new PriorityQueue<SearchChunk>(
        Comparator.comparingInt(SearchChunk::getTotalSize));
    for (int i = 0; i < chunkSize; i++) {
      minHeap.add(new SearchChunk());
    }

    // Greedily assign each item to the chunk with the smallest total size
    for (var folder : list) {
      var smallestChunk = minHeap.poll();
      smallestChunk.addFolder(folder);
      minHeap.add(smallestChunk);
    }

    return new ArrayList<>(minHeap);
  }

  @Override
  public void notify(final ICodeSearchResult result) {
    searchResult.addResult(result, -1);
  }

  private static class SearchChunk {
    private List<SearchObjectFolder> folders = new ArrayList<>();
    private int totalSize = 0;

    public void addFolder(SearchObjectFolder f) {
      folders.add(f);
      totalSize += f.getObjectCount();

    }

    public List<SearchObjectFolder> getFolders() {
      return folders;
    }

    public int getTotalSize() {
      return totalSize;
    }

  }
}