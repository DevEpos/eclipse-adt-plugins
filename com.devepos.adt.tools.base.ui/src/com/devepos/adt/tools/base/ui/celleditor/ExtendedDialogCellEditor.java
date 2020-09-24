package com.devepos.adt.tools.base.ui.celleditor;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
	protected Control createContents(final Composite cell) {
		final Control control = super.createContents(cell);
		control.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(final MouseEvent event) {
				if (ExtendedDialogCellEditor.this.button != null) {
					ExtendedDialogCellEditor.this.button.notifyListeners(SWT.Selection, null);
				}
			}
		});
		return control;
	}

	@Override
	protected Button createButton(final Composite parent) {
		this.button = super.createButton(parent);
		return this.button;
	}

}