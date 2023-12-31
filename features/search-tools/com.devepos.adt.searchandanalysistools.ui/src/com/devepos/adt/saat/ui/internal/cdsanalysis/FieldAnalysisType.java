package com.devepos.adt.saat.ui.internal.cdsanalysis;

import com.devepos.adt.saat.ui.internal.messages.Messages;

/**
 * Mode for CDS Field Analysis
 *
 * @author Ludwig Stockbauer-Muhr
 */
public enum FieldAnalysisType {
  TOP_DOWN(Messages.FieldAnalysisType_topDownName_xlbl, "topDown"), // $NON-NLS-2$
  BOTTOM_UP(Messages.FieldAnalysisType_bottomUpName_xlbl, "bottomUp"); // $NON-NLS-2$

  private final String label;
  private final String prefKey;

  FieldAnalysisType(final String label, final String prefKey) {
    this.label = label;
    this.prefKey = prefKey;
  }

  public String getPrefKey() {
    return prefKey;
  }

  @Override
  public String toString() {
    return label;
  }

}
