package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;

public class SubstringMatcher implements IPatternMatcher {

  private final boolean ignoreCase;
  private final String pattern;
  private int patternLength;

  public SubstringMatcher(boolean ignoreCase, String pattern) {
    this.ignoreCase = ignoreCase;
    this.pattern = ignoreCase ? pattern.toLowerCase() : pattern;
    this.patternLength = pattern.length();
  }

  @Override
  public List<RawMatch> findMatches(String[] source) {
    List<RawMatch> matches = new ArrayList<>();
    for (int i = 0; i < source.length; i++) {
      var line = source[i];
      if (ignoreCase) {
        line = line.toLowerCase();
      }

      var index = line.indexOf(pattern);
      while (index != -1) {
        matches.add(new RawMatch(i, index, patternLength));
        index = line.indexOf(pattern, index + patternLength);
      }
    }
    return matches;
  }

  @Override
  public List<RawMatch> findMatchesInRange(String[] source, int startLine, int offset, int endLine,
      int endOffset) {
    throw new UnsupportedOperationException();
  }

  @Override
  public RawMatch findNextMatch(String[] source, int startLine, int offset) {
    throw new UnsupportedOperationException();
  }

}
