package com.devepos.adt.cst.ui.internal.codesearch.client;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.ISearchFilterProvider;
import com.devepos.adt.base.ui.search.contentassist.PackageSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.SearchFilterValueProposal;
import com.devepos.adt.base.ui.search.contentassist.UserSearchFilter;
import com.devepos.adt.base.util.IValidator;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
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
      parameters.add(new ObjectTypeSearchFilter(projectProvider, true));
      parameters.add(new UserSearchFilter(projectProvider, FilterName.OWNER.getContentAssistName(),
          Messages.CodeSearchScopeFilters_ownerFilterShortDescription_xmsg, null, false));
      parameters.add(new PackageSearchFilter(projectProvider) {
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
      facetProvider.getFacets().forEach(facet -> {
        if (facet.getKey().equals(FilterName.SOFTWARE_COMPONENT.getContentAssistName())) {
          facetFilters.add(new FacetSearchFilter(facet, destinationId, null));
        } else if (facet.getKey().equals(FilterName.APPLICATION_COMPONENT.getContentAssistName())) {
          facetFilters.add(new FacetSearchFilter(facet, destinationId, null));
        } else if (facet.getKey().equals(FilterName.CREATED_FACET_DATE.getContentAssistName())) {
          facetFilters.add(createDateFacetFilter(destinationId, facet, val -> {
            var dateStr = StringUtil.removeNegationCharacter((String) val);
            createDateRegexValidator("[1-9]\\d{3}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|30|31)",
                "%s is not a date pattern (e.g. 20250515)").validate(dateStr);

            // check if the pattern is a valid date (e.g. 20230230)
            var year = Integer.parseInt(dateStr.substring(0, 4));
            var month = Integer.parseInt(dateStr.substring(4, 6));
            var day = Integer.parseInt(dateStr.substring(6, 8));
            try {
              LocalDate.of(year, month, day);
            } catch (DateTimeException e) {
              throw new CoreException(new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID,
                  String.format("%d/%d/%d is not a valid date", year, month, day)));
            }
          }));
        } else if (facet.getKey().equals(FilterName.CREATED_FACET_MONTH.getContentAssistName())) {
          facetFilters.add(createDateFacetFilter(destinationId, facet, "(0[1-9]|1[0-2])",
              "%s is not a valid month (e.g. 05)"));
        } else if (facet.getKey().equals(FilterName.CREATED_FACET_YEAR.getContentAssistName())) {
          facetFilters.add(createDateFacetFilter(destinationId, facet, "(19\\d{2}|2\\d{3})",
              "%s is not a valid year (e.g. 2025)"));
        }
      });
    } catch (ServiceNotAvailableException | CoreException e) {
      e.printStackTrace();
    }
    return facetFilters;
  }

  private ISearchFilter createDateFacetFilter(final String destinationId, final IFacet facet,
      final IValidator validator) {
    return new FacetSearchFilter(facet, destinationId, validator);
  }

  private ISearchFilter createDateFacetFilter(final String destinationId, final IFacet facet,
      final String validationPattern, final String validationErrMsg) {
    return new FacetSearchFilter(facet, destinationId,
        createDateRegexValidator(validationPattern, validationErrMsg));
  }

  private IValidator createDateRegexValidator(final String pattern, final String message) {
    return value -> {
      value = StringUtil.removeNegationCharacter((String) value);
      if (!Pattern.matches(pattern, String.valueOf(value))) {
        throw new CoreException(
            new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID, String.format(message, value)));
      }
    };
  }

  private static class FacetSearchFilter
      implements ISearchFilter, ITextQueryProposalProvider, IValidator {

    private final IFacet facet;
    private final String destinationId;
    private final IValidator validator;

    public FacetSearchFilter(final IFacet facet, final String destinationId,
        final IValidator validator) {
      this.facet = facet;
      this.destinationId = destinationId;
      this.validator = validator;
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
      return true;
    }

    @Override
    public boolean supportsPatternValues() {
      return false;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
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
      if (entryList != null && !entryList.getNamedItem().isEmpty()) {
        var proposals = new ArrayList<IContentProposal>();
        for (var item : entryList.getNamedItem()) {
          proposals.add(new SearchFilterValueProposal(item.getName(), this, item.getDescription(),
              query, this));
        }
        Collections.sort((List) proposals);
        return proposals;
      }
      return null;
    }

    @Override
    public void validate(final Object value) throws CoreException {
      if (validator != null) {
        validator.validate(value);
      }
    }
  }
}
