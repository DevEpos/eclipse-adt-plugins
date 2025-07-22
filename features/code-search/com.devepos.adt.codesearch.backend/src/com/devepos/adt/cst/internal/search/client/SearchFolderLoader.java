package com.devepos.adt.cst.internal.search.client;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.search.client.AdtPackage;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.SearchObjectFolder;
import com.sap.adt.ris.model.virtualfolders.IVirtualFolder;
import com.sap.adt.tools.core.atom.AdtAtomUtilFactory;
import com.sap.adt.tools.core.atom.IAdtAtomUtil;

@SuppressWarnings("restriction")
class SearchFolderLoader {
  private final ScopeService scopeService;
  private final IAdtAtomUtil atomUtil;

  public SearchFolderLoader(final String destinationId, final IProgressMonitor monitor,
      final IClientCodeSearchConfig specs) {
    scopeService = new ScopeService(destinationId, monitor, specs);
    atomUtil = AdtAtomUtilFactory.createAtomUtil();
  }

  public List<SearchObjectFolder> run() {
    var packageExpandRequestParams = scopeService.buildFolderRequestParams(null);
    packageExpandRequestParams.setWantedFacets(List.of(IFacetConstants.PACKAGE));
    var packageResponse = scopeService.fetchFolderContent(packageExpandRequestParams);
    List<SearchObjectFolder> folders = new ArrayList<>();
    if (packageResponse == null) {
      return folders;
    }
    var objectCountInExpandedPackages = 0;
    AdtPackage relativePackage = null;
    for (var f : packageResponse.getVirtualFolder()) {
      // REVISIT: why is this contained in the result???
      if (f.getName().startsWith("..")) {
        relativePackage = new AdtPackage(getPackageUri(f), f.getName().substring(2),
            f.getDisplayName().substring(2), f.getCounter(), null);
        continue;
      }
      objectCountInExpandedPackages += f.getCounter();
      var uri = getPackageUri(f);
      var packageFolder = new SearchObjectFolder(f.getName(), f.getDisplayName(), f.getCounter());
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

  private List<SearchObjectFolder> getTypeFolders(final AdtPackage relativePackage) {
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

  private String getPackageUri(final IVirtualFolder f) {
    var uri = atomUtil.findAtomLinkAsUri(f.getLinks(), "http://www.sap.com/adt/relations/packages",
        "application/vnd.sap.sapgui");
    return uri != null ? uri.toString() : null;
  }
}