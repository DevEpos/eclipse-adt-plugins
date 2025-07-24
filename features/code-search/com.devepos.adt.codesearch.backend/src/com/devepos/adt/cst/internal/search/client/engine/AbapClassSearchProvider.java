package com.devepos.adt.cst.internal.search.client.engine;

import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.SearchableObject;

public class AbapClassSearchProvider implements ISearchProvider {
  private final IClientCodeSearchConfig config;

  public AbapClassSearchProvider(IClientCodeSearchConfig config) {
    this.config = config;
  }

  @Override
  public ICodeSearchResult search(SearchableObject object, ISourceCodeReader srcCodeReader,
      ISourceCodeSearcherFactory searcherFactory) {
    // TODO Auto-generated method stub
    var code = srcCodeReader.getSourceCode(object.getUri() + "/source/main");
    var matches = searcherFactory.createSearcher(code).search();

    return null;
  }
}
