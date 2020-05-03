package com.devepos.adt.tools.base.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.WorkbenchPart;

import com.devepos.adt.tools.base.AdtToolsBasePlugin;
import com.devepos.adt.tools.base.adtobject.IAdtObject;
import com.devepos.adt.tools.base.internal.messages.Messages;
import com.sap.adt.communication.message.HeadersFactory;
import com.sap.adt.communication.message.IHeaders;
import com.sap.adt.destinations.ui.logon.AdtLogonServiceUIFactory;
import com.sap.adt.project.IAdtCoreProject;
import com.sap.adt.project.IProjectProvider;
import com.sap.adt.project.ui.util.ProjectUtil;
import com.sap.adt.sapgui.ui.editors.AdtSapGuiEditorUtilityFactory;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;
import com.sap.adt.tools.core.project.AdtProjectServiceFactory;
import com.sap.adt.tools.core.project.IAbapProject;
import com.sap.adt.tools.core.ui.navigation.AdtNavigationServiceFactory;
import com.sap.adt.tools.core.wbtyperegistry.WorkbenchAction;

/**
 * ADT convenience methods
 *
 * @author stockbal
 */
@SuppressWarnings("restriction")
public class AdtUtil {
	/**
	 * Overrides the title of an embedded SAP GUI Editor Part with the given
	 * <code>partName</code> and <code>imageId</code>
	 *
	 * @param project      the project of the SAP GUI editor
	 * @param partName     the new name for the part
	 * @param titleToolTip the new tooltip for the part
	 * @param image        the new image of the part
	 */
	public static void overrideSapGuiPartTitle(final WorkbenchPart part, final IProject project, final String partName,
		final String titleToolTip, final Image image) {
		if (part == null) {
			return;
		}
		final IAbapProject abapProject = project.getAdapter(IAbapProject.class);

		final String newPartName = String.format("[%s] %s", abapProject.getSystemId(), partName); //$NON-NLS-1$
		final String newTitleTooltip = titleToolTip != null
			? String.format("%s [%s]", titleToolTip, abapProject.getDestinationDisplayText()) //$NON-NLS-1$
			: null;

		final IPropertyListener listener = (object, id) -> {
			if (id == 1) {
				Reflection.forObject(part).invoke("setPartName", new Class[] { String.class }, new Object[] { newPartName }); //$NON-NLS-1$
				if (newTitleTooltip != null) {
					Reflection.forObject(part)
						.invoke("setTitleToolTip", new Class[] { String.class }, new Object[] { newTitleTooltip }); //$NON-NLS-1$
				}
				if (image != null) {
					Reflection.forObject(part).invoke("setTitleImage", new Class[] { Image.class }, new Object[] { image }); //$NON-NLS-1$
				}
			}
		};
		part.addPropertyListener(listener);
	}

	/**
	 * Retrieve headers for REST request
	 *
	 * @return
	 */
	public static IHeaders getHeaders() {
		final IHeaders headers = HeadersFactory.newHeaders();
		headers.addField(HeadersFactory.newField("Accept", "application/xml")); //$NON-NLS-1$ //$NON-NLS-2$
		return headers;
	}

	/**
	 * Returns a simple DB Browser Tools compatible ADT object from the current
	 * selection
	 *
	 * @return
	 */
	public static IAdtObject getAdtObjectFromSelection(final boolean supportsDataPreview) {
		final List<IAdtObject> adtObjects = getAdtObjectsFromSelection(supportsDataPreview);
		return adtObjects != null && !adtObjects.isEmpty() ? adtObjects.get(0) : null;
	}

	/**
	 * Returns a List of simple DB Browser Tools compatible ADT objects from the
	 * current selection
	 *
	 * @return
	 */
	public static List<IAdtObject> getAdtObjectsFromSelection(final boolean supportsDataPreview) {
		List<IAdtObject> adtObjects = null;
		final ISelection selection = SelectionUtil.getSelection();

		if (selection != null) {
			if (selection instanceof ITreeSelection) {
				adtObjects = getObjectFromTreeSelection((ITreeSelection) selection);
			} else if (selection instanceof ITextSelection) {
				final IAdtObject adtObject = getObjectFromActiveEditor();
				if (adtObject != null) {
					adtObjects = Arrays.asList(adtObject);
				}
			}
		}
		if (adtObjects != null && supportsDataPreview) {
			adtObjects = adtObjects.stream()
				.filter(obj -> obj.getObjectType().supportsDataPreview())
				.collect(Collectors.toList());
		}
		return adtObjects;
	}

