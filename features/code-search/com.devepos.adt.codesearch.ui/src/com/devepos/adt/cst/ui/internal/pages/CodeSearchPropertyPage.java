package com.devepos.adt.cst.ui.internal.pages;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PropertyPage;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.MessageLine;
import com.devepos.adt.base.ui.contentassist.ContentAssistSupport;
import com.devepos.adt.base.ui.preferences.LinkToAdtPageBlocksFactory;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.util.TextControlUtil;
import com.devepos.adt.cst.model.codesearch.ICodeSearchSettings;
import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.search.ICodeSearchFeatureUtil;
import com.devepos.adt.cst.search.ICodeSearchSettingsService;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.codesearch.NamedItem;
import com.devepos.adt.cst.ui.internal.help.HelpContexts;
import com.devepos.adt.cst.ui.internal.help.HelpUtil;
import com.devepos.adt.cst.ui.internal.messages.Messages;
import com.devepos.adt.cst.ui.internal.preferences.CodeSearchPreferencesPage;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;

/**
 * Describes project specific settings of the Code Search
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CodeSearchPropertyPage extends PropertyPage implements IWorkbenchPropertyPage {

  public static final String PAGE_ID = "com.devepos.adt.codesearch.ui.pages.CodeSearchPropertyPage";
  /**
   * Identifies the feature to enable/disable the new RegEx engine which is
   * available starting with ABAP NW 7.55
   */
  public static final String PCRE_AVAILABLE_FEATURE = "pcreAvailable";

  private static final int MIN_MAX_OBJECTS = 500;
  private static final int MAX_MAX_OBJECTS = 10000;

  private ICodeSearchSettingsService searchSettingsService;
  private String destinationId;
  private boolean pageIsInvalid;
  private boolean pageIsUseable;
  private IStatus pageNotUseableStatus;

  private Button parallelEnabled;
  private Button pcreSingleLineEnabled;
  private Button pcreExtendedDisabled;
  private Text serverGroupText;
  private Text parlPackageSize;

  private IProject project;
  private IAbapProjectProvider projectProvider;
  private IAdtPluginFeatures searchFeatures;
  private ICodeSearchSettings searchSettings;
  private boolean pcreAvailable;
  private Control linkToPreferencePageCtrl;
  private ICodeSearchFeatureUtil featureUtil;

  public CodeSearchPropertyPage() {

  }

  @SuppressWarnings("rawtypes")
  @Override
  public void applyData(final Object data) {
    if (data instanceof Map) {
      Map<?, ?> options = (Map) data;
      var omit = Boolean.TRUE.equals(options.get(LinkToAdtPageBlocksFactory.NO_PREF_PAGE_LINK_KEY));
      if (omit && linkToPreferencePageCtrl != null && !linkToPreferencePageCtrl.isDisposed()) {
        linkToPreferencePageCtrl.setVisible(false);
        ((GridData) linkToPreferencePageCtrl.getLayoutData()).exclude = true;
        linkToPreferencePageCtrl.getParent().layout();
      }
    }
  }

  @Override
  public boolean performOk() {
    // backend not available
    if (!pageIsUseable) {
      return true;
    }
    var dirty = isPageDirty();
    if (!dirty && !pageIsInvalid) {
      return true;
    }
    if (dirty) {
      validateParallelProcessingPackageSize();
      if (getErrorMessage() != null) {
        return false;
      }
      updateModelFromUi();
    } else if (pageIsInvalid) {
      return false;
    }

    updateSettings();
    return getErrorMessage() == null;
  }

  @Override
  public void setElement(final IAdaptable element) {
    super.setElement(element);
    pageIsUseable = true;

    project = getElement().getAdapter(IProject.class);
    featureUtil = CodeSearchFactory.getCodeSearchFeatureUtil(project);
    searchSettingsService = CodeSearchFactory.getSearchSettingsService(project);

    destinationId = DestinationUtil.getDestinationId(project);
    projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
    checkLoggedOnToProject();
    checkCodeSearchFeatureAvailability();
    determineAvailableFeatures();
    readSettings();

    if (!pageIsUseable) {
      noDefaultAndApplyButton();
    }
  }

  @Override
  protected Control createContents(final Composite parent) {
    HelpUtil.setHelp(parent, HelpContexts.CODE_SEARCH_PROPERTIES);
    var main = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(main);
    GridLayoutFactory.swtDefaults().applyTo(main);

    var linkToPreferencePage = LinkToAdtPageBlocksFactory.createLinkToPreferencePage(
        CodeSearchPreferencesPage.PAGE_ID,
        Collections.singletonMap(LinkToAdtPageBlocksFactory.NO_PROP_PAGE_LINK_KEY, true));
    linkToPreferencePageCtrl = linkToPreferencePage.createControl(main,
        GridDataFactory.fillDefaults().align(SWT.RIGHT, SWT.FILL).create());

    if (pageIsUseable) {
      createRegexSettings(main);
      createParallelSettings(main);
      updateInputFromModel();
    } else {
      createErrorControl(main);
    }

    return main;
  }

  @Override
  protected void performDefaults() {
    super.performDefaults();
    setDefaultValues();
  }

  private void checkCodeSearchFeatureAvailability() {
    if (!pageIsUseable) {
      return;
    }
    var status = featureUtil.testSearchAvailabilityByProject(CodeSearchUIPlugin.getDefault()
        .getPreferenceStore()
        .getBoolean(ICodeSearchPrefs.PREFER_CLIENT_BASED_SEARCH));
    if (!status.isOK()) {
      pageIsUseable = false;
      pageNotUseableStatus = status;
    }
  }

  private void checkLoggedOnToProject() {
    if (!pageIsUseable) {
      return;
    }
    var loggedOnStatus = ProjectUtil.ensureLoggedOnToProject(project);
    if (!loggedOnStatus.isOK()) {
      pageIsUseable = false;
      pageNotUseableStatus = loggedOnStatus;
    }
  }

  private void createErrorControl(final Composite parent) {
    var error = new MessageLine(parent);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(error);
    error.setStatus(pageNotUseableStatus);
  }

  private Group createGroup(final String label, final Composite parent) {
    return createGroup(label, parent, true);
  }

  private Group createGroup(final String label, final Composite parent,
      final boolean createDefaultLayout) {
    final var group = new Group(parent, SWT.NONE);
    if (createDefaultLayout) {
      GridLayoutFactory.swtDefaults().applyTo(group);
    }
    GridDataFactory.fillDefaults().grab(true, false).applyTo(group);
    group.setText(label);
    return group;
  }

  private void createParallelSettings(final Composite parent) {
    var group = createGroup(Messages.CodeSearchPropertyPage_parallelProcessingGroup_xlbl, parent,
        false);
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(group);

    parallelEnabled = new Button(group, SWT.CHECK);
    parallelEnabled.setText(Messages.CodeSearchPropertyPage_parallelProcessingPref_xchk);
    parallelEnabled.addSelectionListener(widgetSelectedAdapter(e -> {
      var isParallelEnabled = parallelEnabled.getSelection();
      serverGroupText.setEnabled(isParallelEnabled);
      parlPackageSize.setEnabled(isParallelEnabled);
    }));
    GridDataFactory.fillDefaults().span(2, 1).applyTo(parallelEnabled);

    var maxObjectsInRequestLabel = new Label(group, SWT.NONE);
    maxObjectsInRequestLabel.setText(Messages.CodeSearchPropertyPage_parallelPackageSizePref_xlbl);

    parlPackageSize = new Text(group, SWT.NONE | SWT.BORDER);
    parlPackageSize.setTextLimit(5);
    parlPackageSize.setEnabled(false);
    parlPackageSize.addModifyListener(l -> {
      validateParallelProcessingPackageSize();
    });
    GridDataFactory.fillDefaults()
        .hint(convertWidthInCharsToPixels(5), SWT.DEFAULT)
        .applyTo(parlPackageSize);

    var serverGroupLabel = new Label(group, SWT.NONE);
    serverGroupLabel.setText(Messages.CodeSearchPropertyPage_serverGroupPref_xlbl);
    serverGroupLabel.setToolTipText(Messages.CodeSearchPropertyPage_serverGroupPref_xtol);

    serverGroupText = new Text(group, SWT.NONE | SWT.BORDER);
    serverGroupText.setTextLimit(20);
    serverGroupText.setEnabled(false);
    GridDataFactory.fillDefaults()
        .hint(convertWidthInCharsToPixels(28), SWT.DEFAULT)
        .applyTo(serverGroupText);
    TextControlUtil.addWordSupport(serverGroupText, "\\s+");
    ContentAssistSupport.createNamedItemContentAssist(serverGroupText, projectProvider,
        CodeSearchFactory.getNamedItemUriTemplateProvider(projectProvider), NamedItem.SERVER_GROUP,
        null);

  }

  private void createRegexSettings(final Composite parent) {
    var group = createGroup(Messages.CodeSearchPropertyPage_pcreRegexEngineSettingsGroup_xlbl,
        parent);

    if (!pcreAvailable) {
      var pcreNotAvailableInfo = new MessageLine(group);
      pcreNotAvailableInfo.setStatus(new Status(IStatus.INFO, CodeSearchUIPlugin.PLUGIN_ID,
          Messages.CodeSearchPropertyPage_pcreNotAvailableInfo_xmsg));
    }

    pcreExtendedDisabled = new Button(group, SWT.CHECK);

    pcreExtendedDisabled.setText(Messages.CodeSearchPropertyPage_disablePcreExtendedModePref_xchk);
    pcreExtendedDisabled.setEnabled(pcreAvailable);
    pcreExtendedDisabled
        .setToolTipText(Messages.CodeSearchPropertyPage_disablePcreExtendedModePref_xtol);

    pcreSingleLineEnabled = new Button(group, SWT.CHECK);
    pcreSingleLineEnabled.setEnabled(pcreAvailable);
    pcreSingleLineEnabled
        .setText(Messages.CodeSearchPropertyPage_enablePcreSingleLineModePref_xchk);
    pcreSingleLineEnabled
        .setToolTipText(Messages.CodeSearchPropertyPage_enablePcreSingleLineModePref_xtol);
  }

  private void determineAvailableFeatures() {
    if (!pageIsUseable) {
      return;
    }
    searchFeatures = featureUtil.getSearchSettingsFeatures();
    pcreAvailable = searchFeatures != null
        && searchFeatures.isFeatureEnabled(PCRE_AVAILABLE_FEATURE);
  }

  private boolean isPageDirty() {
    if (searchSettings == null) {
      return false;
    }
    if (searchSettings.isParallelEnabled() != parallelEnabled.getSelection()
        || searchSettings.isPcreExtendedDisabled() != pcreExtendedDisabled.getSelection()
        || pcreSingleLineEnabled.getSelection() != searchSettings.isPcreSingleLineEnabled()
        || !serverGroupText.getText().equals(searchSettings.getParallelServerGroup())) {
      return true;

    }
    if (!parlPackageSize.getText()
        .equals(String.valueOf(searchSettings.getParallelPackageSize()))) {
      return true;
    }
    return false;
  }

  private void readSettings() {
    if (!pageIsUseable) {
      return;
    }
    Job getSettingsJob = new Job("Retrieve Code Search Settings") {
      @Override
      protected IStatus run(final IProgressMonitor monitor) {
        searchSettings = searchSettingsService.getSettings();
        return Status.OK_STATUS;
      }

    };
    getSettingsJob.addJobChangeListener(new JobChangeAdapter() {
      @Override
      public void done(final IJobChangeEvent event) {
        Display.getDefault().asyncExec(() -> {
          var pageControl = getControl();
          if (pageControl != null && !pageControl.isDisposed()) {
            updateInputFromModel();
          }
        });
      }
    });
    getSettingsJob.schedule();
  }

  private void setDefaultValues() {
    if (pcreExtendedDisabled == null || pcreExtendedDisabled.isDisposed()) {
      return;
    }
    pcreExtendedDisabled.setSelection(false);
    parallelEnabled.setSelection(false);
    serverGroupText.setText("");
    serverGroupText.setEnabled(false);
    parlPackageSize.setText(String.valueOf(MIN_MAX_OBJECTS));
    parlPackageSize.setEnabled(false);
    setErrorMessage(null);
    pageIsInvalid = false;

    updateModelFromUi();
  }

  private void updateInputFromModel() {
    if (searchSettings != null) {
      pcreExtendedDisabled.setSelection(searchSettings.isPcreExtendedDisabled());
      pcreSingleLineEnabled.setSelection(searchSettings.isPcreSingleLineEnabled());
      parallelEnabled.setSelection(searchSettings.isParallelEnabled());
      serverGroupText.setText(searchSettings.getParallelServerGroup());
      serverGroupText.setEnabled(parallelEnabled.getSelection());
      parlPackageSize.setEnabled(parallelEnabled.getSelection());
      parlPackageSize.setText(String.valueOf(searchSettings.getParallelPackageSize()));
    }
  }

  private void updateModelFromUi() {
    if (searchSettings != null) {
      searchSettings.setPcreExtendedDisabled(pcreExtendedDisabled.getSelection());
      searchSettings.setPcreSingleLineEnabled(pcreSingleLineEnabled.getSelection());
      searchSettings.setParallelEnabled(parallelEnabled.getSelection());
      searchSettings.setParallelServerGroup(serverGroupText.getText());
      searchSettings.setParallelPackageSize(Integer.parseInt(parlPackageSize.getText()));
    }
  }

  private void updateSettings() {
    var progressService = PlatformUI.getWorkbench().getProgressService();
    var errorMessage = new AtomicReference<String>();

    try {
      progressService.busyCursorWhile(monitor -> {
        var updateOperationStatus = searchSettingsService.updateSettings(searchSettings);
        if (!updateOperationStatus.isOK()) {
          pageIsInvalid = true;
          errorMessage.set(updateOperationStatus.getMessage());
        }
      });
      if (!getControl().isDisposed()) {
        setErrorMessage(errorMessage.get());
      }
    } catch (InvocationTargetException e) {
      setErrorMessage(e.getCause().getLocalizedMessage());
      e.printStackTrace();
    } catch (InterruptedException e) {
    }
  }

  private void validateParallelProcessingPackageSize() {
    if (parlPackageSize == null || parlPackageSize.isDisposed()) {
      return;
    }
    setErrorMessage(null);
    try {
      var maxObjects = Integer.parseInt(parlPackageSize.getText());
      if (maxObjects < MIN_MAX_OBJECTS || maxObjects > MAX_MAX_OBJECTS) {
        pageIsInvalid = true;
        setErrorMessage(
            MessageFormat.format(Messages.CodeSearchPropertyPage_invalidParlPackageSize_xmsg,
                MIN_MAX_OBJECTS, MAX_MAX_OBJECTS));
      }
    } catch (NumberFormatException exc) {
      pageIsInvalid = true;
      setErrorMessage(
          MessageFormat.format(Messages.CodeSearchPropertyPage_invalidParlPackageSize_xmsg,
              MIN_MAX_OBJECTS, MAX_MAX_OBJECTS));
    }
  }
}
