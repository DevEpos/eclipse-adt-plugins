package com.devepos.adt.base.ui.util;

import org.eclipse.swt.graphics.Image;

/**
 * Proxy for accessing properties of an ADT object type
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IAdtObjectTypeProxy {

  /**
   * Retrieves the Id of the object type
   */
  String getId();

  /**
   * Retrieves the image of the workbench type
   */
  Image getImage();

  /**
   * Retrieves the description for the workbench type
   */
  String getDescription();

  /**
   * Retrieves ADT resource URI path of the type
   */
  String getAdtResourceUriPath();
}
