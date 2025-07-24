package com.devepos.adt.cst.internal.search.client.engine;

public interface ISourceCodeSearcherFactory {
  /**
   * Creates new searcher instance for the given source code
   * 
   * @param sourceCode source code to search
   * @return the searcher instance
   */
  ISourceCodeSearcher createSearcher(ISourceCode sourceCode);
}
