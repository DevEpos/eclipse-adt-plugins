package com.devepos.adt.saat.ui.internal.help;

/**
 * Holds Help Contexts
 *
 * @author stockbal
 */
public enum HelpContexts {
  OBJECT_SEARCH("object_search"),
  OBJECT_SEARCH_DIALOG("object_search_dialog"),
  OBJECT_SEARCH_RESULT("object_search_result"),
  CDS_ANALYZER("cds_analyzer");

  private String helpContextId;

  HelpContexts(final String contextId) {
    helpContextId = contextId;
  }

  public String getHelpContextId() {
    return helpContextId;
  }
}
