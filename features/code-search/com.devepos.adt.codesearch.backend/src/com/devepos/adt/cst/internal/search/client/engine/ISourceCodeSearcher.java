package com.devepos.adt.cst.internal.search.client.engine;

import java.util.List;

public interface ISourceCodeSearcher {
  /**
   * Searches the source code of this instance
   *
   * @return the found matches
   */
  List<Match> search();
}
