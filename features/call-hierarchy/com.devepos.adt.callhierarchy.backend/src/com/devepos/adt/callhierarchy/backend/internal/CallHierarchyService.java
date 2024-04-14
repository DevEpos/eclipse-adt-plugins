package com.devepos.adt.callhierarchy.backend.internal;

import java.net.URI;
import java.text.MessageFormat;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.callhierarchy.backend.ICallHierarchyService;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IRestResource;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.communication.session.ISystemSession;

/**
 * Default hierarchy service implementation
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CallHierarchyService implements ICallHierarchyService {

  @Override
  public IHierarchyResult getCallHierarchy(final String destinationId,
      final IProgressMonitor monitor, final Map<String, Object> queryParams) {
    CallHierarchyUriDiscovery uriDiscovery = new CallHierarchyUriDiscovery(destinationId);

    if (queryParams == null) {
      throw new IllegalArgumentException("No query parameters not supplied");
    }
    URI hierarchyUri = uriDiscovery
        .createUriFromTemplate(uriDiscovery.getCallHierarchyUriTemplate(), queryParams);

    if (hierarchyUri != null) {
      final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(hierarchyUri, session);
      restResource.addContentHandler(new CallHierarchyResultContentHandler());
      return restResource.get(monitor, IHierarchyResult.class);
    }
    return null;
  }

  @Override
  public IStatus testCallHierarchyFeatureAvailability(final IProject project) {
    CallHierarchyUriDiscovery uriDiscovery = new CallHierarchyUriDiscovery(
        DestinationUtil.getDestinationId(project));

    return uriDiscovery != null && uriDiscovery.isResourceDiscoverySuccessful()
        && uriDiscovery.getCallHierarchyUri() != null ? Status.OK_STATUS
            : new Status(IStatus.ERROR, Activator.PLUGIN_ID, MessageFormat.format(
                "ABAP Call Hierarchy is not available in the project ''{0}''", project.getName()));
  }

}
