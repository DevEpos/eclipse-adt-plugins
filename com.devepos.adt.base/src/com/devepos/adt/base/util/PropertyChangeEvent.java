package com.devepos.adt.base.util;

import java.util.EventObject;

import org.eclipse.core.runtime.Assert;

/**
 * An event object describing a change to a named property.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 * @see IPropertyChangeListener
 */
public class PropertyChangeEvent extends EventObject {
  private static final long serialVersionUID = -6100873577865199912L;

  private String propertyName;
  private Object oldValue;
  private Object newValue;

  /**
   * Creates a new property change event.
   *
   * @param source   the object whose property has changed
   * @param property the property that has changed (must not be <code>null</code>)
   * @param oldValue the old value of the property, or <code>null</code> if none
   * @param newValue the new value of the property, or <code>null</code> if none
   */
  public PropertyChangeEvent(final Object source, final String property, final Object oldValue,
      final Object newValue) {
    super(source);
    Assert.isNotNull(property);
    propertyName = property;
    this.oldValue = oldValue;
    this.newValue = newValue;
  }

  /**
   * Returns the new value of the property.
   *
   * @return the new value, or <code>null</code> if not known or not relevant (for
   *         instance if the property was removed).
   */
  public Object getNewValue() {
    return newValue;
  }

  /**
   * Returns the old value of the property.
   *
   * @return the old value, or <code>null</code> if not known or not relevant (for
   *         instance if the property was just added and there was no old value).
   */
  public Object getOldValue() {
    return oldValue;
  }

  /**
   * Returns the name of the property that changed.
   * <p>
   * Warning: there is no guarantee that the property name returned is a constant
   * string. Callers must compare property names using equals, not ==.
   * </p>
   *
   * @return the name of the property that changed
   */
  public String getProperty() {
    return propertyName;
  }

}
