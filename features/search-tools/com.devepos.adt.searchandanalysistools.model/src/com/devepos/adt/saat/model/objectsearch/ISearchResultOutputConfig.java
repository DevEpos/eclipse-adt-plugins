/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Result Output Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig#isListOutputSupported
 * <em>List Output Supported</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig#getGroupingLevels
 * <em>Grouping Levels</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig#getTypesForList
 * <em>Types For List</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchResultOutputConfig()
 * @model extendedMetaData="kind='elementOnly' name='searchResultOutputConfig'"
 * @generated
 */
public interface ISearchResultOutputConfig extends EObject {
  /**
   * Returns the value of the '<em><b>List Output Supported</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>List Output Supported</em>' attribute.
   * @see #setListOutputSupported(boolean)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchResultOutputConfig_ListOutputSupported()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  boolean isListOutputSupported();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig#isListOutputSupported
   * <em>List Output Supported</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>List Output Supported</em>' attribute.
   * @see #isListOutputSupported()
   * @generated
   */
  void setListOutputSupported(boolean value);

  /**
   * Returns the value of the '<em><b>Grouping Levels</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Grouping Levels</em>' attribute list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchResultOutputConfig_GroupingLevels()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' namespace='##targetNamespace' name='groupingLevel'"
   * @generated
   */
  List<String> getGroupingLevels();

  /**
   * Returns the value of the '<em><b>Types For List</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Types For List</em>' attribute list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchResultOutputConfig_TypesForList()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' name='typeForList' namespace='##targetNamespace'"
   * @generated
   */
  List<String> getTypesForList();

} // ISearchResultOutputConfig
