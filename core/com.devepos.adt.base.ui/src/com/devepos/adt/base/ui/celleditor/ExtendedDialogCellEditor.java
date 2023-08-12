package com.devepos.adt.base.ui.celleditor;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * This uses a label provider to display a dialog cell editor.
 */
public abstract class ExtendedDialogCellEditor extends DialogCellEditor {
  private Button button;

  public ExtendedDialogCellEditor(final Composite composite) {
    super(composite);
  }

  @Override
  protected Button createButton(final Composite parent) {
    button = super.createButton(parent);
    return button;
  }

  @Override
  protected Control createContents(final Composite cell) {
    final Control control = super.createContents(cell);
    control.addMouseListener(MouseListener.mouseUpAdapter(e -> {
      if (button != null) {
        button.notifyListeners(SWT.Selection, null);
      }
    }));
    return control;
  }

}