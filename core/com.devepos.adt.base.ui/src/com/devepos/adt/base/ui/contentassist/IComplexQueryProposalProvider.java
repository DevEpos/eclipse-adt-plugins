package com.devepos.adt.base.ui.contentassist;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.fieldassist.IContentProposal;

import com.devepos.adt.base.ui.search.SearchFilterHandler;

/**
 * Proposal provider for complex queries (i.e. queries that contain
 * 
 * @author Ludwig Stockbauer-Muhr
 */
public interface IComplexQueryProposalProvider {

  /**
   * Returns filter handler to handle a complex text query
   * 
   * @return
   */
  SearchFilterHandler getComplexQueryFilterHandler();

  /**
   * Retrieves a list of filter proposals for the given complex query string
   *
   * @param query the query String for which search filters should be retrieved
   * @return a List of search filter proposals
   * @throws CoreException
   */
  List<IContentProposal> getComplexProposalList(final String query) throws CoreException;
}
