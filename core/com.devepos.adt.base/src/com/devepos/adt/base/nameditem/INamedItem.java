package com.devepos.adt.base.nameditem;

import com.devepos.adt.base.internal.nameditem.NamedItem;

/**
 * Named item resource. It always consists of a concrete name and can have an
 * optional description and some generic descriptive data
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface INamedItem {
  /**
   * Creates new named item with the given parameters
   * 
   * @param name        name of the item
   * @param description description of the item
   * @param data        additional data for the item
   * @return the created item
   */
  static INamedItem createNamedItem(String name, String description, String data) {
    var item = new NamedItem();
    item.setName(name);
    item.setDescription(description);
    item.setData(data);
    return item;
  }

  /**
   * Retrieves the custom data of the item
   *
   * @return
   */
  String getData();

  /**
   * Returns the description of the item
   *
   * @return
   */
  String getDescription();

  /**
   * Returns the name of the item
   *
   * @return
   */
  String getName();

  /**
   * Sets the custom data of the item
   *
   * @param data
   */
  void setData(final String data);

  /**
   * Sets the description of the item
   *
   * @param description
   */
  void setDescription(final String description);

  /**
   * Sets the name of the item
   *
   * @param name
   */
  void setName(final String name);
}
