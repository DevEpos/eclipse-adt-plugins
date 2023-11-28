package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

import java.util.Arrays;
import java.util.LinkedList;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.util.Logging;
import com.devepos.adt.saat.ui.internal.ViewPartLookup;
import com.devepos.adt.saat.ui.internal.cdsanalysis.CdsAnalysisType;
import com.devepos.adt.saat.ui.internal.messages.Messages;

/**
 * This class manages all open Views of the CDS Analyzer.<br>
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class CdsAnalysisViewManager {

  private static CdsAnalysisViewManager instance;
  private final LinkedList<CdsAnalysisView> openViews;

  private CdsAnalysisViewManager() {
    openViews = new LinkedList<>();
  }

  public static CdsAnalysisViewManager getInstance() {
    if (instance == null) {
      instance = new CdsAnalysisViewManager();
    }
    return instance;
  }

  /**
   * Retrieves the CDS Analysis view from the workspace
   *
   * @param type analysis type
   */
  public CdsAnalysisView activateCdsAnalysisView(final boolean openNew,
      final CdsAnalysisType type) {
    CdsAnalysisView existingView = null;
    final var activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

    if (activePage == null) {
      return null;
    }

    try {
      if (!openNew) {
        existingView = findLruAnalysisView(activePage, true, type);
      }
      String secondaryId = null;
      if (existingView == null) {
        if (activePage.findViewReference(CdsAnalysisView.VIEW_ID) != null) {
          secondaryId = String.valueOf(openViews.size() + 1);
        }
      } else {
        secondaryId = existingView.getViewSite().getSecondaryId();
      }
      var newView = (CdsAnalysisView) activePage.showView(CdsAnalysisView.VIEW_ID, secondaryId,
          IWorkbenchPage.VIEW_ACTIVATE);
      if (existingView == null) {
        newView.setViewName(String.format("%s (%d)", Messages.CdsAnalysisViewManager_ViewName_xtit, //$NON-NLS-1$
            openViews.size()));
        newView.setConfiguredAnalysisTypes(Arrays.asList(CdsAnalysisType.values()));
      }
      return newView;
    } catch (final PartInitException e) {
      Logging.getLogger(ViewPartLookup.class).error(e);
    }
    return null;
  }

  public void showNewCdsAnalysisView() {
    final var activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

    if (activePage == null) {
      return;
    }
    String secondaryId = null;
    if (activePage.findViewReference(CdsAnalysisView.VIEW_ID) != null) {
      secondaryId = String.valueOf(openViews.size() + 1);
    }
    try {
      var newView = (CdsAnalysisView) activePage.showView(CdsAnalysisView.VIEW_ID, secondaryId,
          IWorkbenchPage.VIEW_ACTIVATE);
      newView.setViewName(String.format("%s (%d)", Messages.CdsAnalysisViewManager_ViewName_xtit, //$NON-NLS-1$
          openViews.size()));
      newView.setConfiguredAnalysisTypes(Arrays.asList(CdsAnalysisType.values()));
    } catch (PartInitException e) {
      Logging.getLogger(ViewPartLookup.class).error(e);
    }
  }

  public void cdsAnalysisViewActivated(final CdsAnalysisView view) {
    openViews.remove(view);
    openViews.addFirst(view);
  }

  public void cdsAnalysisViewClosed(final CdsAnalysisView view) {
    openViews.remove(view);
  }

  /**
   * Checks if the given CDS analysis is shown in any of the open CDS Analyzer
   * views
   *
   * @param analysis the analysis to be checked
   * @return <code>true</code> if the given analysis is shown in any view
   */
  public boolean isAnalysisShown(final CdsAnalysis analysis) {
    synchronized (openViews) {
      for (final var view : openViews) {
        final var shownAnalysis = view.getCurrentAnalysis();
        if (shownAnalysis == analysis) {
          return true;
        }
      }
      return false;
    }
  }

  private CdsAnalysisView findLruAnalysisView(final IWorkbenchPage page,
      final boolean avoidPinnedViews, final CdsAnalysisType targetType) {
    boolean viewFoundInPage = false;
    for (var view : openViews) {
      if (page.equals(view.getSite().getPage())) {
        viewFoundInPage = true;
        if (avoidPinnedViews && view.isPinned()) {
          continue;
        }
        if (view.getConfiguredAnalysisTypes().contains(targetType)) {
          return view;
        }
      }
    }

    if (!viewFoundInPage) {
      // find unresolved views
      var viewReferences = page.getViewReferences();
      for (var curr : viewReferences) {
        if (CdsAnalysisView.VIEW_ID.equals(curr.getId()) && page.equals(curr.getPage())) {
          var view = (CdsAnalysisView) curr.getView(true);
          if (view != null && (!avoidPinnedViews || !view.isPinned())
              && view.getConfiguredAnalysisTypes().contains(targetType)) {
            return view;
          }

        }
      }
    }
    return null;
  }
}
