package com.devepos.adt.base.ui.search;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.sap.adt.ris.search.ui.AdtRepositorySearchServiceUIFactory;
import com.sap.adt.ris.search.ui.IAdtRepositorySearchServiceUIParameters;
import com.sap.adt.ris.search.ui.IAdtRepositorySearchServiceUIResult;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

@SuppressWarnings("restriction")
public final class AdtRisSearchUtil {

  private AdtRisSearchUtil() {
  }

  /**
   * Retrieves result from ADT Repository Quick search dialog. The used shell for the dialog is the
   * shell of the active workbench window
   *
   * @param dialogTitle       title for the search dialog
   * @param multipleSelection if {@code true} multiple object can be selected
   * @return the result from the search dialog
   */
  public static IAdtRisSearchResultProxy searchAdtObjectViaDialog(final String dialogTitle,
      final boolean multipleSelection, final IProject fixedProject) {
    return searchAdtObjectViaDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
        dialogTitle, multipleSelection, null, fixedProject);
  }

  /**
   * Retrieves result from ADT Repository Quick search dialog
   *
   * @param shell             the shell to be used
   * @param dialogTitle       title for the search dialog
   * @param multipleSelection if {@code true} multiple object can be selected
   * @param types             list of types that can be used
   * @return the result from the search dialog
   */
  public static IAdtRisSearchResultProxy searchAdtObjectViaDialog(Shell shell,
      final String dialogTitle, final boolean multipleSelection, List<String> types,
      final IProject fixedProject) {
    final IAdtRepositorySearchServiceUIParameters parameters = AdtRepositorySearchServiceUIFactory
        .createAdtRepositorySearchServiceUIParameters();
    parameters.setTitle(dialogTitle);
    parameters.setFixedProject(fixedProject);
    if (types != null) {
      parameters.setObjectTypes(types);
    }
    parameters.setMultiSelectionEnabled(multipleSelection);
    final IAdtRepositorySearchServiceUIResult result = AdtRepositorySearchServiceUIFactory
        .createAdtRepositorySearchServiceUI()
        .openDialog(shell, parameters);

    if (result == null) {
      return null;
    }

    return new AdtRisSearchResultProxy(result);
  }

  private static class AdtRisSearchResultProxy implements IAdtRisSearchResultProxy {

    private final IAdtRepositorySearchServiceUIResult result;

    public AdtRisSearchResultProxy(final IAdtRepositorySearchServiceUIResult result) {
      this.result = result;
    }

    @Override
    public IProject getSelectedProject() {
      return result != null ? result.getSelectedProject() : null;
    }

    @Override
    public IAdtObjectReference getFirstResult() {
      return result != null ? result.getFirstSelectedObjectReference() : null;
    }

    @Override
    public IAdtObjectReference[] getAllSelectedResults() {
      return result != null ? result.getAllSelectedObjectReferences() : null;
    }
  }
}
