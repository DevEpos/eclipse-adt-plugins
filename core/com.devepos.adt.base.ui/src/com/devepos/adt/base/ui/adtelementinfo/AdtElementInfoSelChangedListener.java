package com.devepos.adt.base.ui.adtelementinfo;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ui.internal.adtelementinfo.AdtElementInfoContextBuilder;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.viewsupport.ViewLookup;
import com.sap.adt.blues.core.ui.elementinfo.AdtElementInfoViewAdapter;

/**
 * Selection change listener to enable a refresh of the ABAP Element Info view when the selection
 * changed in a relevant Table or Tree control
 */
public class AdtElementInfoSelChangedListener implements ISelectionChangedListener {
  private static final String ABAP_DOC_VIEW_ID = "com.sap.adt.tools.abapsource.ui.AbapDocView";
  private final IEventBroker eventBroker = PlatformUI.getWorkbench().getService(IEventBroker.class);
  private Object currentNode;

  @SuppressWarnings("restriction")
  @Override
  public void selectionChanged(final SelectionChangedEvent event) {
    var selected = event.getStructuredSelection().getFirstElement();
    if (!(selected instanceof ITreeNode) || selected.equals(currentNode)) {
      return;
    }

    if (!ViewLookup.isViewVisible(ABAP_DOC_VIEW_ID)) {
      return;
    }

    var context = AdtElementInfoContextBuilder.buildFrom(event.getStructuredSelection());
    if (context == null) {
      return;
    }
    currentNode = selected;

    eventBroker.send("IAbapDocView2Adapter_CHANGE_EVENT",
        new AdtElementInfoViewAdapter(context.getObjectReference(), context.getProject()));
  }

}
