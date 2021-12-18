package com.devepos.adt.base.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.internal.messages.Messages;

/**
 * Action for expanding all elements in a {@link TreeViewer}
 *
 * @author stockbal
 *
 */
public class ExpandAllAction extends Action {

  private TreeViewer treeViewer;

  /**
   * Creates new instance of the receiver
   */
  public ExpandAllAction() {
    super(Messages.Actions_ExpandAll_xmit, AdtBaseUIResources.getImageDescriptor(
        IAdtBaseImages.EXPAND_ALL));
  }

  /**
   * Sets the tree viewer of this action
   *
   * @param treeViewer the new tree viewer
   */
  public void setTreeViewer(final TreeViewer treeViewer) {
    this.treeViewer = treeViewer;
  }

  @Override
  public void run() {
    if (treeViewer == null || treeViewer.getControl() == null || treeViewer.getControl()
        .isDisposed()) {
      return;
    }
    treeViewer.getControl().setRedraw(false);
    treeViewer.expandAll();
    treeViewer.getControl().setRedraw(true);

  }

}
