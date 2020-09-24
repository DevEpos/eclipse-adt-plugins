package com.devepos.adt.tools.base.internal;

import org.osgi.framework.BundleContext;

import com.devepos.adt.tools.base.plugin.AbstractAdtUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class AdtToolsBasePlugin extends AbstractAdtUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.devepos.adt.tools.base"; //$NON-NLS-1$

	// The shared instance
	private static AdtToolsBasePlugin plugin;

	/**
	 * The constructor
	 */
	public AdtToolsBasePlugin() {
		super(PLUGIN_ID);
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
	public static AdtToolsBasePlugin getDefault() {
		return plugin;
	}
}
