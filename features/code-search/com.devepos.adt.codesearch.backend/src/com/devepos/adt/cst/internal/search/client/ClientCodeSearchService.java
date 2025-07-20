package com.devepos.adt.cst.internal.search.client;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.IClientBasedCodeSearchService;

public class ClientCodeSearchService implements IClientBasedCodeSearchService {
  private IProject project;
  private String destinationId;

  public ClientCodeSearchService(IProject project) {
    this.project = project;
    this.destinationId = DestinationUtil.getDestinationId(project);
  }

  @Override
  public ICodeSearchResult search(Map<String, Object> uriParameters, IProgressMonitor monitor) {
    // TODO Auto-generated method stub
    return null;
  }
}
