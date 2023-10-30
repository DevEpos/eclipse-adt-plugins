package com.devepos.adt.searchfavorites.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.CompoundContributionItem;

import com.devepos.adt.base.ui.action.ActionFactory;
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
    var favoritesManager = Activator.getDefault().getSearchFavoriteManager();

    items.addAll(SearchFavoritesMenuAction.createFavoriteContributionItems(favoritesManager));

    items.add(new Separator());
    items.add(
        new ActionContributionItem(ActionFactory.createAction(Messages.Search_ManageFavorites_xmit,
            null, SearchFavoritesMenuAction::openOrganizeFavoritesDialog)));
    items.add(new Separator());
    items.add(new ActionContributionItem(new ImportFavoritesAction()));

    final var exportAction = new ExportFavoritesAction();
    exportAction.setEnabled(favoritesManager.hasEntries());
    items.add(new ActionContributionItem(exportAction));

    return items.toArray(new IContributionItem[items.size()]);
  }
}
