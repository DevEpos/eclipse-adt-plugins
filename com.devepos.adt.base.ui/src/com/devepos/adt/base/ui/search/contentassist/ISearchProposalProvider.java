package com.devepos.adt.base.ui.search.contentassist;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.fieldassist.IContentProposal;

/**
 * Provider for search proposals
 *
 * @author stockbal
 *
 */
public interface ISearchProposalProvider {
  /**
   * Retrieves a list of filter proposals for the given query string
   *
   * @param query the query String for which search filters should be retrieved
   * @return a List of search filter proposals
   * @throws CoreException
   */
  List<IContentProposal> getProposalList(final String query) throws CoreException;
}
