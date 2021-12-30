package com.devepos.adt.base.util;

/**
 * Generic interface for converting a string into another string
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
@FunctionalInterface
public interface IStringConverter {

  /**
   * Converts the given value into a string. It is assumed that the given value is
   * in a form that produces no conversion errors. <br>
   * If the given type is not supported by the converted a simple
   * {@link String#toString()} conversion will be performed
   * 
   * @param value the value to convert
   * @return the converted value
   */
  String convert(Object value);
}
