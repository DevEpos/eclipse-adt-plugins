package com.devepos.adt.atm.ui.internal.wizard.importtags;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.atm.model.abaptags.IAbapTagsContent;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.wizard.AbstractWizardBase;

/**
 * Wizard for importing ABAP Tags content into a given ABAP project.
 * 
 * @author stockbal
 */
public class ImportAbapTagsWizard extends AbstractWizardBase implements IImportWizard {

  private IProject sourceProject;
  private String sourceFile;
  private IAbapTagsContent tagsContentForImport;
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

  public IAbapTagsContent getTagsContentForImport() {
    return tagsContentForImport;
  }

  public void setTagsContentForImport(IAbapTagsContent tagsContentForImport) {
    this.tagsContentForImport = tagsContentForImport;
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
    var wizardResult = new AtomicBoolean();
    wizardResult.set(true);
    try {
      getContainer().run(true, false, monitor -> {
        monitor.beginTask("Importing ABAP Tag data", -1);
        // TODO: run import task and collect the result of the import
        // wizardResult.set(false);
        monitor.done();
      });
      if (wizardResult.get()) {
        /**
         * TODO: prepare custom dialog to show the import result i.e. list of objects that have been
         * imported or not
         */
        Display.getDefault().asyncExec(() -> {
          MessageDialog.openInformation(
              PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Information",
              "Import completed with the following result...\nTagged Object xxxx\nTagged Object xxxy");
        });
      }
      return wizardResult.get();
    } catch (final InvocationTargetException e) {
      Display.getDefault().asyncExec(() -> {
        final String message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        MessageDialog.openError(getShell(), "Error occurred", message);
      });
      return false;
    } catch (final InterruptedException e) {
      return false;
    }
  }

}
