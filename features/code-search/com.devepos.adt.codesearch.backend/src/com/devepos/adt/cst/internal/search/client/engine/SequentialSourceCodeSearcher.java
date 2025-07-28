package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Sequential Source Code Searcher
 * <p>
 * This class performs sequential pattern-based source code searching,
 * respecting comment lines if needed.
 * </p>
 */
public class SequentialSourceCodeSearcher extends AbstractSourceCodeSearcher
    implements ISourceCodeSearcher {

  private boolean hasMoreMatches;
  private int currentLineOffset;
  private int currentColOffset;
  private RawMatch currentMatch;
  private RawMatch matchStart;
  private RawMatch matchEnd;

  /**
   * Constructor
   *
   * @param matchers           list of matchers
   * @param ignoreCommentLines whether to skip comment lines
   * @param lineFeed           line separator
   */
  public SequentialSourceCodeSearcher(final List<IPatternMatcher> matchers,
      final ISourceCode sourceCode, final boolean ignoreCommentLines) {
    super(matchers, sourceCode, ignoreCommentLines);
  }

  /**
   * Entry point for executing the search.
   *
   * @return list of search matches
   */
  @Override
  public List<Match> search() {
    hasMoreMatches = true;

    currentLineOffset = 0;
    currentColOffset = 0;

    List<Match> result = new ArrayList<>();

    while (hasMoreMatches) {
      currentMatch = null;
      matchStart = null;

      findNextFullMatch(result);
    }

    return result;
  }

  private void findNextFullMatch(final List<Match> matches) {
    var i = 0;

    for (var matcher : matchers) {
      i++;
      var match = findNextPartialMatch(matcher);
      if (!hasMoreMatches) {
        return;
      }

      if (i == 1) {
        matchStart = match;
      }
    }

    matchEnd = currentMatch;
    collectSequentialMatch(matches);
  }

  private RawMatch findNextPartialMatch(final IPatternMatcher matcher) {
    RawMatch match = null;

    try {
      match = matcher.findNextMatch(sourceCode.content(), currentLineOffset, currentColOffset);
    } catch (Exception e) {
      hasMoreMatches = false;
      return null;
    }

    if (match == null) {
      hasMoreMatches = false;
      return null;
    }

    if (ignoreCommentLines && isCommentLine(sourceCode.content()[match.line()])) {
      currentLineOffset = match.line();
      currentColOffset = match.offset() + match.length();

      var recursiveMatch = findNextPartialMatch(matcher);
      if (recursiveMatch == null) {
        hasMoreMatches = false;
        return null;
      }

      return recursiveMatch;
    }

    currentLineOffset = match.line();
    currentColOffset = match.offset() + match.length();
    currentMatch = match;

    return match;
  }

  private void collectSequentialMatch(final List<Match> matches) {
    if (matchStart == null || matchEnd == null) {
      return;
    }

    var snippet = sourceCode.content()[matchStart.line()];
    var seqMatch = new Match(matchStart.line(), matchStart.offset(), matchEnd.line(),
        matchEnd.offset() + matchEnd.length(), snippet,
        getLongSnippet(matchStart, matchEnd, snippet));

    matches.add(seqMatch);
  }

  private String getLongSnippet(final RawMatch start, final RawMatch end, final String snippet) {
    if (end.line() == start.line()) {
      return null;
    }
    var longSnippet = new StringBuilder(snippet);
    for (var i = start.line() + 1; i <= end.line(); i++) {
      if (i == end.line()) {
        longSnippet.append("\n").append(sourceCode.content()[i].substring(0, end.offset()));
      } else {
        longSnippet.append("\n").append(sourceCode.content()[i]);
      }
    }
    return longSnippet.toString();
  }
}
