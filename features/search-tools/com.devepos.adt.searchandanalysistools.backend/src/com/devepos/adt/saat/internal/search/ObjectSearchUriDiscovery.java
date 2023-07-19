package com.devepos.adt.saat.internal.search;

import java.net.URI;

import com.devepos.adt.saat.internal.SearchToolsUriDiscovery;

/**
 * URI discovery for Object Search services
 *
 * @author stockbal
 */
public class ObjectSearchUriDiscovery extends SearchToolsUriDiscovery {
  /**
   * Creates new URI discovery for the Object Search services
   *
   * @param destination
   */
  public ObjectSearchUriDiscovery(final String destination) {
    super(destination, SCHEME_URL_BASE_V2 + "/objectsearch");
  }

  /**
   * Retrieves Resource URI for the Object search
   */
  public URI getObjectSearchUri() {
    return getUriFromCollectionMember("objectSearch");
  }

  /**
   * Retrieves Resource URI to retrieve the object search configuration
   */
  public URI getObjectSearchConfigUri() {
    return getUriFromCollectionMember("objectSearchConfig");
  }

}
