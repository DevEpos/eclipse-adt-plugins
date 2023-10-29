package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPageSite;

import com.devepos.adt.base.destinations.IDestinationProvider;
import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.LazyLoadingRefreshMode;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.ContextHelper;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IGeneralCommandConstants;
import com.devepos.adt.base.ui.IGeneralContextConstants;
import com.devepos.adt.base.ui.IGeneralMenuConstants;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.action.CommandFactory;
import com.devepos.adt.base.ui.action.ExpandAllAction;
import com.devepos.adt.base.ui.tree.FilterableTree;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.IFilterableView;
import com.devepos.adt.base.ui.tree.ILazyLoadingListener;
import com.devepos.adt.base.ui.tree.IStyledTreeNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.cdsanalysis.CdsAnalysisServiceFactory;
import com.devepos.adt.saat.cdsanalysis.IWhereUsedInCdsAnalysisConstants;
import com.devepos.adt.saat.ui.internal.ICommandConstants;
import com.devepos.adt.saat.ui.internal.IContextMenuConstants;
import com.devepos.adt.saat.ui.internal.IExtendedAdtObjectInfo;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.TreeViewUiState;
import com.devepos.adt.saat.ui.internal.ViewUiState;
import com.devepos.adt.saat.ui.internal.cdsanalysis.ICdsAnalysisPreferences;
import com.devepos.adt.saat.ui.internal.cdsanalysis.IWhereUsedInCdsSettings;
import com.devepos.adt.saat.ui.internal.help.HelpContextId;
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
public class WhereUsedInCdsAnalysisView extends CdsAnalysisPage<WhereUsedInCdsAnalysis> implements
    IFilterableView {
  private final ILazyLoadingListener lazyLoadingListener;
  private Action showFromUses;
  private Action showAssocUses;
  private Action releasedUsagesOnly;
  private Action localAssociationsOnly;
  private Action filterAction;
  private Action resetFilterAction;
  private Action releasedEntitiesFilterAction;
  private Action searchRecursivelyAction;
  private ITreeNode lastFilteredNode;
  private boolean releasedEntitiesFilterActive;
  private boolean selectionFilterActive;
  private final ViewerFilter treeFilter = new TreeFilter();
  private final Set<Object> filteredNodes = new HashSet<>();
  private LazyLoadingTreeContentProvider contentProvider;
  private ExpandAllAction expandAllAction;
  private FilterableTree resultTree;
  private ContextHelper contextHelper;

  public WhereUsedInCdsAnalysisView(final CdsAnalysisView parentView) {
    super(parentView);
    lazyLoadingListener = count -> {
      PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
        parentView.updateLabel();
      });
    };

  }

  private class ReleasedPathsFilterAction extends Action {
    public ReleasedPathsFilterAction() {
      super(Messages.WhereUsedInCdsAnalysisView_FilterOnReleasedEntities_xmit);
    }

    @Override
    public void run() {
      filteredNodes.clear();
      lastFilteredNode = null;
      selectionFilterActive = false;
      releasedEntitiesFilterActive = true;
      analysisResult.setFiltered(true);
      getViewPart().updateLabel();

      try {
        var input = (Object[]) analysisResult.getResult();
        var resultNode = (ICollectionTreeNode) input[0];
        findReleasedDownward(resultNode);
        getViewer().refresh(false);
      } catch (Exception exc) {
      }
    }

    private void collectTreePathUpwards(final ITreeNode node) {
      filteredNodes.add(node);

      var parent = node.getParent();

      while (parent != null) {
        filteredNodes.add(parent);
        parent = parent.getParent();
      }
    }

    private void findReleasedDownward(final ICollectionTreeNode folderNode) {
      var children = folderNode.getChildren();
      if (children.isEmpty()) {
        return;
      }

      for (var child : children) {
        var extendedInfo = child.getAdapter(IExtendedAdtObjectInfo.class);
        if (extendedInfo != null && extendedInfo.isReleased()) {
          collectTreePathUpwards(child);
        }
        if (child instanceof ICollectionTreeNode) {
          findReleasedDownward((ICollectionTreeNode) child);
        }
      }
    }
  }

  private class TreeFilter extends ViewerFilter {

    @Override
    public Object[] filter(final Viewer viewer, final Object parent, final Object[] elements) {
      if (!selectionFilterActive && !releasedEntitiesFilterActive) {
        return elements;
      }
      return super.filter(viewer, parent, elements);
    }

    @Override
    public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
      var node = (ITreeNode) element;

      if (node.getParent() == null) {
        return true;
      }
      if (releasedEntitiesFilterActive && filteredNodes.isEmpty()) {
        return false;
      }
      if (filteredNodes.isEmpty() || filteredNodes.contains(element)
          || parentElement == lastFilteredNode) {
        return true;
      }
      if (lastFilteredNode == null) {
        return false;
      }
      var collectionNode = (ICollectionTreeNode) lastFilteredNode;
      if (collectionNode.getParent() == null) {
        return false;
      }
      var children = collectionNode.getChildren();
      if (isInChildren(children, element)) {
        return true;
      }

      return false;
    }

    private boolean isInChildren(final List<ITreeNode> children, final Object element) {
      if (children == null || children.isEmpty()) {
        return false;
      }

      for (var child : children) {
        if (child == element) {
          return true;
        }
        if (child instanceof ICollectionTreeNode) {
          var grandChildren = ((ICollectionTreeNode) child).getChildren();
          if (isInChildren(grandChildren, element)) {
            return true;
          }
        }
      }
      return false;
    }
  }

  private class UiState extends TreeViewUiState {
    private ITreeNode lastFilteredNodeState;
    private boolean releasedEntitiesFilterActiveState;
    private boolean selectionFilterActiveState;
    private final Set<Object> filteredNodesState = new HashSet<>();
    private String textFilterState;

    @Override
    public void applyToTreeViewer(final TreeViewer viewer) {
      super.applyToTreeViewer(viewer);
      lastFilteredNode = lastFilteredNodeState;
      filteredNodes.addAll(filteredNodesState);
      releasedEntitiesFilterActive = releasedEntitiesFilterActiveState;
      selectionFilterActive = selectionFilterActiveState;
      if (!StringUtil.isEmpty(textFilterState)) {
        resultTree.setFilterText(textFilterState, false);
        resultTree.setFilterVisible(true);
      } else {
        resultTree.resetFilter(false);
        resultTree.setFilterVisible(false);
      }
    }

    @Override
    public void setFromTreeViewer(final TreeViewer viewer) {
      super.setFromTreeViewer(viewer);
      lastFilteredNodeState = lastFilteredNode;
      releasedEntitiesFilterActiveState = releasedEntitiesFilterActive;
      selectionFilterActiveState = selectionFilterActive;
      filteredNodesState.clear();
      filteredNodesState.addAll(filteredNodes);
      textFilterState = resultTree.getFilterString();
    }
  }

  @Override
  public void dispose() {
    super.dispose();
    if (contextHelper != null) {
      contextHelper.deactivateAllContexts();
    }
  }

  @Override
  public HelpContextId getHelpContextId() {
    return HelpContextId.CDS_ANALYZER_WHERE_USED_ANALYSIS;
  }

  @Override
  public void init(final IPageSite pageSite) {
    super.init(pageSite);
    contextHelper = ContextHelper.createForServiceLocator(getSite());
    contextHelper.activateContext(IGeneralContextConstants.FILTERABLE_VIEWS);
  }

  @Override
  public void setActionBars(final IActionBars actionBars) {
    super.setActionBars(actionBars);
    final IMenuManager menu = actionBars.getMenuManager();
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, showFromUses);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, showAssocUses);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, new Separator());
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, releasedEntitiesFilterAction);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, resetFilterAction);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, new Separator());
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, CommandFactory.createContribItemById(
        IGeneralCommandConstants.TOGGLE_VIEWER_TEXT_FILTER, false, null));
    menu.appendToGroup(IGeneralMenuConstants.GROUP_ADDITIONS, searchRecursivelyAction);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_ADDITIONS, releasedUsagesOnly);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_ADDITIONS, localAssociationsOnly);
  }

  @Override
  public void toggleTextFilterVisibility() {
    if (resultTree != null && !resultTree.isDisposed()) {
      resultTree.toggleFilterVisiblity();
    }
  }

  @Override
  protected void clearViewerInput() {
    super.clearViewerInput();
    if (resultTree != null) {
      resultTree.resetFilter();
      resultTree.setFilterVisible(false);
    }
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

    filterAction = ActionFactory.createAction(
        Messages.WhereUsedInCdsAnalysisView_FilterOnSelection_xmit, AdtBaseUIResources
            .getImageDescriptor(IAdtBaseImages.FILTER), this::filterOnSelection);
    resetFilterAction = ActionFactory.createAction(
        Messages.WhereUsedInCdsAnalysisView_ResetViewerFilter_xmit, null, () -> resetFiltering(
            true));
    releasedEntitiesFilterAction = new ReleasedPathsFilterAction();
    searchRecursivelyAction = ActionFactory.createAction(
        Messages.WhereUsedInCdsAnalysisView_SearchFromPartReferencesRecursively_xmit, null,
        IAction.AS_CHECK_BOX, () -> {
          analysisResult.getSettings().setSearchRecursively(searchRecursivelyAction.isChecked());
          expandAllAction.setEnabled(searchRecursivelyAction.isChecked());
          updateViewerFromSettings();
          refreshAnalysis();
        });
    searchRecursivelyAction.setToolTipText(
        Messages.WhereUsedInCdsAnalysisView_SearchFromPartReferencesRecursively_xtol);
  }

  @Override
  protected TreeViewer createTreeViewer(final Composite parent) {
    resultTree = new FilterableTree(parent, null, true, FilterableComposite.TEXT_SMALL_H_MARGIN);
    var resultTreeViewer = new TreeViewer(resultTree, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    resultTreeViewer.addFilter(treeFilter);
    resultTree.setViewer(resultTreeViewer);
    return resultTreeViewer;
  }

  @Override
  protected void fillContextMenu(final IMenuManager mgr,
      final CommandPossibleChecker commandPossibleChecker) {
    super.fillContextMenu(mgr, commandPossibleChecker);
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.CDS_TOP_DOWN_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.CDS_TOP_DOWN_ANALYSIS);
    }
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.WHERE_USED_IN_CDS_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.WHERE_USED_IN_CDS_ANALYSIS);
    }
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.USED_ENTITIES_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.USED_ENTITIES_ANALYSIS);
    }
    if (commandPossibleChecker.canCommandBeEnabled(ICommandConstants.FIELD_ANALYSIS)) {
      SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(mgr,
          IContextMenuConstants.GROUP_CDS_ANALYSIS, ICommandConstants.FIELD_ANALYSIS);
    }

    var selection = getViewer().getStructuredSelection();
    if (selection.size() == 1) {
      var selectedNode = (ITreeNode) selection.getFirstElement();
      if (selectedNode.getParent() != null) {
        mgr.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, filterAction);
      }
    }
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
        if (size != null && (!analysisResult.getSettings().isSearchRecursively() || analysisResult
            .getSettings()
            .isSearchAssociations()) && !"0".equals(size)) { //$NON-NLS-1$
          text.append(" (" + size + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
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
    final var uiState = new UiState();
    uiState.setFromTreeViewer((TreeViewer) getViewer());
    return uiState;
  }

  @Override
  protected void loadInput(final ViewUiState uiState) {
    checkFeatureState();

    final var viewer = (TreeViewer) getViewer();

    if (analysisResult.isResultLoaded()) {
      setActionStateFromSettings();
      updateViewerFromSettings();
      viewer.setInput(analysisResult.getResult());
      if (uiState instanceof UiState) {
        ((UiState) uiState).applyToTreeViewer(viewer);
        viewer.refresh(false);
      } else {
        final Object[] input = (Object[]) viewer.getInput();
        if (input != null && input.length >= 1) {
          viewer.expandToLevel(input[0], 1);
          viewer.setSelection(new StructuredSelection(input[0]));
        }
      }
      getViewPart().updateLabel();
    } else {
      resetFiltering(false);
      hideTextFilter();
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
    resetFiltering(false);
    analysisResult.refreshAnalysis();
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
    releasedEntitiesFilterAction.setEnabled(releasedUsagesOnly.isEnabled());
  }

  private void filterOnSelection() {
    selectionFilterActive = true;
    filteredNodes.clear();
    var isAlreadyFiltered = analysisResult.isFiltered();
    analysisResult.setFiltered(true);

    var viewer = getViewer();
    var selectedElement = viewer.getStructuredSelection().getFirstElement();
    var node = (ITreeNode) selectedElement;

    lastFilteredNode = node;
    filteredNodes.add(node);

    var parent = node.getParent();
    while (parent != null) {
      filteredNodes.add(parent);
      parent = parent.getParent();
    }

    getViewer().refresh(false);

    if (!isAlreadyFiltered) {
      getViewPart().updateLabel();
    }
  }

  private void hideTextFilter() {
    resultTree.setFilterVisible(false);
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

  private void resetFiltering(final boolean refreshViewer) {
    analysisResult.setFiltered(false);
    filteredNodes.clear();
    lastFilteredNode = null;
    releasedEntitiesFilterActive = false;
    selectionFilterActive = false;
    resultTree.resetFilter();

    if (refreshViewer) {
      getViewer().refresh(false);
    }
    getViewPart().updateLabel();
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
      contentProvider.setNodeRefreshOptions(AbstractTreeViewer.ALL_LEVELS,
          LazyLoadingRefreshMode.ROOT_AND_ALL_CHILDREN);
    } else {
      contentProvider.setNodeRefreshOptions(1, null);
    }
  }
}
