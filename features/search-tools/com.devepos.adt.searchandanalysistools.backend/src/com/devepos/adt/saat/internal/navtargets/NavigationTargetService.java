package com.devepos.adt.saat.internal.navtargets;

import java.net.URI;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.ObjectType;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.util.AdtUtil;
import com.devepos.adt.saat.internal.Activator;
import com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets;
import com.devepos.adt.saat.navtargets.INavigationTargetService;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

/**
 * Service which handles the retrieval of available navigation targets for ADT
 * objects
 *
 * @author stockbal
 */
public class NavigationTargetService implements INavigationTargetService {

  @Override
  public ICdsQueryNavTargets getTargets(final String destinationId, final String objectName,
      final ObjectType objectType) {
    if (objectName == null || objectType == null || objectType.getId() == null) {
      return null;
    }

    final var uriDiscovery = new NavigationTargetsUriDiscovery(destinationId);

    final URI resourceUri = uriDiscovery.createNavTargetsResourceUri(objectName, objectType);
    if (resourceUri == null) {
      return null;
    }

    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);
    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(resourceUri, session);
    restResource.addContentHandler(new NavigationTargetsContentHandler());

    try {
      return restResource.get(null, AdtUtil.getHeaders(), ICdsQueryNavTargets.class);
    } catch (final ResourceException exc) {
      exc.printStackTrace();
    }
    return null;
  }

  @Override
  public IStatus testNavigationTargetsAvailable(final IProject project) {
    var discovery = new NavigationTargetsUriDiscovery(DestinationUtil.getDestinationId(project));
    if (!discovery.isResourceDiscoverySuccessful() || discovery.getNavTargetsUri() == null) {
      return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
          NLS.bind("Navigation Targets are not available in ''{0}''", project.getName()));
    }
    return Status.OK_STATUS;
  }

}
