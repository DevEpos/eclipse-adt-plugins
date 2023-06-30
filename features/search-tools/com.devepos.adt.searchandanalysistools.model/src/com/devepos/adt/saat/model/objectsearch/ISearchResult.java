/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchResult#getResultObject <em>Result
 * Object</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchResult()
 * @model extendedMetaData="kind='elementOnly' name='searchResult'"
 * @generated
 */
public interface ISearchResult extends EObject {
  /**
   * Returns the value of the '<em><b>Result Object</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.base.model.adtbase.IAdtObjRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Result Object</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchResult_ResultObject()
   * @model containment="true"
   *        extendedMetaData="name='resultObject' kind='element'
   *        namespace='http://www.devepos.com/adt/base'"
   * @generated
   */
  List<IAdtObjRef> getResultObject();

} // ISearchResult
