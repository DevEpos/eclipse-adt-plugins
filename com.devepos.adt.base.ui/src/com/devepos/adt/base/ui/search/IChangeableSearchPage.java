package com.devepos.adt.base.ui.search;

import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchQuery;

/**
 * {@link ISearchPage} whose values can be changed after it was opened.
 *
 * @author stockbal
 *
 */
public interface IChangeableSearchPage<Q extends ISearchQuery> {
  /**
   * Sets control input from the given {@link ISearchQuery}.
   *
   * @param query a search query
   */
  void setInputFromSearchQuery(final Q query);
}
