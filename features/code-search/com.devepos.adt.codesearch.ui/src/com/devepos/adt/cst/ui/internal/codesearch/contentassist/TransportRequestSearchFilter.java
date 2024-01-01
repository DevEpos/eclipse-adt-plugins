package com.devepos.adt.cst.ui.internal.codesearch.contentassist;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItem;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IImageProvider;
import com.devepos.adt.base.ui.contentassist.IComplexQueryProposalProvider;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.ISearchFilterProvider;
import com.devepos.adt.base.ui.search.SearchFilterHandler;
import com.devepos.adt.base.ui.search.contentassist.DateSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.FixedNamedItemSearchFilter;
import com.devepos.adt.base.ui.search.contentassist.NamedItemFilter;
import com.devepos.adt.base.ui.search.contentassist.UserSearchFilter;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.IImages;
import com.devepos.adt.cst.ui.internal.codesearch.FilterName;
import com.devepos.adt.cst.ui.internal.codesearch.NamedItem;
import com.devepos.adt.cst.ui.internal.messages.Messages;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;

/**
 * Search filter for transport request/task
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class TransportRequestSearchFilter extends NamedItemFilter
    implements ITextQueryProposalProvider, IComplexQueryProposalProvider {

  private static final String KEY_VALUE_FORMAT = "%s=%s";//$NON-NLS-1$
  private static final String REQUEST_STATUS_MODIFIABLE = "modifiable"; //$NON-NLS-1$
  private static final String REQUEST_STATUS_RELEASED = "released"; //$NON-NLS-1$
  private static final String CUSTOM_FILTER_MARKER = "customFilter=true"; //$NON-NLS-1$

  private SearchFilterHandler detailFilterHandler;
  private final IAbapProjectProvider projectProvider;
  private final IAdtUriTemplateProvider uriTemplateProvider;
  private String predefinedDataFilter;

  public TransportRequestSearchFilter(final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final INamedItemType namedItemType) {
    super(projectProvider, uriTemplateProvider, namedItemType,
        FilterName.TRANSPORT_REQUEST.getContentAssistName(), (String) null);
    setProposalImageProvider(new TransportProposalImageProvider());
    setDescription(Messages.SearchFilters_transportRequestFilterShortDescription_xmsg);
    setLongDescription(
        MessageFormat.format(Messages.SearchFilters_transportRequestFilterDescription_xmsg,
            FilterName.TRANSPORT_REQUEST.getContentAssistName(), "a4hk903065")); //$NON-NLS-1$
    setSupportsMultipleValues(true);
    setSupportsPatternValues(true);
    setComplexQueryProposalProvider(this);
    this.projectProvider = projectProvider;
    this.uriTemplateProvider = uriTemplateProvider;
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    if (predefinedDataFilter == null) {
      var filters = new ArrayList<String>();
      filters.add(CUSTOM_FILTER_MARKER);

      var prefStore = CodeSearchUIPlugin.getDefault().getPreferenceStore();
      if (prefStore.getBoolean(ICodeSearchPrefs.TR_FILTER_ONLY_MY_OBJECTS)) {
        filters.add(String.format(KEY_VALUE_FORMAT, FilterName.TR_OWNER.getContentAssistName(),
            UserSearchFilter.LOGGED_ON_USER));
      }
      var statusValues = new ArrayList<String>();
      if (prefStore.getBoolean(ICodeSearchPrefs.TR_FILTER_INCLUDE_RELEASED)) {
        statusValues.add(REQUEST_STATUS_RELEASED);
        filters
            .add(String.format(KEY_VALUE_FORMAT, FilterName.TR_CHANGED_DATE.getContentAssistName(),
                prefStore.getString(ICodeSearchPrefs.TR_FILTER_RELEASED_DATE)));
      }
      if (prefStore.getBoolean(ICodeSearchPrefs.TR_FILTER_INCLUDE_MODIFIABLE)) {
        statusValues.add(REQUEST_STATUS_MODIFIABLE);
      }
      filters.add(String.format(KEY_VALUE_FORMAT, FilterName.TR_STATUS.getContentAssistName(),
          String.join(",", statusValues))); //$NON-NLS-1$
      predefinedDataFilter = String.join(INamedItem.DATA_SPLIT_MARKER, filters);
    }
    return getProposalList(query, predefinedDataFilter);
  }

  @Override
  public SearchFilterHandler getComplexQueryFilterHandler() {
    if (detailFilterHandler == null) {
      detailFilterHandler = new SearchFilterHandler(new ISearchFilterProvider() {
        private List<ISearchFilter> detailFilters;

        @Override
        public List<ISearchFilter> getFilters() {
          if (detailFilters == null) {
            detailFilters = new ArrayList<>();
            detailFilters.add(
                new UserSearchFilter(projectProvider, FilterName.TR_OWNER.getContentAssistName(),
                    Messages.CodeSearchScopeFilters_ownerFilterShortDescription_xmsg, null));
            detailFilters
                .add(new DateSearchFilter(FilterName.TR_CHANGED_DATE.getContentAssistName(),
                    Messages.TransportRequestSearchFilter_ChangedDateFilterName_xlbl,
                    MessageFormat.format(
                        Messages.TransportRequestSearchFilter_ChangedDateFilterDescription_xmsg,
                        FilterName.TR_CHANGED_DATE.getContentAssistName()),
                    null));
            detailFilters.add(getTypeFilter());
            detailFilters
                .add(new FixedNamedItemSearchFilter(FilterName.TR_STATUS.getContentAssistName(),
                    Messages.TransportRequestSearchFilter_RequestStatusFilterName_xlbl,
                    MessageFormat.format(
                        Messages.TransportRequestSearchFilter_RequestStatusFilterDescription_xmsg,
                        FilterName.TR_STATUS.getContentAssistName()),
                    CodeSearchUIPlugin.getDefault().getImage(IImages.STATUS), false, false,
                    Arrays.asList(
                        INamedItem.createNamedItem(REQUEST_STATUS_MODIFIABLE,
                            Messages.TransportRequestSearchFilter_ModifiableStatus, null),
                        INamedItem.createNamedItem(REQUEST_STATUS_RELEASED,
                            Messages.TransportRequestSearchFilter_ReleasedStatus, null))));
          }
          return detailFilters;
        }

        private ISearchFilter getTypeFilter() {
          var typeFilter = new NamedItemFilter(projectProvider, uriTemplateProvider,
              NamedItem.TRANSPORT_REQ_TYPE, FilterName.TR_TYPE.getContentAssistName(), WILDCARD);
          typeFilter.setDescription(Messages.TransportRequestSearchFilter_TypeFilterName_xlbl);
          typeFilter.setSupportsPatternValues(false);
          typeFilter.setLongDescription(Messages.TransportRequestSearchFilter_TypeFilterName_xmsg);
          typeFilter.setProposalImageProvider(
              () -> AdtBaseUIResources.getImage(IAdtBaseImages.TYPE_GROUP));
          return typeFilter;
        }
      });
      detailFilterHandler.enableSearchTermInput(true);
    }
    return detailFilterHandler;
  }

  @Override
  public List<IContentProposal> getComplexProposalList(final String query) throws CoreException {
    if (!projectProvider.ensureLoggedOn()) {
      return null;
    }
    var filters = detailFilterHandler.getSearchFiltersAsStringMap(query, null, ","); //$NON-NLS-1$

    return getProposalList(detailFilterHandler.getSearchTerm(query),
        filters.keySet()
            .stream()
            .reduce("", (a, e) -> (!a.isEmpty() ? a + INamedItem.DATA_SPLIT_MARKER : a) //$NON-NLS-1$
                + String.format(KEY_VALUE_FORMAT, e, filters.get(e))));
  }

  private static class TransportProposalImageProvider implements IImageProvider {
    private static final String IS_TASK_MARKER = "isTask="; //$NON-NLS-1$
    private static final String IS_RELEASED_MARKER = "isReleased="; //$NON-NLS-1$

    @Override
    public Image getImage() {
      return CodeSearchUIPlugin.getDefault().getImage(IImages.TRANSPORT_REQUEST);
    }

    @Override
    public Image getImage(final Object data) {
      if (!(data instanceof INamedItem)) {
        return null;
      }
      var namedItem = (INamedItem) data;
      if (namedItem.getData() == null) {
        return null;
      }
      var dataEntries = namedItem.getData().split(INamedItem.DATA_SPLIT_MARKER);
      var isTask = false;
      var isReleased = false;
      for (var entry : dataEntries) {
        if (entry.startsWith(IS_TASK_MARKER)) {
          isTask = Boolean.parseBoolean(entry.split(IS_TASK_MARKER)[1]);
        } else if (entry.startsWith(IS_RELEASED_MARKER)) {
          isReleased = Boolean.parseBoolean(entry.split(IS_RELEASED_MARKER)[1]);
        }
      }
      String imageId = null;
      if (isTask) {
        imageId = isReleased ? IImages.TRANSPORT_TASK_RELEASED : IImages.TRANSPORT_TASK;
      } else {
        imageId = isReleased ? IImages.TRANSPORT_REQUEST_RELEASED : IImages.TRANSPORT_REQUEST;
      }
      return imageId != null ? CodeSearchUIPlugin.getDefault().getImage(imageId) : null;
    }
  }
}