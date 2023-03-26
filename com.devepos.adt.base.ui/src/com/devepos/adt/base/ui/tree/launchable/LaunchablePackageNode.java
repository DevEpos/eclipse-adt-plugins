package com.devepos.adt.base.ui.tree.launchable;

import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.PackageNode;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * ADT Package node that supports launching from eclipse tooling
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class LaunchablePackageNode extends PackageNode implements ILaunchableNode {

  public LaunchablePackageNode() {
    super();
  }

  public LaunchablePackageNode(final String name, final String description,
      final IAdtObjectReference objectReference) {
    super(name, description, objectReference);
  }

  public LaunchablePackageNode(final String name, final String description,
      final IAdtObjectReference objectReference, final ICollectionTreeNode parent) {
    super(name, description, objectReference, parent);
  }
}
