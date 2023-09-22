package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.destinations.IDestinationProvider;
import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.base.ui.IGeneralMenuConstants;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.ILazyLoadingListener;
import com.devepos.adt.base.ui.tree.IStyledTreeNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.saat.cdsanalysis.CdsAnalysisServiceFactory;
import com.devepos.adt.saat.cdsanalysis.IWhereUsedInCdsAnalysisConstants;
import com.devepos.adt.saat.ui.internal.ICommandConstants;
import com.devepos.adt.saat.ui.internal.IContextMenuConstants;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.TreeViewUiState;
import com.devepos.adt.saat.ui.internal.ViewUiState;
import com.devepos.adt.saat.ui.internal.cdsanalysis.ICdsAnalysisPreferences;
import com.devepos.adt.saat.ui.internal.cdsanalysis.IWhereUsedInCdsSettings;
import com.devepos.adt.saat.ui.internal.menu.SearchToolsMenuItemFactory;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.CommandPossibleChecker;
import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 * Where-Used page of CDS Analysis page
 *
 * @see {@link CdsAnalyzerPage}
 * @author stockbal
 */
public class WhereUsedInCdsAnalysisView extends CdsAnalysisPage<WhereUsedInCdsAnalysis> {
  private final ILazyLoadingListener lazyLoadingListener;
  private Action showFromUses;
  private Action showAssocUses;
  private Action releasedUsagesOnly;
  private Action localAssociationsOnly;
  private Action searchRecursivelyAction;
  private ExpandAllAction expandAllAction;

