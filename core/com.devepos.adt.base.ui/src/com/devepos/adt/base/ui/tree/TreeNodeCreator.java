package com.devepos.adt.base.ui.tree;

import java.util.ArrayList;
import java.util.List;

import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoCollection;
import com.devepos.adt.base.elementinfo.ILazyLoadingElementInfo;
import com.devepos.adt.base.ui.elementinfo.IExecutableElementInfo;
import com.devepos.adt.base.ui.tree.launchable.ILaunchableNode;
import com.devepos.adt.base.ui.tree.launchable.LaunchableAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.launchable.LaunchableLazyLoadingAdtObjectReferenceNode;

/**
 * Utility class for creating Tree nodes
 *
 * @author stockbal
 */
public class TreeNodeCreator {

  private final ICollectionTreeNode treeNode;

  /**
   * Creates new {@link TreeNodeCreator} instance for the given
   * <code>treeNode</code>
   *
   * @param treeNode      the tree node for which sub nodes should be created
   * @param destinationId the destination
   */
  public TreeNodeCreator(final ICollectionTreeNode treeNode) {
    this.treeNode = treeNode;
    if (this.treeNode.getChildren() == null) {
      this.treeNode.setChildren(new ArrayList<>());
    }
  }

  /**
   * Create sub nodes for the given element information
   *
   * @param elementInfo information about an element
   */
  public void createSubNodes(final IElementInfo elementInfo) {
    if (elementInfo == null) {
      return;
    }
    addNode(elementInfo, treeNode);
  }

  /**
   * Creates sub nodes for the given list of element information
   *
   * @param elementInfos a list of element information objects
   */
  public void createSubNodes(final List<IElementInfo> elementInfos) {
    if (elementInfos == null) {
      return;
    }
    for (final IElementInfo elementInfo : elementInfos) {
      createSubNodes(elementInfo);
    }
  }

  protected void addActionNode(final IExecutableElementInfo elementInfo,
      final ICollectionTreeNode collection) {
    final ITreeNode actionNode = new ActionTreeNode(elementInfo.getName(), elementInfo.getImage(),
        collection, elementInfo.getExecutable());
    actionNode.setNodeValue(elementInfo.getAdditionalInfo());
    actionNode.getProperties().putAll(elementInfo.getProperties());
    collection.addChild(actionNode);

  }

  protected void addAdtObjectRefNode(final IAdtObjectReferenceElementInfo adtObjElementInfo,
      final ICollectionTreeNode collection) {
    IAdtObjectReferenceNode adtObjectRefNode = null;
    if (adtObjElementInfo.hasLazyLoadingSupport()) {
      adtObjectRefNode = createLazyLoadingAdtObjRefNode(adtObjElementInfo, collection);
    } else {
      adtObjectRefNode = createFinalAdtObjRefNode(adtObjElementInfo, collection);
      if (adtObjElementInfo.hasChildren()) {
        for (final IElementInfo child : adtObjElementInfo.getChildren()) {
          addNode(child, adtObjectRefNode);
        }
      }
    }
    adtObjectRefNode.setNodeValue(adtObjElementInfo.getAdditionalInfo());
    adtObjectRefNode.getProperties().putAll(adtObjElementInfo.getProperties());
    collection.addChild(adtObjectRefNode);
  }

  protected void addCollection(final IElementInfoCollection collection,
      final ICollectionTreeNode parentNode) {
    final ICollectionTreeNode collectionTreeNode = new FolderTreeNode(collection.getDisplayName(),
        parentNode, collection.getImage(), null);
    collectionTreeNode.setNodeValue(collection.getAdditionalInfo());
    collectionTreeNode.getProperties().putAll(collection.getProperties());
    for (final IElementInfo collectionElement : collection.getChildren()) {
      addNode(collectionElement, collectionTreeNode);
    }
    parentNode.addChild(collectionTreeNode);
  }

