package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.sap.adt.blues.core.ui.elementinfo.AdtElementInfoViewAdapter;
import com.sap.adt.project.IProjectProvider;

public class ElementInfoChangedListener implements ISelectionChangedListener {
  private final IEventBroker eventBroker = (IEventBroker) PlatformUI.getWorkbench()
      .getService(IEventBroker.class);
  private IAdtObjectReferenceNode currentNode;

  public void selectionChanged(SelectionChangedEvent event) {
    var selected = event.getStructuredSelection().getFirstElement();
    if (selected instanceof IAdtObjectReferenceNode treeNode) {
      var objectReference = treeNode.getObjectReference();
      if (objectReference != null && !treeNode.equals(this.currentNode)) {
        var projectProvider = treeNode.getAdapter(IProjectProvider.class);
        var project = projectProvider != null ? projectProvider.getProject() : null;
        this.eventBroker.send("IAbapDocView2Adapter_CHANGE_EVENT",
            new AdtElementInfoViewAdapter(objectReference, project));
      }
    }
  }

}
