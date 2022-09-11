package com.devepos.adt.callhierarchy.ui.internal.views;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.ViewPart;

import com.devepos.adt.base.destinations.IDestinationProvider;
import com.devepos.adt.base.elementinfo.LazyLoadingRefreshMode;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IGeneralMenuConstants;
import com.devepos.adt.base.ui.IPinnableView;
import com.devepos.adt.base.ui.UIState;
import com.devepos.adt.base.ui.ViewPartListener;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.action.CollapseAllTreeNodesAction;
import com.devepos.adt.base.ui.action.IToggleViewerLayoutActionSettings;
import com.devepos.adt.base.ui.action.OpenPreferencesAction;
import com.devepos.adt.base.ui.action.PinViewAction;
import com.devepos.adt.base.ui.action.RadioActionGroup;
import com.devepos.adt.base.ui.action.ToggleViewLayoutAction;
import com.devepos.adt.base.ui.action.ViewLayoutActionFactory;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.viewsupport.ViewerSelectionProviderAdapter;
import com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;
import com.devepos.adt.callhierarchy.ui.internal.Activator;
import com.devepos.adt.callhierarchy.ui.internal.CallHierarchyInput;
import com.devepos.adt.callhierarchy.ui.internal.CallHierarchyManager;
import com.devepos.adt.callhierarchy.ui.internal.CallHierarchyViewSettings;
import com.devepos.adt.callhierarchy.ui.internal.CallPositionViewer;
import com.devepos.adt.callhierarchy.ui.internal.HierarchyTreeTableViewer;
import com.devepos.adt.callhierarchy.ui.internal.HierarchyTreeViewerLabelProvider;
import com.devepos.adt.callhierarchy.ui.internal.HierarchyViewerType;
import com.devepos.adt.callhierarchy.ui.internal.HistoryDropDownAction;
import com.devepos.adt.callhierarchy.ui.internal.ICallHierarchyListener;
import com.devepos.adt.callhierarchy.ui.internal.preferences.CallHierarchyPreferencesPage;
import com.devepos.adt.callhierarchy.ui.internal.preferences.IPreferences;

