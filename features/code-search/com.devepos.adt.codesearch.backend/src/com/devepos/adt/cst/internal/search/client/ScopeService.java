package com.devepos.adt.cst.internal.search.client;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.sap.adt.ris.model.virtualfolders.IVirtualFoldersResult;
import com.sap.adt.ris.search.virtualfolders.AdtRisVirtualFoldersServiceFactory;
import com.sap.adt.ris.search.virtualfolders.IAdtRisVirtualFoldersRequestParameters;
import com.sap.adt.tools.core.model.util.ServiceNotAvailableException;

@SuppressWarnings("restriction")
public class ScopeService {
  private String destination;
  private IClientCodeSearchConfig specs;
  private IProgressMonitor monitor;

  public ScopeService(String destination, IProgressMonitor monitor, IClientCodeSearchConfig specs) {
    this.destination = destination;
    this.monitor = monitor;
    this.specs = specs;
  }

  public IAdtRisVirtualFoldersRequestParameters buildFolderRequestParams(
      List<String> excludedFacets) {
    var params = AdtRisVirtualFoldersServiceFactory.createVirtualFolderRequestParameters();
    if (specs.getObjectName() != null) {
      params.setObjectSearchPattern(specs.getObjectName());
    } else {
      params.setObjectSearchPattern("*");
    }
    specs.getFacets().forEach((key, value) -> {
      if (excludedFacets != null && excludedFacets.contains(key)) {
        return;
      }
      value.forEach(v -> params.addPreselection(key, v));
    });
    return params;
  }

  public IVirtualFoldersResult fetchFolderContent(IAdtRisVirtualFoldersRequestParameters params) {
    try {
      // System.out.println("Fetching virtual folder content " + params.toString());
      var service = AdtRisVirtualFoldersServiceFactory
          .createVirtualFoldersSearchService(destination);
      // var info = service.getInfo(params, monitor);
      return service.getContent(params, monitor);
    } catch (ServiceNotAvailableException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
