package com.devepos.adt.cst.ui.internal.codesearch.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.ui.tree.FolderTreeNode;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.PackageNode;
import com.devepos.adt.base.ui.tree.launchable.LaunchableAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.launchable.LaunchablePackageNode;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.model.codesearch.ICodeSearchObject;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Handles creating the result tree for the code search
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
class ResultTreeBuilder {
  private final FolderTreeNode rootNode;
  private final String destinationId;
  private Map<String, IAdtObjectReferenceNode> urisToNodes = new HashMap<>();
  private List<String> urisInCorrectTreeOrder;
  private List<PackageNode> newPackagesToAddToTree;
  private List<ITreeNode> flatResult;
  private List<ITreeNode> nodesWithMatches;
  private final Map<String, PackageNode> packageNodeCache = new HashMap<>();
  private final FileMatchesCache fileMatchesCache;

  /**
   * Creates new result tree instance
   *
   * @param fileMatchesCache cache to handle track matches to a given file URI
   * @param destinationId    destination id which was used to create the search result
   */
  public ResultTreeBuilder(final FileMatchesCache fileMatchesCache, final String destinationId) {
    this.fileMatchesCache = fileMatchesCache;
    rootNode = new FolderTreeNode(null, null, null, null);
    // use synchronized list as concurrent modifification can happen
    rootNode.setChildren(Collections.synchronizedList(new ArrayList<>()));
    this.destinationId = destinationId;
  }

  /**
   * Converts the given <code>searchResult</code> to a tree compatible data structure
   *
   * @param searchResult result object from the code search
   */
  public void addResultToTree(final ICodeSearchResult searchResult) {
    flatResult = new ArrayList<>();
    urisInCorrectTreeOrder = new ArrayList<>();
    urisToNodes = new HashMap<>();
    nodesWithMatches = new ArrayList<>();
    newPackagesToAddToTree = new ArrayList<>();

    createTreeNodes(searchResult);
    connectPackageNodes();
    connectTreeNodes();
    propagateMatchCountsToRoot();
  }

  /**
   * Clears the buffer lists/maps of the last
   */
  public void clearBuffersOfLastResult() {
    if (flatResult != null) {
      flatResult.clear();
    }
    if (urisInCorrectTreeOrder != null) {
      urisInCorrectTreeOrder.clear();
    }
    if (urisToNodes != null) {
      urisToNodes.clear();
    }
    if (nodesWithMatches != null) {
      nodesWithMatches.clear();
    }
    if (newPackagesToAddToTree != null) {
      newPackagesToAddToTree.clear();
    }
  }

  public void clearPackageNodeCache() {
    packageNodeCache.clear();
  }

  public List<ITreeNode> getFlatResult() {
    return flatResult;
  }

  public ICollectionTreeNode getRootNode() {
    return rootNode;
  }

  public void removePackageNode(final PackageNode child) {
    packageNodeCache.remove(child.getUri());
  }

  /*
   * Create package node from main object and add it to the node map
   */
  private ITreeNode addPackageNode(final ICodeSearchObject searchObject,
      final IAdtObjRef mainObject) {

    // Test if the package node already exists in the tree
    String uri = searchObject.getUri();
    var packageNode = packageNodeCache.get(uri);
    if (packageNode == null) {
      packageNode = new LaunchablePackageNode(mainObject.getName(), null,
          createObjectRef(destinationId, mainObject, searchObject));
      // use synchronized list as concurrent modifification can happen
      packageNode.setChildren(Collections.synchronizedList(new ArrayList<>()));
      packageNodeCache.put(uri, packageNode);
      newPackagesToAddToTree.add(packageNode);
      urisToNodes.put(uri, packageNode);
      return packageNode;
    }
    urisToNodes.put(uri, packageNode);
    return null;
  }

  private void addSearchMatchNodes(final ICodeSearchObject searchObject,
      final IAdtObjectReferenceNode objectNode) {

    if (!searchObject.getMatches().isEmpty()) {
      for (var match : searchObject.getMatches()) {
        var matchNode = new SearchMatchNode(match, objectNode);
        objectNode.addChild(matchNode);
        flatResult.add(matchNode);
        fileMatchesCache.addNode(matchNode);
      }

      objectNode.setNodeValue(searchObject.getMatches().size());
      nodesWithMatches.add(objectNode);
    }
  }

  private void connectPackageNodes() {
    for (var packageNode : newPackagesToAddToTree) {
      var adtObjRefNode = urisToNodes.get(packageNode.getUri());
      var parentUri = adtObjRefNode.getParentUri();

      if (parentUri != null) {
        IAdtObjectReferenceNode parentNode = packageNodeCache.get(parentUri);

        if (parentNode == null) {
          throw new IllegalStateException("Inconsistent data in text search result: parent uri '" +
              parentUri + "' can not be resolved");
        }
        parentNode.addChild(adtObjRefNode);
      }
    }
  }

