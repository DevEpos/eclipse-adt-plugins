package com.devepos.adt.cst.internal.search.client.engine;

import java.util.ArrayList;
import java.util.List;

import com.sap.adt.communication.content.asx.AbstractAsxDataParser;
import com.sap.adt.communication.content.asx.IAsxData;
import com.sap.adt.communication.content.asx.IAsxDataHandler;
import com.sap.adt.communication.content.asx.IAsxDataSetList;

public class AdtRepoTreeContent extends AbstractAsxDataParser implements IAsxData {

  @Override
  public IAsxDataSetList serialize() {
    return null;
  }

  @Override
  public String getDataName() {
    return AdtRepoTreeService.TREE_CONTENT_MEDIA_TYPE;
  }

  @Override
  public void accept(final IAsxDataHandler handler, final String name) {
    if ("TREE_CONTENT".equals(name)) {
      handler.delegateDeserializationTo(new RepositoryObjectNodes());
    } else if ("OBJECT_TYPES".equals(name)) {
      handler.delegateDeserializationTo(new ObjectTypes());
    }
  }

  public class AdtRepoTreeObjectType extends AbstractAsxDataParser {
    private String objectType;
    private String nodeId;

    public String getObjectType() {
      return objectType;
    }

    public void setObjectType(final String objectType) {
      this.objectType = objectType;
    }

    public String getNodeId() {
      return nodeId;
    }

    public void setNodeId(final String nodeId) {
      this.nodeId = nodeId;
    }

    @Override
    public void accept(final IAsxDataHandler handler, final String name) {
      if ("OBJECT_TYPE".equals(name)) {
        objectType = handler.getSimpleValue();
      } else if ("NODE_ID".equals(name)) {
        nodeId = handler.getSimpleValue();
      }
    }
  }

  public class AdtRepoTreeObjectNode extends AbstractAsxDataParser {

    private String uri;
    private String objectType;
    private String objectName;

    @Override
    public void accept(final IAsxDataHandler handler, final String name) {
      if ("OBJECT_TYPE".equals(name)) {
        objectType = handler.getSimpleValue();
      } else if ("OBJECT_URI".equals(name)) {
        uri = handler.getSimpleValue();
      } else if ("OBJECT_NAME".equals(name)) {
        objectName = handler.getSimpleValue();
      }
    }

    public String getUri() {
      return uri;
    }

    public void setUri(final String uri) {
      this.uri = uri;
    }

    public String getObjectType() {
      return objectType;
    }

    public void setObjectType(final String objectType) {
      this.objectType = objectType;
    }

    public String getObjectName() {
      return objectName;
    }

    public void setObjectName(final String objectName) {
      this.objectName = objectName;
    }
  }

  private List<AdtRepoTreeObjectType> objectTypes;
  private List<AdtRepoTreeObjectNode> objectNodes;

  public List<AdtRepoTreeObjectType> getObjectTypes() {
    if (objectTypes == null) {
      objectTypes = new ArrayList<>();
    }
    return objectTypes;
  }

  public List<AdtRepoTreeObjectNode> getObjectNodes() {
    if (objectNodes == null) {
      objectNodes = new ArrayList<>();
    }
    return objectNodes;
  }

  private class ObjectTypes extends AbstractAsxDataParser {

    @Override
    public void accept(final IAsxDataHandler handler, final String name) {
      if ("SEU_ADT_OBJECT_TYPE_INFO".equals(name)) {
        var objectType = new AdtRepoTreeObjectType();
        getObjectTypes().add(objectType);
        handler.delegateDeserializationTo(objectType);
      }
    }
  }

  private class RepositoryObjectNodes extends AbstractAsxDataParser {

    @Override
    public void accept(final IAsxDataHandler handler, final String name) {
      if ("SEU_ADT_REPOSITORY_OBJ_NODE".equals(name)) {
        var objectNode = new AdtRepoTreeObjectNode();
        getObjectNodes().add(objectNode);
        handler.delegateDeserializationTo(objectNode);
      }
    }
  }
}
