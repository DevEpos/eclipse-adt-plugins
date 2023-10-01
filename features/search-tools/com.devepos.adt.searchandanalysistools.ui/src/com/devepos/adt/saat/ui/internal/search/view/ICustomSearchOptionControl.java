package com.devepos.adt.saat.ui.internal.search.view;

import org.eclipse.swt.widgets.Composite;

/**
 * Represents control of a custom search option
 * 
 * @author Ludwig Stockbauer-Muhr
 */
public interface ICustomSearchOptionControl {

  String getOptionValue();

  void setOptionValue(String value);

  void createControl(Composite parent);
}
