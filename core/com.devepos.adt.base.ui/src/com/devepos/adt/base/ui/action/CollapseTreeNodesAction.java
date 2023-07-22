package com.devepos.adt.base.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.internal.messages.Messages;

/**
 * Action to collapse the tree for a specific node
 *
 * @author stockbal
 */
public class CollapseTreeNodesAction extends Action {
  private TreeViewer viewer;

  public CollapseTreeNodesAction() {
    this(null);
  }

  public CollapseTreeNodesAction(final TreeViewer viewer) {
    super(Messages.Actions_CollapseNode_xtol, AdtBaseUIResources.getImageDescriptor(
        IAdtBaseImages.COLLAPSE_ALL));
    this.viewer = viewer;
  }

  @Override
  public void run() {
    final IStructuredSelection selection = viewer.getStructuredSelection();
    if (selection == null) {
      return;
    }
    for (final Object sel : selection.toList()) {
      viewer.collapseToLevel(sel, AbstractTreeViewer.ALL_LEVELS);
    }
  }

  public void setViewer(final TreeViewer viewer) {
    this.viewer = viewer;
  }
}