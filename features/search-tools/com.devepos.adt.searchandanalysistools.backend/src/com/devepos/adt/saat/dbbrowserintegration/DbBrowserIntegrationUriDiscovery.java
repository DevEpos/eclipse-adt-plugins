package com.devepos.adt.saat.dbbrowserintegration;

import com.devepos.adt.base.util.UriDiscoveryBase;;

/**
 * URI Discovery for the DB Browser integration (SAP GUI Transaction)<br>
 *
 * @author stockbal
 */
public class DbBrowserIntegrationUriDiscovery extends UriDiscoveryBase {
  private static final String DISCOVERY_PATH = "/devepos/adt/dbbr/integration/discovery";

  public DbBrowserIntegrationUriDiscovery(final String destination) {
    super(destination, DISCOVERY_PATH, ""); //$NON-NLS-1$
  }

}
