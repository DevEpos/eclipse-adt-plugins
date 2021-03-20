package com.devepos.adt.base.ui.tree;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.ui.action.IExecutable;

/**
 * Represents a node in a {@link org.eclipse.jface.viewers.TreeViewer}
 *
 * @author stockbal
 */
public class ActionTreeNode extends SimpleInfoTreeNode {
    private final IExecutable action;

    public ActionTreeNode(final String name, final Image image, final ITreeNode parent, final IExecutable action) {
        super(name, image, parent);
        this.action = action;
    }

    public IExecutable getAction() {
        return action;
    }

}
