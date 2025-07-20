package com.devepos.adt.cst.internal.search.backend;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.cst.internal.CodeSearchPlugin;
import com.devepos.adt.cst.model.codesearch.ICodeSearchSettings;
import com.devepos.adt.cst.search.ICodeSearchSettingsService;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.communication.session.ISystemSession;

public class CodeSearchSettingsService implements ICodeSearchSettingsService {

  private final String destinationId;

  public CodeSearchSettingsService(final IProject project) {
    destinationId = DestinationUtil.getDestinationId(project);
  }

  @Override
  public ICodeSearchSettings getSettings() {
    var uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    var settingsUri = uriDiscovery.getCodeSearchSettingsUri();
    if (settingsUri == null) {
      return null;
    }
    final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(settingsUri, session);
    restResource.addContentHandler(new CodeSearchSettingsContentHandler());
    try {
      return restResource.get(new NullProgressMonitor(), ICodeSearchSettings.class);
    } catch (final ResourceException exc) {
      exc.printStackTrace();
    }
    return null;
  }

  @Override
  public IStatus updateSettings(final ICodeSearchSettings settings) {
    if (settings == null) {
      throw new IllegalArgumentException("Parameter 'settings' must not be null");
    }

    var uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    var settingsUri = uriDiscovery.getCodeSearchSettingsUri();
    if (settingsUri == null) {
      return null;
    }
    final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(settingsUri, session);
    restResource.addContentHandler(new CodeSearchSettingsContentHandler());
    try {
      restResource.put(new NullProgressMonitor(), ICodeSearchSettings.class, settings);
      return Status.OK_STATUS;
    } catch (final ResourceException exc) {
      exc.printStackTrace();
      return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID, exc.getMessage());
    }
  }
}
