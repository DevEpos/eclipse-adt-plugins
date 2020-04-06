package com.devepos.adt.tools.base.util;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * Helper class for editor stuff
 *
 * @author stockbal
 */
public class EditorUtil {

	/**
	 * Retrieves the active Editor Input or <code>null</code>
	 *
	 * @return
	 */
	public static IEditorInput getActiveEditorInput() {
		final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (activePage == null) {
			return null;
		}

		final IEditorPart activePart = activePage.getActiveEditor();
		if (activePart == null) {
			return null;
		}

		return activePart.getEditorInput();
	}
}
