package com.devepos.adt.base.ui.tree;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.WorkbenchJob;

import com.devepos.adt.base.elementinfo.ILazyLoadableContent;
import com.devepos.adt.base.elementinfo.LazyLoadingRefreshMode;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.util.ObjectContainer;

/**
 * Tree content provider which implements a lazy loading mechanism to fetch
 * further child nodes
 *
 * @author stockbal
 */
public class LazyLoadingTreeContentProvider extends TreeContentProvider {

  protected TreeViewer viewer;

  private int refreshModeExpansionLevel;
  private LazyLoadingRefreshMode refreshMode;
  private INodeExpansionCheck expansionCheck;

  /**
   * Creates new instance of a tree content provider that support lazy loading of
   * the child nodes of a given node
   *
   * @see ILazyLoadingNode
   */
  public LazyLoadingTreeContentProvider() {
    this(null, 1);
  }

  /**
   * Creates new instance of a tree content provider that support lazy loading of
   * the child nodes of a given node. <br>
   * This constructor allows the setting of refresh mode which shall be used to
   * refresh/expand collection nodes which were lazily loaded. <br>
   * If a non <code>null</code> value was supplied any <code>refresh mode</code>
   * at a node that was set via
   * {@link ILazyLoadableContent#setContentRefreshMode(LazyLoadingRefreshMode)}
   * will be ignored <br>
   * <br>
   * <strong>WARNING:</strong> <br>
   * Setting the refresh mode to
   * {@link LazyLoadingRefreshMode#ROOT_AND_ALL_CHILDREN} can potentially result
   * in a momentary freezing of the user interface if the resulting hierarchy is
   * very big
   *
   * @param refreshMode           the mode which shall be used to refresh lazy
   *                              loaded children
   * @param refreshExpansionLevel the level to which the child nodes that will be
   *                              refreshed depending on the
   *                              <code>refreshMode</code> parameter
   * @see ILazyLoadingNode
   * @see ICollectionTreeNode
   */
  public LazyLoadingTreeContentProvider(final LazyLoadingRefreshMode refreshMode,
      final int refreshExpansionLevel) {
    viewer = null;
    setNodeRefreshOptions(refreshExpansionLevel, refreshMode);
  }

  @FunctionalInterface
  public interface INodeExpansionCheck {
    /**
     * If the given tree node should be expanded the method has to return
     * <code>true</code> <br>
     * The default implementation allows expansion for all nodes. Sub classes should
     * override for custom logic
     *
     * @param node tree node that has child nodes
     * @return <code>true</code> if the given node should be expanded
     */
    boolean shouldExpandNode(ITreeNode node);
  }

  @Override
  public Object[] getChildren(final Object parentElement) {
    if (parentElement instanceof LoadingTreeItemsNode
        || !(parentElement instanceof ICollectionTreeNode)) {
      return EMPTY_ARRAY;
    }
    final ICollectionTreeNode collectionNode = (ICollectionTreeNode) parentElement;

    if (parentElement instanceof ILazyLoadingNode) {
      final ILazyLoadingNode lazyNode = (ILazyLoadingNode) parentElement;
      if (lazyNode.isLoaded()) {
        return getChildren(collectionNode);
      }
      if (lazyNode.isLoading()) {
        return new Object[] { LoadingTreeItemsNode.INSTANCE };
      }
      // start retrieval of the children of the node
      startChildNodeRetrieval(lazyNode);
      return new Object[] { LoadingTreeItemsNode.INSTANCE };
    }
    if (parentElement instanceof ICollectionTreeNode) {
      return getChildren((ICollectionTreeNode) parentElement);
    }
    return EMPTY_ARRAY;
  }

  @Override
  public boolean hasChildren(final Object element) {
    if (element instanceof LoadingTreeItemsNode) {
      return false;
    }
    if (element instanceof ICollectionTreeNode) {
      if (!(element instanceof ILazyLoadingNode) || ((ILazyLoadingNode) element).isLoaded()) {
        return ((ICollectionTreeNode) element).hasChildren();
      }
      return true;
    }

    return false;
  }

