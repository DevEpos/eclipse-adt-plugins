package com.devepos.adt.base.ui.search.contentassist;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.fieldassist.IContentProposal;

/**
 * Analyzer for search patterns
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface ISearchPatternAnalyzer {

  /**
   * Enables/Disables the occurrence of a none filter inside the search pattern
   *
   * @param allowSearchTermInPattern
   */
  void setIsSearchTermAllowed(final boolean allowSearchTermInPattern);

  /**
   * Retrieve the search term out of the current pattern
   *
   * @param searchPattern the current search pattern to analyze
   * @return
   */
  String getSearchTerm(final String searchPattern);

  /**
   * Retrieve proposals for the given query
   *
   * @param query the query String to be analyzed
   * @return the determined proposals
   * @throws CoreException
   */
  List<IContentProposal> getProposals(final String query) throws CoreException;

  /**
   * Get a list of filter proposals from the given query string
   *
   * @param query the query String to analyze
   * @return List of filter proposals
   * @throws CoreException
   */
  List<IContentProposal> getFilterValueProposals(final String query) throws CoreException;

  /**
   * Get proposal list of all relevant query filters. A filter is relevant for the
   * proposal list if the query part is empty or the filter starts with the same
   * string as the current content assist query
   *
   * @param query
   * @return
   */
  List<IContentProposal> getFilters(final String query);

  /**
   * Get content (list of values) of a certain filter out of the given search
   * pattern
   *
   * @param searchPattern the search pattern to analyze
   * @param filterKey     filter key which should be looked for in the
   *                      <code>searchPattern</code>
   * @return a list of filter values
   */
  List<String> getContent(final String searchPattern, final String filterKey);

  /**
   * Check the filters together with their values in the supplied
   * <code>searchPattern</code>
   *
   * @param searchPattern the pattern to analyze
   * @throws CoreException
   */
  void checkFilters(final String searchPattern) throws CoreException;

}
