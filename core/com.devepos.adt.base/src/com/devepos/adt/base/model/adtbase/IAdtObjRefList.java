/**
 */
package com.devepos.adt.base.model.adtbase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Adt Obj
 * Ref List</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A list of object references.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtObjRefList#getObjectReferences <em>Object
 * References</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRefList()
 * @model extendedMetaData="name='adtObjRefs' kind='elementOnly'"
 * @generated
 */
public interface IAdtObjRefList extends EObject {
  /**
   * Returns the value of the '<em><b>Object References</b></em>' containment
   * reference list. The list contents are of type
   * {@link com.devepos.adt.base.model.adtbase.IAdtObjRef}. <!-- begin-user-doc
   * --> <!-- end-user-doc --> <!-- begin-model-doc --> Alternative root element
   * for a single object reference.
   *
   * <!-- end-model-doc -->
   *
   * @return the value of the '<em>Object References</em>' containment reference
   *         list.
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtObjRefList_ObjectReferences()
   * @model containment="true" required="true" extendedMetaData="kind='element'
   *        name='adtObjRef' namespace='##targetNamespace'"
   * @generated
   */
  EList<IAdtObjRef> getObjectReferences();

} // IAdtObjRefList
