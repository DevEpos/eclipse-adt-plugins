package com.devepos.adt.base.ui.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Wrapper for classes
 * <ul>
 * <li>com.sap.adt.tools.core.ui.dialogs.LinkToAdtPropertyPageBlock</li>
 * <li>com.sap.adt.tools.core.ui.dialogs.LinkToAdtPreferencePageBlock</li>
 * </ul>
 * Can be used to create a link to open project specific property pages or
 * workspace specific preference pages.
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface ILinkToAdtPageBlock {

  /**
   * Creates the link control
   *
   * @param parent          the parent composite
   * @param layoutDataToSet the layout data for the link
   * @return
   */
  Control createControl(Composite parent, Object layoutDataToSet);
}
