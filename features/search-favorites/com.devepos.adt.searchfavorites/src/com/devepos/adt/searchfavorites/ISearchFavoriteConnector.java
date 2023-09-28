package com.devepos.adt.searchfavorites;

import java.util.List;

import org.eclipse.search.ui.ISearchQuery;

import com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

/**
 * Connector for search favorites, to create generic favorite entries of executed search queries
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface ISearchFavoriteConnector {

  /**
   * Opens the given favorite entry in the Object Search Page of the eclipse
   * search dialog
   *
   * @param favorite a favorite entry for a search
   */
  void openFavoriteInSearchDialog(ISearchFavorite favorite);

  /**
   * Populates the favorite instance from the given search query
   *
   * @param attributes  attributes of favorite
   * @param searchQuery executed search query whoose properties shall be inserted into the
   *                    favorite
   */
  void populateFavoriteFromQuery(List<IBaseAttribute> attributes, ISearchQuery searchQuery);

  /**
   * Creates and runs a Object search query from the given favorite entry
   *
   * @param favorite a favorite entry for a search
   */
  void runSearchFromFavorite(ISearchFavorite favorite);
}
