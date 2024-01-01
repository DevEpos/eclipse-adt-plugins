package com.devepos.adt.base.ui;

import java.util.function.Consumer;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.dialogs.SearchSelectionDialog;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.util.SWTUtil;
import com.devepos.adt.base.util.StringUtil;

/**
 * Simple string implementation of {@link IDialogFilterPart}.
 * 
 * @see SearchSelectionDialog
 * 
 * @author Ludwig Stockbauer-Muhr
 */
public class StringFilterPart implements IDialogFilterPart<String> {

  private Label headerLabel;
  private String headerLabelText;
  private Text pattern;
  private Consumer<IMenuManager> viewMenuFiller;

  public StringFilterPart(String headerLabelText) {
    this.headerLabelText = headerLabelText;
  }

  @Override
  public void createUI(final Composite parent) {
    createFilterHeader(parent);
    createFilter(parent);

    SWTUtil.setLabelForControl(headerLabel, pattern);
  }

  @Override
  public String getFilter() {
    if (pattern != null && !pattern.isDisposed()) {
      return pattern.getText();
    }
    return null;
  }

  @Override
  public Control[] getFilterControls() {
    return new Control[] { pattern };
  }

  @Override
  public boolean isFilterEmpty() {
    if (pattern != null && !pattern.isDisposed()) {
      return StringUtil.isEmpty(pattern.getText());
    }
    return true;
  }

  @Override
  public void setFilter(final String filter) {
    if (pattern == null || pattern.isDisposed()) {
      return;
    }
    pattern.setText(filter);
  }

  @Override
  public void setFocus(final boolean selectText) {
    pattern.setFocus();
    if (selectText) {
      pattern.setSelection(0, pattern.getText().length());
    } else {
      pattern.setSelection(pattern.getText().length());
    }
  }

  public void setViewMenuFiller(Consumer<IMenuManager> viewMenuFiller) {
    this.viewMenuFiller = viewMenuFiller;
  }

  private void createFilter(final Composite parent) {
    pattern = new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(pattern);
  }

  private void createFilterHeader(final Composite parent) {
    final Composite header = new Composite(parent, SWT.NONE);
    GridLayoutFactory.fillDefaults().numColumns(2).applyTo(header);
    GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(header);

    headerLabel = new Label(header, SWT.NONE);
    headerLabel
        .setText(StringUtil.isEmpty(headerLabelText) ? Messages.SearchSelectionDialog_FilterLabel
            : headerLabelText);
    GridDataFactory.swtDefaults()
        .align(SWT.FILL, SWT.CENTER)
        .grab(true, false)
        .applyTo(headerLabel);

    if (viewMenuFiller != null) {
      ViewMenuCreator.createViewMenu(header, viewMenuFiller);
    }
  }

}