package com.devepos.adt.cst.ui.internal.codesearch.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.search.ui.IQueryListener;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.text.AbstractTextSearchViewPage;
import org.eclipse.search.ui.text.Match;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.PreferencesUtil;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.ContextHelper;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.IGeneralCommandConstants;
import com.devepos.adt.base.ui.IGeneralContextConstants;
import com.devepos.adt.base.ui.ViewerState;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.action.CollapseTreeNodesAction;
import com.devepos.adt.base.ui.action.CommandFactory;
import com.devepos.adt.base.ui.action.PreferenceToggleAction;
import com.devepos.adt.base.ui.controls.FilterableComposite;
import com.devepos.adt.base.ui.search.ISearchResultPageExtension;
import com.devepos.adt.base.ui.table.FilterableTable;
import com.devepos.adt.base.ui.tree.FilterableTree;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.IFilterableView;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.PackageNode;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchDialog;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchQuery;
import com.devepos.adt.cst.ui.internal.codesearch.CodeSearchRelevantWbTypesUtil;
import com.devepos.adt.cst.ui.internal.export.ExportSearchResultsDialog;
import com.devepos.adt.cst.ui.internal.messages.Messages;
import com.devepos.adt.cst.ui.internal.preferences.CodeSearchPreferencesPage;
import com.devepos.adt.searchfavorites.SearchFavoritesActionFactory;
import com.sap.adt.tools.core.model.adtcore.IAdtCoreFactory;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;
import com.sap.adt.tools.core.ui.navigation.AdtNavigationServiceFactory;

