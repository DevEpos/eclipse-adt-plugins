package com.devepos.adt.saat.ui.internal.search.view;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.search.ui.ISearchResult;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.base.ui.search.AbstractAbapProjectSearchQuery;
import com.devepos.adt.saat.search.ObjectSearchServiceFactory;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.sap.adt.communication.resources.ResourceException;

/**
 * Represents an Object Search Query which can be executed from the eclipse
 * search dialog
 *
 * @author stockbal
 */
public class ObjectSearchQuery extends AbstractAbapProjectSearchQuery {
  public static final String SEARCH_FAVORITE_TYPE = "com.devepos.adt.objectsearch";
  private ObjectSearchRequest searchRequest;
  private final ObjectSearchResult searchResult;

  /**
   * Creates a new Object Search Query from the given search request. The
   * {@link ObjectSearchRequest} holds all the data needed to execute this query
   *
   * @param searchRequest the search request of this query
   */
  public ObjectSearchQuery(final ObjectSearchRequest searchRequest) {
    this.searchRequest = searchRequest;
    searchResult = new ObjectSearchResult(this);
    searchResult.setOutputConfig(searchRequest.getOutputConfig());
  }

  @Override
  public boolean canRunInBackground() {
    return true;
  }

  @Override
  public String getDestinationId() {
    var projectProvider = getProjectProvider();
    return projectProvider != null && projectProvider.hasProject()
        ? projectProvider.getDestinationId()
        : null;
  }

  @Override
  public String getLabel() {
    return searchRequest != null ? Messages.ObjectSearch_SearchQueryLabel_xmsg : "";
  }

  public IAbapProjectProvider getProjectProvider() {
    return searchRequest != null ? searchRequest.getProjectProvider() : null;
  }

  @Override
  public IProject getProject() {
    var projectProvider = getProjectProvider();
    return projectProvider != null && projectProvider.hasProject() ? projectProvider.getProject()
        : null;
  }

  /**
   * @return the searchRequest of the search query
   */
  public ObjectSearchRequest getSearchRequest() {
    return searchRequest;
  }

  @Override
  public ISearchResult getSearchResult() {
    return searchResult;
  }

  @Override
  public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
    searchResult.cleanup();

    // perform object search
    final String destinationId = searchRequest.getDestinationId();
    IAbapProjectProvider projectProvider = searchRequest.getProjectProvider();
    if (projectProvider == null) {
      projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
      searchRequest.setProjectProvider(projectProvider);
    }
    if (projectProvider == null) {
      return new Status(IStatus.ERROR, SearchAndAnalysisPlugin.PLUGIN_ID,
          NLS.bind("Destination Id ''{0}'' is not valid", destinationId));
    }
    if (!projectProvider.ensureLoggedOn()) {
      return new Status(IStatus.ERROR, SearchAndAnalysisPlugin.PLUGIN_ID, NLS
          .bind(Messages.ObjectSearch_ProjectLogonFailed_xmsg, projectProvider.getProjectName()));
    }
    monitor.beginTask(Messages.ObjectSearch_SearchJobProgressText_xmsg, IProgressMonitor.UNKNOWN);

    try {
      var searchService = ObjectSearchServiceFactory.getSearchService();
      var result = searchService.search(destinationId, searchRequest.getQueryInput(), monitor);
      if (!searchRequest.shouldReadAllEntries()
          && result.getResultCount() > searchRequest.getMaxResults()) {
        searchResult.setHasMoreResults(true);
      }
      searchResult.addSearchResult(result);
      monitor.worked(1);
      monitor.done();
      return Status.OK_STATUS;
    } catch (final ResourceException exc) {
      final String localizedMessage = exc.getLocalizedMessage();
      return new Status(IStatus.ERROR, SearchAndAnalysisPlugin.PLUGIN_ID,
          localizedMessage != null ? localizedMessage : Messages.ObjectSearch_GeneralError_xmsg);
    }
  }

  /**
   * Sets the search request for this query
   *
   * @param searchRequest the new search request
   */
  public void setSearchRequest(final ObjectSearchRequest searchRequest) {
    this.searchRequest = searchRequest;
  }

}
