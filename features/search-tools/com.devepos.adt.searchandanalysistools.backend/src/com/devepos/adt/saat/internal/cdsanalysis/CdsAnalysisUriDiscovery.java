package com.devepos.adt.saat.internal.cdsanalysis;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.devepos.adt.saat.cdsanalysis.CdsAnalysisFeature;
import com.devepos.adt.saat.internal.SearchToolsUriDiscovery;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * URI discovery for CDS Analysis
 *
 * @author stockbal
 */
class CdsAnalysisUriDiscovery extends SearchToolsUriDiscovery {
  static final String DISCOVERY_TEMPLATE_WHERE_USED_IN_FROM = "/whereUsedIn/from"; //$NON-NLS-1$

  private static final String DISCOVERY_SCHEME = SCHEME_URL_BASE_V2 + "/cds/analysis"; //$NON-NLS-1$
  private static final String DISCOVERY_RELATION_CDS_ANALYSIS = RELATIONS_SCHEME_BASE_V2
      + "/cds/analysis"; //$NON-NLS-1$
  private static final String DISCOVERY_TEMPLATE_TOP_DOWN = "/topDown"; //$NON-NLS-1$
  private static final String DISCOVERY_TEMPLATE_WHERE_USED_IN_ASSOC = "/whereUsedIn/associations"; //$NON-NLS-1$
  private static final String DISCOVERY_TEMPLATE_USED_ENTITES = "/usedEntities"; //$NON-NLS-1$
  private static final String DISCOVERY_TEMPLATE_COL_HIERARCHY = "/field/hierarchy"; //$NON-NLS-1$
  private static final String DISCOVERY_TEMPLATE_COL_WHERE_USED = "/field/whereUsed"; //$NON-NLS-1$

  private static final String FIELD_PARAMETER = "field"; //$NON-NLS-1$
  private static final String NAME_PARAMETER = "name"; //$NON-NLS-1$
  private static final String SEARCH_CALC_FIELDS_PARAMETER = "searchCalcFields"; //$NON-NLS-1$
  private static final String SEARCH_DB_VIEWS_PARAMETER = "searchDbViewUsages"; //$NON-NLS-1$

  private static final String DISCOVERY_TERM_CDS_ANALYSIS = "cdsanalysis"; //$NON-NLS-1$

  public CdsAnalysisUriDiscovery(final String destination) {
    super(destination, DISCOVERY_SCHEME);
  }

  /**
   * Creates a valid REST resource URI to perform a top-down analysis for the
   * given CDS View field
   *
   * @param cdsViewName name of a CDS view
   * @param field       name of a field in the given CDS view
   * @return REST resource URI
   */
  public URI createFieldTopDownCdsAnalysisResourceUri(final String cdsViewName,
      final String field) {
    URI uri = null;
    final IAdtUriTemplate template = createFieldAnalysisResourceUriTemplate(cdsViewName, field,
        DISCOVERY_TEMPLATE_COL_HIERARCHY);
    if (template != null) {
      uri = URI.create(template.expand());
    }
    return uri;
  }

  /**
   * Creates a valid REST resource URI to perform a Where-Used Analysis for the
   * given Database entity field
   *
   * @param objectName       name of a Database entity
   * @param field            name of a field in the given database entity
   * @param searchCalcFields if <code>true</code> calculated fields should be
   *                         considered during analysis
   * @param searchDbViews    if <code>true</code> database views should be
   *                         considered during analysis
   * @return REST resource URI
   */
  public URI createFieldWhereUsedAnalysisResourceUri(final String objectName, final String field,
      final boolean searchCalcFields, final boolean searchDbViews) {
    URI uri = null;
    final IAdtUriTemplate template = createFieldAnalysisResourceUriTemplate(objectName, field,
        DISCOVERY_TEMPLATE_COL_WHERE_USED);
    if (template != null) {
      if (template.containsVariable(SEARCH_CALC_FIELDS_PARAMETER) && searchCalcFields) {
        template.set(SEARCH_CALC_FIELDS_PARAMETER, "X");
      }
      if (template.containsVariable(SEARCH_DB_VIEWS_PARAMETER) && searchDbViews) {
        template.set(SEARCH_DB_VIEWS_PARAMETER, "X");
      }
      uri = URI.create(template.expand());
    }
    return uri;
  }

  /**
   * Creates Resource URI for a Top-Down analysis of the given CDS View
   *
   * @param cdsViewName  name of a CDS view
   * @param parameterMap map of parameters for URI template
   * @return REST resource URI
   */
  public URI createTopDownAnalysisResourceUri(final String cdsViewName,
      final Map<String, Object> parameterMap) {
    return createCdsAnalysisResourceUri(DISCOVERY_TEMPLATE_TOP_DOWN, cdsViewName, parameterMap);
  }

