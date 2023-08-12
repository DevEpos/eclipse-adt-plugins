package com.devepos.adt.base.ui.util;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * Utility handling some common workbench stuff
 *
 * @author stockbal
 *
 */
public class WorkbenchUtil {
  /**
   * Brings the active part of the active page to the front
   */
  public static void bringActivePartToFront() {
    IWorkbenchPage activePage = PlatformUI.getWorkbench()
        .getActiveWorkbenchWindow()
        .getActivePage();
    if (activePage == null) {
      return;
    }
    IWorkbenchPart activePart = activePage.getActivePart();
    if (activePart != null && activePage.isPartVisible(activePart)) {
      activePage.bringToTop(activePart);
    }
  }

  /**
   * Brings the given part to the top of the active page, but only if the
   * {@code part} is visible in the active page
   *
   * @param part a workbench part
   */
  public static void bringPartToFront(final IWorkbenchPart part) {
    if (part == null) {
      return;
    }
    IWorkbenchPage activePage = PlatformUI.getWorkbench()
        .getActiveWorkbenchWindow()
        .getActivePage();
    if (activePage == null) {
      return;
    }
    if (activePage.isPartVisible(part)) {
      activePage.bringToTop(part);
    }
  }
}
