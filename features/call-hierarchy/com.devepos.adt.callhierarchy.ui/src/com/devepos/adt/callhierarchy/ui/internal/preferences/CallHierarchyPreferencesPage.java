package com.devepos.adt.callhierarchy.ui.internal.preferences;

import java.util.stream.Stream;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.devepos.adt.base.ui.preferences.FieldEditorPrefPageBase;
import com.devepos.adt.callhierarchy.ui.internal.Activator;
import com.devepos.adt.callhierarchy.ui.internal.HierarchyViewerType;
import com.devepos.adt.callhierarchy.ui.internal.InterfaceMethodResolution;

/**
 * Preferences for ABAP Call Hierarchy
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CallHierarchyPreferencesPage extends FieldEditorPrefPageBase implements
    IWorkbenchPreferencePage {

  public static final String PAGE_ID = "com.devepos.adt.callhierarchy.ui.preferences.CallHierarchyPreferencesPage";

  @Override
  public void init(final IWorkbench workbench) {
    setPreferenceStore(Activator.getDefault().getPreferenceStore());
  }

  @Override
  protected Control createContents(final Composite parent) {
    // HelpUtil.setHelp(parent, HelpContexts.CODE_SEARCH_PREFERENCES);
    return super.createContents(parent);
  }

  @Override
  protected void createPreferenceControls(final Composite parent) {
    createHierarchyServiceSettings(parent);
    createHierarchyViewSettings(parent);
  }

  private Group createGroup(final String label, final Composite parent) {
    final Group group = new Group(parent, SWT.NONE);
    GridLayoutFactory.swtDefaults().applyTo(group);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(group);
    group.setText(label);
    return group;
  }

  private void createHierarchyServiceSettings(Composite parent) {
    Group group = createGroup("Hierarchy Settings", parent);

    String[][] typeLabelsAndKeys = Stream.of(InterfaceMethodResolution.values())
        .map(type -> new String[] { type.getPrefLabel(), type.name() })
        .toArray(size -> new String[size][1]);

    addEditor(new ComboFieldEditor(IPreferences.CALL_HIERARCHY_INTF_METHOD_RESOLUTION,
        "Interface Method Resolution:", typeLabelsAndKeys, group));

    adjustMargins(group);
  }

  private void createHierarchyViewSettings(final Composite parent) {
    Group group = createGroup("View Settings", parent);

    addBooleanEditor(IPreferences.CALL_HIERARCHY_SHOW_OBJECT_DESCRIPTIONS,
        "Show Object Descriptions", null, group, 2, 1);

    String[][] typeLabelsAndKeys = Stream.of(HierarchyViewerType.values())
        .map(type -> new String[] { type.getPrefLabel(), type.name() })
        .toArray(size -> new String[size][1]);

    addEditor(new ComboFieldEditor(IPreferences.CALL_HIERARCHY_VIEWER_TYPE,
        "Hierarchy Viewer Type:", typeLabelsAndKeys, group));

    adjustMargins(group);
  }
}