  /*
   * add child nodes to appropriate parent nodes
   */
  private void connectTreeNodes() {
    for (String nodeUri : urisInCorrectTreeOrder) {
      var adtObjRefNode = urisToNodes.get(nodeUri);

      var parentUri = adtObjRefNode.getParentUri();
      if (parentUri == null) {
        continue;
      }
      var parentNode = urisToNodes.get(parentUri);

      if (parentNode == null) {
        throw new IllegalStateException("Inconsistent data in text search result: parent uri '" +
            parentUri + "' can not be resolved");
      }

      if (parentNode instanceof PackageNode) {
        /*
         * check if node has already been added to package (could happen during searches of requests
         * with big methods)
         */
        var existingChild = parentNode.getChildren()
            .parallelStream()
            .filter(n -> nodeUri.equals(((IAdtObjectReferenceNode) n).getUri()))
            .findFirst();
        if (existingChild.isPresent()) {
          urisToNodes.put(nodeUri, (IAdtObjectReferenceNode) existingChild.get());
        } else {
          parentNode.addChild(adtObjRefNode);
        }
      } else {
        parentNode.addChild(adtObjRefNode);
      }
    }
  }

  private IAdtObjectReferenceNode createAdtObjectRefNode(final String destinationId,
      final ICodeSearchObject searchObject, final IAdtObjRef mainObject) {
    var objectNode = new LaunchableAdtObjectReferenceNode(mainObject.getName(),
        mainObject.getDisplayName(), mainObject.getDescription(),
        createObjectRef(destinationId, mainObject, searchObject));
    // use synchronized list as concurrent modifification can happen
    objectNode.setChildren(Collections.synchronizedList(new ArrayList<>()));
    if (mainObject.getOwner() != null) {
      objectNode.getProperties()
          .put(IResultPropertyNameConstants.OBJECT_RESPONSIBLE, mainObject.getOwner());
    }
    return objectNode;
  }

  private IAdtObjectReference createObjectRef(final String destinationId,
      final IAdtObjRef adtMainObject, final ICodeSearchObject searchObject) {
    var adtObjectRef = AdtObjectReferenceModelFactory.createReference(destinationId,
        adtMainObject.getName(), adtMainObject.getType(), searchObject.getUri());
    adtObjectRef.setParentUri(searchObject.getParentUri());
    return adtObjectRef;
  }

  private void createTreeNodes(final ICodeSearchResult searchResult) {
    for (ICodeSearchObject searchObject : searchResult.getSearchObjects()) {
      var mainObject = searchObject.getAdtMainObject();
      ITreeNode newNode = null;

      if (IAdtObjectTypeConstants.PACKAGE.equalsIgnoreCase(mainObject.getType())) {
        newNode = addPackageNode(searchObject, mainObject);
      } else {
        // non package types are all AdtObjectReference types
        IAdtObjectReferenceNode objectNode = createAdtObjectRefNode(destinationId, searchObject,
            mainObject);
        addSearchMatchNodes(searchObject, objectNode);
        String nodeUuid = null;
        // NOTE: "isExpandedObject" should be enough as check, but the other 2 checks will be kept
        // for a few more releases for compatibility to older backends
        if (IAdtObjectTypeConstants.FUNCTION_INCLUDE.equals(mainObject.getType())
            || IAdtObjectTypeConstants.PROGRAM_INCLUDE.equals(mainObject.getType())
            || mainObject.getProperties().containsKey("isExpandedObject")) {
          // double fail-safe if program,structure or db table has matches in expanded
          // include and resides under package
          if (packageNodeCache.containsKey(searchObject.getParentUri())) {
            nodeUuid = searchObject.getUri();
          } else {
            nodeUuid = searchObject.getParentUri() + "::" + searchObject.getUri();
          }
        } else {
          nodeUuid = searchObject.getUri();
        }
        urisToNodes.put(nodeUuid, objectNode);
        urisInCorrectTreeOrder.add(nodeUuid);
        newNode = objectNode;

      }

      if (newNode != null && StringUtil.isEmpty(searchObject.getParentUri())) {
        rootNode.addChild(newNode);
      }
    }
  }

  private void propagateMatchCountsToRoot() {
    for (ITreeNode nodeWithMatches : nodesWithMatches) {
      propagateMatchCountToRoot(nodeWithMatches);
    }
  }

  private void propagateMatchCountToRoot(final ITreeNode node) {
    var parentNode = node.getParent();
    while (parentNode != null && parentNode != rootNode) {
      Integer childMatchCount = (Integer) node.getNodeValue();
      if (childMatchCount == null) {
        return;
      }

      Integer parentMatchCount = (Integer) parentNode.getNodeValue();
      if (parentMatchCount == null) {
        parentNode.setNodeValue(childMatchCount);
      } else {
        parentNode.setNodeValue(parentMatchCount + childMatchCount);
      }

      parentNode = parentNode.getParent();
    }
  }
}