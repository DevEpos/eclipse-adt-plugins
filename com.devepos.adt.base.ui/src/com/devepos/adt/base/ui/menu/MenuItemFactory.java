package com.devepos.adt.base.ui.menu;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

/**
 * Factory for creating items for menus
 *
 * @author stockbal
 */
public class MenuItemFactory {

	/**
	 * Adds a {@link CommandContributionItem} for the given <code>commandId</code>
	 * to the supplied {@link IMenuManager}
	 *
	 * @param mgr        the {@link IMenuManager} to which the command should be
	 *                   added
	 * @param groupId    the group name where the command should be inserted in the
	 *                   menu or <code>null</code>
	 * @param commandId  the fully qualified id of the command
	 * @param imageDescr an image descriptor for the command item
	 * @param label      the label of the menu entry
	 * @param params     an optional list of parameter key/value pairs for the
	 *                   command
	 */
	public static void addCommandItem(final IMenuManager mgr, final String groupId, final String commandId,
		final ImageDescriptor imageDescr, final String label, final String[][] params) {
		final IContributionItem commandItem = createCommandContributionItem(groupId, commandId, imageDescr, label, true, params);
		if (groupId != null) {
			mgr.appendToGroup(groupId, commandItem);
		} else {
			mgr.add(commandItem);
		}
	}

	/**
	 * Adds a {@link CommandContributionItem} for the given <code>commandId</code>
	 * to the supplied {@link IToolBarManager}
	 *
	 * @param tbm            the toolbar manager instance
	 * @param groupId        the group id to which the command should be added
	 * @param commandId      a unique identifier of a command
	 * @param imageDescr     an image descriptor for the command item
	 * @param label          the label to be displayed for the command
	 * @param visibleEnabled if <code>true</code> the visibility of the contribution
	 *                       item will depend on the <code>enabled</code> state of
	 *                       the command
	 * @param params         an optional two dimensional array of command parameters
	 */
	public static void addCommandItem(final IToolBarManager tbm, final String groupId, final String commandId,
		final ImageDescriptor imageDescr, final String label, final boolean visibleEnabled, final String[][] params) {

		final IContributionItem commandItem = createCommandContributionItem(groupId, commandId, imageDescr, label, visibleEnabled,
			params);

		if (groupId != null) {
			tbm.appendToGroup(groupId, commandItem);
		} else {
			tbm.add(commandItem);
		}
	}

	private static IContributionItem createCommandContributionItem(final String groupId, final String commandId,
		final ImageDescriptor imageDescr, final String label, final boolean visibleEnabled, final String[][] params) {
		Map<String, String> paramMap = null;
		if (params != null) {
			paramMap = Stream.of(params).collect(Collectors.toMap(key -> key[0], data -> data[1]));
		}
		final CommandContributionItemParameter parameter = new CommandContributionItemParameter(
			PlatformUI.getWorkbench().getActiveWorkbenchWindow(), commandId, commandId, paramMap, imageDescr, null, null, label,
			null, null, CommandContributionItem.STYLE_PUSH, null, visibleEnabled);
		return new CommandContributionItem(parameter);
	}
}
