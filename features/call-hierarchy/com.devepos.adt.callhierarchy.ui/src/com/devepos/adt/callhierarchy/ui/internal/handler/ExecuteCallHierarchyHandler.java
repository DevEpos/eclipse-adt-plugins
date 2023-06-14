package com.devepos.adt.callhierarchy.ui.internal.handler;

import java.net.URI;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;

import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.ui.util.AdtUIUtil;
import com.devepos.adt.callhierarchy.backend.CallHierarchyServiceFactory;
import com.devepos.adt.callhierarchy.backend.ICallHierarchyService;
import com.devepos.adt.callhierarchy.ui.internal.AdtUriSelectionHelper;
import com.devepos.adt.callhierarchy.ui.internal.CallHierarchyInput;
import com.devepos.adt.callhierarchy.ui.internal.CallHierarchyManager;

/**
 * Command handler for executing a call hierarchy on the current selection
 * 
 * @author Ludwig Stockbauer-Muhr
 * 
 */
public class ExecuteCallHierarchyHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    IAdtObject selectedObject = AdtUIUtil.getAdtObjectFromSelection(false);
    if (selectedObject == null) {
      return null;
    }
    IProject project = selectedObject.getProject();
    ICallHierarchyService hierarchyService = CallHierarchyServiceFactory.getHierarchyService();
    IStatus featureStatus = hierarchyService.testCallHierarchyFeatureAvailability(project);
    if (!featureStatus.isOK()) {
      // TODO: show feature not available popup
      return null;
    }

    loadHierarchyAtUri(event, project, hierarchyService);

    return null;
  }

  private void loadHierarchyAtUri(final ExecutionEvent event, final IProject project,
      final ICallHierarchyService hierarchyService) {
    URI uriFromSelection = AdtUriSelectionHelper.extractUriFromEvent(event);
    CallHierarchyManager hierarchyManager = CallHierarchyManager.getInstance();

    CallHierarchyInput hierarchy = new CallHierarchyInput(project, uriFromSelection.toString());
    hierarchyManager.addHierarchy(hierarchy);
    hierarchyManager.showHierarchy(hierarchy, false);
  }

}
