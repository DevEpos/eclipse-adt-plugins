package com.devepos.adt.base.ui.table;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import com.devepos.adt.base.ui.controls.FilterableComposite;

/**
 * Table Viewer with a filter text control on top
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class FilterableTable extends FilterableComposite<TableViewer, Table> {

  /**
   * Creates a new filterable Table control
   *
   * @see {@link FilterableComposite#FilterableComposite(Composite, String, boolean, boolean)}
   *
   */
  public FilterableTable(final Composite parent, final String placeholderText,
      final boolean hideFilterControls, final boolean enableToolbarMode) {
    super(parent, placeholderText, hideFilterControls, enableToolbarMode);
  }

  @Override
  protected Table getViewerControl() {
    return viewer != null ? viewer.getTable() : null;
  }

  @Override
  protected int getViewerItemsCount() {
    return viewerControl != null ? viewerControl.getItemCount() : 0;
  }

  @Override
  protected void selectFirstItem() {
    if (viewerControl.getItemCount() > 0) {
      viewerControl.setSelection(viewerControl.getItem(0));
      viewer.setSelection(viewer.getSelection(), true);
    }
  }

  @Override
  protected void updateSelection(final boolean setFocus) {
    // for table there is nothing else to do but set the focus to the viewer
    if (setFocus && !viewerControl.isFocusControl()) {
      viewerControl.setFocus();
    }
  }

}
