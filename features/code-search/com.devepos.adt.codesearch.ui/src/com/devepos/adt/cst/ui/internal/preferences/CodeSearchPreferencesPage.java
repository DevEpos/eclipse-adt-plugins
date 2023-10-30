package com.devepos.adt.cst.ui.internal.preferences;

import java.util.Collections;
import java.util.Map;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.devepos.adt.base.ui.preferences.FieldEditorPrefPageBase;
import com.devepos.adt.base.ui.preferences.LinkToAdtPageBlocksFactory;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
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

  @SuppressWarnings("rawtypes")
  @Override
  public void applyData(final Object data) {
    if (data instanceof Map) {
      Map<?, ?> options = (Map) data;
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

    createSearchDialogSettings(parent);
  }

  private Group createGroup(final String label, final Composite parent) {
    final Group group = new Group(parent, SWT.NONE);
    GridLayoutFactory.swtDefaults().applyTo(group);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(group);
    group.setText(label);
    return group;
  }

  private void createSearchDialogSettings(final Composite parent) {
    final Group group = createGroup(
        Messages.CodeSearchPreferencesPage_searchDialogSettingsGroup_xlbl, parent);

    final Group includeSettingsGroup = createGroup(
        Messages.CodeSearchPreferencesPage_dialogIncludeSettingsGroup_xlbl, group);
    addBooleanEditor(ICodeSearchPrefs.REMEMBER_INCLUDE_SETTINGS,
        Messages.CodeSearchPreferencesPage_useFromPreviousSearch_xchk,
        createEditorParent(includeSettingsGroup));

    final Group singlePatternModeGroup = createGroup(
        Messages.CodeSearchPreferencesPage_singlePatternModeSettingsGroup_xlbl, group);

    addEditor(addBooleanEditor(ICodeSearchPrefs.SINGLE_PATTERN_REGEX_CONCAT_WITH_LF,
        Messages.CodeSearchPreferencesPage_concatLinesWithLfRegexSinglePatternPref_xlbl,
        createEditorParent(singlePatternModeGroup)));
  }
}