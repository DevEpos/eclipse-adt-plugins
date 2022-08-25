package com.devepos.adt.base.ui.internal.nameditem;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.internal.contentassist.ProposalContentStyle;

/**
 * Proposal provider for named items.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class NamedItemProposalProvider implements ITextQueryProposalProvider {

  private InternalNamedItemProposalProvider namedItemProposalProvider;

  public NamedItemProposalProvider(final Text text, final IAbapProjectProvider projectProvider,
      final IAdtUriTemplateProvider uriTemplateProvider, final INamedItemType namedItemType,
      final String initialQuery) {
    namedItemProposalProvider = new InternalNamedItemProposalProvider(projectProvider,
        uriTemplateProvider, namedItemType, initialQuery);
  }

  @Override
  public List<IContentProposal> getProposalList(final String query) throws CoreException {
    return namedItemProposalProvider.getProposals(query);
  }

  /**
   * @see {@link InternalNamedItemProposalProvider#setProposalContentStyle(ProposalContentStyle)}
   */
  public void setProposalContentStyle(final ProposalContentStyle proposalContentStyle) {
    namedItemProposalProvider.setProposalContentStyle(proposalContentStyle);
  }
}
