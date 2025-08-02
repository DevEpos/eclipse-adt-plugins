package com.devepos.adt.cst.ui.internal.codesearch.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.ISearchFilterProvider;
import com.devepos.adt.base.ui.search.contentassist.PackageSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.SearchFilterValueProposal;
import com.devepos.adt.base.ui.search.contentassist.UserSearchFilter;
import com.devepos.adt.cst.ui.internal.codesearch.FilterName;
import com.devepos.adt.cst.ui.internal.codesearch.contentassist.ObjectTypeSearchFilter;
import com.devepos.adt.cst.ui.internal.messages.Messages;
import com.sap.adt.ris.search.ui.virtualfolders.FacetProviderFactory;
import com.sap.adt.ris.search.ui.virtualfolders.IFacet;
import com.sap.adt.tools.core.model.util.ServiceNotAvailableException;

@SuppressWarnings("restriction")
public class ClientSearchScopeFilters implements ISearchFilterProvider {
  private List<ISearchFilter> parameters;
  private final IAbapProjectProvider projectProvider;
  private static final Map<IProject, List<ISearchFilter>> FACET_FILTERS_CACHE = new HashMap<>();

  public ClientSearchScopeFilters(final IAbapProjectProvider projectProvider) {
    this.projectProvider = projectProvider;
  }

  @Override
  public List<ISearchFilter> getFilters() {
    if (parameters == null) {
      parameters = new ArrayList<>();
      parameters.add(new ObjectTypeSearchFilter(projectProvider, false));
      parameters.add(new UserSearchFilter(projectProvider, FilterName.OWNER.getContentAssistName(),
          Messages.CodeSearchScopeFilters_ownerFilterShortDescription_xmsg, null, false) {
        @Override
        public boolean supportsNegatedValues() {
          return false;
        }
      });
      parameters.add(new PackageSearchFilter(projectProvider) {
        @Override
        public boolean supportsNegatedValues() {
          return false;
        }

        @Override
        public boolean supportsPatternValues() {
          return false;
        }
      });
    }

    var validParameters = new ArrayList<>(parameters);
    addAvailableFacetFilters(validParameters);
    return validParameters;
  }

  private void addAvailableFacetFilters(final ArrayList<ISearchFilter> validParameters) {
    var destinationId = projectProvider.getDestinationId();
    var facetFilters = FACET_FILTERS_CACHE.get(projectProvider.getProject());
    if (facetFilters == null) {
      facetFilters = createFacetFilters(destinationId);
      FACET_FILTERS_CACHE.put(projectProvider.getProject(), facetFilters);
    }
    validParameters.addAll(facetFilters);
  }

  private List<ISearchFilter> createFacetFilters(final String destinationId) {
    var facetFilters = new ArrayList<ISearchFilter>();
    try {
      var facetProvider = FacetProviderFactory.getInstance(projectProvider.getProject(),
          new NullProgressMonitor());
      if (facetProvider.getApplicationComponentFacet() != null) {
        facetFilters.add(
            new FacetSearchFilter(facetProvider.getApplicationComponentFacet(), destinationId));
      }
      if (facetProvider.getCreatedYearFacet() != null) {
        facetFilters.add(new FacetSearchFilter(facetProvider.getCreatedYearFacet(), destinationId));
      }
      if (facetProvider.getCreatedMonthFacet() != null) {
        facetFilters
            .add(new FacetSearchFilter(facetProvider.getCreatedMonthFacet(), destinationId));
      }
      if (facetProvider.getCreatedFacet() != null) {
        facetFilters.add(new FacetSearchFilter(facetProvider.getCreatedFacet(), destinationId));
      }
    } catch (ServiceNotAvailableException | CoreException e) {
      e.printStackTrace();
    }
    return facetFilters;
  }

  private static class FacetSearchFilter implements ISearchFilter, ITextQueryProposalProvider {

    private final IFacet facet;
    private final String destinationId;

    public FacetSearchFilter(final IFacet facet, final String destinationId) {
      this.facet = facet;
      this.destinationId = destinationId;
    }

    @Override
    public String getDescription() {
      return facet.getName();
    }

    @Override
    public Image getImage() {
      return facet.getImage();
    }

    @Override
    public String getLabel() {
      return facet.getKey();
    }

    @Override
    public String getLongDescription() {
      return facet.getDescription();
    }

    @Override
    public boolean isBuffered() {
      return false;
    }

    @Override
    public boolean supportsMultipleValues() {
      return true;
    }

    @Override
    public boolean supportsNegatedValues() {
      return false;
    }

    @Override
    public boolean supportsPatternValues() {
      return false;
    }

    @Override
    public List<IContentProposal> getProposalList(final String query) throws CoreException {
      var service = facet.createNamedItemService(destinationId);
      var queryStr = query;
      if (queryStr == null) {
        queryStr = "*";
      } else if (!queryStr.endsWith("*")) {
        queryStr += "*";
      }
      var entryList = service.getNamedItemList(50, queryStr, null, null, new NullProgressMonitor());
      if (entryList != null) {
        var proposals = new ArrayList<IContentProposal>();
        for (var item : entryList.getNamedItem()) {
          proposals.add(new SearchFilterValueProposal(item.getName(), this, item.getDescription(),
              query, this));
        }
        return proposals;
      }
      return null;
    }
  }
}
