package com.devepos.adt.base.elementinfo;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

/**
 * Collection of element information objects
 *
 * @author stockbal
 */
public class ElementInfoCollection extends ElementInfoBase implements IElementInfoCollection {
  private List<IElementInfo> children;

  public ElementInfoCollection() {
    super();
  }

  public ElementInfoCollection(final String name) {
    super(name);
  }

  public ElementInfoCollection(final String name, final Image image) {
    super(name, image);
  }

  public ElementInfoCollection(final String name, final String displayName, final Image image,
      final String description) {
    super(name, displayName, image, description);
  }

  @Override
  public IElementInfo getChild(final String name) {
    if (!hasChildren() || name == null) {
      return null;
    }
    return children.stream().filter(el -> name.equals(name)).findFirst().orElse(null);
  }

  @Override
  public List<IElementInfo> getChildren() {
    if (children == null) {
      children = new ArrayList<>();
    }
    return children;
  }

  @Override
  public boolean hasChild(final String name) {
    if (!hasChildren() || name == null) {
      return false;
    }
    return children.stream().anyMatch(el -> name.equals(el.getName()));
  }

  @Override
  public boolean hasChildren() {
    return children != null && !children.isEmpty();
  }

  @Override
  public int size() {
    return children == null ? 0 : children.size();
  }

}
