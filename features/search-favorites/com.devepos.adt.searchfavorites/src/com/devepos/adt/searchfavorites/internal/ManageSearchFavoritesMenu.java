package com.devepos.adt.searchfavorites.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.CompoundContributionItem;

import com.devepos.adt.searchfavorites.internal.messages.Messages;

/**
 * Creates Menu for ABAP Object Search + Favorites
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class ManageSearchFavoritesMenu extends CompoundContributionItem {

  public ManageSearchFavoritesMenu() {
  }

  public ManageSearchFavoritesMenu(final String id) {
    super(id);
  }

  @Override
  protected IContributionItem[] getContributionItems() {
    return createMenuItems();
  }

  private IContributionItem[] createMenuItems() {
    final List<IContributionItem> items = new ArrayList<>();
    var favoriteManager = Activator.getDefault().getSearchFavoriteManager();
    if (!favoriteManager.hasEntries()) {
      final IAction noFavoritesAction = new Action(Messages.Search_NoSearchFavorites_xmit) {
      };
      noFavoritesAction.setEnabled(false);
      items.add(new ActionContributionItem(noFavoritesAction));
    } else {
      var favoriteDescriptors = Activator.getDefault().getSearchFavoriteDescriptors();
      for (final var favorite : favoriteManager.getFavorites()) {
        var descriptor = favoriteDescriptors.get(favorite.getSearchType());
        if (descriptor == null) {
          // TODO: throw exception
          continue;
        }
        items.add(new ActionContributionItem(new RunSearchFavoriteAction(descriptor, favorite)));
      }
    }
    items.add(new Separator());
    items.add(new ActionContributionItem(new ImportFavoritesAction()));
    final var exportAction = new ExportFavoritesAction();
    exportAction.setEnabled(favoriteManager.hasEntries());
    items.add(new ActionContributionItem(exportAction));

    return items.toArray(new IContributionItem[items.size()]);
  }
}
