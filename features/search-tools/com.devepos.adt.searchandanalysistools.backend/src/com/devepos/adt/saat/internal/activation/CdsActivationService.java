package com.devepos.adt.saat.internal.activation;

import java.net.URI;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.content.PlainTextContentHandler;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.saat.activation.ICdsActivationService;
import com.devepos.adt.saat.internal.Activator;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

public class CdsActivationService implements ICdsActivationService {

  @Override
  public IStatus testCdsPostActivationAvailable(final IProject project) {
    var discovery = new CdsActivationUriDiscovery(DestinationUtil.getDestinationId(project));

    if (!discovery.isResourceDiscoverySuccessful() || discovery.getCdsPostActivationUri() == null) {
      return new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(
          "CDS Post Activation Services are not available in ''{0}''", project.getName()));
    }
    return Status.OK_STATUS;
  }

  @Override
  public void postActivateCdsViews(final String destinationId, final List<String> ddlNames) {
    if (ddlNames == null || ddlNames.isEmpty()) {
      throw new IllegalArgumentException("ddlNames must not be null or empty");
    }
    var discovery = new CdsActivationUriDiscovery(destinationId);
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    String ddlNamesBody = null;
    URI resourceUri = null;
    if (ddlNames.size() == 1) {
      resourceUri = discovery.createCdsPostActivationUri(ddlNames.get(0));
    } else if (ddlNames.size() > 1) {
      ddlNamesBody = String.join(";", ddlNames);
      resourceUri = discovery.getCdsPostActivationUri();
    }

    final var resource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(resourceUri, session);
    if (ddlNames != null) {
      resource.addContentHandler(new PlainTextContentHandler());
    }
    resource.post(new NullProgressMonitor(), String.class, ddlNamesBody);
  }

}
