package com.devepos.adt.base.ui;

/**
 * Holds constants to defined Contexts in this plugin
 *
 * @author stockbal
 *
 */
public interface IGeneralContextConstants {

  /**
   * Context id for ABAP Development
   */
  String ABAP = "com.sap.adt.tools.core.ui.abap";
  /**
   * Context for Views which allow the filtering of a viewer via a text input
   */
  String FILTERABLE_VIEWS = "com.devepos.adt.base.ui.filterableView";
  /**
   * Context for Views which hold a search page from org.eclipse.search.ui
   */
  String SEARCH_PAGE_VIEWS = "com.devepos.adt.base.ui.searchPage";
  /**
   * Context for Views which are able to show ADT element information for a selected object
   */
  String ELEMENT_INFO = "com.devepos.adt.base.ui.elementInfo";
}
