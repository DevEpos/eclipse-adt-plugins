package com.devepos.adt.base.ui.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.part.WorkbenchPart;

import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.util.Reflection;
import com.sap.adt.sapgui.ui.editors.AdtSapGuiEditorUtilityFactory;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;
import com.sap.adt.tools.core.project.IAbapProject;
import com.sap.adt.tools.core.ui.navigation.AdtNavigationServiceFactory;
import com.sap.adt.tools.core.wbtyperegistry.WorkbenchAction;

/**
 * ADT convenience methods for UI
 *
 * @author stockbal
 */
@SuppressWarnings("restriction")
public class AdtUIUtil {
  /**
   * Returns a simple DB Browser Tools compatible ADT object from the current
   * selection
   *
   * @param supportsDataPreview flag to indicate that only ADT objects that
   *                            support Data Preview should be considered
   * @return
   */
  public static IAdtObject getAdtObjectFromSelection(final boolean supportsDataPreview) {
    return getAdtObjectFromSelection(supportsDataPreview, null);
  }

  /**
   * Returns a simple DB Browser Tools compatible ADT object from the current
   * selection
   *
   * @param supportsDataPreview flag to indicate that only ADT objects that
   *                            support Data Preview should be considered
   * @param sel                 optional selection instance that should be used to
   *                            determine the selected ADT objects
   * @return
   */
  public static IAdtObject getAdtObjectFromSelection(final boolean supportsDataPreview,
      final ISelection sel) {
    final List<IAdtObject> adtObjects = getAdtObjectsFromSelection(supportsDataPreview, sel);
    return adtObjects != null && !adtObjects.isEmpty() ? adtObjects.get(0) : null;
  }

  /**
   * Returns a List of simple DB Browser Tools compatible ADT objects from the
   * current selection
   *
   * @param supportsDataPreview flag to indicate that only ADT objects that
   *                            support Data Preview should be considered
   * @return
   */
  public static List<IAdtObject> getAdtObjectsFromSelection(final boolean supportsDataPreview) {
    return getAdtObjectsFromSelection(supportsDataPreview, null);
  }

  /**
   * Returns a List of simple DB Browser Tools compatible ADT objects from the
   * current selection
   *
   * @param supportsDataPreview flag to indicate that only ADT objects that
   *                            support Data Preview should be considered
   * @param sel                 optional selection instance that should be used to
   *                            determine the selected ADT objects
   * @return
   */
  public static List<IAdtObject> getAdtObjectsFromSelection(final boolean supportsDataPreview,
      final ISelection sel) {
    List<IAdtObject> adtObjects = null;
    final ISelection selection = sel != null ? sel : SelectionUtil.getSelection();

    if (selection != null) {
      if (selection instanceof IStructuredSelection) {
        adtObjects = getObjectFromTreeSelection((IStructuredSelection) selection);
      } else if (selection instanceof ITextSelection) {
        final IAdtObject adtObject = EditorUtil.getAdtObjectFromActiveEditor();
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

  /**
   * Navigates to the given adt object reference
   *
   * @param objectReference the object reference for the navigation
   * @param project         the project the object should be opened in
   */
  public static void navigateWithObjectReference(final IAdtObjectReference objectReference,
      final IProject project) {
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
  public static void openAdtObjectRefInSapGui(final IAdtObjectReference objectReference,
      final IProject project) {
    AdtSapGuiEditorUtilityFactory.createSapGuiEditorUtility()
        .openEditorForObject(project, objectReference, true, WorkbenchAction.DISPLAY.toString(),
            null, Collections.<String, String>emptyMap());
  }

  /**
   * Overrides the title of an embedded SAP GUI Editor Part with the given
   * <code>partName</code> and <code>imageId</code>
   *
   * @param project      the project of the SAP GUI editor
   * @param partName     the new name for the part
   * @param titleToolTip the new tooltip for the part
   * @param image        the new image of the part
   */
  public static void overrideSapGuiPartTitle(final WorkbenchPart part, final IProject project,
      final String partName, final String titleToolTip, final Image image) {
    if (part == null) {
      return;
    }
    final IAbapProject abapProject = project.getAdapter(IAbapProject.class);

    final String newPartName = String.format("[%s] %s", abapProject.getSystemId(), partName); //$NON-NLS-1$
    final String newTitleTooltip = titleToolTip != null ? String.format("%s [%s]", titleToolTip, //$NON-NLS-1$
        abapProject.getDestinationDisplayText()) : null;

    final IPropertyListener listener = (object, id) -> {
      if (id == 1) {
        Reflection.forObject(part).invoke("setPartName", new Class[] { String.class }, newPartName); //$NON-NLS-1$
        if (newTitleTooltip != null) {
          Reflection.forObject(part)
              .invoke("setTitleToolTip", new Class[] { String.class }, newTitleTooltip); //$NON-NLS-1$
        }
        if (image != null) {
          Reflection.forObject(part).invoke("setTitleImage", new Class[] { Image.class }, image); //$NON-NLS-1$
        }
      }
    };
    part.addPropertyListener(listener);
  }

  private static List<IAdtObject> getObjectFromTreeSelection(final IStructuredSelection selection) {
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
