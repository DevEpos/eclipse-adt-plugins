package com.devepos.adt.base.util;

import java.util.List;
import java.util.Map;

/**
 * Element of a XML document
 *
 * @author stockbal
 */
public interface IXmlElement {

  /**
   * @return the attributes of this element
   */
  List<IXmlAttribute> getAttributes();

  /**
   * Retrieves the value of the attribute with the given name
   *
   * @param attributeName the name of attribute
   * @return the value of the attribute
   */
  String getAttributeValue(String attributeName);

  /**
   * Retrieves the value of the attribute with the given name
   *
   * @param namespacePrefix the namespace prefix
   * @param attributeName   the name of the attribute
   * @return the value of the attribute
   */
  String getAttributeValue(String namespacePrefix, String attributeName);

  /**
   * @return the child elements of this element
   */
  List<IXmlElement> getChildren();

  /**
   * @return the first child of the element or <code>null</code> if it has none
   */
  IXmlElement getFirstChild();

  /**
   * @return the name
   */
  String getName();

  /**
   * @return a map of all the defined namespaces with their prefixes
   */
  Map<String, String> getNamespaces();

  /**
   * @return the namespace URI of the element
   */
  String getNamespaceURI();

  /**
   * @return the namespace prefix of the element
   */
  String getPrefix();

  /**
   * @return the text
   */
  String getText();

  /**
   * @return <code>true</code> if the element has attributes
   */
  boolean hasAttributes();

  /**
   * Returns <code>true</code> if this element has a child element with the name
   * <code>tagName</code>
   *
   * @param tagName the element tag name to look for in this elements children
   * @return
   */
  boolean hasChild(String tagName);

  /**
   * @return <code>true</code> if the element has attributes
   */
  boolean hasChildren();

  /**
   * @param name the name to set
   */
  void setName(String name);

  /**
   * Sets the namespace URI of this element
   *
   * @param namespaceURI the namespace URI
   */
  void setNamespace(String namespaceURI);

  /**
   * Sets the namespace prefix of the element
   *
   * @param prefix the prefix of this element
   */
  void setPrefix(String prefix);

  /**
   * @param text the text to set
   */
  void setText(String text);

}