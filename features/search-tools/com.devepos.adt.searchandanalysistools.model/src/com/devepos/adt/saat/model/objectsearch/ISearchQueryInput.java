/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Query Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getType <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getTypeLabel <em>Type
 * Label</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getMaxRows <em>Max
 * Rows</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isCombineFiltersWithAnd
 * <em>Combine Filters With And</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isWithApiState <em>With Api
 * State</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isRowLimitDisabled <em>Row
 * Limit Disabled</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getFields
 * <em>Fields</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getCustomOptions <em>Custom
 * Options</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryInput()
 * @model extendedMetaData="kind='elementOnly' name='queryInput'"
 * @generated
 */
public interface ISearchQueryInput extends EObject {
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryInput_Type()
   * @model extendedMetaData="name='type' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getType
   * <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Type Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Type Label</em>' attribute.
   * @see #setTypeLabel(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryInput_TypeLabel()
   * @model transient="true"
   * @generated
   */
  String getTypeLabel();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getTypeLabel <em>Type
   * Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Type Label</em>' attribute.
   * @see #getTypeLabel()
   * @generated
   */
  void setTypeLabel(String value);

  /**
   * Returns the value of the '<em><b>Max Rows</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Max Rows</em>' attribute.
   * @see #setMaxRows(int)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryInput_MaxRows()
   * @model extendedMetaData="name='maxRows' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  int getMaxRows();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getMaxRows <em>Max
   * Rows</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Max Rows</em>' attribute.
   * @see #getMaxRows()
   * @generated
   */
  void setMaxRows(int value);

  /**
   * Returns the value of the '<em><b>Combine Filters With And</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Combine Filters With And</em>' attribute.
   * @see #setCombineFiltersWithAnd(boolean)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryInput_CombineFiltersWithAnd()
   * @model extendedMetaData="name='combineFiltersWithAnd' kind='attribute'
   *        namespace='##targetNamespace'"
   * @generated
   */
  boolean isCombineFiltersWithAnd();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isCombineFiltersWithAnd
   * <em>Combine Filters With And</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Combine Filters With And</em>' attribute.
   * @see #isCombineFiltersWithAnd()
   * @generated
   */
  void setCombineFiltersWithAnd(boolean value);

  /**
   * Returns the value of the '<em><b>With Api State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>With Api State</em>' attribute.
   * @see #setWithApiState(boolean)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryInput_WithApiState()
   * @model extendedMetaData="name='withApiState' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  boolean isWithApiState();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isWithApiState <em>With Api
   * State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>With Api State</em>' attribute.
   * @see #isWithApiState()
   * @generated
   */
  void setWithApiState(boolean value);

  /**
   * Returns the value of the '<em><b>Row Limit Disabled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Row Limit Disabled</em>' attribute.
   * @see #setRowLimitDisabled(boolean)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryInput_RowLimitDisabled()
   * @model extendedMetaData="name='rowLimitDisabled' kind='attribute'
   *        namespace='##targetNamespace'"
   * @generated
   */
  boolean isRowLimitDisabled();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isRowLimitDisabled <em>Row
   * Limit Disabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Row Limit Disabled</em>' attribute.
   * @see #isRowLimitDisabled()
   * @generated
   */
  void setRowLimitDisabled(boolean value);

  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryInput_Fields()
   * @model containment="true"
   *        extendedMetaData="name='field' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<ISearchQueryField> getFields();

  /**
   * Returns the value of the '<em><b>Custom Options</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type {@link java.lang.String},
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Custom Options</em>' map.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchQueryInput_CustomOptions()
   * @model mapType="com.devepos.adt.saat.model.objectsearch.StringToStringMapEntry&lt;org.eclipse.emf.ecore.xml.type.String,
   *        org.eclipse.emf.ecore.xml.type.String&gt;"
   *        extendedMetaData="kind='element' namespace='##targetNamespace' name='customOption'"
   * @generated
   */
  Map<String, String> getCustomOptions();

} // ISearchQueryInput
