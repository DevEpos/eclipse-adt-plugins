package com.devepos.adt.base.ui.tree;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

/**
 * Represents a simple node in a tree that has child nodes
 *
 * @author stockbal
 */
public class FolderTreeNode extends TreeNodeBase implements ICollectionTreeNode {
  protected List<ITreeNode> children;
  protected Image image;

  public FolderTreeNode(final String name, final ICollectionTreeNode parent, final Image image,
      final List<ITreeNode> children) {
    this(name, name, parent, image, children);
  }

  public FolderTreeNode(final String name, final String displayName,
      final ICollectionTreeNode parent, final Image image, final List<ITreeNode> children) {
    this(name, displayName, null, parent, image, children);
  }

  public FolderTreeNode(final String name, final String displayName, final String description,
      final ICollectionTreeNode parent, final Image image, final List<ITreeNode> children) {
    super(name, displayName, description, parent);
    this.image = image;
    this.children = children;
  }

  @Override
  public void addChild(final ITreeNode child) {
    if (children == null) {
      children = new ArrayList<>();
    }
    if (child.getParent() != this) {
      child.setParent(this);
    }
    children.add(child);
  }

  @Override
  public List<ITreeNode> getChildren() {
    if (children == null) {
      children = new ArrayList<>();
    }
    return children;
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public String getSizeAsString() {
    return new DecimalFormat("###,###").format(getChildren().size());
  }

  @Override
  public boolean hasChildren() {
    return children != null && !children.isEmpty();
  }

  @Override
  public void removeAllChildren() {
    if (children != null) {
      children.clear();
    }
  }

  @Override
  public void removeChild(final ITreeNode child) {
    if (children != null && children.remove(child)) {
      child.setParent(null);
    }
  }

  @Override
  public void setChildren(final List<ITreeNode> children) {
    this.children = children;
  }

  @Override
  public int size() {
    return getChildren().size();
  }

}