/**
 * View to display the result of a Call Hierarchy of an ABAP element (method, function or
 * subroutine)
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CallHierarchyView extends ViewPart implements IPinnableView, ICallHierarchyListener {

  public static final String VIEW_ID = "com.devepos.adt.callhierarchy.ui.views.CallHierarchy";

  private static final int PAGE_EMPTY = 0;
  private static final int PAGE_VIEWER = 1;

  private CollapseAllTreeNodesAction collapseAllNodesAction;
  private CallHierarchyInput currentHierarchy;
  private SashForm hierarchySplitter;
  private TreeViewer hierarchyViewer;
  private RadioActionGroup hierarchyViewerLayoutAction;
  private CallPositionViewer locationViewer;
  private Label noHierarchyShownLabel;
  private PageBook pageBook;
  private Composite viewerContainer;

  private boolean isPinned;

  private HistoryDropDownAction historyDropDownAction;
  private PinViewAction pinViewAction;
  private Action refreshAction;
  private ToggleViewLayoutAction viewLayoutAction;
  private Action showDescriptionsAction;
  private OpenPreferencesAction openPreferencesAction;

  private final ViewPartListener viewPartListener;

  private final Map<CallHierarchyInput, UIState> viewStates;
  private ViewerSelectionProviderAdapter viewerAdapter;
  private MenuManager menuMgr;
  private final IPreferenceStore prefStore;
  private final CallHierarchyViewSettings viewSettings;

  public CallHierarchyView() {
    viewStates = new HashMap<>();
    isPinned = false;

    viewSettings = new CallHierarchyViewSettings();
    prefStore = Activator.getDefault().getPreferenceStore();

    viewPartListener = new ViewPartListener();
    viewPartListener.setPartActivatedConsumer(part -> {
      if (part == this) {
        CallHierarchyViewManager.getInstance().hierarchyViewActivated(this);
      }
    });
  }

  private class ContentProvider extends LazyLoadingTreeContentProvider {

    public ContentProvider() {
      super(LazyLoadingRefreshMode.ROOT_AND_NON_LAZY_CHILDREN, 1);
    }

    @Override
    public Object[] getElements(final Object inputElement) {
      final Object[] nodes = getChildren(inputElement);
      if (nodes != null) {
        return nodes;
      }
      return new Object[0];
    }
  }

  private class RefreshCurrentAnalysisAction extends Action {
    public RefreshCurrentAnalysisAction() {
      super("Refresh", AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.REFRESH));
    }

    @Override
    public void run() {
      if (currentHierarchy != null) {
        currentHierarchy.refresh();
        setContentDescription(currentHierarchy.getLabel());
        getViewer().refresh();
      }
    }
  }

  public static void createContextMenuGroups(final IMenuManager mgr) {
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_NEW));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_OPEN));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_NODE_ACTIONS));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_ADDITIONS));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_EDIT));
  }

  public static void createToolBarGroups(final IToolBarManager toolbar) {
    toolbar.add(new Separator(IGeneralMenuConstants.GROUP_NEW));
    toolbar.add(new Separator(IGeneralMenuConstants.GROUP_EDIT));
    toolbar.add(new Separator(IGeneralMenuConstants.GROUP_NODE_ACTIONS));
    toolbar.add(new Separator(IGeneralMenuConstants.GROUP_SEARCH));
    toolbar.add(new Separator(IGeneralMenuConstants.GROUP_GOTO));
    toolbar.add(new Separator(IGeneralMenuConstants.GROUP_ADDITIONS));
  }

  public static void createViewMenuGroups(final IMenuManager mgr) {
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_PROPERTIES));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_FILTERING));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_ADDITIONS));
  }

  @Override
  public void createPartControl(final Composite parent) {
    pageBook = new PageBook(parent, SWT.NONE);

    noHierarchyShownLabel = new Label(pageBook, SWT.TOP + SWT.LEFT + SWT.WRAP);
    noHierarchyShownLabel.setText(
        "To display the call hierarchy, select a method, a form or a function module, and select the 'Open ABAP Call Hierarchy' menu option.");

    viewerAdapter = new ViewerSelectionProviderAdapter();
    getSite().setSelectionProvider(viewerAdapter);
    registerMenu();

    createHierarchySplitter(pageBook);
    createViewerContainer(hierarchySplitter);
    setupHierarchyViewer();
    createLocationViewer(hierarchySplitter);

    createActions();
    initToolbar();

    getSite().getPage().addPartListener(viewPartListener);
    CallHierarchyManager hierarchyManager = CallHierarchyManager.getInstance();
    hierarchyManager.addCallHierarchyListener(this);

    if (hierarchyManager.hasHierarchies()) {
      showHierarchy(hierarchyManager.getHierarchies()[0]);
    } else {
      showPage(PAGE_EMPTY);
    }
  }

  @Override
  public void dispose() {
    getSite().getPage().removePartListener(viewPartListener);
    CallHierarchyManager.getInstance().removeCallHierarchyListener(this);
    CallHierarchyViewManager.getInstance().hierarchyViewClosed(this);
    super.dispose();
  }

  public CallHierarchyInput getCurrentInput() {
    return currentHierarchy;
  }

  public TreeViewer getViewer() {
    return hierarchyViewer;
  }

  @Override
  public void hierarchyRemoved(final CallHierarchyInput hierarchy) {
    if (hierarchy == currentHierarchy) {
      showPage(PAGE_EMPTY);
    }

    historyDropDownAction.disposeMenu();
    updateViewActions();
  }

  @Override
  public boolean isPinned() {
    return isPinned;
  }

  @Override
  public void setFocus() {
    pageBook.setFocus();
  }

  @Override
  public void setPinned(final boolean pinned) {
    isPinned = pinned;
  }

  public void showHierarchy(final CallHierarchyInput input) {
    if (currentHierarchy != null) {
      saveCurrentViewState();
    }

    currentHierarchy = input;

    if (input != null) {
      setInput();
      showPage(PAGE_VIEWER);
    }
  }

  void updateViewActions() {
    final boolean hasHistory = CallHierarchyManager.getInstance().hasHierarchies();
    historyDropDownAction.setEnabled(hasHistory);
    refreshAction.setEnabled(hasHistory);
    collapseAllNodesAction.setEnabled(hasHistory);
  }

  private void configureHierarchyViewer(final Composite parent) {
    hierarchyViewer.setContentProvider(new ContentProvider());

    hierarchyViewer.addOpenListener(event -> {
      final ITreeSelection sel = (ITreeSelection) event.getSelection();
      final Iterator<?> selectionIter = sel.iterator();
      while (selectionIter.hasNext()) {
        handleOpenOnNode(selectionIter.next());
      }
    });

    hierarchyViewer.addSelectionChangedListener(l -> {
      if (locationViewer != null) {
        IStructuredSelection sel = l.getStructuredSelection();
        if (sel == null || sel.size() != 1) {
          locationViewer.setInput(null);
          return;
        }

        Object selObj = sel.getFirstElement();
        if (!(selObj instanceof ITreeNode)) {
          locationViewer.setInput(null);
          return;
        }
        ITreeNode selNode = (ITreeNode) selObj;
        IHierarchyResultEntry hierarchyEntry = selNode.getAdapter(IHierarchyResultEntry.class);
        if (hierarchyEntry == null) {
          locationViewer.setInput(null);
          return;
        }

        // set call positions to viewer
        locationViewer.setInput(hierarchyEntry.getCallPositions());
      }
    });

    hierarchyViewer.addSelectionChangedListener(viewerAdapter);
    final Menu menu = menuMgr.createContextMenu(hierarchyViewer.getControl());
    hierarchyViewer.getControl().setMenu(menu);

    if (collapseAllNodesAction != null) {
      collapseAllNodesAction.setViewer(hierarchyViewer);
    }
  }

  private void createActions() {
    IToggleViewerLayoutActionSettings viewLayoutActionSettings = ViewLayoutActionFactory
        .getInstance()
        .createDefaultSettings();
    viewLayoutActionSettings.setSingleEnabled(true);
    viewLayoutActionSettings.setSingleActionLabel("Hierarchy only");
    viewLayoutActionSettings.setLayoutPrefOptions(Activator.getDefault().getPreferenceStore(),
        IPreferences.CALL_HIERARCHY_VIEW_LAYOUT);
    viewLayoutAction = ViewLayoutActionFactory.getInstance()
        .createToggleViewLayoutAction(hierarchySplitter, hierarchySplitter,
            viewLayoutActionSettings);

    hierarchyViewerLayoutAction = new RadioActionGroup();
    hierarchyViewerLayoutAction.addAction(HierarchyViewerType.TREE.name(), HierarchyViewerType.TREE
        .getActionLabel(), null, true);
    hierarchyViewerLayoutAction.addAction(HierarchyViewerType.TREE_TABLE.name(),
        HierarchyViewerType.TREE_TABLE.getActionLabel(), null, false);
    hierarchyViewerLayoutAction.setActionChecked(viewSettings.getHierarchyViewerType().name());
    hierarchyViewerLayoutAction.addActionToggledListener(l -> {
      viewSettings.setHierarchyViewerType(hierarchyViewerLayoutAction.getToggledActionId());
      saveCurrentViewState();
      setupHierarchyViewer();
      setInput();
      hierarchyViewer.refresh();
    });

    pinViewAction = new PinViewAction(this);
    refreshAction = new RefreshCurrentAnalysisAction();
    refreshAction.setActionDefinitionId(IWorkbenchCommandConstants.FILE_REFRESH);
    historyDropDownAction = new HistoryDropDownAction(this);
    collapseAllNodesAction = new CollapseAllTreeNodesAction(hierarchyViewer);

    showDescriptionsAction = ActionFactory.createAction("Show Descriptions", null,
        IAction.AS_CHECK_BOX, () -> {
          viewSettings.setShowObjectDescriptions(showDescriptionsAction.isChecked());
          getViewer().refresh();
        });
    showDescriptionsAction.setChecked(prefStore.getBoolean(
        IPreferences.CALL_HIERARCHY_SHOW_OBJECT_DESCRIPTIONS));

    openPreferencesAction = new OpenPreferencesAction(CallHierarchyPreferencesPage.PAGE_ID);
  }

  private void createHierarchySplitter(final Composite parent) {
    hierarchySplitter = new SashForm(parent, SWT.NONE);
  }

  private void createHierarchyViewer(final Composite parent) {
    if (viewSettings.getHierarchyViewerType() == HierarchyViewerType.TREE) {
      hierarchyViewer = new TreeViewer(parent, SWT.MULTI);
      hierarchyViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(
          new HierarchyTreeViewerLabelProvider(viewSettings)));
    } else {
      hierarchyViewer = new HierarchyTreeTableViewer(parent, viewSettings);
    }
    viewerContainer.layout(true);
  }

  private void createLocationViewer(final Composite parent) {
    locationViewer = new CallPositionViewer(parent);
    locationViewer.addOpenListener(e -> {
      IStructuredSelection sel = (IStructuredSelection) e.getSelection();
      if (sel == null || sel.isEmpty() || sel.size() != 1) {
        return;
      }

      Object selObj = sel.getFirstElement();
      if (selObj instanceof ICallPosition) {
        currentHierarchy.navigateToCallPosition((ICallPosition) selObj);
      }
    });
  }

  private void createViewerContainer(final Composite parent) {
    viewerContainer = new Composite(parent, SWT.NONE);
    viewerContainer.setLayout(new FillLayout());
  }

  private void fillContextMenu(final IMenuManager mgr) {
    createContextMenuGroups(mgr);
  }

  /**
   * Handles the open event on one or several tree nodes in the main tree viewer
   * of the CDS Analysis page
   *
   * @param treeNode the tree node to be handled
   */
  private void handleOpenOnNode(final Object treeNode) {
    if (treeNode == null) {
      return;
    }
    if (treeNode instanceof IAdtObjectReferenceNode) {
      final IAdtObjectReferenceNode selectedAdtObject = (IAdtObjectReferenceNode) treeNode;

      if (selectedAdtObject != null) {
        final IDestinationProvider destProvider = selectedAdtObject.getAdapter(
            IDestinationProvider.class);
        if (destProvider != null) {
          final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor
              .getProviderForDestination(destProvider.getDestinationId());
          projectProvider.openObjectReference(selectedAdtObject.getObjectReference());
        }
      }
    } else if (treeNode instanceof ICollectionTreeNode) {
      final boolean isExpanded = hierarchyViewer.getExpandedState(treeNode);
      if (isExpanded) {
        hierarchyViewer.collapseToLevel(treeNode, 1);
      } else {
        hierarchyViewer.expandToLevel(treeNode, 1);
      }
    }
  }

  private void initToolbar() {
    final IActionBars actionBars = getViewSite().getActionBars();
    final IToolBarManager tbm = actionBars.getToolBarManager();

    actionBars.setGlobalActionHandler(org.eclipse.ui.actions.ActionFactory.REFRESH.getId(),
        refreshAction);

    createToolBarGroups(tbm);
    tbm.appendToGroup(IGeneralMenuConstants.GROUP_ADDITIONS, pinViewAction);
    tbm.appendToGroup(IGeneralMenuConstants.GROUP_SEARCH, refreshAction);
    tbm.appendToGroup(IGeneralMenuConstants.GROUP_GOTO, historyDropDownAction);
    tbm.appendToGroup(IGeneralMenuConstants.GROUP_EDIT, collapseAllNodesAction);

    IMenuManager viewMenuMgr = actionBars.getMenuManager();
    createViewMenuGroups(viewMenuMgr);

    hierarchyViewerLayoutAction.contributeToMenuManager(viewMenuMgr);
    viewMenuMgr.add(new Separator());
    viewMenuMgr.add(showDescriptionsAction);
    viewMenuMgr.add(new Separator());
    viewMenuMgr.add(viewLayoutAction);
    viewMenuMgr.add(new Separator());
    viewMenuMgr.add(openPreferencesAction);
  }

  private void registerMenu() {
    menuMgr = new MenuManager("#PopUp");
    menuMgr.setRemoveAllWhenShown(true);
    menuMgr.setParent(getViewSite().getActionBars().getMenuManager());
    menuMgr.addMenuListener(mgr -> {
      fillContextMenu(mgr);
    });

    // Register menu
    getSite().registerContextMenu(getViewSite().getId(), menuMgr, viewerAdapter);
  }

  private void restoreViewState() {
    UIState savedState = viewStates.get(currentHierarchy);
    if (savedState != null) {
      TreePath[] savedPaths = savedState.getExpandedPaths();
      if (savedPaths != null) {
        hierarchyViewer.setExpandedTreePaths(savedPaths);
      }
      ISelection savedSelection = savedState.getSelection();
      if (savedSelection != null) {
        hierarchyViewer.setSelection(savedState.getSelection());
      }
    } else {
      hierarchyViewer.expandToLevel(2);
    }
  }

  private void saveCurrentViewState() {
    if (currentHierarchy == null) {
      return;
    }
    UIState currentUiState = new UIState();
    currentUiState.setExpandedPaths(hierarchyViewer.getExpandedTreePaths());
    currentUiState.setSelection(hierarchyViewer.getSelection());
    viewStates.put(currentHierarchy, currentUiState);
  }

  private void setInput() {
    hierarchyViewer.setInput(currentHierarchy.getResult());
    if (!currentHierarchy.isResultLoaded()) {
      currentHierarchy.addResultLoadedListener(l -> {
        PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
          setContentDescription(currentHierarchy.getLabel());
          // hierarchyViewer.expandAll();
        });
      });
      hierarchyViewer.expandAll();
    } else {
      restoreViewState();
    }
  }

  private void setupHierarchyViewer() {
    if (hierarchyViewer != null) {
      hierarchyViewer.setInput(null);
      hierarchyViewer.removeSelectionChangedListener(viewerAdapter);
      hierarchyViewer.getControl().dispose();
      hierarchyViewer = null;
    }
    createHierarchyViewer(viewerContainer);
    configureHierarchyViewer(viewerContainer);
  }

  private void showPage(final int page) {
    boolean isEmpty = page == PAGE_EMPTY;
    Control control = isEmpty ? (Control) noHierarchyShownLabel : hierarchySplitter;
    if (isEmpty) {
      setContentDescription(""); //$NON-NLS-1$
      setTitleToolTip(getPartName());
    } else if (currentHierarchy != null) {
      setContentDescription(currentHierarchy.getLabel());
    }
    pageBook.showPage(control);
    if (refreshAction != null) {
      refreshAction.setEnabled(!isEmpty);
    }
    if (historyDropDownAction != null) {
      historyDropDownAction.setEnabled(!isEmpty);
    }
    if (collapseAllNodesAction != null) {
      collapseAllNodesAction.setEnabled(!isEmpty);
    }
  }
}
