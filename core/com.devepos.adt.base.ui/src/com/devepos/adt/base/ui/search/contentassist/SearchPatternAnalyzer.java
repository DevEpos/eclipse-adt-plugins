package com.devepos.adt.base.ui.search.contentassist;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.ui.contentassist.ITextQueryProposalProvider;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.search.ISearchFilter;
import com.devepos.adt.base.ui.search.ISearchFilterProvider;
import com.devepos.adt.base.util.IStringConverter;
import com.devepos.adt.base.util.IValidator;
import com.devepos.adt.base.util.StringUtil;

/**
 * Analyzer for search patterns
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchPatternAnalyzer implements ISearchPatternAnalyzer {
  private static final String ANY_VALUE_CHAR = "*"; //$NON-NLS-1$

  private static final String ANY_WHITESPACE = "\\s*"; //$NON-NLS-1$
  private static final String EMPTY = ""; //$NON-NLS-1$
  private static final String FILTER_KEY_END = ":"; //$NON-NLS-1$
  private static final String KEY_VALUE_SEP = "="; //$NON-NLS-1$
  private static final String SOME_VALUE_CHAR = "+"; //$NON-NLS-1$
  private static final String SPACE = " "; //$NON-NLS-1$
  private static final String VALUE_LIST_SEP = ","; //$NON-NLS-1$
  private final ISearchFilterProvider filterHandler;
  private List<ISearchFilter> filters;
  private boolean isSearchTermAllowed;

  /**
   * Creates new search pattern analyzer instance
   *
   * @param filterHandler handler for retrieving search filters
   */
  private SearchPatternAnalyzer(final ISearchFilterProvider filterHandler) {
    this.filterHandler = filterHandler;
  }

  /*
   * Validates filter values
   */
  private class FilterValueValidator {
    private final ISearchFilter filter;
    private final String[] values;

    public FilterValueValidator(final ISearchFilter filter, final String[] filterValues) {
      values = filterValues;
      this.filter = filter;
    }

    public void runChecks() throws CoreException {
      checkMultipleValuesAllowed(filter, values);
      doFilterSpecificValidation(filter, values);
      checkNegatedValues(filter, values);
      checkPatternValues(filter, values);
      validateBufferedValues(filter, values);
    }

    private void checkMultipleValuesAllowed(final ISearchFilter filter, final String[] filterValues)
        throws CoreException {
      if (!filter.supportsMultipleValues() && filterValues.length > 1) {
        throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
            NLS.bind(Messages.SearchPatternAnalyzer_ErrorFilterAllowsOnlySingleValues_xmsg,
                filter.getLabel())));
      }
    }

    private void checkNegatedValues(final ISearchFilter filter, final String[] filterValues)
        throws CoreException {
      if (!filter.supportsNegatedValues()
          && Stream.of(filterValues).anyMatch(StringUtil::startsWithNegationCharacter)) {
        throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
            MessageFormat.format(
                Messages.SearchPatternAnalyzer_ErrorFilterDoesNotSupportNegation_xmsg,
                filter.getLabel())));
      }
    }

    private void checkPatternValues(final ISearchFilter filter, final String[] filterValues)
        throws CoreException {
      if (!filter.supportsPatternValues() && Stream.of(filterValues)
          .anyMatch(value -> value.contains(ANY_VALUE_CHAR) || value.contains(SOME_VALUE_CHAR))) {
        throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
            NLS.bind(Messages.SearchPatternAnalyzer_ErrorWildcardsNotSupportedInFilter_xmsg,
                filter.getLabel())));
      }
    }

    private void doFilterSpecificValidation(final ISearchFilter filter, final String[] filterValues)
        throws CoreException {
      IValidator filterValidator = null;
      if (filter instanceof IAdaptable) {
        filterValidator = ((IAdaptable) filter).getAdapter(IValidator.class);
      } else if (filter instanceof IValidator) {
        filterValidator = (IValidator) filter;
      }

      if (filterValidator != null && filterValidator != null) {
        for (final String value : filterValues) {
          filterValidator.validate(value);
        }
      }
    }

    private void validateBufferedValues(final ISearchFilter filter, final String[] filterValues)
        throws CoreException {
      if (!filter.isBuffered() || !(filter instanceof ITextQueryProposalProvider)) {
        return;
      }
      if (!filter.isBufferedValidationActive()) {
        return;
      }
      for (String value : filterValues) {
        if (filter.supportsPatternValues() && value.contains(ISearchFilter.WILDCARD)) {
          continue;
        }
        value = removeNegation(filter, value);
        final List<IContentProposal> proposalList = ((ITextQueryProposalProvider) filter)
            .getProposalList(value);
        if (!isValueInProposalList(proposalList, value)) {
          throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
              NLS.bind(Messages.SearchPatternAnalyzer_ErrorUnsupportedFilterValue_xmsg,
                  filter.getLabel(), value)));
        }
      }
    }
  }

  /**
   * Creates new search pattern analyzer instance
   *
   * @param filterHandler handler for retrieving search filters
   */
  public static ISearchPatternAnalyzer createAnalyzer(final ISearchFilterProvider filterHandler) {
    return new SearchPatternAnalyzer(filterHandler);
  }

  /*
   * Remove unnecessary spaces around filter end ":" and filter list separator ","
   * and filter key/value separator "="
   */
  private static String condense(final String content) {
    return condense(condense(condense(content, FILTER_KEY_END), VALUE_LIST_SEP), KEY_VALUE_SEP);
  }

  private static String condense(String content, final String by) {
    final String regex = ANY_WHITESPACE + by + "{1}" + ANY_WHITESPACE; //$NON-NLS-1$
    return content = content.replaceAll(regex, by);
  }

  /*
   * Retrieves the actual part of the query that should be used to determine the
   * proposals
   */
  private static String getStringToAnalyse(final String contents) {
    final String term = condense(contents) + "%"; //$NON-NLS-1$
    final String[] splits = term.split(SPACE);
    String lastPart = splits[splits.length - 1];
    lastPart = lastPart.trim();
    return lastPart;
  }

  /*
   * Removes any negation characters if the filter supports this
   */
  private static String removeNegation(final ISearchFilter filter, final String value) {
    if (filter.supportsNegatedValues()) {
      return StringUtil.removeNegationCharacter(value);
    }
    return value;
  }

  @Override
  public boolean isFilterProposal(final String query) {
    updateSearchFilters();
    final String lastPart = getStringToAnalyse(query);
    for (final ISearchFilter filter : filters) {
      if (lastPart.toLowerCase().startsWith(filter.getLabel() + FILTER_KEY_END)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String getCurrentFilterProposalQuery(String filterLabel, String query) {
    final String lastPart = getStringToAnalyse(query);
    final String filterStart = filterLabel + FILTER_KEY_END;
    final String queryToParse = lastPart.substring(filterStart.length());
    final String[] queryParts = queryToParse.split(VALUE_LIST_SEP);
    String currentQuery = queryParts[queryParts.length - 1];
    return currentQuery.substring(0, currentQuery.length() - 1);
  }

  @Override
  public ISearchFilter getFilterFromQuery(String query) {
    final String lastPart = getStringToAnalyse(query);
    for (final ISearchFilter searchFilter : filters) {
      if (!(searchFilter instanceof ITextQueryProposalProvider)) {
        continue;
      }
      final String filterStart = searchFilter.getLabel() + FILTER_KEY_END;
      if (lastPart.toLowerCase().startsWith(filterStart)) {
        return searchFilter;
      }
    }
    return null;
  }

  /**
   * Check the filters together with their values in the supplied
   * <code>searchPattern</code>
   *
   * @param searchPattern the pattern to analyze
   * @throws CoreException
   */
  @Override
  public void checkFilters(final String searchPattern) throws CoreException {
    updateSearchFilters();
    final String condensedPattern = condense(searchPattern);
    final String searchTerm = getSearchTerm(searchPattern);

    if (!isSearchTermAllowed && !searchTerm.isEmpty()) {
      final String errorMessage = NLS
          .bind(Messages.SearchPatternAnalyzer_ErrorInvalidSearchFilter_xmsg, searchTerm);
      throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, errorMessage));
    }

    // find the first invalid part in the search pattern
    for (final String part : condensedPattern.split(SPACE)) {
      if (!part.isEmpty() && !isFilter(part) && !part.equalsIgnoreCase(searchTerm)) {
        final String errorMessage = NLS
            .bind(Messages.SearchPatternAnalyzer_ErrorInvalidSearchFilter_xmsg, part);
        throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, errorMessage));
      }
    }
  }

  /**
   * Get content (list of values) of a certain filter out of the given search
   * pattern
   *
   * @param searchPattern the search pattern to analyze
   * @param filterKey     filter key which should be looked for in the
   *                      <code>searchPattern</code>
   * @return a list of filter values
   */
  @Override
  public List<String> getContent(final String searchPattern, final String filterKey) {
    final List<String> result = new ArrayList<>();
    updateSearchFilters();
    final String pattern = condense(searchPattern);
    final String filterKeyLower = filterKey.toLowerCase(Locale.ENGLISH);
    final List<String> filterSections = Stream.of(pattern.split(SPACE))
        .filter(p -> p.startsWith(filterKeyLower + FILTER_KEY_END))
        .collect(Collectors.toList());
    if (filterSections == null || filterSections.isEmpty()) {
      return result;
    }

    ISearchFilter filter = getFilterByKey(filterKeyLower);
    IStringConverter filterConverter = filter instanceof IAdaptable
        ? filterConverter = ((IAdaptable) filter).getAdapter(IStringConverter.class)
        : null;

    // collect filter values for a single filter in all found filter sections
    for (final String filterSection : filterSections) {
      List<String> rawFilterValues = Stream
          .of(filterSection.substring(filterKeyLower.length() + 1).split(VALUE_LIST_SEP))
          .filter(value -> !value.isEmpty())
          .collect(Collectors.toList());
      List<String> convertedFilterValues = null;

      if (filterConverter != null) {
        convertedFilterValues = rawFilterValues.stream()
            .map(filterVal -> filterConverter.convert(filterVal))
            .collect(Collectors.toList());
      } else {
        convertedFilterValues = rawFilterValues;
      }

      result.addAll(convertedFilterValues);
    }
    return result;
  }

  /**
   * Get proposal list of all relevant query filters. A filter is relevant for the
   * proposal list if the query part is empty or the filter starts with the same
   * string as the current content assist query
   *
   * @param query
   * @return
   */
  @Override
  public List<IContentProposal> getFilters(final String query) {
    final List<IContentProposal> filterProposals = new ArrayList<>();
    String lastPart = getStringToAnalyse(query);
    lastPart = lastPart.substring(0, lastPart.length() - 1);
    for (final ISearchFilter searchFilter : filters) {
      // no query part so every filter gets added to the proposal list
      if (lastPart.isEmpty()) {
        filterProposals
            .add(new SearchFilterProposal(searchFilter.getLabel(), searchFilter.getImage(),
                searchFilter.getDescription(), searchFilter.getLongDescription(), null,
                searchFilter instanceof ITextQueryProposalProvider));
      } else {
        if (searchFilter.getLabel().startsWith(lastPart)) {
          filterProposals
              .add(new SearchFilterProposal(searchFilter.getLabel(), searchFilter.getImage(),
                  searchFilter.getDescription(), searchFilter.getLongDescription(), lastPart,
                  searchFilter instanceof ITextQueryProposalProvider));
        }
      }
    }
    return filterProposals;
  }

  /**
   * Get a list of filter proposals from the given query string
   *
   * @param query the query String to analyze
   * @return List of filter proposals
   * @throws CoreException
   */
  @Override
  public List<IContentProposal> getFilterValueProposals(final String query) throws CoreException {
    List<IContentProposal> proposals = new ArrayList<>();
    final String lastPart = getStringToAnalyse(query);
    for (final ISearchFilter searchFilter : filters) {
      if (!(searchFilter instanceof ITextQueryProposalProvider)) {
        continue;
      }
      final String filterStart = searchFilter.getLabel() + FILTER_KEY_END;
      if (!lastPart.toLowerCase().startsWith(filterStart)) {
        continue;
      }
      final String queryToParse = lastPart.substring(filterStart.length());
      final String[] queryParts = queryToParse.split(VALUE_LIST_SEP);
      String currentQuery = queryParts[queryParts.length - 1];
      currentQuery = currentQuery.substring(0, currentQuery.length() - 1);
      // if the filter supports negated values the the negation char should be
      // excluded during the determination of relevant proposals
      currentQuery = removeNegation(searchFilter, currentQuery);
      proposals = ((ITextQueryProposalProvider) searchFilter).getProposalList(currentQuery);
    }
    return proposals;
  }

  /**
   * Retrieve proposals for the given query
   *
   * @param query the query String to be analyzed
   * @return the determined proposals
   * @throws CoreException
   */
  @Override
  public List<IContentProposal> getProposals(final String query) throws CoreException {
    List<IContentProposal> proposals = null;
    updateSearchFilters();
    // determine if the query to analyze is a filter
    if (isFilterProposal(query)) {
      proposals = getFilterValueProposals(query);
    } else {
      proposals = getFilters(query);
    }
    return proposals;
  }

  /**
   * Retrieve the search term out of the current pattern
   *
   * @param searchPattern the current search pattern to analyze
   * @return
   */
  @Override
  public String getSearchTerm(final String searchPattern) {
    updateSearchFilters();
    /*
     * exclude empty parts and parts that contain ":" characters as those will be
     * filters
     */
    return Stream.of(condense(searchPattern).split(SPACE))
        .filter(p -> !p.isEmpty() && !p.contains(FILTER_KEY_END))
        .findFirst()
        .orElse(EMPTY);
  }

  /**
   * Enables/Disables the occurrence of a none filter inside the search pattern
   *
   * @param allowSearchTermInPattern
   */
  @Override
  public void setIsSearchTermAllowed(final boolean allowSearchTermInPattern) {
    isSearchTermAllowed = allowSearchTermInPattern;
  }

  private boolean checkFilterValuesProvided(final String part, final ISearchFilter filter)
      throws CoreException {
    // Error -> only filter key + ":" supplied
    if (part.length() <= (filter.getLabel() + FILTER_KEY_END).length()) {
      throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, NLS.bind(
          Messages.SearchPatternAnalyzer_ErrorIncompleteSearchFilter_xmsg, filter.getLabel())));
    }

    final String filterValuesString = part.substring(filter.getLabel().length() + 1);
    // Error -> no filter values supplied
    if (filterValuesString.isEmpty()) {
      throw new CoreException(new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
          NLS.bind(Messages.SearchPatternAnalyzer_ErrorIncompleteSearchFilter_xmsg, part)));
    }

    new FilterValueValidator(filter, filterValuesString.split(VALUE_LIST_SEP)).runChecks();

    return true;
  }

  /*
   * Retrieves a filter instance for the given key
   */
  private ISearchFilter getFilterByKey(final String filterKey) {
    if (filters == null || filters.isEmpty()) {
      return null;
    }
    for (ISearchFilter filter : filters) {
      if (filter.getLabel().toLowerCase().equals(filterKey)) {
        return filter;
      }
    }
    return null;
  }

  private boolean isFilter(final String part) throws CoreException {
    if (filters != null) {
      for (final ISearchFilter filter : filters) {
        if (part.startsWith(filter.getLabel() + FILTER_KEY_END)
            && checkFilterValuesProvided(part, filter)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isValueInProposalList(final List<IContentProposal> proposalList,
      final String value) {
    return proposalList != null
        && proposalList.stream().anyMatch(proposal -> proposal.getLabel().equalsIgnoreCase(value));
  }

  private void updateSearchFilters() {
    if (filterHandler == null) {
      filters = new ArrayList<>();
      return;
    }
    filters = filterHandler.getFilters();
  }

}
