package com.devepos.adt.releasenotes.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import com.devepos.adt.releasenotes.internal.messages.Messages;

public class ReleaseNotesEditorInput implements IEditorInput, IPersistableElement {

  private final URL url;
  private final String plugin;
  private final String path;
  private final String tabTitle;

  public ReleaseNotesEditorInput(final IReleaseNotesConfig releaseNotesConfig) throws IOException {
    this(releaseNotesConfig.getPlugin(), releaseNotesConfig.getReleaseNotesPath(),
        releaseNotesConfig.getEditorTitle());
  }

  public ReleaseNotesEditorInput(final String plugin, final String path, final String tabTitle)
      throws IOException {
    this.plugin = plugin;
    this.path = path;
    this.tabTitle = tabTitle;
    var bundle = Platform.getBundle(plugin);
    if (bundle == null) {
      throw new FileNotFoundException("Plugin cannot be resolved: " + plugin); //$NON-NLS-1$
    }
    var bundleUrl = bundle.getEntry(path);
    url = FileLocator.toFileURL(bundleUrl);
    if (bundleUrl == null || url == null) {
      throw new FileNotFoundException(
          String.format("Path cannot be found in plugin: plugin=%s, path=%s", plugin, path)); //$NON-NLS-1$
    }
  }

  @Override
  public boolean exists() {
    return false;
  }

  @Override
  public <T> T getAdapter(final Class<T> adapter) {
    return null;
  }

  @Override
  public String getFactoryId() {
    return ReleaseNotesEditorInputPersist.FACTORY_ID;
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    return null;
  }

  @Override
  public String getName() {
    return url.toExternalForm();
  }

  public String getPath() {
    return path;
  }

  @Override
  public IPersistableElement getPersistable() {
    return this;
  }

  public String getPlugin() {
    return plugin;
  }

  public String getTabTitle() {
    return tabTitle + Messages.ReleaseNotesEditorInput_editorTitleSuffix_xtit;
  }

  @Override
  public String getToolTipText() {
    return tabTitle + Messages.ReleaseNotesEditorInput_editorTitleSuffix_xtit;
  }

  public URL getUrl() {
    return url;
  }

  @Override
  public void saveState(final IMemento memento) {
    ReleaseNotesEditorInputPersist.saveState(memento, this);
  }

}
