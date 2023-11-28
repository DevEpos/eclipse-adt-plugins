package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.help.HelpContextId;
import com.devepos.adt.saat.ui.internal.help.HelpUtil;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class CdsAnalysisTypeConfigurationAction extends Action implements IMenuCreator {
  private Menu menu;
  private final CdsAnalysisView cdsAnalysisView;
  private CdsAnalysis currentAnalysis;

  public CdsAnalysisTypeConfigurationAction(final CdsAnalysisView cdsAnalysisView) {
    super(Messages.CdsAnalysisTypeConfigurationAction_ActionTitle_xtit,
        SearchAndAnalysisPlugin.getDefault().getImageDescriptor(IImages.CDS_ANALYSIS_MODE_SWITCH));
    this.cdsAnalysisView = cdsAnalysisView;
    setMenuCreator(this);
  }

  private class AnalysisTypeSelectionDialog extends ListSelectionDialog {
    @SuppressWarnings("deprecation")
    public AnalysisTypeSelectionDialog(final Shell shell,
        final List<CdsAnalysisType> selectedTypes) {
      super(shell, Arrays.asList(CdsAnalysisType.values()), new ArrayContentProvider(),
          new LabelProvider(),
          Messages.CdsAnalysisTypeConfigurationAction_AnalysisTypeListHeader_xlbl);
      setTitle(Messages.CdsAnalysisTypeConfigurationAction_ConfigureDialog_xtit);
      setInitialElementSelections(selectedTypes);
      setHelpAvailable(true);
    }

    @Override
    protected Control createContents(final Composite parent) {
      HelpUtil.setHelp(parent, HelpContextId.ANALYSIS_TYPE_CONFIG);
      return super.createContents(parent);
    }

    @Override
    public void create() {
      super.create();
      getShell().setImage(
          SearchAndAnalysisPlugin.getDefault().getImage(IImages.CDS_ANALYSIS_MODE_SWITCH));
      getViewer().setComparator(new ViewerComparator());
      getViewer().addCheckStateListener(e -> updateOkButton());
      var listener = SelectionListener.widgetSelectedAdapter(e -> updateOkButton());

      getButton(IDialogConstants.SELECT_ALL_ID).addSelectionListener(listener);
      getButton(IDialogConstants.DESELECT_ALL_ID).addSelectionListener(listener);
    }

    @Override
    protected void buttonPressed(final int buttonId) {
      super.buttonPressed(buttonId);
      if (buttonId == IDialogConstants.SELECT_ALL_ID
          || buttonId == IDialogConstants.DESELECT_ALL_ID) {
        updateOkButton();
      }
    }

    private void updateOkButton() {
      getOkButton().setEnabled(getViewer().getCheckedElements().length > 0);
    }
  }

  @Override
  public void run() {
    configureAnalysisTypes();
  }

  public void setCurrentAnalysis(final CdsAnalysis currentAnalysis) {
    this.currentAnalysis = currentAnalysis;
  }

  @Override
  public void dispose() {
    disposeMenu();
  }

  @Override
  public Menu getMenu(final Control parent) {
    disposeMenu();
    menu = new Menu(parent);

    if (currentAnalysis != null) {
      var isCds = currentAnalysis.getAdtObjectInfo()
          .getAdtType()
          .equals(IAdtObjectTypeConstants.DATA_DEFINITION);

      switch (currentAnalysis.getType()) {
      case TOP_DOWN:
        addWhereUsedAction();
        addFieldAnalysisAction();
        addUsedEntitiesAnalysis(isCds);
        break;
      case WHERE_USED:
        addTopDownAction(isCds);
        addFieldAnalysisAction();
        addUsedEntitiesAnalysis(isCds);
        break;
      case FIELD_ANALYSIS:
        addTopDownAction(isCds);
        addWhereUsedAction();
        addUsedEntitiesAnalysis(isCds);
        break;
      case DEPENDENCY_TREE_USAGES:
        addTopDownAction(isCds);
        addWhereUsedAction();
        addFieldAnalysisAction();
        break;
      }
    }

    if (menu.getItemCount() == 0) {
      var noInpuAction = new Action(
          currentAnalysis == null ? Messages.CdsAnalysisTypeConfigurationAction_NoAnalysisInput_xmsg
              : Messages.CdsAnalysisTypeConfigurationAction_NoApplicableTypesAvailable_xmsg) {
      };
      noInpuAction.setEnabled(false);
      addActionToMenu(noInpuAction);
    }

    var sep = new Separator();
    sep.fill(menu, -1);

    // add action to switch modes
    addActionToMenu(ActionFactory.createAction(
        Messages.CdsAnalysisTypeConfigurationAction_DropdownActionTitle_xmit, null,
        this::configureAnalysisTypes));

    return menu;
  }

  @Override
  public Menu getMenu(final Menu parent) {
    return null;
  }

  private void disposeMenu() {
    if (menu != null && !menu.isDisposed()) {
      menu.dispose();
    }
  }

  private void addTopDownAction(final boolean isCds) {
    if (!isCds
        || !cdsAnalysisView.getConfiguredAnalysisTypes().contains(CdsAnalysisType.TOP_DOWN)) {
      return;
    }
    addActionToMenu(new RunCdsAnalysisAction(cdsAnalysisView, CdsAnalysisType.TOP_DOWN,
        currentAnalysis.getAdtObjectInfo(), currentAnalysis.getProject()));
  }

  private void addWhereUsedAction() {
    if (!cdsAnalysisView.getConfiguredAnalysisTypes().contains(CdsAnalysisType.WHERE_USED)) {
      return;
    }
    addActionToMenu(new RunCdsAnalysisAction(cdsAnalysisView, CdsAnalysisType.WHERE_USED,
        currentAnalysis.getAdtObjectInfo(), currentAnalysis.getProject()));
  }

  private void addFieldAnalysisAction() {
    if (!cdsAnalysisView.getConfiguredAnalysisTypes().contains(CdsAnalysisType.FIELD_ANALYSIS)) {
      return;
    }
    addActionToMenu(new RunCdsAnalysisAction(cdsAnalysisView, CdsAnalysisType.FIELD_ANALYSIS,
        currentAnalysis.getAdtObjectInfo(), currentAnalysis.getProject()));
  }

  private void addUsedEntitiesAnalysis(final boolean isCds) {
    if (!isCds || !cdsAnalysisView.getConfiguredAnalysisTypes()
        .contains(CdsAnalysisType.DEPENDENCY_TREE_USAGES)) {
      return;
    }
    addActionToMenu(
        new RunCdsAnalysisAction(cdsAnalysisView, CdsAnalysisType.DEPENDENCY_TREE_USAGES,
            currentAnalysis.getAdtObjectInfo(), currentAnalysis.getProject()));
  }

  /*
   * Adds the given action to the given menu
   */
  private void addActionToMenu(final IAction action) {
    final var item = new ActionContributionItem(action);
    item.fill(menu, -1);
  }

  private void configureAnalysisTypes() {
    var dialog = new AnalysisTypeSelectionDialog(
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
        cdsAnalysisView.getConfiguredAnalysisTypes());

    if (dialog.open() == Window.OK) {
      List<CdsAnalysisType> selectedTypes = new ArrayList<>();
      for (var result : dialog.getResult()) {
        selectedTypes.add((CdsAnalysisType) result);
      }
      cdsAnalysisView.setConfiguredAnalysisTypes(selectedTypes);
    }
  }
}
