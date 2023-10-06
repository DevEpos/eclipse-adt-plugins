package com.devepos.adt.base.ui.action;

import org.eclipse.swt.SWT;

public enum ViewLayoutOrientation {
  /**
   * Vertical orientation of two controls in a splitter view
   */
  VERTICAL(SWT.VERTICAL),
  /**
   * Horizontal orientation of two controls in a splitter view
   */
  HORIZONTAL(SWT.HORIZONTAL),
  /**
   * Only the main view of the spliiter will be shown
   */
  SINGLE(SWT.SINGLE),
  /**
   * Vertical/Horizontal orientation depending on the size of the view
   */
  AUTOMATIC(-1);

  private final int swtOrientation;

  ViewLayoutOrientation(final int swtOrientation) {
    this.swtOrientation = swtOrientation;
  }

  public int getSwtOrientation() {
    return swtOrientation;
  }
}
