package com.devepos.adt.base.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.ui.dialogs.PreferencesUtil;

import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.util.StringUtil;

/**
 * Opens the 'Colors and Fonts' preference page and select the given color
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class OpenColorPreferencePageAction extends Action {
  private static final String COLORS_AND_FONTS_PREFERENCES = "org.eclipse.ui.preferencePages.ColorsAndFonts";
  private String colorId;
  private String[] categories;

  public OpenColorPreferencePageAction() {
    this(Messages.OpenColorsAndFontsPreferences_xlbl);
  }

  public OpenColorPreferencePageAction(final String actionLabel) {
    super(actionLabel);
  }

  @Override
  public void run() {
    var hasCategories = categories != null && categories.length > 0;

    var prefDialog = PreferencesUtil.createPreferenceDialogOn(null, COLORS_AND_FONTS_PREFERENCES,
        new String[] { COLORS_AND_FONTS_PREFERENCES }, hasCategories ? null : colorId);

    if (hasCategories) {
      prefDialog.setBlockOnOpen(false);
      prefDialog.open();
      var selectedPage = prefDialog.getSelectedPage();
      if (selectedPage instanceof PreferencePage) {
        var prefPage = (PreferencePage) selectedPage;
        for (var category : categories) {
          prefPage.applyData(String.format("selectCategory:%s", category));
        }
        if (colorId != null) {
          prefPage.applyData(colorId);
        }
      }
    } else {
      prefDialog.open();
    }
  }

  /**
   * Sets the theme categories that shall be expanded upon opening of the preference page
   *
   * @param categories List of theme categories
   */
  public void setCategories(final String... categories) {
    this.categories = categories;
  }

  /**
   * Sets the color Id that shall be selected upon opening of the preference page
   *
   * @param colorId color id
   */
  public void setColorId(final String colorId) {
    this.colorId = !StringUtil.isEmpty(colorId) ? String.format("selectColor:%s", colorId) : null;
  }
}