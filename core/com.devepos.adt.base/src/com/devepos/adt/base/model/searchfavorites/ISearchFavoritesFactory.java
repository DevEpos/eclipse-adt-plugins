/**
 */
package com.devepos.adt.base.model.searchfavorites;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage
 * @generated
 */
public interface ISearchFavoritesFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  ISearchFavoritesFactory eINSTANCE = com.devepos.adt.base.model.searchfavorites.impl.SearchFavoritesFactoryImpl
      .init();

  /**
   * Returns a new object of class '<em>Boolean Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Boolean Attribute</em>'.
   * @generated
   */
  IBooleanAttribute createBooleanAttribute();

  /**
   * Returns a new object of class '<em>Int Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Int Attribute</em>'.
   * @generated
   */
  IIntAttribute createIntAttribute();

  /**
   * Returns a new object of class '<em>List Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>List Attribute</em>'.
   * @generated
   */
  IListAttribute createListAttribute();

  /**
   * Returns a new object of class '<em>Long String Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Long String Attribute</em>'.
   * @generated
   */
  ILongStringAttribute createLongStringAttribute();

  /**
   * Returns a new object of class '<em>Map Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Map Attribute</em>'.
   * @generated
   */
  IMapAttribute createMapAttribute();

  /**
   * Returns a new object of class '<em>Search Favorite</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Favorite</em>'.
   * @generated
   */
  ISearchFavorite createSearchFavorite();

  /**
   * Returns a new object of class '<em>Search Favorites</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Favorites</em>'.
   * @generated
   */
  ISearchFavorites createSearchFavorites();

  /**
   * Returns a new object of class '<em>String Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>String Attribute</em>'.
   * @generated
   */
  IStringAttribute createStringAttribute();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the package supported by this factory.
   * @generated
   */
  ISearchFavoritesPackage getSearchFavoritesPackage();

} // ISearchFavoritesFactory
