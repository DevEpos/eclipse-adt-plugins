package com.devepos.adt.base.ui.tree;

import org.eclipse.core.runtime.CoreException;

import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.ILazyLoadableContent;

/**
 * Node which supports lazy loading
 *
 * @author stockbal
 */
public interface ILazyLoadingNode extends ICollectionTreeNode, ILazyLoadableContent {

  /**
   * Refresh the content of the lazy loading node
   */
  void resetLoadedState();

  /**
   * @return <code>true</code> if the node's contents are fully loaded
   */
  boolean isLoaded();

  /**
   * Loads the child nodes of the node
   * 
   * @throws CoreException
   */
  void loadChildren() throws CoreException;

  /**
   * @return <code>true</code> if this node is currently loading it's content
   */
  boolean isLoading();

  /**
   * Returns a descriptive name for the Job to load content of the lazy loading
   * node
   *
   * @return
   */
  String getLazyLoadingJobName();

  /**
   * Sets the lazy loading function for this lazy loading node
   *
   * @param provider the provider for retrieving element information;
   */
  void setElementInfoProvider(IElementInfoProvider provider);

  /**
   * Adds a listener for updates of the lazy loading status. Has no effect if the
   * same listener was already added
   *
   * @param l the listener to be added
   */
  void addLazyLoadingListener(ILazyLoadingListener l);

  /**
   * Removes a listener for updates of the lazy loading status. Has no effect if
   * the same listener was already removed
   *
   * @param l the listener to be removed
   */
  void removeLazyLoadingListener(ILazyLoadingListener l);
}
