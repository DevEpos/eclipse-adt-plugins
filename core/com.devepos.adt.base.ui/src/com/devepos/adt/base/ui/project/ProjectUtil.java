package com.devepos.adt.base.ui.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.destinations.IDestinationProvider;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.sap.adt.destinations.logon.AdtLogonServiceFactory;
import com.sap.adt.destinations.model.http.internal.api.IHttpDestinationData;
import com.sap.adt.destinations.ui.logon.AdtLogonServiceUIFactory;
import com.sap.adt.project.AdtCoreProjectServiceFactory;
import com.sap.adt.project.IAdtCoreProject;
import com.sap.adt.project.IProjectProvider;
import com.sap.adt.tools.core.project.AdtProjectServiceFactory;
import com.sap.adt.tools.core.project.IAbapProject;

/**
 * Utility class concerning {@link IProject}s especially {@link IAbapProject}s
 *
 * @author stockbal
 */
public class ProjectUtil {

  /**
   * Adapts the given object to an instance of {@link IProject} or {@code null} if not possible.
   *
   * @param object object to be adapted
   * @return {@link IProject} or {@code null}
   */
  public static IProject adaptAsProject(final Object object) {
    var adaptedProjectProvider = Adapters.adapt(object, IProjectProvider.class);
    if (adaptedProjectProvider != null) {
      return adaptedProjectProvider.getProject();
    }

    if (object instanceof IDestinationProvider) {
      return getProjectForDestination(((IDestinationProvider) object).getDestinationId());
    }

    final var adaptedProject = Adapters.adapt(object, IProject.class);
    if (adaptedProject != null) {
      return adaptedProject;
    }
    return null;
  }

  /**
   * @return {@code true} if the given project is an ABAP cloud project
   */
  @SuppressWarnings("restriction")
  public static boolean isCloudProject(final IProject project) {
    var destData = DestinationUtil.getDestinationData(DestinationUtil.getDestinationId(project));
    if (destData instanceof IHttpDestinationData) {
      return true;
    }
    return false;
  }

  /**
   * Ensures that the users is logged on to given project
   *
   * @param project the ABAP Project to ensure the logged on status
   * @return Logged On Status for the given project
   */
  public static IStatus ensureLoggedOnToProject(final IProject project) {
    final var abapProject = project.getAdapter(IAbapProject.class);

    if (AdtLogonServiceUIFactory.createLogonServiceUI()
        .ensureLoggedOn(abapProject.getDestinationData(),
            PlatformUI.getWorkbench().getProgressService())
        .isOK()) {
      return Status.OK_STATUS;
    }
    return new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
        NLS.bind(Messages.Project_LogonToProjectFailed_xmsg, project.getName()));
  }

  /**
   * Retrieve a list of all ABAP projects in the current workspace
   *
   * @return List of ABAP projects
   */
  public static IProject[] getAbapProjects() {
    return AdtProjectServiceFactory.createProjectService().getAvailableAbapProjects();
  }

  /**
   * Shows status in popup if project is not accessible and returns {@code true} is project is
   * accessible.
   *
   * @param project project to check for accessability
   * @return {@code true} if project is accessible
   */
  public static boolean checkProjectAccessible(final IProject project) {
    var projectStatus = AdtProjectServiceFactory.createProjectService()
        .isProjectAccessible(project);
    if (!projectStatus.isOK()) {
      StatusManager.getManager()
          .handle(
              new Status(IStatus.WARNING, projectStatus.getPlugin(), projectStatus.getMessage()),
              StatusManager.SHOW);
      return false;
    }
    return true;
  }

  /**
   * Retrieve the currently active ABAP Project
   *
   * @return
   */
  public static IProject getCurrentAbapProject() {
    return getCurrentAbapProject(null);
  }

  /**
   * Retrieve the currently active ABAP Project
   *
   * @param selection selection in a workbench part
   * @return
   */
  public static IProject getCurrentAbapProject(ISelection selection) {
    if (selection == null) {
      final var window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
      if (window == null) {
        return null;
      }
      selection = window.getSelectionService().getSelection();
    }
    return com.sap.adt.project.ui.util.ProjectUtil.getActiveAdtCoreProject(selection, null, null,
        IAdtCoreProject.ABAP_PROJECT_NATURE);
  }

  /**
   * Retrieves project instance for the given destination id
   *
   * @param destinationId destination Id of ABAP project
   * @return the project for the given destination or {@code null}
   */
  public static IProject getProjectForDestination(final String destinationId) {
    final var projectService = AdtCoreProjectServiceFactory.createCoreProjectService();
    return projectService.findProject(destinationId);
  }

  /**
   * Returns {@code true} if the current user is logged on to the given project
   *
   * @param project ABAP project
   * @return {@code true} if the current user is logged on to the given project
   */
  public static boolean isLoggedOnToProject(final IProject project) {
    final var destinationId = DestinationUtil.getDestinationId(project);
    return destinationId != null
        ? AdtLogonServiceFactory.createLogonService().isLoggedOn(destinationId)
        : false;
  }

}
