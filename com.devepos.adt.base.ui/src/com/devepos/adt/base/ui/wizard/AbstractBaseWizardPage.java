package com.devepos.adt.base.ui.wizard;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.wizard.WizardPage;

/**
 * Abstract wizard page implementation with additional methods for status
 * handling, etc.
 *
 * @author stockbal
 */
public abstract class AbstractBaseWizardPage extends WizardPage implements IBaseWizardPage {
  private boolean isDirty = true;

  protected AbstractBaseWizardPage(final String pageName) {
    super(pageName);
  }

  @Override
  public boolean isDirty() {
    return isDirty;
  }

  @Override
  public void setDirty(final boolean isDirty) {
    this.isDirty = isDirty;
  }

  /**
   * Updates the page completion indicator depending on the given status object
   * 
   * @param pageStatus the status of a page validation
   */
  protected void updatePageCompletedStatus(final IStatus pageStatus) {
    boolean pageComplete = true;
    if (pageStatus == null || pageStatus.isOK()) {
      setErrorMessage(null);
      setMessage(null);
    } else if (pageStatus.getSeverity() == IStatus.ERROR) {
      if (pageStatus.getCode() == IStatus.INFO) {
        setErrorMessage(null);
        setMessage(pageStatus.getMessage(), INFORMATION);
      } else {
        setErrorMessage(pageStatus.getMessage());
      }
      pageComplete = false;
    } else if (pageStatus.getSeverity() == IStatus.WARNING) {
      setErrorMessage(null);
      setMessage(pageStatus.getMessage(), WARNING);
    } else if (pageStatus.getSeverity() == IStatus.INFO) {
      setErrorMessage(null);
      setMessage(pageStatus.getMessage(), INFORMATION);
    }
    setPageComplete(pageComplete);
  }
}
