package com.devepos.adt.base.ui.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Base Tree node which has a view basic attributes like a name, a separate
 * display name and an optional description
 *
 * @author stockbal
 */
public abstract class TreeNodeBase implements ITreeNode {

  protected String name;
  protected String displayName;
  protected String description;
  protected ICollectionTreeNode parent;
  protected Map<String, String> properties;
  private Object nodeValue;

  public TreeNodeBase(final String name, final ICollectionTreeNode parent) {
    this(name, name, "", parent);
  }

  public TreeNodeBase(final String name, final String displayName, final String description,
      final ICollectionTreeNode parent) {
    this.name = name;
    this.displayName = displayName;
    this.description = description;
    this.parent = parent;
    properties = new HashMap<>();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public void setDisplayName(final String displayName) {
    this.displayName = displayName;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(final String description) {
    this.description = description;
  }

  @Override
  public ICollectionTreeNode getParent() {
    return parent;
  }

  @Override
  public void setParent(final ICollectionTreeNode parent) {
    this.parent = parent;
  }

  @Override
  public ITreeNode getRoot() {
    if (parent == null) {
      return this;
    }
    ITreeNode parent = this.parent;
    while (parent.getParent() != null) {
      parent = parent.getParent();
    }
    return parent;
  }

  @Override
  public <T> T getAdapter(final Class<T> adapter) {
    try {
      return adapter.cast(nodeValue);
    } catch (final ClassCastException exc) {
      return null;
    }
  }

  @Override
  public Object getNodeValue() {
    return nodeValue;
  }

  @Override
  public void setNodeValue(final Object value) {
    nodeValue = value;
  }

  @Override
  public Map<String, String> getProperties() {
    return properties;
  }

  @Override
  public String getPropertyValue(final String key) {
    return properties.get(key);
  }
}
