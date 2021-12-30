package com.devepos.adt.base.ui.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 * Base class to be used for preference pages that are using {@link FieldEditor}
 * as input controls to edit preferences. <br>
 * The class {@link FieldEditorPreferencePage} is not suitably as the access to
 * the actually created field editors is very restricted. The mentioned class
 * also does not allow to create the editors in {@link Group} controls
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public abstract class FieldEditorPrefPageBase extends PreferencePage implements
    IPropertyChangeListener {

  protected final List<FieldEditor> fields = new ArrayList<>();

  @Override
  public void dispose() {
    super.dispose();

    for (FieldEditor editor : fields) {
      editor.setPage(null);
      editor.setPropertyChangeListener(null);
      editor.setPreferenceStore(null);
    }
  }

  @Override
  public boolean performOk() {
    for (final FieldEditor field : fields) {
      field.store();
    }
    return super.performOk();
  }

  @Override
  public void propertyChange(final PropertyChangeEvent event) {
    if (event.getProperty() == FieldEditor.IS_VALID) {
      final boolean isValid = (Boolean) event.getNewValue();
      if (isValid) {
        checkState();
      } else {
        setValid(false);
      }
    } else if (event.getProperty() == FieldEditor.VALUE) {
      fieldValueChanged((FieldEditor) event.getSource(), event.getOldValue(), event.getNewValue());
    }
  }

  /**
   * Adds the boolean editor to the given <code>parent</code> and also adds it to
   * this pages list of editors
   *
   * @param preferenceId the preference Id of the editor
   * @param labelText    the label for the editor
   * @param parent       the control parent
   * @return the created boolean editor
   */
  protected BooleanFieldEditor addBooleanEditor(final String preferenceId, final String labelText,
      final Composite parent) {
    return addBooleanEditor(preferenceId, labelText, null, parent, 1, 1);
  }

  /**
   * Adds the boolean editor to the given <code>parent</code> and also adds it to
   * this pages list of editors
   *
   * @param preferenceId the preference Id of the editor
   * @param labelText    the label for the editor
   * @param tooltip      the tooltip for the editor
   * @param parent       the control parent
   * @return the created boolean editor
   */
  protected BooleanFieldEditor addBooleanEditor(final String preferenceId, final String labelText,
      final String tooltip, final Composite parent) {
    return addBooleanEditor(preferenceId, labelText, tooltip, parent, 1, 1);
  }

  /**
   * Adds the boolean editor to the given <code>parent</code> and also adds it to
   * this pages list of editors
   *
   * @param preferenceId the preference Id of the editor
   * @param labelText    the label for the editor
   * @param tooltip      the tooltip for the editor
   * @param parent       the control parent
   * @param colSpan      the column span for the editor in the parent control
   * @param rowSpan      the row span for the editor in the parent control
   * @return the created boolean editor
   */
  protected BooleanFieldEditor addBooleanEditor(final String preferenceId, final String labelText,
      final String tooltip, final Composite parent, final int colSpan, final int rowSpan) {
    final BooleanFieldEditor booleanEditor = new BooleanFieldEditor(preferenceId, labelText,
        parent);
    fields.add(booleanEditor);

    Control editorControl = booleanEditor.getDescriptionControl(parent);

    if (tooltip != null) {
      editorControl.setToolTipText(tooltip);
    }
    if (rowSpan != 1 || colSpan != 1) {
      GridDataFactory.fillDefaults().span(colSpan, rowSpan).applyTo(editorControl);
    }

    return booleanEditor;
  }

  /**
   * Adds the given editor to the list of this pages field editors
   *
   * @param editor the editor to be added
   */
  protected void addEditor(final FieldEditor editor) {
    fields.add(editor);
  }

  protected void adjustMargins(final Composite composite) {
    final GridLayout layout = (GridLayout) composite.getLayout();
    layout.marginLeft = 5;
    layout.marginTop = 5;
    layout.marginRight = 5;
    layout.marginBottom = 5;
  }

  /**
   * Recomputes the page's error state by calling <code>isValid</code> for every
   * field editor.
   */
  protected void checkState() {
    boolean valid = true;
    // The state can only be set to true if all
    // field editors contain a valid value. So we must check them all
    if (fields != null) {
      for (FieldEditor editor : fields) {
        valid = valid && editor.isValid();
        if (!valid) {
          break;
        }
      }
    }
    setValid(valid);
  }

  @Override
  protected Control createContents(final Composite parent) {
    final Composite composite = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
    GridLayoutFactory.fillDefaults().applyTo(composite);

    createPreferenceControls(composite);

    initFields();
    checkState();
    applyDialogFont(composite);
    return composite;
  }

  /**
   * Creates composite for a single {@link FieldEditor}
   *
   * @param parent the parent composite
   * @return the created composite for the editor
   */
  protected Composite createEditorParent(final Composite parent) {
    Composite editorParent = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(editorParent);
    return editorParent;
  }

  /**
   * Creates the preference controls of the page.
   *
   * @param parent the parent composite
   */
  protected abstract void createPreferenceControls(Composite parent);

  /**
   * Notification that the value of a field editor changed <br>
   * The default implementation does nothing, subclasses may override
   *
   * @param field    the editor whose value changed
   * @param oldValue the old value of the editor
   * @param newValue the new value of the editor
   */
  protected void fieldValueChanged(FieldEditor field, Object oldValue, Object newValue) {
  }

  protected void initFields() {
    for (final FieldEditor field : fields) {
      field.setPage(this);
      field.setPreferenceStore(getPreferenceStore());
      field.load();
      field.setPropertyChangeListener(this);
    }
  }

  @Override
  protected void performDefaults() {
    for (final FieldEditor field : fields) {
      field.loadDefault();
    }
    super.performDefaults();
  }

}
