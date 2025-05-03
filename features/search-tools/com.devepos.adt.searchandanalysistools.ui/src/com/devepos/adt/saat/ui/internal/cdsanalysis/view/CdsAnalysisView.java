package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.LegacyActionTools;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IShowInSource;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;
import org.eclipse.ui.part.PageSwitcher;
import org.eclipse.ui.part.ShowInContext;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.ContextHelper;
import com.devepos.adt.base.ui.DummyPart;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IGeneralContextConstants;
import com.devepos.adt.base.ui.IGeneralMenuConstants;
import com.devepos.adt.base.ui.IPinnableView;
import com.devepos.adt.base.ui.action.CommandFactory;
import com.devepos.adt.base.ui.action.OpenPreferencesAction;
import com.devepos.adt.base.ui.action.PinViewAction;
import com.devepos.adt.base.ui.adtelementinfo.AdtElementInfoSelChangedListener;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.ui.internal.ICommandConstants;
import com.devepos.adt.saat.ui.internal.IContextMenuConstants;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.ViewUiState;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.help.HelpContextId;
import com.devepos.adt.saat.ui.internal.help.HelpUtil;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.preferences.IPreferences;
import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 * A view which is to be used to analyse a selected CDS view (either from the
 * project explorer view, or from the DB Object explorer view or even from an
 * open CDS view editor.<br>
 * <br>
 * The view provides the ability to navigate either from bottom to top, i.e.
 * analyze where the selected CDS view is used as a data selection source or
 * even as an Association source.<br>
 * The view also can be used to navigate from top to bottom, to see which
 * entities are used in the selection of the data.
 *
 * @author stockbal
 */
public class CdsAnalysisView extends PageBookView
    implements ICdsAnalysisListener, ICdsAnalysisResultListener, IPinnableView {

  public static final String VIEW_ID = "com.devepos.adt.saat.views.cdsanalyzer"; //$NON-NLS-1$
  private static final String VIEW_CONTEXT = "com.devepos.adt.saat.ui.cdsAnalysisView"; //$NON-NLS-1$
  private static final String MEMENTO_VIEW_NAME = "viewName"; //$NON-NLS-1$
  private static final String MEMENTO_CONFIGURED_ANALYSIS_TYPES = "configuredAnalysisTypes"; //$NON-NLS-1$

  private Composite pageContent;
  private Composite descriptionComposite;
  private final Map<DummyPart, CdsAnalysisPage<?>> partsToPages;
  final Map<CdsAnalysisPage<?>, DummyPart> pagesToParts;
  private final Map<CdsAnalysis, ViewUiState> viewStates;
  private CdsAnalysis currentAnalysis;
  private boolean isPinned;
  private IResourceChangeListener projectListener;
  private ContextHelper contextHelper;

  private CLabel description;
  private RefreshCurrentAnalysisAction refreshAnalysisAction;
  private CdsAnalysisHistoryDropDownAction analysesHistoryAction;
  private PinViewAction pinViewAction;
  private Action openPreferencesAction;
  private CdsAnalysisTypeConfigurationAction selectAnalysisModesAction;
  private Action newCdsAnalysisViewAction;
  private AdtElementInfoSelChangedListener elementInfoChangedListener;

  private DummyPart defaultPart;

  private final CdsAnalysisConfigRegistry configRegistry;
  private List<CdsAnalysisType> configuredAnalysisTypes;

  public CdsAnalysisView() {
    super();
    partsToPages = new HashMap<>();
    pagesToParts = new HashMap<>();
    viewStates = new HashMap<>();
    configRegistry = new CdsAnalysisConfigRegistry(this);
    SearchAndAnalysisPlugin.getDefault()
        .getPreferenceStore()
        .setDefault(IPreferences.MAX_CDS_ANALYZER_HISTORY, 10);
    isPinned = false;
    configuredAnalysisTypes = Arrays.asList(CdsAnalysisType.values());
    elementInfoChangedListener = new AdtElementInfoSelChangedListener();
  }

  /**
   * Action to run the currently entered search again
   *
   * @author stockbal
   */
  private class RefreshCurrentAnalysisAction extends Action {
    public RefreshCurrentAnalysisAction() {
      super(Messages.CdsAnalysis_RefreshAction_xtol,
          AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.REFRESH));
    }

    @Override
    public void runWithEvent(final Event event) {
      getActivePage().refreshAnalysis(event.keyCode == 0);
    }

    @Override
    public void run() {
      getActivePage().refreshAnalysis(true);
    }

  }

  private static class WelcomePage extends CdsAnalysisPage<CdsAnalysis> {
    private CdsAnalysisWelcomeText infoText;

    public WelcomePage() {
      super(null);
    }

    @Override
    public void createControl(final Composite parent) {
      infoText = new CdsAnalysisWelcomeText(parent);
    }

    @Override
    public Control getControl() {
      return infoText;
    }

    @Override
    public HelpContextId getHelpContextId() {
      return HelpContextId.CDS_ANALYZER;
    }

    @Override
    public void setFocus() {
      infoText.setFocus();
    }

    @Override
    protected void configureTreeViewer(final TreeViewer treeViewer) {
    }

    @Override
    protected ViewUiState getUiState() {
      return null;
    }

    @Override
    protected void loadInput(final ViewUiState uiState) {
    }

    @Override
    protected void refreshAnalysis(final boolean global) {
    }
  }

  public static void createContextMenuGroups(final IMenuManager mgr) {
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_NEW));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_OPEN));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_EDIT));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_FILTERING));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_NODE_ACTIONS));
    mgr.add(new Separator(IContextMenuConstants.GROUP_DB_BROWSER));
    mgr.add(new Separator(IContextMenuConstants.GROUP_CDS_ANALYSIS));
    mgr.add(new Separator(IGeneralMenuConstants.GROUP_ADDITIONS));
  }

  /**
   * Creates the groups and separators for the search view's tool bar
   *
   * @param toolbar the toolbar
   */
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
  public void analysisAdded(final CdsAnalysis analysis) {
    analysesHistoryAction.updateEnablement();
  }

  @Override
  public void analysisRemoved(final CdsAnalysis analysis) {
    if (analysis.equals(currentAnalysis)) {
      showCdsAnalysis(null);
      partActivated(defaultPart);
      updateHelp(null);
    }
    viewStates.remove(analysis);

    analysesHistoryAction.disposeMenu();
    updateViewActions();
  }

  @Override
  public void createPartControl(final Composite parent) {
    createActions();

    contextHelper = ContextHelper.createForServiceLocator(getSite());
    contextHelper.activateAbapContext();
    contextHelper.activateContext(VIEW_CONTEXT);
    contextHelper.activateContext(IGeneralContextConstants.ELEMENT_INFO);

    pageContent = new Composite(parent, SWT.NONE);
    final GridLayout layout = new GridLayout();
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    pageContent.setLayout(layout);

    descriptionComposite = null;

    super.createPartControl(pageContent);
    getPageBook().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    CdsAnalysisManager.getInstance().addCdsAnalysisListener(this);

    initializeToolBar();
    initializePageSwitcher();

    updateHelp(null);

    showLatestAnalysis();
  }

  @Override
  public void dispose() {
    CdsAnalysisManager.getInstance().removeCdsAnalysisListener(this);
    CdsAnalysisViewManager.getInstance().cdsAnalysisViewClosed(this);
    if (projectListener != null) {
      ResourcesPlugin.getWorkspace().removeResourceChangeListener(projectListener);
    }
    if (contextHelper != null) {
      contextHelper.deactivateAllContexts();
    }
    super.dispose();
  }

  public void setConfiguredAnalysisTypes(final List<CdsAnalysisType> selectedTypes) {
    configuredAnalysisTypes = selectedTypes;
  }

  public List<CdsAnalysisType> getConfiguredAnalysisTypes() {
    return configuredAnalysisTypes;
  }

  /**
   * Returns the active {@link CdsAnalysisPage}
   *
   * @return the active {@link CdsAnalysisPage}
   */
  public CdsAnalysisPage<?> getActivePage() {
    final IPage page = getCurrentPage();
    return page instanceof CdsAnalysisPage ? (CdsAnalysisPage<?>) page : null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getAdapter(final Class<T> adapter) {
    final Object superAdapter = super.getAdapter(adapter);
    if (superAdapter != null) {
      return (T) superAdapter;
    }
    if (adapter == IShowInSource.class) {
      return (T) (IShowInSource) () -> new ShowInContext(null,
          getSelectionProvider().getSelection());
    }
    return null;
  }

  /**
   * Returns the active analysis of the view
   *
   * @return
   */
  public CdsAnalysis getCurrentAnalysis() {
    return currentAnalysis;
  }

  @Override
  public void init(final IViewSite site) throws PartInitException {
    super.init(site);

    final IMenuManager menuManager = site.getActionBars().getMenuManager();
    createViewMenuGroups(menuManager);

    projectListener = event -> {
      if (event == null || getCurrentAnalysis() == null) {
        return;
      }

      if (event.getResource() instanceof IProject
          && (event.getType() == IResourceChangeEvent.PRE_CLOSE
              || event.getType() == IResourceChangeEvent.PRE_DELETE)
          && event.getResource() == getCurrentAnalysis().getProject()) {
        getViewSite().getShell().getDisplay().asyncExec(() -> {
          showCdsAnalysis(null);
          partActivated(defaultPart);
          updateHelp(null);
        });
      }
    };
    ResourcesPlugin.getWorkspace().addResourceChangeListener(projectListener);
  }

  @Override
  public boolean isPinned() {
    return isPinned;
  }

  @Override
  public void partActivated(final IWorkbenchPart part) {
    super.partActivated(part);
    if (part == this) {
      CdsAnalysisViewManager.getInstance().cdsAnalysisViewActivated(this);
    }
  }

  @Override
  public void setFocus() {
    final IPage page = getCurrentPage();
    if (page != null) {
      page.setFocus();
    } else {
      super.setFocus();
    }
  }

  @Override
  public void setPinned(final boolean pinned) {
    isPinned = pinned;
  }

  public void showCdsAnalysis(final CdsAnalysis analysis) {
    if (currentAnalysis == analysis) {
      return;
    }
    CdsAnalysisPage<?> analysisPage = null;
    if (analysis != null) {
      analysisPage = configRegistry.findPageForType(analysis.getType());
      if (analysisPage == null) {
        SearchAndAnalysisPlugin.getDefault()
            .getLog()
            .log(new Status(IStatus.ERROR, SearchAndAnalysisPlugin.PLUGIN_ID,
                "CDS Analysis page for analysis type " + analysis.getType() + //$NON-NLS-1$
                    " could not be created")); //$NON-NLS-1$
        return;
      }
    }
    internalShowCdsAnalysisPage(analysisPage, analysis);
  }

  @Override
  public void init(final IViewSite site, final IMemento memento) throws PartInitException {
    super.init(site, memento);
    if (memento != null) {
      var viewName = memento.getString(MEMENTO_VIEW_NAME);
      if (!StringUtil.isEmpty(viewName)) {
        setPartName(viewName);
      }

      var configuredTypes = memento.getChild(MEMENTO_CONFIGURED_ANALYSIS_TYPES);
      if (configuredTypes != null) {
        List<CdsAnalysisType> analysisTypesFromMemento = new ArrayList<>();
        for (var type : configuredTypes.getAttributeKeys()) {
          var analysisType = CdsAnalysisType.valueOf(type);
          if (analysisType != null) {
            analysisTypesFromMemento.add(analysisType);
          }
        }

        if (!analysisTypesFromMemento.isEmpty()) {
          configuredAnalysisTypes = analysisTypesFromMemento;
        }
      }
    }
  }

  @Override
  public void saveState(final IMemento memento) {
    memento.putString(MEMENTO_VIEW_NAME, getPartName());
    var configuredTypesMemento = memento.createChild(MEMENTO_CONFIGURED_ANALYSIS_TYPES);
    for (var type : configuredAnalysisTypes) {
      configuredTypesMemento.putBoolean(type.name(), true);
    }
  }

  public void setViewName(final String viewName) {
    setPartName(viewName);
  }

  /**
   * Updates the label of the current page
   */
  @Override
  public void updateLabel() {
    final CdsAnalysis analysis = getCurrentAnalysis();
    String label = ""; //$NON-NLS-1$
    if (analysis != null) {
      label = LegacyActionTools.escapeMnemonics(analysis.getLabel());
    }
    if (pageContent.isDisposed()) {
      return;
    }
    if (label.length() == 0) {
      if (descriptionComposite != null) {
        descriptionComposite.dispose();
        descriptionComposite = null;
        pageContent.layout();
      }
    } else {
      if (descriptionComposite == null) {
        descriptionComposite = new Composite(pageContent, SWT.NONE);
        descriptionComposite.moveAbove(null);

        GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(descriptionComposite);
        GridDataFactory.fillDefaults().grab(true, false).applyTo(descriptionComposite);

        description = new CLabel(descriptionComposite, SWT.LEAD | SWT.TOP | SWT.WRAP);
        GridDataFactory.fillDefaults()
            .align(SWT.FILL, SWT.CENTER)
            .grab(true, false)
            .applyTo(description);
        description.setText(label);

        final var separator = new Label(descriptionComposite, SWT.SEPARATOR | SWT.HORIZONTAL);
        GridDataFactory.fillDefaults().grab(true, false).applyTo(separator);
        pageContent.layout();
      } else {
        description.setText(label);
        pageContent.layout();
      }

      description.setImage(
          getActivePage().isFiltered() ? AdtBaseUIResources.getImage(IAdtBaseImages.FILTER) : null);
    }
  }

  @Override
  protected IPage createDefaultPage(final PageBook book) {
    final CdsAnalysisPage<?> page = new WelcomePage();
    initPage(page);
    page.createControl(book);
    final DummyPart part = new DummyPart(getSite());
    partsToPages.put(part, page);
    pagesToParts.put(page, part);
    defaultPart = part;

    return page;
  }

  @Override
  protected PageRec doCreatePage(final IWorkbenchPart part) {
    final IPageBookViewPage page = partsToPages.get(part);
    initPage(page);
    page.createControl(getPageBook());
    final PageRec rec = new PageRec(part, page);
    return rec;
  }

  @Override
  protected void doDestroyPage(final IWorkbenchPart part, final PageRec pageRecord) {
    final IPage page = pageRecord.page;
    page.dispose();
    pageRecord.dispose();
    // empty cross-reference cache
    partsToPages.remove(part);
  }

  @Override
  protected IWorkbenchPart getBootstrapPart() {
    return null;
  }

  @Override
  protected void initPage(final IPageBookViewPage page) {
    super.initPage(page);
    final IActionBars actionBars = page.getSite().getActionBars();
    actionBars.setGlobalActionHandler(ActionFactory.REFRESH.getId(), refreshAnalysisAction);
    updateViewActions();
    actionBars.updateActionBars();
  }

  @Override
  protected boolean isImportant(final IWorkbenchPart part) {
    return part instanceof DummyPart;
  }

  void updateViewActions() {
    analysesHistoryAction.updateEnablement();
    refreshAnalysisAction.setEnabled(currentAnalysis != null);
  }

  private void createActions() {
    // create search functions like refresh, history dropdown, etc.
    refreshAnalysisAction = new RefreshCurrentAnalysisAction();
    refreshAnalysisAction.setEnabled(false);
    refreshAnalysisAction.setActionDefinitionId(IWorkbenchCommandConstants.FILE_REFRESH);

    analysesHistoryAction = new CdsAnalysisHistoryDropDownAction(this);
    analysesHistoryAction.updateEnablement();
    pinViewAction = new PinViewAction(this);
    openPreferencesAction = new OpenPreferencesAction(IPreferences.CDS_ANALYSIS_PREF_PAGE_ID);
    selectAnalysisModesAction = new CdsAnalysisTypeConfigurationAction(this);
    newCdsAnalysisViewAction = com.devepos.adt.base.ui.action.ActionFactory.createAction(
        Messages.CdsAnalysisView_NewCdsAnalyzerAction_xlbl,
        SearchAndAnalysisPlugin.getDefault().getImageDescriptor(IImages.NEW_CDS_ANALYSIS_VIEW),
        () -> CdsAnalysisViewManager.getInstance().showNewCdsAnalysisView());
  }

  private void initializePageSwitcher() {
    new PageSwitcher(this) {
      @Override
      public void activatePage(final Object page) {
        final CdsAnalysis analysis = (CdsAnalysis) page;
        CdsAnalysisManager.getInstance().activated(analysis);
        showCdsAnalysis(analysis);
      }

      @Override
      public ImageDescriptor getImageDescriptor(final Object page) {
        final CdsAnalysis analysis = (CdsAnalysis) page;
        return analysis.getImageDescriptor();
      }

      @Override
      public String getName(final Object page) {
        final CdsAnalysis analysis = (CdsAnalysis) page;
        return analysis.getLabel();
      }

      @Override
      public Object[] getPages() {
        return CdsAnalysisManager.getInstance().getAnalyses();
      }
    };

  }

  /*
   * initializes the Part toolbar
   */
  private void initializeToolBar() {
    final IActionBars actionBars = getViewSite().getActionBars();
    final IToolBarManager tbm = actionBars.getToolBarManager();
    createToolBarGroups(tbm);
    tbm.appendToGroup(IGeneralMenuConstants.GROUP_NEW,
        CommandFactory.createContribItem(ICommandConstants.RUN_CDS_ANALYSIS,
            SearchAndAnalysisPlugin.getDefault().getImageDescriptor(IImages.RUN_NEW_ANALYSIS), null,
            null));
    tbm.appendToGroup(IGeneralMenuConstants.GROUP_EDIT, selectAnalysisModesAction);
    tbm.appendToGroup(IGeneralMenuConstants.GROUP_SEARCH, refreshAnalysisAction);
    tbm.appendToGroup(IGeneralMenuConstants.GROUP_GOTO, analysesHistoryAction);
    tbm.appendToGroup(IGeneralMenuConstants.GROUP_ADDITIONS, pinViewAction);

    IMenuManager viewMenuMgr = actionBars.getMenuManager();
    createViewMenuGroups(viewMenuMgr);
    viewMenuMgr.add(new Separator());
    viewMenuMgr.add(newCdsAnalysisViewAction);
    viewMenuMgr.add(
        CommandFactory.createContribItem(ICommandConstants.RENAME_CDS_ANALYSIS, null, null, null));
    viewMenuMgr.add(new Separator());
    viewMenuMgr.add(openPreferencesAction);
  }

  private void internalShowCdsAnalysisPage(final CdsAnalysisPage<?> page,
      final CdsAnalysis analysisInput) {
    // detach the previous page.
    final CdsAnalysisPage<?> currentPage = getActivePage();
    if (currentAnalysis != null && currentPage != null) {
      viewStates.put(currentAnalysis, currentPage.getUiState());
      currentPage.removeElementInfoChangeListener(elementInfoChangedListener);
      currentPage.setInput(null, null);
    }

    currentAnalysis = analysisInput;
    selectAnalysisModesAction.setCurrentAnalysis(analysisInput);

    if (page != null) {
      if (page != currentPage) {
        DummyPart part = pagesToParts.get(page);
        if (part == null) {
          part = new DummyPart(getSite());
          pagesToParts.put(page, part);
          partsToPages.put(part, page);
        }
        // part.setLastActivation(++fActivationCount);
        partActivated(part);
        page.setFocus();
        updateHelp(page);
      }

      // connect to the new pages
      final ViewUiState uiState = analysisInput != null ? viewStates.get(analysisInput) : null;
      page.setInput(analysisInput, uiState);
      page.addElementInfoChangeListener(elementInfoChangedListener);
    }
    updateViewActions();
    updateLabel();
  }

  private void showLatestAnalysis() {
    if (!CdsAnalysisManager.getInstance().hasAnalyses()) {
      return;
    }
    final CdsAnalysis[] analyses = CdsAnalysisManager.getInstance().getAnalyses();
    var latestAnalysis = analyses[0];
    if (!CdsAnalysisViewManager.getInstance().isAnalysisShown(latestAnalysis)) {
      showCdsAnalysis(latestAnalysis);
    }
  }

  private void updateHelp(final CdsAnalysisPage<?> page) {
    HelpUtil.setHelp(pageContent,
        page == null ? HelpContextId.CDS_ANALYZER : page.getHelpContextId());
  }
}
