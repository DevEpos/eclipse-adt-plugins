package com.devepos.adt.base.ui;

/**
 * Indicates a view that can be pinned (e.g. Search View)
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IPinnableView {

  /**
   * @return {@code true} if the view is pinned
   */
  boolean isPinned();

  /**
   * Sets the pinned status of the view
   *
   * @param pinned if {@code true} the view will be pinned
   */
  void setPinned(boolean pinned);
}
