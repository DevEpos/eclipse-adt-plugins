package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.saat.ui.internal.messages.Messages;

/**
 * History drop down action for all CDS analyses in the history buffer
 *
 * @author stockbal
 */
class CdsAnalysisHistoryDropDownAction extends Action implements IMenuCreator {

  private Menu menu;
  private final CdsAnalysisView analysisView;

  public CdsAnalysisHistoryDropDownAction(final CdsAnalysisView analysisView) {
    super(Messages.CdsAnalysis_SwitchAnalysisPages_xtol,
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.HISTORY_LIST));
    setMenuCreator(this);
    this.analysisView = analysisView;
  }

  private class ShowAnalysisAction extends Action {
    private final CdsAnalysis analysis;

    public ShowAnalysisAction(final CdsAnalysis analysis) {
      super(analysis.getLabel(), AS_RADIO_BUTTON);
      this.analysis = analysis;
      setImageDescriptor(analysis.getImageDescriptor());
    }

    @Override
    public void run() {
      runIfChecked(false);
    }

    @Override
    public void runWithEvent(final Event event) {
      runIfChecked(event.stateMask == SWT.CTRL);
    }

    private void runIfChecked(final boolean openNewAnalysisView) {
      if (!analysis.checkProjectAvailability()) {
        return;
      }
      if (isChecked()) {
        CdsAnalysisManager.getInstance().showAnalysis(analysisView, analysis, openNewAnalysisView);
      }
    }
  }

  @Override
  public void dispose() {
    disposeMenu();
  }

  public void disposeMenu() {
    if (menu != null && !menu.isDisposed()) {
      menu.dispose();
    }
  }

  @Override
  public Menu getMenu(final Control parent) {
    disposeMenu();
    menu = new Menu(parent);

    final var currentAnalysis = analysisView.getCurrentAnalysis();
    final var availableTypes = analysisView.getConfiguredAnalysisTypes();

    for (final var analysis : CdsAnalysisManager.getInstance().getAnalyses()) {
      if (!availableTypes.contains(analysis.getType())) {
        continue;
      }
      final var showAnalysisPageAction = new ShowAnalysisAction(analysis);
      showAnalysisPageAction.setChecked(analysis == currentAnalysis);
      addActionToMenu(menu, showAnalysisPageAction);
    }
    if (menu.getItemCount() > 0) {
      final var separator = new Separator();
      separator.fill(menu, -1);
    }
    addActionToMenu(menu, ActionFactory.createAction(Messages.CdsAnalysis_ManageHistory_xmit, null,
        this::openManagePageDialog));
    addActionToMenu(menu, ActionFactory.createAction(Messages.CdsAnalysis_ClearHistoryAction_xmit,
        null, () -> CdsAnalysisManager.getInstance().removeAll()));
    return menu;
  }

  @Override
  public Menu getMenu(final Menu parent) {
    return null;
  }

  @Override
  public void run() {
    openManagePageDialog();
  }

  @Override
  public void setEnabled(final boolean enabled) {
    super.setEnabled(enabled);
  }

  /**
   * Updates the enabled state of the action depending on the availability of CDS Analysis results
   */
  public void updateEnablement() {
    setEnabled(CdsAnalysisManager.getInstance().hasAnalyses());
  }

  /*
   * Adds the given action to the given menu
   */
  private void addActionToMenu(final Menu parent, final IAction action) {
    final ActionContributionItem item = new ActionContributionItem(action);
    item.fill(parent, -1);
  }

  private void openManagePageDialog() {
    final var analysisManager = CdsAnalysisManager.getInstance();
    final List<CdsAnalysis> analyses = new ArrayList<>();
    for (final var analysis : analysisManager.getAnalyses()) {
      analyses.add(analysis);
    }

    final var dialog = new ManageCdsAnalysesDialog(analyses,
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
    if (dialog.open() == Window.OK) {
      final var selectedAnalysis = dialog.getSelectedAnalysis();
      if (selectedAnalysis != null) {
        analysisManager.showAnalysis(selectedAnalysis, dialog.isOpenInNew());
      }
      final var removedAnalyses = dialog.getDeletedAnalyses();
      if (removedAnalyses != null && !removedAnalyses.isEmpty()) {
        for (final var analysisToRemove : removedAnalyses) {
          analysisManager.removeAnalysis(analysisToRemove);
        }
      }
    }
  }
}