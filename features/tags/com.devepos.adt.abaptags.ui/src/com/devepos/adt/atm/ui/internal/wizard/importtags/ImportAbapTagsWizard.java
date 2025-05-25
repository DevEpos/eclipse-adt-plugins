package com.devepos.adt.atm.ui.internal.wizard.importtags;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagImportRequest;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.wizard.AbstractWizardBase;
import com.devepos.adt.base.ui.wizard.IBaseWizardPage;

/**
 * Wizard for importing ABAP Tags content into a given ABAP project.
 *
 * @author stockbal
 */
public class ImportAbapTagsWizard extends AbstractWizardBase implements IImportWizard {

  private IProject sourceProject;
  private String sourceFile;
  private ITagImportRequest tagsContentForImport;
  private Map<String, ITag> selectedTagsMap;

  public ImportAbapTagsWizard() {
    setWindowTitle(Messages.ImportAbapTagsWizard_Title_xtit);
    setDefaultPageImageDescriptor(
        AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.IMPORT_TAGS_WIZBAN));
    setNeedsProgressMonitor(true);
  }

  public void setSourceProject(final IProject project) {
    sourceProject = project;
  }

  public void setSourceFile(final String sourceFile) {
    this.sourceFile = sourceFile;
  }

  public IProject getSourceProject() {
    return sourceProject;
  }

  public String getSourceFile() {
    return sourceFile;
  }

  public void setTagsContentForImport(final ITagImportRequest importRequest) {
    tagsContentForImport = importRequest;
  }

  public Map<String, ITag> getSelectedTags() {
    if (selectedTagsMap == null) {
      selectedTagsMap = new HashMap<>();
    }
    return selectedTagsMap;
  }

  @Override
  public void init(final IWorkbench workbench, final IStructuredSelection selection) {
    setProject(ProjectUtil.getCurrentAbapProject(selection));
  }

  @Override
  public void addPages() {
    addPage(new ImportSourceWizardPage());
    addPage(new TagContentSelectionWizardPage());
  }

  @Override
  public void createPageControls(final Composite pageContainer) {
    /*
     * page controls will be initialized on demand. This ensures that the wizard
     * dialog will not be unnecessarily big at initial open due to some pages
     * needing more space
     */
  }

  @Override
  public boolean performFinish() {
    final var currentPage = getContainer().getCurrentPage();
    if (currentPage instanceof IBaseWizardPage) {
      ((IBaseWizardPage) currentPage).completePage();
    }
    var importStatus = new AtomicReference<IStatus>();
    try {
      getContainer().run(true, false, monitor -> {
        monitor.beginTask(Messages.ImportAbapTagsWizard_Job_xtit, -1);
        importStatus.set(AdtObjTaggingServiceFactory.createTaggingService()
            .importTags(DestinationUtil.getDestinationId(getProject()), tagsContentForImport));
        monitor.done();
      });

      var status = importStatus.get();

      /**
       * REVISIT: prepare custom dialog to show the import result i.e. list of objects that have
       * been imported or not
       */
      Display.getDefault().asyncExec(() -> {
        if (status.isOK()) {
          showImportResultDialog(status.getMessage());
        } else {
          MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
              Messages.ImportAbapTagsWizard_JobError_xmsg, status.getMessage());
        }
      });

      return status.isOK();
    } catch (final InvocationTargetException e) {
      Display.getDefault().asyncExec(() -> {
        final var message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        MessageDialog.openError(getShell(),
            AdtBaseUIResources.getString(IAdtBaseStrings.Dialog_Error_xtit), message); // $NON-NLS-1$
      });
      return false;
    } catch (final InterruptedException e) {
      return false;
    }
  }

  private void showImportResultDialog(final String importStatusMessage) {
    var dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
        AdtBaseUIResources.getString(IAdtBaseStrings.Dialog_Information_xtit), null,
        Messages.ImportAbapTagsWizard_ImportSuccess_xmsg, MessageDialog.INFORMATION, // $NON-NLS-1$
        0, new String[] { IDialogConstants.OK_LABEL }) { // $NON-NLS-1$

      private Font boldFont;

      public void dispose() {
        boldFont.dispose();
      }

      @Override
      protected Control createCustomArea(final Composite parent) {
        var statsComposite = new Composite(parent, SWT.NONE);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(statsComposite);
        GridLayoutFactory.swtDefaults()
            .numColumns(2)
            .margins(0, 0)
            .spacing(20, SWT.DEFAULT)
            .applyTo(statsComposite);

        var titleLabel = new Label(statsComposite, SWT.NONE);
        GridDataFactory.fillDefaults().span(2, 1).hint(SWT.DEFAULT, 30).applyTo(titleLabel);
        titleLabel.setText(Messages.ImportAbapTagsWizard_ImportStatistics_xlbl);

        var fontData = titleLabel.getFont().getFontData();
        for (var fd : fontData) {
          fd.setStyle(SWT.BOLD);
        }

        boldFont = new Font(getShell().getDisplay(), fontData);
        titleLabel.setFont(boldFont);

        // create labels for statistics
        for (var stat : importStatusMessage.split(";")) { //$NON-NLS-1$
          var textAndValue = stat.split("@@"); //$NON-NLS-1$
          var statNameLabel = new Label(statsComposite, SWT.NONE);
          GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).applyTo(statNameLabel);
          statNameLabel.setText(textAndValue[0]);

          var statValueLabel = new Label(statsComposite, SWT.NONE);
          GridDataFactory.fillDefaults().align(SWT.END, SWT.CENTER).applyTo(statValueLabel);
          statValueLabel
              .setText(new DecimalFormat("###,###").format(Integer.parseInt(textAndValue[1]))); //$NON-NLS-1$
        }
        return statsComposite;
      }

    };
    dialog.open();
    dialog.dispose();
  }

}
