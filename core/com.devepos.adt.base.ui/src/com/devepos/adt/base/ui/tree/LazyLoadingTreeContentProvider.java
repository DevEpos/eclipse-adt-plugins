package com.devepos.adt.base.ui.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
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

  private final Map<ILazyLoadingNode, Job> loadingJobs = new HashMap<>();

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
    Assert.isTrue(
        refreshExpansionLevel == AbstractTreeViewer.ALL_LEVELS || refreshExpansionLevel > 0);
    refreshModeExpansionLevel = refreshExpansionLevel;
    this.refreshMode = refreshMode;
  }

  /**
   * Cancels the current lazy node child loading job
   */
  public void cancelChildLoading(final ILazyLoadingNode node) {
    var jobForNode = loadingJobs.get(node);
    if (jobForNode != null) {
      node.resetLoadedState();
      jobForNode.cancel();
      loadingJobs.remove(node);
    }
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
    var loadingJob = new ChildElementLoadingJob(jobName, viewer.getControl().getDisplay(),
        lazyNode);
    loadingJobs.put(lazyNode, loadingJob);

    loadingJob.schedule();
  }

  /**
   * Job for loading the child nodes of an element
   */
  protected class ChildElementLoadingJob extends Job {
    private final Display display;
    private final ILazyLoadingNode lazyLoadingNode;

    public ChildElementLoadingJob(final String jobName, final Display display,
        final ILazyLoadingNode lazyLoadingNode) {
      super(jobName);
      this.display = display;
      this.lazyLoadingNode = lazyLoadingNode;
    }

    @Override
    public IStatus run(final IProgressMonitor monitor) {
      var wrappedLoadingError = new AtomicReference<CoreException>(null);
      try {
        lazyLoadingNode.loadChildren(monitor);
      } catch (final CoreException exc) {
        wrappedLoadingError.set(exc);
      }
      if (monitor.isCanceled()) {
        loadingJobs.remove(lazyLoadingNode);
        return Status.CANCEL_STATUS;
      }
      var treeUpdateJob = new TreeUpdateJob(display,
          Messages.LazyLoadingTreeContentProvider_UpdatingTreeContent_xmsg, lazyLoadingNode,
          wrappedLoadingError.get());

      treeUpdateJob.setSystem(true);
      treeUpdateJob.schedule();

      loadingJobs.remove(lazyLoadingNode);

      return Status.OK_STATUS;
    }

  }

  /**
   * Job to update the lazy loading node and its loaded child nodes
   */
  protected class TreeUpdateJob extends WorkbenchJob {
    private final CoreException loadingError;
    private final ILazyLoadingNode lazyLoadingNode;

    public TreeUpdateJob(final Display jobDisplay, final String name,
        final ILazyLoadingNode lazyLoadingNode, final CoreException loadingError) {
      super(jobDisplay, name);
      this.lazyLoadingNode = lazyLoadingNode;
      this.loadingError = loadingError;
    }

    @Override
    public IStatus runInUIThread(final IProgressMonitor monitor) {
      final Control control = viewer.getControl();
      if (control.isDisposed()) {
        return Status.CANCEL_STATUS;
      }
      monitor.beginTask(Messages.LazyLoadingTreeContentProvider_UpdatingTreeContent_xmsg, -1);
      refreshLazyNode();
      monitor.done();
      if (loadingError != null) {
        return loadingError.getStatus();
      }
      return Status.OK_STATUS;
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

    private void expandNode(final ITreeNode child, final LazyLoadingRefreshMode refreshMode) {
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