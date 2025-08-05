package com.devepos.adt.cst.ui.internal.codesearch.result;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.search.ui.IQueryListener;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.NewSearchUI;

import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.ui.internal.codesearch.AbstractCodeSearchQuery;
import com.devepos.adt.cst.ui.internal.codesearch.client.ClientBasedCodeSearchQuery;

/**
 * Holds runtime information of a code search query
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CodeSearchRuntimeInformation implements IQueryListener {
  private final Set<IRuntimeInfoListener> runtimeListeners = new HashSet<>();
  private int averageDuration;
  private int requestCount;
  private int resultCount;
  private int objectScopeCount;
  private int searchedSourcesCount;
  private float searchedLinesOfCode;

  private int searchedObjectsCount;

  private String systemId;
  private String subTask;
  private int overallServerTimeInMs;
  private long overallClientTimeInMs;
  private long clientTimeInMs;
  private final AbstractCodeSearchQuery searchQuery;
  private final boolean isClientApiTargeted;

  public CodeSearchRuntimeInformation(final AbstractCodeSearchQuery searchQuery) {
    this.searchQuery = searchQuery;
    isClientApiTargeted = searchQuery instanceof ClientBasedCodeSearchQuery;
  }

  interface IRuntimeInfoListener {
    void queryFinished();

    void updated();

    void subTaskChanged(String subTask);
  }

  /**
   * Returns the average net query duration
   */
  public int getAverageDuration() {
    return averageDuration;
  }

  public void setQuerySubTaskName(final String subTask) {
    this.subTask = subTask;
    fireSubTaskChanged(subTask);
  }

  public String getQuerySubTaskName() {
    return subTask;
  }

  /**
   * Returns the count of the objects in scope
   */
  public int getObjectScopeCount() {
    return objectScopeCount;
  }

  public long getOverallClientTimeInMs() {
    return overallClientTimeInMs + clientTimeInMs;
  }

  /**
   * Returns the overall net server time of the query, i.e. the pure search duration
   */
  public long getOverallServerTimeInMs() {
    return overallServerTimeInMs;
  }

  public int getResultCount() {
    return resultCount;
  }

  /**
   * Returns the number of lines of code that were searched
   */
  public float getSearchedLinesOfCode() {
    return searchedLinesOfCode;
  }

  /**
   * Returns the count of searched objects
   */
  public int getSearchedObjectsCount() {
    return searchedObjectsCount;
  }

  /**
   * Returns the count of searched sources
   */
  public int getSearchedSourcesCount() {
    return searchedSourcesCount;
  }

  public String getSystemId() {
    if (systemId == null) {
      systemId = searchQuery.getProjectProvider()
          .getDestinationData()
          .getSystemConfiguration()
          .getSystemId();
    }
    return systemId;
  }

  public void updateOverallClientTime() {
    overallClientTimeInMs += clientTimeInMs;
  }

  public void updateClientTime() {
    synchronized (searchQuery) {
      clientTimeInMs = System.currentTimeMillis() - searchQuery.getStartTime();
    }
    fireUpdated();
  }

  public boolean isQueryFinished() {
    return searchQuery != null && searchQuery.isFinished();
  }

  public boolean isSearchRunning() {
    return searchQuery == null ? false : NewSearchUI.isQueryRunning(searchQuery);
  }

  @Override
  public void queryAdded(final ISearchQuery query) {
  }

  @Override
  public void queryFinished(final ISearchQuery query) {
    if (query == searchQuery) {
      fireQueryFinished();
    }
  }

  @Override
  public void queryRemoved(final ISearchQuery query) {
  }

  @Override
  public void queryStarting(final ISearchQuery query) {
  }

  public void reset() {
    averageDuration = -1;
    overallServerTimeInMs = -1;
    overallClientTimeInMs = -1;
    clientTimeInMs = -1;
    resultCount = 0;
    requestCount = 0;
    searchedLinesOfCode = 0;
    objectScopeCount = 0;
    searchedSourcesCount = 0;
    searchedObjectsCount = 0;
  }

  public void setObjectCount(final int objectCount) {
    objectScopeCount = objectCount;
  }

  public void updateWithNewResult(final ICodeSearchResult result) {
    resultCount += result.getNumberOfResults();
    searchedObjectsCount += result.getNumberOfSearchedObjects();
    searchedSourcesCount += result.getNumberOfSearchedSources();
    searchedLinesOfCode += result.getLinesOfSearchedCode();
    if (!isClientApiTargeted) {
      overallServerTimeInMs += result.getQueryTimeInMs();
      averageDuration = overallServerTimeInMs / ++requestCount;
    }

    fireUpdated();
  }

  public boolean isClientSearch() {
    return searchQuery instanceof ClientBasedCodeSearchQuery;
  }

  void addRuntimeInfoListener(final IRuntimeInfoListener l) {
    runtimeListeners.add(l);
  }

  void removeRuntimeInfoListener(final IRuntimeInfoListener l) {
    runtimeListeners.remove(l);
  }

  void startQueryListening() {
    NewSearchUI.addQueryListener(this);
  }

  void stopQueryListening() {
    NewSearchUI.removeQueryListener(this);
  }

  private void fireQueryFinished() {
    for (IRuntimeInfoListener l : runtimeListeners) {
      l.queryFinished();
    }
  }

  private void fireUpdated() {
    for (IRuntimeInfoListener l : runtimeListeners) {
      l.updated();
    }
  }

  private void fireSubTaskChanged(final String subTask) {
    for (IRuntimeInfoListener l : runtimeListeners) {
      l.subTaskChanged(subTask);
    }
  }
}
