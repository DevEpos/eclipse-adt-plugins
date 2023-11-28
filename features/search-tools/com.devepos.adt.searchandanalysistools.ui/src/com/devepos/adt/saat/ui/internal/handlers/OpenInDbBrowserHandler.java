package com.devepos.adt.saat.ui.internal.handlers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;

import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.ui.util.AdtUIUtil;
import com.devepos.adt.saat.ui.internal.util.OpenInUtil;
import com.sap.adt.tools.core.project.AdtProjectServiceFactory;

public class OpenInDbBrowserHandler extends DbBrowserCommandHandler {
  public static final String PARAM_SKIP_SELSCREEN = "com.devepos.adt.saat.openindbbrowser.skipSelscreenParam";

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final List<IAdtObject> selectedAdtObjects = AdtUIUtil.getAdtObjectsFromSelection(true);
    if (selectedAdtObjects == null || selectedAdtObjects.isEmpty()) {
      return null;
    }

    final String skipSelscreenParam = event.getParameter(PARAM_SKIP_SELSCREEN);
    if (skipSelscreenParam != null) {
      final boolean skipSelscreen = Boolean.parseBoolean(skipSelscreenParam);
      final Set<IProject> uniqueProjects = collectUniqueProjects(selectedAdtObjects);
      var projectService = AdtProjectServiceFactory.createProjectService();
      for (final IProject project : uniqueProjects) {
        var projectStatus = projectService.isProjectAccessible(project);
        if (!projectStatus.isOK()) {
          StatusManager.getManager()
              .handle(new Status(IStatus.WARNING, projectStatus.getPlugin(),
                  projectStatus.getMessage()), StatusManager.SHOW);
          return null;
        }
        if (!isFeatureAvailable(project)) {
          showFeatureNotAvailableDialog(project);
          return null;
        }
      }
      for (final IAdtObject adtObject : selectedAdtObjects) {
        OpenInUtil.openEntity(adtObject.getProject(), adtObject.getName(),
            adtObject.getObjectType().getId(), skipSelscreen);
      }
    }

    return null;
  }

  private Set<IProject> collectUniqueProjects(final List<IAdtObject> selectedAdtObjects) {
    final Set<IProject> uniqueProjects = new HashSet<>();
    for (final IAdtObject adtObject : selectedAdtObjects) {
      uniqueProjects.add(adtObject.getProject());
    }
    return uniqueProjects;
  }

}
