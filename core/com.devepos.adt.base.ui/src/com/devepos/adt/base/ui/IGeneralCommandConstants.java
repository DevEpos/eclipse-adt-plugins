package com.devepos.adt.base.ui;

/**
 * Constants for available commands in this plugin
 *
 * @author stockbal
 *
 */
public interface IGeneralCommandConstants {
  /**
   * Command id to open the query behind the current search result in the search
   * dialog
   */
  String OPEN_QUERY_IN_SEARCH_DIALOG = "com.devepos.adt.base.ui.command.openQueryInSearchDialog";
  /**
   * Command id for triggering the ADT Where-Used-List
   */
  String WHERE_USED_IN = "com.sap.adt.ris.whereused.ui.callWhereUsed";
  /**
   * Command id for toggling the viewer text filter
   */
  String TOGGLE_VIEWER_TEXT_FILTER = "com.devepos.adt.base.ui.command.toggleTextFilter";
  /**
   * Command id for showing element information for a selected ADT object reference
   */
  String SHOW_ADT_ELEMENT_INFORMATION = "com.devepos.adt.base.ui.commands.showElementInfo";
}
