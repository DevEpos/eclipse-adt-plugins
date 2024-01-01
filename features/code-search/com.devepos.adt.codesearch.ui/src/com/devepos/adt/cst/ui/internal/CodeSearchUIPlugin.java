package com.devepos.adt.cst.ui.internal;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IDecoration;
import org.osgi.framework.BundleContext;

import com.devepos.adt.base.ui.plugin.AbstractAdtUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class CodeSearchUIPlugin extends AbstractAdtUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "com.devepos.adt.codesearch.ui"; //$NON-NLS-1$

  // The shared instance
  private static CodeSearchUIPlugin plugin;

  /**
   * The constructor
   */
  public CodeSearchUIPlugin() {
    super(PLUGIN_ID);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static CodeSearchUIPlugin getDefault() {
    return plugin;
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

  @Override
  protected void initializeImageRegistry(final ImageRegistry reg) {
    registerImage(reg, IImages.CODE_SEARCH, "icons/codesearch.png");
    registerImage(reg, IImages.STATUS, "icons/full/progress/progress_task.png", "org.eclipse.ui");
    registerImage(reg, IImages.TRANSPORT_TASK, "icons/obj/transport_task.png", "com.sap.adt.tm.ui");
    registerImage(reg, IImages.TRANSPORT_REQUEST, "icons/obj/transport_request.png",
        "com.sap.adt.tm.ui");
    registerImage(reg, IImages.OVR_TRANSPORT_RELEASED, "icons/taskoverlay_released.png",
        "com.sap.adt.tm.ui");

    overlayImage(reg.get(IImages.TRANSPORT_REQUEST), IImages.TRANSPORT_REQUEST_RELEASED,
        reg.get(IImages.OVR_TRANSPORT_RELEASED), IDecoration.BOTTOM_LEFT);
    overlayImage(reg.get(IImages.TRANSPORT_TASK), IImages.TRANSPORT_TASK_RELEASED,
        reg.get(IImages.OVR_TRANSPORT_RELEASED), IDecoration.BOTTOM_LEFT);
  }

}
