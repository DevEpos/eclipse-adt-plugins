package com.devepos.adt.atm.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.atm.ui.internal.views.AbapTagManagerView;
import com.devepos.adt.base.ui.project.ProjectUtil;

public class ShowTagManagerHandler extends AbstractHandler {

  public static final String PARAMETER_TAG_ID = "com.devepos.adt.atm.ui.showTagManager.tagId";
  public static final String COMMAND_ID = "com.devepos.adt.atm.ui.command.showTagManager";

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    var tagId = event.getParameter(PARAMETER_TAG_ID);
    var currentProject = ProjectUtil.getCurrentAbapProject(HandlerUtil.getCurrentSelection(event));

    try {
      var page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
      var viewPart = page.showView(AbapTagManagerView.VIEW_ID);
      if (tagId != null && viewPart instanceof AbapTagManagerView) {
        var view = (AbapTagManagerView) viewPart;
        view.activate(currentProject, tagId);
      }
    } catch (PartInitException e) {
      e.printStackTrace();
    }
    return null;
  }

}