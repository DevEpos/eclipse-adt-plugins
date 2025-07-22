package com.devepos.adt.cst.internal.search.client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.SearchObjectFolder;
import com.devepos.adt.cst.search.client.SearchableObject;
import com.sap.adt.tools.core.atom.AdtAtomUtilFactory;

@SuppressWarnings("restriction")
public class FolderContentLoader {
  private ScopeService scopeService;

  public FolderContentLoader(String destination, IProgressMonitor monitor,
      IClientCodeSearchConfig config) {
    scopeService = new ScopeService(destination, monitor, config);
  }

  public List<SearchableObject> run(SearchObjectFolder folder) {
    var folderSearchParams = scopeService.buildFolderRequestParams(
        folder.getFacets().stream().map(Facet::getType).collect(Collectors.toList()));
    folder.getFacets()
        .forEach(facet -> folderSearchParams.addPreselection(facet.getType(), facet.getName()));

    var objectResponse = scopeService.fetchFolderContent(folderSearchParams);
    if (objectResponse != null) {
      List<SearchableObject> searchableObjects = new ArrayList<>();
      var atomUtil = AdtAtomUtilFactory.createAtomUtil();
      for (var o : objectResponse.getObject()) {
        var uri = atomUtil.findAtomLinkAsUri(o.getLinks(),
            "http://www.sap.com/adt/relations/objects");
        searchableObjects.add(
            new SearchableObject(o.getName(), o.getText(), o.getType(), uri.toString(), folder));
      }
      return searchableObjects;
    }
    return null;
  }
}
