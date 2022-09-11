package com.devepos.adt.callhierarchy.ui.internal.preferences;

/**
 * Preferences keys for Call Hierarchy
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IPreferences {
  /**
   * Maximum number of history entries in Call Hierarchy view
   */
  String MAX_HIERARCHY_HISTORY = "com.devepos.adt.callhierarchy.maxHistorySize"; //$NON-NLS-1$
  /**
   * Type of the hierarchy viewer to be used
   */
  String CALL_HIERARCHY_VIEWER_TYPE = "com.devepos.adt.callhierarchy.hierarchyViewerType"; //$NON-NLS-1$
  /**
   * View layout in the hierarchy view
   */
  String CALL_HIERARCHY_VIEW_LAYOUT = "com.devepos.adt.callhierarchy.ui.callHierarchy.viewLayout"; //$NON-NLS-1$
  /**
   * Flag to control visibility of the object (methods, function module) descriptions
   */
  String CALL_HIERARCHY_SHOW_OBJECT_DESCRIPTIONS = "com.devepos.adt.callhierarchy.showObjectDescriptions"; //$NON-NLS-1$
  /**
   * Flag to indicate that interface methods in the hierarchy should be automatically resolved to
   * the first implementing class that is found
   */
  String CALL_HIERARCHY_INTF_METHOD_RESOLUTION = "com.devepos.adt.callhierarchy.api.interfaceMethodResolution"; //$NON-NLS-1$
}
