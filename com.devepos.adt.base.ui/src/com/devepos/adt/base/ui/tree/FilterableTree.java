package com.devepos.adt.base.ui.tree;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.devepos.adt.base.ui.controls.FilterableComposite;

/**
 * Filterable Tree
 *
 * @author stockbal
 *
 */
public class FilterableTree extends FilterableComposite<TreeViewer, Tree> {

    private boolean expandAllOnEmptyFilter = true;

    /**
     * Creates new Filtered Tree control.<br/>
     * It is a composite control comprised of a {@link Text} and {@link Tree}
     * control
     *
     * @param parent             the parent
     * @param treeStyle          SWT bits used for the tree control
     * @param placeholderText    the placeholder text for the filter input
     * @param hideFilterControls if {@code true} the filter controls are hidden
     *                           initially
     */
    public FilterableTree(final Composite parent, final int treeStyle, final String placeholderText,
        final boolean hideFilterControls) {
        super(parent, placeholderText, hideFilterControls);
        setViewer(new TreeViewer(this, treeStyle));
    }

    /**
     * Sets field {@code expandAllOnEmptyFilter}. <br>
     * If {@code true} all nodes of the tree are expanded if the filter
     *
     * @param expandAllOnEmptyFilter
     */
    public void setExpandAllOnFilterEmpty(final boolean expandAllOnEmptyFilter) {
        this.expandAllOnEmptyFilter = expandAllOnEmptyFilter;
    }

    @Override
    protected void filterJobCompleted() {
        if (expandAllOnEmptyFilter) {
            String filterString = getFilterString();
            if (filterString == null || filterString.trim().length() == 0) {
                viewer.expandAll();
                selectFirstItem();
            }
        }
    }

    @Override
    protected void beforeUpdatingSelection() {
        viewer.expandAll();
    }

    @Override
    protected Tree getViewerControl() {
        return viewer != null ? viewer.getTree() : null;
    }

    @Override
    protected int getViewerItemsCount() {
        return viewerControl != null ? viewerControl.getItemCount() : 0;
    }

    @Override
    protected void updateSelection(final boolean setFocus) {
        viewer.expandAll();
        IStructuredSelection selection = viewer.getStructuredSelection();
        if (setFocus && !viewerControl.isFocusControl()) {
            viewerControl.setFocus();
        }
        if (selection.isEmpty() || !isElementMatching(selection.getFirstElement())) {
            Object item = getFirstMatchingItem(viewerControl.getItems());
            if (item != null) {
                viewer.setSelection(new StructuredSelection(item), true);
            }
        }
    }

    @Override
    protected void selectFirstItem() {
        if (viewerControl.getItemCount() > 0) {
            viewerControl.setSelection(viewerControl.getItem(0));
            viewer.setSelection(viewer.getSelection(), true);
        }
    }

    private Object getFirstMatchingItem(final TreeItem[] treeItems) {
        for (TreeItem treeItem : treeItems) {
            if (isElementMatching(treeItem.getData())) {
                return treeItem.getData();
            }
            if (treeItem.getItemCount() > 0) {
                return getFirstMatchingItem(treeItem.getItems());
            }
        }
        return null;
    }
}
