package com.devepos.adt.base.ui.search.favorites;

import org.eclipse.jface.action.IAction;

import com.devepos.adt.base.ui.internal.search.favorites.SearchFavoritesMenuAction;

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
