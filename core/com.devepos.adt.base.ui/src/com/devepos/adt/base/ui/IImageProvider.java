package com.devepos.adt.base.ui;

import org.eclipse.swt.graphics.Image;

/**
 * Provides an Image
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IImageProvider {

  /**
   * Returns the image of this provider
   *
   * @return the provided image
   */
  Image getImage();

  /**
   * Returns image depending on the given input
   *
   * @param data input object to decide which image to return
   * @return the provided image
   */
  default Image getImage(final Object data) {
    return getImage();
  }
}
