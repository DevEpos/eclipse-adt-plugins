package com.devepos.adt.base.ui.internal.search;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.StringFilterPart;
import com.devepos.adt.base.ui.contentassist.IComplexQueryProposalProvider;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.dialogs.SearchSelectionDialog;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.contentassist.SearchFilterLabelProvider;
import com.devepos.adt.base.ui.util.TextControlUtil;
import com.devepos.adt.base.util.StringUtil;

public class SearchFilterValueSelectionDialog
    extends SearchSelectionDialog<IContentProposal, String> {

  private ISearchFilter searchFilter;
  private IComplexQueryProposalProvider complexQueryProposalProvider;
  private ITextQueryProposalProvider proposalProvider;
  private boolean negationActive;

  public SearchFilterValueSelectionDialog(Shell parent, boolean multi, String query,
      ISearchFilter searchFilter, ITextQueryProposalProvider proposalProvider) {
    super(parent, searchFilter.supportsMultipleValues());
    setTitle(String.format(Messages.SearchFilterValueSelectionDialog_DialogTitle_xtit,
        searchFilter.getDescription()));

    complexQueryProposalProvider = Adapters.adapt(searchFilter,
        IComplexQueryProposalProvider.class);

    StringFilterPart filterPart = null;
    if (complexQueryProposalProvider != null) {
      filterPart = new ContentAssistFilterPart();
    } else {
      filterPart = new StringFilterPart(
          Messages.SearchFilterValueSelectionDialog_SimpleFilterLabel_xlbl);
    }
    setFilterViewPart(filterPart);
    setResultLabelProvider(new DelegatingStyledCellLabelProvider(new SearchFilterLabelProvider()));
    setDetailsLabelProvider(new SearchFilterLabelProvider(true));
    if (!StringUtil.isEmpty(query)) {
      setInitialFilter(query);
    } else if (!searchFilter.isBuffered()) {
      setStartupSearchWithNullFilterDisabled(true);
    }
    if (searchFilter.isBuffered()) {
      setJobDelay(300);
      setInitialJobDelay(0);
    }

    this.searchFilter = searchFilter;
    this.proposalProvider = proposalProvider;
  }

  /**
   * @return {@code true} if proposal negation was activated
   */
  public boolean isNegated() {
    return negationActive;
  }

  @Override
  protected void createContentsBeforeStatusLine(Composite parent) {
    if (!searchFilter.supportsNegatedValues()) {
      return;
    }
    var negationActiveCheck = new Button(parent, SWT.CHECK);
    negationActiveCheck.setText(Messages.SearchFilterValueSelectionDialog_Negation_xchk);
    negationActiveCheck.addSelectionListener(
        widgetSelectedAdapter(e -> negationActive = negationActiveCheck.getSelection()));
  }

  @Override
  protected IDialogSettings getDialogSettings() {
    return AdtBaseUIPlugin.getDefault()
        .getDialogSettingsSection(SearchFilterValueSelectionDialog.class.getCanonicalName());
  }

  @Override
  protected boolean matchesFilter(IContentProposal result, String filter) {
    return true;
  }

  @Override
  protected SearchSelectionDialog<IContentProposal, String>.SearchResultObject performSearch(
      String filter, IProgressMonitor monitor) throws CoreException {
    List<IContentProposal> proposals = null;
    if (complexQueryProposalProvider != null) {
      complexQueryProposalProvider.getComplexQueryFilterHandler()
          .checkSearchFiltersComplete(filter);
      proposals = complexQueryProposalProvider.getComplexProposalList(filter);
    } else {
      proposals = proposalProvider.getProposalList(filter);
    }

    if (proposals != null && !proposals.isEmpty()) {
      var isComplete = true;
      if (proposals.size() > 50 && proposals.size() < 52) {
        proposals.remove(50);
        isComplete = false;
      }
      return new SearchResultObject(proposals, isComplete);
    }
    return new SearchResultObject(new ArrayList<>(), true);
  }

  private class ContentAssistFilterPart extends StringFilterPart {

    public ContentAssistFilterPart() {
      super(Messages.SearchFilterValueSelectionDialog_ComplexFilterLabel_xlbl);
    }

    @Override
    public void createUI(Composite parent) {
      super.createUI(parent);
      var filterText = ((Text) getFilterControls()[0]);
      TextControlUtil.addWordSupport(filterText);
      complexQueryProposalProvider.getComplexQueryFilterHandler().addContentAssist(filterText);

      filterText.addDisposeListener(e -> {
        complexQueryProposalProvider.getComplexQueryFilterHandler().dispose();
      });
    }
  }

}
