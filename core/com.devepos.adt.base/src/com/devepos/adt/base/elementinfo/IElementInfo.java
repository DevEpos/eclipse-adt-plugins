package com.devepos.adt.base.elementinfo;

import org.eclipse.swt.graphics.Image;

/**
 * Information about a search result element
 *
 * @author stockbal
 */
public interface IElementInfo extends IPropertyBag {
  /**
   * Returns the additional info object
   *
   * @return
   */
  Object getAdditionalInfo();

  /**
   * @return the description of the element
   */
  String getDescription();

  /**
   * @return the display name of the element
   */
  String getDisplayName();

  /**
   * @return the image of this element
   */
  Image getImage();

  /**
   * @return the name of the element
   */
  String getName();

  /**
   * Returns <code>true</code> if this element information has an object with
   * additional information
   *
   * @return <code>true</code> if this element information has an object with
   *         additional information
   */
  boolean hasAdditionalInfo();

  /**
   * Sets additional information object
   *
   * @param info
   */
  void setAdditionalInfo(Object info);

  /**
   * Sets the description of the element info
   *
   * @param description the description to be set
   */
  void setDescription(String description);

  /**
   * Sets the display name of the element information
   *
   * @param displayName the display name to be set
   */
  void setDisplayName(String displayName);

  /**
   * Sets the image to be associated with this element
   *
   * @param imageId
   */
  void setImage(Image image);

  /**
   * Sets the name of the element info
   *
   * @param name the name to be set
   */
  void setName(String name);
}
