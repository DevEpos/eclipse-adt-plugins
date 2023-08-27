package com.devepos.adt.saat.ui.internal.preferences;

import java.util.stream.Stream;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.devepos.adt.base.ui.preferences.FieldEditorPrefPageBase;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.messages.Messages;

public class ObjectSearchPreferencePage extends FieldEditorPrefPageBase implements
    IWorkbenchPreferencePage, IPropertyChangeListener {

  @Override
  public void init(final IWorkbench workbench) {
    setPreferenceStore(SearchAndAnalysisPlugin.getDefault().getPreferenceStore());
  }

  @Override
  protected void createPreferenceControls(final Composite parent) {
    createSearchSettings(parent);
  }

  /**
   * Creates group with search settings
   *
   * @param parent the parent composite
   */
  private void createSearchSettings(final Composite parent) {
    GridDataFactory.fillDefaults().grab(true, false).applyTo(parent);

    var dialogSettingsGroup = new Group(parent, SWT.NONE);
    dialogSettingsGroup.setText(Messages.ObjectSearchPreferencePage_searchDialogSettings_xgrp);
    GridDataFactory.fillDefaults().span(2, 1).applyTo(dialogSettingsGroup);
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(dialogSettingsGroup);

    final FieldEditor maxSearchResultsEditor = new IntegerFieldEditor(
        IPreferences.MAX_SEARCH_RESULTS, Messages.MainPreferencePage_MaxResultsSetting_xfld,
        dialogSettingsGroup, 4);
    fields.add(maxSearchResultsEditor);

    // create combo editor for default search type
    // TODO: move to new project specific preference page
    // final FieldEditor defaultSearchTypeEditor = new ComboFieldEditor(
    // IPreferences.DEFAULT_SEARCH_TYPE, Messages.MainPreferencePage_DefaultSearchTypeSetting_xfld,
    // SearchType.toNamesAndKeys(), parent);
    // fields.add(defaultSearchTypeEditor);

    addBooleanEditor(IPreferences.CURSOR_AT_END_OF_SEARCH_INPUT,
        Messages.MainPreferencePage_CursorAtEndSetting_xfld, null, dialogSettingsGroup, 2, 1);
    addBooleanEditor(IPreferences.TAKE_TEXT_SELECTION_INTO_SEARCH,
        Messages.MainPreferencePage_UseCurrentTextSelectionForObjName_xfld, null,
        dialogSettingsGroup, 2, 1);
    addBooleanEditor(IPreferences.OVERWRITE_OPENED_SEARCH_QUERY,
        Messages.MainPreferencePage_OverwriteSearchQuerySetting_xfld, null, dialogSettingsGroup, 2,
        1);

    var focusNamesAndLabels = Stream.of(InitialSearchFocus.values())
        .map(val -> new String[] { val.getLabel(), val.getPrefKey() })
        .toArray(size -> new String[size][1]);

    addEditor(new RadioGroupFieldEditor(IPreferences.INITIAL_CONTROL_FOCUS,
        Messages.ObjectSearchPreferencePage_initialControlFocus_xgrp, 1, focusNamesAndLabels,
        dialogSettingsGroup, true));

    adjustMargins(dialogSettingsGroup);

    /*
     * Layout of group needs to be set at last as the field editors will change it
     * final during their creation
     */
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(dialogSettingsGroup);
  }
}