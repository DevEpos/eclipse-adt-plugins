package com.devepos.adt.cst.internal.search.client;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.cst.internal.CodeSearchPlugin;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.sap.adt.ris.model.virtualfolders.IVirtualFoldersResult;
import com.sap.adt.ris.search.virtualfolders.AdtRisVirtualFoldersServiceFactory;
import com.sap.adt.ris.search.virtualfolders.IAdtRisVirtualFoldersRequestParameters;
import com.sap.adt.tools.core.model.util.ServiceNotAvailableException;

@SuppressWarnings("restriction")
public class ScopeService {
  private final String destination;
  private final IClientCodeSearchConfig config;
  private final IProgressMonitor monitor;

  public ScopeService(final String destination, final IProgressMonitor monitor,
      final IClientCodeSearchConfig config) {
    this.destination = destination;
    this.monitor = monitor;
    this.config = config;
  }

  public IAdtRisVirtualFoldersRequestParameters buildFolderRequestParams() {
    return buildFolderRequestParams(null);
  }

  public IAdtRisVirtualFoldersRequestParameters buildFolderRequestParams(
      final List<String> excludedFacets) {
    var params = AdtRisVirtualFoldersServiceFactory.createVirtualFolderRequestParameters();
    params.setIgnoreShortDescriptions(true);
    config.getFacets().forEach((key, value) -> {
      if (excludedFacets != null && excludedFacets.contains(key)) {
        return;
      }
      value.forEach(v -> params.addPreselection(key, v));
    });
    return params;
  }

  public IVirtualFoldersResult fetchFolderContent(
      final IAdtRisVirtualFoldersRequestParameters params) {
    try {
      // System.out.println("Fetching virtual folder content " + params.toString());
      var service = AdtRisVirtualFoldersServiceFactory
          .createVirtualFoldersSearchService(destination);
      // var info = service.getInfo(params, monitor);
      return service.getContent(params, monitor);
    } catch (ServiceNotAvailableException | IOException | IllegalArgumentException e) {
      CodeSearchPlugin.getDefault()
          .getLog()
          .log(new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID,
              String.format("Virtual Folder Content for %s could not be retrieved",
                  params.getPreselectionFacets()),
              e));
    }
    return null;
  }
}
