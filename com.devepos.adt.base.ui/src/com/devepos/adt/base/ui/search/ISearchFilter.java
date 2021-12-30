package com.devepos.adt.base.ui.search;

import org.eclipse.swt.graphics.Image;

/**
 * Describes search filter
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface ISearchFilter {
  String WILDCARD = "*";

  /**
   * Retrieve the image for this filter
   *
   * @return reference to Image
   */
  Image getImage();

  /**
   * Returns the Label for this filter to be shown in proposals
   *
   * @return the String label of the filter
   */
  String getLabel();

  /**
   * Returns the Description for this filter to be shown in proposals
   *
   * @return the String description of the filter
   */
  String getDescription();

  /**
   * Retrieves a flag which signals if the filter allows values with wildcard
   * pattern
   *
   * @return <code>true</code> if the filter supports pattern values
   */
  boolean supportsPatternValues();

  /**
   * Retrieves a flag which signals if the filter is buffered. That means the
   * possible values of this filter are only retrieved once from the backend
   *
   * @return <code>true</code> if the filter's values are buffered
   */
  boolean isBuffered();

  /**
   * Retrieves a flag which signals if the filter allows multiple values or not
   *
   * @return <code>true</code> if the filter supports multiple values
   */
  boolean supportsMultipleValues();

  /**
   * Returns <code>true</code> if this filter supports the negation of its values
   *
   * @return <code>true</code> if filter supports negation of values
   */
  boolean supportsNegatedValues();
}
