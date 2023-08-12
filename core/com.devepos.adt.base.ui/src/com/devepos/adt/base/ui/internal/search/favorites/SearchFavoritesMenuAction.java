package com.devepos.adt.base.ui.internal.search.favorites;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.window.Window;
import org.eclipse.search2.internal.ui.SearchView;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;

import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.search.IAbapProjectSearchQuery;

/**
 * An Action for managing the opening/managing the searches favorites
 *
 * @author Ludwig Stockbauer-Muhr
 */
@SuppressWarnings("restriction")
public class SearchFavoritesMenuAction extends Action implements IMenuCreator {
  private Menu menu;
  private final ISearchFavorites favoriteManager;
  private final String searchType;

  public SearchFavoritesMenuAction(final String searchType) {
    super(Messages.Search_SearchFavoritesAction_xtol, AdtBaseUIPlugin.getDefault()
        .getImageDescriptor(IAdtBaseImages.FAVORITES));
    setMenuCreator(this);
    this.searchType = searchType;
    favoriteManager = AdtBaseUIPlugin.getDefault().getSearchFavoriteManager();
  }

  @Override
  public void dispose() {
    if (menu != null) {
      menu.dispose();
    }
  }

  @Override
  public Menu getMenu(final Control parent) {
    if (menu != null) {
      menu.dispose();
    }
    menu = new Menu(parent);

    var organizeFavoritesAction = ActionFactory.createAction(Messages.Search_OrganizeFavorites_xmit,
        null, this::openOrganizeFavoritesDialog);
    organizeFavoritesAction.setEnabled(favoriteManager.hasEntries());

    final var createFavoriteAction = ActionFactory.createAction(
        Messages.Search_CreateFavoriteFromCurrentQuery_xmit, null, this::createNewFavorite);

    if (!favoriteManager.hasEntries()) {
      final var noFavoritesAction = new Action(Messages.Search_NoSearchFavorites_xmit) {
      };
      noFavoritesAction.setEnabled(false);
      addActionToMenu(menu, noFavoritesAction);
    } else {
      var favoriteDescriptors = AdtBaseUIPlugin.getDefault().getSearchFavoriteDescriptors();
      for (final var favorite : favoriteManager.getFavorites()) {
        var descriptor = favoriteDescriptors.get(favorite.getSearchType());
        if (descriptor == null) {
          // TODO: throw exception
          continue;
        }
        addActionToMenu(menu, new RunSearchFavoriteAction(descriptor, favorite));
      }
    }
    var separator = new Separator();

    separator.fill(menu, -1);

    addActionToMenu(menu, createFavoriteAction);
    addActionToMenu(menu, organizeFavoritesAction);

    separator = new Separator();
    separator.fill(menu, -1);
    addActionToMenu(menu, new ImportFavoritesAction());
    final var exportAction = new ExportFavoritesAction();
    exportAction.setEnabled(favoriteManager.hasEntries());
    addActionToMenu(menu, exportAction);

    return menu;
  }

  @Override
  public Menu getMenu(final Menu parent) {
    return null;
  }

  @Override
  public void runWithEvent(final Event event) {
    openOrganizeFavoritesDialog();
  }

  /*
   * Adds the given action to the given menu
   */
  private void addActionToMenu(final Menu parent, final IAction action) {
    final var item = new ActionContributionItem(action);
    item.fill(parent, -1);
  }

  /*
   * Creates new favorite from the last executed object search query
   */
  private void createNewFavorite() {
    final var activePart = PlatformUI.getWorkbench()
        .getActiveWorkbenchWindow()
        .getActivePage()
        .getActivePart();
    if (!(activePart instanceof SearchView)) {
      return;
    }
    final var currentSearchView = (SearchView) activePart;
    final var currentSearchResult = currentSearchView.getCurrentSearchResult();
    final var resultPage = currentSearchView.getActivePage();
    if (resultPage == null) {
      return;
    }
    var searchQuery = currentSearchResult.getQuery();
    if (!(searchQuery instanceof IAbapProjectSearchQuery)) {
      return;
    }
    new NewSearchFavoriteDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
        searchType, (IAbapProjectSearchQuery) searchQuery).open();
  }

  /*
   * Opens a dialog to organize all the favorites
   */
  private void openOrganizeFavoritesDialog() {
    final SelectionDialog favoritesDialog = new ManageSearchFavoritesDialog(PlatformUI
        .getWorkbench()
        .getActiveWorkbenchWindow()
        .getShell());
    if (favoritesDialog.open() == Window.OK) {
      final var chosenEntries = favoritesDialog.getResult();
      if (chosenEntries != null && chosenEntries.length == 1) {
        SearchFavoriteRunner.runSearchFavorite((ISearchFavorite) chosenEntries[0]);
      }
    }
  }
}