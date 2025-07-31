package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;

public class SubstringMatcher implements IPatternMatcher {

  private final boolean ignoreCase;
  private final String pattern;
  private final int patternLength;
  private final int controlFlags;

  public SubstringMatcher(final boolean ignoreCase, final String pattern) {
    this(ignoreCase, pattern, 0);
  }

  public SubstringMatcher(final boolean ignoreCase, final String pattern, final int controlFlags) {
    this.ignoreCase = ignoreCase;
    this.controlFlags = controlFlags;
    this.pattern = ignoreCase ? pattern.toLowerCase() : pattern;
    patternLength = pattern.length();
  }

  @Override
  public int getControlFlags() {
    return controlFlags;
  }

  @Override
  public List<RawMatch> findMatches(final String[] source) {
    var matches = new ArrayList<RawMatch>();
    for (var i = 0; i < source.length; i++) {
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
  public List<RawMatch> findMatchesInRange(final String[] source, final int startLine,
      final int offset, final int endLine, final int endOffset) {
    var matches = new ArrayList<RawMatch>();
    for (var i = startLine; i <= endLine; i++) {
      var line = source[i];
      var beginIndex = startLine == i ? offset : 0;
      var endIndex = endLine == i ? endOffset : line.length();
      if (ignoreCase) {
        line = line.toLowerCase();
      }
      var index = line.indexOf(pattern, beginIndex);
      while (index != -1 && index < endIndex) {
        matches.add(new RawMatch(i, beginIndex + index, patternLength));
        index = line.indexOf(pattern, beginIndex + index + patternLength);
      }
    }
    return matches;
  }

  @Override
  public RawMatch findNextMatch(final String[] source, final int startLine, final int offset) {
    for (var i = startLine; i < source.length; i++) {
      var line = source[i];
      var beginIndex = startLine == i ? offset : 0;
      if (ignoreCase) {
        line = line.toLowerCase();
      }

      var index = line.indexOf(pattern, beginIndex);
      if (index != -1) {
        return new RawMatch(i, index, patternLength);
      }
    }
    return null;
  }

}
