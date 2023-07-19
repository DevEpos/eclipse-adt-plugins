package com.devepos.adt.saat.internal;

import com.devepos.adt.base.util.UriDiscoveryBase;

public class SearchToolsUriDiscovery extends UriDiscoveryBase {
  protected static final String SCHEME_URL_BASE = "http://www.devepos.com/adt/saat"; //$NON-NLS-1$ ;
  protected static final String SCHEME_URL_BASE_V2 = SCHEME_URL_BASE + "/v2"; //$NON-NLS-1$ ;

  protected static final String RELATIONS_SCHEME_BASE = "http://www.devepos.com/adt/relations/saat"; //$NON-NLS-1$
  protected static final String RELATIONS_SCHEME_BASE_V2 = RELATIONS_SCHEME_BASE + "/v2"; //$NON-NLS-1$

  protected SearchToolsUriDiscovery(final String destination, final String scheme) {
    super(destination, "/devepos/adt/saat/discovery", scheme);
  }
}
