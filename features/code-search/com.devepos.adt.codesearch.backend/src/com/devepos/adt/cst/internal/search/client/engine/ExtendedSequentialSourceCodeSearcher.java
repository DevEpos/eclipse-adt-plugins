package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;

public class ExtendedSequentialSourceCodeSearcher extends SequentialSourceCodeSearcher {

  private static final int FLAG_MATCH_START = PatternCtrlSequence.MATCH_START.getFlag();
  private static final int FLAG_MATCH = PatternCtrlSequence.MATCH.getFlag();
  private static final int FLAG_EXCLUDE = PatternCtrlSequence.EXCLUDE.getFlag();
  private static final int FLAG_BOUNDARY_START = PatternCtrlSequence.BOUNDARY_START.getFlag();
  private static final int FLAG_BOUNDARY_END = PatternCtrlSequence.BOUNDARY_END.getFlag();
  private static final int FLAG_MATCH_END = PatternCtrlSequence.MATCH_END.getFlag();

  private boolean hasCustomMatchBoundary;
  private RawMatch previousMatch;
  private RawMatch boundaryStart;
  private RawMatch boundaryEnd;
  private List<IPatternMatcher> exclusionMatchers = new ArrayList<>();

  public ExtendedSequentialSourceCodeSearcher(List<IPatternMatcher> matchers,
      ISourceCode sourceCode, boolean ignoreCommentLines) {
    super(matchers, sourceCode, ignoreCommentLines);
    for (var matcher : matchers) {
      int flags = matcher.getControlFlags();
      if ((flags & FLAG_MATCH_START) == FLAG_MATCH_START || (flags & FLAG_MATCH) == FLAG_MATCH) {
        hasCustomMatchBoundary = true;
        break;
      }
    }
  }

  @Override
  public List<Match> search() {
    this.hasMoreMatches = true;

    currentLineOffset = 0;
    currentColOffset = 0;

    List<Match> result = new ArrayList<>();

    while (hasMoreMatches) {
      currentMatch = null;
      previousMatch = null;
      matchStart = null;
      matchEnd = null;
      boundaryStart = null;
      boundaryEnd = null;
      exclusionMatchers.clear();

      findNextFullMatch(result);
    }

    return result;
  }

  private void findNextFullMatch(List<Match> matches) {
    boolean skipMatchSearch;

    for (int i = 0; i < matchers.size(); i++) {
      var matcher = matchers.get(i);
      skipMatchSearch = false;

      int flags = matcher.getControlFlags();
      if ((flags & FLAG_EXCLUDE) == FLAG_EXCLUDE) {
        exclusionMatchers.add(matcher);
        continue;
      } else if ((flags & FLAG_BOUNDARY_END) == FLAG_BOUNDARY_END) {
        previousMatch = currentMatch;
        currentMatch = boundaryEnd;
        currentLineOffset = boundaryEnd.line();
        currentColOffset = boundaryEnd.offset();

        boundaryStart = null;
        boundaryEnd = null;
        skipMatchSearch = true;
      }

      if (!skipMatchSearch) {
        previousMatch = currentMatch;

        currentMatch = findNextPartialMatch(matcher, this::setCurrentOffsets);

        if (!hasMoreMatches)
          return;
      }

      if (!exclusionMatchers.isEmpty()) {
        if (hasMatchesForExclusions(false))
          return;
        exclusionMatchers.clear();
      }

      if (boundaryEnd != null
          && (currentMatch.line() > boundaryEnd.line() || (currentMatch.line() == boundaryEnd.line()
              && currentMatch.offset() >= boundaryEnd.offset()))) {
        currentLineOffset = boundaryEnd.line();
        currentColOffset = boundaryEnd.offset() + boundaryEnd.length();
        return;
      }

      if ((flags & FLAG_BOUNDARY_START) == FLAG_BOUNDARY_START) {
        boundaryStart = currentMatch;
        if (!findNextBoundaryEnd(i + 1)) {
          hasMoreMatches = false;
          return;
        }
      }

      if (!hasCustomMatchBoundary && matchStart == null) {
        matchStart = currentMatch;
      }

      if ((flags & FLAG_MATCH_START) == FLAG_MATCH_START) {
        matchStart = currentMatch;
      } else if ((flags & FLAG_MATCH_END) == FLAG_MATCH_END) {
        matchEnd = currentMatch;
      } else if ((flags & FLAG_MATCH) == FLAG_MATCH) {
        matchStart = currentMatch;
        matchEnd = currentMatch;
      }
    }

    if (!exclusionMatchers.isEmpty()) {
      if (hasMatchesForExclusions(true))
        return;
    }

    if (!hasCustomMatchBoundary) {
      matchEnd = currentMatch;
    }

    collectSequentialMatch(matches);
  }

  private boolean hasMatchesForExclusions(boolean lookahead) {
    var rangeMatchStart = lookahead ? currentMatch : previousMatch;
    var rangeMatchEnd = lookahead
        ? new RawMatch(sourceCode.lineCount() - 1,
            sourceCode.content()[sourceCode.lineCount() - 1].length(), 0)
        : currentMatch;

    for (var matcher : exclusionMatchers) {
      if (isAnyMatchInRange(matcher, rangeMatchStart.line(),
          rangeMatchStart.offset() + rangeMatchStart.length(), rangeMatchEnd.line(),
          rangeMatchEnd.offset())) {
        return true;
      }
    }
    return false;
  }

  private boolean findNextBoundaryEnd(int startIndex) {
    for (int i = startIndex; i < matchers.size(); i++) {
      var matcher = matchers.get(i);
      if ((matcher.getControlFlags() & FLAG_BOUNDARY_END) == FLAG_BOUNDARY_END) {
        boundaryEnd = findNextPartialMatch(matcher);
        return boundaryEnd != null;
      }
    }
    return false;
  }

  private boolean isAnyMatchInRange(IPatternMatcher matcher, int startLine, int offset, int endLine,
      int endOffset) {
    try {
      List<RawMatch> matches = matcher.findMatchesInRange(sourceCode.content(), startLine, offset,
          endLine, endOffset);
      if (matches.isEmpty())
        return false;

      for (RawMatch match : matches) {
        if (ignoreCommentLines && isCommentLine(sourceCode.content()[match.line()])) {
          continue;
        }
        return true;
      }
    } catch (Exception e) {
      // TODO: Handle SAP-specific pattern match exception
      return false;
    }
    return false;
  }

}
