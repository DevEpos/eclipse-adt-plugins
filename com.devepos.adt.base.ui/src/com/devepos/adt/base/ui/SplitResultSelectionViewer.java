package com.devepos.adt.base.ui;

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

import com.devepos.adt.base.ui.internal.messages.Messages;

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
        return selectedResultsViewer;
    }

    @Override
    public StructuredViewer getResultViewer() {
        return allElementsViewer;
    }

    @Override
    protected void createContent(final Composite parent) {
        splitter = new SashForm(parent, SWT.VERTICAL | SWT.SMOOTH);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(splitter);

        createResultViewer();
        createSelectionViewer();

        if (initialSelections != null) {
            selectedElements.addAll(initialSelections);
        }

        splitter.setWeights(70, 30);
    }

    @Override
    protected int getSelectedElementCount() {
        return selectedElements.size();
    }

    private void createResultViewer() {
        final Composite resultContainer = new Composite(splitter, SWT.NONE);
        GridLayoutFactory.fillDefaults().applyTo(resultContainer);

        final Label resultViewerLabel = new Label(resultContainer, SWT.NONE);
        resultViewerLabel.setText(Messages.SearchSelectionDialog_ResultItemsLabel);
        GridDataFactory.fillDefaults().grab(true, false).applyTo(resultViewerLabel);

        allElementsViewer = new TableViewer(resultContainer, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
        allElementsViewer.setContentProvider(ArrayContentProvider.getInstance());
        GridDataFactory.fillDefaults()
                .grab(true, true)
                .hint(SWT.DEFAULT, allElementsViewer.getTable().getItemCount() * 15)
                .applyTo(allElementsViewer.getTable());

        createSelectionToolbar(resultContainer);

        allElementsViewer.addSelectionChangedListener(l -> {
            selectButton.setEnabled(l.getSelection() != null && !l.getSelection().isEmpty());
        });
        allElementsViewer.addDoubleClickListener(l -> {
            selectElements();
        });
    }

    private void createSelectionToolbar(final Composite resultContainer) {
        toolbar = new ToolBar(resultContainer, SWT.HORIZONTAL);
        GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.FILL).applyTo(toolbar);

        selectButton = new ToolItem(toolbar, SWT.PUSH);
        selectButton.setToolTipText(Messages.SplitResultSelectionViewer_AddItemButton);
        selectButton.setEnabled(false);
        selectButton.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.ARROW_DOWN));
        selectButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
            selectElements();
        }));

        unselectButton = new ToolItem(toolbar, SWT.PUSH);
        unselectButton.setToolTipText(Messages.SplitResultSelectionViewer_RemoveItemButton);
        unselectButton.setEnabled(false);
        unselectButton.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.ARROW_UP));
        unselectButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
            removeSelectedElements();
        }));

    }

    private void createSelectionViewer() {
        selectedResultsViewer = new TableViewer(splitter, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
        selectedResultsViewer.setContentProvider(ArrayContentProvider.getInstance());
        selectedResultsViewer.setInput(selectedElements);
        GridDataFactory.fillDefaults()
                .grab(true, false)
                .hint(SWT.DEFAULT, selectedResultsViewer.getTable().getItemCount() * 5)
                .applyTo(selectedResultsViewer.getTable());

        selectedResultsViewer.addSelectionChangedListener(l -> {
            unselectButton.setEnabled(l.getSelection() != null && !l.getSelection().isEmpty());
        });
        selectedResultsViewer.addDoubleClickListener(l -> {
            removeSelectedElements();
        });
    }

    private void removeSelectedElements() {
        final IStructuredSelection selection = selectedResultsViewer.getStructuredSelection();
        int lastIndex = -1;
        for (final Object selectedItem : selection.toList()) {
            lastIndex = selectedElements.indexOf(selectedItem);
            selectedElements.remove(selectedItem);
        }
        if (!selectedElements.isEmpty()) {
            if (lastIndex > 0 && lastIndex <= selectedElements.size()) {
                lastIndex--;
            }
            selectedResultsViewer.setSelection(new StructuredSelection(selectedElements.get(lastIndex)));
        }
        fireSelectedElementsChanged();
        selectedResultsViewer.refresh();

    }

    private void selectElements() {
        final IStructuredSelection selection = allElementsViewer.getStructuredSelection();
        boolean elementsAdded = false;
        for (final Object selectedItem : selection.toList()) {
            if (!selectedElements.contains(selectedItem)) {
                selectedElements.add(selectedItem);
                elementsAdded = true;
            }
        }
        selectedResultsViewer.refresh();
        if (elementsAdded) {
            fireSelectedElementsChanged();
            if (selectedResultsViewer.getStructuredSelection().isEmpty()) {
                selectedResultsViewer.setSelection(new StructuredSelection(selectedElements.get(0)));
            }
        }
    }
}
