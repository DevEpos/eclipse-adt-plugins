package com.devepos.adt.base.ui.adtelementinfo;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.sap.adt.blues.core.ui.elementinfo.AdtElementInfoViewAdapter;
import com.sap.adt.project.IProjectProvider;

@SuppressWarnings("restriction")
public class AdtElementInfoSelChangedListener implements ISelectionChangedListener {
  private final IEventBroker eventBroker = PlatformUI.getWorkbench().getService(IEventBroker.class);
  private IAdtObjectReferenceNode currentNode;

  @Override
  public void selectionChanged(final SelectionChangedEvent event) {
    var selected = event.getStructuredSelection().getFirstElement();
    if (selected instanceof IAdtObjectReferenceNode) {
      var treeNode = (IAdtObjectReferenceNode) selected;
      var objectReference = treeNode.getObjectReference();
      if (objectReference != null && !treeNode.equals(currentNode)) {
        var projectProvider = treeNode.getAdapter(IProjectProvider.class);
        var project = projectProvider != null ? projectProvider.getProject() : null;
        eventBroker.send("IAbapDocView2Adapter_CHANGE_EVENT",
            new AdtElementInfoViewAdapter(objectReference, project));
      }
    }
  }

}
