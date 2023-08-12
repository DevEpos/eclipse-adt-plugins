package com.devepos.adt.base.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.PageBookView;

import com.devepos.adt.base.ui.tree.IFilterableView;

/**
 * Command handler for toggling a text inline filer, i.e. a filter input above a
 * filterable viewer
 *
 * @author stockbal
 *
 */
public class ToggleTextFilterHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
    if (activePart == null) {
      return null;
    }
    IFilterableView filterableView = null;
    if (!(activePart instanceof IFilterableView)) {
      // check if page book view
      if (activePart instanceof PageBookView) {
        var page = ((PageBookView) activePart).getCurrentPage();
        if (page instanceof IFilterableView) {
          filterableView = (IFilterableView) page;
        }
      }
    } else {
      filterableView = (IFilterableView) activePart;
    }
    if (filterableView != null) {
      filterableView.toggleTextFilterVisibility();
    }
    return null;
  }

}
