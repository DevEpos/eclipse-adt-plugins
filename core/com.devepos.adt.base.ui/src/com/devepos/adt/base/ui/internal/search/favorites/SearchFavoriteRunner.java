package com.devepos.adt.base.ui.internal.search.favorites;

import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;

/**
 * Runner for search favorites
 * 
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFavoriteRunner {

  public static void runSearchFavorite(ISearchFavorite favorite) {
    var descriptor = AdtBaseUIPlugin.getDefault()
        .getSearchFavoriteDescriptors()
        .get(favorite.getSearchType());
    if (descriptor == null) {
      throw new IllegalArgumentException("No search favorite descriptor registered for type "
          + favorite.getSearchType());
    }
    runSearchFavorite(favorite, descriptor);
  }

  public static void runSearchFavorite(ISearchFavorite favorite,
      SearchFavoriteDescriptor descriptor) {
    if (descriptor == null) {
      throw new IllegalArgumentException("Search favorite descriptor must not be null!");
    }

    if (favorite.isProjectIndependent()) {
      descriptor.getConnector().openFavoriteInSearchDialog(favorite);
    } else {
      descriptor.getConnector().runSearchFromFavorite(favorite);
    }
  }
}
