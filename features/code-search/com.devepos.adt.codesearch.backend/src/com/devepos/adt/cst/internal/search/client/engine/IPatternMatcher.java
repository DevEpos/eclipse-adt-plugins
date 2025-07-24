package com.devepos.adt.cst.internal.search.client.engine;

import java.util.List;

public interface IPatternMatcher {
  List<RawMatch> findMatches(String[] source);

  List<RawMatch> findMatchesInRange(String[] source, int startLine, int offset, int endLine,
      int endOffset);

  RawMatch findNextMatch(String[] source, int startLine, int offset);
}
