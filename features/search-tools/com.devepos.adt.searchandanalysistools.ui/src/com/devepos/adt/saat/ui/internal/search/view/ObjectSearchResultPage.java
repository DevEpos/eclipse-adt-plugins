package com.devepos.adt.saat.ui.internal.search.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.Page;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ObjectType;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.ContextHelper;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.IGeneralCommandConstants;
import com.devepos.adt.base.ui.IGeneralContextConstants;
import com.devepos.adt.base.ui.IGeneralMenuConstants;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.action.CollapseAllTreeNodesAction;
import com.devepos.adt.base.ui.action.CollapseTreeNodesAction;
import com.devepos.adt.base.ui.action.CommandFactory;
import com.devepos.adt.base.ui.action.CopyToClipboardAction;
import com.devepos.adt.base.ui.action.ExecuteAdtObjectAction;
import com.devepos.adt.base.ui.action.ExpandAllAction;
import com.devepos.adt.base.ui.action.OpenAdtObjectAction;
import com.devepos.adt.base.ui.action.RadioActionGroup;
import com.devepos.adt.base.ui.adtelementinfo.AdtElementInformationUtil;
import com.devepos.adt.base.ui.controls.FilterableComposite;
import com.devepos.adt.base.ui.search.ISearchResultPageExtension;
import com.devepos.adt.base.ui.search.QueryListenerAdapter;
import com.devepos.adt.base.ui.table.FilterableTable;
import com.devepos.adt.base.ui.tree.FilterableTree;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.IFilterableView;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.tree.PackageNode;
import com.devepos.adt.base.ui.tree.launchable.ILaunchableNode;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.ui.util.WorkbenchUtil;
import com.devepos.adt.base.ui.viewsupport.ViewerSelectionProviderAdapter;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.ui.internal.ICommandConstants;
import com.devepos.adt.saat.ui.internal.IExtendedAdtObjectInfo;
import com.devepos.adt.saat.ui.internal.ImageUtil;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.menu.SearchToolsMenuItemFactory;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.FeatureTester;
import com.devepos.adt.saat.ui.internal.util.IImages;
import com.devepos.adt.searchfavorites.SearchFavoritesActionFactory;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * The result page for an executed Object Search
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class ObjectSearchResultPage extends Page
    implements ISearchResultPage, ISearchResultListener,
    ISearchResultPageExtension<ObjectSearchQuery>, IFilterableView, IAdaptable {
  public static final String GROUPED_BY_PACKAGE_PREF = "com.devepos.adt.saat.objectsearch.groupByPackage"; //$NON-NLS-1$

  public static final String LAYOUT_TREE = ObjectSearchResultPage.class.getCanonicalName() +
      "treeLayoutEnabled";
  public static final String LAYOUT_LIST = ObjectSearchResultPage.class.getCanonicalName() +
      "listLayoutEnabled";

  private String id;
  private UIState state;
  private ObjectSearchResult result;
  private ISearchResultViewPart searchViewPart;
  private StructuredViewer resultViewer;
  private ViewLabelProvider resultViewerLabelProvider;
  private Composite mainComposite;
  private FilterableComposite<?, ?> filterableComposite;
  private ObjectSearchQuery searchQuery;
  /**
   * Flag to indicate the list layout is currently active
   */
  private boolean isListLayoutActive;

  private CollapseAllTreeNodesAction collapseAllNodesAction;
  private ExpandAllAction expandAllAction;
  private CollapseTreeNodesAction collapseNodesAction;
  private ExpandSelectedFolderNodesAction expandPackageNodesAction;
  private CopyToClipboardAction copyToClipBoardAction;
  private OpenObjectSearchPreferences openPreferencesAction;
  private GroupByPackageAction groupByPackageAction;
  private RadioActionGroup layoutActionGroup;
  private IAction favoritesAction;
  private ViewerSelectionProviderAdapter viewerAdapter;
  private MenuManager menuMgr;

  private IAbapProjectProvider projectProvider;
  private boolean isDbBrowserIntegrationAvailable;
  private boolean isCdsTopDownAnalysisAvailable;
  private boolean isCdsUsedEntitiesAnalysisAvailable;
  private boolean isCdsAnalysisAvailable;
  private final IPreferenceStore prefStore;
  private ContextHelper contextHelper;
  private QueryListenerAdapter queryListener;
  private AdtTypeAlternativeImgMapper adtTypeImageMapper;

  public ObjectSearchResultPage() {
    prefStore = SearchAndAnalysisPlugin.getDefault().getPreferenceStore();
    prefStore.setDefault(GROUPED_BY_PACKAGE_PREF, false);
  }

  /**
   * Label provider for list output of result
   */
  static class ListViewLabelProvider extends ViewLabelProvider {

    @Override
    public Image getImage(final Object element) {
      Image image = null;
      final var adtObjRefNode = (IAdtObjectReferenceNode) element;

      var typeName = adtObjRefNode.getAdtObjectType();
      if (IAdtObjectTypeConstants.INTERFACE_METHOD.equals(typeName)
          || IAdtObjectTypeConstants.METHOD_IMPLEMENTATION.equals(typeName)) {
        image = ImageUtil.getMethodImage(adtObjRefNode.getProperties(),
            IAdtObjectTypeConstants.INTERFACE_METHOD.equals(typeName));
      }

      if (image == null) {
        // first try to map the type to an alternative image key
        image = typeImageMapper != null ? typeImageMapper.mapTypeToImage(typeName) : null;
        if (image == null) {
          image = AdtTypeUtil.getInstance().getTypeImage(typeName);
        }
      }
      return image;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      var text = new StyledString();
      final var searchResult = (IAdtObjectReferenceNode) element;

      text.append(searchResult.getDisplayName());

      var parent = searchResult.getParent();
      if (parent != null) {
        text.append(" - ");
        text.append(parent.getName(), StyledString.QUALIFIER_STYLER);
      }

      final String description = searchResult.getDescription();
      if (description != null && !description.isEmpty()) {
        text.append("  " + description + "  ", //$NON-NLS-1$ //$NON-NLS-2$
            StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
      }

      return text;
    }

  }

  /**
   * Custom view label provider for the Result Tree
   */
  static class ViewLabelProvider extends LabelProvider
      implements ILabelProvider, IStyledLabelProvider {

    protected AdtTypeAlternativeImgMapper typeImageMapper;

    @Override
    public Image getImage(final Object element) {
      Image image;
      final var adtObjRefNode = (IAdtObjectReferenceNode) element;
      image = adtObjRefNode.getImage();

      var typeName = adtObjRefNode.getAdtObjectType();

      if (image == null) {
        if (adtObjRefNode.getObjectType() == ObjectType.DATA_DEFINITION) {
          image = SearchAndAnalysisPlugin.getDefault().getImage(IImages.CDS_VIEW);
        } else if (IAdtObjectTypeConstants.INTERFACE_METHOD.equals(typeName)
            || IAdtObjectTypeConstants.METHOD_IMPLEMENTATION.equals(typeName)) {
          image = ImageUtil.getMethodImage(adtObjRefNode.getProperties(),
              IAdtObjectTypeConstants.INTERFACE_METHOD.equals(typeName));
        } else {
          // first try to map the type to an alternative image key
          image = typeImageMapper != null ? typeImageMapper.mapTypeToImage(typeName) : null;
          if (image == null) {
            image = AdtTypeUtil.getInstance().getTypeImage(typeName);
          }
        }
        final var extendedResult = adtObjRefNode.getAdapter(IExtendedAdtObjectInfo.class);
        if (extendedResult != null) {
          final String[] overlayImages = new String[4];
          if (extendedResult.getSourceType() != null) {
            overlayImages[IDecoration.BOTTOM_RIGHT] = extendedResult.getSourceType().getImageId();
          }
          image = SearchAndAnalysisPlugin.getDefault().overlayImage(image, overlayImages);
        }

      }
      return image;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      var text = new StyledString();
      final var searchResult = (IAdtObjectReferenceNode) element;

      text.append(searchResult.getDisplayName());

      if (element instanceof ICollectionTreeNode) {
        final var collectionNode = (ICollectionTreeNode) element;
        if (collectionNode.hasChildren()) {
          final String size = ((ICollectionTreeNode) element).getSizeAsString();
          if (size != null) {
            text.append(" (" + size + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
          }
        }
      }

      final String description = searchResult.getDescription();
      if (description != null && !description.isEmpty()) {
        text.append("  " + description + "  ", //$NON-NLS-1$ //$NON-NLS-2$
            StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
      }

      return text;
    }

    @Override
    public String getText(final Object element) {
      final ITreeNode searchResult = (ITreeNode) element;

      return searchResult.getName();
    }

    public void setTypeImageMapper(final AdtTypeAlternativeImgMapper typeImageMapper) {
      this.typeImageMapper = typeImageMapper;
    }
  }

  private class ExpandSelectedFolderNodesAction extends Action {
    private TreeViewer viewer;

    public ExpandSelectedFolderNodesAction() {
      super(Messages.ObjectSearch_ExpandNodeAction_xmsg,
          AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.EXPAND_ALL));
    }

    @Override
    public void run() {
      if (viewer == null) {
        return;
      }
      final IStructuredSelection selection = viewer.getStructuredSelection();
      if (selection == null) {
        return;
      }
      BusyIndicator.showWhile(getSite().getShell().getDisplay(), () -> {
        viewer.getControl().setRedraw(false);
        try {
          for (final Object selectedObject : selection.toList()) {
            final var node = (ICollectionTreeNode) selectedObject;
            viewer.setExpandedState(node, true);
            for (final var subNode : node.getCollectionChildrenRecursive()) {
              viewer.setExpandedState(subNode, true);
            }
          }
        } finally {
          viewer.getControl().setRedraw(true);
        }
      });
    }

    public void setViewer(final TreeViewer viewer) {
      this.viewer = viewer;
    }
  }

  private class GroupByPackageAction extends Action {
    public GroupByPackageAction() {
      super(Messages.ObjectSearch_GroupByPackageAction_xtol, AS_CHECK_BOX);
      setImageDescriptor(SearchAndAnalysisPlugin.getDefault().getImageDescriptor(IImages.PACKAGE));
    }

    @Override
    public void run() {
      updateGrouping();
    }
  }

  private class TableContentProvider implements IStructuredContentProvider {

    @Override
    public Object[] getElements(final Object inputElement) {
      if (result != null) {
        return result.getResultForList();
      }
      return ObjectSearchResult.EMPTY_RESULT;
    }

  }

  private class TreeContentProvider extends LazyLoadingTreeContentProvider {
    @Override
    public Object[] getElements(final Object inputElement) {
      if (result != null) {
        return result.getResultForTree(groupByPackageAction.isChecked());
      }
      return ObjectSearchResult.EMPTY_RESULT;
    }
  }

  /*
   * Represents the current state of the object
   */
  private static class UIState {
    private ISelection selection;
    private String filterText;
    private TreePath[] expandedPaths;

    /**
     * @return the expandedPaths
     */
    public TreePath[] getExpandedPaths() {
      return expandedPaths;
    }

    public String getFilterText() {
      return filterText;
    }

    /**
     * @return the stored selection
     */
    public ISelection getSelection() {
      return selection;
    }

    /**
     * @return <code>true</code> if the stored state has a selection
     */
    public boolean hasSelection() {
      return selection != null && !selection.isEmpty();
    }

    /**
     * @param expandedPaths the expandedPaths to set
     */
    public void setExpandedPaths(final TreePath[] expandedPaths) {
      this.expandedPaths = expandedPaths;
    }

    public void setFilterText(final String filterText) {
      this.filterText = filterText;
    }

    /**
     * @param selection the selectedObject to set
     */
    public void setSelection(final ISelection selection) {
      this.selection = selection;
    }
  }

  @Override
  public void createControl(final Composite parent) {
    mainComposite = createViewerComposite(parent);

    initializeActions();

    viewerAdapter = new ViewerSelectionProviderAdapter();
    getSite().setSelectionProvider(viewerAdapter);
    createMenu();
    createDefaultViewer();

    contextHelper = ContextHelper.createForServiceLocator(getSite());
    contextHelper.activateAbapContext();
    contextHelper.activateContext(IGeneralContextConstants.SEARCH_PAGE_VIEWS);
    contextHelper.activateContext(IGeneralContextConstants.FILTERABLE_VIEWS);

    queryListener = new QueryListenerAdapter() {
      @Override
      public void queryStarting(final ISearchQuery query) {
        if (result != null && query.getSearchResult() != null
            && result.equals(query.getSearchResult())) {
          if (filterableComposite != null && filterableComposite.isFilterVisible()) {
            Display.getDefault().asyncExec(() -> filterableComposite.toggleFilterVisiblity());
          }
        }
      }
    };
    NewSearchUI.addQueryListener(queryListener);
  }

  @Override
  public void dispose() {
    if (contextHelper != null) {
      contextHelper.deactivateAllContexts();
    }
    NewSearchUI.removeQueryListener(queryListener);
    super.dispose();
  }

  @Override
  public <T> T getAdapter(final Class<T> adapter) {
    if (adapter == StructuredViewer.class) {
      return adapter.cast(resultViewer);
    }
    return null;
  }

  @Override
  public Control getControl() {
    return mainComposite;
  }

  @Override
  public String getID() {
    return id;
  }

  @Override
  public String getLabel() {
    if (result != null) {
      return result.getLabel();
    }
    return ""; //$NON-NLS-1$
  }

  @Override
  public String getSearchPageId() {
    return ObjectSearchPage.PAGE_ID;
  }

  /**
   * @return the {@link ObjectSearchQuery} of this the result page
   */
  @Override
  public ObjectSearchQuery getSearchQuery() {
    return searchQuery != null ? searchQuery : null;
  }

  @Override
  public Object getUIState() {
    if (resultViewer != null && !resultViewer.getControl().isDisposed()) {
      final UIState uiState = new UIState();
      if (resultViewer instanceof TreeViewer) {
        uiState.setExpandedPaths(((TreeViewer) resultViewer).getExpandedTreePaths());
      }
      uiState.setSelection(resultViewer.getSelection());
      uiState.setFilterText(filterableComposite.getFilterString());
      return uiState;
    }
    return null;
  }

  @Override
  public void restoreState(final IMemento memento) {

  }

  @Override
  public void saveState(final IMemento memento) {

  }

  @Override
  public void searchResultChanged(final SearchResultEvent e) {
    if (e instanceof ObjectSearchResultEvent && ((ObjectSearchResultEvent) e).isCleanup()) {
      return;
    }
    state = null;
    Display.getDefault().asyncExec(() -> {
      resultViewer.setInput(null);
      WorkbenchUtil.bringPartToFront(searchViewPart);
      searchViewPart.updateLabel();
      final IAbapProjectProvider projectProvider = searchQuery.getProjectProvider();
      if (projectProvider != this.projectProvider) {
        this.projectProvider = projectProvider;
        checkFeatureAvailibility();
      }
      resultViewer.setInput(e.getSearchResult());
      if (resultViewer instanceof TreeViewer && groupByPackageAction.isChecked()) {
        expandAllPackages();
      }
      updateUiState();
    });

  }

  @Override
  public void setActionBars(final IActionBars actionBars) {
    final IToolBarManager tbm = actionBars.getToolBarManager();
    tbm.appendToGroup(IContextMenuConstants.GROUP_NEW, CommandFactory
        .createContribItemById(IGeneralCommandConstants.OPEN_QUERY_IN_SEARCH_DIALOG, false, null));
    tbm.appendToGroup(IContextMenuConstants.GROUP_NEW, favoritesAction);
    copyToClipBoardAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_COPY);
    actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copyToClipBoardAction);
    actionBars.updateActionBars();
  }

  @Override
  public void setFocus() {
    if (resultViewer != null && !resultViewer.getControl().isDisposed()) {
      resultViewer.getControl().setFocus();
    }
  }

  @Override
  public void setID(final String id) {
    this.id = id;
  }

  @Override
  public void setInput(final ISearchResult search, final Object uiState) {
    if (search == null && filterableComposite != null) {
      filterableComposite.resetFilter();
      filterableComposite.setFilterVisible(false);
    }
    if (result != null) {
      // clean up old search
      result.removeListener(this);
      resultViewer.setInput(null);
    }
    result = (ObjectSearchResult) search;
    if (result != null) {
      result.addListener(this);
      searchQuery = (ObjectSearchQuery) result.getQuery();
      adtTypeImageMapper = new AdtTypeAlternativeImgMapper(
          searchQuery.getSearchRequest().getOutputConfig().getAdtAltTypeImages());
      updateLayoutFromPref();
      updateViewerFromResult();
      resultViewerLabelProvider.setTypeImageMapper(adtTypeImageMapper);
      state = uiState instanceof UIState ? (UIState) uiState : null;
      projectProvider = searchQuery.getProjectProvider();
      checkFeatureAvailibility();
      if (!NewSearchUI.isQueryRunning(searchQuery)) {
        updateUiState();
      }
      updateActionBars();
    } else {
      searchViewPart.updateLabel();
    }

  }

  @Override
  public void setViewPart(final ISearchResultViewPart part) {
    searchViewPart = part;
  }

  @Override
  public void toggleTextFilterVisibility() {
    if (filterableComposite != null) {
      filterableComposite.toggleFilterVisiblity();
    }
  }

  /**
   * Creates the composite which will hold the tree viewer of the page
   * <p>
   * Subclasses may override to create a more complex layout <br>
   * </p>
   *
   * @param parent the parent composite
   * @return
   */
  protected Composite createViewerComposite(final Composite parent) {
    final Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayoutData(new GridData(GridData.FILL_BOTH));
    composite.setSize(100, 100);
    composite.setLayout(new FillLayout());
    return composite;
  }

  private void checkFeatureAvailibility() {
    isDbBrowserIntegrationAvailable = false;
    isCdsTopDownAnalysisAvailable = false;
    isCdsUsedEntitiesAnalysisAvailable = false;
    isCdsAnalysisAvailable = false;
    if (projectProvider != null && projectProvider.ensureLoggedOn()) {
      isDbBrowserIntegrationAvailable = FeatureTester
          .isSapGuiDbBrowserAvailable(projectProvider.getProject());
      isCdsTopDownAnalysisAvailable = FeatureTester
          .isCdsTopDownAnalysisAvailable(projectProvider.getProject());
      isCdsUsedEntitiesAnalysisAvailable = FeatureTester
          .isCdsUsedEntitiesAnalysisAvailable(projectProvider.getProject());
      isCdsAnalysisAvailable = FeatureTester.isCdsAnalysisAvailable(projectProvider.getProject());
    }

  }

  private void configureViewer() {
    resultViewer.setUseHashlookup(true);
    resultViewer.addOpenListener(event -> {
      final var sel = (IStructuredSelection) event.getSelection();
      final Iterator<?> selIter = sel.iterator();
      while (selIter.hasNext()) {
        handleOpenOnNode(selIter.next());
      }
    });
    filterableComposite.setElementMatcher(element -> {
      var adtObjectRefNode = (IAdtObjectReferenceNode) element;
      var wordMatcher = filterableComposite.getWordMatcher();

      if (adtObjectRefNode.hasChildren()) {
        return false;
      }

      var text = resultViewerLabelProvider.getStyledText(element);
      if (text == null) {
        return false;
      }

      return wordMatcher.matchesWord(text.getString());
    });

    viewerAdapter.setViewer(resultViewer);
    resultViewer.addSelectionChangedListener(viewerAdapter);

    final Control viewerControl = resultViewer.getControl();
    final var menu = menuMgr.createContextMenu(viewerControl);
    viewerControl.setMenu(menu);
  }

  private void createDefaultViewer() {
    createTreeViewer();
    updateTreeViewerActions();
  }

  private void createMenu() {
    menuMgr = new MenuManager();
    menuMgr.setRemoveAllWhenShown(true);
    menuMgr.setParent(getSite().getActionBars().getMenuManager());
    menuMgr.addMenuListener(menu -> {
      fillContextMenu(menu);
    });
    getSite().registerContextMenu(searchViewPart.getViewSite().getId(), menuMgr, viewerAdapter);
  }

  private void createTableViewer() {
    var table = new FilterableTable(mainComposite, null, true,
        FilterableComposite.TEXT_SMALL_H_MARGIN);
    filterableComposite = table;
    table.addKeyListenerForFilterFocus();
    resultViewer = new TableViewer(table, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    table.setViewer((TableViewer) resultViewer);
    resultViewer.setContentProvider(new TableContentProvider());
    resultViewerLabelProvider = new ListViewLabelProvider();
    resultViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(resultViewerLabelProvider));
    isListLayoutActive = true;
    configureViewer();

    resultViewer.setComparator(new ViewerComparator() {
      @Override
      public int compare(final Viewer viewer, final Object e1, final Object e2) {
        var adtObjectNode1 = (IAdtObjectReferenceNode) e1;
        var adtObjectNode2 = (IAdtObjectReferenceNode) e2;
        return adtObjectNode1.getName().compareTo(adtObjectNode2.getName());
      }

    });
  }

  /*
   * Creates the result tree of the object search
   */
  private void createTreeViewer() {
    var tree = new FilterableTree(mainComposite, null, true,
        FilterableComposite.TEXT_SMALL_H_MARGIN);
    filterableComposite = tree;
    resultViewer = new TreeViewer(tree, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    tree.setViewer((TreeViewer) resultViewer);
    resultViewer.setContentProvider(new TreeContentProvider());
    resultViewerLabelProvider = new ViewLabelProvider();
    resultViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(resultViewerLabelProvider));
    isListLayoutActive = false;
    configureViewer();
  }

  /*
   * Expands all package nodes
   */
  private void expandAllPackages() {
    if (!(resultViewer instanceof TreeViewer)) {
      return;
    }
    var treeViewer = (TreeViewer) resultViewer;
    BusyIndicator.showWhile(getSite().getShell().getDisplay(), () -> {
      final var packages = result.getPackages();
      if (packages != null) {
        try {
          var input = result.getResultForTree(groupByPackageAction.isChecked());
          treeViewer.getControl().setRedraw(false);
          treeViewer.setExpandedElements((Object[]) packages);
          // expand first non package collection node
          var firstPackage = input[0];
          for (var childNode : firstPackage.getCollectionChildrenRecursive()) {
            if (!(childNode instanceof PackageNode)) {
              treeViewer.expandToLevel(childNode, AbstractTreeViewer.ALL_LEVELS);
              break;
            }
          }
        } finally {
          treeViewer.getControl().setRedraw(true);
        }
      }
    });
  }

  private void fillContextMenu(final IMenuManager menu) {
    menu.add(new Separator(IContextMenuConstants.GROUP_NEW));
    menu.add(new Separator(IContextMenuConstants.GROUP_EDIT));
    menu.add(new GroupMarker(IContextMenuConstants.GROUP_OPEN));
    menu.add(
        new GroupMarker(com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_DB_BROWSER));
    menu.add(
        new GroupMarker(com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_CDS_ANALYSIS));
    menu.add(new GroupMarker(IGeneralMenuConstants.GROUP_NODE_ACTIONS));
    menu.add(new GroupMarker(IContextMenuConstants.GROUP_SEARCH));

    var additionalItems = new ArrayList<IContributionItem>();

    final IStructuredSelection selection = resultViewer.getStructuredSelection();
    if (selection == null || selection.isEmpty()) {
      return;
    }
    boolean selectionHasExpandedNodes = false;
    final List<IAdtObjectReference> adtObjRefs = new ArrayList<>();
    final List<IAdtObjectReference> previewAdtObjRefs = new ArrayList<>();
    final int selectionSize = selection.size();
    int launchableNodeCount = 0;
    boolean singleDataPreviewObjectSelected = false;
    boolean singleCdsViewSelected = false;
    boolean hasCollapsedPackages = false;

    boolean isTreeViewer = resultViewer instanceof TreeViewer;

    // determine overall action availability depending on the selection
    for (final Object selectedObject : selection.toList()) {
      if (selectedObject instanceof ILaunchableNode) {
        launchableNodeCount++;
      }
      if (selectedObject instanceof IAdtObjectReferenceNode) {
        final IAdtObjectReferenceNode objRefNode = (IAdtObjectReferenceNode) selectedObject;
        final IAdtObjectReference adtObjectRef = objRefNode.getObjectReference();
        if (objRefNode.supportsDataPreview()) {
          previewAdtObjRefs.add(adtObjectRef);
        }
        adtObjRefs.add(adtObjectRef);

        if (selectionSize == 1) {
          singleDataPreviewObjectSelected = true;
          singleCdsViewSelected = objRefNode.getObjectType() == ObjectType.DATA_DEFINITION;
        }
      }

      if (isTreeViewer && (!selectionHasExpandedNodes || !hasCollapsedPackages)
          && selectedObject instanceof ICollectionTreeNode) {
        var collectionNode = (ICollectionTreeNode) selectedObject;
        if (collectionNode.hasChildren()) {
          if (((TreeViewer) resultViewer).getExpandedState(selectedObject)) {
            selectionHasExpandedNodes = true;
          } else {
            hasCollapsedPackages = true;
          }
        }
      }
    }

    // fill Open object action
    if (!adtObjRefs.isEmpty()) {
      menu.appendToGroup(IContextMenuConstants.GROUP_OPEN, new Separator());
      menu.appendToGroup(IContextMenuConstants.GROUP_OPEN,
          new OpenAdtObjectAction(projectProvider.getProject(), adtObjRefs));
    }
    // Fill Data Preview actions
    if (!previewAdtObjRefs.isEmpty()) {
      menu.appendToGroup(IContextMenuConstants.GROUP_OPEN,
          new ExecuteAdtObjectAction(projectProvider.getProject(), previewAdtObjRefs, true));
      if (isDbBrowserIntegrationAvailable) {
        menu.appendToGroup(com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_DB_BROWSER,
            new Separator());
        SearchToolsMenuItemFactory.addOpenInDbBrowserCommand(menu,
            com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_DB_BROWSER, false);
        SearchToolsMenuItemFactory.addOpenInDbBrowserCommand(menu,
            com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_DB_BROWSER, true);
      }

      // is a separator at the end of the group needed?
      if (!singleDataPreviewObjectSelected) {
        if (isDbBrowserIntegrationAvailable) {
          menu.appendToGroup(
              com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_DB_BROWSER,
              new Separator());
        } else {
          menu.appendToGroup(IContextMenuConstants.GROUP_OPEN, new Separator());
        }
      }
    }

    if (!adtObjRefs.isEmpty() && selectionSize == 1) {
      additionalItems.add(new ActionContributionItem(com.devepos.adt.base.ui.action.ActionFactory
          .createAction(AdtBaseUIResources
              .getString(IAdtBaseStrings.Action_ShowElementInformation_xmsg), null, () -> {
            if (resultViewer instanceof TreeViewer) {
              AdtElementInformationUtil.showElementInformation(projectProvider.getProject(),
                  adtObjRefs.get(0), ((TreeViewer) resultViewer).getTree());
            } else {
              AdtElementInformationUtil.showElementInformation(projectProvider.getProject(),
                  adtObjRefs.get(0), ((TableViewer) resultViewer).getTable());
            }
          })));
      additionalItems.add(
          CommandFactory.createContribItemById(IGeneralCommandConstants.WHERE_USED_IN, true, null));
    }

    // fill CDS analysis actions
    if (singleDataPreviewObjectSelected && isCdsAnalysisAvailable) {
      menu.appendToGroup(com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_CDS_ANALYSIS,
          new Separator());
      if (singleCdsViewSelected && isCdsTopDownAnalysisAvailable) {
        SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(menu,
            com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_CDS_ANALYSIS,
            ICommandConstants.CDS_TOP_DOWN_ANALYSIS);
      }
      if (!previewAdtObjRefs.isEmpty()) {
        SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(menu,
            com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_CDS_ANALYSIS,
            ICommandConstants.WHERE_USED_IN_CDS_ANALYSIS);
      }
      if (singleCdsViewSelected && isCdsUsedEntitiesAnalysisAvailable) {
        SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(menu,
            com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_CDS_ANALYSIS,
            ICommandConstants.USED_ENTITIES_ANALYSIS);
      }
      if (!previewAdtObjRefs.isEmpty()) {
        SearchToolsMenuItemFactory.addCdsAnalyzerCommandItem(menu,
            com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_CDS_ANALYSIS,
            ICommandConstants.FIELD_ANALYSIS);
      }
      // is a separator at the end of the group needed?
      if (!additionalItems.isEmpty() && !selectionHasExpandedNodes && !hasCollapsedPackages) {
        menu.appendToGroup(
            com.devepos.adt.saat.ui.internal.IContextMenuConstants.GROUP_CDS_ANALYSIS,
            new Separator());
      }
    }

    // fill folder actions like expand/collapse
    if (selectionHasExpandedNodes || hasCollapsedPackages) {
      menu.appendToGroup(IGeneralMenuConstants.GROUP_NODE_ACTIONS, new Separator());
      if (hasCollapsedPackages) {
        menu.appendToGroup(IGeneralMenuConstants.GROUP_NODE_ACTIONS, expandPackageNodesAction);
      }
      if (selectionHasExpandedNodes) {
        menu.appendToGroup(IGeneralMenuConstants.GROUP_NODE_ACTIONS, collapseNodesAction);
      }
      // is a separator at the end of the group needed?
      if (!additionalItems.isEmpty()) {
        menu.appendToGroup(IGeneralMenuConstants.GROUP_NODE_ACTIONS, new Separator());
      }
    }

    menu.appendToGroup(IContextMenuConstants.GROUP_EDIT, copyToClipBoardAction);

    if (!additionalItems.isEmpty()) {
      // if 'additions' node is created as separator if it is not needed than the context menu will
      // end with a separator which is not pretty
      menu.add(launchableNodeCount == selectionSize
          ? new Separator(IWorkbenchActionConstants.MB_ADDITIONS)
          : new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
      for (var item : additionalItems) {
        menu.insertBefore(IWorkbenchActionConstants.MB_ADDITIONS, item);
      }
    }
  }

  private void handleOpenOnNode(final Object node) {
    if (node == null) {
      return;
    }
    if (node instanceof IAdtObjectReferenceNode) {
      final IAdtObjectReferenceNode selectedAdtObject = (IAdtObjectReferenceNode) node;

      if (selectedAdtObject != null) {
        searchQuery.getProjectProvider()
            .openObjectReference(selectedAdtObject.getObjectReference());
      }
    } else if (node instanceof ICollectionTreeNode && resultViewer instanceof TreeViewer) {
      var treeViewer = (TreeViewer) resultViewer;
      final boolean isExpanded = treeViewer.getExpandedState(node);
      if (isExpanded) {
        treeViewer.collapseToLevel(node, 1);
      } else {
        treeViewer.expandToLevel(node, 1);
      }
    }
  }

  private void initializeActions() {
    favoritesAction = SearchFavoritesActionFactory
        .createSearchFavoritesAction(ObjectSearchQuery.SEARCH_FAVORITE_TYPE);
    collapseAllNodesAction = new CollapseAllTreeNodesAction();
    collapseAllNodesAction.setId(ObjectSearchResultPage.class.getName() + ".collapseAllAction");
    collapseNodesAction = new CollapseTreeNodesAction();
    copyToClipBoardAction = new CopyToClipboardAction();
    copyToClipBoardAction.registerViewerAdapter(this);
    groupByPackageAction = new GroupByPackageAction();
    groupByPackageAction.setId(ObjectSearchResultPage.class.getName() + ".groupBy");
    groupByPackageAction.setChecked(prefStore.getBoolean(GROUPED_BY_PACKAGE_PREF));
    expandAllAction = new ExpandAllAction();
    expandAllAction.setId(ObjectSearchResultPage.class.getName() + ".expandAll");
    expandPackageNodesAction = new ExpandSelectedFolderNodesAction();
    openPreferencesAction = new OpenObjectSearchPreferences();

    layoutActionGroup = new RadioActionGroup();
    layoutActionGroup.addAction(LAYOUT_LIST, Messages.ObjectSearchResultPage_showAsListAction_xlbl,
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.LIST_LAYOUT), false);
    layoutActionGroup.addAction(LAYOUT_TREE, Messages.ObjectSearchResultPage_showAsTreeAction_xlbl,
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.TREE_LAYOUT), true);
    layoutActionGroup.addActionToggledListener(l -> {
      prefStore.putValue(String.format("%s.%s.layout",
          ObjectSearchResultPage.class.getCanonicalName(), result.getUsedSearchType()),
          layoutActionGroup.getToggledActionId());
      updateViewerLayout();
    });
  }

  private void updateActionBars() {
    var actionBars = getSite().getActionBars();
    var viewMenu = actionBars.getMenuManager();

    viewMenu.removeAll();

    if (result.supportsListLayout()) {
      layoutActionGroup.contributeToMenuManager(viewMenu);
      layoutActionGroup.setActionChecked(result.isListLayoutActive() ? LAYOUT_LIST : LAYOUT_TREE);
      viewMenu.add(new Separator());
    }
    viewMenu.add(CommandFactory
        .createContribItemById(IGeneralCommandConstants.TOGGLE_VIEWER_TEXT_FILTER, false, null));
    viewMenu.add(new Separator());
    viewMenu.add(openPreferencesAction);

    if (result.supportsListLayout()) {
      updateTreeActions(
          !((ObjectSearchResult) getSearchQuery().getSearchResult()).isListLayoutActive());
    } else {
      updateTreeActions(true);
    }
    updateTreeViewerActions();
  }

  private void updateGrouping() {
    BusyIndicator.showWhile(getSite().getShell().getDisplay(), () -> {
      resultViewer.refresh();
    });
    prefStore.putValue(GROUPED_BY_PACKAGE_PREF, Boolean.toString(groupByPackageAction.isChecked()));
  }

  private void updateLayoutFromPref() {
    if (result.supportsListLayout()) {
      var storedLayoutForType = prefStore.getString(String.format("%s.%s.layout",
          ObjectSearchResultPage.class.getCanonicalName(), result.getUsedSearchType()));
      if (storedLayoutForType != null) {
        result.setListLayoutActive(storedLayoutForType.equals(LAYOUT_LIST));
      }
    }
  }

  private void updateTreeActions(final boolean enable) {
    var actionBars = getSite().getActionBars();
    var tbm = actionBars.getToolBarManager();

    if (enable) {
      if (tbm.find(collapseAllNodesAction.getId()) == null) {
        tbm.appendToGroup(IContextMenuConstants.GROUP_EDIT, expandAllAction);
        tbm.appendToGroup(IContextMenuConstants.GROUP_EDIT, collapseAllNodesAction);
        tbm.appendToGroup(IContextMenuConstants.GROUP_VIEWER_SETUP, groupByPackageAction);
      }
    } else {
      tbm.remove(collapseAllNodesAction.getId());
      tbm.remove(expandAllAction.getId());
      tbm.remove(groupByPackageAction.getId());
    }

    actionBars.updateActionBars();
  }

  private void updateTreeViewerActions() {
    if (resultViewer instanceof TreeViewer) {
      expandAllAction.setTreeViewer((TreeViewer) resultViewer);
      expandPackageNodesAction.setViewer((TreeViewer) resultViewer);
      collapseAllNodesAction.setViewer((TreeViewer) resultViewer);
      collapseNodesAction.setViewer((TreeViewer) resultViewer);
    } else {
      expandAllAction.setTreeViewer(null);
      expandPackageNodesAction.setViewer(null);
      collapseAllNodesAction.setViewer(null);
      collapseNodesAction.setViewer(null);
    }
  }

  private void updateUiState() {
    Display.getDefault().asyncExec(() -> {
      if (resultViewer == null || resultViewer.getControl().isDisposed() || result == null) {
        return;
      }
      if (resultViewer instanceof TreeViewer && state != null && state.getExpandedPaths() != null) {
        var treeViewer = (TreeViewer) resultViewer;
        treeViewer.getControl().setRedraw(false);
        try {
          treeViewer.setExpandedTreePaths(state.getExpandedPaths());
        } finally {
          treeViewer.getControl().setRedraw(true);
        }
      }
      // update text filter
      if (state != null && !StringUtil.isEmpty(state.getFilterText())) {
        filterableComposite.setFilterText(state.getFilterText(), false);
        filterableComposite.setFilterVisible(true);
      } else {
        filterableComposite.resetFilter();
        filterableComposite.setFilterVisible(false);
      }
      resultViewer.getControl().setFocus();
      IAdtObjectReferenceNode[] results = null;
      if (isListLayoutActive) {
        results = result.getResultForList();
      } else {
        results = result.getResultForTree(groupByPackageAction.isChecked());
      }
      if (results != null && results.length > 0) {
        if (state != null && state.hasSelection()) {
          resultViewer.setSelection(state.getSelection(), true);
        } else {
          resultViewer.setSelection(new StructuredSelection(results[0]));
        }
      }
      resultViewer.refresh();
    });
  }

  private void updateViewerFromResult() {
    if (result.isListLayoutActive() != isListLayoutActive) {

      var oldSelection = resultViewer.getSelection();
      var currentFilter = filterableComposite.getFilterString();
      var isFiltered = !StringUtil.isEmpty(currentFilter) && filterableComposite.isFilterVisible();

      resultViewer.setInput(null);
      viewerAdapter.setViewer(null);
      resultViewer.removeSelectionChangedListener(viewerAdapter);
      resultViewer.getControl().dispose();
      filterableComposite.dispose();
      filterableComposite = null;
      resultViewer = null;

      if (result.isListLayoutActive()) {
        createTableViewer();
      } else {
        createTreeViewer();
      }
      if (isFiltered) {
        filterableComposite.setFilterVisible(true);
        filterableComposite.setFilterText(currentFilter);
      }
      resultViewer.setInput(result);
      if (oldSelection != null) {
        resultViewer.setSelection(oldSelection, true);
      }
    } else {
      resultViewer.setInput(result);
    }

  }

  private void updateViewerLayout() {
    result.setListLayoutActive(layoutActionGroup.getToggledActionId().equals(LAYOUT_LIST));
    updateViewerFromResult();
    mainComposite.layout(true);
    filterableComposite.layout(true);

    updateTreeActions(layoutActionGroup.getToggledActionId().equals(LAYOUT_TREE));
    updateTreeViewerActions();

    resultViewer.getControl().setFocus();
  }

}
