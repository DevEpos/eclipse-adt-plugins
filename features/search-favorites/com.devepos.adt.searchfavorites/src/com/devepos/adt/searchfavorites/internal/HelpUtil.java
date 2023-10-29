package com.devepos.adt.searchfavorites.internal;

import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

/**
 * Utility for easily setting help context to controls
 *
 * @author stockbal
 */
public class HelpUtil {

  /**
   * Sets the help with the given context id to the given control
   *
   * @param control   a control
   * @param contextId relative id of a help context
   */
  public static void setHelp(final Control control, final String contextId) {
    if (control == null || control.isDisposed()) {
      return;
    }
    PlatformUI.getWorkbench()
        .getHelpSystem()
        .setHelp(control, getFullyQualifiedContextId(contextId));
  }

  /**
   * Returns the fully qualified help context id for the given context
   *
   * @param contextId relative id of a help context
   * @return
   */
  public static String getFullyQualifiedContextId(final String contextId) {
    return "com.devepos.adt.searchfavorites." + contextId; //$NON-NLS-1$
  }
}
