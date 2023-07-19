package com.devepos.adt.saat.internal.activation;

import java.net.URI;

import com.devepos.adt.saat.internal.SearchToolsUriDiscovery;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

public class CdsActivationUriDiscovery extends SearchToolsUriDiscovery {
  private static final String POST_ACTIVATION_URI_PART = "/cds/postActivation"; //$NON-NLS-1$
  private static final String DISCOVERY_RELATION_CDS_POST_ACTIVATION = RELATIONS_SCHEME_BASE
      + POST_ACTIVATION_URI_PART;
  private static final String DISCOVERY_TERM_CDS_POST_ACTIVATION = "cdsPostActivation"; //$NON-NLS-1$

  public CdsActivationUriDiscovery(final String destination) {
    super(destination, SCHEME_URL_BASE + POST_ACTIVATION_URI_PART);
  }

  /**
   * @return Retrieves Resource URI for the CDS Post Activation Resource
   */
  public URI getCdsPostActivationUri() {
    return getUriFromCollectionMember(DISCOVERY_TERM_CDS_POST_ACTIVATION);
  }

  /**
   * Returns <code>true</code> if the CDS Post Activation handler is available in the
   * current destination
   *
   * @return <code>true</code> if the CDS Post Activation handler is available in the
   *         current destination
   */
  public boolean isCdsPostActivaionAvailable() {
    return getCdsPostActivationTemplate() != null;
  }

  /**
   * @return ADT URI template for the CDS Post Activation Handler
   */
  public IAdtUriTemplate getCdsPostActivationTemplate() {
    return getTemplate(DISCOVERY_TERM_CDS_POST_ACTIVATION, DISCOVERY_RELATION_CDS_POST_ACTIVATION);
  }

  /*
   * Creates a valid REST resource URI to call the Post Activation Handler for the given CDS View
   */
  public URI createCdsPostActivationUri(final String ddlName) {
    if (ddlName == null || ddlName.isEmpty()) {
      throw new IllegalArgumentException("Parameter 'ddlname' must have a value");
    }
    final IAdtUriTemplate template = getCdsPostActivationTemplate();
    URI uri = null;
    if (template != null) {
      if (template.containsVariable("ddlName")) { //$NON-NLS-1$
        template.set("ddlName", ddlName); //$NON-NLS-1$
      }
      uri = URI.create(template.expand());
    }
    return uri;
  }
}
