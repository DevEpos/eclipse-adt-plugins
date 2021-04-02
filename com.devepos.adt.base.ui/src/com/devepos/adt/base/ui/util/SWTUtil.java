package com.devepos.adt.base.ui.util;

import java.util.Objects;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * Some utility methods for SWT
 *
 * @author stockbal
 */
public class SWTUtil {

    /**
     * Sets focus to the given control if the label control is accessed via the
     * menmonic letter
     *
     * @param label   the label for the control
     * @param control the control which should be focused via the label
     */
    public static void setLabelForControl(final Label label, final Control control) {
        Objects.requireNonNull(control, "control must not be null"); //$NON-NLS-1$
        label.addTraverseListener(e -> {
            if (e.detail == SWT.TRAVERSE_MNEMONIC && e.doit) {
                e.detail = SWT.TRAVERSE_NONE;
                control.setFocus();
            }
        });
    }

    /**
     * Sets the visibility status of the control and layouts the parent
     *
     * @param control the control
     * @param visible if {@code true} the control should be shown
     */
    public static void setControlVisible(final Control control, final boolean visible) {
        if (control == null || control.isDisposed()) {
            return;
        }
        control.setVisible(visible);
        final GridData gd = (GridData) control.getLayoutData();
        gd.exclude = !visible;
        control.setLayoutData(gd);
        control.getParent().layout();
    }
}
