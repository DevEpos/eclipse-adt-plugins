package com.devepos.adt.callhierarchy.ui.internal;

import java.net.URI;
import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.MultiPageEditorPart;

import com.sap.adt.project.IProjectProvider;
import com.sap.adt.tools.core.ui.editors.IAdtFormEditor;
import com.sap.adt.tools.core.ui.internal.navigation.ITextNavigationSource;
import com.sap.adt.tools.core.urimapping.AdtUriMappingServiceFactory;
import com.sap.adt.tools.core.urimapping.IAdtUriMappingService;

/**
 * Helper class to determine an ADT URI from the current selection in the workbench
 * 
 * @author Ludwig Stockbauer-Muhr
 */
@SuppressWarnings("restriction")
public class AdtUriSelectionHelper {

  public static URI extractUriFromEvent(final ExecutionEvent event) throws RuntimeException {
    URI uri = null;
    ISelection sel = HandlerUtil.getCurrentSelection(event);
    if (sel instanceof IStructuredSelection) {
      com.sap.adt.tools.core.IAdtObjectReference selectedRef = getFirstObjectInSelection(
          (IStructuredSelection) sel);
      if (selectedRef != null) {
        uri = selectedRef.getUri();
      }
    } else {
      IWorkbenchPart part = HandlerUtil.getActivePart(event);
      if (part instanceof MultiPageEditorPart) {
        MultiPageEditorPart adtEditor = (MultiPageEditorPart) part;
        ITextNavigationSource navSource = adtEditor.<ITextNavigationSource>getAdapter(
            ITextNavigationSource.class);
        if (navSource != null) {
          uri = navSource.getResourceUri(true, true);
          // navSource.getProject();
        } else {
          IFile file = findSelectedFileInEditor(adtEditor);
          if (file != null) {
            // file.getProject();
            IAdtUriMappingService uriMappingService = AdtUriMappingServiceFactory
                .createUriMappingService();
            uri = uriMappingService.getAdtUri(file);
          }
        }
      }
    }
    return uri;
  }

  private static IFile findSelectedFileInEditor(final MultiPageEditorPart adtEditor) {
    if (adtEditor instanceof IAdtFormEditor) {
      IFile f = ((IAdtFormEditor) adtEditor).getFile(adtEditor.getActivePage());
      return f;
    }
    IEditorInput input = adtEditor.getEditorInput();
    if (input instanceof IFileEditorInput) {
      IFile file = ((IFileEditorInput) input).getFile();
      return file;
    }
    return null;
  }

  private static com.sap.adt.tools.core.IAdtObjectReference getFirstObjectInSelection(
      final IStructuredSelection sel) {
    IStructuredSelection selection = sel;
    new ArrayList<>(selection.size());
    for (Object selObj : selection) {
      com.sap.adt.tools.core.IAdtObjectReference reference = Adapters.adapt(selObj,
          com.sap.adt.tools.core.IAdtObjectReference.class);
      IProjectProvider projectProvider = Adapters.adapt(selObj, IProjectProvider.class);
      if (reference != null && projectProvider != null) {
        return reference;
      }
    }
    return null;
  }
}
