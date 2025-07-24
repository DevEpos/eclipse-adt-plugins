package com.devepos.adt.cst.internal.search.client.engine;

import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.client.SearchableObject;

public interface ISearchProvider {
  ICodeSearchResult search(SearchableObject object, ISourceCodeReader srcCodeReader,
      ISourceCodeSearcherFactory searcherFactory);
}
