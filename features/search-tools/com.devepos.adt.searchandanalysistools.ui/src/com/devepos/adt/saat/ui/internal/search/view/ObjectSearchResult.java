package com.devepos.adt.saat.ui.internal.search.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.ui.tree.FolderTreeNode;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.PackageNode;
import com.devepos.adt.base.ui.tree.launchable.LaunchableAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.launchable.LaunchablePackageNode;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchResult;
import com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig;
import com.devepos.adt.saat.ui.internal.CdsSourceType;
import com.devepos.adt.saat.ui.internal.ExtendedAdtObjectInfo;
import com.devepos.adt.saat.ui.internal.SearchAndAnalysisPlugin;
import com.devepos.adt.saat.ui.internal.messages.Messages;
import com.devepos.adt.saat.ui.internal.util.IImages;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class ObjectSearchResult implements ISearchResult {
  /**
   * Flag (<code>value 1</code>) denoting flat list layout.
   */
  public static final int FLAG_LAYOUT_FLAT = 1;
  /**
   * Flag (<code>value 2</code>) denoting tree layout.
   */
  public static final int FLAG_LAYOUT_TREE = 2;

  static final IAdtObjectReferenceNode[] EMPTY_RESULT = new IAdtObjectReferenceNode[0];

  private final ObjectSearchQuery searchQuery;
  private IObjectSearchResult searchResult;
  private final FolderTreeNode rootNode;
  private final HashSet<ISearchResultListener> searchResultListener;
  private IAdtObjectReferenceNode[] treeResult;
  private IAdtObjectReferenceNode[] packages;
  private IAdtObjectReferenceNode[] listResult;
  private boolean isGroupedResult;
  private int resultCount;
  private boolean hasMoreResults;

  private final Map<String, IAdtObjectReferenceNode> urisToNodes = new HashMap<>();
  private final List<String> urisInCorrectTreeOrder = new ArrayList<>();
  private final Map<String, PackageNode> packageNodeCache = new HashMap<>();
  private final String destinationId;
  private boolean listLayoutActive;

  private ISearchResultOutputConfig outputConfig;

  public ObjectSearchResult(final ObjectSearchQuery searchQuery) {
    this.searchQuery = searchQuery;
    searchResultListener = new HashSet<>();
    destinationId = searchQuery.getDestinationId();
    rootNode = new FolderTreeNode(null, null, null, null);
  }

  @Override
  public void addListener(final ISearchResultListener l) {
    searchResultListener.add(l);
  }

  public void addSearchResult(final IObjectSearchResult searchResult) {
    final ObjectSearchResultEvent resultEvent = new ObjectSearchResultEvent(this);
    if (searchResult != null && searchResult.getResultObjects().size() > 0) {
      this.searchResult = searchResult;
      resultCount = this.searchResult.getResultCount();
    } else {
      this.searchResult = null;
      listResult = null;
      packages = null;
      treeResult = null;
      resultCount = 0;
    }
    informListener(resultEvent);
  }

  public void cleanup() {
    urisInCorrectTreeOrder.clear();
    urisToNodes.clear();
    packageNodeCache.clear();
    searchResult = null;
    listResult = null;
    packages = null;
    resultCount = 0;
    hasMoreResults = false;
    treeResult = null;
    final ObjectSearchResultEvent resultEvent = new ObjectSearchResultEvent(this);
    resultEvent.setCleanup(true);
    informListener(resultEvent);
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    return SearchAndAnalysisPlugin.getDefault().getImageDescriptor(IImages.OBJECT_SEARCH);
  }

  @Override
  public String getLabel() {
    String resultsLabel = null;

    if (resultCount == 1) {
      resultsLabel = Messages.ObjectSearch_OneResult_xmsg;
    } else if (resultCount > 1) {
      if (hasMoreResults) {
        resultsLabel = NLS.bind(Messages.ObjectSearch_MoreThanMaxRowsResults_xmsg, searchQuery
            .getSearchRequest()
            .getMaxResults());
      } else {
        resultsLabel = NLS.bind(Messages.ObjectSearch_Results_xmsg, resultCount);

      }
    } else {
      resultsLabel = Messages.ObjectSearch_NoResults_xmsg;
    }
    // final String label = NLS.bind(Messages.ObjectSearch_SearchResultLabel_xmsg, searchQuery
    // .getSearchRequest(), resultsLabel);
    final String label = NLS.bind("{0} - {1}", searchQuery.getSearchRequest(), resultsLabel);
    return label;
  }

  /**
   * Returns the package ADT objects in the search result
   *
   * @return
   */
  public IAdtObjectReferenceNode[] getPackages() {
    return packages;
  }

  @Override
  public ISearchQuery getQuery() {
    return searchQuery;
  }

  public IObjectSearchResult getResult() {
    return searchResult;
  }

  /**
   * Returns array of tree nodes for display in Table Viewer
   */
  public IAdtObjectReferenceNode[] getResultForList() {
    if (resultCount == 0) {
      return EMPTY_RESULT;
    }
    if (urisToNodes.isEmpty()) {
      createTreeNodes();
    }

    if (listResult == null || listResult == EMPTY_RESULT) {
      createListResult();
    }
    return listResult;
  }

  /**
   * Returns an Array of Tree Nodes, where the root nodes are either CDS Views,
   * Database Tables or Views
   *
   * @param groupByPackage if <code>true</code> the search result should be
   *                       grouped by their packages
   * @return an Array of Tree Nodes, where the root nodes are either CDS Views,
   *         Database Tables or Views
   */
  public IAdtObjectReferenceNode[] getResultForTree(final boolean groupByPackage) {
    if (resultCount == 0) {
      return EMPTY_RESULT;
    }
    if (urisToNodes.isEmpty()) {
      createTreeNodes();
    }

    if (treeResult == null || treeResult == EMPTY_RESULT || groupByPackage != isGroupedResult) {
      isGroupedResult = groupByPackage;
      packages = null;
      rootNode.getChildren().clear();
      connectTreeNodes();

      treeResult = rootNode.getChildren().toArray(new IAdtObjectReferenceNode[0]);
    }
    return treeResult;
  }

  @Override
  public String getTooltip() {
    return getLabel();
  }

  public boolean isListLayoutActive() {
    return listLayoutActive;
  }

  @Override
  public void removeListener(final ISearchResultListener l) {
    searchResultListener.remove(l);
  }

  /**
   * Sets the variable <code>hasMoreResults</code> to indicate that the query has
   * found more results than specified by the maximum number results restriction
   *
   * @param hasMoreResults
   */
  public void setHasMoreResults(final boolean hasMoreResults) {
    this.hasMoreResults = hasMoreResults;
  }

  public void setListLayoutActive(final boolean listLayoutActive) {
    this.listLayoutActive = listLayoutActive;
  }

  public void setOutputConfig(final ISearchResultOutputConfig outputConfig) {
    this.outputConfig = outputConfig;
  }

  public boolean supportsListLayout() {
    return outputConfig.isListOutputSupported();
  }

  protected void informListener(final ObjectSearchResultEvent resultEvent) {
    for (final ISearchResultListener listener : searchResultListener) {
      listener.searchResultChanged(resultEvent);
    }
  }

  /*
   * Create package node from main object and add it to the node map
   */
  private ITreeNode addPackageNode(final IAdtObjRef adtObjRef) {

    // Test if the package node already exists in the tree
    String uri = adtObjRef.getUri();
    PackageNode packageNode = packageNodeCache.get(uri);
    if (packageNode == null) {
      packageNode = new LaunchablePackageNode(adtObjRef.getName(), adtObjRef.getDescription(),
          createObjectRef(adtObjRef));
      packageNodeCache.put(uri, packageNode);
      urisToNodes.put(uri, packageNode);
    }
    return packageNode;
  }

  /*
   * add child nodes to appropriate parent nodes
   */
  private void connectTreeNodes() {
    var packageList = new ArrayList<IAdtObjectReferenceNode>();

    // clear children of all nodes first
    for (var node : urisToNodes.values()) {
      node.getChildren().clear();
    }

    for (String nodeUri : urisInCorrectTreeOrder) {
      IAdtObjectReferenceNode adtObjRefNode = urisToNodes.get(nodeUri);
      if (adtObjRefNode instanceof PackageNode) {
        if (!isGroupedResult) {
          continue;
        }
        packageList.add(adtObjRefNode);
      }

      IAdtObjectReference objectRefOfNode = adtObjRefNode.getObjectReference();

      if (objectRefOfNode.getParentUri() != null) {
        IAdtObjectReferenceNode parentNode = urisToNodes.get(objectRefOfNode.getParentUri());

        if (parentNode == null) {
          throw new IllegalStateException("Inconsistent data in text search result: parent uri '"
              + objectRefOfNode.getParentUri() + "' can not be resolved");
        }

        if (parentNode instanceof PackageNode) {
          if (isGroupedResult) {
            parentNode.addChild(adtObjRefNode);
          } else {
            rootNode.addChild(adtObjRefNode);
          }
        } else {
          parentNode.addChild(adtObjRefNode);
        }
      } else {
        rootNode.addChild(adtObjRefNode);
      }
    }

    packages = packageList.toArray(new IAdtObjectReferenceNode[0]);
  }

  private IAdtObjectReferenceNode createAdtObjectRefNode(final IAdtObjRef adtObjRef) {
    IAdtObjectReferenceNode objectNode = new LaunchableAdtObjectReferenceNode(adtObjRef.getName(),
        adtObjRef.getDisplayName(), adtObjRef.getDescription(), createObjectRef(adtObjRef));
    final var extendedInfo = new ExtendedAdtObjectInfo();
    for (var prop : adtObjRef.getProperties()) {
      switch (prop.getKey()) {
      case "API_STATE":
        extendedInfo.setApiState(prop.getValue());
        break;

      case "SOURCE_TYPE":
        if (!StringUtil.isEmpty(prop.getValue())) {
          extendedInfo.setSourceType(CdsSourceType.getFromId(prop.getValue()));
        }
        break;
      default:
        objectNode.getProperties().put(prop.getKey(), prop.getValue());
      }
    }
    objectNode.setNodeValue(extendedInfo);
    return objectNode;
  }

  private void createListResult() {
    var results = new ArrayList<IAdtObjectReferenceNode>();

    var validListTypes = outputConfig.getTypesForList();

    for (String nodeUri : urisInCorrectTreeOrder) {
      IAdtObjectReferenceNode adtObjRefNode = urisToNodes.get(nodeUri);
      if (adtObjRefNode instanceof PackageNode || !validListTypes.contains(adtObjRefNode
          .getAdtObjectType())) {
        continue;
      }

      IAdtObjectReference objectRefOfNode = adtObjRefNode.getObjectReference();

      if (objectRefOfNode.getParentUri() != null) {
        IAdtObjectReferenceNode parentNode = urisToNodes.get(objectRefOfNode.getParentUri());

        if (parentNode == null) {
          throw new IllegalStateException("Inconsistent data in text search result: parent uri '"
              + objectRefOfNode.getParentUri() + "' can not be resolved");
        }

        results.add(adtObjRefNode);
      }
    }

    listResult = results.toArray(new IAdtObjectReferenceNode[0]);
  }

  private IAdtObjectReference createObjectRef(final IAdtObjRef adtObjRef) {
    IAdtObjectReference adtObjectRef = AdtObjectReferenceModelFactory.createReference(destinationId,
        adtObjRef.getName(), adtObjRef.getType(), adtObjRef.getUri());
    adtObjectRef.setParentUri(adtObjRef.getParentUri());
    return adtObjectRef;
  }

  private void createTreeNodes() {
    for (var adtObjRef : searchResult.getResultObjects()) {
      if (IAdtObjectTypeConstants.PACKAGE.equalsIgnoreCase(adtObjRef.getType())) {
        addPackageNode(adtObjRef);
        urisInCorrectTreeOrder.add(adtObjRef.getUri());
      } else {
        IAdtObjectReferenceNode objectNode = createAdtObjectRefNode(adtObjRef);
        urisToNodes.put(adtObjRef.getUri(), objectNode);
        urisInCorrectTreeOrder.add(adtObjRef.getUri());
      }
    }
  }
}
