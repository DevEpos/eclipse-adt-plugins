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
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchConfig#getImageInfos <em>Image
 * Infos</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchConfig()
 * @model extendedMetaData="kind='elementOnly' name='searchConfig'"
 * @generated
 */
public interface ISearchConfig extends EObject {
  /**
   * Returns the value of the '<em><b>Search Types</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Search Types</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchConfig_SearchTypes()
   * @model containment="true"
   *        extendedMetaData="name='searchType' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<ISearchTypeConfig> getSearchTypes();

  /**
   * Returns the value of the '<em><b>Image Infos</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.saat.model.objectsearch.IImageInfo}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Image Infos</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchConfig_ImageInfos()
   * @model containment="true"
   *        extendedMetaData="name='imageInfo' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<IImageInfo> getImageInfos();

} // ISearchConfig
