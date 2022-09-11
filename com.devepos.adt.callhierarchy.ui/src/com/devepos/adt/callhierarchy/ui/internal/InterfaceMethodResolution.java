package com.devepos.adt.callhierarchy.ui.internal;

public enum InterfaceMethodResolution {

  FIND_FIRST_IMPLEMENTER("Automatically resolve to first implementing class"),
  // USE_DIALOG(""),
  DISABLED("Disabled");

  private String prefLabel;

  InterfaceMethodResolution(final String prefLabel) {
    this.prefLabel = prefLabel;
  }

  public String getPrefLabel() {
    return prefLabel;
  }
}
