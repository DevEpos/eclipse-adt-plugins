package com.devepos.adt.base.util;

import org.eclipse.core.runtime.IStatus;

/**
 * Marks a a view that holds a status control (i.e. Status Label and/or Status
 * Icon)
 *
 * @author stockbal
 */
public interface IStatusView {

  /**
   * Sets the given status in the view
   *
   * @param status the new status to be set in the view
   */
  void setViewStatus(IStatus status);
}
