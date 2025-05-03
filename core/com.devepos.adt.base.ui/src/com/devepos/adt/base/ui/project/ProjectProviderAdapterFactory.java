package com.devepos.adt.base.ui.project;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.destinations.IDestinationProvider;
import com.sap.adt.project.IProjectProvider;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Adapter Factory to adapt object to {@link IProjectProvider}
 *
 * @author stockbal
 */
public class ProjectProviderAdapterFactory {
  /*
   * Simple implementation of a project provider
   */
  private static final class ProjectProvider implements IProjectProvider {

    private final IProject project;

    public ProjectProvider(final IProject project) {
      this.project = project;
    }

    @Override
    public IProject getProject() {
      return project;
    }

  }

  /**
   * Adapts destination provider to project provider
   *
   * @param adtObjectRef EMF ADT Object Reference
   * @return the adapted project provider
   */
  public static IProjectProvider adaptToProjectProvider(final IAdtObjectReference adtObjectRef) {
    if (adtObjectRef == null || !(adtObjectRef instanceof IDestinationProvider)) {
      return null;
    }
    var project = ProjectUtil
        .getProjectForDestination(((IDestinationProvider) adtObjectRef).getDestinationId());
    if (project != null) {
      return new ProjectProvider(project);
    }
    return null;
  }
}
