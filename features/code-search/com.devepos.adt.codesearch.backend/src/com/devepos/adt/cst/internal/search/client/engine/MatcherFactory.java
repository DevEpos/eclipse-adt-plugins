package com.devepos.adt.cst.internal.search.client.engine;

public class MatcherFactory {

  public static IPatternMatcher createMatcher(String pattern, boolean ignoreCase) {
    // TODO: implement regex matcher
    return new SubstringMatcher(ignoreCase, pattern);
  }

}
