package com.devepos.adt.base.plugin.features;

import com.devepos.adt.base.model.adtbase.IAdtPluginFeature;

/**
 * Features in ADT Backend plugin
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IAdtPluginFeatures {

  /**
   * Checks if a feature with a given name is enabled or not
   *
   * @param name the name of a feature
   * @return {@code true} if the feature is enabled
   */
  boolean isFeatureEnabled(String name);

  /**
   * Checks if all contained features are enabled or not
   *
   * @return {@code true} if all contained features are enabled
   */
  boolean areAllFeaturesEnabled();

  /**
   * Returns the feature with the given name or {@code null} if is not found
   *
   * @param name the name of a feature
   * @return the feature with the given name or {@code null} if is not found
   */
  IAdtPluginFeature getFeature(String name);

  /**
   * Retrieves an array of all contained features
   *
   * @return an array of all contained features
   */
  IAdtPluginFeature[] getAll();
}
