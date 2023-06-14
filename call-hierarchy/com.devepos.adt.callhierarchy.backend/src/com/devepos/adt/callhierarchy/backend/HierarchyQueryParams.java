package com.devepos.adt.callhierarchy.backend;

/**
 * Query parameters for the {@link ICallHierarchyService}
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
public enum HierarchyQueryParams {
  PATH("path"),
  PATH_TYPE("pathType"),
  AUTO_RESOLVE_INTF_METHOD("autoResolveIntfMethod");

  private String literal;

  private HierarchyQueryParams(String literal) {
    this.literal = literal;
  }

  public String getLiteral() {
    return literal;
  }
}
