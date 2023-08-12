package com.devepos.adt.base.ui.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of {@link ITreeNode}
 *
 * @author stockbal
 */
public interface ICollectionTreeNode extends ITreeNode {

  /**
   * Adds the given node as a child node
   *
   * @param child the child node to be added
   */
  void addChild(ITreeNode child);

  /**
   * Returns the list of child nodes of this node
   *
   * @return a {@link List} of child nodes of this collection node
   */
  List<ITreeNode> getChildren();

  /**
   * Returns collection child nodes recursively
   *
   * @return a list of collection tree nodes
   */
  default List<ICollectionTreeNode> getCollectionChildrenRecursive() {
    var collectionNodes = new ArrayList<ICollectionTreeNode>();
    for (var node : getChildren()) {
      if (node instanceof ICollectionTreeNode) {
        collectionNodes.add((ICollectionTreeNode) node);
        collectionNodes.addAll(((ICollectionTreeNode) node).getCollectionChildrenRecursive());
      }
    }
    return collectionNodes;
  }

  /**
   * Returns the number of <code>nodes</code> in this collection in a readable
   * format
   *
   * @return the current size as a String
   */
  String getSizeAsString();

  /**
   * Returns <code>true</code> if the node has children
   *
   * @return <code>true</code> if the node has children
   */
  boolean hasChildren();

  /**
   * Removes all child nodes of this node
   */
  void removeAllChildren();

  /**
   * Removes the given child node if possible
   *
   * @param child the child node to be removed
   */
  void removeChild(ITreeNode child);

  /**
   * Sets the child nodes of this collection node
   *
   * @param children List of child nodes
   */
  void setChildren(List<ITreeNode> children);

  /**
   * Returns the size of this collection
   *
   * @return the number of entries in this collection
   */
  int size();
}
