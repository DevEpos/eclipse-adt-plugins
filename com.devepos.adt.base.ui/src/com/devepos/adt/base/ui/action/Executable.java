package com.devepos.adt.base.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;

public abstract class Executable implements IExecutable {

    @Override
    public IAction createAction(final String name, final ImageDescriptor imageDescriptor) {
        final Action action = new Action(name, imageDescriptor) {
            @Override
            public void run() {
                execute();
            }
        };
        return action;
    }

}
