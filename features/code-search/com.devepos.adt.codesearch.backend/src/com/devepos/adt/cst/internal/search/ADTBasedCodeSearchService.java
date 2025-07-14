package com.devepos.adt.cst.internal.search;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScope;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScopeParameters;
import com.devepos.adt.cst.model.codesearch.ICodeSearchSettings;
import com.devepos.adt.cst.search.ICodeSearchService;

public class ADTBasedCodeSearchService implements ICodeSearchService {
  private IProject project;

  public ADTBasedCodeSearchService(IProject project) {
    this.project = project;
  }

  @Override
  public ICodeSearchScope createScope(String destinationId,
      ICodeSearchScopeParameters scopeParameters, IProgressMonitor monitor) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IAdtPluginFeatures getSearchScopeFeatures(String destinationId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IAdtPluginFeatures getSearchSettingsFeatures(String destinationId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ICodeSearchSettings getSettings(String destinationId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isCodeSearchParameterSupported(String queryParameter) {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public ICodeSearchResult search(String destinationId, Map<String, Object> uriParameters,
      IProgressMonitor monitor) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IStatus testCodeSearchFeatureAvailability() {
    return Status.OK_STATUS;
  }

  @Override
  public IStatus testCodeSearchNamedItemAvailability(String namedItemTerm) {
    // TODO Auto-generated method stub
    return Status.CANCEL_STATUS;
  }

  @Override
  public IStatus updateSettings(String destinationId, ICodeSearchSettings settings) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IStatus validatePatterns(String destinationId, String patterns,
      Map<String, String> uriParameters) {
    // TODO Auto-generated method stub
    return null;
  }
}
