package com.devepos.adt.cst.internal.search;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.plugin.features.AdtPluginFeaturesServiceFactory;
import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.cst.internal.search.backend.CodeSearchUriDiscovery;
import com.devepos.adt.cst.internal.search.client.ClientCodeSearchUriDiscovery;
import com.devepos.adt.cst.search.ICodeSearchScopeService;

public class CodeSearchScopeService implements ICodeSearchScopeService {

  private final String destinationId;
  private final boolean isCloudProject;

  public CodeSearchScopeService(final IProject project) {
    isCloudProject = ProjectUtil.isCloudProject(project);
    destinationId = DestinationUtil.getDestinationId(project);
  }

  @Override
  public IAdtPluginFeatures getClientFeatures() {
    var adtDiscovery = new ClientCodeSearchUriDiscovery(destinationId);
    var pluginFeatureList = IAdtBaseFactory.eINSTANCE.createAdtPluginFeatureList();
    var dbEditorFeature = IAdtBaseFactory.eINSTANCE.createAdtPluginFeature();
    dbEditorFeature.setEnabled(adtDiscovery.isDatabaseEditorAvailable());
    dbEditorFeature.setEndpoint("/dummy");
    dbEditorFeature.setName("parameters.type.dbTable");
    pluginFeatureList.getFeatures().add(dbEditorFeature);

    var structureFeature = IAdtBaseFactory.eINSTANCE.createAdtPluginFeature();
    structureFeature.setEnabled(adtDiscovery.isStructureEditorAvailable());
    structureFeature.setEndpoint("/dummy");
    structureFeature.setName("parameters.type.structure");
    pluginFeatureList.getFeatures().add(structureFeature);

    return pluginFeatureList.getFeaturesByEndpoint("/dummy");
  }

  @Override
  public IAdtPluginFeatures getBackendFeatures() {
    var uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    var pluginFeaturesUri = uriDiscovery.getPluginFeaturesUri();
    if (pluginFeaturesUri == null) {
      return null;
    }
    var settingsUri = uriDiscovery.getCodeSearchScopeUri();
    if (settingsUri == null) {
      return null;
    }

    var featureList = AdtPluginFeaturesServiceFactory.createService()
        .getFeatures(destinationId, pluginFeaturesUri.toString());

    return featureList != null ? featureList.getFeaturesByEndpoint(settingsUri.toString()) : null;
  }

  @Override
  public IAdtPluginFeatures getFeaturesByProject() {
    return isCloudProject ? getClientFeatures() : getBackendFeatures();
  }

}
