package com.devepos.adt.base.ui.elementinfo;

import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.ui.action.IExecutable;

/**
 * Element information that holds an Action
 *
 * @author stockbal
 */
public interface IExecutableElementInfo extends IElementInfo {
    /**
     * Returns the action of this element information
     *
     * @return
     */
    IExecutable getExecutable();
}
