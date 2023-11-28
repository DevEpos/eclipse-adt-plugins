package com.devepos.adt.saat.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.CdsAnalysisView;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;

public class RenameCdsAnalysisViewHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    var activePart = HandlerUtil.getActivePart(event);
    if (activePart instanceof CdsAnalysisView) {
      var cdsAnalysisView = (CdsAnalysisView) activePart;
      var inputDialog = new InputDialog(HandlerUtil.getActiveShell(event),
          Messages.RenameCdsAnalysisViewHandler_DialogTitle_xtit,
          Messages.RenameCdsAnalysisViewHandler_NewViewNameInput_xlbl,
          cdsAnalysisView.getPartName(),
          value -> (StringUtil.isEmpty(value)
              ? Messages.RenameCdsAnalysisViewHandler_EmptyViewNameError_xmsg
              : null)) {
        @Override
        public void create() {
          super.create();
          getShell().setImage(SearchAndAnalysisPlugin.getDefault().getImage(IImages.CDS_ANALYZER));
        }
      };

      if (inputDialog.open() == Window.OK) {
        cdsAnalysisView.setViewName(inputDialog.getValue());
      }
    }
    return null;
  }

}
