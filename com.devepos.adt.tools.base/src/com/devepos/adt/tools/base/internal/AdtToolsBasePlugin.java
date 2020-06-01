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
		registerImage(imageRegistry, IAdtToolsBaseImages.REFRESH, "icons/Refresh.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.IMPORT, "icons/ImportWizard.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.EXPORT, "icons/ExportWizard.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.EXPAND_ALL, "icons/ExpandAll.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.COLLAPSE_ALL, "icons/CollapseAll.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.WAITING_INDICATOR, "icons/WaitingIndicator.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.EDIT_ACTION, "icons/EditMode.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.UNLOCK_ACTION, "icons/Unlock.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.SAP_GUI_OBJECT, "icons/SAPGUIObject.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.DATA_PREVIEW, "icons/DataPreview.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.WHERE_USED_LIST, "icons/WhereUsed.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.SEARCH, "icons/Search.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.RUN_OBJECT, "icons/RunObject.png");
		registerImage(imageRegistry, IAdtToolsBaseImages.OTHER_OBJECT, "icons/OtherObject.png");
	}

}
