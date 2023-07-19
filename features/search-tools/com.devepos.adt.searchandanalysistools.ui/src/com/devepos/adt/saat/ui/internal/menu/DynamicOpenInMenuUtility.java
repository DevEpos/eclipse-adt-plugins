package com.devepos.adt.saat.ui.internal.menu;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ObjectType;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets;
import com.devepos.adt.saat.navtargets.NavigationTargetServiceFactory;
import com.devepos.adt.saat.ui.internal.ICommandConstants;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.analytics.OpenWithAnalysisForOfficeExecutable;
import com.devepos.adt.saat.ui.internal.analytics.OpenWithQueryMonitorExecutable;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.FeatureTester;
import com.devepos.adt.saat.ui.internal.util.IImages;

/**
 * Utility class to create a Menu for some DB Browser actions for a given object
 * (CDS View, Database table or Database view)
 *
 * @author stockbal
 */
public class DynamicOpenInMenuUtility {

  /**
   * Creates analysis tools menu for the list of ADT Objects
   *
   * @param adtObjects a list of ADT objects
   * @return the created menu or <code>null</code>
   */
  public static IMenuManager buildAnalysisToolsSubMenu(final List<IAdtObject> adtObjects) {
    if (adtObjects == null || adtObjects.isEmpty()) {
      return null;
    }
    final IProject project = adtObjects.get(0).getProject();
    if (project == null || !FeatureTester.isCdsAnalysisAvailable(project)) {
      return null;
    }
    return new DynamicOpenInMenuManager(adtObjects, project);
  }

  private static class DynamicOpenInMenuManager extends MenuManager implements IMenuListener {
    private static final String ID = SearchAndAnalysisPlugin.PLUGIN_ID + ".actionsMenu"; //$NON-NLS-1$
    private final List<IAdtObject> adtObjects;
    private final IProject project;
    private final boolean cdsAnalysisAvailable;

    public DynamicOpenInMenuManager(final List<IAdtObject> adtObjects, final IProject project) {
      super(Messages.AdtObjectMenu_MainMenuEntry, SearchAndAnalysisPlugin.getDefault()
          .getImageDescriptor(IImages.CDS_ANALYZER), ID);
      this.adtObjects = adtObjects;
      this.project = project;
      cdsAnalysisAvailable = this.adtObjects.size() == 1 && FeatureTester.isCdsAnalysisAvailable(
          project);
      setRemoveAllWhenShown(true);
      addMenuListener(this);
    }

    @Override
    public void menuAboutToShow(final IMenuManager manager) {
      final boolean isDbBrowserAvailable = FeatureTester.isSapGuiDbBrowserAvailable(adtObjects);
      // Add command "Open In DB Browser"
      if (isDbBrowserAvailable) {
        SaatMenuItemFactory.addOpenInDbBrowserCommand(this, false);
        SaatMenuItemFactory.addOpenInDbBrowserCommand(this, true);
      }

      if (cdsAnalysisAvailable) {
        if (isDbBrowserAvailable) {
          add(new Separator());
        }
        final boolean isCdsView = adtObjects.get(0).getObjectType() == ObjectType.DATA_DEFINITION;
        if (isCdsView && FeatureTester.isCdsTopDownAnalysisAvailable(project)) {
          SaatMenuItemFactory.addCdsAnalyzerCommandItem(this, null,
              ICommandConstants.CDS_TOP_DOWN_ANALYSIS);
        }
        if (FeatureTester.isWhereUsedInCdsAnalysisAvailable(project)) {
          SaatMenuItemFactory.addCdsAnalyzerCommandItem(this, null,
              ICommandConstants.WHERE_USED_IN_CDS_ANALYSIS);
        }
        if (isCdsView && FeatureTester.isCdsUsedEntitiesAnalysisAvailable(project)) {
          SaatMenuItemFactory.addCdsAnalyzerCommandItem(this, null,
              ICommandConstants.USED_ENTITIES_ANALYSIS);
        }
        if (FeatureTester.isFieldAnalysisAvailable(project)) {
          SaatMenuItemFactory.addCdsAnalyzerCommandItem(this, null,
              ICommandConstants.FIELD_ANALYSIS);
        }
        // Additional actions only exist for CDS view at the moment
        if (isCdsView && FeatureTester.isNavigationTargetsFeatureAvailable(project)) {
          add(new Separator());
          add(new ExternalNavigationTargetsMenu(adtObjects.get(0), project));
        }
      }

    }

  }

