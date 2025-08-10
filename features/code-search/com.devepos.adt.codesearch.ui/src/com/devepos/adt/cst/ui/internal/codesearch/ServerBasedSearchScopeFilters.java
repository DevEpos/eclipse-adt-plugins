package com.devepos.adt.cst.ui.internal.codesearch;

import java.util.ArrayList;
import java.util.List;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.ISearchFilterProvider;
import com.devepos.adt.base.ui.search.contentassist.ApplicationComponentSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.DateSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.PackageSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.UserSearchFilter;
import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.ui.internal.codesearch.contentassist.ObjectTypeSearchFilter;
import com.devepos.adt.cst.ui.internal.codesearch.contentassist.TransportRequestSearchFilter;
import com.devepos.adt.cst.ui.internal.messages.Messages;

/**
 * Represents all available search filters for the Code Search
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class ServerBasedSearchScopeFilters implements ISearchFilterProvider {
  private List<ISearchFilter> parameters;
  private ISearchFilter transportRequestFilter;
  private final IAbapProjectProvider projectProvider;
  private final IAdtUriTemplateProvider uriTemplateProvider;

  public ServerBasedSearchScopeFilters(final IAbapProjectProvider projectProvider) {
    this.projectProvider = projectProvider;
    uriTemplateProvider = CodeSearchFactory.getNamedItemUriTemplateProvider(projectProvider);
  }

  @Override
  public List<ISearchFilter> getFilters() {
    if (parameters == null) {
      parameters = new ArrayList<>();
      parameters.add(new ObjectTypeSearchFilter(projectProvider, true));
      parameters.add(new UserSearchFilter(projectProvider, FilterName.OWNER.getContentAssistName(),
          Messages.CodeSearchScopeFilters_ownerFilterShortDescription_xmsg, null));
      parameters.add(new PackageSearchFilter(projectProvider));
      parameters.add(new ApplicationComponentSearchFilter(projectProvider, uriTemplateProvider,
          NamedItem.APPLICATION_COMPONENT));
      parameters.add(new DateSearchFilter(FilterName.CREATED_DATE.getContentAssistName(),
          Messages.CodeSearchScopeFilters_createdOnFilterShortDescription_xmsg,
          AdtBaseUIResources.format(IAdtBaseStrings.SearchFilter_CreatedDateFilterDescription_xmsg,
              FilterName.CREATED_DATE.getContentAssistName()),
          null));
    }

    var validParameters = new ArrayList<>(parameters);
    if (uriTemplateProvider
        .getTemplateByDiscoveryTerm(NamedItem.TRANSPORT_REQUEST.getDiscoveryTerm()) != null) {
      if (transportRequestFilter == null) {
        transportRequestFilter = new TransportRequestSearchFilter(projectProvider,
            uriTemplateProvider, NamedItem.TRANSPORT_REQUEST);
      }
      validParameters.add(transportRequestFilter);
    }

    return validParameters;
  }
}
