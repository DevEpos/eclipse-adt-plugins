package com.devepos.adt.base.util;

import java.util.regex.Pattern;

/**
 * Utility for common String tasks
 *
 * @author stockbal
 */
public class StringUtil {
  public static final String NEGATION1 = "!"; //$NON-NLS-1$

  /**
   * Checks if {@code value} equals {@code value2}
   *
   * @param value  a String value
   * @param value2 another String value
   * @return {@code true} if both strings are equal
   */
  public static boolean equals(final String value, final String value2) {
    if (value == null && value2 == null) {
      return true;
    }
    if (value == null || value2 == null) {
      return false;
    }
    return value.equals(value2);
  }

  /**
   * Compiles pattern for the given query string
   *
   * @param query the query to compile into Pattern
   * @return
   */
  public static Pattern getPatternForQuery(final String query) {
    return getPatternForQuery(query, false);

  }

  /**
   * Compiles pattern for the given query string
   *
   * @param query         the query to compile into Pattern
   * @param caseSensitive if {@code true} the pattern will use case sensitive
   *                      matching
   * @return
   */
  public static Pattern getPatternForQuery(final String query, final boolean caseSensitive) {
    if (query == null || query.isEmpty()) {
      return Pattern.compile(".*");
    }
    final String pattern = query.replace(".", "\\.").replace("*", ".*").replace("+", ".") + ".*";
    return Pattern.compile(pattern, !caseSensitive ? Pattern.CASE_INSENSITIVE : 0);
  }

  /**
   * Returns {@code true} if the string is null, empty or contains only
   * {@link Character#isWhitespace(int) white space} codepoints, otherwise
   * {@code false}.
   *
   * @return {@code true} if the string is null, empty or contains only
   *         {@link Character#isWhitespace(int) white space} codepoints, otherwise
   *         {@code false}
   */
  public static boolean isBlank(final String value) {
    if (value == null || value.isEmpty()) {
      return true;
    }
    return value.trim().equals("");
  }

  /**
   * Returns {@code true} if, and only if, {@link value#length()} is {@code 0}.
   *
   * @return {@code true} if {@link value#length()} is {@code 0}, otherwise
   *         {@code false}
   */
  public static boolean isEmpty(final String value) {
    return value == null || value.isEmpty();
  }

  /**
   * Removes any existing negation characters from the start of the given string
   *
   * @param value the String to be adjusted
   * @return the passed String value without any leading negation characters
   */
  public static String removeNegationCharacter(final String value) {
    if (value == null || value.isEmpty()) {
      return value;
    }
    int negationCharLength;
    if (!value.startsWith(NEGATION1)) {
      return value;
    }
    negationCharLength = 1;

    if (value.length() > negationCharLength) {
      return value.substring(negationCharLength);
    }
    return "";
  }

  /**
   * Returns <code>true</code> if the passed String value starts with a negation
   * character/string. A negation character is either "!" or "<>"
   *
   * @param value the String to be analyzed
   * @return <code>true</code> if <code>value</code> starts with negation
   *         character
   */
  public static boolean startsWithNegationCharacter(final String value) {
    if (value == null || value.isEmpty()) {
      return false;
    }
    return value.startsWith(NEGATION1);
  }

  /**
   * Unescapes HTML escaped characters
   *
   * @param escapedHtml the String where characters should be unescaped
   * @return
   */
  public static String unescapeHtmlChars(final String escapedHtml) {
    if (escapedHtml == null || escapedHtml.isEmpty()) {
      return "";
    }
    return escapedHtml.replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&szlig;", "ß")
        .replace("&amp;", "&")
        .replace("&quot;", "\"")
        .replace("&#39;", "'")
        .replace("&agrave;", "à")
        .replace("&Agrave;", "À")
        .replace("&acirc;", "Â")
        .replace("&auml;", "ä")
        .replace("&Auml;", "Ä")
        .replace("&ouml;", "ö")
        .replace("&Ouml;", "Ö")
        .replace("&uuml;", "ü")
        .replace("&Uuml;", "Ü")
        .replace("&nbsp;", " ");
  }
}
