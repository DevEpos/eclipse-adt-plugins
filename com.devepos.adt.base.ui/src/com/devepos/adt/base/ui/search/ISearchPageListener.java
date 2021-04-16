package com.devepos.adt.base.ui.search;

import org.eclipse.search.ui.ISearchPage;

/**
 * Listener to be notified if a SearchPage in the eclipse SearchDialog was
 * opened
 *
 * @author stockbal
 *
 */
public interface ISearchPageListener {

    /**
     * Notification that the search page was opened
     *
     * @param searchPage the current page
     */
    void pageOpened(ISearchPage searchPage);
}
