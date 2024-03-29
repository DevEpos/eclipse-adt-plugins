package com.devepos.adt.base.ui.project;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.sap.adt.project.AdtCoreProjectServiceFactory;
import com.sap.adt.project.IAdtCoreProjectService;

/**
 * Provides access to the current ABAP project provider
 *
 * @author stockbal
 */
public class AbapProjectProviderAccessor {
  private static Map<String, IAbapProjectProvider> projectProviderMap;

  /**
   * Returns a project provider for the ABAP project that is currently selected
   * 
   * @return the found project provider or {@code null}
   */
  public static IAbapProjectProvider getProviderFromSelection() {
    var activeProject = ProjectUtil.getCurrentAbapProject();
    if (activeProject == null) {
      return null;
    }

    return getProviderForDestination(DestinationUtil.getDestinationId(activeProject));
  }

  /**
   * Retrieves an abap project provider for the given destination id
   *
   * @param destinationId a valid destination id of a project
   * @return
   */
  public static IAbapProjectProvider getProviderForDestination(final String destinationId) {
    if (destinationId == null) {
      return null;
    }
    IAbapProjectProvider projectProvider = null;
    if (projectProviderMap != null) {
      projectProvider = projectProviderMap.get(destinationId);
    }
    if (projectProvider == null) {
      final IAdtCoreProjectService projectService = AdtCoreProjectServiceFactory
          .createCoreProjectService();
      final IProject projectForDestination = projectService.findProject(destinationId);
      if (projectForDestination != null) {
        projectProvider = new AbapProjectProxy(projectForDestination);
        registerProjectProvider(projectProvider);
      }
    }

    return projectProvider;
  }

  /**
   * Registers the given project provider to be globally accessible
   *
   * @param projectProvider the {@link IAbapProjectProvider} to be registered
   */
  public static void registerProjectProvider(final IAbapProjectProvider projectProvider) {
    if (projectProvider == null) {
      return;
    }

    if (projectProviderMap == null) {
      projectProviderMap = new HashMap<>();
    }

    if (!projectProviderMap.containsKey(projectProvider.getDestinationId())) {
      projectProviderMap.put(projectProvider.getDestinationId(), projectProvider.copy());
    }
  }

}
