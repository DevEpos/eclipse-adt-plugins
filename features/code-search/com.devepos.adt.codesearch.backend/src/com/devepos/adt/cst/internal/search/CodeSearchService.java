package com.devepos.adt.cst.internal.search;

import java.net.URI;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;
import com.devepos.adt.base.nameditem.NamedItemServiceFactory;
import com.devepos.adt.base.plugin.features.AdtPluginFeaturesServiceFactory;
import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.internal.CodeSearchPlugin;
import com.devepos.adt.cst.internal.messages.Messages;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScope;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScopeParameters;
import com.devepos.adt.cst.model.codesearch.ICodeSearchSettings;
import com.devepos.adt.cst.search.ICodeSearchService;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IQueryParameter;
import com.sap.adt.communication.resources.IRestResource;
import com.sap.adt.communication.resources.QueryParameter;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.communication.session.ISystemSession;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * Standard implementation of the interface {@link ICodeSearchService}
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CodeSearchService implements ICodeSearchService {

  @Override
  public ICodeSearchScope createScope(final String destinationId,
      final ICodeSearchScopeParameters scopeParameters, final IProgressMonitor monitor) {

    CodeSearchUriDiscovery discovery = new CodeSearchUriDiscovery(destinationId);
    URI resourceUri = discovery.getCodeSearchScopeUri();
    if (resourceUri != null) {
      final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(resourceUri, session);
      restResource.addContentHandler(new CodeSearchScopeParametersContentHandler());
      restResource.addContentHandler(new CodeSearchScopeContentHandler());
      return restResource.post(monitor, ICodeSearchScope.class, scopeParameters);
    }
    return null;
  }

  @Override
  public IAdtUriTemplateProvider getNamedItemUriTemplateProvider(
      final IAbapProjectProvider projectProvider) {
    if (projectProvider == null) {
      throw new IllegalArgumentException("Parameter 'projectProvider' must be filled!");
    }
    return NamedItemServiceFactory.createNamedItemUriTemplateProvider(projectProvider,
        CodeSearchUriDiscovery::new);
  }

  @Override
  public IAdtPluginFeatures getSearchScopeFeatures(final String destinationId) {
    CodeSearchUriDiscovery uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    URI pluginFeaturesUri = uriDiscovery.getPluginFeaturesUri();
    if (pluginFeaturesUri == null) {
      return null;
    }
    URI settingsUri = uriDiscovery.getCodeSearchScopeUri();
    if (settingsUri == null) {
      return null;
    }

    IAdtPluginFeatureList featureList = AdtPluginFeaturesServiceFactory.createService()
        .getFeatures(destinationId, pluginFeaturesUri.toString());

    return featureList != null ? featureList.getFeaturesByEndpoint(settingsUri.toString()) : null;
  }

  @Override
  public IAdtPluginFeatures getSearchSettingsFeatures(final String destinationId) {
    CodeSearchUriDiscovery uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    URI pluginFeaturesUri = uriDiscovery.getPluginFeaturesUri();
    if (pluginFeaturesUri == null) {
      return null;
    }
    URI settingsUri = uriDiscovery.getCodeSearchSettingsUri();
    if (settingsUri == null) {
      return null;
    }

    IAdtPluginFeatureList featureList = AdtPluginFeaturesServiceFactory.createService()
        .getFeatures(destinationId, pluginFeaturesUri.toString());

    return featureList != null ? featureList.getFeaturesByEndpoint(settingsUri.toString()) : null;
  }

  @Override
  public ICodeSearchSettings getSettings(final String destinationId) {
    CodeSearchUriDiscovery uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    URI settingsUri = uriDiscovery.getCodeSearchSettingsUri();
    if (settingsUri == null) {
      return null;
    }
    final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(settingsUri, session);
    restResource.addContentHandler(new CodeSearchSettingsContentHandler());
    try {
      return restResource.get(new NullProgressMonitor(), ICodeSearchSettings.class);
    } catch (final ResourceException exc) {
      exc.printStackTrace();
    }
    return null;
  }

  @Override
  public boolean isCodeSearchParameterSupported(final IProject project,
      final String queryParameter) {
    final String destinationId = DestinationUtil.getDestinationId(project);
    CodeSearchUriDiscovery uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    if (!uriDiscovery.isResourceDiscoverySuccessful() || uriDiscovery.getCodeSearchUri() == null) {
      return false;
    }
    IAdtUriTemplate template = uriDiscovery.getCodeSearchTemplate();
    return template != null ? template.containsVariable(queryParameter) : null;
  }

  @Override
  public ICodeSearchResult search(final String destinationId,
      final Map<String, Object> uriParameters, final IProgressMonitor monitor) {

    CodeSearchUriDiscovery discovery = new CodeSearchUriDiscovery(destinationId);
    URI resourceUri = discovery.createCodeSearchUriFromTemplate(uriParameters);
    if (resourceUri != null) {
      final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(resourceUri, session);
      restResource.addContentHandler(new CodeSearchResultContentHandler());
      return restResource.get(monitor, ICodeSearchResult.class);
    }
    return null;
  }

  @Override
  public IStatus testCodeSearchFeatureAvailability(final IProject project) {
    final String destinationId = DestinationUtil.getDestinationId(project);
    CodeSearchUriDiscovery uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    if (uriDiscovery.isResourceDiscoverySuccessful() && uriDiscovery.getCodeSearchUri() != null) {
      return Status.OK_STATUS;
    }
    return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID, NLS.bind(
        Messages.CodeSearchSearchService_searchNotAvailableInProjectError_xmsg, project.getName()));
  }

  @Override
  public IStatus testCodeSearchNamedItemAvailability(final IProject project,
      final String namedItemTerm) {
    final String destinationId = DestinationUtil.getDestinationId(project);
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
  public IStatus updateSettings(final String destinationId, final ICodeSearchSettings settings) {
    if (settings == null) {
      throw new IllegalArgumentException("Parameter 'settings' must not be null");
    }

    CodeSearchUriDiscovery uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    URI settingsUri = uriDiscovery.getCodeSearchSettingsUri();
    if (settingsUri == null) {
      return null;
    }
    final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(settingsUri, session);
    restResource.addContentHandler(new CodeSearchSettingsContentHandler());
    try {
      restResource.put(new NullProgressMonitor(), ICodeSearchSettings.class, settings);
      return Status.OK_STATUS;
    } catch (final ResourceException exc) {
      exc.printStackTrace();
      return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID, exc.getMessage());
    }
  }

  @Override
  public IStatus validatePatterns(final String destinationId, final String patterns,
      final Map<String, String> uriParameters) {
    if (patterns == null || StringUtil.isBlank(patterns)) {
      throw new IllegalArgumentException("Parameter 'patterns' must not be empty or null");
    }
    CodeSearchUriDiscovery uriDiscovery = new CodeSearchUriDiscovery(destinationId);
    URI settingsUri = uriDiscovery.getPatternValidationUri();
    if (settingsUri == null) {
      return null;
    }
    final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(settingsUri, session);
    try {
      restResource.post(new NullProgressMonitor(), String.class, patterns,
          uriParameters.keySet()
              .stream()
              .map(k -> new QueryParameter(k, uriParameters.get(k)))
              .toArray(IQueryParameter[]::new));
      return Status.OK_STATUS;
    } catch (final ResourceException exc) {
      exc.printStackTrace();
      return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID, exc.getMessage());
    }
  }
}
