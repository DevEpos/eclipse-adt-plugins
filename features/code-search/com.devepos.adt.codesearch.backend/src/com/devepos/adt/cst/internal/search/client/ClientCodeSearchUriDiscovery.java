package com.devepos.adt.cst.internal.search.client;

import com.devepos.adt.base.util.UriDiscoveryBase;
import com.sap.adt.compatibility.discovery.AdtDiscoveryFactory;

public class ClientCodeSearchUriDiscovery extends UriDiscoveryBase {

  public ClientCodeSearchUriDiscovery(final String destinationId) {
    super(destinationId, AdtDiscoveryFactory.RESOURCE_URI.toString(), "");
  }

  public boolean isVirtualFoldersAvailable() {
    return getCollectionMember("http://www.sap.com/adt/categories/repository",
        "virtualfolders") != null;
  }

  public boolean isDatabaseEditorAvailable() {
    return getCollectionMember("http://www.sap.com/wbobj/dictionary", "tabldt") != null;
  }

  public boolean isStructureEditorAvailable() {
    return getCollectionMember("http://www.sap.com/wbobj/dictionary", "tablds") != null;
  }

  public boolean isServiceDefinitionAvailable() {
    return getCollectionMember("http://www.sap.com/wbobj/raps", "srvdsrv") != null;
  }
}
