package com.devepos.adt.searchfavorites.internal;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.search2.internal.ui.SearchView;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.search.IAbapProjectSearchQuery;
import com.devepos.adt.searchfavorites.internal.messages.Messages;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

/**
 * An Action for managing the opening/managing the searches favorites
 *
 * @author Ludwig Stockbauer-Muhr
 */
@SuppressWarnings("restriction")
public class SearchFavoritesMenuAction extends Action implements IMenuCreator {
  private Menu menu;
  private final String searchType;

  /**
   * Creates action contribution items for the search favorite in the given favorites container
   *
   * @param favorites container with favorites
   * @return list of action contribution items to be used in a menu
   */
  public static List<IContributionItem> createFavoriteContributionItems(
      final ISearchFavorites favorites) {
    List<IContributionItem> favoriteItems = new ArrayList<>();
    if (!favorites.hasEntries()) {
      final var noFavoritesAction = new Action(Messages.Search_NoSearchFavorites_xmit) {
      };
      noFavoritesAction.setEnabled(false);
      favoriteItems.add(new ActionContributionItem(noFavoritesAction));
    } else {
      var favoriteDescriptors = Activator.getDefault().getSearchFavoriteDescriptors();
      var accelerator = 1;
      for (final var favorite : favorites.getFavorites(false)) {
        var descriptor = favoriteDescriptors.get(favorite.getSearchType());
        if (descriptor == null) {
          var missingPluginAction = new Action(
              MessageFormat.format(
                  Messages.SearchFavoritesMenuAction_MissingPluginForFavSearchType_xtit,
                  favorite.getSearchType()),
              PlatformUI.getWorkbench()
                  .getSharedImages()
                  .getImageDescriptor(ISharedImages.IMG_OBJS_ERROR_TSK)) {

            @Override
            public void run() {
              MessageDialog.openError(
                  PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                  AdtBaseUIResources.getString(IAdtBaseStrings.Dialog_Error_xtit),
                  MessageFormat.format(
                      Messages.SearchFavoritesMenuAction_MissingPluginForFavSearchType_xtit,
                      favorite.getSearchType()) + "\n\n" + //$NON-NLS-1$
                      Messages.SearchFavoritesMenuAction_MissingPluginForFavSearchType_xmsg);
            }

          };
          favoriteItems.add(new ActionContributionItem(missingPluginAction));
          continue;
        }
        var favoriteAction = new RunSearchFavoriteAction(descriptor, favorite);
        if (accelerator < 10) {
          favoriteAction.setText(String.format("&%d %s", accelerator++, favoriteAction.getText())); //$NON-NLS-1$
        }
        favoriteItems.add(new ActionContributionItem(favoriteAction));
      }

      if (favoriteItems.isEmpty()) {
        final var noFavoritesAction = new Action(
            Messages.SearchFavoritesMenuAction_AllFavsAreHidden_xmit) {
        };
        noFavoritesAction.setEnabled(false);
        favoriteItems.add(new ActionContributionItem(noFavoritesAction));
      }
    }

    return favoriteItems;
  }

  public SearchFavoritesMenuAction(final String searchType) {
    super(Messages.Search_SearchFavoritesAction_xtol,
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.FAVORITES));
    setMenuCreator(this);
    this.searchType = searchType;
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

    var favorites = Activator.getDefault().getSearchFavoriteManager();

    final var createFavoriteAction = ActionFactory.createAction(
        Messages.Search_CreateFavoriteFromCurrentQuery_xmit, null, this::createNewFavorite);

    createFavoriteContributionItems(favorites).forEach(item -> item.fill(menu, -1));
    var separator = new Separator();

    separator.fill(menu, -1);

    addActionToMenu(menu, createFavoriteAction);
    addActionToMenu(menu, ActionFactory.createAction(Messages.Search_ManageFavorites_xmit, null,
        SearchFavoritesMenuAction::openOrganizeFavoritesDialog));

    return menu;
  }

  /*
   * Opens a dialog to organize all the favorites
   */
  public static void openOrganizeFavoritesDialog() {
    final SelectionDialog favoritesDialog = new ManageSearchFavoritesDialog(
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
    if (favoritesDialog.open() == Window.OK) {
      final var chosenEntries = favoritesDialog.getResult();
      if (chosenEntries != null && chosenEntries.length == 1) {
        SearchFavoriteRunner.runSearchFavorite((ISearchFavorite) chosenEntries[0]);
      }
    }
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
}