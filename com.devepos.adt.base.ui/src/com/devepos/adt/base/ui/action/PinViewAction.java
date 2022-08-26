package com.devepos.adt.base.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IPinnableView;
import com.devepos.adt.base.ui.internal.messages.Messages;

/**
 * Pins the currently visible view
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class PinViewAction extends Action {

  private final IPinnableView view;

  public PinViewAction(final IPinnableView view) {
    super(Messages.PinViewAction_actionLabel_xlbl, IAction.AS_CHECK_BOX);
    this.view = view;
    setImageDescriptor(AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.PIN_VIEW));
    setToolTipText(Messages.PinViewAction_actionTooltip_xtol);
    setChecked(view.isPinned());
  }

  @Override
  public void run() {
    view.setPinned(isChecked());
  }

}
