package com.devepos.adt.base.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.search.favorites.ManageSearchFavoritesDialog;

public class ManageSearchFavoritesHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final var favoriteDialog = new ManageSearchFavoritesDialog(HandlerUtil.getActiveShell(event));
    if (favoriteDialog.open() == Window.OK) {
      final var chosenEntries = favoriteDialog.getResult();
      if (chosenEntries != null && chosenEntries.length == 1) {
        final var favorite = (ISearchFavorite) chosenEntries[0];
        var descriptor = AdtBaseUIPlugin.getDefault()
            .getSearchFavoriteDescriptors()
            .get(favorite.getSearchType());
        if (descriptor == null) {
          return null;
        }
        var connector = descriptor.getConnector();
        if (connector == null) {
          return null;
        }
        if (favorite.isProjectIndependent()) {
          connector.openFavoriteInSearchDialog(favorite);
        } else {
          connector.runSearchFromFavorite(favorite);
        }
      }
    }
    return null;
  }

}