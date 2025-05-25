package com.devepos.adt.base.ui.viewsupport;

import java.util.stream.Stream;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class ViewLookup {

  public static boolean isViewVisible(final String id) {
    IViewPart view;
    try {
      view = lookupView(id, false);
      return view != null && PlatformUI.getWorkbench()
          .getActiveWorkbenchWindow()
          .getActivePage()
          .isPartVisible(view);
    } catch (PartInitException e) {
      e.printStackTrace();
    }
    return false;
  }

  public static <T extends IViewPart> T lookupView(final String id, final boolean showIfClosed,
      final Class<T> expectingViewClass) throws PartInitException {
    var view = lookupView(id, showIfClosed);
    return view != null
        ? (expectingViewClass == view.getClass() ? expectingViewClass.cast(view) : null)
        : null;
  }

  public static IViewPart lookupView(final String id, final boolean showIfClosed)
      throws PartInitException {
    var activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    if (activePage == null) {
      return null;
    }

    var view = activePage.findView(id);
    if (view == null) {
      // fallback search in all references. Unclear why `.findView()` does not always return the
      // view part
      var viewRef = Stream.of(activePage.getViewReferences())
          .filter(v -> id.equals(v.getId()))
          .findFirst();

      if (viewRef.isPresent()) {
        view = viewRef.get().getView(false);
      }
    }

    if (view == null && showIfClosed) {
      view = activePage.showView(id);
    }

    return view;
  }
}
