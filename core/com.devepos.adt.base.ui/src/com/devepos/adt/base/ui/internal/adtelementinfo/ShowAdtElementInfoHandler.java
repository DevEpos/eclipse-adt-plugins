package com.devepos.adt.base.ui.internal.adtelementinfo;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.base.ui.adtelementinfo.AdtElementInformationUtil;
import com.devepos.adt.base.ui.adtelementinfo.IAdtElementInfoConstants;

/**
 * Command handler to show ADT element information for the currently selected
 * control of a Table or Tree control
 *
 * @author stockbal
 */
public class ShowAdtElementInfoHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    var selectedControl = getSelectedControl(event);
    if (selectedControl == null) {
      return null;
    }

    var context = AdtElementInfoContextBuilder.buildFromCurrentSelection();
    if (context != null) {
      AdtElementInformationUtil.showElementInformation(context.getProject(),
          context.getObjectReference(), selectedControl);
    }
    return null;

  }

  @Override
  public boolean isEnabled() {
    return AdtElementInformationUtil.isElementInfoAvailable(null);
  }

  private Control getSelectedControl(final ExecutionEvent event) {
    Object control = null;
    if (event.getTrigger() instanceof Event) {
      control = ((Event) event.getTrigger()).widget;
    }

    if (control instanceof MenuItem) {
      var menu = ((MenuItem) control).getParent();
      if (menu != null) {
        control = menu.getData(IAdtElementInfoConstants.MENU_CONTROL_ID_FOR_CMD);
      }
    }

    if (control instanceof Tree || control instanceof Table) {
      return (Control) control;
    }
    return null;
  }

}
