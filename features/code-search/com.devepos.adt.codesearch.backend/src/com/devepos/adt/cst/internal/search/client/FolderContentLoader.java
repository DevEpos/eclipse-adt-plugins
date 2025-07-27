package com.devepos.adt.cst.internal.search.client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.SearchObjectFolder;
import com.devepos.adt.cst.search.client.SearchableObject;

@SuppressWarnings("restriction")
public class FolderContentLoader {
  private final ScopeService scopeService;

  public FolderContentLoader(final String destination, final IProgressMonitor monitor,
      final IClientCodeSearchConfig config) {
    scopeService = new ScopeService(destination, monitor, config);
  }

  public List<SearchableObject> run(final SearchObjectFolder folder) {
    return run(folder, folder.getObjectPattern());
  }

  public List<SearchableObject> run(final SearchObjectFolder folder, final String objectPattern) {
    var objectSearchParams = scopeService.buildFolderRequestParams(
        folder.getFacets().stream().map(Facet::getType).collect(Collectors.toList()));
    if (objectPattern != null) {
      objectSearchParams.setObjectSearchPattern(objectPattern);
    }
    folder.getFacets()
        .forEach(facet -> objectSearchParams.addPreselection(facet.getType(), facet.getName()));

    var objectResponse = scopeService.fetchFolderContent(objectSearchParams);
    if (objectResponse != null) {
      List<SearchableObject> searchableObjects = new ArrayList<>();
      for (var o : objectResponse.getObject()) {
        searchableObjects.add(new SearchableObject(o.getName(), o.getText(), o.getType(),
            AtomLinkUtil.getObjectUri(o), folder));
      }
      return searchableObjects;
    }
    return null;
  }
}
