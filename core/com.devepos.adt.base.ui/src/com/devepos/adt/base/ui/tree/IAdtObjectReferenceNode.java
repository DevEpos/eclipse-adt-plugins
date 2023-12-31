package com.devepos.adt.base.ui.tree;

import org.eclipse.core.runtime.IAdaptable;

import com.devepos.adt.base.ObjectType;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Tree node which holds a reference to a {@link IAdtObjectReference}
 *
 * @author stockbal
 */
public interface IAdtObjectReferenceNode extends ICollectionTreeNode, IAdaptable {
  /**
   * Returns the ADT object type of the underlying ADT object reference
   *
   * @return
   */
  String getAdtObjectType();

  /**
   * @return the object reference of the node
   */
  IAdtObjectReference getObjectReference();

  /**
   * Returns the object type of the underlying ADT object reference
   *
   * @return
   */
  ObjectType getObjectType();

  /**
   * @return URI of parent of contained ADT object reference
   */
  String getParentUri();

  /**
   * @return URI of ADT object reference
   */
  String getUri();

  /**
   * Sets the object reference of the node
   *
   * @param objectReference
   */
  void setObjectReference(IAdtObjectReference objectReference);

  /**
   * Returns <code>true</code> if this ADT object reference can be opened in the
   * Data Preview
   *
   * @return <code>true</code> if Data Preview is supported
   */
  boolean supportsDataPreview();
}
