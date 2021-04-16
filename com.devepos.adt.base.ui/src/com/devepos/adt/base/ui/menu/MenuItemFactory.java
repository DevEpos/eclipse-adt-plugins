package com.devepos.adt.base.ui.menu;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.menus.CommandContributionItem;

import com.devepos.adt.base.ui.action.CommandFactory;

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
        final IContributionItem commandItem = CommandFactory.createContribItem(commandId, imageDescr, label, true,
            params);
        if (groupId != null) {
            mgr.appendToGroup(groupId, commandItem);
        } else {
            mgr.add(commandItem);
        }
    }

}
