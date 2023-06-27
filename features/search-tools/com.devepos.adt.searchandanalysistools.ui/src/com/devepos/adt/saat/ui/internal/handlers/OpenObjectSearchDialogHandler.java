package com.devepos.adt.saat.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.saat.ui.internal.search.view.ObjectSearchPage;

/**
 * Handler for opening the ABAP Object Search + in the eclipse search dialog
 *
 * @author stockbal
 */
public class OpenObjectSearchDialogHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    NewSearchUI.openSearchDialog(HandlerUtil.getActiveWorkbenchWindow(event),
        ObjectSearchPage.PAGE_ID);
    return null;
  }

}
