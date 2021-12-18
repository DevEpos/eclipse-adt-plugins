package com.devepos.adt.base.ui.search;

import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultPage;

/**
 * Extension to {@link ISearchResultPage}
 *
 * @author stock
 *
 * @see {@link IChangeableSearchPage}
 *
 */
public interface ISearchResultPageExtension<Q extends ISearchQuery> {

  /**
   * Returns the query which was used to fill the {@link ISearchResult} of the
   * page
   *
   * @return the query which was used to fill the {@link ISearchResult} of the
   *         page
   */
  Q getSearchQuery();

  /**
   * Returns the Id for the corresponding {@link ISearchPage} in the search dialog
   *
   * @return id of search page
   */
  String getSearchPageId();
}
