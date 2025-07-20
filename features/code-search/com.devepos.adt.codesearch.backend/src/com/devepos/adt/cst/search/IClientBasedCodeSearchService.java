package com.devepos.adt.cst.search;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;

public interface IClientBasedCodeSearchService {
  /**
   * Find matches in ABAP Code
   *
   * @param uriParameters map of URI parameters
   * @param monitor       progress monitor
   * @return search results
   */
  ICodeSearchResult search(Map<String, Object> uriParameters, IProgressMonitor monitor);

}
