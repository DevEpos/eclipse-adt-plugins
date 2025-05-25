package com.devepos.adt.atm.ui.internal.wizard.importtags;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.tagging.IAdtObjTaggingService;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.tags.IAbapTagsService;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.project.ProjectInput;
import com.devepos.adt.base.ui.project.RadioProjectInput;
import com.devepos.adt.base.ui.wizard.AbstractBaseWizardPage;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.util.ui.swt.AdtSWTUtilFactory;

/**
 * Initial page of the Import tags wizard, which allows the user to choose from which source the
 * tags content should be fetched.
 * 
 * @see {@link ImportAbapTagsWizard}
 * @author stockbal
 */
public class ImportSourceWizardPage extends AbstractBaseWizardPage {
  public static final String PAGE_NAME = ImportSourceWizardPage.class.getCanonicalName();

  private final IAbapTagsService tagsService;
  private final IAdtObjTaggingService taggingService;
  private Map<ValidationSource, IStatus> pageValidationStatusMap;

  private ProjectInput targetProjectInput;
  private RadioProjectInput sourceProjectInput;
  private Text sourceFileInput;
  private Button browseSourceFileButton;
  private Button selectSourceFileRadio;

  public ImportSourceWizardPage() {
    super(PAGE_NAME);
    setTitle(Messages.ImportSourceWizardPage_SelectImportSource_xmsg);
    tagsService = AbapTagsServiceFactory.createTagsService();
    taggingService = AdtObjTaggingServiceFactory.createTaggingService();

    pageValidationStatusMap = new HashMap<>();
    pageValidationStatusMap.put(ValidationSource.PROJECT, Status.OK_STATUS);
    pageValidationStatusMap.put(ValidationSource.SOURCE_PROJECT, new Status(IStatus.ERROR,
        AbapTagsUIPlugin.PLUGIN_ID, Messages.ImportSourceWizardPage_NoSourceProjectSpecified_xmsg));
    pageValidationStatusMap.put(ValidationSource.SOURCE_FILE, new Status(IStatus.ERROR,
        AbapTagsUIPlugin.PLUGIN_ID, Messages.ImportSourceWizardPage_NoSourceFileSpecified_xmsg));
  }

  private enum ValidationSource {
    PROJECT,
    SOURCE_FILE,
    SOURCE_PROJECT
  }

  @Override
  public void completePage() {
    if (!isDirty()) {
      return;
    }
    var wizard = getWizard();
    wizard.setProject(targetProjectInput.getProjectProvider().getProject());
    if (sourceProjectInput.getRadioButton().getSelection()) {
      wizard.setSourceProject(sourceProjectInput.getProjectProvider().getProject());
      wizard.setSourceFile(null);
    } else {
      wizard.setSourceProject(null);
      wizard.setSourceFile(sourceFileInput.getText());
    }

    setDirty(false);
  }

  @Override
  public void createControl(final Composite parent) {
    final var root = new Composite(parent, SWT.NONE);

    // TODO: Help Context
    // HelpUtil.setHelp(root, HelpContexts.UNASSIGN_TAGS_WIZARD_TAG_SELECTION);
    GridLayoutFactory.swtDefaults().applyTo(root);
    GridDataFactory.fillDefaults().hint(400, SWT.DEFAULT);

    createTargetProjectSection(root);
    createSourceSection(root);

    var currentProject = getWizard().getProject();
    if (currentProject != null) {
      targetProjectInput.setProjectName(currentProject.getName());
      if (pageValidationStatusMap.get(ValidationSource.PROJECT).isOK()) {
        sourceProjectInput.setFocus();
      }
    } else {
      targetProjectInput.setProjectName(null);
      targetProjectInput.setFocus();
    }

    setControl(root);
    setPageComplete(false);
  }

  @Override
  public ImportAbapTagsWizard getWizard() {
    return (ImportAbapTagsWizard) super.getWizard();
  }

  @Override
  public void setVisible(final boolean visible) {
    if (visible && !isPageComplete()) {
      getWizard().completePreviousPage(this);
    }
    super.setVisible(visible);
  }

  private void createTargetProjectSection(final Composite parent) {
    targetProjectInput = new ProjectInput(true);

    var projectComposite = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(projectComposite);
    GridLayoutFactory.swtDefaults().applyTo(projectComposite);

    targetProjectInput.setBrowseButtonMnemonic("o"); //$NON-NLS-1$
    targetProjectInput.createControl(projectComposite);

    targetProjectInput.addProjectValidator(p -> {
      var tagFeatureStatus = tagsService.testTagsFeatureAvailability(p);
      return tagFeatureStatus.isOK() ? taggingService.testTagsImportFeatureAvailability(p)
          : tagFeatureStatus;
    });

    targetProjectInput.addStatusChangeListener(status -> {
      sourceProjectInput.setRadioButtonEnabled(status.isOK());
      selectSourceFileRadio.setEnabled(status.isOK());

      if (status.isOK()) {
        checkSourceMode();
      } else {
        sourceProjectInput.setEnabled(false);
        browseSourceFileButton.setEnabled(false);
        sourceFileInput.setEnabled(false);
      }
      validatePage(status, ValidationSource.PROJECT);
    });
  }

  private void createSourceSection(final Composite parent) {
    var sourceGroup = new Group(parent, SWT.NONE);
    sourceGroup.setText(Messages.ImportSourceWizardPage_Source_xgrp);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(sourceGroup);
    GridLayoutFactory.swtDefaults().numColumns(3).applyTo(sourceGroup);

    createSourceProjectControl(sourceGroup);
    createSourceFileInput(sourceGroup);

    sourceProjectInput.getRadioButton().setSelection(true);
    checkSourceMode();
  }

