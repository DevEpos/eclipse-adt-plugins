package com.devepos.adt.base.ui.event;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;

/**
 * Utility for key event checks
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class KeyEventUtil {

  /**
   * Returns {@code true} if the key event matches the Ctrl/Command+f shortcut
   *
   * @param e the key event
   * @return
   */
  public static boolean isDefaultFindKeyStroke(final KeyEvent e) {
    return e.keyCode == 'f' && (e.stateMask == SWT.CTRL || e.stateMask == SWT.COMMAND);
  }
}
