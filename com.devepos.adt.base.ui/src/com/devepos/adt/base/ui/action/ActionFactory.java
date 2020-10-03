package com.devepos.adt.base.ui.action;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Factory for creating anonymous action instances
 * 
 * @author stockbal
 */
public class ActionFactory {

	/**
	 * Represents a single run-action with no input parameters and no return values.
	 */
	@FunctionalInterface
	public interface IActionRunner {

		/**
		 * Performs the run operation on an {@link Action}
		 */
		void execute();
	}

	@FunctionalInterface
	public interface IActionRunnerWithData<T> {
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
		final IActionRunner actionRunner) {
		return createAction(text, imageDescriptor, Action.AS_PUSH_BUTTON, actionRunner);
	}

	/**
	 * Create anonymous {@link Action} class with the given {@link Consumer
	 * runConsumer} as the implementation for the {@link Action#run()} method
	 *
	 * @param  text            the text/tooltip for the action
	 * @param  imageDescriptor the optional image descriptor for the action
	 * @param  actionRunner    the implementation for the {@link Action#run()}
	 *                         method
	 * @param  style           one of <code>Action.AS_PUSH_BUTTON</code>,
	 *                         <code>Action.AS_CHECK_BOX</code>,
	 *                         <code>Action.AS_DROP_DOWN_MENU</code>,
	 *                         <code>Action.AS_RADIO_BUTTON</code>.
	 * @return                 the created Action instance
	 */
	public static Action createAction(final String text, final ImageDescriptor imageDescriptor, final int style,
		final IActionRunner actionRunner) {
		Objects.requireNonNull(actionRunner, "Parameter 'actionRunner' must not be null");

		final Action action = new Action(text, style) {
			@Override
			public void run() {
				actionRunner.execute();
			}
		};
		action.setImageDescriptor(imageDescriptor);
		return action;
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
		final IActionRunnerWithData<T> actionRunner, final T actionData) {
		Objects.requireNonNull(actionRunner, "Parameter 'actionRunner' must not be null");

		return new Action(text, imageDescriptor) {
			@Override
			public void run() {
				actionRunner.execute(actionData);
			}
		};
	}
}
