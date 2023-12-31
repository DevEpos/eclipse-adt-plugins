package com.devepos.adt.atm.ui.internal.search;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.search.TaggedObjectSearchFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.ITaggedObjectSearchPrefs;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.search.AbstractAbapProjectSearchQuery;
import com.sap.adt.destinations.model.IDestinationData;

/**
 * Search Query which implements the search for ABAP Tagged Objects
 *
 * @author stockbal
 */
public class TaggedObjectSearchQuery extends AbstractAbapProjectSearchQuery {
  public static final String SEARCH_FAVORITE_TYPE = "com.devepos.adt.taggedobjectsearch";

  private final TaggedObjectSearchResult searchResult;
  private IAbapProjectProvider projectProvider;
  private final ITaggedObjectSearchParams searchParams;

  public TaggedObjectSearchQuery(final ITaggedObjectSearchParams searchParams) {
    this.searchParams = searchParams;
    searchResult = new TaggedObjectSearchResult(this);
  }

  @Override
  public boolean canRunInBackground() {
    return true;
  }

  @Override
  public String getDestinationId() {
    return projectProvider != null ? projectProvider.getDestinationId() : ""; //$NON-NLS-1$
  }

  @Override
  public IProject getProject() {
    return projectProvider != null && projectProvider.hasProject() ? projectProvider.getProject()
        : null;
  }

  @Override
  public String getLabel() {
    return searchParams != null ? Messages.TaggedObjectSearchQuery_TaggedObjectSearchLabel_xmsg
        : ""; //$NON-NLS-1$
  }

  public IAbapProjectProvider getProjectProvider() {
    return projectProvider;
  }

  public ITaggedObjectSearchParams getSearchParams() {
    return searchParams;
  }

  @Override
  public TaggedObjectSearchResult getSearchResult() {
    return searchResult;
  }

  @Override
  public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
    searchResult.cleanup();
    // update the max results parameter as it could have changed in the mean time
    searchParams.setMaxResults(AbapTagsUIPlugin.getDefault()
        .getPreferenceStore()
        .getInt(ITaggedObjectSearchPrefs.MAX_RESULTS));

    // perform object search
    if (projectProvider == null || !projectProvider.hasProject()) {
      return new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID,
          Messages.TaggedObjectSearchQuery_NoProjectError_xmsg);
    }
    final IStatus loggedOnStatus = ProjectUtil
        .ensureLoggedOnToProject(projectProvider.getProject());
    if (!loggedOnStatus.isOK()) {
      return loggedOnStatus;
    }

    monitor.beginTask(Messages.TaggedObjectSearchQuery_SearchTaskName_xmsg,
        IProgressMonitor.UNKNOWN);

    final ITaggedObjectList result = TaggedObjectSearchFactory.createTaggedObjectSearchService()
        .findObjects(projectProvider.getDestinationId(), searchParams);

    if (result != null && result.getTaggedObjects().size() > searchParams.getMaxResults()) {
      searchResult.setHasMoreResults(true);
    }
    searchResult.addSearchResult(result);
    monitor.worked(1);
    monitor.done();
    return Status.OK_STATUS;
  }

  public void setProjectProvider(final IAbapProjectProvider projectProvider) {
    this.projectProvider = projectProvider;
  }

  @Override
  public String toString() {
    final String destinationInfo = getDestinationInfo();
    if (destinationInfo.isEmpty()) {
      return String.format("'%s'", getQuery()); //$NON-NLS-1$
    }
    return String.format("'%s' [%s]", getQuery(), destinationInfo); //$NON-NLS-1$
  }

  private String getDestinationInfo() {
    if (projectProvider == null || !projectProvider.hasProject()) {
      return ""; //$NON-NLS-1$
    }
    final IDestinationData destData = projectProvider.getDestinationData();
    return String.format("%s-%s", destData.getSystemConfiguration().getSystemId(), destData //$NON-NLS-1$
        .getClient());
  }

  private String getQuery() {
    if (searchParams != null) {
      StringBuilder query = new StringBuilder();
      int tagsInString = 0;
      var selectedTagsCount = searchParams.getTagIds().size();

      if (searchParams.getTags().isEmpty()) {
        tagsInString = selectedTagsCount;
        query.append(String.format("%d selected Tags", tagsInString));
      } else {
        for (var tag : searchParams.getTags()) {
          if (query.length() >= 40) {
            break;
          }
          if (query.length() > 0) {
            query.append(", "); //$NON-NLS-1$
          }
          query.append(tag);
          tagsInString++;
        }
      }
      if (tagsInString != selectedTagsCount) {
        query.append(String.format(Messages.TaggedObjectSearchQuery_MoreTagsInQuery_xlbl,
            searchParams.getTags().size() - tagsInString));
      }
      return query.toString();
    }
    return ""; //$NON-NLS-1$
  }
}
