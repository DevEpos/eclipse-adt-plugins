package com.devepos.adt.base.elementinfo;

import org.eclipse.core.runtime.IAdaptable;

import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public interface IAdtObjectReferenceElementInfo
    extends IElementInfoCollection, ILazyLoadingElementInfo, IAdaptable {

  /**
   * @return the ADT object reference of the element
   */
  IAdtObjectReference getAdtObjectReference();

  /**
   * Returns the ADT Object type of the ADT Object reference
   *
   * @return the ADT Object type of the ADT Object reference
   */
  String getAdtType();

  /**
   * Returns the URI of the ADT Object
   *
   * @return the URI of the ADT Object
   */
  String getUri();

  /**
   * Signals that the ADT object reference supports lazy loading or not
   *
   * @return <code>true</code> if this element info of a ADT Object reference
   *         support lazy loading
   */
  boolean hasLazyLoadingSupport();

  /**
   * Sets ADT object reference of this element
   *
   * @param objectReference the new object reference to be set
   */
  void setAdtObjectReference(IAdtObjectReference objectReference);

  /**
   * Sets this ADT Object reference element information to lazy loading
   *
   * @param supportsLazyLoading
   */
  void setLazyLoadingSupport(boolean lazyLoading);

}
