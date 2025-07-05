package com.devepos.adt.base.ui.project;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.util.ui.swt.IAdtSWTUtil;

/**
 * Derivation of the standard ProjectInput which uses a radio button control instead
 * of a Label control.
 * 
 * @author stockbal
 */
public class RadioProjectInput extends ProjectInput {
  private Button projectLabelControl;

  public RadioProjectInput() {
    super();
  }

  public RadioProjectInput(boolean ensureLoggedOn) {
    super(ensureLoggedOn);
  }

  public RadioProjectInput(IAbapProjectProvider projectProvider, boolean ensureLoggedOn) {
    super(projectProvider, ensureLoggedOn);
  }

  public Button getRadioButton() {
    return projectLabelControl;
  }

  public void setRadioButtonEnabled(boolean enabled) {
    projectLabelControl.setEnabled(enabled);
  }

  @Override
  protected void createLabelControl(IAdtSWTUtil swtUtil, Composite parent) {
    projectLabelControl = new Button(parent, SWT.RADIO);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(projectLabelControl);
    projectLabelControl.setText(StringUtil.setMnemonic(projectLabelText, projectLabelMnemonic));
  }

}
