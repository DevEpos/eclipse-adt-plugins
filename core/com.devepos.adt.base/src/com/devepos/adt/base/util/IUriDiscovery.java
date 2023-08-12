package com.devepos.adt.base.util;

import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * Represents an Object for discovering URI Resources
 *
 * @author stockbal
 */
public interface IUriDiscovery {

  /**
   * Retrieves the named item URI template for the given discovery term
   *
   * @param discoveryTerm term to access a concrete named item URI
   */
  IAdtUriTemplate getNamedItemTemplate(final String discoveryTerm);

  /**
   * @return <code>true</code> if the resource discovery has been successful
   */
  boolean isResourceDiscoverySuccessful();

}