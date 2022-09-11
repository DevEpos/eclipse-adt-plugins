package com.devepos.adt.callhierarchy.backend;

/**
 * Query parameters for the {@link ICallHierarchyService}
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
public enum HierarchyQueryParams {
  URI("uri"),
  AUTO_RESOLVE_INTF_METHOD("autoResolveIntfMethod");

  private String queryParamName;

  private HierarchyQueryParams(String queryParamName) {
    this.queryParamName = queryParamName;
  }

  public String getQueryParamName() {
    return queryParamName;
  }
}
