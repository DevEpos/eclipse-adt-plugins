package com.devepos.adt.tools.base.internal;

import org.eclipse.jface.resource.ImageRegistry;
import org.osgi.framework.BundleContext;

import com.devepos.adt.tools.base.IAdtToolsBaseImages;
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

	@Override
	protected void initializeImageRegistry(final ImageRegistry imageRegistry) {
		registerImage(imageRegistry, IAdtToolsBaseImages.REFRESH, "icons/full/elcl16/refresh.png", "org.eclipse.search");
		registerImage(imageRegistry, IAdtToolsBaseImages.IMPORT, "icons/full/etool16/import_wiz.png", "org.eclipse.ui");
		registerImage(imageRegistry, IAdtToolsBaseImages.EXPORT, "icons/full/etool16/export_wiz.png", "org.eclipse.ui");
		registerImage(imageRegistry, IAdtToolsBaseImages.EXPAND_ALL, "icons/full/elcl16/expandall.png", "org.eclipse.search");
		registerImage(imageRegistry, IAdtToolsBaseImages.COLLAPSE_ALL, "icons/full/elcl16/collapseall.png", "org.eclipse.search");
		registerImage(imageRegistry, IAdtToolsBaseImages.WAITING_INDICATOR, "icons/WaitingIndicator.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.EDIT_ACTION, "icons/EditMode.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.UNLOCK_ACTION, "icons/Unlock.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.SAP_GUI_OBJECT, "icons/SAPGUIObject.png");
	}

}
