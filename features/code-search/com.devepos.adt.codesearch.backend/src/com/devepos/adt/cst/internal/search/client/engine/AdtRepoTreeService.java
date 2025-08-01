package com.devepos.adt.cst.internal.search.client.engine;

import java.net.URI;
import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.adt.communication.content.AdtContentHandlingFactory;
import com.sap.adt.communication.content.AdtMediaType;
import com.sap.adt.communication.content.asx.AbstractAsxDataParser;
import com.sap.adt.communication.content.asx.IAsxData;
import com.sap.adt.communication.content.asx.IAsxDataHandler;
import com.sap.adt.communication.content.asx.IAsxDataSetList;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.QueryParameter;
import com.sap.adt.compatibility.discovery.AdtDiscoveryFactory;
import com.sap.adt.compatibility.filter.AdtCompatibleRestResourceFilterFactory;

public class AdtRepoTreeService {

  private static final String PARAM_PARENT_NAME = "parent_name";
  private static final String PARAM_TECH_PARENT_NAME = "parent_tech_name";
  private static final String PARAM_PARENT_TYPE = "parent_type";
  private static final String FALLBACK_NODESTRUCTURE_URI = "/sap/bc/adt/repository/nodestructure";
  private static final String CATEGORY_SCHEME = "http://www.sap.com/adt/categories/respository";
  private static final String CATEGORY_TERM = "nodestructure";

  public static final String TREE_CONTENT_MEDIA_TYPE = "com.sap.adt.RepositoryObjectTreeContent";

  private final String destinationId;

  public AdtRepoTreeService(final String destinationId) {
    this.destinationId = destinationId;
  }

  public AdtRepoTreeContent loadTreeContent(final IProgressMonitor monitor, final String name,
      final String type, final String... nodeIds) {

    var restResourceFactory = AdtRestResourceFactory.createRestResourceFactory();
    var restResource = restResourceFactory
        .createResourceWithStatelessSession(getAdtRepoTreeUri(monitor), destinationId);

    var parameters = new ArrayList<QueryParameter>();
    parameters.add(new QueryParameter(PARAM_PARENT_NAME, name));
    parameters.add(new QueryParameter(PARAM_TECH_PARENT_NAME, name));
    parameters.add(new QueryParameter(PARAM_PARENT_TYPE, type));

    var compabilityFilter = AdtCompatibleRestResourceFilterFactory
        .createFilter(AdtMediaType.buildAsXmlMediaType(TREE_CONTENT_MEDIA_TYPE));
    restResource.addRequestFilter(compabilityFilter);
    restResource.addResponseFilter(compabilityFilter);

    var content = restResource.post(monitor, AdtRepoTreeContent.class, new NodeIds(nodeIds),
        parameters.toArray(QueryParameter[]::new));
    return content;
  }

  private URI getAdtRepoTreeUri(final IProgressMonitor monitor) {
    var discovery = AdtDiscoveryFactory.createDiscovery(destinationId,
        AdtDiscoveryFactory.RESOURCE_URI);
    if (discovery.getStatus().isOK()) {
      var collectionMember = discovery.getCollectionMember(CATEGORY_SCHEME, CATEGORY_TERM, monitor);
      if (collectionMember != null) {
        return collectionMember.getUri();
      }
    }
    return URI.create(FALLBACK_NODESTRUCTURE_URI);
  }

  private static class NodeIds extends AbstractAsxDataParser implements IAsxData {

    private final String[] nodeIds;

    public NodeIds(final String... nodeIds) {
      this.nodeIds = nodeIds;
    }

    @Override
    public IAsxDataSetList serialize() {
      var asxDataFactory = AdtContentHandlingFactory.getContentHandlingFactory()
          .getAsxDataFactory();
      var asxDataSetList = asxDataFactory.createAsxDataSetList();
      for (var id : nodeIds) {
        var dataSet = asxDataFactory.createSimpleAsxDataSet("TV_NODEKEY", id);
        asxDataSetList.add(dataSet);
      }
      return asxDataSetList;
    }

    @Override
    public void accept(final IAsxDataHandler var1, final String var2) {
    }

    @Override
    public String getDataName() {
      return null;
    }
  }
}
