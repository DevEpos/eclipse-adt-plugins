package com.devepos.adt.base.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Parser for XML stream
 *
 * @author stockbal
 */
public class XmlStreamParser {

  private final XMLStreamReader xsr;
  private final List<String> elementsWithText;

  public XmlStreamParser(final XMLStreamReader xsr, final String... elementsWithText) {
    this.xsr = xsr;
    this.elementsWithText = new ArrayList<>();
    if (elementsWithText != null) {
      this.elementsWithText.addAll(Arrays.asList(elementsWithText));
    }
  }

  private static class Attribute implements IXmlAttribute {
    private String name;
    private String value;
    private String namespace;

    /**
     * @return the name
     */
    @Override
    public String getName() {
      return name;
    }

    /**
     * @return the namespace
     */
    @Override
    public String getNamespace() {
      return namespace;
    }

    /**
     * @return the value
     */
    @Override
    public String getValue() {
      return value;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(final String name) {
      this.name = name;
    }

    /**
     * @param namespace the namespace to set
     */
    @Override
    public void setNamespace(final String namespace) {
      this.namespace = namespace;
    }

    /**
     * @param value the value to set
     */
    @Override
    public void setValue(final String value) {
      this.value = value;
    }

  }

  private static class Element implements IXmlElement {
    private String text;
    private String name;
    private String namespacePrefix;
    private String namespaceURI;
    private Map<String, String> namespaces;
    private List<IXmlAttribute> attributes;
    private List<IXmlElement> children;

    @Override
    public List<IXmlAttribute> getAttributes() {
      if (attributes == null) {
        attributes = new ArrayList<>();
      }
      return attributes;
    }

    @Override
    public String getAttributeValue(final String attributeName) {
      return getAttributes().stream()
          .filter(a -> a.getName().equals(attributeName))
          .findFirst()
          .orElse(new Attribute())
          .getValue();
    }

    @Override
    public String getAttributeValue(final String namespacePrefix, final String attributeName) {
      return getAttributes().stream()
          .filter(a -> a.getName().equals(attributeName) && a.getNamespace()
              .equals(namespacePrefix))
          .findFirst()
          .orElse(new Attribute())
          .getValue();
    }

    @Override
    public List<IXmlElement> getChildren() {
      if (children == null) {
        children = new ArrayList<>();
      }
      return children;
    }

    @Override
    public IXmlElement getFirstChild() {
      return getChildren().stream().findFirst().orElse(null);
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
      return name;
    }

    @Override
    public Map<String, String> getNamespaces() {
      if (namespaces == null) {
        namespaces = new HashMap<>();
      }
      return namespaces;
    }

    @Override
    public String getNamespaceURI() {
      return namespaceURI;
    }

    @Override
    public String getPrefix() {
      return namespacePrefix;
    }

    /**
     * @return the text
     */
    @Override
    public String getText() {
      return text;
    }

    @Override
    public boolean hasAttributes() {
      return !getAttributes().isEmpty();
    }

    @Override
    public boolean hasChild(final String tagName) {
      if (children == null || children.isEmpty()) {
        return false;
      }
      return children.stream().anyMatch(c -> c.getName().equals(tagName));
    }

    @Override
    public boolean hasChildren() {
      return !getChildren().isEmpty();
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(final String name) {
      this.name = name;
    }

    @Override
    public void setNamespace(final String namespaceURI) {
      this.namespaceURI = namespaceURI;
    }

    @Override
    public void setPrefix(final String prefix) {
      namespacePrefix = prefix;
    }

    /**
     * @param text the text to set
     */
    @Override
    public void setText(final String text) {
      this.text = text;
    }

  }

  /**
   * Parses the XML file from the given reader and returns the root element
   *
   * @param xsr the reader to parse the XML
   * @return the root element
   */
  public IXmlElement parseXML() {
    return parse();
  }

  /**
   * Fill attributes at this element
   *
   * @param element
   */
  private void fillAttributes(final IXmlElement element) {
    for (int i = 0; i < xsr.getAttributeCount(); i++) {
      final Attribute attribute = new Attribute();
      attribute.setNamespace(xsr.getAttributeNamespace(i));
      attribute.setName(xsr.getAttributeLocalName(i));
      attribute.setValue(xsr.getAttributeValue(i));
      element.getAttributes().add(attribute);
    }
  }

  private void fillNamespaces(final IXmlElement element) {
    element.setNamespace(xsr.getNamespaceURI());
    element.setPrefix(xsr.getPrefix());
    for (int i = 0; i < xsr.getNamespaceCount(); i++) {
      final String prefix = xsr.getNamespacePrefix(i);
      if (prefix != null) {
        final String namespaceURI = xsr.getNamespaceURI(i);
        element.getNamespaces().put(prefix, namespaceURI);
      }

    }
  }

  /**
   * Parse current element
   *
   * @return
   */
  private Element parse() {
    Element element = null;

    while (xsr.getEventType() != XMLStreamConstants.END_DOCUMENT) {
      try {
        if (xsr.getEventType() == XMLStreamConstants.START_ELEMENT) {
          if (element != null) {
            element.getChildren().add(parse());
            xsr.next();
          } else {
            element = new Element();
            final String elementName = xsr.getLocalName();
            element.setName(elementName);
            fillAttributes(element);
            if (elementsWithText.contains(elementName)) {
              try {
                element.setText(xsr.getElementText());
              } catch (final XMLStreamException e) {
              }
            }
            fillNamespaces(element);
            if (xsr.getEventType() == XMLStreamConstants.END_ELEMENT) {
              return element;
            }
            xsr.next();
          }
        } else if (xsr.getEventType() == XMLStreamConstants.END_ELEMENT) {
          return element;
        } else {
          xsr.next();
        }

      } catch (final XMLStreamException | NoSuchElementException e) {
        e.printStackTrace();
        if (xsr != null) {
          try {
            xsr.close();
          } catch (final XMLStreamException e1) {
          }
        }
      }
    }
    return element;
  }
}
