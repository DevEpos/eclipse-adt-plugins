package com.devepos.adt.tools.base.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.devepos.adt.tools.base.ui.internal.messages.Messages;

public class SplitResultSelectionViewer extends DialogResultPart {

	private TableViewer allElementsViewer;
	private ToolItem selectButton;
	private final List<Object> selectedElements = new ArrayList<>();
	private TableViewer selectedResultsViewer;
	private SashForm splitter;
	private ToolBar toolbar;
	private ToolItem unselectButton;

	@Override
	public ContentViewer getDetailViewer() {
		return this.selectedResultsViewer;
	}

	@Override
	public StructuredViewer getResultViewer() {
		return this.allElementsViewer;
	}

	@Override
	protected void createContent(final Composite parent) {
		this.splitter = new SashForm(parent, SWT.VERTICAL | SWT.SMOOTH);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.splitter);

		createResultViewer();
		createSelectionViewer();

		if (this.initialSelections != null) {
			this.selectedElements.addAll(this.initialSelections);
		}

		this.splitter.setWeights(new int[] { 70, 30 });
	}

	@Override
	protected int getSelectedElementCount() {
		return this.selectedElements.size();
	}

	private void createResultViewer() {
		final Composite resultContainer = new Composite(this.splitter, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(resultContainer);

		final Label resultViewerLabel = new Label(resultContainer, SWT.NONE);
		resultViewerLabel.setText(Messages.SearchSelectionDialog_ResultItemsLabel);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(resultViewerLabel);

		this.allElementsViewer = new TableViewer(resultContainer, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		this.allElementsViewer.setContentProvider(ArrayContentProvider.getInstance());
		GridDataFactory.fillDefaults()
			.grab(true, true)
			.hint(SWT.DEFAULT, this.allElementsViewer.getTable().getItemCount() * 15)
			.applyTo(this.allElementsViewer.getTable());

		createSelectionToolbar(resultContainer);

		this.allElementsViewer.addSelectionChangedListener(l -> {
			this.selectButton.setEnabled(l.getSelection() != null && !l.getSelection().isEmpty());
		});
		this.allElementsViewer.addDoubleClickListener(l -> {
			selectElements();
		});
	}

	private void createSelectionToolbar(final Composite resultContainer) {
		this.toolbar = new ToolBar(resultContainer, SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.FILL).applyTo(this.toolbar);

		this.selectButton = new ToolItem(this.toolbar, SWT.PUSH);
		this.selectButton.setToolTipText(Messages.SplitResultSelectionViewer_AddItemButton);
		this.selectButton.setEnabled(false);
		this.selectButton.setImage(AdtToolsBaseUIResources.getImage(IAdtToolsBaseImages.ARROW_DOWN));
		this.selectButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			selectElements();
		}));

		this.unselectButton = new ToolItem(this.toolbar, SWT.PUSH);
		this.unselectButton.setToolTipText(Messages.SplitResultSelectionViewer_RemoveItemButton);
		this.unselectButton.setEnabled(false);
		this.unselectButton.setImage(AdtToolsBaseUIResources.getImage(IAdtToolsBaseImages.ARROW_UP));
		this.unselectButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			removeSelectedElements();
		}));

	}

	private void createSelectionViewer() {
		this.selectedResultsViewer = new TableViewer(this.splitter, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		this.selectedResultsViewer.setContentProvider(ArrayContentProvider.getInstance());
		this.selectedResultsViewer.setInput(this.selectedElements);
		GridDataFactory.fillDefaults()
			.grab(true, false)
			.hint(SWT.DEFAULT, this.selectedResultsViewer.getTable().getItemCount() * 5)
			.applyTo(this.selectedResultsViewer.getTable());

		this.selectedResultsViewer.addSelectionChangedListener(l -> {
			this.unselectButton.setEnabled(l.getSelection() != null && !l.getSelection().isEmpty());
		});
		this.selectedResultsViewer.addDoubleClickListener(l -> {
			removeSelectedElements();
		});
	}

	private void removeSelectedElements() {
		final IStructuredSelection selection = this.selectedResultsViewer.getStructuredSelection();
		int lastIndex = -1;
		for (final Object selectedItem : selection.toList()) {
			lastIndex = this.selectedElements.indexOf(selectedItem);
			this.selectedElements.remove(selectedItem);
		}
		if (!this.selectedElements.isEmpty()) {
			if (lastIndex > 0 && lastIndex <= this.selectedElements.size()) {
				lastIndex--;
			}
			this.selectedResultsViewer.setSelection(new StructuredSelection(this.selectedElements.get(lastIndex)));
		}
		fireSelectedElementsChanged();
		this.selectedResultsViewer.refresh();

	}

	private void selectElements() {
		final IStructuredSelection selection = this.allElementsViewer.getStructuredSelection();
		boolean elementsAdded = false;
		for (final Object selectedItem : selection.toList()) {
			if (!this.selectedElements.contains(selectedItem)) {
				this.selectedElements.add(selectedItem);
				elementsAdded = true;
			}
		}
		this.selectedResultsViewer.refresh();
		if (elementsAdded) {
			fireSelectedElementsChanged();
			if (this.selectedResultsViewer.getStructuredSelection().isEmpty()) {
				this.selectedResultsViewer.setSelection(new StructuredSelection(this.selectedElements.get(0)));
			}
		}
	}
}