	public static IProject adaptAsProject(final Object object) {
		final IProjectProvider adaptedProjectProvider = Adapters.adapt(object, IProjectProvider.class);
		if (adaptedProjectProvider != null) {
			return adaptedProjectProvider.getProject();
		}
		final IProject adaptedProject = Adapters.adapt(object, IProject.class);
		if (adaptedProject != null) {
			return adaptedProject;
		}
		return null;
	}

	/**
	 * Read destination id from the given project. If the project is not of type
	 * {@link IAbapProject} <code>null</code> will be returned
	 *
	 * @param  project project instance which must be adaptable to type
	 *                 {@link IAbapProject}
	 * @return
	 */
	public static String getDestinationId(final IProject project) {
		if (project == null) {
			return null;
		}
		final IAbapProject abapProject = project.getAdapter(IAbapProject.class);
		return abapProject != null ? abapProject.getDestinationId() : null;
	}

	/**
	 * Navigates to the given adt object reference
	 *
	 * @param objectReference the object reference for the navigation
	 * @param project         the project the object should be opened in
	 */
	public static void navigateWithObjectReference(final IAdtObjectReference objectReference, final IProject project) {
		if (objectReference == null || project == null) {
			return;
		}

		AdtNavigationServiceFactory.createNavigationService().navigate(project, objectReference, true);
	}

	/**
	 * Opens the given Object reference in an integrated SAP GUI editor in the
	 * current eclipse instance
	 *
	 * @param objectReference the ADT object reference to be opened
	 * @param project         the project where the object reference should be
	 *                        opened in
	 */
	public static void openAdtObjectRefInSapGui(final IAdtObjectReference objectReference, final IProject project) {
		AdtSapGuiEditorUtilityFactory.createSapGuiEditorUtility()
			.openEditorForObject(project, objectReference, true, WorkbenchAction.DISPLAY.toString(), null,
				Collections.<String, String>emptyMap());
	}

	/**
	 * Retrieve a list of all ABAP projects in the current workspace
	 *
	 * @return List of ABAP projects
	 */
	public static IProject[] getAbapProjects() {
		return AdtProjectServiceFactory.createProjectService().getAvailableAbapProjects();
	}

	/**
	 * Ensures that the users is logged on to given project
	 *
	 * @param  project the ABAP Project to ensure the logged on status
	 * @return         Logged On Status for the given project
	 */
	public static IStatus ensureLoggedOnToProject(final IProject project) {
		final IAbapProject abapProject = project.getAdapter(IAbapProject.class);

		if (AdtLogonServiceUIFactory.createLogonServiceUI()
			.ensureLoggedOn(abapProject.getDestinationData(), PlatformUI.getWorkbench().getProgressService())
			.isOK()) {
			return Status.OK_STATUS;
		} else {
			return new Status(IStatus.ERROR, AdtToolsBasePlugin.PLUGIN_ID,
				NLS.bind(Messages.AdtUtil_LogonToProjectFailed_xmsg, project.getName()));
		}
	}

	/**
	 * Retrieve the currently active ABAP Project
	 *
	 * @return
	 */
	public static IProject getCurrentAbapProject() {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return null;
		}
		final ISelection selection = window.getSelectionService().getSelection();
		return ProjectUtil.getActiveAdtCoreProject(selection, null, null, IAdtCoreProject.ABAP_PROJECT_NATURE);
	}

	/**
	 * Returns the ADT object from currently active editor or <code>null</code> if
	 * the editor content cannot be adapted to an instance of {@link IAdtObject}
	 *
	 * @return
	 */
	public static IAdtObject getObjectFromActiveEditor() {
		final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (activePage == null) {
			return null;
		}
		final IEditorPart activeEditor = activePage.getActiveEditor();
		if (activeEditor == null) {
			return null;
		}
		final IEditorInput input = activeEditor.getEditorInput();
		if (input == null) {
			return null;
		}
		return Adapters.adapt(input, IAdtObject.class);
	}

	private static List<IAdtObject> getObjectFromTreeSelection(final ITreeSelection selection) {
		List<IAdtObject> adtObjects = null;
		for (final Object selectionItem : selection.toList()) {
			final IAdtObject adtObject = Adapters.adapt(selectionItem, IAdtObject.class);
			if (adtObject == null) {
				continue;
			}
			if (adtObjects == null) {
				adtObjects = new ArrayList<>();
			}

			adtObjects.add(adtObject);

		}
		return adtObjects;
	}

}
