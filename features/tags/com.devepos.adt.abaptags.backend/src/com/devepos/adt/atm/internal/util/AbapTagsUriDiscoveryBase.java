package com.devepos.adt.atm.internal.util;

import java.net.URI;

import com.devepos.adt.base.util.UriDiscoveryBase;

/**
 * URI discovery base for ABAP Tags/Tagging API
 *
 * @author stockbal
 */
public class AbapTagsUriDiscoveryBase extends UriDiscoveryBase {

  private static final String DISCOVERY_PATH = "/devepos/adt/atm/discovery";
  private static final String DISCOVERY_TERM_PLUGIN_FEATURES = "pluginFeatures";

  protected AbapTagsUriDiscoveryBase(final String destination, final String discoveryScheme) {
    super(destination, DISCOVERY_PATH, discoveryScheme);
  }

  /**
   * Returns URI for retrieving available ADT backend plugin features
   *
   * @return URI for retrieving available ADT backend plugin features
   */
  public URI getPluginFeaturesUri() {
    return getUriFromCollectionMember(DISCOVERY_TERM_PLUGIN_FEATURES);
  }

}