  private static class ExternalNavigationTargetsMenu extends MenuManager implements IMenuListener {
    private static final String ID = SearchAndAnalysisPlugin.PLUGIN_ID + ".externalNavTargetsMenu"; //$NON-NLS-1$
    private final IAdtObject adtObject;
    private final IProject project;

    public ExternalNavigationTargetsMenu(final IAdtObject adtObject, final IProject project) {
      super(Messages.AdtObjectMenu_ExtnernalNavigationTargets_xmit, SearchAndAnalysisPlugin
          .getDefault()
          .getImageDescriptor(IImages.EXTERNAL_TOOLS), ID);
      this.adtObject = adtObject;
      this.project = project;
      setRemoveAllWhenShown(true);
      addMenuListener(this);
    }

    @Override
    public void menuAboutToShow(final IMenuManager manager) {
      createLazyMenuItem();
    }

    private void createLazyMenuItem() {
      final IContributionItem loadingIndicator = addTextContribution(
          Messages.AdtObjectMenu_LoadingText_xmit);
      final String objectName = adtObject.getName();
      final ObjectType objectType = adtObject.getObjectType();

      final Job job = new Job(NLS.bind(Messages.AdtObjectMenu_DynamicMenuItemsLoadingJob_xmsg,
          objectName)) {
        @Override
        protected IStatus run(final IProgressMonitor monitor) {

          final var service = NavigationTargetServiceFactory.getService();
          final var targets = service.getTargets(DestinationUtil.getDestinationId(project),
              objectName, objectType);
          monitor.done();

          // update menu after targets are loaded
          PlatformUI.getWorkbench().getDisplay().asyncExec((Runnable) () -> {
            ExternalNavigationTargetsMenu.this.remove(loadingIndicator);
            if (targets != null) {
              addNavigationTargetActions(targets);
            } else {
              addTextContribution(Messages.AdtObjectMenu_NoTargetsFound_xmit);
            }
            ExternalNavigationTargetsMenu.this.update(true);
          });
          return Status.OK_STATUS;
        }
      };
      job.schedule(100);

    }

    private void addNavigationTargetActions(final ICdsQueryNavTargets targets) {
      for (final var target : targets.getNavigationTargets()) {
        switch (target) {
        case EXCEL:
          add(new OpenWithAnalysisForOfficeExecutable(DestinationUtil.getDestinationId(project),
              adtObject.getName()).createAction(
                  Messages.ElementInformation_AnalysisForOfficeTarget_xtit, SearchAndAnalysisPlugin
                      .getDefault()
                      .getImageDescriptor(IImages.EXCEL_APPLICATION)));
          break;
        case QUERY_MONITOR:
          add(new OpenWithQueryMonitorExecutable(DestinationUtil.getDestinationId(project),
              adtObject.getName()).createAction(Messages.ElementInformation_QueryMonitorTarget_xtit,
                  SearchAndAnalysisPlugin.getDefault()
                      .getImageDescriptor(IImages.ANALYTICAL_QUERY)));
          break;
        }
      }
    }

    private IContributionItem addTextContribution(final String text) {
      final IContributionItem item = new ActionContributionItem(new Action(text) {
        @Override
        public boolean isEnabled() {
          return false;
        }
      });
      add(item);
      return item;
    }
  }
}
