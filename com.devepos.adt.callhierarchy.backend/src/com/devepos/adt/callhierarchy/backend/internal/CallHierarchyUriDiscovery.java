package com.devepos.adt.callhierarchy.backend.internal;

import java.net.URI;

import com.devepos.adt.base.util.UriDiscoveryBase;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * URI discovery for ABAP Call Hierarchy
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CallHierarchyUriDiscovery extends UriDiscoveryBase {
  private static final String SCHEME_SUFFIX = "/callhierarchy";
  private static final String DISCOVERY_RELATION_CALL_HIERARCHY = "http://www.devepos.com/adt/relations/aht" //$NON-NLS-1$
      + SCHEME_SUFFIX;
  private static final String DISCOVERY_SCHEME = "http://www.devepos.com/adt/aht" + SCHEME_SUFFIX; //$NON-NLS-1$
  private static final String DISCOVERY_PATH = "/devepos/adt/aht/discovery"; //$NON-NLS-1$
  private static final String TERM_CALL_HIERARCHY = "callHierarchy"; //$NON-NLS-1$

  public CallHierarchyUriDiscovery(final String destinationId) {
    super(destinationId, DISCOVERY_PATH, DISCOVERY_SCHEME);
  }

  /**
   * Returns the URI for the call hierarchy
   *
   * @return URI
   */
  public URI getCallHierarchyUri() {
    return getUriFromCollectionMember(TERM_CALL_HIERARCHY);
  }

  /**
   * Returns the URI template for the call hierarchy
   *
   * @return URI template
   */
  public IAdtUriTemplate getCallHierarchyUriTemplate() {
    return getTemplate(TERM_CALL_HIERARCHY, DISCOVERY_RELATION_CALL_HIERARCHY);
  }

}
