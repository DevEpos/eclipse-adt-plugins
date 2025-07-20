package com.devepos.adt.cst.search;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;

public interface ICodeSearchPatternValidator {

  /**
   * Validates the given search patterns
   *
   * @param patterns      the pattern string to be validated
   * @param uriParameters map of URI parameters for the request
   * @return the status of the validation call
   */
  IStatus validatePatternsByProject(String patterns, Map<String, String> uriParameters);

  /**
   * Validates the given search patterns via ADT client API
   *
   * @param patterns      the pattern string to be validated
   * @param uriParameters map of URI parameters for the request
   * @return the status of the validation call
   */
  IStatus validatePatternsForClient(String patterns, Map<String, String> uriParameters);

  /**
   * Validates the given search patterns via ABAP Backend
   *
   * @param patterns      the pattern string to be validated
   * @param uriParameters map of URI parameters for the request
   * @return the status of the validation call
   */
  IStatus validatePatternsForBackend(String patterns, Map<String, String> uriParameters);

}