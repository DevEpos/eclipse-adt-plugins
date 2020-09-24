package com.devepos.adt.tools.base.ui;

import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Composite;

/**
 * Result part of a dialog which consists of a Structured Viewer that holds the
 * result items and an optional content viewer which displays the details like
 * the current selection.
 * 
 * @author stockbal
 */
public abstract class DialogResultPart implements IUIComponent {

	private ILabelProvider resultLabelProvider;
	private ILabelProvider detailsLabelProvider;

	/**
	 * Creates the dialog part
	 * 
	 * @param parent the parent composite
	 */
	public final void createDialogPart(final Composite parent) {
		createUI(parent);
		final StructuredViewer resultViewer = getResultViewer();
		if (resultViewer != null) {
			resultViewer.setLabelProvider(getResultLabelProvider());
		}
		final ContentViewer detailsViewer = getDetailViewer();
		if (detailsViewer != null) {
			detailsViewer.setLabelProvider(getDetailsLabelProvider());
		}
	}

	/**
	 * Returns the result viewer of the part.
	 * <p>
	 * <strong>Note:</strong><br>
	 * The viewer is first bound after the call of
	 * {@link #createUI(org.eclipse.swt.widgets.Composite)}
	 * </p>
	 * 
	 * @return the results viewer of the dialog
	 */
	public abstract StructuredViewer getResultViewer();

	/**
	 * Returns the Detail viewer of the part.<br>
	 * The default implementation returns null. Subclasses may override
	 * <p>
	 * <strong>Note:</strong><br>
	 * The viewer is first bound after the call of
	 * {@link #createUI(org.eclipse.swt.widgets.Composite)}
	 * </p>
	 * 
	 * @return the Detail viewer of the part
	 */
	public ContentViewer getDetailViewer() {
		return null;
	}

	/**
	 * Sets the label provider for the result viewer
	 * 
	 * @param labelProvider the label provider for the result viewer
	 */
	public void setResultLabelProvider(final ILabelProvider labelProvider) {
		this.resultLabelProvider = labelProvider;
	}

	/**
	 * Sets the label provider for the detail viewer
	 * 
	 * @param labelProvider the label provider for the detail viewer
	 */
	public void setDetailsLabelProvider(final ILabelProvider labelProvider) {
		this.detailsLabelProvider = labelProvider;
	}

	private ILabelProvider getResultLabelProvider() {
		if (this.resultLabelProvider == null) {
			this.resultLabelProvider = new LabelProvider();
		}
		return this.resultLabelProvider;
	}

	private ILabelProvider getDetailsLabelProvider() {
		if (this.detailsLabelProvider == null) {
			this.detailsLabelProvider = new LabelProvider();
		}
		return this.detailsLabelProvider;
	}
}
