package com.devepos.adt.cst.ui.internal.codesearch;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.project.AbapProjectProxy;
import com.devepos.adt.base.ui.project.ProjectInput;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.search.IChangeableSearchPage;
import com.devepos.adt.base.ui.search.SearchFilterHandler;
import com.devepos.adt.base.ui.search.SearchPageUtil;
import com.devepos.adt.base.ui.search.ext.ISearchPageParameterSection;
import com.devepos.adt.base.ui.search.ext.SearchPageExtensionsRegistry;
import com.devepos.adt.base.ui.util.StatusUtil;
import com.devepos.adt.base.ui.util.TextControlUtil;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.help.HelpContexts;
import com.devepos.adt.cst.ui.internal.help.HelpUtil;
import com.devepos.adt.cst.ui.internal.messages.Messages;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;
import com.sap.adt.util.ui.swt.AdtSWTUtilFactory;

public class CodeSearchDialog extends DialogPage
    implements ISearchPage, IChangeableSearchPage<CodeSearchQuery> {
  public static final String PAGE_ID = "com.devepos.adt.codesearch.ui.searchpage.codeSearch"; //$NON-NLS-1$

  private static final String LAST_PROJECT_PREF = "lastProject"; //$NON-NLS-1$
  private static final String FUGR_INCLUDES_BITS = "functionGroup.includeBits";
  private static final String FUGR_INCLUDES_ALL_ENABLED = "functionGroup.includes.allEnabled";
  private static final String CLASS_INCLUDES_BITS = "class.includeBits";
  private static final String CLASS_INCLUDES_ALL_ENABLED = "class.includes.allEnabled";
  private static final String PROGRAM_INCLUDES_EXPAND_ENABLED = "program.includes.expandEnabled";
  private static final String TABLE_INCLUDES_EXPAND_ENABLED = "table.includes.expandEnabled";

  private final Map<ValidationSource, IStatus> allValidationStatuses;
  private ISearchPageContainer container;
  private SearchFilterHandler filterHandler;

  private Composite mainComposite;
  private Composite statusArea;
  private Label searchStatusImageLabel;
  private Label searchStatusTextLabel;
  private List<ISearchPageParameterSection> extensionParamSections;

  private Button ignoreCaseCheck;
  private Button multilineSearchOption;
  private Button singlePattern;
  private Button useRegExpCheck;
  private Button matchAllPatterns;
  private Button ignoreCommentLinesCheck;
  private Button sequentialMatchingCheck;
  private Button expandProgIncludesButton;
  private Button expandTablIncludesButton;
  private IncludeFlagsRadioButtonGroup classIncludeConfigGroup;
  private IncludeFlagsRadioButtonGroup fugrIncludeConfigGroup;

  private Text patternsText;
  private Text objectNameInput;
  private Text filterInput;
  private ProjectInput projectInput;

  private final IAbapProjectProvider projectProvider;
  private final CodeSearchQuerySpecification querySpecs;

  private IDialogSettings dialogSettings;

  public CodeSearchDialog() {
    projectProvider = new AbapProjectProxy(null);
    querySpecs = new CodeSearchQuerySpecification();
    querySpecs.setProjectProvider(projectProvider);

    allValidationStatuses = new HashMap<>();
    for (ValidationSource s : ValidationSource.values()) {
      allValidationStatuses.put(s, Status.OK_STATUS);
    }
  }

  private enum ValidationSource {
    FILTERS,
    PROJECT,
    SEARCH_PATTERN,
    SEARCH_PATTERN_BACKEND;
  }

  @Override
  public void createControl(final Composite parent) {
    initializeDialogUnits(parent);
    readDialogSettings();

    mainComposite = new Composite(parent, SWT.NONE);
    HelpUtil.setHelp(mainComposite, HelpContexts.CODE_SEARCH_DIALOG);

    GridLayoutFactory.swtDefaults().applyTo(mainComposite);
    setControl(mainComposite);

    createPatternsGroup(mainComposite);

    // create middle composite
    var middle = new Composite(mainComposite, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(middle);
    GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(2).applyTo(middle);

    createObjectScopeGroup(middle);
    createAdditionalSettingsGroup(middle);

    var customTypeOptions = new Composite(mainComposite, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(customTypeOptions);
    GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(4).applyTo(customTypeOptions);
    createTypeSpecificSettingGroups(customTypeOptions);

    createProjectInput(mainComposite);
    createStatusArea(mainComposite);
    registerContentAssist();

    setInitialData();
    updateOKStatus();

    if (patternsText != null && !patternsText.isDisposed()) {
      patternsText.setFocus();
    }

    SearchPageUtil.notifySearchPageListeners(this);
  }

  @Override
  public void dispose() {
    super.dispose();
  }

  @Override
  public boolean performAction() {
    collectQuerySpecs();

    var patternValidationStatus = runPatternValidationRequest();
    if (!patternValidationStatus.isOK()) {
      validateAndSetStatus(patternValidationStatus, ValidationSource.SEARCH_PATTERN_BACKEND);
      return false;
    }
    writeDialogSettings();

    NewSearchUI.runQueryInBackground(new CodeSearchQuery(querySpecs));
    return true;
  }

  @Override
  public void setContainer(final ISearchPageContainer container) {
    this.container = container;
  }

  @Override
  public void setInputFromSearchQuery(final CodeSearchQuery query) {
    var querySpecs = query.getQuerySpecs();
    final String searchTerm = querySpecs.getPatterns();
    patternsText.setText(searchTerm);

    final var projectProvider = querySpecs.getProjectProvider();
    if (projectProvider != null && projectProvider.hasProject()) {
      projectInput.setProjectName(projectProvider.getProjectName());
    }
    objectNameInput.setText(querySpecs.getObjectNames());
    filterInput.setText(querySpecs.getObjectScopeFiltersString());

    matchAllPatterns.setSelection(querySpecs.isMatchAllPatterns());
    useRegExpCheck.setSelection(querySpecs.isUseRegExp());
    singlePattern.setSelection(querySpecs.isSinglePattern());
    multilineSearchOption.setSelection(querySpecs.isMultilineSearchOption());
    ignoreCommentLinesCheck.setSelection(querySpecs.isIgnoreCommentLines());
    ignoreCaseCheck.setSelection(querySpecs.isIgnoreCaseCheck());
    sequentialMatchingCheck.setSelection(querySpecs.isSequentialMatching());

    updateOptionEnabledment();

    var classIncludesParamCurrent = this.querySpecs.getClassIncludesParam();
    var classIncludesParamOld = querySpecs.getClassIncludesParam();
    classIncludesParamCurrent.setAllIncludes(classIncludesParamOld.isAllIncludes());
    classIncludesParamCurrent.setIncludeFlags(classIncludesParamOld.getIncludeFlags());

    var fugrIncludesParamCurrent = this.querySpecs.getFugrIncludesParam();
    var fugrIncludesParamOld = querySpecs.getFugrIncludesParam();
    fugrIncludesParamCurrent.setAllIncludes(fugrIncludesParamOld.isAllIncludes());
    fugrIncludesParamCurrent.setIncludeFlags(fugrIncludesParamOld.getIncludeFlags());

    expandProgIncludesButton.setSelection(querySpecs.isExpandProgramIncludes());
    expandTablIncludesButton.setSelection(querySpecs.isExpandTableIncludes());

    classIncludeConfigGroup.updateControlsFromModel();
    fugrIncludeConfigGroup.updateControlsFromModel();

    updateExtensionSectionsFromQuery(query);
  }

  @Override
  public void setVisible(final boolean visible) {
    super.setVisible(visible);
    updateOKStatus();
  }

  private void collectExtensionSectionParameters() {
    for (ISearchPageParameterSection section : extensionParamSections) {
      querySpecs.getExtensionObjectScopeFilters()
          .put(section.getParameterId(),
              section.getParameterValues().stream().collect(Collectors.joining(",")));
    }
  }

  private void collectQuerySpecs() {
    querySpecs.setPatterns(patternsText.getText());
    String objectScopeFilterText = filterInput.getText();
    querySpecs
        .setObjectScopeFilters(filterHandler.getSearchFiltersAsStringMap(objectScopeFilterText,
            FilterName.getContentAssistToUriParamNameMap(), ","), objectScopeFilterText);
    querySpecs.setIgnoreCaseCheck(ignoreCaseCheck.getSelection());
    querySpecs.setIgnoreCommentLines(ignoreCommentLinesCheck.getSelection());
    querySpecs.setObjectNames(objectNameInput.getText());
    querySpecs.setSinglePattern(singlePattern.getSelection());
    querySpecs.setSequentialMatching(sequentialMatchingCheck.getSelection());
    querySpecs.setMultilineSearchOption(multilineSearchOption.getSelection());
    querySpecs.setMatchAllPatterns(matchAllPatterns.getSelection());
    querySpecs.setUseRegExp(useRegExpCheck.getSelection());
    querySpecs.setExpandProgramIncludes(expandProgIncludesButton.getSelection());
    querySpecs.setExpandTableIncludes(expandTablIncludesButton.getSelection());

    collectExtensionSectionParameters();
  }

  private void createAdditionalSettingsGroup(final Composite parent) {
    final var group = new Group(parent, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(group);
    GridLayoutFactory.swtDefaults().numColumns(1).applyTo(group);
    group.setText(Messages.CodeSearchDialog_additionalSettingsGroup_xlbl);

    ignoreCommentLinesCheck = new Button(group, SWT.CHECK);
    ignoreCommentLinesCheck.setText(Messages.CodeSearchDialog_ignoreCommentLines_xchk);

    multilineSearchOption = new Button(group, SWT.CHECK);
    multilineSearchOption.setText(Messages.CodeSearchDialog_multilineSearch_xchk);
    multilineSearchOption.setToolTipText(Messages.CodeSearchDialog_multilineSearch_xtol);

    singlePattern = new Button(group, SWT.CHECK);
    singlePattern.setText(Messages.CodeSearchDialog_singlePatternModeOption_xchk);
    singlePattern.setToolTipText(Messages.CodeSearchDialog_singlePatternModeOption_xtol);
    singlePattern.addSelectionListener(widgetSelectedAdapter(e -> {
      updateOptionSelection();
      updateOptionEnabledment();
    }));

    matchAllPatterns = new Button(group, SWT.CHECK);
    matchAllPatterns.setText(Messages.CodeSearchDialog_matchAllOption_xchk);
    matchAllPatterns.setToolTipText(Messages.CodeSearchDialog_matchAllOption_xtol);

    sequentialMatchingCheck = new Button(group, SWT.CHECK);
    sequentialMatchingCheck.setText(Messages.CodeSearchDialog_sequentialMatchingOption_xchk);
    sequentialMatchingCheck
        .setToolTipText(Messages.CodeSearchDialog_seqeuentialMatchingOption_xtol);
    sequentialMatchingCheck.addSelectionListener(widgetSelectedAdapter(e -> {
      updateOptionSelection();
      updateOptionEnabledment();
      validateSearchPatterns();
      updateOKStatus();
    }));
  }

  private void createExtensionParamSections(final Composite parent) {
    try {
      extensionParamSections = SearchPageExtensionsRegistry.getParameterSections(PAGE_ID);

      for (ISearchPageParameterSection paramSection : extensionParamSections) {
        paramSection.createControl(parent);
        paramSection.addLayoutChangeListener(() -> mainComposite.layout(true));
      }
    } catch (CoreException e) {
      MessageDialog.openError(getShell(), Messages.CodeSearchDialog_extensionInitError_xtit,
          e.getMessage());
    }
  }

  private void createTypeSpecificSettingGroups(final Composite parent) {
    classIncludeConfigGroup = new IncludeFlagsRadioButtonGroup(
        Messages.CodeSearchDialog_classIncludesRadioGroup_xlbl,
        querySpecs.getClassIncludesParam()) {
      @Override
      protected IncludeFlagsDialog createDialog() {
        return new IncludeFlagsDialog(getShell(), groupTitle, includeFlagsParam.getIncludeFlags(),
            includeFlagsParam.getPossibleIncludes()) {
          private Group globalClassIncludesGroup;
          private Group otherClassIncludesGroup;

          @Override
          protected void createCheckComposites(final Composite parent) {
            Composite groupsComposite = new Composite(parent, SWT.NONE);
            GridDataFactory.fillDefaults().grab(true, true).applyTo(groupsComposite);
            GridLayoutFactory.swtDefaults()
                .margins(0, 0)
                .numColumns(2)
                .equalWidth(true)
                .applyTo(groupsComposite);

            globalClassIncludesGroup = createGroup(groupsComposite,
                Messages.CodeSearchDialog_globalClassIncludesSection_xlbl);
            otherClassIncludesGroup = createGroup(groupsComposite,
                Messages.CodeSearchDialog_otherClassIncludeSection_xlbl);
          }

          @Override
          protected Composite getParentForInclude(final IIncludeToSearch incl) {
            if (incl == ClassInclude.METHODS || incl == ClassInclude.PUBLIC_SECTION
                || incl == ClassInclude.PROTECTED_SECTION || incl == ClassInclude.PRIVATE_SECTION) {
              return globalClassIncludesGroup;
            }
            return otherClassIncludesGroup;
          }

          private Group createGroup(final Composite parent, final String text) {
            var group = new Group(parent, SWT.NONE);
            GridLayoutFactory.swtDefaults().applyTo(group);
            GridDataFactory.fillDefaults().grab(true, false).applyTo(group);
            group.setText(text);
            return group;
          }
        };
      }
    };

    classIncludeConfigGroup.createControl(parent);

    fugrIncludeConfigGroup = new IncludeFlagsRadioButtonGroup(
        Messages.CodeSearchDialog_functionGroupIncludesRadioGroup_xlbl,
        querySpecs.getFugrIncludesParam());

    fugrIncludeConfigGroup.createControl(parent);

    // create Group to control search of program includes
    final var programSettingsGroup = new Group(parent, SWT.NONE);
    programSettingsGroup.setText(Messages.CodeSearchDialog_programSettingsGroup_xtit);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(programSettingsGroup);
    RowLayoutFactory.swtDefaults().applyTo(programSettingsGroup);

    expandProgIncludesButton = new Button(programSettingsGroup, SWT.CHECK);
    expandProgIncludesButton.setText(Messages.CodeSearchDialog_expandIncludes_xchk);
    expandProgIncludesButton.setSelection(querySpecs.isExpandProgramIncludes());

    var tableSettingsGroup = new Group(parent, SWT.NONE);
    tableSettingsGroup.setText(Messages.CodeSearchDialog_tableSettingsGroup_xtit);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(tableSettingsGroup);
    GridLayoutFactory.swtDefaults().applyTo(tableSettingsGroup);

    expandTablIncludesButton = new Button(tableSettingsGroup, SWT.CHECK);
    expandTablIncludesButton.setText(Messages.CodeSearchDialog_expandIncludes_xchk);
    expandTablIncludesButton.setSelection(querySpecs.isExpandTableIncludes());
  }

  private void createObjectScopeGroup(final Composite parent) {
    var objectScopeGroup = new Group(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(objectScopeGroup);
    GridLayoutFactory.swtDefaults().applyTo(objectScopeGroup);
    objectScopeGroup.setText(Messages.CodeSearchDialog_objectScopeGroup_xlbl);

    var name = new Label(objectScopeGroup, SWT.NONE);
    name.setText(Messages.CodeSearchDialog_objectNameFilter_xlbl);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(name);

    objectNameInput = new Text(objectScopeGroup, SWT.BORDER);
    AdtSWTUtilFactory.getOrCreateSWTUtil().addTextEditMenu(objectNameInput);
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.CENTER)
        .grab(true, false)
        .hint(200, SWT.DEFAULT)
        .applyTo(objectNameInput);
    var filter = new Label(objectScopeGroup, SWT.NONE);
    filter.setText(Messages.CodeSearchDialog_objectScopeFilters_xlbl);
    GridDataFactory.fillDefaults()
        .indent(SWT.DEFAULT, 5)
        .align(SWT.FILL, SWT.CENTER)
        .applyTo(filter);

    filterInput = new Text(objectScopeGroup, SWT.BORDER);
    AdtSWTUtilFactory.getOrCreateSWTUtil().addTextEditMenu(filterInput);
    TextControlUtil.addWordSupport(filterInput);
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.CENTER)
        .grab(true, false)
        .hint(200, SWT.DEFAULT)
        .applyTo(filterInput);

    filterInput.addModifyListener(event -> {
      validateFilterPattern();
      updateOKStatus();
    });

    createExtensionParamSections(objectScopeGroup);
  }

  private void createPatternsGroup(final Composite parent) {
    final var patternsGroup = new Group(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(patternsGroup);
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(patternsGroup);
    patternsGroup.setText(Messages.CodeSearchDialog_searchPatternFilter_xlbl);

    patternsText = new Text(patternsGroup, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
    AdtSWTUtilFactory.getOrCreateSWTUtil().addTextEditMenu(patternsText);
    GridDataFactory.fillDefaults()
        .grab(true, false)
        .hint(SWT.DEFAULT, 100)
        .align(SWT.FILL, SWT.FILL)
        .applyTo(patternsText);

    patternsText.addModifyListener(e -> {
      // reset status of back end pattern validation if pattern was changed
      allValidationStatuses.put(ValidationSource.SEARCH_PATTERN_BACKEND, Status.OK_STATUS);

      validateSearchPatterns();
      updateOKStatus();
    });

    // create composite for pattern options
    var patternOptions = new Composite(patternsGroup, SWT.NONE);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).applyTo(patternOptions);
    GridLayoutFactory.swtDefaults().margins(5, 0).applyTo(patternOptions);

    ignoreCaseCheck = new Button(patternOptions, SWT.CHECK);
    ignoreCaseCheck.setText(Messages.CodeSearchDialog_ignoreCaseOption_xchk);

    useRegExpCheck = new Button(patternOptions, SWT.CHECK);
    useRegExpCheck.setText(Messages.CodeSearchDialog_regularExpressionsOption_xchk);
    useRegExpCheck.addSelectionListener(widgetSelectedAdapter(e -> {
      allValidationStatuses.put(ValidationSource.SEARCH_PATTERN_BACKEND, Status.OK_STATUS);
      updateOptionSelection();
      updateOptionEnabledment();
      validateSearchPatterns();
      updateOKStatus();
    }));
  }

  private void createProjectInput(final Composite parent) {
    projectInput = new ProjectInput(projectProvider, true);

    projectInput.createControl(parent, new Point(0, 5));
    projectInput.addProjectValidator(project -> CodeSearchFactory.getCodeSearchService()
        .testCodeSearchFeatureAvailability(project));
    projectInput.addStatusChangeListener(status -> {
      boolean isProjectValid = false;
      if (validateAndSetStatus(status, ValidationSource.PROJECT)) {
        isProjectValid = true;
        validateFilterPattern();
        validateSearchPatterns();
      }
      updateProjectDependentOptions(isProjectValid);
      setProjectInExtensionSections();
      updateOKStatus();
    });
  }

  private void createStatusArea(final Composite parent) {
    statusArea = new Composite(parent, SWT.NONE);

    GridDataFactory.swtDefaults()
        .align(SWT.FILL, SWT.FILL)
        .hint(650, SWT.DEFAULT)
        .grab(true, false)
        .applyTo(statusArea);
    GridLayoutFactory.fillDefaults().numColumns(2).applyTo(statusArea);

    searchStatusImageLabel = new Label(statusArea, SWT.NONE);
    GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.CENTER).applyTo(searchStatusImageLabel);

    searchStatusTextLabel = new Label(statusArea, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(searchStatusTextLabel);
  }

  private IDialogSettings getDialogSettings() {
    if (dialogSettings == null) {
      dialogSettings = CodeSearchUIPlugin.getDefault()
          .getDialogSettingsSection(CodeSearchDialog.class.getName());
    }
    return dialogSettings;
  }

  private boolean isSearchPatternProvided() {
    if (patternsText == null || patternsText.isDisposed()) {
      return false;
    }
    String patterns = patternsText.getText();
    return patterns != null && !patterns.isEmpty();
  }

  private void readDialogSettings() {
    if (!CodeSearchUIPlugin.getDefault()
        .getPreferenceStore()
        .getBoolean(ICodeSearchPrefs.REMEMBER_INCLUDE_SETTINGS)) {
      return;
    }
    var dialogSettings = getDialogSettings();

    var classIncludesParam = querySpecs.getClassIncludesParam();
    try {
      classIncludesParam.setIncludeFlags(dialogSettings.getInt(CLASS_INCLUDES_BITS));
    } catch (NumberFormatException exc) {
      classIncludesParam.setIncludeFlags(0);
    }
    classIncludesParam.setAllIncludes(dialogSettings.getBoolean(CLASS_INCLUDES_ALL_ENABLED)
        || classIncludesParam.getIncludeFlags() == 0);

    var fugrIncludesParam = querySpecs.getFugrIncludesParam();
    try {
      fugrIncludesParam.setIncludeFlags(dialogSettings.getInt(FUGR_INCLUDES_BITS));
    } catch (NumberFormatException exc) {
      fugrIncludesParam.setIncludeFlags(0);
    }
    fugrIncludesParam.setAllIncludes(dialogSettings.getBoolean(FUGR_INCLUDES_ALL_ENABLED)
        || fugrIncludesParam.getIncludeFlags() == 0);
    querySpecs.setExpandProgramIncludes(dialogSettings.getBoolean(TABLE_INCLUDES_EXPAND_ENABLED));
    querySpecs.setExpandTableIncludes(dialogSettings.getBoolean(TABLE_INCLUDES_EXPAND_ENABLED));
  }

  private void registerContentAssist() {
    // set up content assist for the filters text
    var filterProvider = new CodeSearchScopeFilters(projectProvider);
    filterHandler = new SearchFilterHandler(filterProvider);
    filterHandler.addContentAssist(filterInput);
  }

  private IStatus runPatternValidationRequest() {
    /**
     * Pattern validation is only necessary for regular expressions or sequential matching
     */
    if (!querySpecs.isUseRegExp() && !querySpecs.isSequentialMatching()) {
      return Status.OK_STATUS;
    }
    Map<String, String> uriParams = new HashMap<>();
    if (querySpecs.isUseRegExp()) {
      uriParams.put(SearchParameter.USE_REGEX.getUriName(), String.valueOf(true));
    }
    if (querySpecs.isSequentialMatching()) {
      uriParams.put(SearchParameter.SEQUENTIAL_MATCHING.getUriName(), String.valueOf(true));
    }
    var validationStatusAtom = new AtomicReference<>(Status.OK_STATUS);

    try {
      PlatformUI.getWorkbench().getProgressService().busyCursorWhile(monitor -> {
        validationStatusAtom.set(CodeSearchFactory.getCodeSearchService()
            .validatePatterns(projectProvider.getDestinationId(),
                querySpecs.getPatternForValidationCall(), uriParams));
      });
    } catch (InvocationTargetException e) {
      e.printStackTrace();
      return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID, e.getMessage(), e);
    } catch (InterruptedException e) {
    }
    return validationStatusAtom.get();
  }

  /*
   * Sets initial data
   */
  private void setInitialData() {
    ignoreCaseCheck.setSelection(true);
    setInitialProject();
  }

  private void setInitialProject() {
    if (projectInput != null) {
      String projectName = null;

      final IProject currentAbapProject = ProjectUtil.getCurrentAbapProject();
      if (currentAbapProject != null) {
        projectName = currentAbapProject.getName();
      }
      if (projectName == null || projectName.isEmpty()) {
        projectName = getDialogSettings().get(LAST_PROJECT_PREF);
      }
      projectInput.setProjectName(projectName);
    }
  }

  private void setProjectInExtensionSections() {
    var project = projectProvider.getProject();
    var searchScopeFeatures = project != null
        ? CodeSearchFactory.getCodeSearchService()
            .getSearchScopeFeatures(projectProvider.getDestinationId())
        : null;

    for (ISearchPageParameterSection section : extensionParamSections) {
      if (project != null) {
        // check feature availability
        if (searchScopeFeatures != null
            && searchScopeFeatures.isFeatureEnabled("parameters." + section.getParameterId())) {
          section.setProject(project);
          section.setEnabledStatus(Status.OK_STATUS);
        } else {
          section.setProject(null);
          section.setEnabledStatus(new Status(IStatus.INFO, CodeSearchUIPlugin.PLUGIN_ID,
              Messages.CodeSearchDialog_extensionNotAvailableError_xmsg));
        }
      } else {
        section.setProject(null);
        section.setEnabledStatus(Status.OK_STATUS);
      }
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
        searchStatusImageLabel.setImage(StatusUtil.getImageForStatus(status.getSeverity()));
        searchStatusTextLabel.setText(status.getMessage());
        searchStatusTextLabel.setToolTipText(status.getMessage());
        searchStatusTextLabel.pack(true);
        searchStatusTextLabel.getParent().layout(true);
        getShell().pack(true);
      }
    });
  }

  private void updateExtensionSectionsFromQuery(final CodeSearchQuery query) {
    Map<String, Object> scopeFilters = query.getQuerySpecs().getExtensionObjectScopeFilters();

    for (ISearchPageParameterSection section : extensionParamSections) {
      Object scopeFilterValue = scopeFilters.get(section.getParameterId());
      if (scopeFilterValue instanceof String) {
        section.setParameterValues(Arrays.asList(((String) scopeFilterValue).split(",")));
      }
    }
  }

  private void updateOKStatus() {
    Display.getDefault().asyncExec(() -> {
      if (getControl().isDisposed()) {
        return;
      }
      boolean isError = allValidationStatuses.values()
          .stream()
          .anyMatch(s -> s.getSeverity() == IStatus.ERROR);
      container.setPerformActionEnabled(!isError);
    });
  }

  private void updateOptionEnabledment() {
    boolean isSinglePattern = singlePattern.getSelection();
    boolean isSequentialMatching = sequentialMatchingCheck.getSelection();

    singlePattern.setEnabled(!isSequentialMatching);
    sequentialMatchingCheck.setEnabled(!isSinglePattern);

    if (!isSinglePattern && !isSequentialMatching) {
      multilineSearchOption.setEnabled(true);
      matchAllPatterns.setEnabled(true);
    } else {
      multilineSearchOption.setEnabled(!isSinglePattern && !isSequentialMatching);
      matchAllPatterns.setEnabled(!isSinglePattern && !isSequentialMatching);
    }
  }

  private void updateOptionSelection() {
    if (sequentialMatchingCheck.getSelection()) {
      singlePattern.setSelection(false);
      matchAllPatterns.setSelection(true);
      multilineSearchOption.setSelection(false);
    } else if (singlePattern.getSelection()) {
      sequentialMatchingCheck.setSelection(false);
      multilineSearchOption.setSelection(true);
      matchAllPatterns.setSelection(false);
    }
  }

  private void updateProjectDependentOptions(final boolean isProjectValid) {
    if (expandProgIncludesButton == null || expandProgIncludesButton.isDisposed()) {
      return;
    }

    if (!isProjectValid) {
      expandProgIncludesButton.setEnabled(false);
      expandTablIncludesButton.setEnabled(false);
    } else {
      var service = CodeSearchFactory.getCodeSearchService();
      expandProgIncludesButton.setEnabled(service.isCodeSearchParameterSupported(
          projectProvider.getProject(), SearchParameter.EXPAND_PROG_INCLUDES.getUriName()));
      expandTablIncludesButton.setEnabled(service.isCodeSearchParameterSupported(
          projectProvider.getProject(), SearchParameter.EXPAND_TABLE_INCLUDES.getUriName()));
    }

    if (!expandProgIncludesButton.isEnabled()) {
      expandProgIncludesButton.setSelection(false);
    }
    if (!expandTablIncludesButton.isEnabled()) {
      expandTablIncludesButton.setSelection(false);
    }
  }

  private IStatus updateStatus(final IStatus status, final ValidationSource type) {
    final var validatedStatus = status == null ? Status.OK_STATUS : status;
    allValidationStatuses.put(type, validatedStatus);
    return validatedStatus;
  }

  private boolean validateAndSetStatus(final IStatus status, final ValidationSource type) {
    final var validatedStatus = updateStatus(status, type);
    if (validatedStatus.getSeverity() == IStatus.OK) {
      var lastErrorStatus = allValidationStatuses.entrySet()
          .stream()
          .filter(
              entry -> entry.getKey() != type && entry.getValue().getSeverity() == IStatus.ERROR)
          .map(Entry::getValue)
          .findFirst();
      setStatus(lastErrorStatus.orElse(Status.OK_STATUS));
    } else {
      setStatus(validatedStatus);
    }
    return validatedStatus == null || validatedStatus.isOK();
  }

  private void validateFilterPattern() {
    if (filterHandler == null || filterInput == null || filterInput.isDisposed()) {
      return;
    }
    final String filterPattern = filterInput.getText();
    try {
      filterHandler.checkSearchFiltersComplete(filterPattern);
      validateAndSetStatus(new Status(IStatus.OK, CodeSearchUIPlugin.PLUGIN_ID, null, null),
          ValidationSource.FILTERS);
    } catch (final CoreException e) {
      validateAndSetStatus(
          new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID, e.getMessage(), e),
          ValidationSource.FILTERS);
    }
  }

  private void validateSearchPatterns() {
    if (isSearchPatternProvided()) {
      if (sequentialMatchingCheck.getSelection()
          && patternsText.getText().split(Text.DELIMITER).length < 2) {
        validateAndSetStatus(
            new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID,
                Messages.CodeSearchDialog_invalidPatternCountForSeqMatching_xmsg),
            ValidationSource.SEARCH_PATTERN);
        return;
      }
      // everything checked out
      validateAndSetStatus(new Status(IStatus.OK, CodeSearchUIPlugin.PLUGIN_ID, null, null),
          ValidationSource.SEARCH_PATTERN);
    } else {
      /*
       * reset the pattern validation status so the previous error status from a
       * different validation source is shown
       */
      validateAndSetStatus(Status.OK_STATUS, ValidationSource.SEARCH_PATTERN);
      updateStatus(new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID, null, null),
          ValidationSource.SEARCH_PATTERN);
    }
  }

  private void writeDialogSettings() {
    var dialogSettings = getDialogSettings();
    dialogSettings.put(CLASS_INCLUDES_ALL_ENABLED,
        querySpecs.getClassIncludesParam().isAllIncludes());
    dialogSettings.put(CLASS_INCLUDES_BITS, querySpecs.getClassIncludesParam().getIncludeFlags());
    dialogSettings.put(FUGR_INCLUDES_ALL_ENABLED,
        querySpecs.getFugrIncludesParam().isAllIncludes());
    dialogSettings.put(FUGR_INCLUDES_BITS, querySpecs.getFugrIncludesParam().getIncludeFlags());
    dialogSettings.put(LAST_PROJECT_PREF, projectProvider.getProjectName());
    dialogSettings.put(PROGRAM_INCLUDES_EXPAND_ENABLED, querySpecs.isExpandProgramIncludes());
    dialogSettings.put(TABLE_INCLUDES_EXPAND_ENABLED, querySpecs.isExpandTableIncludes());
  }
}
