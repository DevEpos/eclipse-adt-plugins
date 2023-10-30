package com.devepos.adt.base.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.dialogs.PreferencesUtil;

import com.devepos.adt.base.ui.internal.messages.Messages;

/**
 * Action to open preferences dialog at a given page
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class OpenPreferencesAction extends Action {
  private final String preferencePageId;

  public OpenPreferencesAction(final String preferencePageId) {
    this(Messages.OpenPreferencesAction_actionLabel_xlbl, preferencePageId);
  }

  public OpenPreferencesAction(final String label, final String preferencePageId) {
    super(label);
    this.preferencePageId = preferencePageId;
  }

  @Override
  public void run() {
    PreferencesUtil
        .createPreferenceDialogOn(null, preferencePageId, new String[] { preferencePageId },
            (Object) null)
        .open();
  }
}