  protected void addLazyLoadingFolder(final ILazyLoadingElementInfo lazyLoadingElement,
      final ICollectionTreeNode parent) {
    final ICollectionTreeNode lazyFolder = new LazyLoadingFolderNode(lazyLoadingElement.getName(),
        lazyLoadingElement.getDisplayName(), lazyLoadingElement.getElementInfoProvider(),
        lazyLoadingElement.getImage(), null, parent);
    lazyFolder.setNodeValue(lazyLoadingElement.getAdditionalInfo());
    lazyFolder.getProperties().putAll(lazyLoadingElement.getProperties());
    ((ILazyLoadingNode) lazyFolder).setContentRefreshMode(lazyLoadingElement
        .getContentRefreshMode());
    if (lazyFolder != null) {
      parent.addChild(lazyFolder);
    }

  }

  protected void addNode(final IElementInfo elementInfo, final ICollectionTreeNode parent) {
    if (elementInfo instanceof IAdtObjectReferenceElementInfo) {
      addAdtObjectRefNode((IAdtObjectReferenceElementInfo) elementInfo, parent);
    } else if (elementInfo instanceof IElementInfoCollection) {
      addCollection((IElementInfoCollection) elementInfo, parent);
    } else if (elementInfo instanceof IExecutableElementInfo) {
      addActionNode((IExecutableElementInfo) elementInfo, parent);
    } else if (elementInfo instanceof ILazyLoadingElementInfo) {
      addLazyLoadingFolder((ILazyLoadingElementInfo) elementInfo, parent);
    } else {
      addSimpleNode(elementInfo, parent);
    }
  }

  protected void addSimpleNode(final IElementInfo elementInfo,
      final ICollectionTreeNode collection) {
    final ITreeNode simpleNode = new SimpleInfoTreeNode(elementInfo.getName(), elementInfo
        .getDisplayName(), elementInfo.getImage(), elementInfo.getDescription(), collection);
    simpleNode.setNodeValue(elementInfo.getAdditionalInfo());
    simpleNode.getProperties().putAll(elementInfo.getProperties());
    collection.addChild(simpleNode);

  }

  private IAdtObjectReferenceNode createFinalAdtObjRefNode(
      final IAdtObjectReferenceElementInfo adtObjElementInfo,
      final ICollectionTreeNode collection) {
    IAdtObjectReferenceNode adtObjectRefNode;
    if (isNodeLaunchable(adtObjElementInfo)) {
      adtObjectRefNode = new LaunchableAdtObjectReferenceNode(adtObjElementInfo.getName(),
          adtObjElementInfo.getDisplayName(), adtObjElementInfo.getDescription(), adtObjElementInfo
              .getAdtObjectReference(), collection);
    } else {
      adtObjectRefNode = new AdtObjectReferenceNode(adtObjElementInfo.getName(), adtObjElementInfo
          .getDisplayName(), adtObjElementInfo.getDescription(), adtObjElementInfo
              .getAdtObjectReference(), collection);
    }
    return adtObjectRefNode;
  }

  private IAdtObjectReferenceNode createLazyLoadingAdtObjRefNode(
      final IAdtObjectReferenceElementInfo adtObjElementInfo,
      final ICollectionTreeNode collection) {
    IAdtObjectReferenceNode adtObjectRefNode;
    if (isNodeLaunchable(adtObjElementInfo)) {
      adtObjectRefNode = new LaunchableLazyLoadingAdtObjectReferenceNode(adtObjElementInfo
          .getName(), adtObjElementInfo.getDisplayName(), adtObjElementInfo.getDescription(),
          adtObjElementInfo.getAdtObjectReference(), collection);
    } else {
      adtObjectRefNode = new LazyLoadingAdtObjectReferenceNode(adtObjElementInfo.getName(),
          adtObjElementInfo.getDisplayName(), adtObjElementInfo.getDescription(), adtObjElementInfo
              .getAdtObjectReference(), collection);
    }
    final ILazyLoadingNode lazyLoadingNode = (ILazyLoadingNode) adtObjectRefNode;
    lazyLoadingNode.setContentRefreshMode(adtObjElementInfo.getContentRefreshMode());
    lazyLoadingNode.setElementInfoProvider(adtObjElementInfo.getElementInfoProvider());
    return adtObjectRefNode;
  }

  private boolean isNodeLaunchable(final IAdtObjectReferenceElementInfo adtObjElementInfo) {
    return Boolean.TRUE.toString()
        .equals(adtObjElementInfo.getPropertyValue(ILaunchableNode.class.getName()));
  }
}