  @Override
  public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
    this.viewer = (TreeViewer) viewer;
  }

  /**
   * Sets expansion checker to be used during refresh of lazy loading loading node
   *
   * @param expansionCheck the check function to be used during expansion of a
   *                       {@link ICollectionNode}
   */
  public void setExpansionChecker(final INodeExpansionCheck expansionCheck) {
    this.expansionCheck = expansionCheck;
  }

  /**
   * Sets parameters for the node refresh
   *
   * @param refreshExpansionLevel level to expand child nodes after they were loaded dynamically
   * @param refreshMode           refresh mode for sub nodes
   */
  public void setNodeRefreshOptions(final int refreshExpansionLevel,
      final LazyLoadingRefreshMode refreshMode) {
    Assert.isTrue(refreshExpansionLevel == AbstractTreeViewer.ALL_LEVELS
        || refreshExpansionLevel > 0);
    refreshModeExpansionLevel = refreshExpansionLevel;
    this.refreshMode = refreshMode;
  }

  protected void refreshViewer() {
    if (viewer == null) {
      return;
    }
    var tree = viewer.getTree();
    if (tree == null || tree.isDisposed()) {
      return;
    }
    viewer.refresh();
  }

  private void startChildNodeRetrieval(final ILazyLoadingNode lazyNode) {
    String jobName = lazyNode.getLazyLoadingJobName();
    if (jobName == null) {
      jobName = NLS.bind(Messages.LazyLoadingTreeContentProvider_LoadingChildNodes_xmsg,
          ((ITreeNode) lazyNode).getDisplayName());
    }
    Job.create(jobName, new ChildElementLoader(viewer.getControl().getDisplay(), lazyNode))
        .schedule();
  }

  /**
   * Job for loading the child nodes of an element
   *
   * @author Ludwig Stockbauer-Muhr
   */
  protected class ChildElementLoader implements ICoreRunnable {
    private final Display display;
    private final ILazyLoadingNode lazyLoadingNode;

    public ChildElementLoader(final Display display, final ILazyLoadingNode lazyLoadingNode) {
      this.display = display;
      this.lazyLoadingNode = lazyLoadingNode;

    }

    @Override
    public void run(final IProgressMonitor monitor) throws CoreException {
      var wrappedLoadingError = new ObjectContainer<CoreException>(null);
      try {
        lazyLoadingNode.loadChildren();
      } catch (final CoreException exc) {
        wrappedLoadingError.setObject(exc);
      }
      monitor.done();
      final WorkbenchJob treeUpdateJob = new WorkbenchJob(display,
          Messages.LazyLoadingTreeContentProvider_UpdatingTreeContent_xmsg) {

        @Override
        public IStatus runInUIThread(final IProgressMonitor monitor) {
          final Control control = viewer.getControl();
          if (control.isDisposed()) {
            return Status.CANCEL_STATUS;
          }
          monitor.beginTask(Messages.LazyLoadingTreeContentProvider_UpdatingTreeContent_xmsg, -1);
          refreshLazyNode();
          monitor.done();
          var loadingError = wrappedLoadingError.getObject();
          if (loadingError != null) {
            return loadingError.getStatus();
          }
          return Status.OK_STATUS;
        }
      };
      treeUpdateJob.setSystem(true);
      treeUpdateJob.schedule();
    }

    private void refreshLazyNode() {
      viewer.refresh(lazyLoadingNode);
      final var refreshMode = LazyLoadingTreeContentProvider.this.refreshMode != null
          ? LazyLoadingTreeContentProvider.this.refreshMode
          : lazyLoadingNode.getContentRefreshMode();
      if (refreshMode == LazyLoadingRefreshMode.ROOT_ONLY
          || !(lazyLoadingNode instanceof ICollectionTreeNode)) {
        return;
      }
      expandChildren(refreshMode, ((ICollectionTreeNode) lazyLoadingNode).getChildren());
    }

    private void expandChildren(final LazyLoadingRefreshMode refreshMode,
        final List<ITreeNode> children) {
      if (children == null || children.isEmpty()) {
        return;
      }
      for (final ITreeNode child : children.stream()
          .filter(ICollectionTreeNode.class::isInstance)
          .collect(Collectors.toList())) {
        if (refreshMode == LazyLoadingRefreshMode.ROOT_AND_NON_LAZY_CHILDREN
            && child instanceof ILazyLoadingNode) {
          continue;
        }
        expandNode(child, refreshMode);
      }
    }

    private void expandNode(final ITreeNode child, LazyLoadingRefreshMode refreshMode) {
      if (expansionCheck != null && !expansionCheck.shouldExpandNode(child)) {
        return;
      }
      if (viewer instanceof LazyLoadingTreeViewer) {
        ((LazyLoadingTreeViewer) viewer).expandNode(child, refreshModeExpansionLevel,
            refreshMode == LazyLoadingRefreshMode.ROOT_AND_NON_LAZY_CHILDREN);
      } else {
        viewer.expandToLevel(child, refreshModeExpansionLevel, true);
      }
    }
  }
}