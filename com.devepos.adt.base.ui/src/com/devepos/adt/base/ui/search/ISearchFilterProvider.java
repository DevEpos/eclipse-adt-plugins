package com.devepos.adt.base.ui.search;

import java.util.List;

/**
 * Provides relevant search parameters
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface ISearchFilterProvider {

  /**
   * Retrieves a list of all valid search parameters
   *
   * @return List of search parameters
   */
  List<ISearchFilter> getFilters();
}
