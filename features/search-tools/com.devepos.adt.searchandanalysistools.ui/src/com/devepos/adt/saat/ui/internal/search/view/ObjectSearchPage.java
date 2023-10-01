package com.devepos.adt.saat.ui.internal.search.view;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.project.AbapProjectProxy;
import com.devepos.adt.base.ui.project.ProjectInput;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.search.IChangeableSearchPage;
import com.devepos.adt.base.ui.search.SearchPageUtil;
import com.devepos.adt.base.ui.util.SelectionUtil;
import com.devepos.adt.base.ui.util.StatusUtil;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig;
import com.devepos.adt.saat.search.IObjectSearchService;
import com.devepos.adt.saat.search.ObjectSearchServiceFactory;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.help.HelpContexts;
import com.devepos.adt.saat.ui.internal.help.HelpUtil;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.preferences.IPreferences;
import com.devepos.adt.saat.ui.internal.preferences.InitialSearchFocus;
import com.sap.adt.communication.content.ContentHandlerException;

/**
 * Describes the Page in the Search Dialog for the extended ABAP Object Search
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class ObjectSearchPage extends DialogPage implements ISearchPage, ISearchPageStatusUpdater,
    IPageLayoutUpdater, IChangeableSearchPage<ObjectSearchQuery> {
  public static final String LAST_PROJECT_PREF = "com.devepos.adt.saat.objectsearch.lastSelectedProject"; //$NON-NLS-1$
  public static final String PAGE_ID = "com.devepos.adt.saat.ObjectSearchPage"; //$NON-NLS-1$

  private static final int MULTIPLIER = 50;
  private static final int BIG_MULTIPLIER = 500;
  private static final int SMALL_SCALE_LIMIT = 10;
  private static final int MAX_SCALE = 29;
  private static final int MIN_SCALE = 1;
  private static final int SMALL_SCALE_UPPER_BOUND = MULTIPLIER * SMALL_SCALE_LIMIT;

  public static final int MAX_RESULTS_UPPER_BOUND = SMALL_SCALE_UPPER_BOUND + (MAX_SCALE
      - SMALL_SCALE_LIMIT) * BIG_MULTIPLIER;

  private final Map<String, IStatus> allValidationStatuses;
  private ISearchPageContainer pageContainer;

  private final IPreferenceStore prefStore;
  private Composite mainComposite;
  private Composite statusArea;
  private Label searchStatusImageLabel;
  private Label searchStatusTextLabel;
  private Label maxResultsLabel;
  private int maxResults;

  private TableViewer searchTypeViewer;
  private ProjectInput projectInput;
  private Scale maxResultsScale;
  private Button andOptionCheck;
  private ObjectSearchFields searchFields;

  private final IAbapProjectProvider projectProvider;
  private final ObjectSearchRequest searchRequest;
  private ObjectSearchQuery previousQuery;
  private final IObjectSearchService searchService;
  private Composite searchFieldComposite;
  private Composite customOptionContainer;

  public ObjectSearchPage() {
    prefStore = SearchAndAnalysisPlugin.getDefault().getPreferenceStore();
    prefStore.setDefault(LAST_PROJECT_PREF, ""); //$NON-NLS-1$
    projectProvider = new AbapProjectProxy(null);
    searchRequest = new ObjectSearchRequest();
    searchRequest.setProjectProvider(projectProvider);
    searchRequest.setReadApiState(true);
    searchService = ObjectSearchServiceFactory.getSearchService();

    allValidationStatuses = new HashMap<>();
    allValidationStatuses.put(ObjectSearchDialogValidationSource.PROJECT.name(), Status.OK_STATUS);
  }

  @Override
  public void addStatusSource(final String source) {
    allValidationStatuses.put(source, Status.OK_STATUS);
  }

  @Override
  public void createControl(final Composite parent) {
    initializeDialogUnits(parent);
    mainComposite = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(mainComposite);
    GridLayoutFactory.swtDefaults()
        .spacing(10, 5)
        .equalWidth(false)
        .numColumns(2)
        .applyTo(mainComposite);
    setControl(mainComposite);

    HelpUtil.setHelp(mainComposite, HelpContexts.OBJECT_SEARCH_DIALOG);

    createSearchTypeInput(mainComposite);

    var searchFieldsGroup = new Group(mainComposite, SWT.NONE);
    searchFieldsGroup.setText(Messages.ObjectSearchPage_queryInputGroup_xtit);
    searchFieldComposite = searchFieldsGroup;
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(searchFieldComposite);
    GridDataFactory.fillDefaults()
        .grab(true, false)
        .hint(500, SWT.DEFAULT)
        .applyTo(searchFieldComposite);

    var customOptions = new Group(mainComposite, SWT.NONE);
    customOptions.setText(Messages.ObjectSearchPage_queryOptionsGroup_xtit);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(customOptions);
    GridLayoutFactory.swtDefaults().numColumns(3).equalWidth(false).applyTo(customOptions);

    customOptionContainer = new Composite(customOptions, SWT.NONE);
    GridDataFactory.fillDefaults().span(3, 1).grab(true, false).applyTo(customOptionContainer);
    GridLayoutFactory.swtDefaults().margins(0, 0).applyTo(customOptionContainer);

    searchFields = new ObjectSearchFields(searchFieldComposite, customOptionContainer,
        projectProvider, this, this);

    createAndOptionCheckbox(customOptions);
    createMaxResultsScale(customOptions);

    createSeparator(mainComposite);
    createProjectInput(mainComposite);
    createStatusArea(parent);

    setInitialData();
    updateOKStatus();

    setFocus();
    SearchPageUtil.notifySearchPageListeners(this);
  }

  @Override
  public void dispose() {
    super.dispose();
  }

  @Override
  public boolean performAction() {
    ISearchResultViewPart activeSearchView = null;
    // save current project in preferences
    prefStore.putValue(LAST_PROJECT_PREF, projectProvider.getProjectName());
    var queryInput = searchRequest.getQueryInput();
    queryInput.getFields().clear();
    queryInput.getFields().addAll(searchFields.toSearchQueryFields());
    queryInput.getCustomOptions().putAll(searchFields.getCustomOptions());

    final ISearchTypeConfig selectedSearchType = (ISearchTypeConfig) searchTypeViewer
        .getStructuredSelection()
        .getFirstElement();

    if (prefStore.getBoolean(IPreferences.REMEMBER_LAST_SEARCH_TYPE)) {
      prefStore.putValue(IPreferences.LAST_SEARCH_TYPE_ID, selectedSearchType.getName());
    }

    queryInput.setType(selectedSearchType.getName());
    queryInput.setTypeLabel(selectedSearchType.getLabel());
    searchRequest.setOutputConfig(selectedSearchType.getOutputConfig());

    ObjectSearchQuery query = null;
    if (previousQuery != null) {
      query = previousQuery;
      query.setSearchRequest(searchRequest);
      activeSearchView = NewSearchUI.getSearchResultView();
    } else {
      query = new ObjectSearchQuery(searchRequest);
    }

    NewSearchUI.runQueryInBackground(query, activeSearchView);

    return true;
  }

  @Override
  public void removeStatusSource(final String source) {
    allValidationStatuses.remove(source);
  }

  @Override
  public void setContainer(final ISearchPageContainer container) {
    pageContainer = container;
  }

  /**
   * Sets focus to first input field
   */
  public void setFocusToFirstInput() {
    if (searchFields != null) {
      searchFields.setFocus();
    }
  }

  /**
   * Sets control input from the given {@link ObjectSearchRequest}
   *
   * @param request the Object Search Request to be used
   */
  @Override
  public void setInputFromSearchQuery(final ObjectSearchQuery query) {
    final ObjectSearchRequest request = query.getSearchRequest();
    final boolean doSetCursorToEnd = prefStore.getBoolean(
        IPreferences.CURSOR_AT_END_OF_SEARCH_INPUT);
    final IAbapProjectProvider projectProvider = request.getProjectProvider();
    if (projectProvider != null && projectProvider.hasProject()) {
      projectInput.setProjectName(projectProvider.getProjectName());
    }
    updateSearchTypeViewer(request.getSearchType());
    updateMaxResultsScaleFromNumber(request.getMaxResults());
    andOptionCheck.setSelection(request.isAndSearchActive());
    searchRequest.setAndSearchActive(request.isAndSearchActive());
    updateMaxResults();

    searchFields.fillInputFromQueryFields(request.getQueryInput().getFields());
    searchFields.fillCustomOptionFromQuery(request.getQueryInput().getCustomOptions());
    searchFields.setSelection(doSetCursorToEnd);
    searchFields.setFocus();

    // use previous query if overwrite preference is true
    if (prefStore.getBoolean(IPreferences.OVERWRITE_OPENED_SEARCH_QUERY)) {
      previousQuery = query;
    }
  }

  /**
   * Sets the search type drop down to the given search type
   *
   * @param typeName the search type to be selected in the dialog
   */
  public void setSearchType(final String typeName) {
    if (searchTypeViewer == null || searchTypeViewer.getControl().isDisposed()) {
      return;
    }

    updateSearchTypeViewer(typeName);
  }

  @Override
  public void setVisible(final boolean visible) {
    super.setVisible(visible);
    updateOKStatus();
  }

  @Override
  public void updateOKStatus() {
    Display.getDefault().asyncExec(() -> {
      if (getControl().isDisposed()) {
        return;
      }
      boolean isError = allValidationStatuses.values()
          .stream()
          .anyMatch(s -> s.getSeverity() == IStatus.ERROR);
      pageContainer.setPerformActionEnabled(isValidSearchData() && !isError);
    });
  }

  @Override
  public void updatePageLayout() {
    Display.getDefault().asyncExec(() -> {
      mainComposite.getParent().layout(true, true);
      getShell().pack(true);
    });
  }

  @Override
  public boolean validateAndSetStatus(final IStatus status, final String source) {
    final IStatus validatedStatus = updateStatus(status, source);
    if (validatedStatus.getSeverity() == IStatus.OK) {
      Optional<IStatus> lastErrorStatus = allValidationStatuses.entrySet()
          .stream()
          .filter(entry -> entry.getKey() != source && entry.getValue()
              .getSeverity() == IStatus.ERROR)
          .map(Entry::getValue)
          .findFirst();
      setStatus(lastErrorStatus.orElse(Status.OK_STATUS));
    } else {
      setStatus(validatedStatus);
    }
    return validatedStatus == null || validatedStatus.isOK();
  }

  private void calculateMaxResultsByScale(final int selectedScale) {
    if (selectedScale >= SMALL_SCALE_LIMIT) {
      maxResults = SMALL_SCALE_UPPER_BOUND;
      maxResults += (selectedScale - SMALL_SCALE_LIMIT) * BIG_MULTIPLIER;
    } else {
      maxResults = selectedScale * MULTIPLIER;
    }
  }

  private void createAndOptionCheckbox(final Composite parent) {
    andOptionCheck = new Button(parent, SWT.CHECK);
    andOptionCheck.setText(Messages.ObjectSearch_UseAndFilter_xtol);
    GridDataFactory.fillDefaults()
        .grab(true, false)
        .align(SWT.FILL, SWT.CENTER)
        .span(3, 1)
        .applyTo(andOptionCheck);
    andOptionCheck.setToolTipText(Messages.ObjectSearchPage_UseAndFilter_xtol);

    andOptionCheck.addSelectionListener(widgetSelectedAdapter(l -> searchRequest.setAndSearchActive(
        andOptionCheck.getSelection())));
  }

  private void createMaxResultsScale(final Composite parent) {
    final Label maxResultsLabel = new Label(parent, SWT.NONE);
    maxResultsLabel.setText(Messages.ObjectSearch_MaxNumberOfResultsScale_xfld);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(maxResultsLabel);

    maxResultsScale = new Scale(parent, SWT.HORIZONTAL);
    maxResultsScale.setIncrement(1);
    maxResultsScale.setMinimum(MIN_SCALE);
    maxResultsScale.setMaximum(MAX_SCALE);
    maxResultsScale.addSelectionListener(widgetSelectedAdapter(l -> {
      calculateMaxResultsByScale(maxResultsScale.getSelection());
      updateMaxResults();

    }));
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.CENTER)
        .grab(true, false)
        .applyTo(maxResultsScale);

    this.maxResultsLabel = new Label(parent, SWT.NONE);
    GridDataFactory.fillDefaults()
        .align(SWT.LEAD, SWT.CENTER)
        .hint(convertHorizontalDLUsToPixels(50), SWT.DEFAULT)
        .applyTo(this.maxResultsLabel);
  }

  private void createProjectInput(final Composite parent) {
    projectInput = new ProjectInput(projectProvider, true);

    projectInput.setUseDedicatedComposite(true);
    projectInput.createControl(parent);

    projectInput.addProjectValidator(project -> searchService.testObjectSearchFeatureAvailability(
        project));
    projectInput.addStatusChangeListener(status -> {
      validateAndSetStatus(status, ObjectSearchDialogValidationSource.PROJECT.name());
      updateSearchTypeViewer(null);
      updateOKStatus();
    });

  }

  private void createSearchTypeInput(final Composite parent) {
    var typeGroup = new Group(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(false, true).span(1, 2).applyTo(typeGroup);
    GridLayoutFactory.swtDefaults().applyTo(typeGroup);
    typeGroup.setText(Messages.ObjectSearch_SearchTypeInput_xfld);

    searchTypeViewer = new TableViewer(typeGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(searchTypeViewer.getControl());
    searchTypeViewer.setContentProvider(ArrayContentProvider.getInstance());
    searchTypeViewer.setLabelProvider(new LabelProvider() {
      @Override
      public String getText(final Object element) {
        if (element instanceof ISearchTypeConfig) {
          return ((ISearchTypeConfig) element).getLabel();
        }
        return super.getText(element);
      }

      @Override
      public Image getImage(Object element) {
        if (element instanceof ISearchTypeConfig) {
          return SearchAndAnalysisPlugin.getDefault()
              .getSearchTypeImage(((ISearchTypeConfig) element));
        }
        return null;
      }

    });

    setTypeViewerNoProjectInput();

    searchTypeViewer.addSelectionChangedListener(event -> {
      if (event.getSelection().isEmpty()) {
        return;
      }
      var projectStatus = allValidationStatuses.get(ObjectSearchDialogValidationSource.PROJECT
          .name());

      if (projectStatus.isOK() && !(searchTypeViewer.getInput() instanceof String)) {
        final ISearchTypeConfig selectedSearchType = (ISearchTypeConfig) event
            .getStructuredSelection()
            .getFirstElement();
        searchRequest.setSearchType(selectedSearchType.getName());
        searchFields.updateControls(selectedSearchType);

      }
    });
  }

  private void createSeparator(final Composite parent) {
    final Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
    separator.setVisible(true);
    GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(separator);
  }

  private void createStatusArea(final Composite parent) {
    statusArea = new Composite(parent, SWT.NONE);

    GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(statusArea);
    GridLayoutFactory.fillDefaults().numColumns(2).applyTo(statusArea);

    searchStatusImageLabel = new Label(statusArea, SWT.NONE);
    GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.CENTER).applyTo(searchStatusImageLabel);

    searchStatusTextLabel = new Label(statusArea, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(searchStatusTextLabel);
  }

  private boolean isValidSearchData() {
    if (searchFields == null || !searchFields.hasInput() || !projectProvider.hasProject()) {
      return false;
    }

    return true;
  }

  private void setFocus() {
    var initialFocus = prefStore.getString(IPreferences.INITIAL_CONTROL_FOCUS);

    if (InitialSearchFocus.TYPE_VIEWER.getPrefKey().equals(initialFocus)) {
      if (searchTypeViewer != null && !searchTypeViewer.getControl().isDisposed()) {
        searchTypeViewer.getControl().setFocus();
      }
    } else {
      setFocusToFirstInput();
    }

  }

  private void setInitialData() {
    // set the project
    setInitialProject();

    // set initial max result values
    updateMaxResultsScaleFromNumber(prefStore.getInt(IPreferences.MAX_SEARCH_RESULTS));
    updateMaxResults();

    if (prefStore.getBoolean(IPreferences.TAKE_TEXT_SELECTION_INTO_SEARCH)) {
      final ISelection selection = SelectionUtil.getSelection();
      if (selection instanceof ITextSelection) {
        final String selectedText = ((ITextSelection) selection).getText();
        searchFields.setTextInFirstInput(selectedText);
      }
    }

    searchFields.initialize();
  }

  private void setInitialProject() {
    String projectName = null;

    final IProject currentAbapProject = ProjectUtil.getCurrentAbapProject();
    if (currentAbapProject != null) {
      projectName = currentAbapProject.getName();
    }
    if (projectName == null || projectName.isEmpty()) {
      projectName = prefStore.getString(LAST_PROJECT_PREF);
    }

    projectInput.setProjectName(projectName == null ? "" : projectName); //$NON-NLS-1$
    if (projectName == null || projectName.isEmpty()) {
      prefStore.setToDefault(LAST_PROJECT_PREF);
    }
  }

  private void setStatus(final IStatus status) {
    Display.getDefault().asyncExec(() -> {
      if (mainComposite.isDisposed() || searchStatusImageLabel == null
          || searchStatusTextLabel == null) {
        return;
      }
      if (status.getSeverity() == IStatus.OK || StringUtil.isEmpty(status.getMessage())) {
        searchStatusImageLabel.setImage(null);
        searchStatusTextLabel.setText(""); //$NON-NLS-1$
      } else {
        // searchFieldComposite.layout(true);
        searchStatusImageLabel.setImage(StatusUtil.getImageForStatus(status.getSeverity()));
        searchStatusTextLabel.setText(status.getMessage());
        searchStatusTextLabel.setToolTipText(status.getMessage());
        searchStatusTextLabel.pack(true);
        searchStatusTextLabel.getParent().layout(true);
        getShell().pack(true);
      }
    });
  }

  private void setTypeViewerNoProjectInput() {
    searchTypeViewer.setInput(new String[] { Messages.ObjectSearchPage_noProjectInput_xmsg });
    searchTypeViewer.setSelection(new StructuredSelection(((String[]) searchTypeViewer
        .getInput())[0]));
  }

  private void updateMaxResults() {
    searchRequest.setReadAllEntries(false);
    searchRequest.setMaxResults(maxResults);
    maxResultsLabel.setText(NLS.bind(Messages.ObjectSearch_FoundResultsLabel_xmsg, maxResults));
  }

  private void updateMaxResultsScaleFromNumber(final int maxResults) {
    if (maxResults > 0) {
      if (maxResults >= MAX_RESULTS_UPPER_BOUND) {
        this.maxResults = MAX_RESULTS_UPPER_BOUND;
        maxResultsScale.setSelection(MAX_SCALE);
      } else if (maxResults >= SMALL_SCALE_UPPER_BOUND && maxResults < MAX_RESULTS_UPPER_BOUND) {
        maxResultsScale.setSelection(SMALL_SCALE_LIMIT + (maxResults - SMALL_SCALE_UPPER_BOUND)
            / BIG_MULTIPLIER);
        this.maxResults = maxResults;
      } else {
        int maxResultScalePref = maxResults / MULTIPLIER;
        if (maxResultScalePref > MAX_SCALE) {
          maxResultScalePref = MAX_SCALE;
        }
        maxResultsScale.setSelection(maxResultScalePref);
        this.maxResults = maxResults;
      }
    } else {
      maxResultsScale.setSelection(1);
      this.maxResults = 1 * MULTIPLIER;
    }
  }

  /*
   * Updates the input/selection of the search type viewer Combo Box according to the current
   * project
   */
  private void updateSearchTypeViewer(String selectedTypeName) {
    if (projectProvider.hasProject()) {
      try {
        var searchConfig = searchService.getSearchConfig(projectProvider.getDestinationId());
        var typesOfProject = searchConfig.getSearchTypes();

        if (selectedTypeName == null) {
          var typeViewerInput = searchTypeViewer.getInput();
          if (typeViewerInput != null && !(typeViewerInput instanceof String[])) {
            selectedTypeName = ((ISearchTypeConfig) searchTypeViewer.getStructuredSelection()
                .getFirstElement()).getName();
          }
        }

        searchTypeViewer.setInput(typesOfProject);

        if (selectedTypeName != null) {
          final var typeNameToFind = selectedTypeName;
          var typeInInput = typesOfProject.stream()
              .filter(t -> t.getName().equals(typeNameToFind))
              .findFirst();
          if (typeInInput.isPresent()) {
            searchTypeViewer.setSelection(new StructuredSelection(typeInInput.get()));
          }
        } else if (prefStore.getBoolean(IPreferences.REMEMBER_LAST_SEARCH_TYPE)) {
          // set initial type according to preferences or use first in list
          final String lastChosenTypeId = prefStore.getString(IPreferences.LAST_SEARCH_TYPE_ID);
          if (lastChosenTypeId != null) {
            var defaultTypeConfig = typesOfProject.stream()
                .filter(t -> t.getName().equals(lastChosenTypeId))
                .findFirst()
                .orElse(typesOfProject.get(0));
            searchTypeViewer.setSelection(new StructuredSelection(defaultTypeConfig));
          }
        } else {
          searchTypeViewer.setSelection(new StructuredSelection(typesOfProject.get(0)));
        }
      } catch (ContentHandlerException exc) {
        // set generic content error status so user get's an idea on what needs to be done
        validateAndSetStatus(new Status(IStatus.ERROR, SearchAndAnalysisPlugin.PLUGIN_ID,
            MessageFormat.format(Messages.ObjectSearchPage_searchTypeConfigSerializationError_xmsg,
                projectProvider.getProjectName())), ObjectSearchDialogValidationSource.SEARCH_TYPE
                    .name());
        // logs actual content issue
        SearchAndAnalysisPlugin.getDefault()
            .getLog()
            .log(new Status(IStatus.ERROR, SearchAndAnalysisPlugin.PLUGIN_ID, exc.getMessage(),
                exc));
      }
    } else {
      setTypeViewerNoProjectInput();
    }

  }

  private IStatus updateStatus(final IStatus status, final String source) {
    final IStatus validatedStatus = status == null ? Status.OK_STATUS : status;
    allValidationStatuses.put(source, validatedStatus);
    return validatedStatus;
  }

}