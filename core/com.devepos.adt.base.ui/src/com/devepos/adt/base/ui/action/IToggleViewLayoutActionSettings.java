package com.devepos.adt.base.ui.action;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Settings for ToggleViewLayoutAction
 *
 * @author Ludwig Stockbauer-Muhr
 * @see ToggleViewLayoutAction
 *
 */
public interface IToggleViewLayoutActionSettings {

  String getPrefKey();

  IPreferenceStore getPrefStore();

  String getSingleActionLabel();

  boolean isAutomaticEnabled();

  boolean isSingleEnabled();

  void setAllOptionsEnabled(boolean enableAll);

  void setAutomaticEnabled(boolean enabled);

  void setLayoutPrefOptions(IPreferenceStore prefStore, String prefKey);

  void setSingleActionLabel(String actionLabel);

  void setSingleEnabled(boolean enabled);
}
