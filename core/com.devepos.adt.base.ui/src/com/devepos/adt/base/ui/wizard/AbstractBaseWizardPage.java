package com.devepos.adt.base.ui.wizard;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Rectangle;

/**
 * Abstract wizard page implementation with additional methods for status
 * handling, etc.
 *
 * @author stockbal
 */
public abstract class AbstractBaseWizardPage extends WizardPage implements IBaseWizardPage {
  private boolean isDirty = true;
  private Rectangle preferredShellSize;
  private ShellListener shellListener;
  private boolean autoPreferredSize = true;

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

  @Override
  public void setVisible(final boolean visible) {
    super.setVisible(visible);
    if (visible) {
      storePreferredShellSize();
      if (autoPreferredSize) {
        setPreferredShellSize();
      }
    }
  }

  /**
   * Sets flag to control whether the preferred size should be automatically set once the page is
   * made visible
   * 
   * @param autoPreferredSize
   */
  protected void setAutoPreferredSize(final boolean autoPreferredSize) {
    this.autoPreferredSize = autoPreferredSize;
  }

  /**
   * Updates the page completion indicator depending on the given status object
   *
   * @param pageStatus the status of a page validation
   */
  protected void updatePageCompletedStatus(final IStatus pageStatus) {
    var pageComplete = true;
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

  protected void storePreferredShellSize() {
    if (preferredShellSize == null) {
      var shell = getShell();
      if (shell.isVisible()) {
        preferredShellSize = shell.getBounds();
      } else {
        shellListener = new ShellAdapter() {
          @Override
          public void shellActivated(final ShellEvent e) {
            preferredShellSize = shell.getBounds();
            shell.removeShellListener(shellListener);
            shellListener = null;
          }
        };
        shell.addShellListener(shellListener);
      }
    }
  }

  protected Rectangle getPreferredShellSize() {
    return preferredShellSize;
  }

  /**
   * Restores the shell of the wizard dialog to the preferred size
   * for the page
   */
  protected void setPreferredShellSize() {
    if (preferredShellSize == null) {
      return;
    }
    var size = getShell().getSize();
    if (size.x < preferredShellSize.width || size.x > preferredShellSize.width
        || size.y < preferredShellSize.height || size.y > preferredShellSize.height) {
      getShell().setSize(preferredShellSize.width, preferredShellSize.height);
    }
  }
}
