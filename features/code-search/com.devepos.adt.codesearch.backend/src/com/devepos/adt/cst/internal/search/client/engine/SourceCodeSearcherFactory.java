package com.devepos.adt.cst.internal.search.client.engine;

import java.util.List;

import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;

public class SourceCodeSearcherFactory {
  /**
   * Creates search instance with given matchers and search configuration
   *
   * @param matchers list of matchers used to search
   * @param config
   * @return
   */
  public static ISourceCodeSearcherFactory createFactory(final List<IPatternMatcher> matchers,
      final IClientCodeSearchConfig config) {
    final var containsControlFlags = matchers.stream().anyMatch(m -> m.getControlFlags() > 0);
    return sourceCode -> {
      if (config.isSequentialMatching()) {
        return containsControlFlags
            ? new ExtendedSequentialSourceCodeSearcher(matchers, sourceCode,
                config.isIgnoreCommentLines())
            : new SequentialSourceCodeSearcher(matchers, sourceCode, config.isIgnoreCommentLines());
      }
      return new StandardSourceCodeSearcher(matchers, sourceCode, config.isIgnoreCommentLines(),
          config.isMatchAllPatterns());
    };
  }
}