  public WhereUsedInCdsAnalysisView(final CdsAnalysisView parentView) {
    super(parentView);
    lazyLoadingListener = count -> {
      PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
        parentView.updateLabel();
      });
    };
  }

  @Override
  public void dispose() {
    super.dispose();
  }

  @Override
  public void setActionBars(final IActionBars actionBars) {
    super.setActionBars(actionBars);
    final IMenuManager menu = actionBars.getMenuManager();
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, showFromUses);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, showAssocUses);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_ADDITIONS, searchRecursivelyAction);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_ADDITIONS, releasedUsagesOnly);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_ADDITIONS, localAssociationsOnly);
  }

  @Override
  protected void configureTreeViewer(final TreeViewer treeViewer) {
    contentProvider = new LazyLoadingTreeContentProvider();
    contentProvider.setExpansionChecker(null);
    treeViewer.setContentProvider(contentProvider);
    treeViewer.setUseHashlookup(true);
    treeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(
        new TreeViewerLabelProvider()));
  }

  @Override
  protected void createActions() {
    super.createActions();

    expandAllAction = new ExpandAllAction();
    expandAllAction.setTreeViewer((TreeViewer) getViewer());

    showFromUses = ActionFactory.createAction(
        Messages.WhereUsedInCdsAnalysisView_ShowUsesInSelectPartAction_xmit, SearchAndAnalysisPlugin
            .getDefault()
            .getImageDescriptor(IImages.DATA_SOURCE), IAction.AS_CHECK_BOX, () -> {
              analysisResult.getSettings().setSearchFromPart(showFromUses.isChecked());
              analysisResult.updateWhereUsedProvider();
              updateViewerFromSettings();
              refreshAnalysis();
            });

    showAssocUses = ActionFactory.createAction(
        Messages.WhereUsedInCdsAnalysisView_ShowUsesInAssociationsAction_xmit,
        SearchAndAnalysisPlugin.getDefault().getImageDescriptor(IImages.ASSOCIATION),
        IAction.AS_CHECK_BOX, () -> {
          analysisResult.getSettings().setSearchAssociation(showAssocUses.isChecked());
          analysisResult.updateWhereUsedProvider();
          updateViewerFromSettings();
          refreshAnalysis();
        });

    localAssociationsOnly = ActionFactory.createAction(
        Messages.WhereUsedInCdsAnalysisView_OnlyLocallyDefinedAssocUsages_xmit, null,
        IAction.AS_CHECK_BOX, () -> {
          analysisResult.getSettings().setLocalAssociationsOnly(localAssociationsOnly.isChecked());
          analysisResult.updateWhereUsedProvider();
          refreshAnalysis();
        });
    localAssociationsOnly.setEnabled(false);

    releasedUsagesOnly = ActionFactory.createAction(
        Messages.WhereUsedInCdsAnalysisView_OnlyUsagesInReleasedEntities_xmit, null,
        IAction.AS_CHECK_BOX, () -> {
          analysisResult.getSettings().setReleasedUsagesOnly(releasedUsagesOnly.isChecked());
          analysisResult.updateWhereUsedProvider();
          refreshAnalysis();
        });
    showAssocUses.addPropertyChangeListener(event -> {
      if (!showAssocUses.isChecked()) {
        showFromUses.setChecked(true);
        analysisResult.getSettings().setSearchFromPart(true);
      }
    });
    showFromUses.addPropertyChangeListener(event -> {
      if (!showFromUses.isChecked()) {
        showAssocUses.setChecked(true);
        analysisResult.getSettings().setSearchAssociation(true);
      }
    });
    searchRecursivelyAction = ActionFactory.createAction("Search for References recursively", null,
        IAction.AS_CHECK_BOX, () -> {
          analysisResult.getSettings().setSearchRecursively(searchRecursivelyAction.isChecked());
          expandAllAction.setEnabled(searchRecursivelyAction.isChecked());
          updateViewerFromSettings();
          refreshAnalysis();
        });
    searchRecursivelyAction.setToolTipText(
        "References in SELECT parts of CDS Views are searched recursively");
  }

  @Override
  protected void fillContextMenu(final IMenuManager mgr,
      final CommandPossibleChecker commandPossibleChecker) {
    super.fillContextMenu(mgr, commandPossibleChecker);
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.CDS_TOP_DOWN_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.CDS_TOP_DOWN_ANALYSIS);
    }
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.USED_ENTITIES_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.USED_ENTITIES_ANALYSIS);
    }
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.FIELD_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.FIELD_ANALYSIS);
    }

  @Override
  protected void fillToolbar(final IToolBarManager tbm) {
    tbm.appendToGroup(IGeneralMenuConstants.GROUP_NODE_ACTIONS, expandAllAction);

    super.fillToolbar(tbm);
  }

  @Override
  protected StyledString getTreeNodeLabel(final Object element) {
    StyledString text = null;
    final ITreeNode node = (ITreeNode) element;

    if (element instanceof IStyledTreeNode) {
      text = ((IStyledTreeNode) element).getStyledText();
    } else {
      text = new StyledString();
      if (element instanceof LoadingTreeItemsNode) {
        text.append(node.getDisplayName(), StylerFactory.ITALIC_STYLER);
      } else {
        text.append(" "); // for broader image due to overlay //$NON-NLS-1$
        text.append(node.getDisplayName());
      }

      if (element instanceof ICollectionTreeNode) {
        final String size = ((ICollectionTreeNode) element).getSizeAsString();
        if (size != null) {
          if ((!analysisResult.getSettings().isSearchRecursively() || analysisResult.getSettings()
              .isSearchAssociations()) && !"0".equals(size)) {
            text.append(" (" + size + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
          }
        }
      }

      final String description = node.getDescription();
      if (description != null && !description.isEmpty()) {
        text.append("  " + description + "  ", //$NON-NLS-1$ //$NON-NLS-2$
            StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
      }
    }
    return text;
  }

  @Override
  protected ViewUiState getUiState() {
    final TreeViewUiState uiState = new TreeViewUiState();
    uiState.setFromTreeViewer((TreeViewer) getViewer());
    return uiState;
  }

  @Override
  protected void loadInput(final ViewUiState uiState) {
    checkFeatureState();
    final TreeViewer viewer = (TreeViewer) getViewer();
    if (analysisResult.isResultLoaded()) {
      setActionStateFromSettings();
      updateViewerFromSettings();
      viewer.setInput(analysisResult.getResult());
      if (uiState instanceof TreeViewUiState) {
        ((TreeViewUiState) uiState).applyToTreeViewer(viewer);
      } else {
        final Object[] input = (Object[]) viewer.getInput();
        if (input != null && input.length >= 1) {
          viewer.expandToLevel(input[0], 1);
          viewer.setSelection(new StructuredSelection(input[0]));
        }
      }
    } else {
      initActionState();
      updateViewerFromSettings();
      analysisResult.createResult(lazyLoadingListener);
      viewer.setInput(analysisResult.getResult());
      analysisResult.setResultLoaded(true);
      viewer.expandAll();
    }
  }

  @Override
  protected void refreshAnalysis() {
    analysisResult.refreshAnalysis();
    getViewPart().updateLabel();
    getViewer().refresh();
  }

  private void checkFeatureState() {
    final IAdtObjectReferenceElementInfo adtObjElemInfo = analysisResult.getAdtObjectInfo();
    final IDestinationProvider destProvider = adtObjElemInfo.getAdapter(IDestinationProvider.class);
    var whereUsedInTemplate = CdsAnalysisServiceFactory.getCdsAnalysisService()
        .getWhereUsedInCdsAnalysisTemplate(destProvider.getDestinationId());

    boolean isLocalAssocOnlyFeatureAvailable = whereUsedInTemplate != null && whereUsedInTemplate
        .containsVariable(
            IWhereUsedInCdsAnalysisConstants.QUERY_PARAM_LOCAL_DECLARED_ASSOCIATIONS_ONLY);
    localAssociationsOnly.setEnabled(isLocalAssocOnlyFeatureAvailable);
    releasedUsagesOnly.setEnabled(whereUsedInTemplate != null && whereUsedInTemplate
        .containsVariable(IWhereUsedInCdsAnalysisConstants.QUERY_PARAM_RELEASED_ENTITIES_ONLY));
  }

  private void initActionState() {
    IPreferenceStore prefStore = SearchAndAnalysisPlugin.getDefault().getPreferenceStore();
    boolean isSearchFrom = prefStore.getBoolean(ICdsAnalysisPreferences.WHERE_USED_USES_IN_SELECT);
    boolean isSearchAssoc = prefStore.getBoolean(ICdsAnalysisPreferences.WHERE_USED_USES_IN_ASSOC);
    boolean isSearchRecursively = prefStore.getBoolean(
        ICdsAnalysisPreferences.WHERE_USED_SEARCH_RECURSIVELY);

    boolean isLocalAssocOnly = prefStore.getBoolean(
        ICdsAnalysisPreferences.WHERE_USED_LOCAL_ASSOCIATIONS_ONLY);
    boolean isReleasedUsagesOnly = prefStore.getBoolean(
        ICdsAnalysisPreferences.WHERE_USED_ONLY_RELEASED_USAGES);

    showFromUses.setChecked(isSearchFrom);
    showAssocUses.setChecked(isSearchAssoc);
    releasedUsagesOnly.setChecked(isReleasedUsagesOnly);
    localAssociationsOnly.setChecked(isReleasedUsagesOnly);
    searchRecursivelyAction.setChecked(isSearchRecursively);
    expandAllAction.setEnabled(isSearchRecursively);

    if (analysisResult != null) {
      IWhereUsedInCdsSettings settings = analysisResult.getSettings();
      settings.setSearchFromPart(isSearchFrom);
      settings.setSearchAssociation(isSearchAssoc);
      settings.setLocalAssociationsOnly(isLocalAssocOnly);
      settings.setReleasedUsagesOnly(isReleasedUsagesOnly);
      settings.setSearchRecursively(isSearchRecursively);
    }
  }

  private void setActionStateFromSettings() {
    var analysisSettings = analysisResult.getSettings();
    showFromUses.setChecked(analysisSettings.isSearchFromPart());
    showAssocUses.setChecked(analysisSettings.isSearchAssociations());
    localAssociationsOnly.setChecked(analysisSettings.isLocalAssociationsOnly());
    releasedUsagesOnly.setChecked(analysisSettings.isReleasedUsagesOnly());
    searchRecursivelyAction.setChecked(analysisSettings.isSearchRecursively());
    expandAllAction.setEnabled(analysisSettings.isSearchRecursively());
  }

  private void updateViewerFromSettings() {
    if (analysisResult.getSettings().isSearchRecursively() && showFromUses.isChecked()
        && !showAssocUses.isChecked()) {
      contentProvider.setNodeRefreshOptions(TreeViewer.ALL_LEVELS,
          LazyLoadingRefreshMode.ROOT_AND_ALL_CHILDREN);
    } else {
      contentProvider.setNodeRefreshOptions(1, null);
    }
  }
}
