/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IObjectSearchResult#getResultCount <em>Result
 * Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IObjectSearchResult#getResultObjects
 * <em>Result Objects</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getObjectSearchResult()
 * @model extendedMetaData="kind='elementOnly' name='searchResult'"
 * @generated
 */
public interface IObjectSearchResult extends EObject {
  /**
   * Returns the value of the '<em><b>Result Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Result Count</em>' attribute.
   * @see #setResultCount(int)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getObjectSearchResult_ResultCount()
   * @model extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  int getResultCount();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.IObjectSearchResult#getResultCount <em>Result
   * Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Result Count</em>' attribute.
   * @see #getResultCount()
   * @generated
   */
  void setResultCount(int value);

  /**
   * Returns the value of the '<em><b>Result Objects</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.base.model.adtbase.IAdtObjRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Result Objects</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getObjectSearchResult_ResultObjects()
   * @model containment="true"
   *        extendedMetaData="name='adtObjRef' kind='element'
   *        namespace='http://www.devepos.com/adt/base'"
   * @generated
   */
  List<IAdtObjRef> getResultObjects();

} // IObjectSearchResult
