package com.devepos.adt.cst.ui.internal.preferences;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.devepos.adt.base.ui.preferences.FieldEditorPrefPageBase;
import com.devepos.adt.base.ui.preferences.LinkToAdtPageBlocksFactory;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.codesearch.ReleasedRequestDate;
import com.devepos.adt.cst.ui.internal.help.HelpContexts;
import com.devepos.adt.cst.ui.internal.help.HelpUtil;
import com.devepos.adt.cst.ui.internal.messages.Messages;
import com.devepos.adt.cst.ui.internal.pages.CodeSearchPropertyPage;

/**
 * Preferences for the code search
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class CodeSearchPreferencesPage extends FieldEditorPrefPageBase
    implements IWorkbenchPreferencePage {

  public static final String PAGE_ID = "com.devepos.adt.codesearch.ui.preferences.CodeSearchPreferencesPage"; //$NON-NLS-1$
  private Control linkToPropPageCtrl;
  private BooleanFieldEditor modifiableRequestsEditor;
  private BooleanFieldEditor releasedRequestsEditor;

  @SuppressWarnings("rawtypes")
  @Override
  public void applyData(final Object data) {
    if (data instanceof Map) {
      var options = (Map) data;
      boolean omit = Boolean.TRUE
          .equals(options.get(LinkToAdtPageBlocksFactory.NO_PROP_PAGE_LINK_KEY));
      if (omit && linkToPropPageCtrl != null && !linkToPropPageCtrl.isDisposed()) {
        linkToPropPageCtrl.setVisible(false);
        ((GridData) linkToPropPageCtrl.getLayoutData()).exclude = true;
        linkToPropPageCtrl.getParent().layout();
      }
    }
  }

  @Override
  public void init(final IWorkbench workbench) {
    setPreferenceStore(CodeSearchUIPlugin.getDefault().getPreferenceStore());
  }

  @Override
  protected Control createContents(final Composite parent) {
    HelpUtil.setHelp(parent, HelpContexts.CODE_SEARCH_PREFERENCES);
    return super.createContents(parent);
  }

  @Override
  protected void createPreferenceControls(final Composite parent) {
    var linkToPropertyPage = LinkToAdtPageBlocksFactory.createLinkToPropertyPage(
        CodeSearchPropertyPage.PAGE_ID,
        Collections.singletonMap(LinkToAdtPageBlocksFactory.NO_PREF_PAGE_LINK_KEY, true));
    linkToPropPageCtrl = linkToPropertyPage.createControl(parent,
        GridDataFactory.fillDefaults().align(SWT.RIGHT, SWT.FILL).create());

    createClientSearchSettings(parent);
    createSearchDialogSettings(parent);
  }

  @Override
  protected void fieldValueChanged(final FieldEditor field, final Object oldValue,
      final Object newValue) {
    if (!ICodeSearchPrefs.TR_FILTER_INCLUDE_MODIFIABLE.equals(field.getPreferenceName())
        && !ICodeSearchPrefs.TR_FILTER_INCLUDE_RELEASED.equals(field.getPreferenceName())) {

      return;
    }
    if (!(Boolean) newValue) {
      if (!modifiableRequestsEditor.getBooleanValue()
          && !releasedRequestsEditor.getBooleanValue()) {
        setErrorMessage(
            MessageFormat.format(Messages.CodeSearchPreferencesPage_StatusMandatoryError_xmsg,
                modifiableRequestsEditor.getLabelText().replace("&", ""),
                releasedRequestsEditor.getLabelText().replace("&", "")));
        setValid(false);
      }
    } else {
      setValid(true);
      setErrorMessage(null);
    }
  }

  private Group createGroup(final String label, final Composite parent) {
    final var group = new Group(parent, SWT.NONE);
    GridLayoutFactory.swtDefaults().applyTo(group);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(group);
    group.setText(label);
    return group;
  }

  private void createClientSearchSettings(Composite parent) {
    final var group = createGroup("Client Based Search Settings", parent);

    final var maxJobsEditor = new IntegerFieldEditor(ICodeSearchPrefs.MAX_CLIENT_SEARCH_JOBS,
        "Max. number of Jobs (Threads):", createEditorParent(group), 2);
    maxJobsEditor.setValidRange(1, 20);
    addEditor(maxJobsEditor);

    addBooleanEditor(ICodeSearchPrefs.PREFER_CLIENT_BASED_SEARCH, "Prefer client based search",
        createEditorParent(group));

    adjustMargins(group);
  }

  private void createSearchDialogSettings(final Composite parent) {
    final var group = createGroup(Messages.CodeSearchPreferencesPage_searchDialogSettingsGroup_xlbl,
        parent);

    final var includeSettingsGroup = createGroup(
        Messages.CodeSearchPreferencesPage_dialogIncludeSettingsGroup_xlbl, group);
    addBooleanEditor(ICodeSearchPrefs.REMEMBER_INCLUDE_SETTINGS,
        Messages.CodeSearchPreferencesPage_useFromPreviousSearch_xchk,
        createEditorParent(includeSettingsGroup));

    final var singlePatternModeGroup = createGroup(
        Messages.CodeSearchPreferencesPage_singlePatternModeSettingsGroup_xlbl, group);

    addEditor(addBooleanEditor(ICodeSearchPrefs.SINGLE_PATTERN_REGEX_CONCAT_WITH_LF,
        Messages.CodeSearchPreferencesPage_concatLinesWithLfRegexSinglePatternPref_xlbl,
        createEditorParent(singlePatternModeGroup)));

    final var requestFilterSettings = createGroup(
        Messages.CodeSearchPreferencesPage_TransportRequestSettings_xgrp, group);

    createTransportRequestFilterSettings(requestFilterSettings);

    adjustMargins(group);
  }

  private void createTransportRequestFilterSettings(final Composite parent) {
    addBooleanEditor(ICodeSearchPrefs.TR_FILTER_ONLY_MY_OBJECTS,
        Messages.CodeSearchPreferencesPage_LoggedOnUserRestriction_xchk,
        createEditorParent(parent));

    var statusGroup = createGroup(Messages.CodeSearchPreferencesPage_RequestStatus_xgrp, parent);

    modifiableRequestsEditor = addBooleanEditor(ICodeSearchPrefs.TR_FILTER_INCLUDE_MODIFIABLE,
        Messages.CodeSearchPreferencesPage_ModifiableStatus_xchk, createEditorParent(statusGroup));

    var releasedRequestsEditorParent = createEditorParent(statusGroup);

    releasedRequestsEditor = addBooleanEditor(ICodeSearchPrefs.TR_FILTER_INCLUDE_RELEASED,
        Messages.CodeSearchPreferencesPage_ReleasedStatus_xchk, releasedRequestsEditorParent);
    addReleasedRequestEditor(releasedRequestsEditorParent);
  }

  private void addReleasedRequestEditor(final Composite releasedRequestsEditorParent) {
    var releaseDateFilters = Stream.of(ReleasedRequestDate.values())
        .map(mode -> new String[] { mode.toString(), mode.name() })
        .toArray(size -> new String[size][1]);

    var dateEditor = new ComboFieldEditor(ICodeSearchPrefs.TR_FILTER_RELEASED_DATE, "", //$NON-NLS-1$
        releaseDateFilters, releasedRequestsEditorParent);
    addEditor(dateEditor);

    // exclude empty label from layout
    var label = dateEditor.getLabelControl(releasedRequestsEditorParent);
    var gridData = (GridData) label.getLayoutData();
    gridData.exclude = true;

    // adjust grid of editor parent
    var gridLayout = (GridLayout) releasedRequestsEditorParent.getLayout();
    gridLayout.numColumns = 2;
  }
}