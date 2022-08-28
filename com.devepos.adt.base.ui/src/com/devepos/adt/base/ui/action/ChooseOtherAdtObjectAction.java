package com.devepos.adt.base.ui.action;

import java.util.function.Consumer;

import org.eclipse.jface.action.Action;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.search.AdtRisSearchUtil;
import com.devepos.adt.base.ui.search.IAdtRisSearchResultProxy;

/**
 * Action for opening an ADT Ris Search Dialog
 *
 * @author stockbal
 */
public class ChooseOtherAdtObjectAction extends Action {

  private final boolean multipleSelection;
  private final Consumer<IAdtRisSearchResultProxy> runConsumer;

  public ChooseOtherAdtObjectAction(final boolean multipleSelection,
      final Consumer<IAdtRisSearchResultProxy> runConsumer) {
    super(Messages.ChooseOtherAdtObjectAction_ActionText_xtol, AdtBaseUIResources
        .getImageDescriptor(IAdtBaseImages.OTHER_OBJECT));
    this.multipleSelection = multipleSelection;
    this.runConsumer = runConsumer;
  }

  @Override
  public void run() {
    final IAdtRisSearchResultProxy resultProxy = AdtRisSearchUtil.searchAdtObjectViaDialog(
        getText(), this.getClass().getCanonicalName() + ".dialog", multipleSelection, null);
    if (resultProxy != null) {
      runConsumer.accept(resultProxy);
    }
  }

}
