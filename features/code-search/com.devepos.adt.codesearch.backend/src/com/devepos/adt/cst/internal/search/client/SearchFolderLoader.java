package com.devepos.adt.cst.internal.search.client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.SearchObjectFolder;

@SuppressWarnings("restriction")
class SearchFolderLoader {
  private final ScopeService scopeService;
  private List<Facet> facets;
  private final String objectPattern;

  public SearchFolderLoader(final String destinationId, final IProgressMonitor monitor,
      final IClientCodeSearchConfig specs, final String objectPattern) {
    this.objectPattern = objectPattern;
    scopeService = new ScopeService(destinationId, monitor, specs);
  }

  public void setFacets(final Facet... facets) {
    this.facets = List.of(facets);
  }

  public List<SearchObjectFolder> run() {
    var packageExpandRequestParams = scopeService.buildFolderRequestParams(getExcludedFacets());
    packageExpandRequestParams.setObjectSearchPattern(objectPattern);
    packageExpandRequestParams.setWantedFacets(List.of(IFacetConstants.PACKAGE));
    if (facets != null) {
      facets.forEach(f -> packageExpandRequestParams.addPreselection(f.getType(), f.getName()));
    }
    var packageResponse = scopeService.fetchFolderContent(packageExpandRequestParams);
    List<SearchObjectFolder> folders = new ArrayList<>();
    if (packageResponse == null) {
      return folders;
    }
    var objectCountInExpandedPackages = 0;
    SearchObjectFolder relativePackage = null;
    for (var f : packageResponse.getVirtualFolder()) {
      var uri = AtomLinkUtil.getPackageUri(f);
      // REVISIT: why is this contained in the result???
      if (f.getName().startsWith("..")) {
        relativePackage = new SearchObjectFolder(f.getName().substring(2), null, f.getCounter());
        continue;
      }
      objectCountInExpandedPackages += f.getCounter();
      var packageFolder = new SearchObjectFolder(f.getName(), f.getDisplayName(), f.getCounter());
      packageFolder.setObjectPattern(objectPattern);
      packageFolder.getFacets().add(new Facet(IFacetConstants.PACKAGE, f.getName()));
      packageFolder.setHasChildrenOfSameFacet(f.isHasChildrenOfSameFacet());
      packageFolder.setUri(uri);
      packageFolder.setFacet(IFacetConstants.PACKAGE);
      packageFolder.setPackageName(f.getName());
      folders.add(packageFolder);
    }
    if (objectCountInExpandedPackages < packageResponse.getObjectCount()
        && relativePackage != null) {
      folders.addAll(getTypeFolders(relativePackage));
    }
    return folders;
  }

  private List<SearchObjectFolder> getTypeFolders(final SearchObjectFolder relativePackage) {
    var packageDirectContentReqParams = scopeService
        .buildFolderRequestParams(List.of(IFacetConstants.PACKAGE));
    packageDirectContentReqParams.setWantedFacets(List.of(IFacetConstants.TYPE));
    packageDirectContentReqParams.addPreselection(IFacetConstants.PACKAGE,
        relativePackage.getName());
    var typeFolderResponse = scopeService.fetchFolderContent(packageDirectContentReqParams);
    List<SearchObjectFolder> folders = new ArrayList<>();
    if (typeFolderResponse != null) {
      for (var f : typeFolderResponse.getVirtualFolder()) {
        var typeFolder = new SearchObjectFolder(f.getName(), f.getDisplayName(), f.getCounter());
        typeFolder.setObjectPattern(objectPattern);
        typeFolder.getFacets().add(new Facet(IFacetConstants.PACKAGE, relativePackage.getName()));
        typeFolder.getFacets().add(new Facet(IFacetConstants.TYPE, f.getName()));
        typeFolder.setUri(relativePackage.getUri());
        typeFolder.setFacet(IFacetConstants.TYPE);
        typeFolder.setPackageName(relativePackage.getName());
        folders.add(typeFolder);
      }
    }
    return folders;
  }

  private List<String> getExcludedFacets() {
    if (facets == null) {
      return null;
    }
    return facets.stream().map(Facet::getType).collect(Collectors.toList());
  }
}