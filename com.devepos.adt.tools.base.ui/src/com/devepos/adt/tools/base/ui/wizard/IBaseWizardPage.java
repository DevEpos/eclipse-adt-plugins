package com.devepos.adt.tools.base.ui.wizard;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;

/**
 * Base interface for a Page in a {@link IWizard}
 *
 * @author stockbal
 */
public interface IBaseWizardPage extends IWizardPage {

	/**
	 * Call to complete this page so the next page can work properly
	 */
	default void completePage() {
	}

	/**
	 * Returns flag if this page contains changed content
	 *
	 * @return flag if this page contains changed content
	 */
	boolean isDirty();

	/**
	 * Sets the {@code isDirty} flag of this page
	 *
	 * @param isDirty the new value for the {@code isDirty} flag of this page
	 */
	void setDirty(boolean isDirty);
}
