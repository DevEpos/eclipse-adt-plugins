package com.devepos.adt.base.ui.tree.launchable;

import com.devepos.adt.base.ui.tree.AdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * ADT Object Reference Node that supports launching from eclipse tooling
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class LaunchableAdtObjectReferenceNode extends AdtObjectReferenceNode implements
    ILaunchableNode {

  public LaunchableAdtObjectReferenceNode(final ICollectionTreeNode parent) {
    super(parent);
  }

  public LaunchableAdtObjectReferenceNode(final String name, final String displayName,
      final String description, final IAdtObjectReference objectReference) {
    this(name, displayName, description, objectReference, null);
  }

  public LaunchableAdtObjectReferenceNode(final String name, final String displayName,
      final String description, final IAdtObjectReference adtObjectReference,
      final ICollectionTreeNode collection) {
    super(name, displayName, description, adtObjectReference, collection);
  }

}
