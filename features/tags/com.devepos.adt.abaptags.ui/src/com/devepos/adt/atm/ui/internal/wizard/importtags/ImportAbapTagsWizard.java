package com.devepos.adt.atm.ui.internal.wizard.importtags;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagImportRequest;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.base.destinations.DestinationUtil;
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
    setWindowTitle("Import ABAP Tags & Tagged Objects");
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
    // addPage(new TaggedObjectsSelectionWizardPage());
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
        monitor.beginTask("Importing ABAP Tag data", -1);
        // TODO: run import task and collect the result of the import
        importStatus.set(AdtObjTaggingServiceFactory.createTaggingService()
            .importTags(DestinationUtil.getDestinationId(getProject()), tagsContentForImport));
        monitor.done();
      });

      var status = importStatus.get();
      if ((status == null) || status.isOK()) {
        return true;
      }
      /**
       * TODO: prepare custom dialog to show the import result i.e. list of objects that have been
       * imported or not
       */
      Display.getDefault().asyncExec(() -> {
        MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
            "Import Error", status.getMessage());
      });
      return false;
    } catch (final InvocationTargetException e) {
      Display.getDefault().asyncExec(() -> {
        final var message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        MessageDialog.openError(getShell(), "Error occurred", message);
      });
      return false;
    } catch (final InterruptedException e) {
      return false;
    }
  }

}
