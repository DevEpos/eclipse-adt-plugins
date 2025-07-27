package com.devepos.adt.cst.internal.search.client;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.search.client.AdtPackage;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.sap.adt.ris.model.virtualfolders.IVirtualFolder;
import com.sap.adt.tools.core.atom.AdtAtomUtilFactory;
import com.sap.adt.tools.core.atom.IAdtAtomUtil;

@SuppressWarnings("restriction")
class PackageLoader {
  private ScopeService scopeService;
  private IProgressMonitor monitor;
  private String destination;
  private IAdtAtomUtil atomUtil;

  public PackageLoader(String destinationId, IProgressMonitor monitor,
      IClientCodeSearchConfig specs) {
    scopeService = new ScopeService(destinationId, monitor, specs);
    this.monitor = monitor;
    this.destination = destinationId;
    this.atomUtil = AdtAtomUtilFactory.createAtomUtil();
  }

  public List<AdtPackage> run() {
    var rootPackages = getRootPackages();
    // for (var pack : rootPackages) {
    // PackageUtils.getPackageHierarchy(pack.getUri(), monitor, destination);
    // }
    filterDuplicatePackages(rootPackages);
    for (var pack : rootPackages) {
      if (pack.isHasSubPackages()) {
        pack.setSubPackageLoader((monitor, destination, specs) -> getSubPackages(pack,
            new ScopeService(destination, monitor, specs)));
      }
    }

    return rootPackages;
  }

  private void filterDuplicatePackages(List<AdtPackage> rootPackages) {
    // TODO: Ignore for now and live with potential redundant object searches
  }

  private void getSubPackages(AdtPackage pack, ScopeService scopeService) {
    var subPackageReqParams = scopeService.buildFolderRequestParams();
    subPackageReqParams.addPreselection(IFacetConstants.PACKAGE, pack.getName());
    subPackageReqParams.setWantedFacets(List.of(IFacetConstants.PACKAGE));
    var subFoldersResponse = scopeService.fetchFolderContent(subPackageReqParams);
    if (subFoldersResponse != null) {
      for (var f : subFoldersResponse.getVirtualFolder()) {
        var subPackage = new AdtPackage(getPackageUri(f), f.getName(), f.getDisplayName(),
            f.getCounter(), null);
        if (f.isHasChildrenOfSameFacet()) {
          subPackage.setHasSubPackages(true);
          getSubPackages(subPackage, scopeService);
        }
        pack.getSubPackages().add(subPackage);
      }
    }
  }

  private List<AdtPackage> getRootPackages() {
    var folderSearchParams = scopeService.buildFolderRequestParams();
    folderSearchParams.setWantedFacets(List.of(IFacetConstants.PACKAGE));
    var packageResponse = scopeService.fetchFolderContent(folderSearchParams);
    List<AdtPackage> packages = new ArrayList<>();
    if (packageResponse != null) {
      for (var f : packageResponse.getVirtualFolder()) {
        // REVISIT: why is this contained in the result???
        if (f.getName().startsWith("..")) {
          continue;
        }
        var uri = getPackageUri(f);
        var p = new AdtPackage(uri, f.getName(), f.getDisplayName(), f.getCounter(), null);
        // if (uri != null) {
        // var hierarchy = PackageUtils.getPackageHierarchy(uri, monitor, destination);
        // p.setHierarchy(hierarchy);
        // }
        p.setHasSubPackages(f.isHasChildrenOfSameFacet());
        packages.add(p);
      }
    }
    return packages;
  }

  private String getPackageUri(IVirtualFolder f) {
    var uri = atomUtil.findAtomLinkAsUri(f.getLinks(), "http://www.sap.com/adt/relations/packages",
        "application/vnd.sap.sapgui");
    return uri != null ? uri.toString() : null;
  }
}