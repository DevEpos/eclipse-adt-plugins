package com.devepos.adt.base.internal.plugin.features;

import java.net.URI;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;
import com.devepos.adt.base.plugin.features.IAdtPluginFeaturesService;
import com.sap.adt.communication.exceptions.CommunicationException;
import com.sap.adt.communication.exceptions.SystemFailureException;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

/**
 * Implementation for plugin feature service without any caching
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class AdtPluginFeaturesService implements IAdtPluginFeaturesService {

  @Override
  public IAdtPluginFeatureList getFeatures(String destinationId, String uri) {
    if (destinationId == null || destinationId.isEmpty()) {
      throw new IllegalArgumentException("Parameter 'destinationId' must not be empty");
    }
    if (uri == null || uri.isEmpty()) {
      throw new IllegalArgumentException("Parameter 'uri' must not be empty");
    }

    return getFeatureList(destinationId, uri);
  }

  protected IAdtPluginFeatureList getFeatureList(String destinationId, String uri) {
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(URI.create(uri), session);
    restResource.addContentHandler(new AdtPluginFeaturesContentHandler());
    try {
      return restResource.get(new NullProgressMonitor(), IAdtPluginFeatureList.class);
    } catch (final ResourceException | CommunicationException exc) {
      exc.printStackTrace();
    }
    return null;
  }

}
