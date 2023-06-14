package com.devepos.adt.base;

import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * Provider ADT URI templates
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IAdtUriTemplateProvider {
  /**
   * Retrieves URI template for the given discovery term
   *
   * @param discoveryTerm the discovery term for the template
   * @return URI template for the given discovery term
   */
  IAdtUriTemplate getTemplateByDiscoveryTerm(String discoveryTerm);
}
