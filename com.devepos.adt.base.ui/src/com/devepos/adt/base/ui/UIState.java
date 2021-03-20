package com.devepos.adt.base.ui;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;

/**
 * UI State for e.g. Search View Result Pages
 *
 * @author stockbal
 */
public class UIState {
    private ISelection selection;

    /**
     * @return the stored selection
     */
    public ISelection getSelection() {
        return selection;
    }

    /**
     * @return <code>true</code> if the stored state has a selection
     */
    public boolean hasSelection() {
        return selection != null && !selection.isEmpty();
    }

    /**
     * @param selection the selectedObject to set
     */
    public void setSelection(final ISelection selection) {
        this.selection = selection;
    }

    private TreePath[] expandedPaths;

    /**
     * @return the expandedPaths
     */
    public TreePath[] getExpandedPaths() {
        return expandedPaths;
    }

    /**
     * @param expandedPaths the expandedPaths to set
     */
    public void setExpandedPaths(final TreePath[] expandedPaths) {
        this.expandedPaths = expandedPaths;
    }

}
