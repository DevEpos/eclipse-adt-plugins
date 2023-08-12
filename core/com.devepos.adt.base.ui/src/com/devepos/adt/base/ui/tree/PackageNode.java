package com.devepos.adt.base.ui.tree;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Tree node that represents an ABAP Development package
 *
 * @author stockbal
 */
public class PackageNode extends AdtObjectReferenceNode {

  private String childCountString;
  private int childCount;

  public PackageNode() {
    super(null);
  }

  public PackageNode(final String name, final String description,
      final IAdtObjectReference objectReference) {
    super(name, name, description, objectReference);
  }

  public PackageNode(final String name, final String description,
      final IAdtObjectReference objectReference, final ICollectionTreeNode parent) {
    super(name, name, description, objectReference, parent);
  }

  @Override
  public String getSizeAsString() {
    if (childCountString == null) {
      determineNonPackageCount(getChildren());
      childCountString = new DecimalFormat("###,###").format(childCount);
    }
    return childCountString;
  }

  public List<PackageNode> getSubPackages() {
    final List<PackageNode> subPackages = new LinkedList<>();
    determineSubPackages(subPackages, getChildren());
    return subPackages;
  }

  private void determineNonPackageCount(final List<ITreeNode> nodes) {
    if (nodes == null) {
      return;
    }
    for (final ITreeNode childNode : nodes) {
      if (!(childNode instanceof PackageNode)) {
        childCount++;
      } else {
        determineNonPackageCount(((ICollectionTreeNode) childNode).getChildren());
      }
    }
  }

  private void determineSubPackages(final List<PackageNode> subPackages,
      final List<ITreeNode> children) {
    if (children == null) {
      return;
    }
    for (final ITreeNode childNode : children) {
      if (childNode instanceof PackageNode) {
        final PackageNode packageNode = (PackageNode) childNode;
        subPackages.add(packageNode);
        determineSubPackages(subPackages, packageNode.getChildren());
      }
    }
  }

}
