package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Sequential Source Code Searcher
 * <p>
 * This class performs sequential pattern-based source code searching,
 * respecting comment lines if needed.
 * </p>
 */
public class SequentialSourceCodeSearcher extends AbstractSourceCodeSearcher
    implements ISourceCodeSearcher {

  protected boolean hasMoreMatches;
  protected int currentLineOffset;
  protected int currentColOffset;
  protected RawMatch currentMatch;
  protected RawMatch matchStart;
  protected RawMatch matchEnd;
  protected List<IPatternMatcher> matchers;

  /**
   * Constructor
   *
   * @param matchers           list of matchers
   * @param ignoreCommentLines whether to skip comment lines
   * @param lineFeed           line separator
   */
  public SequentialSourceCodeSearcher(final List<IPatternMatcher> matchers,
      final ISourceCode sourceCode, final boolean ignoreCommentLines) {
    super(sourceCode, ignoreCommentLines);
    this.matchers = matchers;

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

  protected void setCurrentOffsets(final int col, final int line) {
    currentColOffset = col;
    currentLineOffset = line;
  }

  protected RawMatch findNextPartialMatch(final IPatternMatcher matcher) {
    return findNextPartialMatch(matcher, null);
  }

  protected RawMatch findNextPartialMatch(final IPatternMatcher matcher,
      final BiConsumer<Integer, Integer> offsetWriter) {
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
        if (offsetWriter != null) {
          offsetWriter.accept(0, 0);
        }
        return null;
      }

      return recursiveMatch;
    }

    if (offsetWriter != null) {
      offsetWriter.accept(match.offset() + match.length(), match.line());
    }

    return match;
  }

  protected void collectSequentialMatch(final List<Match> matches) {
    if (matchStart == null || matchEnd == null) {
      return;
    }

    var snippet = sourceCode.content()[matchStart.line()];
    var seqMatch = new Match(matchStart.line(), matchStart.offset(), matchEnd.line(),
        matchEnd.offset() + matchEnd.length(), snippet,
        getLongSnippet(matchStart, matchEnd, snippet));

    matches.add(seqMatch);
  }

  private void findNextFullMatch(final List<Match> matches) {
    for (var matcher : matchers) {
      currentMatch = findNextPartialMatch(matcher, this::setCurrentOffsets);
      if (!hasMoreMatches) {
        return;
      }

      if (matchStart == null) {
        matchStart = currentMatch;
      }
    }

    matchEnd = currentMatch;
    collectSequentialMatch(matches);
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
