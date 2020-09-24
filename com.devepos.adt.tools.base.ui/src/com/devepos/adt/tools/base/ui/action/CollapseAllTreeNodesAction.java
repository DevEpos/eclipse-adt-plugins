package com.devepos.adt.tools.base.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import com.devepos.adt.tools.base.ui.AdtToolsBaseUIResources;
import com.devepos.adt.tools.base.ui.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.ui.internal.messages.Messages;

/**
 * Action for collapsing all nodes in the given {@link TreeViewer}
 *
 * @author stockbal
 */
public class CollapseAllTreeNodesAction extends Action {
	private final TreeViewer viewer;

	public CollapseAllTreeNodesAction(final TreeViewer viewer) {
		super(Messages.Actions_CollapseAllNodes_xmit, AdtToolsBaseUIResources.getImageDescriptor(IAdtToolsBaseImages.COLLAPSE_ALL));
		this.viewer = viewer;
	}

	@Override
	public void run() {
		this.viewer.getControl().setRedraw(false);
		try {
			this.viewer.collapseAll();
		} finally {
			this.viewer.getControl().setRedraw(true);
		}
	}
}