package com.devepos.adt.saat.ui.internal.search.view;

import java.util.Map.Entry;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.devepos.adt.saat.model.objectsearch.ICustomOption;

public class CustomSearchOptionControlCreator {

  private static class BooleanOptionControl implements ICustomSearchOptionControl {
    private static final String ABAP_TRUE = "X";
    private final ICustomOption optionMetadata;
    private Button optionControl;

    public BooleanOptionControl(final ICustomOption option) {
      optionMetadata = option;
    }

    @Override
    public void createControl(final Composite parent) {
      optionControl = new Button(parent, SWT.CHECK);
      optionControl.setText(optionMetadata.getLabel());
      if (optionMetadata.getDescription() != null) {
        optionControl.setToolTipText(optionMetadata.getDescription());
      }
    }

    @Override
    public String getOptionValue() {
      return optionControl.getSelection() ? ABAP_TRUE : null;
    }

    @Override
    public void setOptionValue(final String value) {
      optionControl.setSelection(ABAP_TRUE.equals(value));
    }

  }

  private static class ComboOptionControl implements ICustomSearchOptionControl {

    private final ICustomOption optionMetadata;
    private Composite comboContainer;
    private ComboViewer comboOptionControl;

    public ComboOptionControl(final ICustomOption option) {
      optionMetadata = option;
    }

    @Override
    public void createControl(final Composite parent) {
      comboContainer = new Composite(parent, SWT.NONE);
      GridDataFactory.fillDefaults().grab(true, false).applyTo(comboContainer);
      GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(comboContainer);

      var comboLabel = new Label(comboContainer, SWT.NONE);
      comboLabel.setText(optionMetadata.getLabel());
      comboLabel.setToolTipText(optionMetadata.getDescription());

      comboOptionControl = new ComboViewer(comboContainer, SWT.READ_ONLY);
      comboOptionControl.setContentProvider(ArrayContentProvider.getInstance());
      var comboOptions = optionMetadata.getOptionValues().entrySet();
      comboOptionControl.setInput(comboOptions);
      comboOptionControl.setLabelProvider(new LabelProvider() {
        @SuppressWarnings("unchecked")
        @Override
        public String getText(final Object element) {
          if (element instanceof Entry<?, ?>) {
            return ((Entry<String, String>) element).getValue();
          }
          return super.getText(element);
        }
      });
      comboOptionControl.setSelection(new StructuredSelection(comboOptions.iterator().next()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getOptionValue() {
      var selection = comboOptionControl.getStructuredSelection();
      if (selection != null) {
        var selectedEntry = (Entry<String, String>) selection.getFirstElement();
        return selectedEntry.getKey();
      }

      return null;
    }

    @Override
    public void setOptionValue(final String value) {
      var optionValue = optionMetadata.getOptionValues()
          .entrySet()
          .stream()
          .filter(o -> o.getKey().equals(value))
          .findFirst();
      if (optionValue.isPresent()) {
        comboOptionControl.setSelection(new StructuredSelection(optionValue.get()));
      }
    }

  }

  @SuppressWarnings("incomplete-switch")
  public static ICustomSearchOptionControl create(final ICustomOption customOption) {
    switch (customOption.getType()) {
    case BOOLEAN:
      return new BooleanOptionControl(customOption);
    case COMBO:
      return new ComboOptionControl(customOption);
    }
    return null;
  }
}
