package com.devepos.adt.cst.search;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScope;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScopeParameters;
import com.devepos.adt.cst.model.codesearch.ICodeSearchSettings;

/**
 * Service
 *
 * @author stockbal
 */
public interface ICodeSearchProjectService {

  /**
   * Creates the passed search scope in the ABAP project of the given destination id
   *
   * @param scopeParameters the parameters of the search scope
   * @param monitor         progress monitor of the background job
   * @return the persisted search scope
   */
  ICodeSearchScope createScope(ICodeSearchScopeParameters scopeParameters,
      IProgressMonitor monitor);

  /**
   * Retrieves the list of available features for the code search scope
   *
   * @param destinationId Id of the destination of an ABAP project
   * @return list of available features in the context of the code search scope
   */
  IAdtPluginFeatures getSearchScopeFeatures();

  /**
   * Retrieves the list of available features to configure the code search
   *
   * @return list of available features in the context of the code search
   */
  IAdtPluginFeatures getSearchSettingsFeatures();

  /**
   * Retrieves the project specific settings for the ABAP code search
   *
   * @return the found settings or {@code null}
   */
  ICodeSearchSettings getSettings();

  /**
   * Returns {@code true} if the parameter is supported in the Code Search API
   *
   * @param queryParameter name of a query parameter
   * @return
   */
  boolean isCodeSearchParameterSupported(String queryParameter);

  /**
   * Find matches in ABAP Code
   *
   * @param uriParameters map of URI parameters
   * @param monitor       progress monitor
   * @return search results
   */
  ICodeSearchResult search(Map<String, Object> uriParameters, IProgressMonitor monitor);

  /**
   * Tests the availablity of the ABAP Code search feature in the given project
   *
   * @return the validation status
   */
  IStatus testCodeSearchFeatureAvailability();

  /**
   * Tests the availability of transport request/task scope filter in the given project
   *
   * @param namedItemTerm identifies named item resource
   * @return the validation status of the test
   */
  IStatus testCodeSearchNamedItemAvailability(final String namedItemTerm);

  /**
   * Updates the given code search settings in the ABAP backend
   *
   * @param settings code search settings object
   * @return the status of the update operation
   */
  IStatus updateSettings(ICodeSearchSettings settings);

  /**
   * Validates the given search patterns
   *
   * @param patterns      the pattern string to be validated
   * @param uriParameters map of URI parameters for the request
   * @return the status of the validation call
   */
  IStatus validatePatterns(String patterns, Map<String, String> uriParameters);
}
