package com.devepos.adt.releasenotes.internal;

import java.net.URL;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.part.EditorPart;

/**
 * Release notes editor
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class ReleaseNotesEditor extends EditorPart {
  public static final String EDITOR_ID = "com.devepos.adt.releasenotes.editor";

  private ReleaseNotesEditorInput editorInput;
  private Browser browser;

  public ReleaseNotesEditor() {
  }

  @Override
  public void createPartControl(final Composite parent) {
    parent.setLayout(GridLayoutFactory.fillDefaults().create());
    browser = new Browser(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(browser);
    browser.addLocationListener(new LocationAdapter() {
      @Override
      public void changing(final LocationEvent event) {
        try {
          if (event.location.startsWith("file:")) {
            URL url;
            url = new URL(event.location);

            var pattern = Pattern.compile(".*/PLUGINS_ROOT/(.*)/html/(.*).html.*");
            var matcher = pattern.matcher(url.getPath());
            String pluginId;
            String fileName;
            if (matcher.find()) {
              pluginId = matcher.group(1);
              fileName = matcher.group(2);
              String helpContextIdx = pluginId + '.' + fileName;

              IWorkbenchHelpSystem helpSystemx = PlatformUI.getWorkbench().getHelpSystem();
              helpSystemx.displayHelp(helpContextIdx);
              event.doit = false;
            }
          }
        } catch (Exception e) {
        }
      }
    });
    String url = editorInput.getUrl().toExternalForm();
    browser.setUrl(url);
  }

  @Override
  public void doSave(final IProgressMonitor monitor) {
  }

  @Override
  public void doSaveAs() {
  }

  @Override
  public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
    editorInput = (ReleaseNotesEditorInput) input;
    setSite(site);
    setInput(input);
    setPartName(editorInput.getTabTitle());
  }

  @Override
  public boolean isDirty() {
    return false;
  }

  @Override
  public boolean isSaveAsAllowed() {
    return false;
  }

  @Override
  public void setFocus() {
    if (browser != null && !browser.isDisposed()) {
      browser.setFocus();
    }
  }
}
