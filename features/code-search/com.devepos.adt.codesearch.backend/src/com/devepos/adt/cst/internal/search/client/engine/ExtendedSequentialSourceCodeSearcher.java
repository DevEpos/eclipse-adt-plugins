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
  private RawMatch boundaryEnd;
  private final List<IPatternMatcher> exclusionMatchers = new ArrayList<>();

  public ExtendedSequentialSourceCodeSearcher(final List<IPatternMatcher> matchers,
      final ISourceCode sourceCode, final boolean ignoreCommentLines) {
    super(matchers, sourceCode, ignoreCommentLines);
    for (var matcher : matchers) {
      var flags = matcher.getControlFlags();
      if ((flags & FLAG_MATCH_START) == FLAG_MATCH_START || (flags & FLAG_MATCH) == FLAG_MATCH) {
        hasCustomMatchBoundary = true;
        break;
      }
    }
  }

  @Override
  public List<Match> search() {
    hasMoreMatches = true;

    currentLineOffset = 0;
    currentColOffset = 0;

    List<Match> result = new ArrayList<>();

    while (hasMoreMatches) {
      currentMatch = null;
      previousMatch = null;
      matchStart = null;
      matchEnd = null;
      boundaryEnd = null;
      exclusionMatchers.clear();

      findNextFullMatch(result);
    }

    return result;
  }

  private void findNextFullMatch(final List<Match> matches) {
    boolean skipMatchSearch;

    for (var i = 0; i < matchers.size(); i++) {
      var matcher = matchers.get(i);
      skipMatchSearch = false;

      var flags = matcher.getControlFlags();
      if ((flags & FLAG_EXCLUDE) == FLAG_EXCLUDE) {
        exclusionMatchers.add(matcher);
        continue;
      }
      if ((flags & FLAG_BOUNDARY_END) == FLAG_BOUNDARY_END) {
        previousMatch = currentMatch;
        currentMatch = boundaryEnd;
        currentLineOffset = boundaryEnd.line();
        currentColOffset = boundaryEnd.offset();

        boundaryEnd = null;
        skipMatchSearch = true;
      }

      if (!skipMatchSearch) {
        previousMatch = currentMatch;

        currentMatch = findNextPartialMatch(matcher, this::setCurrentOffsets);

        if (!hasMoreMatches) {
          return;
        }
      }

      if (!exclusionMatchers.isEmpty()) {
        if (hasMatchesForExclusions(false)) {
          return;
        }
        exclusionMatchers.clear();
      }

      if (boundaryEnd != null
          && (currentMatch.line() > boundaryEnd.line() || currentMatch.line() == boundaryEnd.line()
              && currentMatch.offset() >= boundaryEnd.offset())) {
        currentLineOffset = boundaryEnd.line();
        currentColOffset = boundaryEnd.offset() + boundaryEnd.length();
        return;
      }

      // NOTE: it is not required right now to store the boundary start
      if ((flags & FLAG_BOUNDARY_START) == FLAG_BOUNDARY_START && !findNextBoundaryEnd(i + 1)) {
        hasMoreMatches = false;
        return;
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

    if (!exclusionMatchers.isEmpty() && hasMatchesForExclusions(true)) {
      return;
    }

    if (!hasCustomMatchBoundary) {
      matchEnd = currentMatch;
    }

    collectSequentialMatch(matches);
  }

  private boolean hasMatchesForExclusions(final boolean lookahead) {
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

  private boolean findNextBoundaryEnd(final int startIndex) {
    for (var i = startIndex; i < matchers.size(); i++) {
      var matcher = matchers.get(i);
      if ((matcher.getControlFlags() & FLAG_BOUNDARY_END) == FLAG_BOUNDARY_END) {
        boundaryEnd = findNextPartialMatch(matcher);
        return boundaryEnd != null;
      }
    }
    return false;
  }

  private boolean isAnyMatchInRange(final IPatternMatcher matcher, final int startLine,
      final int offset, final int endLine, final int endOffset) {
    try {
      var matches = matcher.findMatchesInRange(sourceCode.content(), startLine, offset, endLine,
          endOffset);
      if (matches.isEmpty()) {
        return false;
      }

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
