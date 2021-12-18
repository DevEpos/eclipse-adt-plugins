package com.devepos.adt.base.ui.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.sap.adt.destinations.logon.AdtLogonServiceFactory;
import com.sap.adt.destinations.ui.logon.AdtLogonServiceUIFactory;
import com.sap.adt.project.IAdtCoreProject;
import com.sap.adt.tools.core.project.AdtProjectServiceFactory;
import com.sap.adt.tools.core.project.IAbapProject;

/**
 * Utility class concerning {@link IProject}s especially {@link IAbapProject}s
 *
 * @author stockbal
 */
public class ProjectUtil {

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
      final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
      if (window == null) {
        return null;
      }
      selection = window.getSelectionService().getSelection();
    }
    return com.sap.adt.project.ui.util.ProjectUtil.getActiveAdtCoreProject(selection, null, null,
        IAdtCoreProject.ABAP_PROJECT_NATURE);
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
   * Ensures that the users is logged on to given project
   *
   * @param project the ABAP Project to ensure the logged on status
   * @return Logged On Status for the given project
   */
  public static IStatus ensureLoggedOnToProject(final IProject project) {
    final IAbapProject abapProject = project.getAdapter(IAbapProject.class);

    if (AdtLogonServiceUIFactory.createLogonServiceUI()
        .ensureLoggedOn(abapProject.getDestinationData(), PlatformUI.getWorkbench()
            .getProgressService())
        .isOK()) {
      return Status.OK_STATUS;
    }
    return new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, NLS.bind(
        Messages.Project_LogonToProjectFailed_xmsg, project.getName()));
  }

  /**
   * Returns {@code true} if the current user is logged on to the given project
   *
   * @param project ABAP project
   * @return {@code true} if the current user is logged on to the given project
   */
  public static boolean isLoggedOnToProject(final IProject project) {
    final String destinationId = DestinationUtil.getDestinationId(project);
    return destinationId != null ? AdtLogonServiceFactory.createLogonService()
        .isLoggedOn(destinationId) : false;
  }

}
