/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Input Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchInputControl#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchInputControl#getLabel
 * <em>Label</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchInputControl#getFilters
 * <em>Filters</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchInputControl()
 * @model extendedMetaData="kind='elementOnly' name='input'"
 * @generated
 */
public interface ISearchInputControl extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchInputControl_Name()
   * @model extendedMetaData="name='name' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchInputControl#getName <em>Name</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Label</em>' attribute.
   * @see #setLabel(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchInputControl_Label()
   * @model extendedMetaData="name='label' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchInputControl#getLabel <em>Label</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

  /**
   * Returns the value of the '<em><b>Filters</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.saat.model.objectsearch.ISearchFilter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Filters</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchInputControl_Filters()
   * @model containment="true"
   *        extendedMetaData="name='filter' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<ISearchFilter> getFilters();

} // ISearchInputControl
