package com.devepos.adt.searchfavorites;

import org.eclipse.jface.action.IAction;

import com.devepos.adt.searchfavorites.internal.SearchFavoritesMenuAction;

public class SearchFavoritesActionFactory {

  /**
   * Creates new search favorites action instance
   *
   * @param searchType identifies a search favorite and the corresponding search page
   */
  public static IAction createSearchFavoritesAction(final String searchType) {
    return new SearchFavoritesMenuAction(searchType);
  }
}
