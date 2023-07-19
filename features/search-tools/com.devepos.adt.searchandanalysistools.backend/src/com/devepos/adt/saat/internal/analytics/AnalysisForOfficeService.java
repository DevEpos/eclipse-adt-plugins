package com.devepos.adt.saat.internal.analytics;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.base.content.PlainTextContentHandler;
import com.devepos.adt.saat.analytics.IAnalysisForOfficeService;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

public class AnalysisForOfficeService implements IAnalysisForOfficeService {

  @Override
  public String getSapAoxLauncherContent(final String destinationId, final IProgressMonitor monitor,
      final String queryCdsView) {
    final var discovery = new AnalysisForOfficeUriDiscovery(destinationId);
    final var launcherResourceURI = discovery.createAnalysisForOfficeLauncherURI(queryCdsView
        .toUpperCase());
    final var launcherResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(launcherResourceURI, AdtSystemSessionFactory
            .createSystemSessionFactory()
            .createStatelessSession(destinationId));
    launcherResource.addContentHandler(new PlainTextContentHandler());
    return launcherResource.get(monitor, String.class);
  }
}
