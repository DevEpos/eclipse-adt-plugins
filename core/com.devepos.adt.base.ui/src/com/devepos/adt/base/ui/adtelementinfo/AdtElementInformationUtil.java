package com.devepos.adt.base.ui.adtelementinfo;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;

import com.sap.adt.blues.core.ui.elementinfo.AdtShowElementInfoAction;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

@SuppressWarnings("restriction")
public class AdtElementInformationUtil {

  public static void showElementInformation(final IProject project,
      final IAdtObjectReference adtObjRef, final Tree tree) {
    new AdtShowElementInfoAction(project, () -> adtObjRef, tree).run();
  }

  public static void showElementInformation(final IProject project,
      final IAdtObjectReference adtObjRef, final Table table) {
    new AdtShowElementInfoAction(project, () -> adtObjRef, table).run();
  }
}
