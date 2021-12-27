package com.devepos.adt.base.ui.internal;

import org.eclipse.jface.resource.ImageRegistry;
import org.osgi.framework.BundleContext;

import com.devepos.adt.base.plugin.AbstractAdtUIPlugin;
import com.devepos.adt.base.ui.IAdtBaseImages;

/**
 * The activator class controls the plug-in life cycle
 */
public class AdtBaseUIPlugin extends AbstractAdtUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "com.devepos.adt.base.ui"; //$NON-NLS-1$

  // The shared instance
  private static AdtBaseUIPlugin plugin;

  /**
   * The constructor
   */
  public AdtBaseUIPlugin() {
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
  public static AdtBaseUIPlugin getDefault() {
    return plugin;
  }

  @Override
  protected void initializeImageRegistry(final ImageRegistry imageRegistry) {
    registerImage(imageRegistry, IAdtBaseImages.ARROW_DOWN, "icons/ArrowDown.png");
    registerImage(imageRegistry, IAdtBaseImages.ARROW_UP, "icons/ArrowUp.png");
    registerImage(imageRegistry, IAdtBaseImages.REFRESH, "icons/full/elcl16/refresh.png",
        "org.eclipse.search");
    registerImage(imageRegistry, IAdtBaseImages.EXPORT, "icons/full/etool16/export_wiz.png",
        "org.eclipse.ui.ide");
    registerImage(imageRegistry, IAdtBaseImages.IMPORT, "icons/full/etool16/import_wiz.png",
        "org.eclipse.ui.ide");
    registerImage(imageRegistry, IAdtBaseImages.EXPAND_ALL, "icons/full/elcl16/expandall.png",
        "org.eclipse.search");
    registerImage(imageRegistry, IAdtBaseImages.COLLAPSE_ALL, "icons/full/elcl16/collapseall.png",
        "org.eclipse.search");
    registerImage(imageRegistry, IAdtBaseImages.WAITING_INDICATOR, "icons/WaitingIndicator.png");
    registerImage(imageRegistry, IAdtBaseImages.EDIT_ACTION, "icons/EditMode.png");
    registerImage(imageRegistry, IAdtBaseImages.UNLOCK_ACTION, "icons/Unlock.png");
    registerImage(imageRegistry, IAdtBaseImages.SAP_GUI_OBJECT, "icons/SAPGUIObject.png");
    registerImage(imageRegistry, IAdtBaseImages.DATA_PREVIEW, "icons/DataPreview.png");
    registerImage(imageRegistry, IAdtBaseImages.WHERE_USED_LIST, "icons/etool/where_used.png",
        "com.sap.adt.ris.whereused.ui");
    registerImage(imageRegistry, IAdtBaseImages.SEARCH, "icons/full/etool16/search.png",
        "org.eclipse.search");
    registerImage(imageRegistry, IAdtBaseImages.RUN_OBJECT, "icons/full/obj16/lrun_obj.png",
        "org.eclipse.debug.ui");
    registerImage(imageRegistry, IAdtBaseImages.OTHER_OBJECT, "icons/OtherObject.png");
    registerImage(imageRegistry, IAdtBaseImages.AUTOMATIC_LAYOUT,
        "icons/full/elcl16/automaticOrientation.png", "org.eclipse.search");
    registerImage(imageRegistry, IAdtBaseImages.HORIZONTAL_LAYOUT,
        "icons/full/elcl16/horizontalOrientation.png", "org.eclipse.search");
    registerImage(imageRegistry, IAdtBaseImages.VERTICAL_LAYOUT,
        "icons/full/elcl16/verticalOrientation.png", "org.eclipse.search");
    registerImage(imageRegistry, IAdtBaseImages.TRANSPORT, "icons/Transport.png");
    registerImage(imageRegistry, IAdtBaseImages.SHARE, "icons/Share.png");
    registerImage(imageRegistry, IAdtBaseImages.SHARE_OVR, "icons/ovr/Share.png");
    registerImage(imageRegistry, IAdtBaseImages.USER, "com.sap.adt.tools.core.ui",
        "icons/obj/useredit.png");
    registerImage(imageRegistry, IAdtBaseImages.USER_PROPS, "com.sap.adt.tools.core.ui",
        "icons/obj/useredit.png");
    registerImage(imageRegistry, IAdtBaseImages.DELETE_OVR, "icons/ovr/Delete.png");
    registerImage(imageRegistry, IAdtBaseImages.VIEW_MENU, "icons/ViewMenu.png");
    registerImage(imageRegistry, IAdtBaseImages.FILTER, "icons/full/elcl16/filter_ps.png",
        "org.eclipse.search");
    registerImage(imageRegistry, IAdtBaseImages.SEARCH_MATCH, "icons/full/obj16/searchm_obj.png",
        "org.eclipse.search");
    registerImage(imageRegistry, IAdtBaseImages.PACKAGE_PARAM, "icons/obj/package_obj.png",
        "com.sap.adt.tools.core.ui");
    registerDeleteOvr(imageRegistry);
  }

  private void registerDeleteOvr(final ImageRegistry imageRegistry) {
    imageRegistry.put(IAdtBaseImages.UNSHARE, overlayImage(imageRegistry.get(IAdtBaseImages.SHARE),
        new String[] { null, null, null, IAdtBaseImages.DELETE_OVR }));

  }

}
