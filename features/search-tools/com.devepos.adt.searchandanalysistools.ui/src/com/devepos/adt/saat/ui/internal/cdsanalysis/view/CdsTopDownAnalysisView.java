package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.part.IPageSite;

import com.devepos.adt.base.elementinfo.LazyLoadingRefreshMode;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.ContextHelper;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.IGeneralCommandConstants;
import com.devepos.adt.base.ui.IGeneralContextConstants;
import com.devepos.adt.base.ui.IGeneralMenuConstants;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.action.CommandFactory;
import com.devepos.adt.base.ui.action.ExpandAllAction;
import com.devepos.adt.base.ui.action.OpenColorPreferencePageAction;
import com.devepos.adt.base.ui.controls.FilterableComposite;
import com.devepos.adt.base.ui.tree.FilterableTree;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.IFilterableView;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.base.ui.tree.IStyledTreeNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeViewer;
import com.devepos.adt.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType;
import com.devepos.adt.saat.ui.internal.IColorConstants;
import com.devepos.adt.saat.ui.internal.ICommandConstants;
import com.devepos.adt.saat.ui.internal.IContextMenuConstants;
import com.devepos.adt.saat.ui.internal.NativeColumnViewerToolTipSupport;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.TreeViewUiState;
import com.devepos.adt.saat.ui.internal.ViewUiState;
import com.devepos.adt.saat.ui.internal.cdsanalysis.ICdsAnalysisPreferences;
import com.devepos.adt.saat.ui.internal.cdsanalysis.ISqlRelationInfo;
import com.devepos.adt.saat.ui.internal.help.HelpContextId;
import com.devepos.adt.saat.ui.internal.menu.SearchToolsMenuItemFactory;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.CommandPossibleChecker;

/**
 * Top-Down Analysis of CDS Analysis page
 *
 * @see {@link CdsAnalyzerPage}
 * @author stockbal
 */
