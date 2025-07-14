package com.devepos.adt.cst.search;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.NamedItemServiceFactory;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.cst.internal.search.ADTBasedCodeSearchService;
import com.devepos.adt.cst.internal.search.CodeSearchService;
import com.devepos.adt.cst.internal.search.CodeSearchUriDiscovery;

/**
 * Factory for creating instances of {@link ICodeSearchService}
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CodeSearchFactory {

  /**
   * Retrieves instance of {@link ICodeSearchService}
   *
   * @return search service instance for searching in ABAP Code
   */
  public static ICodeSearchService getCodeSearchService(IProject project) {
    if (ProjectUtil.isCloudProject(project)) {
      return new ADTBasedCodeSearchService(project);
    } else {
      return new CodeSearchService(project);
    }
  }

  public static IAdtUriTemplateProvider getNamedItemUriTemplateProvider(
      final IAbapProjectProvider projectProvider) {
    if (projectProvider == null) {
      throw new IllegalArgumentException("Parameter 'projectProvider' must be filled!");
    }
    return NamedItemServiceFactory.createNamedItemUriTemplateProvider(projectProvider,
        CodeSearchUriDiscovery::new);
  }
}
