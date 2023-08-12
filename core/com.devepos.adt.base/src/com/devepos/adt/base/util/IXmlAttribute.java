package com.devepos.adt.base.util;

/**
 * Attribute of a XML Element
 *
 * @author stockbal
 */
public interface IXmlAttribute {

  /**
   * @return the name
   */
  String getName();

  /**
   * @return the namespace
   */
  String getNamespace();

  /**
   * @return the value
   */
  String getValue();

  /**
   * @param name the name to set
   */
  void setName(String name);

  /**
   * @param namespace the namespace to set
   */
  void setNamespace(String namespace);

  /**
   * @param value the value to set
   */
  void setValue(String value);

}