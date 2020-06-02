package com.devepos.adt.tools.base.ui.action;

import java.util.function.Consumer;

import org.eclipse.jface.action.Action;

import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.internal.messages.Messages;
import com.devepos.adt.tools.base.ui.search.AdtRisSearchUtil;
import com.devepos.adt.tools.base.ui.search.IAdtRisSearchResultProxy;

/**
 * Action for opening an ADT Ris Search Dialog
 *
 * @author stockbal
 */
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
		final IAdtRisSearchResultProxy resultProxy = AdtRisSearchUtil.searchAdtObjectViaDialog(getText(), this.multipleSelection,
			null);
		if (resultProxy != null) {
			this.runConsumer.accept(resultProxy);
		}
	}

}
