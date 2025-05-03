package com.devepos.adt.base.ui.adtelementinfo;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.IGeneralCommandConstants;
import com.devepos.adt.base.ui.action.CommandFactory;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.sap.adt.blues.core.ui.elementinfo.AdtShowElementInfoAction;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Utility to interact with the ADT Element information service
 */
public class AdtElementInformationUtil {

  public static void showElementInformation(final IProject project,
      final IAdtObjectReference adtObjRef, final Control control) {
    if (control instanceof Tree) {
      showElementInformation(project, adtObjRef, ((Tree) control));
    } else if (control instanceof Table) {
      showElementInformation(project, adtObjRef, ((Table) control));
    } else {
      throw new IllegalArgumentException(
          "Parameter 'control' must be an instance of Table or Tree");
    }
  }

  @SuppressWarnings("restriction")
  public static void showElementInformation(final IProject project,
      final IAdtObjectReference adtObjRef, final Tree tree) {
    new AdtShowElementInfoAction(project, () -> adtObjRef, tree).run();
  }

  @SuppressWarnings("restriction")
  public static void showElementInformation(final IProject project,
      final IAdtObjectReference adtObjRef, final Table table) {
    new AdtShowElementInfoAction(project, () -> adtObjRef, table).run();
  }

  @SuppressWarnings("restriction")
  public static boolean isElementInfoAvailable(IProject project) {
    if (project == null) {
      project = ProjectUtil.getCurrentAbapProject();
    }
    return project != null && AdtShowElementInfoAction.isAvailable(project);
  }

  /**
   * Creates command contribution item for the "Show Element Information" command
   * 
   * @param visibleEnabled if {@code true} the enabled state of the command will control the
   *                       visibility of the menu item
   * @return the created command contribution item
   */
  public static IContributionItem createElementInfoCommand(boolean visibleEnabled) {
    return CommandFactory.createContribItem(IGeneralCommandConstants.SHOW_ADT_ELEMENT_INFORMATION,
        null, AdtBaseUIResources.getString(IAdtBaseStrings.Action_ShowElementInformation_xmsg),
        visibleEnabled, null);
  }
}
