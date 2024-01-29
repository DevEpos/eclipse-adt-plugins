package com.devepos.adt.searchfavorites.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import com.devepos.adt.searchfavorites.internal.Activator;
import com.devepos.adt.searchfavorites.internal.IExecutionModes;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

  @Override
  public void initializeDefaultPreferences() {
    var prefStore = Activator.getDefault().getPreferenceStore();

    prefStore.setDefault(IPreferences.MAKE_NEW_FAVS_VISIBLE, true);
    prefStore.setDefault(IPreferences.INSERT_NEW_FAVS_AT_START, false);
    prefStore.setDefault(IPreferences.FAV_EXEC_MODE_NO_MODIFIERS, IExecutionModes.RUN);
    prefStore.setDefault(IPreferences.FAV_EXEC_MODE_WITH_CTRL, IExecutionModes.OPEN_IN_DIALOG);
  }

}
