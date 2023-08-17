package com.devepos.adt.releasenotes.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "com.devepos.adt.releasenotes"; //$NON-NLS-1$

  // The shared instance
  private static Activator plugin;

  private List<ReleaseNotesEditorConfigDescriptor> descriptors;

  /**
   * The constructor
   */
  public Activator() {
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

  public List<ReleaseNotesEditorConfigDescriptor> getEditorConfigDescriptors() {
    if (descriptors == null) {
      var elements = Platform.getExtensionRegistry()
          .getConfigurationElementsFor(PLUGIN_ID,
              ReleaseNotesEditorConfigDescriptor.EXTENSION_POINT);
      descriptors = new ArrayList<>();
      for (var element : elements) {
        descriptors.add(new ReleaseNotesEditorConfigDescriptor(element));
      }
    }
    return descriptors;
  }

  public Optional<ReleaseNotesEditorConfigDescriptor> getLatestReleaseNotesForPlugin(
      final String plugin) {
    return getEditorConfigDescriptors().stream()
        .filter(d -> d.getPlugin().equals(plugin))
        .findFirst();
  }

  /**
   * Logs exception as warning to eclipse log
   * 
   * @param exc error that occurred
   */
  public void logWarning(Exception exc) {
    getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, exc.getMessage(), exc));
  }

  @Override
  public void start(final BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  @Override
  public void stop(final BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }
}
