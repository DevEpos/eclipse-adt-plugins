package com.devepos.adt.base.ui.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.search.ui.ISearchPage;

/**
 * Utility for working with {@link ISearchPage}s
 *
 * @author stockbal
 *
 */
public class SearchPageUtil {
  private static final List<ISearchPageListener> searchPageOpenListeners = new ArrayList<>();

  /**
   * Adds search page open listener
   *
   * @param l listener to be added
   */
  public static void addSearchPageOpenListener(final ISearchPageListener l) {
    searchPageOpenListeners.add(l);
  }

  /**
   * Notifies the current list of {@link ISearchPageListener}s that the given
   * {@code searchPage} was opened. <br/>
   * After the listeners have been notified they are removed from the internal
   * registry.
   *
   * @param searchPage the search page that was opened
   */
  public static void notifySearchPageListeners(final ISearchPage searchPage) {
    if (searchPageOpenListeners.isEmpty()) {
      return;
    }
    ISearchPageListener[] copiedListeners = searchPageOpenListeners.toArray(
        new ISearchPageListener[searchPageOpenListeners.size()]);
    searchPageOpenListeners.clear();
    for (ISearchPageListener l : copiedListeners) {
      l.pageOpened(searchPage);
    }
  }

  /**
   * Removes the given listener
   *
   * @param l listener to be removed
   */
  public static void removeSearchPageOpenListener(final ISearchPageListener l) {
    searchPageOpenListeners.remove(l);
  }
}
