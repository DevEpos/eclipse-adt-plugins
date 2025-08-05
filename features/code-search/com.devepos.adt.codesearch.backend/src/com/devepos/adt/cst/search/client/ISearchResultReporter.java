package com.devepos.adt.cst.search.client;

import com.devepos.adt.base.model.adtbase.IResponseMessage;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;

public interface ISearchResultReporter {
  void reportResult(ICodeSearchResult result);

  void logMessage(IResponseMessage message);
}
