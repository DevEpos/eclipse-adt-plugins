package com.devepos.adt.tools.base.ui.tree;

import org.eclipse.jface.viewers.StyledString;

/**
 * A tree node with styled text content
 *
 * @author stockbal
 */
public interface IStyledTreeNode {

	/**
	 * @return a styled String
	 */
	StyledString getStyledText();
}
