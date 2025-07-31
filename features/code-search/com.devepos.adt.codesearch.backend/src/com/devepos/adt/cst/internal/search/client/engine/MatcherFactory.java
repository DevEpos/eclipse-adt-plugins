package com.devepos.adt.cst.internal.search.client.engine;

public class MatcherFactory {

  public static IPatternMatcher createMatcher(String pattern, boolean useRegex, boolean ignoreCase,
      int controlFlags) {
    return useRegex ? new RegexMatcher(ignoreCase, pattern, controlFlags)
        : new SubstringMatcher(ignoreCase, pattern, controlFlags);
  }

}
