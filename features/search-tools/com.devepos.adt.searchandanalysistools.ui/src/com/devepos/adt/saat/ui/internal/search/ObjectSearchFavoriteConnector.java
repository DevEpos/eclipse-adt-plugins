package com.devepos.adt.saat.ui.internal.search;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.model.searchfavorites.IBaseAttribute;
import com.devepos.adt.base.model.searchfavorites.IBooleanAttribute;
import com.devepos.adt.base.model.searchfavorites.IIntAttribute;
import com.devepos.adt.base.model.searchfavorites.IMapAttribute;
import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.base.model.searchfavorites.ISearchFavoritesFactory;
import com.devepos.adt.base.model.searchfavorites.IStringAttribute;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.base.ui.project.AbapProjectProxy;
import com.devepos.adt.base.ui.search.IChangeableSearchPage;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.ISearchPageListener;
import com.devepos.adt.base.ui.search.SearchFilterHandler;
import com.devepos.adt.base.ui.search.SearchPageUtil;
import com.devepos.adt.base.ui.search.favorites.ISearchFavoriteConnector;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchFactory;
import com.devepos.adt.saat.model.objectsearch.ISearchConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryField;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig;
import com.devepos.adt.saat.search.ObjectSearchServiceFactory;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.search.view.FilterInitializer;
import com.devepos.adt.saat.ui.internal.search.view.ObjectSearchPage;
import com.devepos.adt.saat.ui.internal.search.view.ObjectSearchQuery;
import com.devepos.adt.saat.ui.internal.search.view.ObjectSearchRequest;
import com.sap.adt.communication.content.ContentHandlerException;

