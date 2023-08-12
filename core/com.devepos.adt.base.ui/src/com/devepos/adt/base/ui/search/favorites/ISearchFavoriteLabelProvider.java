package com.devepos.adt.base.ui.search.favorites;

import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;

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
