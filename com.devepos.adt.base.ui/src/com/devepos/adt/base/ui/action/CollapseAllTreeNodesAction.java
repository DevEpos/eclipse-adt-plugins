package com.devepos.adt.base.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.internal.messages.Messages;

/**
 * Action for collapsing all nodes in the given {@link TreeViewer}
 *
 * @author stockbal
 */
public class CollapseAllTreeNodesAction extends Action {
  private final TreeViewer viewer;

  public CollapseAllTreeNodesAction(final TreeViewer viewer) {
    super(Messages.Actions_CollapseAllNodes_xmit, AdtBaseUIResources.getImageDescriptor(
        IAdtBaseImages.COLLAPSE_ALL));
    this.viewer = viewer;
  }

  @Override
  public void run() {
    viewer.getControl().setRedraw(false);
    try {
      viewer.collapseAll();
    } finally {
      viewer.getControl().setRedraw(true);
    }
  }
}