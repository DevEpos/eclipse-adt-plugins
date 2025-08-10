package com.devepos.adt.cst.search;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.NamedItemServiceFactory;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.cst.internal.search.CodeSearchFeatureUtil;
import com.devepos.adt.cst.internal.search.CodeSearchPatternValidator;
import com.devepos.adt.cst.internal.search.CodeSearchScopeService;
import com.devepos.adt.cst.internal.search.backend.ServerBasedCodeSearchService;
import com.devepos.adt.cst.internal.search.backend.CodeSearchSettingsService;
import com.devepos.adt.cst.internal.search.backend.CodeSearchUriDiscovery;
import com.devepos.adt.cst.internal.search.client.ClientCodeSearchService;
import com.devepos.adt.cst.model.codesearch.ICodeSearchSettings;
import com.devepos.adt.cst.search.client.IClientBasedCodeSearchService;

/**
 * Factory for creating instances of {@link ICodeSearchService}
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CodeSearchFactory {

  /**
   * Retrieves instance of code search service to perform a adt client based search
   */
  public static IClientBasedCodeSearchService getClientCodeSearchService(final IProject project) {
    return new ClientCodeSearchService(project);
  }

  /**
   * Retrieves instance of code search service to perform a backend based search against the Code
   * Search ABAP backend
   */
  public static IServerBasedCodeSearchService getBackendCodeSearchService(final IProject project) {
    return new ServerBasedCodeSearchService(project);
  }

  public static IAdtUriTemplateProvider getNamedItemUriTemplateProvider(
      final IAbapProjectProvider projectProvider) {
    if (projectProvider == null) {
      throw new IllegalArgumentException("Parameter 'projectProvider' must be filled!");
    }
    return NamedItemServiceFactory.createNamedItemUriTemplateProvider(projectProvider,
        CodeSearchUriDiscovery::new);
  }

  public static ICodeSearchFeatureUtil getCodeSearchFeatureUtil(final IProject project) {
    return new CodeSearchFeatureUtil(project);
  }

  public static ICodeSearchSettingsService getSearchSettingsService(final IProject project) {
    if (!ProjectUtil.isCloudProject(project)) {
      return new CodeSearchSettingsService(project);
    }
    return new ICodeSearchSettingsService() {
      @Override
      public IStatus updateSettings(final ICodeSearchSettings settings) {
        throw new UnsupportedOperationException();
      }

      @Override
      public ICodeSearchSettings getSettings() {
        throw new UnsupportedOperationException();
      }
    };
  }

  public static ICodeSearchScopeService getSearchScopeService(final IProject project) {
    return new CodeSearchScopeService(project);
  }

  public static ICodeSearchPatternValidator getPatternValidator(final IProject project) {
    return new CodeSearchPatternValidator(project);
  }
}
