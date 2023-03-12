package com.devepos.adt.base.ui.tree.launchable;

import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingAdtObjectReferenceNode;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * ADT Object Reference node with lazy loading support that supports launching from eclipse tooling
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class LaunchableLazyLoadingAdtObjectReferenceNode extends LazyLoadingAdtObjectReferenceNode
    implements ILaunchableNode {

  public LaunchableLazyLoadingAdtObjectReferenceNode(final ICollectionTreeNode parent) {
    super(parent);
  }

  public LaunchableLazyLoadingAdtObjectReferenceNode(final String name, final String displayName,
      final String description, final IAdtObjectReference objectReference,
      final ICollectionTreeNode parent) {
    super(name, displayName, description, objectReference, parent);
  }
}
