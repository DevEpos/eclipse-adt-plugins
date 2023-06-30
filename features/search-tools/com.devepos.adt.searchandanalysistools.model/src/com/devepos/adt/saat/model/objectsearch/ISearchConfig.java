/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchConfig#getSearchTypes <em>Search
 * Types</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchConfig()
 * @model extendedMetaData="kind='elementOnly' name='searchConfig'"
 * @generated
 */
public interface ISearchConfig extends EObject {
  /**
   * Returns the value of the '<em><b>Search Types</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.saat.model.objectsearch.ISearchType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Search Types</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchConfig_SearchTypes()
   * @model containment="true"
   *        extendedMetaData="name='searchType' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<ISearchType> getSearchTypes();

} // ISearchConfig
