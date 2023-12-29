package com.devepos.adt.base.ui.internal.search;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.swt.widgets.Shell;

import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.dialogs.SearchSelectionDialog;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.contentassist.SearchFilterLabelProvider;
import com.devepos.adt.base.util.StringUtil;

public class QuickSearchSelectionDialog extends SearchSelectionDialog<IContentProposal, String> {

  private ISearchFilter searchFilter;
  private ITextQueryProposalProvider proposalProvider;

  public QuickSearchSelectionDialog(Shell parent, boolean multi, String query,
      ISearchFilter searchFilter, ITextQueryProposalProvider proposalProvider) {
    super(parent, multi);
    setTitle(String.format("Select values for Filter \"%s\"", searchFilter.getDescription()));
    setFilterLabel("&Enter search string and / or filter criteria");
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

  @Override
  protected IDialogSettings getDialogSettings() {
    return AdtBaseUIPlugin.getDefault()
        .getDialogSettingsSection(QuickSearchSelectionDialog.class.getCanonicalName());
  }

  @Override
  protected boolean matchesFilter(IContentProposal result, String filter) {
    return true;
  }

  @Override
  protected SearchSelectionDialog<IContentProposal, String>.SearchResultObject performSearch(
      String filter, IProgressMonitor monitor) throws CoreException {
    var proposals = proposalProvider.getProposalList(filter);
    if (proposals != null && !proposals.isEmpty()) {
      var isComplete = true;
      if (proposals.size() > 50) {
        proposals.remove(50);
        isComplete = false;
      }
      return new SearchResultObject(proposals, isComplete);
    }
    return new SearchResultObject(new ArrayList<>(), true);
  }

}