  private void createSourceProjectControl(final Composite parent) {
    sourceProjectInput = new RadioProjectInput(true);
    sourceProjectInput.setUseDedicatedComposite(false);
    sourceProjectInput.setBrowseButtonMnemonic("w"); //$NON-NLS-1$
    sourceProjectInput.setProjectLabelText(Messages.ImportSourceWizardPage_ProjectInput_xlbl);
    sourceProjectInput.setLabelMnemonic("j"); //$NON-NLS-1$

    sourceProjectInput.createControl(parent);
    sourceProjectInput.getRadioButton().addSelectionListener(widgetSelectedAdapter(l -> {
      checkSourceMode();
      if (sourceProjectInput.getRadioButton().getSelection()) {
        sourceProjectInput.setFocus();
      } else {
        browseSourceFileButton.setFocus();
      }
      validatePage(null, null);
    }));

    sourceProjectInput.addProjectValidator(p -> {
      var tagFeatureStatus = tagsService.testTagsFeatureAvailability(p);
      return tagFeatureStatus.isOK() ? taggingService.testTagsExportFeatureAvailability(p)
          : tagFeatureStatus;
    });
    // add additional check to verify that source project does not equal the target project
    sourceProjectInput.addProjectValidator(p -> {
      if (DestinationUtil.getSystemId(DestinationUtil.getDestinationId(p))
          .equals(DestinationUtil.getSystemId(DestinationUtil
              .getDestinationId(targetProjectInput.getProjectProvider().getProject())))) {
        return new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID,
            Messages.ImportSourceWizardPage_TargetProjectEqualsSource_xmsg);
      }
      return Status.OK_STATUS;
    });

    sourceProjectInput.addStatusChangeListener(status -> {
      validatePage(status, ValidationSource.SOURCE_PROJECT);
    });
  }

  private void checkSourceMode() {
    var isProjectMode = sourceProjectInput.getRadioButton().getSelection();

    sourceProjectInput.setEnabled(isProjectMode);
    browseSourceFileButton.setEnabled(!isProjectMode);
    sourceFileInput.setEnabled(!isProjectMode);
  }

  private void createSourceFileInput(final Composite parent) {
    selectSourceFileRadio = new Button(parent, SWT.RADIO);
    selectSourceFileRadio.setText(Messages.ImportSourceWizardPage_FileInput_xlbl);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(selectSourceFileRadio);

    sourceFileInput = new Text(parent, SWT.BORDER | SWT.READ_ONLY);
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.CENTER)
        .grab(true, false)
        .applyTo(sourceFileInput);

    browseSourceFileButton = new Button(parent, SWT.PUSH);
    browseSourceFileButton.setText(
        StringUtil.setMnemonic(AdtBaseUIResources.getString(IAdtBaseStrings.Browse_xbtn), "s")); //$NON-NLS-1$
    browseSourceFileButton.addSelectionListener(widgetSelectedAdapter(l -> {
      var fileDialog = new FileDialog(getShell(), SWT.OPEN);
      fileDialog.setText(Messages.ImportSourceWizardPage_SelectSourceFileDialog_xtit);
      if (!StringUtil.isEmpty(sourceFileInput.getText())) {
        var file = new File(sourceFileInput.getText());
        fileDialog.setFileName(file.getName());
      } else {
        fileDialog.setFileName("ABAP-Tags-Export"); //$NON-NLS-1$
      }
      fileDialog.setFilterExtensions(new String[] { "*.xml" }); //$NON-NLS-1$
      var fileName = fileDialog.open();
      IStatus fileValidationStatus = null;
      if (fileName != null) {
        sourceFileInput.setText(fileName);
        var file = new File(fileName);
        if (!file.exists()) {
          fileValidationStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID,
              IStatus.ERROR, Messages.ImportSourceWizardPage_SourceFileNotExisting_xmsg, null);
        }
      } else {
        fileValidationStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, IStatus.ERROR,
            Messages.ImportSourceWizardPage_NoSourceFileSpecified_xmsg, null);
        sourceFileInput.setText(""); //$NON-NLS-1$
      }
      validatePage(fileValidationStatus, ValidationSource.SOURCE_FILE);
    }));
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(browseSourceFileButton);
    AdtSWTUtilFactory.getOrCreateSWTUtil().setButtonWidthHint(browseSourceFileButton);
  }

  private void validatePage(final IStatus status, final ValidationSource source) {
    setDirty(true);
    getWizard().setCanFinish(false);

    var pageStatus = status;
    if (source != null) {
      pageValidationStatusMap.put(source, status == null ? Status.OK_STATUS : status);
    }

    if (status == null || status.isOK()) {
      var lastErrorStatus = pageValidationStatusMap.entrySet()
          .stream()
          .filter(e -> e.getKey() != source && e.getValue().getSeverity() == IStatus.ERROR)
          .filter(e -> sourceProjectInput.getRadioButton().getSelection()
              ? e.getKey() != ValidationSource.SOURCE_FILE
              : e.getKey() != ValidationSource.SOURCE_PROJECT)
          .map(Entry::getValue)
          .findFirst();
      pageStatus = lastErrorStatus.orElse(Status.OK_STATUS);
    }

    updatePageCompletedStatus(pageStatus);
  }
}
