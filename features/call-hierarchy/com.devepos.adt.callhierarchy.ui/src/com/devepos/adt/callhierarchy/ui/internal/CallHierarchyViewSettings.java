package com.devepos.adt.callhierarchy.ui.internal;

import org.eclipse.jface.preference.IPreferenceStore;

import com.devepos.adt.callhierarchy.ui.internal.preferences.IPreferences;

/**
 * Settings for call hierarchy view
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CallHierarchyViewSettings {

  private boolean showObjectDescriptions;
  private HierarchyViewerType hierarchyViewerType;

  public CallHierarchyViewSettings() {
    IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();

    showObjectDescriptions = prefStore.getBoolean(
        IPreferences.CALL_HIERARCHY_SHOW_OBJECT_DESCRIPTIONS);
    hierarchyViewerType = Enum.valueOf(HierarchyViewerType.class, prefStore.getString(
        IPreferences.CALL_HIERARCHY_VIEWER_TYPE));
  }

  public HierarchyViewerType getHierarchyViewerType() {
    return hierarchyViewerType;
  }

  public boolean isShowObjectDescriptions() {
    return showObjectDescriptions;
  }

  public void setHierarchyViewerType(String hierarchyViewerType) {
    this.hierarchyViewerType = Enum.valueOf(HierarchyViewerType.class, hierarchyViewerType);
  }

  public void setShowObjectDescriptions(final boolean showObjectDescriptions) {
    this.showObjectDescriptions = showObjectDescriptions;
  }
}
