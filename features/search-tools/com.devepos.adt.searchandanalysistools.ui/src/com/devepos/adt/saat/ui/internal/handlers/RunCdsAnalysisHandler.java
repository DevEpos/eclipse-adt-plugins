package com.devepos.adt.saat.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.saat.ui.internal.cdsanalysis.view.RunCdsAnalysisAction;
import com.devepos.adt.saat.ui.internal.cdsanalysis.view.RunNewCdsAnalysisDialog;

/**
 * Command handler to run a new CDS analysis via dialog
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class RunCdsAnalysisHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    RunNewCdsAnalysisDialog dialog = new RunNewCdsAnalysisDialog(HandlerUtil.getActiveShell(event));
    if (dialog.open() == Window.OK) {
      var objectRef = dialog.getSelectedObject();
      var project = dialog.getProject();
      var runAnalysisAction = new RunCdsAnalysisAction(null, dialog.getSelectedAnalysisType(),
          objectRef, project, dialog.isRunInNew());
      runAnalysisAction.run();
    }
    return null;
  }
}
