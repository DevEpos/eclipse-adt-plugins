package com.devepos.adt.tools.base.util;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.tools.base.adtobject.IAdtObject;

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
		final IEditorPart activePart = getActiveEditor();
		if (activePart == null) {
			return null;
		}

		return activePart.getEditorInput();
	}

	/**
	 * Returns the active editor part of the current workbench window
	 *
	 * @return
	 */
	public static IEditorPart getActiveEditor() {
		final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (activePage == null) {
			return null;
		}

		final IEditorPart activePart = activePage.getActiveEditor();
		return activePart;
	}

	/**
	 * Returns the ADT object from currently active editor or <code>null</code> if
	 * the editor content cannot be adapted to an instance of {@link IAdtObject}
	 *
	 * @return
	 */
	public static IAdtObject getAdtObjectFromActiveEditor() {
		final IEditorPart activeEditor = getActiveEditor();
		return activeEditor != null ? Adapters.adapt(activeEditor, IAdtObject.class) : null;
	}

	/**
	 * Returns the ADT Object instance from the given editor part
	 *
	 * @param  editorPart editor part
	 * @return            the ADT object instance of the editor or {@code null}
	 */
	public static IAdtObject getAdtObjectFromEditor(final IEditorPart editorPart) {
		return Adapters.adapt(editorPart, IAdtObject.class);
	}
}
