package com.devepos.adt.saat.ui.internal.preferences;

import com.devepos.adt.saat.ui.internal.messages.Messages;

public enum InitialSearchFocus {
  TYPE_VIEWER(Messages.InitialSearchFocus_searchTypeViewerFocus_xlbl, "typeViewer"), // $NON-NLS-2$
  FIRST_SEARCH_FIELD(Messages.InitialSearchFocus_firstSearchFieldFocus_xlbl, "searchField"); // $NON-NLS-2$

  private final String label;
  private final String prefKey;

  InitialSearchFocus(final String label, final String prefKey) {
    this.label = label;
    this.prefKey = prefKey;
  }

  public String getLabel() {
    return label;
  }

  public String getPrefKey() {
    return prefKey;
  }

}
