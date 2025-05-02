package com.devepos.adt.base.ui.adtelementinfo;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.base.ui.internal.adtelementinfo.ShowAdtElementInfoHandler;

/**
 * @author stockbal
 */
public interface IAdtElementInfoConstants {

  /**
   * Custom Id to store {@link Table} or {@link Tree} control in a {@link Menu} instance.
   * 
   * @see ShowAdtElementInfoHandler
   */
  String MENU_CONTROL_ID_FOR_CMD = "com.devepos.adt.base.ui.elementinfo.control";
}
