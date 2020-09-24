package com.devepos.adt.tools.base.ui;

import org.eclipse.swt.widgets.Control;

import com.devepos.adt.tools.base.ui.dialogs.SearchSelectionDialog;

/**
 * Filter part within a dialog
 * 
 * @author     stockbal
 * @param  <F> the filter type of the filter part, e.g. {@link String}
 * @see        SearchSelectionDialog
 */
public interface IDialogFilterPart<F> extends IUIComponent {

	/**
	 * Returns the current filter value of the filter part
	 * 
	 * @return the current filter value of the filter part
	 */
	F getFilter();

	/**
	 * Sets the given filter in the filter controls
	 * 
	 * @param filter new filter value
	 */
	void setFilter(F filter);

	/**
	 * Retrieves the controls that trigger a new filter job/request
	 * 
	 * @return array of filter controls
	 */
	Control[] getFilterControls();

	/**
	 * Returns {@code true} if the current filter is empty
	 * 
	 * @return {@code true} if the current filter is empty
	 */
	boolean isFilterEmpty();

	/**
	 * Sets the focus to the filter part
	 * 
	 * @param selectText if {@code true} the text in the filter control should be
	 *                   selected
	 */
	void setFocus(boolean selectText);

}
