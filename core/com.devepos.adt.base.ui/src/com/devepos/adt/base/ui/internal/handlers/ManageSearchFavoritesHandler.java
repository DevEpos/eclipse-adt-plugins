package com.devepos.adt.base.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.base.ui.internal.search.favorites.ManageSearchFavoritesDialog;

public class ManageSearchFavoritesHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    final var favoriteDialog = new ManageSearchFavoritesDialog(HandlerUtil.getActiveShell(event));
    if (favoriteDialog.open() == Window.OK) {
      final Object[] chosenEntries = favoriteDialog.getResult();
      if (chosenEntries != null && chosenEntries.length == 1) {
        final ISearchFavorite favorite = (ISearchFavorite) chosenEntries[0];
        if (favorite.isProjectIndependent()) {
          // ObjectSearchEngine.openFavoriteInSearchDialog(favorite);
        } else {
          // ObjectSearchEngine.runSearchFromFavorite(favorite);
        }
      }
    }
    return null;
  }

}