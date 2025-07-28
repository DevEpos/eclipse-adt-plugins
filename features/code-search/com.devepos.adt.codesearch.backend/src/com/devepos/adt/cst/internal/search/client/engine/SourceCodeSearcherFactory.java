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
  public static ISourceCodeSearcherFactory createFactory(List<IPatternMatcher> matchers,
      IClientCodeSearchConfig config) {
    return new ISourceCodeSearcherFactory() {

      @Override
      public ISourceCodeSearcher createSearcher(ISourceCode sourceCode) {
        if (config.isSequentialMatching()) {
          return new SequentialSourceCodeSearcher(matchers, sourceCode,
              config.isIgnoreCommentLines());
        } else {
          return new StandardSourceCodeSearcher(matchers, sourceCode, config.isIgnoreCommentLines(),
              config.isMatchAllPatterns());
        }
      }
    };
  }
}
