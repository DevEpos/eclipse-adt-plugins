package com.devepos.adt.cst.search;

import org.eclipse.core.runtime.IStatus;

import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;

/**
 * Utility to check available features of Code Search
 */
public interface ICodeSearchFeatureUtil {

  int SEARCH_TARGET_CLIENT = 1;
  int SEARCH_TARGET_BACKEND = 2;

  /**
   * Retrieves the list of available features to configure the code search
   *
   * @return list of available features in the context of the code search
   */
  IAdtPluginFeatures getSearchSettingsFeatures();

  /**
   * Tests the availability of the ABAP Code search feature in ABAP backend
   *
   * @return the validation status
   */
  IStatus testBackendBasedSearchAvailability();

  /**
   * Tests the availibility of the ABAP Code search feature via ADT client
   *
   * @return the validation status
   */
  IStatus testClientBasedSearchAvailability();

  /**
   * Tests the availibility of the ABAP Code search feature depending on the project
   *
   * @param preferClient if {@code true} client side search will be used prioritized
   * @return the validation status
   */
  IStatus testSearchAvailabilityByProject(boolean preferClient);

  /**
   * Tests availability of named item by the given term
   *
   * @param namedItemTerm identifies named item resource
   * @return the validation status of the test
   */

  IStatus testBackendNamedItemAvailability(final String namedItemTerm);

  /**
   * Tests availability of named item by the given term via ADT client
   *
   * @param namedItemTerm identifies named item resource
   * @return the validation status of the test
   */
  IStatus testClientNamedItemAvailability(final String namedItemTerm);

  /**
   * Tests availability of named item by the given term by project
   *
   * @param namedItemTerm identifies named item resource
   * @return the validation status of the test
   */
  IStatus testNamedItemAvailabilityByProject(final String namedItemTerm);

  /**
   * Returns {@code true} if the parameter is supported in the Code Search API
   *
   * @param queryParameter name of a query parameter
   * @return
   */
  boolean isCodeSearchParameterSupported(String queryParameter);

}
