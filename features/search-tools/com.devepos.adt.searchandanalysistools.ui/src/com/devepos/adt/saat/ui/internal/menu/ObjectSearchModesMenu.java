package com.devepos.adt.saat.ui.internal.menu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.saat.search.ObjectSearchServiceFactory;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.search.view.ObjectSearchPage;

/**
 * Menu contribution which creates quick start menu items for the ABAP object
 * search + pull down menu in the main toolbar
 *
 * @author stockbal
 */
public class ObjectSearchModesMenu extends CompoundContributionItem {

  public ObjectSearchModesMenu() {
  }

  public ObjectSearchModesMenu(final String id) {
    super(id);
  }

  private class OpenSearchDialogWithType extends Action {
    private final String typeName;

    public OpenSearchDialogWithType(final ImageDescriptor imgDescr, final String typeName,
        final String label) {
      super(label, imgDescr);
      this.typeName = typeName;
    }

    @Override
    public void run() {
      openSearchDialog(typeName);
    }
  }

  @Override
  protected IContributionItem[] getContributionItems() {
    final IContributionItem[] items = createMenuItems();
    return items;
  }

  private IContributionItem[] createMenuItems() {
    final List<IContributionItem> items = new ArrayList<>();

    var searchService = ObjectSearchServiceFactory.getSearchService();
    var currentProject = ProjectUtil.getCurrentAbapProject();
    if (currentProject != null && ProjectUtil.isLoggedOnToProject(currentProject)
        && searchService.testObjectSearchFeatureAvailability(currentProject).isOK()) {
      var config = searchService.getSearchConfig(DestinationUtil.getDestinationId(currentProject));
      for (var typeConfig : config.getSearchTypes()) {
        items.add(new ActionContributionItem(new OpenSearchDialogWithType(
            SearchAndAnalysisPlugin.getDefault().getSearchTypeImgDescr(typeConfig),
            typeConfig.getName(), typeConfig.getLabel())));
      }
    } else {
      final IAction noProjectAction = new Action(
          Messages.ObjectSearchModesMenu_noAbapProjectSelected_xmsg) {
      };
      noProjectAction.setEnabled(false);
      items.add(new ActionContributionItem(noProjectAction));
    }

    return items.toArray(new IContributionItem[items.size()]);
  }

  @SuppressWarnings("restriction")
  private void openSearchDialog(final String typeName) {
    final var activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    final var dialog = new org.eclipse.search.internal.ui.SearchDialog(activeWindow,
        ObjectSearchPage.PAGE_ID);
    dialog.setBlockOnOpen(false);
    dialog.open();
    if (dialog.getSelectedPage() instanceof ObjectSearchPage) {
      final var searchDialog = (ObjectSearchPage) dialog.getSelectedPage();
      searchDialog.setSearchType(typeName);
      searchDialog.setFocusToFirstInput();
    }
    dialog.setBlockOnOpen(true);
  }
}
