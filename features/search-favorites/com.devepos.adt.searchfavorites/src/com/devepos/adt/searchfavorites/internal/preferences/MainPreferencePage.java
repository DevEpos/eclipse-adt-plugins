package com.devepos.adt.searchfavorites.internal.preferences;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.devepos.adt.base.ui.preferences.FieldEditorPrefPageBase;
import com.devepos.adt.searchfavorites.internal.Activator;
import com.devepos.adt.searchfavorites.internal.messages.Messages;

public class MainPreferencePage extends FieldEditorPrefPageBase implements IWorkbenchPreferencePage,
    IPropertyChangeListener {

  private Group dialogSettingsGroup;
  private BooleanFieldEditor makeNewFavsVisibleEditor;
  private BooleanFieldEditor insertNewFavsAtBeginningEditor;

  @Override
  public void init(final IWorkbench workbench) {
    setPreferenceStore(Activator.getDefault().getPreferenceStore());
  }

  @Override
  protected void createPreferenceControls(final Composite parent) {
    createSettings(parent);
  }

  /**
   * Creates group with search settings
   *
   * @param parent the parent composite
   */
  private void createSettings(final Composite parent) {
    dialogSettingsGroup = new Group(parent, SWT.NONE);
    dialogSettingsGroup.setText(Messages.MainPreferencePage_NewFavSettings_xgrp);
    GridDataFactory.fillDefaults().span(2, 1).applyTo(dialogSettingsGroup);
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(dialogSettingsGroup);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(dialogSettingsGroup);

    makeNewFavsVisibleEditor = addBooleanEditor(IPreferences.MAKE_NEW_FAVS_VISIBLE,
        Messages.MainPreferencePage_MakeNewFavsVisible_xchk, null, dialogSettingsGroup, 2, 1);
    insertNewFavsAtBeginningEditor = addBooleanEditor(IPreferences.INSERT_NEW_FAVS_AT_START,
        Messages.MainPreferencePage_InsertNewFavsAtStart_xchk, null, dialogSettingsGroup, 2, 1);

    adjustMargins(dialogSettingsGroup);

    /*
     * Layout of group needs to be set at last as the field editors will change it
     * final during their creation
     */
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(dialogSettingsGroup);
  }

  @Override
  protected void initFields() {
    super.initFields();

    insertNewFavsAtBeginningEditor.setEnabled(makeNewFavsVisibleEditor.getBooleanValue(),
        dialogSettingsGroup);
  }

  @Override
  protected void fieldValueChanged(FieldEditor field, Object oldValue, Object newValue) {
    if (field == makeNewFavsVisibleEditor) {
      insertNewFavsAtBeginningEditor.setEnabled((boolean) newValue, dialogSettingsGroup);
    }
  }

}