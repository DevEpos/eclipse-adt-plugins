package com.devepos.adt.base.ui.search.contentassist;

import java.util.List;

import org.eclipse.jface.fieldassist.IContentProposal;

/**
 * Handler to signal content changes
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IContentChangeListener {

  /**
   * Notify subscribers of the content change
   *
   * @param resultList the list of updated content proposals
   */
  void notifyContentChange(List<IContentProposal> resultList);
}
