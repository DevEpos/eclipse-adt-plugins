package com.devepos.adt.cst.internal.search;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.plugin.features.AdtPluginFeaturesServiceFactory;
import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.cst.internal.CodeSearchPlugin;
import com.devepos.adt.cst.internal.messages.Messages;
import com.devepos.adt.cst.internal.search.backend.CodeSearchUriDiscovery;
import com.devepos.adt.cst.search.ICodeSearchFeatureUtil;
import com.sap.adt.ris.search.virtualfolders.AdtRisVirtualFoldersServiceFactory;

public class CodeSearchFeatureUtil implements ICodeSearchFeatureUtil {

  private final IProject project;
  private final boolean isCloudProject;
  private final String destinationId;

  public CodeSearchFeatureUtil(final IProject project) {
    this.project = project;
    isCloudProject = ProjectUtil.isCloudProject(project);
    destinationId = DestinationUtil.getDestinationId(project);
  }

  @Override
  public IStatus testSearchAvailabilityByProject(final boolean preferClient) {
    if (isCloudProject) {
      return testClientBasedSearchAvailability();
    }
    if (preferClient) {
      var status = testClientBasedSearchAvailability();
      return status.isOK() ? status : testBackendBasedSearchAvailability();
    }
    var status = testBackendBasedSearchAvailability();
    return status.isOK() ? status : testClientBasedSearchAvailability();
  }

  @Override
  public IStatus testBackendBasedSearchAvailability() {
    var uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    if (uriDiscovery.isResourceDiscoverySuccessful() && uriDiscovery.getCodeSearchUri() != null) {
      return new Status(IStatus.OK, CodeSearchPlugin.PLUGIN_ID,
          ICodeSearchFeatureUtil.SEARCH_TARGET_BACKEND, "", null);
    }
    return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID, NLS.bind(
        Messages.CodeSearchSearchService_searchNotAvailableInProjectError_xmsg, project.getName()));
  }

  @SuppressWarnings("restriction")
  @Override
  public IStatus testClientBasedSearchAvailability() {
    // for now the test if the virtual folder API is available is enough
    if (AdtRisVirtualFoldersServiceFactory.isVirtualFolderSearchServiceAvailable(project)) {
      return new Status(IStatus.OK, CodeSearchPlugin.PLUGIN_ID,
          ICodeSearchFeatureUtil.SEARCH_TARGET_CLIENT, "", null);
    }
    return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID, NLS.bind(
        Messages.CodeSearchSearchService_searchNotAvailableInProjectError_xmsg, project.getName()));
  }

  @Override
  public IStatus testNamedItemAvailabilityByProject(final String namedItemTerm) {
    if (isCloudProject) {
      return testClientNamedItemAvailability(namedItemTerm);
    }
    return testBackendNamedItemAvailability(namedItemTerm);
  }

  @Override
  public IStatus testBackendNamedItemAvailability(final String namedItemTerm) {
    var uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    if (uriDiscovery.isResourceDiscoverySuccessful()
        && uriDiscovery.getNamedItemTemplate(namedItemTerm) != null) {
      return Status.OK_STATUS;
    }
    return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID,
        NLS.bind(Messages.CodeSearchSearchService_namedItemNotAvailableInProject_xmsg,
            project.getName(), namedItemTerm));
  }

  @Override
  public IStatus testClientNamedItemAvailability(final String namedItemTerm) {
    // TODO: check term against available service (i.e. transport search)
    return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID,
        NLS.bind(Messages.CodeSearchSearchService_namedItemNotAvailableInProject_xmsg,
            project.getName(), namedItemTerm));
  }

  @Override
  public boolean isCodeSearchParameterSupported(final String queryParameter) {
    if (isCloudProject) {
      return false;
    }
    var uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    if (!uriDiscovery.isResourceDiscoverySuccessful() || uriDiscovery.getCodeSearchUri() == null) {
      return false;
    }
    var template = uriDiscovery.getCodeSearchTemplate();
    return template != null ? template.containsVariable(queryParameter) : null;
  }

  @Override
  public IAdtPluginFeatures getSearchSettingsFeatures() {
    var uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    var pluginFeaturesUri = uriDiscovery.getPluginFeaturesUri();
    if (pluginFeaturesUri == null) {
      return null;
    }
    var settingsUri = uriDiscovery.getCodeSearchSettingsUri();
    if (settingsUri == null) {
      return null;
    }

    var featureList = AdtPluginFeaturesServiceFactory.createService()
        .getFeatures(destinationId, pluginFeaturesUri.toString());

    return featureList != null ? featureList.getFeaturesByEndpoint(settingsUri.toString()) : null;
  }

}