public class ObjectSearchFavoriteConnector implements ISearchFavoriteConnector,
    ISearchPageListener {

  private static final String MAX_RESULTS_OPTION = "maxResults";
  private static final String AND_SEARCH_ACTIVE_OPTION = "andSearchActive";
  private static final String SEARCH_TYPE_OPTION = "searchType";
  private static final String SEARCH_TYPE_LABEL_OPTION = "searchTypeLabel";
  private static final String CUSTOM_OPTIONS = "customOptions";
  private static final String FIELDS = "fields";
  private static final String FIELDS_WITH_FILTER = "fieldsWithFilter";

  private ObjectSearchQuery currentQuery;

  @SuppressWarnings("unchecked")
  private static ObjectSearchRequest createRequestFromFavorite(final ISearchFavorite favorite) {
    final var searchRequest = new ObjectSearchRequest();
    for (var favAttribute : favorite.getAttributes()) {
      switch (favAttribute.getName()) {
      case FIELDS_WITH_FILTER:
      case FIELDS:
        for (var entry : ((IMapAttribute) favAttribute).getEntries()) {
          var inputField = IObjectSearchFactory.eINSTANCE.createSearchQueryField();
          inputField.setName(entry.getKey());
          inputField.setRawInput(entry.getValue());

          if (favAttribute.getName().equals(FIELDS)) {
            inputField.getValues().addAll(Arrays.asList(entry.getValue().split(" ")));
          }

          searchRequest.getQueryInput().getFields().add(inputField);
        }
        break;
      case SEARCH_TYPE_OPTION:
        searchRequest.setSearchType(((IStringAttribute) favAttribute).getValue());
        break;
      case AND_SEARCH_ACTIVE_OPTION:
        searchRequest.setAndSearchActive(((IBooleanAttribute) favAttribute).isValue());
        break;
      case MAX_RESULTS_OPTION:
        searchRequest.setMaxResults(((IIntAttribute) favAttribute).getValue());
        break;
      case CUSTOM_OPTIONS:
        var entries = ((IMapAttribute) favAttribute).getEntries();
        searchRequest.getQueryInput().getCustomOptions().putAll((Map<String, String>) entries);
        break;
      }
    }

    searchRequest.setReadApiState(true);
    searchRequest.setDestinationId(favorite.getDestinationId());
    return searchRequest;
  }

  @SuppressWarnings("unchecked")
  private static boolean parseRawInputAndUpdateQueryInput(final ISearchQueryField queryInput,
      final ISearchTypeInputFieldConfig fieldConfig, final IAbapProjectProvider projectProvider) {
    if (fieldConfig.getFilters().isEmpty() || StringUtil.isEmpty(queryInput.getRawInput())) {
      return true;
    }

    var configuredFilters = new ArrayList<ISearchFilter>();
    for (var filterConfig : fieldConfig.getFilters()) {
      if (filterConfig.isInternal()) {
        continue;
      }
      var searchFilter = new FilterInitializer(filterConfig, projectProvider).createFilter();
      configuredFilters.add(searchFilter);
    }

    if (configuredFilters.isEmpty()) {
      return true;
    }

    var filterHandler = new SearchFilterHandler(() -> configuredFilters);
    var parsedFilterMap = filterHandler.getSearchFiltersAsListMap(queryInput.getRawInput(), null);

    for (var parsedFilter : parsedFilterMap.entrySet()) {
      var queryFieldFilter = IObjectSearchFactory.eINSTANCE.createSearchQueryFilter();
      queryFieldFilter.setName(parsedFilter.getKey());
      queryFieldFilter.getValues().addAll((Collection<String>) parsedFilter.getValue());
      queryInput.getFilters().add(queryFieldFilter);
    }
    return true;
  }

  @Override
  public void openFavoriteInSearchDialog(final ISearchFavorite favorite) {
    final var searchRequest = createRequestFromFavorite(favorite);
    searchRequest.setProjectProvider(new AbapProjectProxy(null));

    currentQuery = new ObjectSearchQuery(searchRequest);
    SearchPageUtil.addSearchPageOpenListener(this);
    NewSearchUI.openSearchDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
        ObjectSearchPage.PAGE_ID);
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
  public void populateFavoriteFromQuery(final List<IBaseAttribute> favOptions,
      final ISearchQuery searchQuery) {
    if (!(searchQuery instanceof ObjectSearchQuery)) {
      return;
    }
    var objectSearchQuery = (ObjectSearchQuery) searchQuery;
    var searchRequest = objectSearchQuery.getSearchRequest();

    addFavAttribute(favOptions, AND_SEARCH_ACTIVE_OPTION, searchRequest.isAndSearchActive());
    addFavAttribute(favOptions, SEARCH_TYPE_OPTION, searchRequest.getSearchType());
    addFavAttribute(favOptions, SEARCH_TYPE_LABEL_OPTION, searchRequest.getQueryInput()
        .getTypeLabel());
    addFavAttribute(favOptions, MAX_RESULTS_OPTION, searchRequest.getMaxResults());

    var queryInput = searchRequest.getQueryInput();
    addFavAttribute(favOptions, CUSTOM_OPTIONS, queryInput.getCustomOptions());

    addFavAttribute(favOptions, FIELDS, queryInput.getFields()
        .stream()
        .filter(f -> f.getFilters().isEmpty())
        .collect(Collectors.toMap(ISearchQueryField::getName, ISearchQueryField::getRawInput)));

    addFavAttribute(favOptions, FIELDS_WITH_FILTER, queryInput.getFields()
        .stream()
        .filter(f -> !f.getFilters().isEmpty())
        .collect(Collectors.toMap(ISearchQueryField::getName, ISearchQueryField::getRawInput)));
  }

  @Override
  public void runSearchFromFavorite(final ISearchFavorite favorite) {
    final var projectProvider = AbapProjectProviderAccessor.getProviderForDestination(favorite
        .getDestinationId());
    if (projectProvider == null || !projectProvider.hasProject()) {
      MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
          Messages.Dialog_ErrorTitle_xmsg, MessageFormat.format(
              Messages.ObjectSearch_NoProjectFound_xmsg, favorite.getDestinationId()));
      openFavoriteInSearchDialog(favorite);
    } else {
      final var searchRequest = createRequestFromFavorite(favorite);

      searchRequest.setProjectProvider(projectProvider);

      if (!projectProvider.ensureLoggedOn()) {
        return;
      }

      ISearchConfig searchConfig = null;
      try {
        searchConfig = ObjectSearchServiceFactory.getSearchService()
            .getSearchConfig(projectProvider.getDestinationId());
      } catch (ContentHandlerException exc) {
        MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
            Messages.Dialog_ErrorTitle_xmsg, MessageFormat.format(
                Messages.ObjectSearchPage_searchTypeConfigSerializationError_xmsg, projectProvider
                    .getProjectName()));
        return;
      }
      var searchTypeConfig = searchConfig.getSearchTypes()
          .stream()
          .filter(s -> searchRequest.getSearchType().equals(s.getName()))
          .findFirst();
      if (searchTypeConfig.isPresent()) {
        searchRequest.setOutputConfig(searchTypeConfig.get().getOutputConfig());
        searchRequest.getQueryInput().setTypeLabel(searchTypeConfig.get().getLabel());
        var searchFields = searchTypeConfig.get().getInputs();
        for (var queryInputField : searchRequest.getQueryInput().getFields()) {
          var fieldConfig = searchFields.stream()
              .filter(f -> f.getName().equals(queryInputField.getName()))
              .findFirst();
          if (fieldConfig.isPresent()) {
            queryInputField.setLabel(fieldConfig.get().getLabel());
            if (!parseRawInputAndUpdateQueryInput(queryInputField, fieldConfig.get(),
                projectProvider)) {
              openFavoriteInSearchDialog(favorite);
              return;
            }
          }
        }
        NewSearchUI.runQueryInBackground(new ObjectSearchQuery(searchRequest));
      } else {
        openFavoriteInSearchDialog(favorite);
      }
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
      final int value) {
    var intAttribute = ISearchFavoritesFactory.eINSTANCE.createIntAttribute();
    intAttribute.setName(name);
    intAttribute.setValue(value);
    favOptions.add(intAttribute);
  }

  private void addFavAttribute(final List<IBaseAttribute> favOptions, final String name,
      final Map<String, String> entries) {
    if (entries == null || entries.isEmpty()) {
      return;
    }
    var mapAttribute = ISearchFavoritesFactory.eINSTANCE.createMapAttribute();
    mapAttribute.setName(name);
    mapAttribute.getEntries().putAll(entries);
    favOptions.add(mapAttribute);
  }

  private void addFavAttribute(final List<IBaseAttribute> favOptions, final String name,
      final String value) {
    var stringAttribute = ISearchFavoritesFactory.eINSTANCE.createStringAttribute();
    stringAttribute.setName(name);
    stringAttribute.setValue(value);
    favOptions.add(stringAttribute);
  }
}
