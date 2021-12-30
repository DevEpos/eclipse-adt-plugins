package com.devepos.adt.base.ui.search;

import org.eclipse.swt.graphics.Image;

/**
 * Describes a simple search filter without any proposal support
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFilter implements ISearchFilter {

  private final String label;
  private final String description;
  private final Image image;
  private final boolean supportsPatternValues;
  private final boolean supportsMultipleValues;
  private final boolean supportsNegatedValues;

  /**
   * Creates a simple search filter that supports multiple values and patterns. It
   * does not allow buffering and negated values
   *
   * @param label       the label for the filter
   * @param description a long description for the filter
   * @param image       the image to be displayed for the filter
   */
  public SearchFilter(final String label, final String description, final Image image) {
    this(label, description, image, true, true, false);
  }

  /**
   * Creates a simple search filter with the given options. Negated values are not
   * allowed.
   *
   * @param label                  the label for the filter
   * @param description            a long description for the filter
   * @param image                  the image to be displayed for the filter
   * @param supportsPatternValues  if <code>true</code> the filter supports
   *                               pattern values
   * @param supportsMultipleValues if <code>true</code> the filter supports
   *                               multiple values
   */
  public SearchFilter(final String label, final String description, final Image image,
      final boolean supportsPatternValues, final boolean supportsMultipleValues) {
    this(label, description, image, supportsMultipleValues, supportsMultipleValues, false);
  }

  /**
   * Creates a simple search filter with the given options
   *
   * @param label                  the label for the filter
   * @param description            a long description for the filter
   * @param image                  the image to be displayed for the filter
   * @param supportsPatternValues  if <code>true</code> the filter supports
   *                               pattern values
   * @param supportsMultipleValues if <code>true</code> the filter supports
   *                               multiple values
   * @param supportsNegatedValues  if <code>true</code> the filter supports the
   *                               negation of values
   */
  public SearchFilter(final String label, final String description, final Image image,
      final boolean supportsPatternValues, final boolean supportsMultipleValues,
      final boolean supportsNegatedValues) {
    this.label = label;
    this.description = description;
    this.image = image;
    this.supportsPatternValues = supportsPatternValues;
    this.supportsMultipleValues = supportsMultipleValues;
    this.supportsNegatedValues = supportsNegatedValues;
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public String getLabel() {
    return label;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public boolean supportsPatternValues() {
    return supportsPatternValues;
  }

  @Override
  public boolean isBuffered() {
    return false;
  }

  @Override
  public boolean supportsMultipleValues() {
    return supportsMultipleValues;
  }

  @Override
  public boolean supportsNegatedValues() {
    return supportsNegatedValues;
  }

}
