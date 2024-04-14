package com.devepos.adt.base.ui.tree;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.LazyLoadingRefreshMode;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * ADT Object Reference node, which supports the lazy loading of its children.
 *
 * @author stockbal
 */
public class LazyLoadingAdtObjectReferenceNode extends AdtObjectReferenceNode
    implements ILazyLoadingNode {
  private boolean isLoading;
  private boolean isLoaded;
  private IElementInfoProvider provider;
  private LazyLoadingRefreshMode refreshMode;
  private final List<ILazyLoadingListener> lazyLoadingListeners = new ArrayList<>();

  public LazyLoadingAdtObjectReferenceNode(final ICollectionTreeNode parent) {
    this("", "", "", null, parent);
  }

  public LazyLoadingAdtObjectReferenceNode(final String name, final String displayName,
      final String description, final IAdtObjectReference objectReference,
      final ICollectionTreeNode parent) {
    super(name, displayName, description, objectReference, parent);
  }

  @Override
  public void addLazyLoadingListener(final ILazyLoadingListener l) {
    if (l == null) {
      throw new IllegalArgumentException();
    }
    lazyLoadingListeners.add(l);
  }

  @Override
  public LazyLoadingRefreshMode getContentRefreshMode() {
    return refreshMode != null ? refreshMode : ILazyLoadingNode.super.getContentRefreshMode();
  }

  @Override
  public String getLazyLoadingJobName() {
    return provider != null ? provider.getProviderDescription() : null;
  }

  @Override
  public String getSizeAsString() {
    if (isLoading || !isLoaded) {
      return "?";
    }
    if (children != null) {
      return new DecimalFormat("###,###").format(children.size());
    }
    return "0";
  }

  @Override
  public boolean hasChildren() {
    return !isLoaded || children != null && !children.isEmpty();
  }

  @Override
  public boolean isLoaded() {
    return isLoaded;
  }

  @Override
  public boolean isLoading() {
    return isLoading;
  }

  @Override
  public void loadChildren(final IProgressMonitor monitor) throws CoreException {
    isLoading = true;
    CoreException loadingError = null;
    try {
      loadChildrenInternal(monitor);
    } catch (CoreException exc) {
      loadingError = exc;
    }
    isLoading = false;
    isLoaded = true;
    for (final ILazyLoadingListener l : lazyLoadingListeners) {
      l.loadingFinished(children != null ? children.size() : 0);
    }

    if (loadingError != null) {
      throw loadingError;
    }
  }

  @Override
  public void removeLazyLoadingListener(final ILazyLoadingListener l) {
    lazyLoadingListeners.remove(l);

  }

  @Override
  public void resetLoadedState() {
    isLoaded = false;
    isLoading = false;
    if (children != null) {
      children.clear();
    }
    children = null;
  }

  @Override
  public void setContentRefreshMode(final LazyLoadingRefreshMode mode) {
    refreshMode = mode;
  }

  @Override
  public void setElementInfoProvider(final IElementInfoProvider provider) {
    this.provider = provider;
  }

  /**
   * Internal logic for loading the child nodes of this tree node
   */
  protected void loadChildrenInternal(final IProgressMonitor monitor) throws CoreException {
    if (provider == null) {
      return;
    }
    try {
      final List<IElementInfo> elements = provider.getElements(monitor);
      if (elements == null || elements.isEmpty()) {
        return;
      }

      // create the sub nodes
      new TreeNodeCreator(this).createSubNodes(elements);
    } catch (Throwable t) {
      addChild(new LoadingErrorNode(this, Messages.LazyLoadingNode_ErrorDuringLoading_xmsg, t));
      throw new CoreException(
          new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, t.getMessage(), t));
    }
  }
}
