package com.devepos.adt.cst.internal.search.client;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.SearchObjectFolder;
import com.sap.adt.ris.model.virtualfolders.IObject;

@SuppressWarnings("restriction")
public class PackageContentLoader {
  private ScopeService scopeService;

  public PackageContentLoader(String destination, IProgressMonitor monitor,
      IClientCodeSearchConfig config) {
    scopeService = new ScopeService(destination, monitor, config);
  }

  public List<IObject> loadObjects(SearchObjectFolder folder) {
    var folderSearchParams = scopeService.buildFolderRequestParams(
        folder.getFacets().stream().map(Facet::getType).collect(Collectors.toList()));
    folder.getFacets()
        .forEach(facet -> folderSearchParams.addPreselection(facet.getType(), facet.getName()));

    var objectResponse = scopeService.fetchFolderContent(folderSearchParams);
    return objectResponse != null ? objectResponse.getObject() : null;
  }
}
