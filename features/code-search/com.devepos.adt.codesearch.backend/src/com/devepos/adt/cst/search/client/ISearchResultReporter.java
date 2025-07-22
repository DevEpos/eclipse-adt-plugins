package com.devepos.adt.cst.search.client;

import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;

public interface ISearchResultReporter {
  void notify(ICodeSearchResult result);
}
