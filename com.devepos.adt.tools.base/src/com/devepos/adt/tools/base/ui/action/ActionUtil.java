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

	@FunctionalInterface
	public interface IActionRunWithData<T> {
		void execute(T data);
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

	/**
	 * Create anonymous {@link Action} class with the given {@link Consumer
	 * runConsumer} as the implementation for the {@link Action#run()} method.
	 * 
	 * @param  text            the text/tooltip for the action
	 * @param  imageDescriptor the optional image descriptor for the action
	 * @param  actionRunner    the implementation for the {@link Action#run()}
	 *                         method
	 * @param  actionData      the actual data that will be handled during the
	 *                         execution of the passed {@code actionRunner}
	 * @return                 the created Action instance
	 */
	public static <T> Action createActionWithData(final String text, final ImageDescriptor imageDescriptor,
		final IActionRunWithData<T> actionRunner, final T actionData) {
		Assert.isNotNull(actionRunner, "Parameter 'actionRunner' must not be null");

		return new Action(text, imageDescriptor) {
			@Override
			public void run() {
				actionRunner.execute(actionData);
			}
		};
	}
}
