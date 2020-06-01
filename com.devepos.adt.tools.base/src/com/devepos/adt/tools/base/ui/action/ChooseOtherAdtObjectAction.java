package com.devepos.adt.tools.base.ui.action;

import java.util.function.Consumer;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.internal.messages.Messages;
import com.devepos.adt.tools.base.ui.search.IAdtRisSearchResultProxy;
import com.sap.adt.ris.search.ui.AdtRepositorySearchServiceUIFactory;
import com.sap.adt.ris.search.ui.IAdtRepositorySearchServiceUIParameters;
import com.sap.adt.ris.search.ui.IAdtRepositorySearchServiceUIResult;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Action for opening an ADT Ris Search Dialog
 *
 * @author stockbal
 */
@SuppressWarnings("restriction")
public class ChooseOtherAdtObjectAction extends Action {

	private final boolean multipleSelection;
	private final Consumer<IAdtRisSearchResultProxy> runConsumer;

	public ChooseOtherAdtObjectAction(final boolean multipleSelection, final Consumer<IAdtRisSearchResultProxy> runConsumer) {
		super(Messages.ChooseOtherAdtObjectAction_ActionText_xtol,
			AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.OTHER_OBJECT));
		this.multipleSelection = multipleSelection;
		this.runConsumer = runConsumer;
	}

	@Override
	public void run() {
		final IAdtRepositorySearchServiceUIParameters parameters = AdtRepositorySearchServiceUIFactory
			.createAdtRepositorySearchServiceUIParameters();
		parameters.setTitle(getText());
		parameters.setMultiSelectionEnabled(this.multipleSelection);
		final IAdtRepositorySearchServiceUIResult result = AdtRepositorySearchServiceUIFactory
			.createAdtRepositorySearchServiceUI()
			.openDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), parameters);

		if (result == null) {
			return;
		}

		this.runConsumer.accept(new AdtRisSearchResultProxy(result));
	}

	private class AdtRisSearchResultProxy implements IAdtRisSearchResultProxy {

		private final IAdtRepositorySearchServiceUIResult result;

		public AdtRisSearchResultProxy(final IAdtRepositorySearchServiceUIResult result) {
			this.result = result;
		}

		@Override
		public IProject getSelectedProject() {
			return this.result != null ? this.result.getSelectedProject() : null;
		}

		@Override
		public IAdtObjectReference getFirstResult() {
			return this.result != null ? this.result.getFirstSelectedObjectReference() : null;
		}

		@Override
		public IAdtObjectReference[] getAllSelectedResults() {
			return this.result != null ? this.result.getAllSelectedObjectReferences() : null;
		}
	}

}
