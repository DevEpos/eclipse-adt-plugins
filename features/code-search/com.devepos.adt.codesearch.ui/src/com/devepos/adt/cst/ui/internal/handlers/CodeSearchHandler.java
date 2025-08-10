package com.devepos.adt.cst.ui.internal.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.base.ui.adtobject.AdtObjectFactory;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.ui.projectexplorer.node.IAbapRepositoryFolderNode;
import com.devepos.adt.base.ui.projectexplorer.virtualfolders.IVirtualFolderNode;
import com.devepos.adt.base.ui.search.IChangeableSearchPage;
import com.devepos.adt.base.ui.search.ISearchPageListener;
import com.devepos.adt.base.ui.search.SearchPageUtil;
import com.devepos.adt.base.ui.util.AdtUIUtil;
import com.devepos.adt.cst.ui.internal.TmViewAdapterHelper;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchDialog;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuery;
import com.devepos.adt.cst.ui.internal.converter.AbapRepositoryFolderToQueryConverter;
import com.devepos.adt.cst.ui.internal.converter.AdtObjectSelectionToQueryConverter;
import com.devepos.adt.cst.ui.internal.converter.VirtualFolderToQueryConverter;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Handler implementation for code search command
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CodeSearchHandler extends AbstractHandler implements ISearchPageListener {

  private CodeSearchQuery searchQuery;

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    searchQuery = null;
    var selection = HandlerUtil.getCurrentSelection(event);
    if (selection == null) {
      return null;
    }

    if (selection instanceof IStructuredSelection) {
      var structSelection = (IStructuredSelection) selection;
      if (structSelection.size() > 1) {
        List<IAdtObject> selectedObjects = null;
        var activePart = HandlerUtil.getActivePart(event);
        // special handling for ADT transport view, as the project is not directly accessible
        if (TmViewAdapterHelper.isPartTmView(activePart)) {
          selectedObjects = getSelectedTransportObjects((IStructuredSelection) selection,
              activePart);
        } else {
          selectedObjects = AdtUIUtil.getAdtObjectsFromSelection(false, selection);
        }
        createQueryFromAdtObjects(selectedObjects, selection);
      } else {
        var selectedObject = structSelection.getFirstElement();
        var virtualFolderNode = Adapters.adapt(selectedObject, IVirtualFolderNode.class);
        if (virtualFolderNode != null) {
          searchQuery = new VirtualFolderToQueryConverter(virtualFolderNode).convert();
        } else {
          var repositoryFolder = Adapters.adapt(selectedObject, IAbapRepositoryFolderNode.class);
          if (repositoryFolder != null) {
            searchQuery = new AbapRepositoryFolderToQueryConverter(repositoryFolder).convert();
          } else {
            var adtObject = Adapters.adapt(selectedObject, IAdtObject.class);
            createQueryFromAdtObjects(adtObject == null ? null : Arrays.asList(adtObject),
                selection);
          }
        }
      }
    } else {
      createQueryFromAdtObjects(AdtUIUtil.getAdtObjectsFromSelection(false, selection), selection);
    }

    if (searchQuery == null) {
      return null;
    }

    SearchPageUtil.addSearchPageOpenListener(this);
    NewSearchUI.openSearchDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
        CodeSearchDialog.PAGE_ID);
    return null;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void pageOpened(final ISearchPage searchPage) {
    if (searchPage instanceof IChangeableSearchPage) {
      ((IChangeableSearchPage) searchPage).setInputFromSearchQuery(searchQuery);
    }
  }

  private List<IAdtObject> getSelectedTransportObjects(final IStructuredSelection selection,
      final IWorkbenchPart activePart) {
    var project = TmViewAdapterHelper.getProjectFromTmView(activePart);
    if (project != null) {
      List<IAdtObject> selectedTranportObjects = new ArrayList<>();
      for (var selObj : selection) {
        var trObject = Adapters.adapt(selObj, IAdtObjectReference.class);
        if (trObject != null) {
          selectedTranportObjects.add(AdtObjectFactory.create(trObject, project));
        }
      }
      return selectedTranportObjects;
    }
    // fallback: maybe the method was renamed or removed or did not return a project
    // for some reason
    return AdtUIUtil.getAdtObjectsFromSelection(false, selection);
  }

  private void createQueryFromAdtObjects(final List<IAdtObject> selectedObjects,
      final ISelection selection) {

    if (selectedObjects == null || selectedObjects.isEmpty()) {
      return;
    }
    searchQuery = new AdtObjectSelectionToQueryConverter(selectedObjects).convert();
    if (selection instanceof ITextSelection) {
      searchQuery.getQuerySpecs().setPatterns(((ITextSelection) selection).getText());
    }
  }

}