public class CdsTopDownAnalysisView extends CdsAnalysisPage<CdsTopDownAnalysis>
    implements IFilterableView {

  private Action showDescriptions;
  private Action showAliasNames;
  private Action loadAssociations;
  private Action filterAction;
  private Action resetFilterAction;
  private Action refreshNodesAction;
  private OpenColorPreferencePageAction showColorsAndFontsPrefs;
  private FilterableTree resultTree;

  private final List<Column> columns;
  private final ViewerFilter treeFilter = new TreeFilter();
  private final Set<Object> filteredNodes = new HashSet<>();
  private boolean selectionFilterActive;
  private ITreeNode lastFilteredNode;
  private final IPropertyChangeListener colorPropertyChangeListener;
  private ContextHelper contextHelper;
  private ExpandAllAction expandAllAction;

  public CdsTopDownAnalysisView(final CdsAnalysisView parentView) {
    super(parentView);
    columns = Arrays.asList(Column.OBJECT_NAME, Column.RELATION);
    colorPropertyChangeListener = event -> {
      if (IColorConstants.CDS_ANALYSIS_ALIAS_NAME.equals(event.getProperty())) {
        final StructuredViewer viewer = getViewer();
        if (viewer != null && !viewer.getControl().isDisposed()) {
          viewer.refresh();
        }
      }
    };
    JFaceResources.getColorRegistry().addListener(colorPropertyChangeListener);
  }

  /**
   * Label provider for a single column in this TreeViewer
   *
   * @author stockbal
   */
  class ColumnLabelProvider extends CellLabelProvider
      implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {

    private final Column column;

    public ColumnLabelProvider(final Column column) {
      this.column = column;
    }

    @Override
    public Image getImage(final Object element) {
      Image image = null;
      if (column == Column.OBJECT_NAME) {
        image = getTreeNodeImage(element);
      }
      return image;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      StyledString text = new StyledString();

      switch (column) {
      case OBJECT_NAME:
        text = getTreeNodeLabel(element);
        break;
      case RELATION:
        ISqlRelationInfo relationalInfo = null;
        if (element instanceof IAdaptable) {
          relationalInfo = ((IAdaptable) element).getAdapter(ISqlRelationInfo.class);
        }

        if (relationalInfo != null && relationalInfo.getRelation() != null
            && !relationalInfo.getRelation().isEmpty()) {
          text.append(relationalInfo.getRelation());
        }

        break;
      }

      return text;
    }

    @Override
    public String getToolTipText(final Object element) {
      if (column == Column.OBJECT_NAME && element instanceof IAdtObjectReferenceNode) {
        final IAdtObjectReferenceNode adtNode = (IAdtObjectReferenceNode) element;
        final StringBuffer tooltip = new StringBuffer();
        appendTooltipInfo(tooltip, Messages.CdsTopDownAnalysisView_NameTooltipPart_xtol,
            adtNode.getDisplayName());
        appendTooltipInfo(tooltip, Messages.CdsTopDownAnalysisView_DescriptionTooltipPart_xtol,
            adtNode.getDescription());
        final ISqlRelationInfo relationInfo = adtNode.getAdapter(ISqlRelationInfo.class);
        if (relationInfo != null) {
          appendTooltipInfo(tooltip, Messages.CdsTopDownAnalysisView_AliasTooltipPart_xtol,
              relationInfo.getAliasName());
        }
        return tooltip.toString();
      }
      return super.getToolTipText(element);
    }

    @Override
    public void update(final ViewerCell cell) {
    }

    private void appendTooltipInfo(final StringBuffer tooltip, final String infoName,
        final String infoContent) {
      if (infoContent == null || infoContent.isEmpty()) {
        return;
      }
      if (tooltip.length() > 0) {
        tooltip.append(System.lineSeparator());
      }
      tooltip.append(infoName);
      tooltip.append(":"); //$NON-NLS-1$
      tooltip.append(System.lineSeparator());
      tooltip.append("  "); //$NON-NLS-1$
      tooltip.append(infoContent);
    }
  }

  private enum Column {
    OBJECT_NAME(400, Messages.CdsTopDownAnalysisView_ObjectTypeColumn_xmit),
    RELATION(100, Messages.CdsTopDownAnalysisView_SqlRelationColumn_xmit);

    public final int defaultWidth;
    public final String headerText;

    Column(final int width, final String headerText) {
      defaultWidth = width;
      this.headerText = headerText;
    }

  }

  private class TreeFilter extends ViewerFilter {

    @Override
    public Object[] filter(final Viewer viewer, final Object parent, final Object[] elements) {
      if (!selectionFilterActive) {
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
      if (filteredNodes.isEmpty()) {
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
    private boolean selectionFilterActiveState;
    private final Set<Object> filteredNodesState = new HashSet<>();
    private String textFilterState;

    @Override
    public void applyToTreeViewer(final TreeViewer viewer) {
      super.applyToTreeViewer(viewer);
      lastFilteredNode = lastFilteredNodeState;
      filteredNodes.addAll(filteredNodesState);
      selectionFilterActive = selectionFilterActiveState;
      if (!StringUtil.isEmpty(textFilterState)) {
        resultTree.setFilterText(textFilterState, false);
        resultTree.setFilterVisible(true);
      } else {
        resultTree.resetFilter(false);
        resultTree.setFilterVisible(false);
      }
      setFiltered(selectionFilterActive);
    }

    @Override
    public void setFromTreeViewer(final TreeViewer viewer) {
      super.setFromTreeViewer(viewer);
      lastFilteredNodeState = lastFilteredNode;
      selectionFilterActiveState = selectionFilterActive;
      filteredNodesState.clear();
      filteredNodesState.addAll(filteredNodes);
      textFilterState = resultTree.getFilterString();
    }
  }

  @Override
  public void dispose() {
    super.dispose();
    JFaceResources.getColorRegistry().removeListener(colorPropertyChangeListener);
    if (contextHelper != null) {
      contextHelper.deactivateAllContexts();
    }
  }

  @Override
  public HelpContextId getHelpContextId() {
    return HelpContextId.CDS_ANALYZER_TOP_DOWN_ANALYSIS;
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
    menu.appendToGroup(IGeneralMenuConstants.GROUP_PROPERTIES, showDescriptions);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_PROPERTIES, showAliasNames);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_PROPERTIES, new Separator());
    menu.appendToGroup(IGeneralMenuConstants.GROUP_PROPERTIES, loadAssociations);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_ADDITIONS, showColorsAndFontsPrefs);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, resetFilterAction);
    menu.appendToGroup(IGeneralMenuConstants.GROUP_FILTERING, CommandFactory
        .createContribItemById(IGeneralCommandConstants.TOGGLE_VIEWER_TEXT_FILTER, false, null));
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
    final LazyLoadingTreeContentProvider contentProvider = new LazyLoadingTreeContentProvider(
        LazyLoadingRefreshMode.ROOT_AND_NON_LAZY_CHILDREN, AbstractTreeViewer.ALL_LEVELS);
    contentProvider.setExpansionChecker(node -> {
      final ISqlRelationInfo relation = node.getAdapter(ISqlRelationInfo.class);
      return relation != null
          && !TopDownAnalysisEntryType.ASSOCIATIONS.name().equals(relation.getType());
    });
    treeViewer.setContentProvider(contentProvider);
    treeViewer.setUseHashlookup(true);
    treeViewer.getTree().setHeaderVisible(true);
    NativeColumnViewerToolTipSupport.enableFor(treeViewer);
    createColumns(treeViewer);
  }

  @Override
  protected void createActions() {
    super.createActions();
    expandAllAction = new ExpandAllAction();
    expandAllAction.setTreeViewer((TreeViewer) getViewer());
    expandAllAction
        .setText(AdtBaseUIResources.getString(IAdtBaseStrings.ExpandAllLoadedNodes_xlbl));

    showDescriptions = ActionFactory.createAction(
        Messages.CdsTopDownAnalysisView_ShowDescriptionsToggleAction_xmit, null,
        IAction.AS_CHECK_BOX, () -> {
          analysisResult.getSettings().setShowDescriptions(showDescriptions.isChecked());
          getViewer().refresh();
        });
    showAliasNames = ActionFactory.createAction(
        Messages.CdsTopDownAnalysisView_ShowAliasNamesToggleAction_xmit, null, IAction.AS_CHECK_BOX,
        () -> {
          analysisResult.getSettings().setShowAliasNames(showAliasNames.isChecked());
          getViewer().refresh();
        });
    loadAssociations = ActionFactory.createAction(
        Messages.CdsTopDownAnalysisView_LoadAssociationsToggleAction_xmit, null,
        IAction.AS_CHECK_BOX, () -> {
          analysisResult.getSettings().setLoadAssociations(loadAssociations.isChecked());
          refreshAnalysis(true);
        });
    showColorsAndFontsPrefs = new OpenColorPreferencePageAction();
    showColorsAndFontsPrefs.setColorId(IColorConstants.CDS_ANALYSIS_ALIAS_NAME);
    showColorsAndFontsPrefs.setCategories(IColorConstants.SAAT_COLOR_CATEGORY,
        IColorConstants.CDS_ANALYSIS_CATEGORY);
    filterAction = ActionFactory.createAction(
        Messages.WhereUsedInCdsAnalysisView_FilterOnSelection_xmit,
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.FILTER), this::filterOnSelection);
    resetFilterAction = ActionFactory.createAction(
        Messages.WhereUsedInCdsAnalysisView_ResetViewerFilter_xmit, null,
        () -> resetFiltering(true));

    refreshNodesAction = ActionFactory.createAction(
        Messages.CdsAnalysis_RefreshAnalysisForNode_xlbl,
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.REFRESH), () -> {
          refreshAnalysis(false);
        });
    refreshNodesAction.setActionDefinitionId(IWorkbenchCommandConstants.FILE_REFRESH);
  }

  @Override
  protected TreeViewer createTreeViewer(final Composite parent) {
    resultTree = new FilterableTree(parent, null, true, FilterableComposite.TEXT_SMALL_H_MARGIN);
    var resultTreeViewer = new LazyLoadingTreeViewer(resultTree,
        SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
    resultTreeViewer.addFilter(treeFilter);
    resultTree.setViewer(resultTreeViewer);
    resultTree.setElementMatcher(element -> {
      if (element instanceof IAdtObjectReferenceNode) {
        final var node = (IAdtObjectReferenceNode) element;
        final var wordMatcher = resultTree.getWordMatcher();

        return wordMatcher.matchesWord(node.getName())
            || wordMatcher.matchesWord(node.getDescription())
            || wordMatcher.matchesWord(node.getDisplayName());
      }
      return false;
    });
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

    if (Stream.of(selection.toArray()).anyMatch(ILazyLoadingNode.class::isInstance)) {
      mgr.appendToGroup(IGeneralMenuConstants.GROUP_NODE_ACTIONS, refreshNodesAction);
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

      if (showAliasNames.isChecked()) {
        ISqlRelationInfo relationalInfo;
        relationalInfo = node.getAdapter(ISqlRelationInfo.class);
        if (relationalInfo != null) {
          final String alias = relationalInfo.getAliasName();
          if (alias != null && !alias.isEmpty()) {
            text.append(" [" + alias + "] ", //$NON-NLS-1$ //$NON-NLS-2$
                StylerFactory.createCustomStyler(SWT.NORMAL,
                    IColorConstants.CDS_ANALYSIS_ALIAS_NAME, null));
          }
        }
      }

      if (showDescriptions.isChecked()) {
        final String description = node.getDescription();
        if (description != null && !description.isEmpty()) {
          text.append("  " + description + "  ", //$NON-NLS-1$ //$NON-NLS-2$
              StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR,
                  null));
        }
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
    final TreeViewer viewer = (TreeViewer) getViewer();

    if (analysisResult.isResultLoaded()) {
      setActionStateFromSettings();
      resetFiltering(true);
      viewer.setInput(analysisResult.getResult());
      // update ui state
      if (uiState instanceof UiState) {
        ((UiState) uiState).applyToTreeViewer(viewer);
      } else {
        setFiltered(false);
        final Object[] input = (Object[]) viewer.getInput();
        if (input != null && input.length >= 1) {
          viewer.expandToLevel(input[0], 1);
          viewer.setSelection(new StructuredSelection(input[0]));
        }
      }
    } else {
      resetFiltering(false);
      hideTextFilter();
      initActionState();
      analysisResult.createElementInfoProvider();
      analysisResult.setResultLoaded(true);
      viewer.setInput(analysisResult.getResult());
      viewer.expandAll(true);
    }
  }

  @Override
  protected void refreshAnalysis(final boolean global) {
    var viewer = (TreeViewer) getViewer();
    var selectedElements = viewer.getStructuredSelection().toList();

    boolean refreshRoot = global || selectedElements.contains(analysisResult.getResult()[0]);
    if (!refreshRoot) {
      // reset all lazy nodes in the selection
      for (var elem : selectedElements) {
        if (elem instanceof ILazyLoadingNode) {
          ((ILazyLoadingNode) elem).resetLoadedState();
          viewer.refresh(elem);
          viewer.expandToLevel(elem, AbstractTreeViewer.ALL_LEVELS, true);
        }
      }
    } else {
      resetFiltering(false);
      analysisResult.refreshAnalysis();
      viewer.refresh();
      viewer.expandAll(true);
    }
  }

  private void createColumn(final TreeViewer treeViewer, final Column column) {
    final TreeViewerColumn viewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
    viewerColumn.getColumn().setText(column.headerText);
    viewerColumn
        .setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnLabelProvider(column)));
    viewerColumn.getColumn().setWidth(column.defaultWidth);
    viewerColumn.getColumn().setMoveable(true);
  }

  private void createColumns(final TreeViewer treeViewer) {
    for (final Column column : columns) {
      createColumn(treeViewer, column);
    }
  }

  private void filterOnSelection() {
    selectionFilterActive = true;
    filteredNodes.clear();
    var isAlreadyFiltered = isFiltered();
    setFiltered(true);

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
    boolean isShowDescriptions = prefStore
        .getBoolean(ICdsAnalysisPreferences.TOP_DOWN_SHOW_DESCRIPTIONS);
    boolean isShowAliasNames = prefStore
        .getBoolean(ICdsAnalysisPreferences.TOP_DOWN_SHOW_ALIAS_NAMES);
    boolean isLoadAssociations = prefStore
        .getBoolean(ICdsAnalysisPreferences.TOP_DOWN_LOAD_ASSOCIATIONS);
    showDescriptions.setChecked(isShowDescriptions);
    showAliasNames.setChecked(isShowAliasNames);
    loadAssociations.setChecked(isLoadAssociations);

    if (analysisResult != null) {
      ICdsTopDownSettingsUi settings = analysisResult.getSettings();
      settings.setShowDescriptions(isShowDescriptions);
      settings.setShowAliasNames(isShowAliasNames);
      settings.setLoadAssociations(isLoadAssociations);
    }
  }

  private void resetFiltering(final boolean refreshViewer) {
    setFiltered(false);
    filteredNodes.clear();
    lastFilteredNode = null;
    selectionFilterActive = false;
    resultTree.resetFilter();

    if (refreshViewer) {
      getViewer().refresh(false);
    }
    getViewPart().updateLabel();
  }

  private void setActionStateFromSettings() {
    ICdsTopDownSettingsUi analysisSettings = analysisResult.getSettings();
    showDescriptions.setChecked(analysisSettings.isShowDescriptions());
    showAliasNames.setChecked(analysisSettings.isShowAliasNames());
    loadAssociations.setChecked(analysisSettings.isLoadAssociations());
  }
}
