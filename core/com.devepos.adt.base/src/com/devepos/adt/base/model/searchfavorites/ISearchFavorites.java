/**
 */
package com.devepos.adt.base.model.searchfavorites;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Favorites</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.searchfavorites.ISearchFavorites#getFavorites
 * <em>Favorites</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage#getSearchFavorites()
 * @model
 * @generated
 */
public interface ISearchFavorites extends EObject {
  /**
   * Returns the value of the '<em><b>Favorites</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.base.model.searchfavorites.ISearchFavorite}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Favorites</em>' containment reference list.
   * @see com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage#getSearchFavorites_Favorites()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='favorite'"
   * @generated
   */
  EList<ISearchFavorite> getFavorites();

} // ISearchFavorites
