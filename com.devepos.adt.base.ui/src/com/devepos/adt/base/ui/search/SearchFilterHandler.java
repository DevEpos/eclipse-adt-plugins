package com.devepos.adt.base.ui.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.search.contentassist.SearchFilterLabelProvider;
import com.devepos.adt.base.ui.search.contentassist.SearchPatternAnalyzer;
import com.devepos.adt.base.ui.search.contentassist.SearchPatternContentAssist;

/**
 * Provides search filter values that were entered in a text input
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFilterHandler {
  private SearchPatternContentAssist contentAssist;
  private final SearchPatternAnalyzer patternAnalyzer;
  private ISearchFilterProvider filterProvider;

  public SearchFilterHandler(final ISearchFilterProvider filterProvider) {
    patternAnalyzer = new SearchPatternAnalyzer(filterProvider);
    this.filterProvider = filterProvider;
  }

  public void enableSearchTermInput(final boolean enable) {
    patternAnalyzer.setIsSearchTermAllowed(enable);
  }

  /**
   * Adds content assistance to the given field. This provider currently supports
   * only one field
   *
   * @param input
   */
  public void addContentAssist(final Text input) {
    // TODO: decouple content assist completely from the provider
    if (contentAssist != null) {
      contentAssist.dispose();
      contentAssist = null;
    }
    contentAssist = new SearchPatternContentAssist(input, patternAnalyzer);
    contentAssist.setLabelProvider(new SearchFilterLabelProvider());
  }

  /**
   * Checks if the current search pattern is complete
   *
   * @param searchPattern the pattern to analyze
   * @throws CoreException
   */
  public void checkSearchFiltersComplete(final String searchPattern) throws CoreException {
    if (patternAnalyzer != null) {
      patternAnalyzer.checkFilters(searchPattern);
    }
  }

  /**
   * Retrieves a map of all valid filters in the given search pattern and their
   * entered values
   *
   * @param pattern
   * @return
   */
  public Map<String, Object> getSearchFilters(final String pattern,
      final Map<String, String> externalFilterNames) {
    final Map<String, Object> filterMap = new HashMap<>();
    final List<ISearchFilter> filters = filterProvider.getFilters();

    for (final ISearchFilter filter : filters) {
      String filterName = externalFilterNames != null ? externalFilterNames.get(filter.getLabel())
          : filter.getLabel();
      if (filterName == null) {
        filter.getLabel();
      }
      filterMap.put(filterName, getFilterValues(pattern, filter.getLabel()));

    }
    return filterMap;
  }

  /**
   * Retrieves the search term from the the given <code>searchPattern</code>
   *
   * @param searchPattern the pattern to analyze
   * @return
   */
  public String getSearchTerm(final String searchPattern) {
    if (patternAnalyzer != null) {
      return patternAnalyzer.getSearchTerm(searchPattern);
    }
    return searchPattern;
  }

  private List<String> getFilterValues(final String pattern, final String filterName) {
    if (patternAnalyzer != null) {
      return patternAnalyzer.getContent(pattern, filterName);
    }
    return new ArrayList<>();
  }

  /**
   * Dispose of all allocated resources
   */
  public void dispose() {
    if (contentAssist != null) {
      contentAssist.dispose();
    }
  }
}
