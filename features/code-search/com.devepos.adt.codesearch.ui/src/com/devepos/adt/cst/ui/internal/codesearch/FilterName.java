package com.devepos.adt.cst.ui.internal.codesearch;

import java.util.HashMap;
import java.util.Map;

import com.devepos.adt.base.ui.search.contentassist.ApplicationComponentSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.PackageSearchFilter;

/**
 * Filters in the context of the ABAP code search The <strong>external
 * name</strong> of a filter will be used in the backend search API
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public enum FilterName {
  APPLICATION_COMPONENT(ApplicationComponentSearchFilter.FILTER_NAME, "applComp"),
  CREATED_DATE("created", "createdDate"),
  OWNER("owner", "owner"),
  OBJECT_NAME(null, "objectName"),
  OBJECT_TYPE("type", "objectType"),
  PACKAGE(PackageSearchFilter.FILTER_NAME, "packageName"),
  TRANSPORT_REQUEST("trreq", "transportRequest"),
  TR_OWNER("owner", "owner"),
  TR_CHANGED_DATE("changed", "changed"),
  TR_TYPE("type", "type"),
  TR_STATUS("status", "status"),
  SEARCH_PATTERN(null, "searchPattern");

  private final String contentAssistName;
  private final String uriParamName;
  private static Map<String, String> CONTENT_ASSIST_TO_URI_PARAM_MAP;

  FilterName(final String contentAssistName, final String uriParamName) {
    this.contentAssistName = contentAssistName;
    this.uriParamName = uriParamName;
  }

  /**
   * Retrieves the name for content assist features
   */
  public String getContentAssistName() {
    return contentAssistName;
  }

  /**
   * Retrieves the external name of the filter
   */
  public String getUriParamName() {
    return uriParamName;
  }

  /**
   * Returns map which contains a mapping between the filter names entered in a UI
   * friendly name and the filter name to be used in an API call to the backend
   *
   * @return map of UI filter name to API internal name
   */
  public static Map<String, String> getContentAssistToUriParamNameMap() {
    if (CONTENT_ASSIST_TO_URI_PARAM_MAP == null) {
      CONTENT_ASSIST_TO_URI_PARAM_MAP = new HashMap<>();
      for (FilterName filter : FilterName.values()) {
        if (filter.contentAssistName != null
            && !filter.contentAssistName.equals(filter.uriParamName)) {
          CONTENT_ASSIST_TO_URI_PARAM_MAP.put(filter.contentAssistName, filter.uriParamName);
        }
      }
    }
    return CONTENT_ASSIST_TO_URI_PARAM_MAP;
  }

}
