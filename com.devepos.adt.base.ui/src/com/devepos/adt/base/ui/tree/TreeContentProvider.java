package com.devepos.adt.base.ui.tree;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;

/**
 * Simple Tree Content Provider for inputs based on {@link ITreeNode}. <br>
 * If some elements in the tree are not yet loaded use
 * {@link LazyLoadingTreeContentProvider} instead
 *
 * @author stockbal
 */
public class TreeContentProvider implements ITreeContentProvider {

  protected final Object[] EMPTY_ARRAY = new Object[0];

  @Override
  public Object[] getElements(final Object inputElement) {
    if (inputElement instanceof List<?>) {
      return ((List<?>) inputElement).toArray();
    }
    if (inputElement instanceof Object[]) {
      return (Object[]) inputElement;
    }
    return new Object[] { inputElement };
  }

  @Override
  public Object[] getChildren(final Object parentElement) {
    if (parentElement instanceof ICollectionTreeNode) {
      return getChildren((ICollectionTreeNode) parentElement);
    }
    return EMPTY_ARRAY;
  }

  @Override
  public Object getParent(final Object element) {
    if (element instanceof ITreeNode) {
      return ((ITreeNode) element).getParent();
    }
    return null;
  }

  @Override
  public boolean hasChildren(final Object element) {
    if (element instanceof ICollectionTreeNode) {
      return ((ICollectionTreeNode) element).hasChildren();
    }

    return false;
  }

  /**
   * Retrieves child nodes from the given collection node
   *
   * @param collectionNode collection node with child nodes
   * @return the retrieved child nodes as an array or {@code null}
   */
  protected Object[] getChildren(final ICollectionTreeNode collectionNode) {
    final List<ITreeNode> children = collectionNode.getChildren();
    if (children == null) {
      return null;
    }
    return children.toArray(new Object[children.size()]);
  }

}
