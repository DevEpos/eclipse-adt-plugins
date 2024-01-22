package com.devepos.adt.searchfavorites.internal.handlers;

import java.text.MessageFormat;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.searchfavorites.internal.Activator;
import com.devepos.adt.searchfavorites.internal.ManageSearchFavoritesDialog;
import com.devepos.adt.searchfavorites.internal.SearchFavoriteStorage;
import com.devepos.adt.searchfavorites.internal.messages.Messages;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

public class ManageSearchFavoritesHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final var favoriteDialog = new ManageSearchFavoritesDialog(HandlerUtil.getActiveShell(event));
    if (favoriteDialog.open() == Window.OK) {
      final var chosenEntries = favoriteDialog.getResult();
      if (chosenEntries != null && chosenEntries.length == 1) {
        final var favorite = (ISearchFavorite) chosenEntries[0];
        var descriptor = Activator.getDefault()
            .getSearchFavoriteDescriptors()
            .get(favorite.getSearchType());
        if (descriptor == null) {
          MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
              AdtBaseUIResources.getString(IAdtBaseStrings.Dialog_Error_xtit),
              MessageFormat.format(
                  Messages.SearchFavoritesMenuAction_MissingPluginForFavSearchType_xtit,
                  favorite.getSearchType()) + "\n\n" + //$NON-NLS-1$
                  Messages.SearchFavoritesMenuAction_MissingPluginForFavSearchType_xmsg);
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
    } else {
      // reset from file if certain actions occurred
      if (favoriteDialog.isFavsRenamed()) {
        var favManager = Activator.getDefault().getSearchFavoriteManager();
        favManager.getFavorites().clear();
        SearchFavoriteStorage.deserialize(Activator.getDefault().getSearchFavoriteManager());
      }
    }
    return null;
  }

}