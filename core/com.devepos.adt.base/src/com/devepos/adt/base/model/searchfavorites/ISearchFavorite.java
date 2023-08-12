/**
 */
package com.devepos.adt.base.model.searchfavorites;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Favorite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.ISearchFavorite#getSearchType <em>Search
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.ISearchFavorite#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.ISearchFavorite#getDestinationId
 * <em>Destination Id</em>}</li>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.ISearchFavorite#isProjectIndependent
 * <em>Project Independent</em>}</li>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.ISearchFavorite#getAttributes
 * <em>Attributes</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage#getSearchFavorite()
 * @model
 * @generated
 */
public interface ISearchFavorite extends EObject {
  /**
   * Returns the value of the '<em><b>Search Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Search Type</em>' attribute.
   * @see #setSearchType(String)
   * @see com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage#getSearchFavorite_SearchType()
   * @model
   * @generated
   */
  String getSearchType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.base.model.searchfavorites.ISearchFavorite#getSearchType <em>Search
   * Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Search Type</em>' attribute.
   * @see #getSearchType()
   * @generated
   */
  void setSearchType(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage#getSearchFavorite_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.base.model.searchfavorites.ISearchFavorite#getDescription
   * <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Destination Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Destination Id</em>' attribute.
   * @see #setDestinationId(String)
   * @see com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage#getSearchFavorite_DestinationId()
   * @model
   * @generated
   */
  String getDestinationId();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.base.model.searchfavorites.ISearchFavorite#getDestinationId
   * <em>Destination Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Destination Id</em>' attribute.
   * @see #getDestinationId()
   * @generated
   */
  void setDestinationId(String value);

  /**
   * Returns the value of the '<em><b>Project Independent</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Project Independent</em>' attribute.
   * @see #setProjectIndependent(boolean)
   * @see com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage#getSearchFavorite_ProjectIndependent()
   * @model
   * @generated
   */
  boolean isProjectIndependent();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.base.model.searchfavorites.ISearchFavorite#isProjectIndependent
   * <em>Project Independent</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Project Independent</em>' attribute.
   * @see #isProjectIndependent()
   * @generated
   */
  void setProjectIndependent(boolean value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.base.model.searchfavorites.IBaseAttribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage#getSearchFavorite_Attributes()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='attribute'"
   * @generated
   */
  EList<IBaseAttribute> getAttributes();

  /**
   * Retrieves value of a boolean attribute or specified default value
   *
   * @param name         name of an attribute
   * @param defaultValue the default value
   * @return the found value or the default value
   */
  boolean getAttribute(String name, boolean defaultValue);

  /**
   * Retrieves value of a string attribute or the specified default value
   *
   * @param name         name of an attribute
   * @param defaultValue the default value
   * @return the found value of the default value
   */
  String getAttribute(String name, String defaultValue);

  /**
   * Retrieves value of an integer attribute or the specified default value
   *
   * @param name         name of an attribute
   * @param defaultValue the default value
   * @return the found value of the default value
   */
  int getAttribute(String name, int defaultValue);

  /**
   * Retrieves value of an integer attribute or the specified default value
   *
   * @param name name of an attribute
   * @return the found value or an empty map
   */
  Map<String, String> getMapAttribute(String name);

  /**
   * Retrieves value of a list attribute or the specified default value
   *
   * @param name name of an attribute
   * @return the found value or an empty list
   */
  List<String> getListAttribute(String name);

} // ISearchFavorite
