/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Query Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryParam#getName <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryParam#getValues
 * <em>Values</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryParam()
 * @model
 * @generated
 */
public interface ISearchQueryParam extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryParam_Name()
   * @model extendedMetaData="name='name' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryParam#getName
   * <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Values</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Values</em>' attribute list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryParam_Values()
   * @model extendedMetaData="name='value' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<String> getValues();

} // ISearchQueryParam
