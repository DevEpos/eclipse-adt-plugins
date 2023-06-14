package com.devepos.adt.base;

import org.eclipse.core.runtime.IStatus;

/**
 * Listens for {@link IStatus} changes
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
@FunctionalInterface
public interface IStatusChangeListener {

  /**
   * Notification that the status changed
   *
   * @param status the new status
   */
  void statusChanged(IStatus status);
}
