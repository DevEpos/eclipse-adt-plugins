package com.devepos.adt.base.ui.internal.pages;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;

import com.devepos.adt.base.ui.internal.messages.Messages;

/**
 * Root property page for ABAP project specific properties
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class DevEposProjectRootPropertyPage extends PropertyPage implements IWorkbenchPropertyPage {

  public static final String PAGE_ID = "com.devepos.adt.base.ui.projectProperties.DevEpos";

  public DevEposProjectRootPropertyPage() {
    noDefaultAndApplyButton();
  }

  @Override
  protected Control createContents(final Composite parent) {
    final Composite main = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(main);
    GridLayoutFactory.fillDefaults().applyTo(main);

    final Label label = new Label(main, SWT.NONE);
    label.setText(Messages.ProjectPropertyPagesRoot_infoLabel_xlbl);
    GridDataFactory.fillDefaults().applyTo(label);
    return main;
  }

}
