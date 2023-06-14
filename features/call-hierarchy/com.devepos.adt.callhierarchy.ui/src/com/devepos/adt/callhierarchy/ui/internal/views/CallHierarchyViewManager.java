package com.devepos.adt.callhierarchy.ui.internal.views;

import java.util.LinkedList;

import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.callhierarchy.ui.internal.CallHierarchyInput;

/**
 * This class manages all open Views of the CDS Analyzer.<br>
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class CallHierarchyViewManager {

  private static CallHierarchyViewManager instance;
  private static int viewCount = 0;
  private final LinkedList<CallHierarchyView> openViews;

  private CallHierarchyViewManager() {
    openViews = new LinkedList<>();
  }

  public static CallHierarchyViewManager getInstance() {
    if (instance == null) {
      instance = new CallHierarchyViewManager();
    }
    return instance;
  }

  /**
   * Retrieves the Call Hierarchy view from the workspace
   *
   * @return
   */
  public CallHierarchyView activateHierarchyView(final boolean openNew) {
    CallHierarchyView view = null;
    final IWorkbenchPage activePage = PlatformUI.getWorkbench()
        .getActiveWorkbenchWindow()
        .getActivePage();

    if (activePage == null) {
      return null;
    }

    try {
      if (!openNew) {
        view = findLruHierarchyView(activePage, true);
      }
      String secondaryId = null;
      if (view == null) {
        if (activePage.findViewReference(CallHierarchyView.VIEW_ID) != null) {
          secondaryId = String.valueOf(++viewCount);
        }
      } else {
        secondaryId = view.getViewSite().getSecondaryId();
      }
      return (CallHierarchyView) activePage.showView(CallHierarchyView.VIEW_ID, secondaryId,
          IWorkbenchPage.VIEW_ACTIVATE);
    } catch (final PartInitException e) {
      // Logging.getLogger(CallHierarchyViewManager.class).error(e);
    }
    return view;
  }

  public void hierarchyViewActivated(final CallHierarchyView view) {
    openViews.remove(view);
    openViews.addFirst(view);
  }

  public void hierarchyViewClosed(final CallHierarchyView view) {
    openViews.remove(view);
  }

  /**
   * Checks if the given hierarchy result is shown in any of the open CDS Analyzer
   * views
   *
   * @param hierarchyResult the hierarchy result to be checked
   * @return <code>true</code> if the given hierarchy result is shown in any view
   */
  public boolean isHierarchyShown(final CallHierarchyInput hierarchyResult) {
    synchronized (openViews) {
      for (final CallHierarchyView view : openViews) {
        final CallHierarchyInput shownAnalysis = view.getCurrentInput();
        if (shownAnalysis == hierarchyResult) {
          return true;
        }
      }
      return false;
    }
  }

  private CallHierarchyView findLruHierarchyView(final IWorkbenchPage page,
      final boolean avoidPinnedViews) {
    boolean viewFoundInPage = false;
    for (CallHierarchyView view : openViews) {
      if (page.equals(view.getSite().getPage())) {
        if (!avoidPinnedViews || !view.isPinned()) {
          return view;
        }
        viewFoundInPage = true;
      }
    }

    if (!viewFoundInPage) {
      // find unresolved views
      IViewReference[] viewReferences = page.getViewReferences();
      for (IViewReference curr : viewReferences) {
        if (CallHierarchyView.VIEW_ID.equals(curr.getId()) && page.equals(curr.getPage())) {
          CallHierarchyView view = (CallHierarchyView) curr.getView(true);
          if (view != null && (!avoidPinnedViews || !view.isPinned())) {
            return view;
          }

        }
      }
    }
    return null;
  }
}
