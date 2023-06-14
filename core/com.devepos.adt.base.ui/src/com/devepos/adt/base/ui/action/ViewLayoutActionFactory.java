package com.devepos.adt.base.ui.action;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Control;

public class ViewLayoutActionFactory {

  private static ViewLayoutActionFactory INSTANCE;

  private ViewLayoutActionFactory() {
    // singleton
  }

  private static class ToggleViewLayoutActionSettings implements IToggleViewLayoutActionSettings {

    private boolean automaticEnabled;
    private boolean singleEnabled;
    private String prefKey;

    private String singleActionLabel;

    private IPreferenceStore prefStore;

    @Override
    public String getPrefKey() {
      return prefKey;
    }

    @Override
    public IPreferenceStore getPrefStore() {
      return prefStore;
    }

    @Override
    public String getSingleActionLabel() {
      return singleActionLabel;
    }

    @Override
    public boolean isAutomaticEnabled() {
      return automaticEnabled;
    }

    @Override
    public boolean isSingleEnabled() {
      return singleEnabled;
    }

    @Override
    public void setAllOptionsEnabled(final boolean enableAll) {
      automaticEnabled = enableAll;
      singleEnabled = enableAll;
    }

    @Override
    public void setAutomaticEnabled(final boolean enabled) {
      automaticEnabled = enabled;
    }

    @Override
    public void setLayoutPrefOptions(final IPreferenceStore prefStore, final String prefKey) {
      this.prefKey = prefKey;
      this.prefStore = prefStore;
    }

    @Override
    public void setSingleActionLabel(final String actionLabel) {
      singleActionLabel = actionLabel;
    }

    @Override
    public void setSingleEnabled(final boolean enabled) {
      singleEnabled = enabled;
    }
  }

  public static ViewLayoutActionFactory getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ViewLayoutActionFactory();
    }
    return INSTANCE;
  }

  /**
   * Creates default settings instance for ToggleViewLayoutAction
   *
   * @return default settings
   */
  public IToggleViewLayoutActionSettings createDefaultSettings() {
    IToggleViewLayoutActionSettings settings = new ToggleViewLayoutActionSettings();
    settings.setAllOptionsEnabled(true);
    settings.setSingleEnabled(false);
    return settings;
  }

  /**
   * Creates settings instance for ToggleViewLayoutAction
   *
   * @return settings instance
   */
  public IToggleViewLayoutActionSettings createSettings() {
    return new ToggleViewLayoutActionSettings();
  }

  /**
   * Creates Action for switching the layout of a View with a sash form. The Action will be created
   * with the default layout options {@link ViewLayoutOrientation#VERTICAL},
   * {@link ViewLayoutOrientation#HORIZONTAL} and {@link ViewLayoutOrientation#AUTOMATIC}
   *
   * @param sashForm       the splitter composite
   * @param resizedControl the control that listens for resize events
   * @return the created action
   */
  public ToggleViewLayoutAction createToggleViewLayoutAction(final SashForm sashForm,
      final Control resizedControl) {
    return createToggleViewLayoutAction(sashForm, resizedControl, createDefaultSettings());
  }

  /**
   * Creates Action for switching the layout of a View with a sash form. The {@code settings}
   * instance will be used to configure the action. It can be created via {@link #createSettings()}
   *
   * @param sashForm       the splitter composite
   * @param resizedControl the control that listens for resize events
   * @param settings       settings instance to configure the action behavior
   * @return the created action
   */
  public ToggleViewLayoutAction createToggleViewLayoutAction(final SashForm sashForm,
      final Control resizedControl, final IToggleViewLayoutActionSettings settings) {
    Assert.isNotNull(sashForm);
    Assert.isNotNull(resizedControl);
    Assert.isNotNull(settings);
    return new ToggleViewLayoutAction(sashForm, resizedControl, settings);
  }
}
