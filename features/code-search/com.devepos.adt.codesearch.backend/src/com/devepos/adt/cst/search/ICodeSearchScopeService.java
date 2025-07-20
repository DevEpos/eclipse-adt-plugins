package com.devepos.adt.cst.search;

import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;

public interface ICodeSearchScopeService {

  /**
   * Retrieves the list of available features via ADT client for the code search scope
   *
   * @param destinationId Id of the destination of an ABAP project
   * @return list of available features in the context of the code search scope
   */
  IAdtPluginFeatures getClientFeatures();

  /**
   * Retrieves the list of available features in the ABAP backend for the code search scope
   *
   * @param destinationId Id of the destination of an ABAP project
   * @return list of available features in the context of the code search scope
   */
  IAdtPluginFeatures getBackendFeatures();

  /**
   * Retrieves the list of available features for the code search scope for the current project
   *
   * @param destinationId Id of the destination of an ABAP project
   * @return list of available features in the context of the code search scope
   */
  IAdtPluginFeatures getFeaturesByProject();
}
