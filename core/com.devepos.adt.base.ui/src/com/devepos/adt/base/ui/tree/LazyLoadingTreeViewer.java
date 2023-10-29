package com.devepos.adt.base.ui.tree;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

/**
 * TreeViewer with custom handling of expandAll, to prevent unwanted loading of lazy content
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class LazyLoadingTreeViewer extends TreeViewer {
  private boolean isExpandCheckForLazyNodes = true;

  public LazyLoadingTreeViewer(final Composite parent) {
    super(parent);
  }

  public LazyLoadingTreeViewer(final Composite parent, final int style) {
    super(parent, style);
  }

  public LazyLoadingTreeViewer(final Tree tree) {
    super(tree);
  }

  @Override
  public void expandToLevel(Object elementOrTreePath, int level, boolean disableRedraw) {
    if (!isExpandCheckForLazyNodes) {
      super.expandToLevel(elementOrTreePath, level, disableRedraw);
      return;
    }

    if (elementOrTreePath == getRoot() && level == ALL_LEVELS) {
      expandAllLoadedNodes(disableRedraw);
    } else {
      super.expandToLevel(elementOrTreePath, level, disableRedraw);
    }
  }

  void expandNode(ITreeNode node, int level, boolean loadedChildrenOnly) {
    var tree = getTree();
    tree.setRedraw(false);
    internalExpandNode(node, 1, level, loadedChildrenOnly);
    tree.setRedraw(true);
    refresh(false);
  }

  /**
   * Sets the expand behavior for lazy nodes during {@link #expandAll()}.
   * <br>
   * Setting this flag to {@link true} will disable the expansion of {@link ILazyLoadingNode} whose
   * children are not yet loaded.
   * 
   * @param expandPreCheck if {@code true} all nodes will be expanded regardless of state
   */
  public void setExpandCheckForLazyNodes(boolean expandPreCheck) {
    this.isExpandCheckForLazyNodes = expandPreCheck;
  }

  @Override
  protected void assertContentProviderType(IContentProvider provider) {
    Assert.isTrue(provider instanceof LazyLoadingTreeContentProvider);
  }

  private void expandAllLoadedNodes(boolean disableRedraw) {
    if (disableRedraw) {
      getTree().setRedraw(false);
    }
    var input = getInput();
    if (input instanceof Object[]) {
      var elements = (Object[]) input;
      if (elements.length == 1 && isLazyUnloadedRoot(elements[0])) {
        setExpandedState(elements[0], true);
      } else {
        for (var element : (Object[]) input) {
          if (element instanceof ICollectionTreeNode) {
            internalExpandNode((ITreeNode) element);
          }
        }
      }
    } else if (isLazyUnloadedRoot(input)) {
      setExpandedState(input, true);
    } else if (input instanceof ICollectionTreeNode) {
      internalExpandNode((ITreeNode) input);
    }

    refresh(false);
    if (disableRedraw) {
      getTree().setRedraw(true);
    }
  }

  private boolean isLazyUnloadedRoot(Object node) {
    return node instanceof ILazyLoadingNode && !((ILazyLoadingNode) node).isLoaded();
  }

  private void internalExpandNode(final ITreeNode node) {
    internalExpandNode(node, ALL_LEVELS, ALL_LEVELS, true);
  }

  private void internalExpandNode(final ITreeNode node, int level, int maxLevel,
      boolean loadedChildrenOnly) {
    if (!(node instanceof ICollectionTreeNode)) {
      return;
    }
    if (node instanceof ILazyLoadingNode) {
      var lazyNode = (ILazyLoadingNode) node;
      if (!lazyNode.isLoaded() && loadedChildrenOnly) {
        return;
      }
    }

    setExpandedState(node, true);

    if (maxLevel != ALL_LEVELS && level >= maxLevel) {
      return;
    }

    var nextLevel = level != ALL_LEVELS ? level + 1 : ALL_LEVELS;
    var collectionNode = ((ICollectionTreeNode) node);
    if (!collectionNode.hasChildren()) {
      return;
    }
    for (var child : collectionNode.getChildren()) {
      internalExpandNode(child, nextLevel, maxLevel, loadedChildrenOnly);
    }
  }

}