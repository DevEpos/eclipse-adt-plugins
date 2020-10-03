package com.devepos.adt.base.ui.wizard;

import org.eclipse.jface.wizard.WizardPage;

/**
 * Abstract wizard page implementation with additional methods for status
 * handling, etc.
 * 
 * @author stockbal
 */
public abstract class AbstractBaseWizardPage extends WizardPage implements IBaseWizardPage {
	private boolean isDirty = true;

	protected AbstractBaseWizardPage(final String pageName) {
		super(pageName);
	}

	@Override
	public boolean isDirty() {
		return this.isDirty;
	}

	@Override
	public void setDirty(final boolean isDirty) {
		this.isDirty = isDirty;
	}

}
