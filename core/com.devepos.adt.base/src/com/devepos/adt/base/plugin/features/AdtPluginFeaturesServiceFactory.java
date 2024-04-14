package com.devepos.adt.base.plugin.features;

import com.devepos.adt.base.internal.plugin.features.AdtPluginFeaturesService;
import com.devepos.adt.base.internal.plugin.features.CachedAdtPluginFeaturesService;

/**
 * Factory for creating instances of {@link IAdtPluginFeaturesService}.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class AdtPluginFeaturesServiceFactory {

  private static IAdtPluginFeaturesService INSTANCE;

  /**
   * Creates instance of service to retrieve ADT plugin features
   *
   * @return service instance
   */
  public static IAdtPluginFeaturesService createService() {
    if (INSTANCE == null) {
      var pluginFeatureCacheDisabledProp = System
          .getProperty("com.devepos.adt.base.pluginFeatureCacheDisabled", Boolean.FALSE.toString());
      if (Boolean.parseBoolean(pluginFeatureCacheDisabledProp)) {
        INSTANCE = new AdtPluginFeaturesService();
      } else {
        INSTANCE = new CachedAdtPluginFeaturesService();
      }
    }
    return INSTANCE;
  }
}
