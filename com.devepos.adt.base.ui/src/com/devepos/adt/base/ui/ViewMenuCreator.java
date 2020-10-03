package com.devepos.adt.base.ui;

import static org.eclipse.swt.events.MouseListener.mouseDownAdapter;
import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.services.IDisposable;

/**
 * Class which creates the equivalent of the view menu in eclipse views
 * 
 * @author stockbal
 */
public class ViewMenuCreator {

	/**
	 * Creates toolbar with a single button that shows a menu upon a click. The menu
	 * can be filled via the {@code menuFiller} parameter
	 * 
	 * @param  parent     the parent composite for the toolbar button that triggers
	 *                    the view menu
	 * @param  menuFiller consumer to fill the menu
	 * @return            instance of {@link IDisposable} so the menu resources can
	 *                    be disposed
	 */
	public static IDisposable createViewMenu(final Composite parent, final Consumer<IMenuManager> menuFiller) {
		final ViewMenu viewMenu = new ViewMenu();
		viewMenu.createViewMenu(parent, menuFiller);
		return viewMenu;
	}

	private static class ViewMenu implements IDisposable {

		private MenuManager menuManager;
		private IHandlerActivation showViewHandler;
		private ToolBar toolBar;
		private ToolItem toolItem;

		@Override
		public void dispose() {
			if (this.showViewHandler != null) {
				final IHandlerService service = PlatformUI.getWorkbench().getService(IHandlerService.class);
				service.deactivateHandler(this.showViewHandler);
				this.showViewHandler.getHandler().dispose();
				this.showViewHandler = null;
			}
			if (this.menuManager != null) {
				this.menuManager.dispose();
			}
		}

		public void createViewMenu(final Composite parent, final Consumer<IMenuManager> menuFiller) {
			Objects.requireNonNull(menuFiller, "menuFiller must not be null"); //$NON-NLS-1$
			this.toolBar = new ToolBar(parent, SWT.FLAT);
			this.toolItem = new ToolItem(this.toolBar, SWT.PUSH, 0);

			GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).applyTo(this.toolBar);

			this.toolBar.addMouseListener(mouseDownAdapter(e -> {
				showViewMenu();
			}));

			this.toolItem.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.VIEW_MENU));
			this.toolItem.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.Menu));
			this.toolItem.addSelectionListener(widgetSelectedAdapter(e -> showViewMenu()));

			this.menuManager = new MenuManager();

			menuFiller.accept(this.menuManager);

			final IHandlerService service = PlatformUI.getWorkbench().getService(IHandlerService.class);
			final IHandler handler = new AbstractHandler() {
				@Override
				public Object execute(final ExecutionEvent event) {
					showViewMenu();
					return null;
				}
			};
			this.showViewHandler = service.activateHandler(IWorkbenchCommandConstants.WINDOW_SHOW_VIEW_MENU, handler,
				new ActiveShellExpression(parent.getShell()));
		}

		private void showViewMenu() {
			final Menu menu = this.menuManager.createContextMenu(this.toolBar.getShell());
			final Rectangle bounds = this.toolItem.getBounds();
			Point topLeft = new Point(bounds.x, bounds.y + bounds.height);
			topLeft = this.toolBar.toDisplay(topLeft);
			menu.setLocation(topLeft.x, topLeft.y);
			menu.setVisible(true);
		}
	}

}
