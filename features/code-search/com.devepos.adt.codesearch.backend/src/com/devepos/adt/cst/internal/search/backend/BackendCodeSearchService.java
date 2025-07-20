package com.devepos.adt.cst.internal.search.backend;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScope;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScopeParameters;
import com.devepos.adt.cst.search.IBackendBasedCodeSearchService;
import com.devepos.adt.cst.search.ICodeSearchService;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.communication.session.ISystemSession;

/**
 * Standard implementation of the interface {@link ICodeSearchService}
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class BackendCodeSearchService implements IBackendBasedCodeSearchService {
  private final String destinationId;

  public BackendCodeSearchService(final IProject project) {
    destinationId = DestinationUtil.getDestinationId(project);
  }

  @Override
  public ICodeSearchScope createScope(final ICodeSearchScopeParameters scopeParameters,
      final IProgressMonitor monitor) {

    var discovery = new CodeSearchUriDiscovery(destinationId);
    var resourceUri = discovery.getCodeSearchScopeUri();
    if (resourceUri != null) {
      final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final var restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(resourceUri, session);
      restResource.addContentHandler(new CodeSearchScopeParametersContentHandler());
      restResource.addContentHandler(new CodeSearchScopeContentHandler());
      return restResource.post(monitor, ICodeSearchScope.class, scopeParameters);
    }
    return null;
  }

  @Override
  public ICodeSearchResult search(final Map<String, Object> uriParameters,
      final IProgressMonitor monitor) {

    var discovery = new CodeSearchUriDiscovery(destinationId);
    var resourceUri = discovery.createCodeSearchUriFromTemplate(uriParameters);
    if (resourceUri != null) {
      final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final var restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(resourceUri, session);
      restResource.addContentHandler(new CodeSearchResultContentHandler());
      return restResource.get(monitor, ICodeSearchResult.class);
    }
    return null;
  }

}
