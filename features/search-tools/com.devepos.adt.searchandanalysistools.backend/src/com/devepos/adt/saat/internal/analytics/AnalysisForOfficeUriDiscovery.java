package com.devepos.adt.saat.internal.analytics;

import java.net.URI;

import com.devepos.adt.saat.internal.SearchToolsUriDiscovery;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * URI discovery for analysis for office
 *
 * @author stockbal
 */
public class AnalysisForOfficeUriDiscovery extends SearchToolsUriDiscovery {
  private static final String DISCOVERY_TERM = "sapaox"; //$NON-NLS-1$
  private static final String DISCOVERY_RELATION_AOX_LAUNCHER = RELATIONS_SCHEME_BASE + "/sapaox"; //$NON-NLS-1$

  public AnalysisForOfficeUriDiscovery(final String destination) {
    super(destination, SCHEME_URL_BASE + "/sapaox");
  }

  /**
   * Creates REST resource URI for retrieving the analysis for office launcher for
   * the given CDS query
   *
   * @param cdsViewName name of a CDS view
   * @return the created REST resource URI
   */
  public URI createAnalysisForOfficeLauncherURI(final String cdsViewName) {
    final IAdtUriTemplate template = getLauncherTemplate();
    URI uri = null;
    if (template != null) {
      if (template.containsVariable("objectName")) { //$NON-NLS-1$
        template.set("objectName", cdsViewName); //$NON-NLS-1$
      }
      uri = URI.create(template.expand());
    }
    return uri;
  }

  /**
   * @return ADT URI template for the analysis for office launcher
   */
  public IAdtUriTemplate getLauncherTemplate() {
    return getTemplate(DISCOVERY_TERM, DISCOVERY_RELATION_AOX_LAUNCHER);
  }

  /**
   * @return Retrieves Resource URI for the Analysis for Office launcher
   */
  public URI getLauncherUri() {
    return getUriFromCollectionMember(DISCOVERY_TERM);
  }

}
