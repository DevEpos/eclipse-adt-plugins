package com.devepos.adt.base.internal.plugin.features;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;
import com.devepos.adt.base.plugin.features.IAdtPluginFeaturesService;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IRestResource;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.communication.session.ISystemSession;

/**
 * Implementation for plugin feature service. <br>
 * This implementation only retrieves the feature once from a given destination
 * (i.e. ABAP project).<br>
 * That means when the features of a plugin change are not detected and
 * therefore a restart of the eclipse platform is required
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CachedAdtPluginFeaturesService implements IAdtPluginFeaturesService {

  private Map<String, IAdtPluginFeatureList> cache = new HashMap<>();

  @Override
  public IAdtPluginFeatureList getFeatures(final String destinationId, final String uri) {
    if (destinationId == null || destinationId.isEmpty()) {
      throw new IllegalArgumentException("Parameter 'destinationId' must not be empty");
    }
    if (uri == null || uri.isEmpty()) {
      throw new IllegalArgumentException("Parameter 'uri' must not be empty");
    }
    if (cache.containsKey(uri)) {
      return cache.get(uri);
    }
    IAdtPluginFeatureList featureList = null;
    final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(URI.create(uri), session);
    restResource.addContentHandler(new AdtPluginFeaturesContentHandler());
    try {
      featureList = restResource.get(new NullProgressMonitor(), IAdtPluginFeatureList.class);
    } catch (final ResourceException exc) {
      exc.printStackTrace();
    }
    cache.put(uri, featureList);
    return featureList;
  }

}
