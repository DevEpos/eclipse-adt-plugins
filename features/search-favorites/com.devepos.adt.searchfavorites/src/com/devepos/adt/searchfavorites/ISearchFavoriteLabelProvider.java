package com.devepos.adt.searchfavorites;

import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

/**
 * Custom label provider for search favorites.
 * Can be used to overwrite the default label that is shown for a search favorite
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface ISearchFavoriteLabelProvider {

  /**
   * Retrieves label for the given search favorite
   *
   * @param favorite a favorite entry for the integrated eclipse search
   * @return
   */
  String getLabel(ISearchFavorite favorite);
}
