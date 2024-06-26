package com.devepos.adt.base.internal.plugin.features;

import java.util.HashMap;
import java.util.Map;

import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;

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
public class CachedAdtPluginFeaturesService extends AdtPluginFeaturesService {

  private final Map<String, Map<String, IAdtPluginFeatureList>> cache = new HashMap<>();

  @Override
  public IAdtPluginFeatureList getFeatures(final String destinationId, final String uri) {
    if (destinationId == null || destinationId.isEmpty()) {
      throw new IllegalArgumentException("Parameter 'destinationId' must not be empty");
    }
    if (uri == null || uri.isEmpty()) {
      throw new IllegalArgumentException("Parameter 'uri' must not be empty");
    }
    return getCachedFeatures(destinationId, uri);
  }

  private IAdtPluginFeatureList getCachedFeatures(final String destinationId, final String uri) {
    if (!cache.containsKey(destinationId)) {
      cache.put(destinationId, new HashMap<>());
    }

    var destinationCache = cache.get(destinationId);

    if (destinationCache.containsKey(uri)) {
      return destinationCache.get(uri);
    }
    var featureList = getFeatureList(destinationId, uri);
    destinationCache.put(uri, featureList);
    return featureList;
  }
}
