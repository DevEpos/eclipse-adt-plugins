package com.devepos.adt.base.ui.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.contentassist.ContentAssistSupport;
import com.devepos.adt.base.ui.contentassist.IContentAssist;
import com.devepos.adt.base.ui.search.contentassist.ISearchPatternAnalyzer;
import com.devepos.adt.base.ui.search.contentassist.SearchPatternAnalyzer;

/**
 * Provides search filter values that were entered in a text input
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFilterHandler {
  private IContentAssist contentAssist;
  private final ISearchPatternAnalyzer patternAnalyzer;
  private final ISearchFilterProvider filterProvider;

  public SearchFilterHandler(final ISearchFilterProvider filterProvider) {
    patternAnalyzer = SearchPatternAnalyzer.createAnalyzer(filterProvider);
    this.filterProvider = filterProvider;
  }

  /**
   * Adds content assistance to the given field. This provider currently supports
   * only one field
   *
   * @param input the text control which should get the content assist
   */
  public void addContentAssist(final Text input) {
    if (contentAssist != null) {
      contentAssist.dispose();
    }
    contentAssist = ContentAssistSupport.createSearchFilterContentAssist(input, patternAnalyzer);
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
   * Dispose of all allocated resources
   */
  public void dispose() {
    if (contentAssist != null) {
      contentAssist.dispose();
    }
  }

  public void enableSearchTermInput(final boolean enable) {
    patternAnalyzer.setIsSearchTermAllowed(enable);
  }

  /**
   * Retrieves a map of all valid filters in the given search pattern and their
   * entered values. <br>
   * Multiple values of the same filter will be concatenated
   *
   * @param pattern             the search pattern that should be parsed
   * @param externalFilterNames a map of optional mappings between internal an
   *                            external filter names
   * @return a map of the found filters with their values
   */
  public Map<String, Object> getSearchFiltersAsListMap(final String pattern,
      final Map<String, String> externalFilterNames) {
    return getSearchFilters(pattern, externalFilterNames, filterValues -> filterValues);
  }

  /**
   * Retrieves a map of all valid filters in the given search pattern and their
   * entered values.<br>
   * Multiple values of the same filter will be concatenated into a single String
   * using the given <code>delimiter</code>
   *
   * @param pattern             the search pattern that should be parsed
   * @param externalFilterNames a map of optional mappings between internal an
   *                            external filter names
   * @param delimiter           the delimiter to be used for joining multiple
   *                            values of a single filter together
   * @return a map of the found filters with their values
   */
  public Map<String, Object> getSearchFiltersAsStringMap(final String pattern,
      final Map<String, String> externalFilterNames, final CharSequence delimiter) {
    if (delimiter == null) {
      throw new IllegalArgumentException("Parameter 'delimiter' must not be null!");
    }
    return getSearchFilters(pattern, externalFilterNames, filterValues -> filterValues.stream()
        .collect(Collectors.joining(delimiter)));
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

  /*
   * Creates a map of the search filters and their values from the given search
   * pattern. The 'filterValueCollector' will be used for aggregation of the
   * values of a single filter
   */
  private Map<String, Object> getSearchFilters(final String pattern,
      final Map<String, String> externalFilterNames,
      final Function<List<String>, Object> filterValueCollector) {
    if (filterValueCollector == null) {
      throw new IllegalArgumentException("Parameter 'filterValueCollector' must not be null!");
    }
    final Map<String, Object> filterMap = new HashMap<>();
    final List<ISearchFilter> filters = filterProvider.getFilters();

    for (final ISearchFilter filter : filters) {
      String filterName = externalFilterNames != null ? externalFilterNames.get(filter.getLabel())
          : filter.getLabel();
      if (filterName == null) {
        filterName = filter.getLabel();
      }
      List<String> filterValues = getFilterValues(pattern, filter.getLabel());
      if (filterValues != null && !filterValues.isEmpty()) {
        filterMap.put(filterName, filterValueCollector.apply(filterValues));
      }
    }
    return filterMap;
  }
}
