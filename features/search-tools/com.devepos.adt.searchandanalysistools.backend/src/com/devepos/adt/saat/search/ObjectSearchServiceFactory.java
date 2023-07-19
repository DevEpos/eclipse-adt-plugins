package com.devepos.adt.saat.search;

import com.devepos.adt.saat.internal.search.ObjectSearchService;

/**
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class ObjectSearchServiceFactory {
  private static IObjectSearchService SEARCH_SERVICE;

  /**
   * Retrieves instance of search service
   */
  public static IObjectSearchService getSearchService() {
    if (SEARCH_SERVICE == null) {
      SEARCH_SERVICE = new ObjectSearchService();
    }
    return SEARCH_SERVICE;
  }
}
