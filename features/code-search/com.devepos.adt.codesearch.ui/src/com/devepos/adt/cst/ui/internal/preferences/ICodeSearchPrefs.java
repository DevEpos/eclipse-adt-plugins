package com.devepos.adt.cst.ui.internal.preferences;

/**
 * Preference Id's for ABAP Code Search
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface ICodeSearchPrefs {
  /**
   * Maximum number of jobs when using the client based Code Search
   */
  String MAX_CLIENT_SEARCH_JOBS = "codeSearch.clientBasedSearch.maxJobs";
  /**
   * Settings to prioritize the ADT client based search over the backend one
   */
  String PREFER_CLIENT_BASED_SEARCH = "codeSearch.clientBasedSearch.prefer";
  /**
   * Removes the limit on the maximum number of objects that are searched
   */
  String ALL_OBJECTS_ENABLED = "codeSearch.searchAllObjectsEnabled";
  /**
   * Maximum objects that will be selected during the Code Search
   */
  String MAX_OBJECTS = "codeSearch.maxObjects";
  /**
   * Concatenates lines of the search pattern with \n if single pattern mode and regular expressions
   * are active
   */
  String SINGLE_PATTERN_REGEX_CONCAT_WITH_LF = "codeSearch.singlePattern.regex.concatPatternLinesWithLf";
  /**
   * Setting to remember the include settings for class/function group/program for next dialog call
   */
  String REMEMBER_INCLUDE_SETTINGS = "codeSearch.rememberIncludeSettings";
  /**
   * Marker sequence value to mark Code search matches in a file export
   */
  String CSV_EXPORT_MATCH_MARKER_SEQUENCE = "codeSearch.exportDialog.matchMarkerSequence";
  /**
   * Flag to indicate if a marker sequence should be used to mark the search pattern in a file
   * export
   */
  String CSV_EXPORT_USE_MATCH_MARKER = "codeSearch.exportDialog.useMatchMarker";
  /**
   * Delimiter for csv data export
   */
  String CSV_EXPORT_DELIMITER = "codeSearch.exportDialog.delimiter";
  /**
   * Flag to indicate that only requests of logged on user should be considered
   */
  String TR_FILTER_ONLY_MY_OBJECTS = "codeSearch.trFilter.restrictToMyObjects";
  /**
   * Flag to indicate that modifiable requests/tasks should be included in result
   */
  String TR_FILTER_INCLUDE_MODIFIABLE = "codeSearch.trFilter.includeModifiable";
  /**
   * Flag to indicate that released requests/tasks should be included in result
   */
  String TR_FILTER_INCLUDE_RELEASED = "codeSearch.trFilter.includeReleased";
  /**
   * Setting to restrict result to released requests/tasks by fixed dates
   */
  String TR_FILTER_RELEASED_DATE = "codeSearch.trFilter.releasedDate";
}
