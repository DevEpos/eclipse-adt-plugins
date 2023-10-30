package com.devepos.adt.searchfavorites.internal;

import org.eclipse.jface.action.Action;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.searchfavorites.internal.messages.Messages;
import com.devepos.adt.searchfavorites.internal.preferences.IPreferences;

/**
 * Imports search favorites from a file
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class ImportFavoritesAction extends Action {

  public ImportFavoritesAction() {
    super(Messages.FavoritesImporter_ImportFavoritesAction_xmit,
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.IMPORT));
  }

  @Override
  public void run() {
    final var existingFavorites = Activator.getDefault().getSearchFavoriteManager();

    var importer = new FavoritesImporter(importedFavs -> {
      var prefStore = Activator.getDefault().getPreferenceStore();
      var makeNewFavsVisible = prefStore.getBoolean(IPreferences.MAKE_NEW_FAVS_VISIBLE);
      var insertNewFavsAtBeginning = makeNewFavsVisible
          && prefStore.getBoolean(IPreferences.INSERT_NEW_FAVS_AT_START);
      if (insertNewFavsAtBeginning) {
        existingFavorites.addFavorites(importedFavs, 0);
      } else {
        existingFavorites.addFavorites(importedFavs);
      }
      SearchFavoriteStorage.serialize();
    }, favToBeImported -> existingFavorites.contains(favToBeImported.getDestinationId(),
        favToBeImported.getSearchType(), favToBeImported.getDescription()));

    importer.run();
  }
}
