package com.devepos.adt.atm.ui.internal.wizard.importtags;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.wizard.AbstractWizardBase;
import com.devepos.adt.base.ui.project.ProjectUtil;

public class ImportAbapTagsWizard extends AbstractWizardBase implements IImportWizard {

  public ImportAbapTagsWizard() {
    setWindowTitle("Import ABAP Tags & Tagged Objects");
    setDefaultPageImageDescriptor(
        AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.IMPORT_TAGS_WIZBAN));
    setNeedsProgressMonitor(true);
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
    // TODO Auto-generated method stub
    return false;
  }

}
