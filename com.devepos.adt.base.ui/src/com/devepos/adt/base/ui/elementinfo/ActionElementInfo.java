package com.devepos.adt.base.ui.elementinfo;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.base.elementinfo.ElementInfoBase;
import com.devepos.adt.base.ui.action.IExecutable;

/**
 * Represents the action which can be executed on an element information
 *
 * @author stockbal
 */
public class ActionElementInfo extends ElementInfoBase implements IExecutableElementInfo {

	private final IExecutable action;

	public ActionElementInfo(final String name, final Image image, final IExecutable action) {
		super(name, image);
		this.action = action;
	}

	@Override
	public IExecutable getExecutable() {
		return this.action;
	}

}
