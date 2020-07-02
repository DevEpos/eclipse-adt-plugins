package com.devepos.adt.tools.base.ui.action;

import java.util.function.Consumer;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public class ActionUtil {

	/**
	 * Represents a single run-action with no input parameters and no return values.
	 */
	@FunctionalInterface
	public interface IActionRun {

		/**
		 * Performs the run operation on an {@link Action}
		 */
		void execute();
	}

	/**
	 * Create anonymous {@link Action} class with the given {@link Consumer
	 * runConsumer} as the implementation for the {@link Action#run()} method
	 *
	 * @param  text            the text/tooltip for the action
	 * @param  imageDescriptor the optional image descriptor for the action
	 * @param  actionRunner    the implementation for the {@link Action#run()}
	 *                         method
	 * @return                 the created Action instance
	 */
	public static Action createAction(final String text, final ImageDescriptor imageDescriptor,
		final IActionRun actionRunner) {
		Assert.isNotNull(actionRunner, "Parameter 'actionRunner' must not be null");

		return new Action(text, imageDescriptor) {
			@Override
			public void run() {
				actionRunner.execute();
			}
		};
	}
}
