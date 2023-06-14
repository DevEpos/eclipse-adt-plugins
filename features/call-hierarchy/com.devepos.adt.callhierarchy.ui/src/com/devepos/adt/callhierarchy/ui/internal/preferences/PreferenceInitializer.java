package com.devepos.adt.callhierarchy.ui.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.devepos.adt.base.ui.action.ViewLayoutOrientation;
import com.devepos.adt.callhierarchy.ui.internal.Activator;
import com.devepos.adt.callhierarchy.ui.internal.HierarchyViewerType;
import com.devepos.adt.callhierarchy.ui.internal.InterfaceMethodResolution;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

  public PreferenceInitializer() {
  }

  @Override
  public void initializeDefaultPreferences() {
    IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();

    prefStore.setDefault(IPreferences.MAX_HIERARCHY_HISTORY, 10);
    prefStore.setDefault(IPreferences.CALL_HIERARCHY_SHOW_OBJECT_DESCRIPTIONS, true);
    prefStore.setDefault(IPreferences.CALL_HIERARCHY_VIEWER_TYPE, HierarchyViewerType.TREE.name());
    prefStore.setDefault(IPreferences.CALL_HIERARCHY_VIEW_LAYOUT, ViewLayoutOrientation.AUTOMATIC
        .name());
    prefStore.setDefault(IPreferences.CALL_HIERARCHY_INTF_METHOD_RESOLUTION,
        InterfaceMethodResolution.DISABLED.name());
  }

}
