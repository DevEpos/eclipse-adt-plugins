package com.devepos.adt.callhierarchy.ui.internal;

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
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.callhierarchy.ui.internal.dialog.ManageHierarchyHistoryDialog;
import com.devepos.adt.callhierarchy.ui.internal.views.CallHierarchyView;

public class HistoryDropDownAction extends Action implements IMenuCreator {

  private Menu menu;
  private final CallHierarchyView callHierarchyView;

  public HistoryDropDownAction(final CallHierarchyView callHierarchyView) {
    super("Show Previous Hierarchies", AdtBaseUIResources.getImageDescriptor(
        IAdtBaseImages.HISTORY_LIST));
    setMenuCreator(this);
    this.callHierarchyView = callHierarchyView;
  }

  @Override
  public void dispose() {
    disposeMenu();
  }

  @Override
  public void setEnabled(final boolean enabled) {
    super.setEnabled(enabled);
  }

  @Override
  public Menu getMenu(final Control parent) {
    disposeMenu();
    menu = new Menu(parent);

    final CallHierarchyInput currentHierarchy = callHierarchyView.getCurrentInput();

    for (final CallHierarchyInput hierarchyInput : CallHierarchyManager.getInstance()
        .getHierarchies()) {
      final IAction showHierarchyHistoryAction = new ShowHistoryHierarchyAction(hierarchyInput);
      showHierarchyHistoryAction.setChecked(hierarchyInput == currentHierarchy);
      addActionToMenu(menu, showHierarchyHistoryAction);
    }
    final Separator separator = new Separator();
    separator.fill(menu, -1);
    addActionToMenu(menu, new Action(AdtBaseUIResources.getString(
        IAdtBaseStrings.OpenHistory_xmit)) {
      @Override
      public void run() {
        openManageHierarchiesDialog();
      }
    });
    addActionToMenu(menu, new Action(AdtBaseUIResources.getString(
        IAdtBaseStrings.ClearHistory_xmit)) {
      @Override
      public void run() {
        CallHierarchyManager.getInstance().removeAll();
      }
    });
    return menu;
  }

  public void disposeMenu() {
    if (menu != null && !menu.isDisposed()) {
      menu.dispose();
    }
  }

  @Override
  public Menu getMenu(final Menu parent) {
    return null;
  }

  @Override
  public void run() {
    openManageHierarchiesDialog();
  }

  private void openManageHierarchiesDialog() {
    final CallHierarchyManager hierarchyManager = CallHierarchyManager.getInstance();
    final List<CallHierarchyInput> hierarchies = new ArrayList<>();
    for (final CallHierarchyInput hierarchy : hierarchyManager.getHierarchies()) {
      hierarchies.add(hierarchy);
    }

    final ManageHierarchyHistoryDialog dialog = new ManageHierarchyHistoryDialog(hierarchies,
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
    if (dialog.open() == Window.OK) {
      final CallHierarchyInput selectedHierarchy = dialog.getSelectedHierarchy();
      if (selectedHierarchy != null) {
        hierarchyManager.showHierarchy(selectedHierarchy, dialog.isOpenInNew());
      }
      final List<CallHierarchyInput> removedHierarchies = dialog.getDeletedHierarchies();
      if (removedHierarchies != null && !removedHierarchies.isEmpty()) {
        for (final CallHierarchyInput hierarchyToRemove : removedHierarchies) {
          hierarchyManager.removeHierarchy(hierarchyToRemove);
        }
      }
    }
  }

  /*
   * Adds the given action to the given menu
   */
  private void addActionToMenu(final Menu parent, final IAction action) {
    final ActionContributionItem item = new ActionContributionItem(action);
    item.fill(parent, -1);
  }

  private class ShowHistoryHierarchyAction extends Action {
    private final CallHierarchyInput callHierarchy;

    public ShowHistoryHierarchyAction(final CallHierarchyInput callHierarchy) {
      super(callHierarchy.getLabelForHistory(), AS_RADIO_BUTTON);
      this.callHierarchy = callHierarchy;
      setImageDescriptor(callHierarchy.getImageDescr());
    }

    @Override
    public void runWithEvent(final Event event) {
      runIfChecked(event.stateMask == SWT.CTRL);
    }

    @Override
    public void run() {
      runIfChecked(false);
    }

    private void runIfChecked(boolean openNewAnalysisView) {
      if (isChecked())
        CallHierarchyManager.getInstance().showHierarchy(callHierarchy, openNewAnalysisView);
    }
  }
}