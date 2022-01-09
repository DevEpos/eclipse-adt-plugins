package com.devepos.adt.base.plugin.features;

import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;

/**
 * Service for accessing the features for plugins, i.e. services that are
 * implemented in the ABAP backend.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IAdtPluginFeaturesService {

  /**
   * Retrieves available features of ADT plugins
   *
   * @param destinationId destination id of ABAP project
   * @param uri           URI which points to the resource for accessing plugin
   *                      features
   * @return a list of found features
   */
  IAdtPluginFeatureList getFeatures(String destinationId, String uri);
}
