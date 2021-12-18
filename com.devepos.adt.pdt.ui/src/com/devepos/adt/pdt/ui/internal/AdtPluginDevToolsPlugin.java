package com.devepos.adt.pdt.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class AdtPluginDevToolsPlugin extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "com.devepos.adt.pdt.ui"; //$NON-NLS-1$

  // The shared instance
  private static AdtPluginDevToolsPlugin plugin;

  /**
   * The constructor
   */
  public AdtPluginDevToolsPlugin() {
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

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static AdtPluginDevToolsPlugin getDefault() {
    return plugin;
  }

}
