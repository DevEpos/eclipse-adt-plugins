package com.devepos.adt.cst.ui.internal;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IWorkbenchPart;

import com.devepos.adt.base.util.Reflection;

/**
 * Helper to retrieve the project from the current selection in the Transport Organizer View.
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class TmViewAdapterHelper {
  private static final String TM_VIEW_ID = "com.sap.adt.tm.ui.tmview"; //$NON-NLS-1$

  public static boolean isPartTmView(final IWorkbenchPart part) {
    return part != null && TM_VIEW_ID.equals(part.getSite().getId());
  }

  public static IProject getProjectFromTmView(final IWorkbenchPart part) {
    /*
     * Reflection is the only possible option here as retrieving the project via IProjectProvider
     * and getAdapter() call fails with a ClassCastException
     */
    var project = Reflection.forObject(part).invoke("getProject"); //$NON-NLS-1$
    if (project instanceof IProject) {
      return (IProject) project;
    }
    return null;
  }
}
