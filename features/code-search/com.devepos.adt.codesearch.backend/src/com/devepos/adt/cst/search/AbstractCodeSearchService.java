package com.devepos.adt.cst.search;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.cst.internal.CodeSearchPlugin;
import com.devepos.adt.cst.internal.messages.Messages;
import com.devepos.adt.cst.internal.search.backend.CodeSearchUriDiscovery;

public abstract class AbstractCodeSearchService {

  protected IProject project;
  protected String destinationId;

  public AbstractCodeSearchService(final IProject project) {
    this.project = project;
    destinationId = DestinationUtil.getDestinationId(project);
  }

  public IStatus testCodeSearchFeatureAvailability() {
    var uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    if (uriDiscovery.isResourceDiscoverySuccessful() && uriDiscovery.getCodeSearchUri() != null) {
      return Status.OK_STATUS;
    }
    return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID, NLS.bind(
        Messages.CodeSearchSearchService_searchNotAvailableInProjectError_xmsg, project.getName()));
  }
}
