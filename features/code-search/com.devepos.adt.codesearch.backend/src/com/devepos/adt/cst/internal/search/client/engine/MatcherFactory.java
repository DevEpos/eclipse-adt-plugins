package com.devepos.adt.cst.internal.search.client.engine;

public class MatcherFactory {

  public static IPatternMatcher createMatcher(final String pattern, final boolean useRegex,
      final boolean ignoreCase, final int controlFlags) {
    return useRegex ? new RegexMatcher(ignoreCase, pattern, controlFlags)
        : new SubstringMatcher(ignoreCase, pattern, controlFlags);
  }

}
