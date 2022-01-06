package com.devepos.adt.base.plugin.features;

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
      INSTANCE = new CachedAdtPluginFeaturesService();
    }
    return INSTANCE;
  }
}
