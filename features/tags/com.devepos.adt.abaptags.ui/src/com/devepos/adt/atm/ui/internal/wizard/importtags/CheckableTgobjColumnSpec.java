package com.devepos.adt.atm.ui.internal.wizard.importtags;

import com.devepos.adt.atm.ui.internal.messages.Messages;

enum CheckableTgobjColumnSpec {
  OBJECT(255, Messages.ColumnViewerSpec_ObjectColumn_xtit, false),
  OBJECT_TYPE(120, "Type", false),
  PARENT_TAG(150, Messages.ColumnViewerSpec_ParentTagColumn_xtit, true),
  PARENT_OBJECT(235, Messages.ColumnViewerSpec_ParentObjectColumn_xtit, true),
  PARENT_OBJ_TYPE(120, "Type", true);

  public final int defaultWidth;
  public final String headerText;
  public final boolean parentTagMode;

  CheckableTgobjColumnSpec(final int width, final String headerText, boolean parentTagMode) {
    defaultWidth = width;
    this.headerText = headerText;
    this.parentTagMode = parentTagMode;
  }
}
