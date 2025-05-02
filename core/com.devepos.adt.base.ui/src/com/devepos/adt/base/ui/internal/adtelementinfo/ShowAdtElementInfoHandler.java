package com.devepos.adt.base.ui.internal.adtelementinfo;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.base.destinations.IDestinationProvider;
import com.devepos.adt.base.ui.adtelementinfo.AdtElementInformationUtil;
import com.devepos.adt.base.ui.adtelementinfo.IAdtElementInfoConstants;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.sap.adt.project.IProjectProvider;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Command handler to show ADT element information for the currently selected
 * control of a Table or Tree control
 *
 * @author stockbal
 */
public class ShowAdtElementInfoHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    var selectedControl = getSelectedControl(event);
    if (selectedControl instanceof Tree) {
      var selectedTreeItem = ((Tree) selectedControl).getSelection();
      if (selectedTreeItem.length > 1) {
        return null;
      }
      var node = selectedTreeItem[0].getData();
      if (node instanceof IAdtObjectReferenceNode) {
        var projectProvider = ((IAdtObjectReferenceNode) node).getAdapter(IProjectProvider.class);
        if (projectProvider == null) {
          return null;
        }
        var adtObjRef = ((IAdtObjectReferenceNode) node).getObjectReference();
        AdtElementInformationUtil.showElementInformation(projectProvider.getProject(), adtObjRef,
            (Tree) selectedControl);
      } else if (node instanceof ITreeNode) {
        var possibleObjectRef = ((ITreeNode) node).getAdapter(IAdtObjectReference.class);
        if (possibleObjectRef != null) {
          var destProvider = Adapters.adapt(possibleObjectRef, IDestinationProvider.class);
          if (destProvider != null) {
            var project = ProjectUtil.getProjectForDestination(destProvider.getDestinationId());
            if (project != null) {
              AdtElementInformationUtil.showElementInformation(project, possibleObjectRef,
                  (Tree) selectedControl);
            }
          }
        }
      }
    }
    return null;
  }

  private Object getSelectedControl(final ExecutionEvent event) {
    Object control = null;
    if (event.getTrigger() instanceof Event) {
      control = ((Event) event.getTrigger()).widget;
    }

    if (control instanceof MenuItem) {
      var menu = ((MenuItem) control).getParent();
      if (menu != null) {
        control = menu.getData(IAdtElementInfoConstants.MENU_CONTROL_ID_FOR_CMD);
      }
    }

    return control;
  }

}
