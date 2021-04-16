package com.devepos.adt.base.ui.action;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.IAdtBaseUICommandConstants;
import com.devepos.adt.base.ui.internal.messages.Messages;

/**
 * Factory for creating Commands and {@link CommandContributionItem}s
 *
 * @author stockbal
 *
 */
public class CommandFactory {

    /**
     * Creates command contribution item. <br>
     * The visibility of the contribution item is dependent on the {@code enabled}
     * property.
     *
     * @param commandId  a unique identifier of a command
     * @param imageDescr an image descriptor for the command item
     * @param label      the label to be displayed for the command
     * @param params     an optional two dimensional array of command parameters
     * @return the created command contribution item
     */
    public static IContributionItem createContribItem(final String commandId, final ImageDescriptor imageDescr,
        final String label, final String[][] params) {
        return createContribItem(commandId, imageDescr, label, true, params);
    }

    /**
     * Creates command contribution item
     *
     * @param commandId      a unique identifier of a command
     * @param imageDescr     an image descriptor for the command item
     * @param label          the label to be displayed for the command
     * @param visibleEnabled if <code>true</code> the visibility of the contribution
     *                       item will depend on the <code>enabled</code> state of
     *                       the command
     * @param params         an optional two dimensional array of command parameters
     * @return the created command contribution item
     */
    public static IContributionItem createContribItem(final String commandId, final ImageDescriptor imageDescr,
        final String label, final boolean visibleEnabled, final String[][] params) {
        Map<String, String> paramMap = null;
        if (params != null) {
            paramMap = Stream.of(params).collect(Collectors.toMap(key -> key[0], data -> data[1]));
        }
        final CommandContributionItemParameter parameter = new CommandContributionItemParameter(PlatformUI
            .getWorkbench()
            .getActiveWorkbenchWindow(), commandId, commandId, paramMap, imageDescr, null, null, label, null, null,
            CommandContributionItem.STYLE_PUSH, null, visibleEnabled);
        return new CommandContributionItem(parameter);
    }

    /**
     * Creates and returns a {@link IContributionItem} for the existing
     * {@code commandId}
     *
     * @param commandId      a unique identifier for a command in this plugin
     * @param visibleEnabled if <code>true</code> the visibility of the contribution
     *                       item will depend on the <code>enabled</code> state of
     *                       the command
     * @param params         an optional two dimensional array of command parameters
     * @return the created command contribution item
     *
     * @see {@link IAdtBaseUICommandConstants}
     */
    public static IContributionItem createContribItemById(final String commandId, final boolean visibleEnabled,
        final String[][] params) {

        ImageDescriptor imageDescr = null;
        String label = null;
        switch (commandId) {
        case IAdtBaseUICommandConstants.OPEN_QUERY_IN_SEARCH_DIALOG:
            label = Messages.Actions_OpenQueryInSearchDialog_xmit;
            imageDescr = AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.SEARCH);
            break;
        case IAdtBaseUICommandConstants.WHERE_USED_IN:
            label = AdtBaseUIResources.getString(IAdtBaseStrings.General_WhereUsedList_xmit);
            imageDescr = AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.WHERE_USED_LIST);
            break;
        case IAdtBaseUICommandConstants.TOGGLE_VIEWER_TEXT_FILTER:
            label = Messages.Actions_ToggleViewerTextFilter_xmit;
            imageDescr = AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.FILTER);
            break;
        default:
            return null;
        }

        Map<String, String> paramMap = null;
        if (params != null) {
            paramMap = Stream.of(params).collect(Collectors.toMap(key -> key[0], data -> data[1]));
        }
        final CommandContributionItemParameter parameter = new CommandContributionItemParameter(PlatformUI
            .getWorkbench()
            .getActiveWorkbenchWindow(), commandId, commandId, paramMap, imageDescr, null, null, label, null, null,
            CommandContributionItem.STYLE_PUSH, null, visibleEnabled);
        return new CommandContributionItem(parameter);
    }
}
