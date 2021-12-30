package com.devepos.adt.base.util;

/**
 * Listens for property changes of an object
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IPropertyChangeListener {

  /**
   * Notification that a property changed
   *
   * @param event the property change event
   */
  void propertyChanged(PropertyChangeEvent event);
}
