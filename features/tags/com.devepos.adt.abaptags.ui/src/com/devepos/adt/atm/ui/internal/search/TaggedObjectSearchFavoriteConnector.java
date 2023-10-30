package com.devepos.adt.atm.ui.internal.search;

import java.text.MessageFormat;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.base.ui.search.IChangeableSearchPage;
import com.devepos.adt.base.ui.search.ISearchPageListener;
import com.devepos.adt.base.ui.search.SearchPageUtil;
import com.devepos.adt.searchfavorites.ISearchFavoriteConnector;
import com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IBooleanAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IListAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesFactory;

public class TaggedObjectSearchFavoriteConnector
    implements ISearchFavoriteConnector, ISearchPageListener {
  private static final String TAGS_OPTION = "tags";
  private static final String MATCHES_ALL_TAGS_OPTION = "matchesAllTags";

  private TaggedObjectSearchQuery currentQuery;

  @Override
  public void openFavoriteInSearchDialog(final ISearchFavorite favorite) {
    var searchParams = createParamsFromFavorite(favorite);

    SearchPageUtil.addSearchPageOpenListener(this);
    currentQuery = new TaggedObjectSearchQuery(searchParams);
    NewSearchUI.openSearchDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
        TaggedObjectSearchPage.PAGE_ID);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void pageOpened(final ISearchPage searchPage) {
    if (currentQuery != null && searchPage instanceof IChangeableSearchPage) {
      ((IChangeableSearchPage) searchPage).setInputFromSearchQuery(currentQuery);
    }
    currentQuery = null;
  }

  @Override
  public void populateFavoriteFromQuery(final List<IBaseAttribute> attributes,
      final ISearchQuery searchQuery) {
    if (!(searchQuery instanceof TaggedObjectSearchQuery)) {
      return;
    }

    var tgobjQuery = (TaggedObjectSearchQuery) searchQuery;
    var params = tgobjQuery.getSearchParams();

    addFavAttribute(attributes, MATCHES_ALL_TAGS_OPTION, params.isMatchesAllTags());
    addFavAttribute(attributes, TAGS_OPTION, params.getTagIds());
  }

  @Override
  public void runSearchFromFavorite(final ISearchFavorite favorite) {
    final var projectProvider = AbapProjectProviderAccessor
        .getProviderForDestination(favorite.getDestinationId());
    if (projectProvider == null || !projectProvider.hasProject()) {
      MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
          "Error", MessageFormat.format("No Project found for destination ''{0}''",
              favorite.getDestinationId()));
      openFavoriteInSearchDialog(favorite);
    } else {
      if (!projectProvider.ensureLoggedOn()) {
        return;
      }

      final var searchRequest = new TaggedObjectSearchQuery(createParamsFromFavorite(favorite));
      searchRequest.setProjectProvider(projectProvider);

      NewSearchUI.runQueryInBackground(searchRequest);
    }

  }

  private void addFavAttribute(final List<IBaseAttribute> favOptions, final String name,
      final boolean value) {
    var booleanAttribute = ISearchFavoritesFactory.eINSTANCE.createBooleanAttribute();
    booleanAttribute.setName(name);
    booleanAttribute.setValue(value);
    favOptions.add(booleanAttribute);
  }

  private void addFavAttribute(final List<IBaseAttribute> favOptions, final String name,
      final List<String> values) {
    if (values == null || values.isEmpty()) {
      return;
    }
    var listAttribute = ISearchFavoritesFactory.eINSTANCE.createListAttribute();
    listAttribute.setName(name);
    listAttribute.getValues().addAll(values);
    favOptions.add(listAttribute);
  }

  private ITaggedObjectSearchParams createParamsFromFavorite(final ISearchFavorite favorite) {
    var searchParams = IAbapTagsFactory.eINSTANCE.createTaggedObjectSearchParams();

    for (var attribute : favorite.getAttributes()) {
      switch (attribute.getName()) {
      case TAGS_OPTION:
        searchParams.getTagIds().addAll(((IListAttribute) attribute).getValues());
        break;
      case MATCHES_ALL_TAGS_OPTION:
        searchParams.setMatchesAllTags(((IBooleanAttribute) attribute).isValue());
        break;
      }
    }
    return searchParams;
  }

}
