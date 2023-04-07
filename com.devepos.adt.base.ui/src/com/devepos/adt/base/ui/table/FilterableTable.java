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
   * @param parent             the parent composite
   * @param placeholderText    the placeholder text for the filter control
   * @param hideFilterControls flag to control initial visibility of the filter control
   * @param enableToolbarMode  if {@code true} then the filter control will not occupy the fullwidth
   *                           of the viewer
   * 
   */
  public FilterableTable(Composite parent, String placeholderText, boolean hideFilterControls,
      boolean enableToolbarMode) {
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
  protected void updateSelection(boolean setFocus) {
    // for table there is nothing else to do but set the focus to the viewer
    if (setFocus && !viewerControl.isFocusControl()) {
      viewerControl.setFocus();
    }
  }

}
