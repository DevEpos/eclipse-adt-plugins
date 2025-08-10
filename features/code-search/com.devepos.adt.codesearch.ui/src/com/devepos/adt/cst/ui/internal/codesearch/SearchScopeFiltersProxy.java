package com.devepos.adt.cst.ui.internal.codesearch;

import java.util.ArrayList;
import java.util.List;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.ISearchFilterProvider;
import com.devepos.adt.cst.ui.internal.codesearch.client.ClientSearchScopeFilters;

public class SearchScopeFiltersProxy implements ISearchFilterProvider {

  private static final List<ISearchFilter> EMPTY_FILTERS = new ArrayList<>();
  private boolean isClientSearchMode;
  private IAbapProjectProvider projectProvider;
  private ISearchFilterProvider clientSearchFilterProvider;
  private ISearchFilterProvider backendSearchFilterProvider;

  public SearchScopeFiltersProxy(final IAbapProjectProvider projectProvider) {
    this.projectProvider = projectProvider;
  }

  @Override
  public List<ISearchFilter> getFilters() {
    if (!projectProvider.ensureLoggedOn()) {
      return EMPTY_FILTERS;
    }
    return getFilterProvider().getFilters();
  }

  private ISearchFilterProvider getFilterProvider() {
    if (isClientSearchMode) {
      if (clientSearchFilterProvider == null) {
        clientSearchFilterProvider = new ClientSearchScopeFilters(projectProvider);
      }
      return clientSearchFilterProvider;
    } else {
      if (backendSearchFilterProvider == null) {
        backendSearchFilterProvider = new ServerBasedSearchScopeFilters(projectProvider);
      }
      return backendSearchFilterProvider;
    }
  }

  public void setClientSearchMode(boolean clientSearch) {
    this.isClientSearchMode = clientSearch;

  }
}
