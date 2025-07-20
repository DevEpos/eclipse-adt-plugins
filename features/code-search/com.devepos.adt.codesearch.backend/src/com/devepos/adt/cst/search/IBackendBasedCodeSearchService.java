package com.devepos.adt.cst.search;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScope;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScopeParameters;

public interface IBackendBasedCodeSearchService {
  /**
   * Creates the passed search scope in the ABAP project of the given destination id
   *
   * @param scopeParameters the parameters of the search scope
   * @param monitor         progress monitor of the background job
   * @return the persisted search scope
   */
  ICodeSearchScope createScope(ICodeSearchScopeParameters scopeParameters,
      IProgressMonitor monitor);

  /**
   * Find matches in ABAP Code
   *
   * @param uriParameters map of URI parameters
   * @param monitor       progress monitor
   * @return search results
   */
  ICodeSearchResult search(Map<String, Object> uriParameters, IProgressMonitor monitor);
}
