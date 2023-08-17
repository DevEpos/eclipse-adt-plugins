package com.devepos.adt.releasenotes.internal;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.progress.UIJob;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.prefs.BackingStoreException;

import com.devepos.adt.releasenotes.internal.messages.Messages;

public class Startup implements IStartup {

  @Override
  public void earlyStartup() {
    var preferences = InstanceScope.INSTANCE.getNode(FrameworkUtil.getBundle(Startup.class)
        .getSymbolicName());
    for (var descriptor : Activator.getDefault().getEditorConfigDescriptors()) {
      var oldReleaseNotes = preferences.get(descriptor.getPlugin(), (String) null);
      if (oldReleaseNotes == null || !oldReleaseNotes.equals(descriptor.getReleaseNotesId())) {
        preferences.put(descriptor.getPlugin(), descriptor.getReleaseNotesId());
        try {
          preferences.flush();
        } catch (BackingStoreException e) {
          Activator.getDefault().logWarning(e);
        }
        openReleaseNotesAsync(descriptor);
      }
    }
  }

  private void openReleaseNotes(final IReleaseNotesConfig releaseNotesConfig) throws IOException,
      PartInitException {
    var editorInput = new ReleaseNotesEditorInput(releaseNotesConfig);
    IWorkbenchPage activePage = PlatformUI.getWorkbench()
        .getActiveWorkbenchWindow()
        .getActivePage();
    IDE.openEditor(activePage, editorInput, ReleaseNotesEditor.EDITOR_ID, true);
  }

  private void openReleaseNotesAsync(final IReleaseNotesConfig releaseNotesConfig) {
    var uiJob = new UIJob(Messages.Startup_releaseNotesJobPrefix_xmsg + releaseNotesConfig
        .getEditorTitle()) {
      @Override
      public IStatus runInUIThread(final IProgressMonitor monitor) {
        try {
          openReleaseNotes(releaseNotesConfig);
        } catch (Exception e) {
          Activator.getDefault().logWarning(e);
        }

        return Status.OK_STATUS;
      }
    };
    uiJob.setSystem(true);
    uiJob.schedule();
  }
}
