package com.devepos.adt.base.ui.util;

import java.util.Objects;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.keys.IBindingService;

/**
 * Some utility methods for SWT
 *
 * @author stockbal
 */
public class SWTUtil {

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
   * Retrieves key stroke for the given command id. If none could be found the fallback key stroke
   * will be returned instead
   *
   * @param commandId id of registered workbench command
   * @param fallback  key stroke instance to be used as fallback
   * @return the found key stroke or the fallback key stroke
   */
  public static KeyStroke getKeyStrokeForCommandId(final String commandId,
      final KeyStroke fallback) {
    try {
      if (Platform.isRunning()) {
        final var service = PlatformUI.getWorkbench().getService(IBindingService.class);
        if (service != null) {
          final var binding = service.getBestActiveBindingFor(commandId);
          if (binding instanceof KeySequence) {
            final var keyStrokes = ((KeySequence) binding).getKeyStrokes();

            // we only consider bindings with a single key stroke
            if (keyStrokes.length == 1) {
              return keyStrokes[0];
            }
          }
        }
      }
    } catch (final Exception e) {
    }

    return fallback;
  }
}
