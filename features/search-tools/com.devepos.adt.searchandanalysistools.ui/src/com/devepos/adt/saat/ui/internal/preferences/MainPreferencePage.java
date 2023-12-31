package com.devepos.adt.saat.ui.internal.preferences;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.devepos.adt.saat.ui.internal.messages.Messages;

/**
 * Main preference page for search and analysis tools
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class MainPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

  @Override
  public void init(final IWorkbench workbench) {

  }

  @Override
  protected Control createContents(final Composite parent) {
    final Composite main = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(main);
    GridLayoutFactory.fillDefaults().applyTo(main);

    final Label label = new Label(main, SWT.NONE);
    label.setText(Messages.MainPreferencePage_seeSubPagesInfo_xmsg);
    GridDataFactory.fillDefaults().applyTo(label);
    return main;
  }

}
