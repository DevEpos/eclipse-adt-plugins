package com.devepos.adt.saat.internal.search;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.nameditem.NamedItemServiceFactory;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.saat.internal.Activator;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchResult;
import com.devepos.adt.saat.model.objectsearch.ISearchConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryInput;
import com.devepos.adt.saat.search.IObjectSearchService;
import com.devepos.adt.saat.search.ObjectSearchSystemConfig;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

/**
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class ObjectSearchService implements IObjectSearchService {

  private final Map<String, ISearchConfig> searchConfigMap = new HashMap<>();

  public ObjectSearchService() {
  }

  @Override
  public IAdtUriTemplateProvider getNamedItemUriTemplateProvider(
      final IAbapProjectProvider projectProvider) {
    if (projectProvider == null) {
      throw new IllegalArgumentException("Parameter 'projectProvider' must be filled!");
    }
    return NamedItemServiceFactory.createNamedItemUriTemplateProvider(projectProvider,
        ObjectSearchUriDiscovery::new);
  }

  @Override
  public ISearchConfig getSearchConfig(final String destinationId) {
    if (!ObjectSearchSystemConfig.IS_OBJ_SEARCH_CONFIG_CACHING_DISABLED
        && searchConfigMap.containsKey(destinationId)) {
      return searchConfigMap.get(destinationId);
    }
    var discovery = new ObjectSearchUriDiscovery(destinationId);
    var resourceUri = discovery.getObjectSearchConfigUri();
    if (resourceUri != null) {
      final var session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final var restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(resourceUri, session);
      restResource.addContentHandler(new ObjectSearchConfigContentHandler());
      var searchConfig = restResource.get(null, ISearchConfig.class);
      if (!ObjectSearchSystemConfig.IS_OBJ_SEARCH_CONFIG_CACHING_DISABLED) {
        searchConfigMap.put(destinationId, searchConfig);
      }
      return searchConfig;
    }
    return null;
  }

  @Override
  public IObjectSearchResult search(final String destinationId, final ISearchQueryInput searchInput,
      final IProgressMonitor monitor) {
    var discovery = new ObjectSearchUriDiscovery(destinationId);
    var resourceUri = discovery.getObjectSearchUri();
    if (resourceUri != null) {
      final var session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final var restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(resourceUri, session);
      restResource.addContentHandler(new ObjectSearchResultContentHandler());
      restResource.addContentHandler(new ObjectSearchInputContentHandler());
      return restResource.post(monitor, IObjectSearchResult.class, searchInput);
    }
    return null;
  }

  @Override
  public IStatus testObjectSearchFeatureAvailability(final IProject project) {
    final var destinationId = DestinationUtil.getDestinationId(project);
    var uriDiscovery = new ObjectSearchUriDiscovery(destinationId);
    if (uriDiscovery.isResourceDiscoverySuccessful() && uriDiscovery.getObjectSearchUri() != null) {
      return Status.OK_STATUS;
    }
    return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
        NLS.bind("ABAP Object Search (v2) is not available in project ''{0}''", project.getName()));
  }
}
