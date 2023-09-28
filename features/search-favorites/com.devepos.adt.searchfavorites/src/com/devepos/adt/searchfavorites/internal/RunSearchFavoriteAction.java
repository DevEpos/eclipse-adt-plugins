package com.devepos.adt.searchfavorites.internal;

import org.eclipse.jface.action.Action;

import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

public class RunSearchFavoriteAction extends Action {

  private final ISearchFavorite favorite;
  private final SearchFavoriteDescriptor descriptor;

  public RunSearchFavoriteAction(final SearchFavoriteDescriptor favoriteDescriptor,
      final ISearchFavorite favorite) {
    super();
    this.favorite = favorite;
    descriptor = favoriteDescriptor;

    setImageDescriptor(favoriteDescriptor.getIcon());
    var actionText = SearchFavoritesUtil.getFavoriteDisplayName(favorite, favoriteDescriptor);
    if (actionText.indexOf("@") != -1) {
      actionText = actionText.concat("@");
    }
    setText(actionText);
  }

  @Override
  public void run() {
    SearchFavoriteRunner.runSearchFavorite(favorite, descriptor);
  }
}