/**
 * Result page of a ABAP Code Search query
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CodeSearchResultPage extends AbstractTextSearchViewPage
    implements ISearchResultPageExtension<CodeSearchQuery>, IQueryListener, IFilterableView {

  private static final String GROUP_BY_PACKAGE_PREF = "codeSearch.result.groupByPackageEnabled"; //$NON-NLS-1$

  private static final String GROUP_GROUPING = "com.devepos.adt.cst.searchResult.grouping"; //$NON-NLS-1$
  private IStructuredContentProvider contentProvider;

  private IAction openPreferencesAction;

  private IAction openRuntimeInformation;
  private IAction expandPackageNodeAction;
  private IAction collapseNodeAction;
  private IAction exportResultsAction;
  private IAction searchFavoritesAction;
  private ContinueCodeSearchAction continueSearchAction;
  private ContextHelper contextHelper;

  private FilterableComposite<?, ?> filterableComposite;
  private PreferenceToggleAction groupByPackageAction;
  private final IPropertyChangeListener prefChangeListener;

  public CodeSearchResultPage() {
    super();

    prefChangeListener = l -> {
      if (l.getProperty().equals(GROUP_BY_PACKAGE_PREF)) {
        StructuredViewer viewer = getViewer();
        if (viewer instanceof TreeViewer) {
          viewer.refresh();
        }
      }
    };
    CodeSearchUIPlugin.getDefault()
        .getPreferenceStore()
        .addPropertyChangeListener(prefChangeListener);
    initializeActions();
  }

  private static class UiState extends ViewerState {
    private String filterText;

    public String getFilterText() {
      return filterText;
    }

    public void setFilterText(final String filterText) {
      this.filterText = filterText;
    }

  }

  @Override
  public void createControl(final Composite parent) {
    super.createControl(parent);

    contextHelper = ContextHelper.createForServiceLocator(getSite());
    contextHelper.activateAbapContext();
    contextHelper.activateContext(IGeneralContextConstants.SEARCH_PAGE_VIEWS);
    contextHelper.activateContext(IGeneralContextConstants.FILTERABLE_VIEWS);

    NewSearchUI.addQueryListener(this);
  }

  @Override
  public void dispose() {
    if (contextHelper != null) {
      contextHelper.deactivateAllContexts();
    }
    if (prefChangeListener != null) {
      CodeSearchUIPlugin.getDefault()
          .getPreferenceStore()
          .removePropertyChangeListener(prefChangeListener);
    }
    NewSearchUI.removeQueryListener(this);
    super.dispose();
  }

  @Override
  public String getLabel() {
    var result = (CodeSearchResult) getInput();
    if (result == null) {
      return "";
    }
    return result.getLabelForSearchView();
  }

  @Override
  public String getSearchPageId() {
    return CodeSearchDialog.PAGE_ID;
  }

  @Override
  public CodeSearchQuery getSearchQuery() {
    var searchResult = getInput();
    return searchResult != null ? (CodeSearchQuery) searchResult.getQuery() : null;
  }

  @Override
  public Object getUIState() {
    var state = new UiState();
    state.setSelection(getViewer().getSelection());
    state.setFilterText(filterableComposite.getFilterString());
    return state;
  }

  public boolean isPackageGroupingEnabled() {
    return groupByPackageAction != null ? groupByPackageAction.isChecked() : false;
  }

  @Override
  public void queryAdded(final ISearchQuery query) {
  }

  @Override
  public void queryFinished(final ISearchQuery query) {
    if (currentQueryStatusChanged(query)) {
      updateContinueAction();
    }
  }

  @Override
  public void queryRemoved(final ISearchQuery query) {
    if (currentQueryStatusChanged(query)) {
      updateContinueAction();
    }
  }

  @Override
  public void queryStarting(final ISearchQuery query) {
    if (currentQueryStatusChanged(query)) {
      updateContinueAction();

      if (filterableComposite != null && filterableComposite.isFilterVisible()) {
        Display.getDefault().asyncExec(() -> filterableComposite.toggleFilterVisiblity());
      }
    }
  }

  @Override
  public void setActionBars(final IActionBars actionBars) {
    IMenuManager menuMgr = actionBars.getMenuManager();
    menuMgr.appendToGroup(IContextMenuConstants.GROUP_ADDITIONS, openRuntimeInformation);
    menuMgr.appendToGroup(IContextMenuConstants.GROUP_PROPERTIES, openPreferencesAction);
    menuMgr.add(new Separator());
    menuMgr.add(CommandFactory
        .createContribItemById(IGeneralCommandConstants.TOGGLE_VIEWER_TEXT_FILTER, false, null));
    menuMgr.add(new Separator());
    menuMgr.add(exportResultsAction);
  }

  @Override
  public void setInput(final ISearchResult newSearch, final Object viewState) {
    super.setInput(newSearch,
        viewState instanceof UiState ? ((UiState) viewState).getSelection() : viewState);

    updateContinueAction();

    if (filterableComposite == null || filterableComposite.isDisposed()) {
      return;
    }

    if (newSearch == null) {
      filterableComposite.resetFilter();
      filterableComposite.setFilterVisible(false);
    } else if (viewState instanceof UiState) {
      var filterText = ((UiState) viewState).getFilterText();
      if (!StringUtil.isEmpty(filterText)) {
        filterableComposite.setFilterText(filterText, false);
        filterableComposite.setFilterVisible(true);
      } else {
        filterableComposite.resetFilter(false);
        filterableComposite.setFilterVisible(false);
      }
    }
  }

  @Override
  public void setLayout(final int layout) {
    var oldLayout = getLayout();
    var filterString = getFilterString();
    super.setLayout(layout);

    if (filterableComposite != null && !filterableComposite.isDisposed()) {
      filterableComposite.layout(true);
    }

    if (oldLayout == FLAG_LAYOUT_FLAT) {
      getViewer().refresh();
    }

    // check if filter was active in previous layout
    if (!StringUtil.isEmpty(filterString)) {
      filterableComposite.setFilterVisible(true);
      filterableComposite.setFilterText(filterString);
    }
  }

  @Override
  public void toggleTextFilterVisibility() {
    if (filterableComposite != null && !filterableComposite.isDisposed()) {
      filterableComposite.toggleFilterVisiblity();
    }
  }

  @Override
  protected void clear() {
    getViewer().refresh();
  }

  @Override
  protected void configureTableViewer(final TableViewer viewer) {
    collapseNodeAction = null;
    contentProvider = new CodeSearchTableContentProvider(this);
    viewer.setContentProvider(contentProvider);
    viewer.setUseHashlookup(true);
    ColumnViewerToolTipSupport.enableFor(viewer);
    viewer.setLabelProvider(
        new DelegatingStyledCellLabelProvider(new CodeSearchResultLabelProvider()));
  }

  @Override
  protected void configureTreeViewer(final TreeViewer viewer) {
    collapseNodeAction = new CollapseTreeNodesAction(viewer);
    contentProvider = new CodeSearchTreeContentProvider(this);
    viewer.setContentProvider(contentProvider);
    viewer.setUseHashlookup(true);
    ColumnViewerToolTipSupport.enableFor(viewer);
    viewer.setLabelProvider(
        new DelegatingStyledCellLabelProvider(new CodeSearchResultLabelProvider()));
    viewer.setComparator(new ViewerComparator() {

      @Override
      public int compare(final Viewer viewer, final Object e1, final Object e2) {
        if (e1 instanceof SearchMatchNode) {
          return 0;
        }
        return ((ITreeNode) e1).getDisplayName().compareTo(((ITreeNode) e2).getDisplayName());
      }

    });
  }

  @Override
  protected TableViewer createTableViewer(final Composite parent) {
    disposeControls();
    var table = new FilterableTable(parent, null, true, FilterableComposite.TEXT_SMALL_H_MARGIN);
    filterableComposite = table;
    var resultViewer = new TableViewer(table, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    table.setViewer(resultViewer);

    configureFilterableComposite();

    return resultViewer;
  }

  @Override
  protected TreeViewer createTreeViewer(final Composite parent) {
    disposeControls();
    var tree = new FilterableTree(parent, null, true, FilterableComposite.TEXT_SMALL_H_MARGIN);
    filterableComposite = tree;
    var resultViewer = new TreeViewer(tree, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    tree.setViewer(resultViewer);

    configureFilterableComposite();
    return resultViewer;
  }

  @Override
  protected void elementsChanged(final Object[] updatedElements) {
    new MatchViewerUpdater(updatedElements, (CodeSearchResult) getInput(), getViewer(), this)
        .update();
  }

  @Override
  protected void fillContextMenu(final IMenuManager mgr) {
    super.fillContextMenu(mgr);

    StructuredViewer currentViewer = getViewer();
    if (!(currentViewer instanceof TreeViewer)) {
      removeUnusedContextGroups(mgr, Arrays.asList(IContextMenuConstants.GROUP_REORGANIZE,
          IWorkbenchActionConstants.MB_ADDITIONS));
      return;
    }
    TreeViewer treeViewer = (TreeViewer) currentViewer;

    IStructuredSelection selection = currentViewer.getStructuredSelection();
    boolean collapsedPackageSelected = false;
    boolean expandedNodeSelected = false;
    boolean codeSearchableObjSelected = false;
    boolean searchMatchSelected = false;

    List<String> relevantAdtTypesForCodeSearch = CodeSearchRelevantWbTypesUtil
        .getCodeSearchableAdtTypes(getSearchQuery().getProject());

    for (Object selObj : selection) {
      if (collapsedPackageSelected && expandedNodeSelected) {
        break;
      }
      // check if code searchable object is selected (clas,intf, ... or package)
      if (!codeSearchableObjSelected && selObj instanceof IAdtObjectReferenceNode
          && (relevantAdtTypesForCodeSearch
              .contains(((IAdtObjectReferenceNode) selObj).getAdtObjectType())
              || ((IAdtObjectReferenceNode) selObj).getAdtObjectType()
                  .equals(IAdtObjectTypeConstants.PACKAGE))) {
        codeSearchableObjSelected = true;
      }
      if (selObj instanceof ICollectionTreeNode) {
        boolean isExpanded = treeViewer.getExpandedState(selObj);
        if (!expandedNodeSelected && isExpanded) {
          expandedNodeSelected = true;
        } else if (!collapsedPackageSelected && selObj instanceof PackageNode && !isExpanded) {
          collapsedPackageSelected = true;
        }
      } else if (!searchMatchSelected && selObj instanceof SearchMatchNode) {
        searchMatchSelected = true;
      }
    }

    if (collapsedPackageSelected) {
      mgr.appendToGroup(IContextMenuConstants.GROUP_REORGANIZE, expandPackageNodeAction);
    }
    if (expandedNodeSelected) {
      mgr.appendToGroup(IContextMenuConstants.GROUP_REORGANIZE, collapseNodeAction);
    }

    /*
     * Ugly workaround to hide empty Separators in context menu - Reason is currently unknown
     */
    List<String> additionalGroupsToDelete = new ArrayList<>();
    if (!collapsedPackageSelected && !expandedNodeSelected) {
      additionalGroupsToDelete.add(IContextMenuConstants.GROUP_REORGANIZE);
    } else if (codeSearchableObjSelected) {
      mgr.appendToGroup(IContextMenuConstants.GROUP_REORGANIZE, new Separator());
    }
    if (!codeSearchableObjSelected || searchMatchSelected) {
      additionalGroupsToDelete.add(IWorkbenchActionConstants.MB_ADDITIONS);
    }
    removeUnusedContextGroups(mgr, additionalGroupsToDelete);
  }

  @Override
  protected void fillToolbar(final IToolBarManager tbm) {
    super.fillToolbar(tbm);
    tbm.appendToGroup(IContextMenuConstants.GROUP_NEW, CommandFactory
        .createContribItemById(IGeneralCommandConstants.OPEN_QUERY_IN_SEARCH_DIALOG, false, null));
    tbm.appendToGroup(IContextMenuConstants.GROUP_NEW, searchFavoritesAction);
    if (getLayout() != FLAG_LAYOUT_FLAT) {
      tbm.appendToGroup(IContextMenuConstants.GROUP_VIEWER_SETUP, new Separator(GROUP_GROUPING));
      tbm.appendToGroup(GROUP_GROUPING, groupByPackageAction);
    }
    tbm.prependToGroup(IContextMenuConstants.GROUP_SEARCH, continueSearchAction);
  }

  @Override
  protected StructuredViewer getViewer() {
    // override to make available in package
    return super.getViewer();
  }

  @Override
  protected void handleOpen(final OpenEvent event) {
    if (event.getSelection() instanceof IStructuredSelection) {
      IStructuredSelection selection = (IStructuredSelection) event.getSelection();
      Object element = selection.getFirstElement();
      if (element != null && getDisplayedMatchCount(element) == 0) {
        boolean navigated = navigateToElement(element, OpenStrategy.activateOnOpen());
        if (navigated) {
          return;
        }
      }
    }
    super.handleOpen(event);
  }

  @Override
  protected void showMatch(final Match match, final int currentOffset, final int currentLength,
      final boolean activate) throws PartInitException {
    Object element = match.getElement();
    navigateToElement(element, activate);
  }

  private void configureFilterableComposite() {
    filterableComposite.setElementMatcher(element -> {
      var wordMatcher = filterableComposite.getWordMatcher();

      if (element instanceof SearchMatchNode) {
        var match = ((SearchMatchNode) element).getStyledText().getString();
        return wordMatcher.matchesWord(match);
      }
      return false;
    });
  }

  /*
   * Evaluates if the 'continueSearch' action needs to be updated
   */
  private boolean currentQueryStatusChanged(final ISearchQuery query) {
    var searchResult = getInput();
    return searchResult != null && searchResult.equals(query.getSearchResult());
  }

  private void disposeControls() {
    if (filterableComposite != null && !filterableComposite.isDisposed()) {
      filterableComposite.dispose();
      filterableComposite = null;
    }
  }

  private void exportResults() {
    var searchResult = (CodeSearchResult) getInput();
    if (searchResult.getResultTree() == null || !searchResult.getResultTree().hasChildren()) {
      MessageDialog.openInformation(getSite().getShell(),
          Messages.CodeSearchResultPage_NoResultsForExport_xtit,
          Messages.CodeSearchResultPage_NoResultsForExport_xmsg);
      return;
    }
    var exportResultsDialog = new ExportSearchResultsDialog(getSite().getShell(),
        searchResult.getResultTree(),
        ((CodeSearchQuery) getInput().getQuery()).getProjectProvider().getProject());
    exportResultsDialog.open();
  }

  private String getFilterString() {
    if (filterableComposite != null) {
      return filterableComposite.getFilterString();
    }
    return null;
  }

  private void initializeActions() {
    searchFavoritesAction = SearchFavoritesActionFactory
        .createSearchFavoritesAction(CodeSearchQuery.SEARCH_FAVORITE_TYPE);
    continueSearchAction = new ContinueCodeSearchAction(this);
    continueSearchAction.setEnabled(false);
    openPreferencesAction = ActionFactory
        .createAction(Messages.CodeSearchResultPage_openSearchPreferencesAction_xlbl, null, () -> {
          PreferencesUtil
              .createPreferenceDialogOn(null, CodeSearchPreferencesPage.PAGE_ID,
                  new String[] { CodeSearchPreferencesPage.PAGE_ID }, (Object) null)
              .open();
        });
    exportResultsAction = ActionFactory.createAction(
        Messages.CodeSearchResultPage_ExportResultAction_xtit, null, this::exportResults);
    groupByPackageAction = new PreferenceToggleAction(
        Messages.CodeSearchResultPage_groupByPackageAction_xtol,
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.PACKAGE), GROUP_BY_PACKAGE_PREF, true,
        CodeSearchUIPlugin.getDefault().getPreferenceStore());
    openRuntimeInformation = ActionFactory
        .createAction(Messages.CodeSearchResultPage_showRuntimInfoDialogAction_xlbl, null, () -> {
          CodeSearchRuntimeInfoDialog dialog = new CodeSearchRuntimeInfoDialog(
              getViewPart().getViewSite().getShell(),
              ((CodeSearchResult) getInput()).getRuntimeInfo());
          dialog.open();
        });

    expandPackageNodeAction = ActionFactory.createAction(
        AdtBaseUIResources.getString(IAdtBaseStrings.ExpandTree_xlbl),
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.EXPAND_ALL), () -> {
          TreeViewer viewer = (TreeViewer) getViewer();
          IStructuredSelection selection = viewer.getStructuredSelection();

          BusyIndicator.showWhile(getSite().getShell().getDisplay(), () -> {
            viewer.getControl().setRedraw(false);
            try {
              for (final Object selectedObject : selection.toList()) {
                final PackageNode node = (PackageNode) selectedObject;
                viewer.setExpandedState(node, true);
                for (final PackageNode subNode : node.getSubPackages()) {
                  viewer.setExpandedState(subNode, true);
                }
              }
            } finally {
              viewer.getControl().setRedraw(true);
            }
          });
        });
  }

  private boolean navigateToElement(final Object element, final boolean activate) {
    IAdtObjectReference adtObjRef = null;
    if (element instanceof IAdtObjectReferenceNode) {
      adtObjRef = ((IAdtObjectReferenceNode) element).getObjectReference();
    } else if (element instanceof SearchMatchNode) {
      SearchMatchNode matchNode = (SearchMatchNode) element;
      adtObjRef = IAdtCoreFactory.eINSTANCE.createAdtObjectReference();
      adtObjRef.setUri(matchNode.getUri());
    }

    if (adtObjRef != null) {
      IProject project = ((CodeSearchQuery) getInput().getQuery()).getProjectProvider()
          .getProject();
      AdtNavigationServiceFactory.createNavigationService().navigate(project, adtObjRef, activate);
      return true;
    }
    return false;
  }

  /*
   * For some reason an empty separator is shown in the context menu if these groups are not removed
   *
   * @see SearchView#createContextMenuGroups
   */
  private void removeUnusedContextGroups(final IMenuManager mgr,
      final List<String> additionalGroups) {
    IContributionItem[] items = mgr.getItems();
    if (items == null || items.length == 0) {
      return;
    }

    List<String> groupsToDelete = new ArrayList<>(
        Arrays.asList(IContextMenuConstants.GROUP_GENERATE, IContextMenuConstants.GROUP_SEARCH,
            IContextMenuConstants.GROUP_BUILD, IContextMenuConstants.GROUP_GOTO,
            IContextMenuConstants.GROUP_VIEWER_SETUP, IContextMenuConstants.GROUP_PROPERTIES));
    if (additionalGroups != null && !additionalGroups.isEmpty()) {
      additionalGroups.forEach(groupsToDelete::add);
    }

    for (IContributionItem item : items) {
      String id = item.getId();
      if (id == null) {
        continue;
      }
      if (groupsToDelete.contains(id)) {
        mgr.remove(item);
      }
    }
  }

  private void updateContinueAction() {
    boolean enabled = false;
    var query = getSearchQuery();
    if (query != null && !query.isFinished() && !NewSearchUI.isQueryRunning(query)) {
      enabled = true;
    }

    continueSearchAction.setEnabled(enabled);
  }
}
