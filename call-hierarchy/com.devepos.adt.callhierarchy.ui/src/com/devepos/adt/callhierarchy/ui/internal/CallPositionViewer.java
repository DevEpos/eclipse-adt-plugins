package com.devepos.adt.callhierarchy.ui.internal;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;

import com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition;

public class CallPositionViewer extends TableViewer {

  public CallPositionViewer(Composite parent) {
    super(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);

    setContentProvider(ArrayContentProvider.getInstance());
    setLabelProvider(new ColumnLabelProvider());
    setInput(new ArrayList<ICallPosition>());

    createColumns();
  }

  /**
   * Enum for columns in Call Position viewer
   *
   * @author Ludwig Stockbauer-Muhr
   *
   */
  private enum CallPositionColumn {
    ICON("", new ColumnPixelData(18, false, true)),
    LINE("Line", new ColumnWeightData(60));

    private final String label;
    private final ColumnLayoutData layoutData;

    CallPositionColumn(final String label, final ColumnLayoutData layoutData) {
      this.layoutData = layoutData;
      this.label = label;
    }
  }

  private void createColumns() {
    TableLayout layout = new TableLayout();
    getTable().setLayout(layout);
    getTable().setHeaderVisible(true);

    CallPositionColumn[] columns = CallPositionColumn.values();

    for (int i = 0; i < columns.length; i++) {
      CallPositionColumn column = columns[i];
      layout.addColumnData(column.layoutData);
      TableColumn tc = new TableColumn(getTable(), SWT.NONE, i);

      tc.setResizable(column.layoutData.resizable);
      tc.setText(column.label);
    }
  }

  private class ColumnLabelProvider extends LabelProvider implements ITableLabelProvider {

    @Override
    public Image getColumnImage(Object element, int columnIndex) {
      if (CallPositionColumn.ICON.ordinal() == columnIndex) {
        return Activator.getDefault().getImage(IImages.CALL_POSITION);
      }
      return null;
    }

    @Override
    public String getColumnText(Object element, int columnIndex) {
      if (element instanceof ICallPosition) {
        if (columnIndex == CallPositionColumn.LINE.ordinal()) {
          return String.valueOf(((ICallPosition) element).getLine());
        }
      }
      return null;
    }

  }
}