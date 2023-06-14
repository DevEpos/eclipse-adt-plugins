package com.devepos.adt.base.util;

/**
 * Provides possibility to add/remove property change listeners to an object
 *
 * @author Ludwig Stockbauer-Muhr
 * @see IPropertyChangeListener
 */
public interface IPropertyChangeSupport {
  /**
   * Adds the given property change listener
   *
   * @param l the listener to be added
   */
  void addPropertyChangeListener(IPropertyChangeListener l);

  /**
   * Removes the given property change listener
   *
   * @param l the listener to be removed
   */
  void removePropertyChangeListener(IPropertyChangeListener l);
}
