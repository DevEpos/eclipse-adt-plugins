package com.devepos.adt.atm.ui.internal.wizard.export;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITagExportRequest;
import com.devepos.adt.atm.model.abaptags.ITagExportResponse;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.wizard.AbstractWizardBase;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.wizard.IBaseWizardPage;

/**
 * Wizard to export ABAP Tags
 *
 * @author stockbal
 */
public class ExportAbapTagsWizard extends AbstractWizardBase implements IExportWizard {

  private ITagExportRequest tagExportRequest;
  private String exportFileName;
  private boolean overwriteFileNoWarning;

  public ExportAbapTagsWizard() {
    setWindowTitle("Export ABAP Tags & Tagged Objects");
    setDefaultPageImageDescriptor(
        AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.EXPORT_TAGS_WIZBAN));
    setNeedsProgressMonitor(true);
  }

  public ITagExportRequest getTagExportRequest() {
    if (tagExportRequest == null) {
      tagExportRequest = IAbapTagsFactory.eINSTANCE.createTagExportRequest();
    }
    return tagExportRequest;
  }

  public void setExportFileName(final String exportFileName) {
    this.exportFileName = exportFileName;
  }

  public void setOverwriteFileNoWarning(boolean overwriteFileNoWarning) {
    this.overwriteFileNoWarning = overwriteFileNoWarning;
  }

  @Override
  public void init(final IWorkbench workbench, final IStructuredSelection selection) {
    setProject(ProjectUtil.getCurrentAbapProject(selection));
  }

  @Override
  public void addPages() {
    addPage(new TagSelectionWizardPage());
  }

  @Override
  public boolean performFinish() {
    final var currentPage = getContainer().getCurrentPage();
    if (currentPage instanceof IBaseWizardPage) {
      ((IBaseWizardPage) currentPage).completePage();
    }

    if (new File(exportFileName).exists() && !overwriteFileNoWarning
        && !MessageDialog.openQuestion(null, "Overwrite?",
            MessageFormat.format(
                "The specified file \"{0}\" already exists. Do you want to overwrite it?",
                new Object[] { exportFileName }))) {
      return false;
    }

    var wizardResult = new AtomicBoolean(true);
    try {
      getContainer().run(true, false, monitor -> {
        monitor.beginTask("Exporting ABAP Tag data", -1);
        var taggingSrv = AdtObjTaggingServiceFactory.createTaggingService();
        var response = taggingSrv.exportTags(DestinationUtil.getDestinationId(getProject()),
            tagExportRequest);

        monitor.done();
        Display.getDefault().asyncExec(() -> {
          if (response == null || response.getTags().size() == 0) {
            MessageDialog.openWarning(getShell(), "Warning",
                "Backend returned no matching data for the selected ABAP Tags");
            wizardResult.set(false);
          } else {
            saveExportToFile(response);
          }
        });
      });
      return wizardResult.get();
    } catch (final InvocationTargetException e) {
      if (e.getTargetException() instanceof RuntimeException) {
        throw (RuntimeException) e.getTargetException();
      }
      Display.getDefault().asyncExec(() -> {
        final String message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        MessageDialog.openError(getShell(), "Error occurred", message);
      });
      return false;
    } catch (final InterruptedException e) {
      return false;
    }
  }

  @SuppressWarnings("restriction")
  private void saveExportToFile(final ITagExportResponse response) {
    final var resourceFactory = new AbapTagsResourceFactory();
    try {
      var abapTagsContent = IAbapTagsFactory.eINSTANCE.createAbapTagContent();
      abapTagsContent.getTags().addAll(response.getTags());
      abapTagsContent.getSharedTags().addAll(response.getSharedTags());
      abapTagsContent.getTaggedObjectInfos().addAll(response.getTaggedObjectInfos());
      final var resource = resourceFactory.createResource(URI.createFileURI(exportFileName));
      final EList<EObject> resourceContents = resource.getContents();
      resourceContents.add(abapTagsContent);
      var options = createEmfResourceOptions();
      resource.save(options);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  /*
   * Creates option for loading/saving favorites via EMF
   */
  private static Map<String, Object> createEmfResourceOptions() {
    final HashMap<String, Object> options = new HashMap<>();
    options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
    options.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
    options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
        Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
    return options;
  }

}
