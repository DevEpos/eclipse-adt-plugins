package com.devepos.adt.searchfavorites.internal;

import com.devepos.adt.searchfavorites.internal.preferences.IPreferences;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

/**
 * Runner for search favorites
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFavoriteRunner {

  public static void runSearchFavorite(final ISearchFavorite favorite) {
    var descriptor = Activator.getDefault()
        .getSearchFavoriteDescriptors()
        .get(favorite.getSearchType());
    if (descriptor == null) {
      throw new IllegalArgumentException("No search favorite descriptor registered for type " //$NON-NLS-1$
          + favorite.getSearchType());
    }
    runSearchFavorite(favorite, descriptor);
  }

  public static void handleSelectedSearchFavorite(final ISearchFavorite favorite,
      final SearchFavoriteDescriptor descriptor, final boolean ctrlDown) {
    if (descriptor == null) {
      throw new IllegalArgumentException("Search favorite descriptor must not be null!"); //$NON-NLS-1$
    }

    var execMode = Activator.getDefault()
        .getPreferenceStore()
        .getString(ctrlDown ? IPreferences.FAV_EXEC_MODE_WITH_CTRL
            : IPreferences.FAV_EXEC_MODE_NO_MODIFIERS);

    if (execMode == IExecutionModes.OPEN_IN_DIALOG) {
      descriptor.getConnector().openFavoriteInSearchDialog(favorite);
    } else {
      descriptor.getConnector().runSearchFromFavorite(favorite);
    }
  }

  public static void runSearchFavorite(final ISearchFavorite favorite,
      final SearchFavoriteDescriptor descriptor) {
    if (descriptor == null) {
      throw new IllegalArgumentException("Search favorite descriptor must not be null!"); //$NON-NLS-1$
    }

    if (favorite.isProjectIndependent()) {
      descriptor.getConnector().openFavoriteInSearchDialog(favorite);
    } else {
      descriptor.getConnector().runSearchFromFavorite(favorite);
    }
  }
}
