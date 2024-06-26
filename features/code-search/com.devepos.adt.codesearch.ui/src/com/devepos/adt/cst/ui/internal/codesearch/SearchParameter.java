package com.devepos.adt.cst.ui.internal.codesearch;

public enum SearchParameter {
  FUGR_INCLUDES("fugrIncludes"),
  CLASS_INCLUDES("classIncludes"),
  EXPAND_PROG_INCLUDES("expandProgIncl"),
  EXPAND_TABLE_INCLUDES("expandTableIncl"),
  MAX_OBJECTS("maxObjects"),
  IGNORE_CASE("ignoreCase"),
  IGNORE_COMMENT_LINES("ignoreCommentLines"),
  USE_REGEX("useRegex"),
  MATCH_ALL("matchAll"),
  MULTI_LINE("multiLine"),
  SINGLE_PATTERN("singlePattern"),
  SCOPE_ID("scopeId"),
  SCOPE_OFFSET("scopeOffset"),
  SEQUENTIAL_MATCHING("seqMatching");

  private final String uriParamName;

  SearchParameter(final String uriParamName) {
    this.uriParamName = uriParamName;
  }

  /**
   * Retrieves the URI name of the parameter
   */
  public String getUriName() {
    return uriParamName;
  }
}
