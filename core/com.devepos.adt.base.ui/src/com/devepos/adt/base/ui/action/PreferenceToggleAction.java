package com.devepos.adt.base.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;

import com.devepos.adt.base.util.Logging;

/**
 * Action which holds a boolean value from a {@link IPreferenceStore}
 *
 * @author stockbal
 */
public class PreferenceToggleAction extends Action {
  protected final IPreferenceStore prefStore;
  private final String preferenceKey;

  public PreferenceToggleAction(final String text, final ImageDescriptor imageDescriptor,
      final String preferenceKey, final boolean defaultPreferenceValue,
      final IPreferenceStore prefStore) {
    super(text, IAction.AS_CHECK_BOX);
    setImageDescriptor(imageDescriptor);
    this.prefStore = prefStore;
    this.preferenceKey = preferenceKey;
    this.prefStore.setDefault(this.preferenceKey, defaultPreferenceValue);
    this.prefStore.addPropertyChangeListener(e -> {
      if (e.getProperty().equals(preferenceKey)) {
        setChecked((boolean) e.getNewValue());
      }
    });
    final boolean checked = this.prefStore.getBoolean(this.preferenceKey);
    setChecked(checked);
  }

  /**
   * Returns the preference key this action toggles
   *
   * @return
   */
  public String getPreferenceKey() {
    return preferenceKey;
  }

  @Override
  public final void run() {
    try {
      final boolean checked = isChecked();
      prefStore.setValue(preferenceKey, checked);
      toggled(checked);
    } catch (final Exception e) {
      Logging.getLogger(getClass()).error(e);
    }
  }

  @Override
  public void setChecked(final boolean checked) {
    super.setChecked(checked);
    prefStore.setValue(preferenceKey, checked);
  }

  /**
   * Will be called with the new value of the toggle action
   * <p>
   * Default implementation does nothing. Subclasses may override
   * </p>
   *
   * @param checked if <code>true</code> the action is checked
   */
  protected void toggled(final boolean checked) {
  }
}
