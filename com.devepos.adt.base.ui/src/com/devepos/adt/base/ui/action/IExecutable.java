package com.devepos.adt.base.ui.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * An action represents an action that can be executed on an element
 * information.
 *
 * @author stockbal
 */
public interface IExecutable {

    /**
     * Executes the logic of the action
     */
    void execute();

    /**
     * Creates UI action from executable
     *
     * @param name            the name for the action (tooltip or text)
     * @param imageDescriptor the image descriptor for the action
     * @return
     */
    IAction createAction(String name, ImageDescriptor imageDescriptor);
}