  /**
   * Creates Resource URI for Used Entities Analysis for the given CDS View
   *
   * @param cdsViewName  name of a CDS view
   * @param parameterMap map of parameters for URI template
   * @return REST resource URI
   */
  public URI createUsedEntitiesAnalysisResourceUri(final String cdsViewName,
      Map<String, Object> parameterMap) {
    if (parameterMap == null) {
      parameterMap = new HashMap<>();
    }
    parameterMap.put("usageAnalysis", "X"); //$NON-NLS-1$ //$NON-NLS-2$
    return createCdsAnalysisResourceUri(DISCOVERY_TEMPLATE_USED_ENTITES, cdsViewName, parameterMap);
  }

  /**
   * @return ADT URI template for the CDS Analysis Resource
   */
  public IAdtUriTemplate getCdsAnalysisTemplate(final String templateUriPart) {
    return getTemplate(DISCOVERY_TERM_CDS_ANALYSIS, DISCOVERY_RELATION_CDS_ANALYSIS
        + templateUriPart);
  }

  /**
   * @return Retrieves Resource URI for the CDS Analysis Resource
   */
  public URI getCdsAnalysisUri() {
    return getUriFromCollectionMember(DISCOVERY_TERM_CDS_ANALYSIS);
  }

  public URI createWhereUsedInCdsAnalysisResourceUri(final Map<String, Object> params) {
    /*
     * We can use any term because the underlying URI will always be same. They just serve as a
     * marker to check if a certain mode is available or not
     */
    final var template = getCdsAnalysisTemplate(DISCOVERY_TEMPLATE_WHERE_USED_IN_FROM);
    URI uri = null;
    if (template != null) {
      fillTemplateWithParams(template, params);
      uri = URI.create(template.expand());
    }
    return uri;
  }

  /**
   * Returns <code>true</code> if the cds feature is available in this discovery provider.
   *
   * @param feature identifies CDS feature
   *
   * @return <code>true</code> if the feature is available
   */
  public boolean isCdsFeatureAvailable(final CdsAnalysisFeature feature) {
    switch (feature) {
    case GENERAL:
      return getCollectionMember(DISCOVERY_TERM_CDS_ANALYSIS) != null;
    case FIELD_ANALYSIS_TOP_DOWN:
      return getCdsAnalysisTemplate(DISCOVERY_TEMPLATE_COL_HIERARCHY) != null;
    case FIELD_ANALYSIS_WHERE_USED:
      return getCdsAnalysisTemplate(DISCOVERY_TEMPLATE_COL_WHERE_USED) != null;
    case TOP_DOWN:
      return getCdsAnalysisTemplate(DISCOVERY_TEMPLATE_TOP_DOWN) != null;
    case WHERE_USED_IN_ASSOC:
      return getCdsAnalysisTemplate(DISCOVERY_TEMPLATE_WHERE_USED_IN_ASSOC) != null;
    case WHERE_USED_IN_FROM:
      return getCdsAnalysisTemplate(DISCOVERY_TEMPLATE_WHERE_USED_IN_FROM) != null;
    case USED_ENTITIES:
      return getCdsAnalysisTemplate(DISCOVERY_TEMPLATE_USED_ENTITES) != null;
    default:
      return false;
    }
  }

  /*
   * Creates a valid REST resource URI to perform a CDS analysis for the given CDS
   * View
   */
  private URI createCdsAnalysisResourceUri(final String templateUriPart, final String cdsViewName,
      final Map<String, Object> parameterMap) {
    final IAdtUriTemplate template = getCdsAnalysisTemplate(templateUriPart);
    URI uri = null;
    if (template != null) {
      if (template.containsVariable("cdsViewName")) { //$NON-NLS-1$
        template.set("cdsViewName", cdsViewName); //$NON-NLS-1$
      }
      fillTemplateWithParams(template, parameterMap);
      uri = URI.create(template.expand());
    }
    return uri;
  }

  private IAdtUriTemplate createFieldAnalysisResourceUriTemplate(final String name,
      final String field, final String templateUriPart) {
    final IAdtUriTemplate template = getCdsAnalysisTemplate(templateUriPart);
    if (template != null) {
      if (template.containsVariable(NAME_PARAMETER)) {
        template.set(NAME_PARAMETER, name);
      }
      if (template.containsVariable(FIELD_PARAMETER)) {
        template.set(FIELD_PARAMETER, field);
      }
    }
    return template;
  }
}
