/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Query Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getName <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getValues
 * <em>Values</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getFilters
 * <em>Filters</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getRawInput <em>Raw
 * Input</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryField()
 * @model extendedMetaData="kind='elementOnly' name='field'"
 * @generated
 */
public interface ISearchQueryField extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryField_Name()
   * @model extendedMetaData="name='name' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getName
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
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryField_Values()
   * @model extendedMetaData="name='value' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<String> getValues();

  /**
   * Returns the value of the '<em><b>Filters</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Filters</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryField_Filters()
   * @model containment="true"
   *        extendedMetaData="name='filter' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<ISearchQueryFilter> getFilters();

  /**
   * Returns the value of the '<em><b>Raw Input</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Raw Input</em>' attribute.
   * @see #setRawInput(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryField_RawInput()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" transient="true"
   * @generated
   */
  String getRawInput();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getRawInput <em>Raw
   * Input</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Raw Input</em>' attribute.
   * @see #getRawInput()
   * @generated
   */
  void setRawInput(String value);

} // ISearchQueryField
