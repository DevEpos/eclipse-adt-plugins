package com.devepos.adt.base.ui.tree;

import org.eclipse.swt.graphics.Image;

public class SimpleInfoTreeNode extends TreeNodeBase {
  private final Image image;

  public SimpleInfoTreeNode(final String name, final Image image,
      final ICollectionTreeNode parent) {
    this(name, name, image, null, parent);
  }

  public SimpleInfoTreeNode(final String name, final String displayName, final Image image,
      final String description, final ICollectionTreeNode parent) {
    super(name, displayName, description, parent);
    this.image = image;
  }

  @Override
  public Image getImage() {
    return image;
  }

}
