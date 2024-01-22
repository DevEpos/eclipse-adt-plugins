package com.devepos.adt.searchfavorites.internal.preferences;

public interface IPreferences {

  /**
   * Setting to always make new favorite visible
   */
  String MAKE_NEW_FAVS_VISIBLE = "com.devepos.adt.searchfavorite.makeNewFavVisible";

  /**
   * Setting to insert new favorites at the start of the list instead of the end
   */
  String INSERT_NEW_FAVS_AT_START = "com.devepos.adt.searchfavorites.insertNewFavAtStart";

  /**
   * Execution mode for favorite when no modifier keys are pressed
   */
  String FAV_EXEC_MODE_NO_MODIFIERS = "com.devepos.adt.searchfavorites.favExecModeNoModifiers";

  /**
   * Execution mode for favorite when CTRL is pressed
   */
  String FAV_EXEC_MODE_WITH_CTRL = "com.devepos.adt.searchfavorites.favExecModeWithCtrl";
}
