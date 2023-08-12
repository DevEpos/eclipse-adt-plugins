package com.devepos.adt.base.ui.internal.search.favorites;

import org.eclipse.jface.action.Action;

import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;

public class RunSearchFavoriteAction extends Action {

  private ISearchFavorite favorite;
  private SearchFavoriteDescriptor descriptor;

  public RunSearchFavoriteAction(SearchFavoriteDescriptor favoriteDescriptor,
      ISearchFavorite favorite) {
    super();
    this.favorite = favorite;
    this.descriptor = favoriteDescriptor;

    setImageDescriptor(favoriteDescriptor.getIcon());
    setText(SearchFavoritesUtil.getFavoriteDisplayName(favorite, favoriteDescriptor));
  }

  @Override
  public void run() {
    SearchFavoriteRunner.runSearchFavorite(favorite, descriptor);
  }
}
