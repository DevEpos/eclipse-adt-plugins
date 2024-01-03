package com.devepos.adt.base.ui.contentassist;

import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.viewers.ILabelProvider;

/**
 * Interface that is the result of created content assist provider to a text
 * control. <br>
 * Provides the possibility to add a custom label provider, which is to be used
 * to display the found {@link IContentProposal}s
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IContentAssist {
  /**
   * Disposes of listeners and allocated resources
   */
  void dispose();

  /**
   * Sets a custom label provider which is to be used to display the content
   * proposals. <br>
   * If none is set the methods {@link IContentProposal#getLabel()} and/or
   * {@link IContentProposal#getContent()} will be shown and no Images
   *
   * @param labelProvider the label provider to be used to display the labels of
   *                      the content proposals
   */
  void setLabelProvider(final ILabelProvider labelProvider);

  /**
   * Set the integer style that indicates how an accepted proposal affects the
   * control's content.<br>
   * The default value is <code>PROPOSAL_REPLACE</code>.
   *
   * @param acceptance a constant indicating how an accepted proposal should
   *                   affect the control's content. Should be one of
   *                   <code>PROPOSAL_INSERT</code>,
   *                   <code>PROPOSAL_REPLACE</code> or
   *                   <code>PROPOSAL_IGNORE</code>
   *
   * @see {@link ContentProposalAdapter#PROPOSAL_IGNORE}
   * @see {@link ContentProposalAdapter#PROPOSAL_REPLACE}
   * @see {@link ContentProposalAdapter#PROPOSAL_INSERT}
   */
  void setProposalAcceptanceStyle(final int acceptance);
}
