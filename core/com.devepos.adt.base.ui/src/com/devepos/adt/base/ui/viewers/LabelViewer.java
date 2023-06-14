package com.devepos.adt.base.ui.viewers;

import org.eclipse.jface.action.LegacyActionTools;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Content Viewer with a Label as control
 *
 * @author stockbal
 */
public class LabelViewer extends ContentViewer {

  private final CLabel label;

  /**
   * Unfortunately, it was impossible to delegate displaying border to label. The
   * <code>ViewForm</code> is used because <code>CLabel</code> displays shadow
   * when border is present.
   */
  private final ViewForm viewForm;

  /**
   * Constructs a new instance of this class given its parent and a style value
   * describing its behavior and appearance.
   *
   * @param parent the parent component
   * @param style  SWT style bits
   */
  public LabelViewer(final Composite parent, final int style) {
    viewForm = new ViewForm(parent, style);

    GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(viewForm);
    label = new CLabel(viewForm, SWT.FLAT);
    label.setFont(parent.getFont());
    viewForm.setContent(label);
    hookControl(viewForm);
    setContentProvider(new IContentProvider() {
      // intentionally left empty
    });
  }

  @Override
  protected void inputChanged(final Object input, final Object oldInput) {
    if (oldInput == null && input == null) {
      return;
    }
    refresh();
  }

  @Override
  protected void handleLabelProviderChanged(final LabelProviderChangedEvent event) {
    if (event != null) {
      refresh(event.getElements());
    }
  }

  @Override
  public Control getControl() {
    return viewForm;
  }

  @Override
  public ISelection getSelection() {
    // not supported
    return null;
  }

  @Override
  public void refresh() {
    final Object input = getInput();
    if (input != null) {
      final ILabelProvider labelProvider = (ILabelProvider) getLabelProvider();
      doRefresh(labelProvider.getText(input), labelProvider.getImage(input));
    } else {
      doRefresh(null, null);
    }
  }

  /**
   * Sets the given text and image to the label.
   *
   * @param text  the new text or null
   * @param image the new image
   */
  private void doRefresh(String text, final Image image) {
    if (text != null) {
      text = LegacyActionTools.escapeMnemonics(text);
    }
    label.setText(text);
    label.setImage(image);
  }

  @Override
  public void setSelection(final ISelection selection, final boolean reveal) {
    // not supported
  }

  /**
   * Refreshes the label if currently chosen element is on the list.
   *
   * @param objs list of changed object
   */
  private void refresh(final Object[] objs) {
    if (objs == null || getInput() == null) {
      return;
    }
    final Object input = getInput();
    for (final Object obj : objs) {
      if (obj.equals(input)) {
        refresh();
        break;
      }
    }
  }

}
