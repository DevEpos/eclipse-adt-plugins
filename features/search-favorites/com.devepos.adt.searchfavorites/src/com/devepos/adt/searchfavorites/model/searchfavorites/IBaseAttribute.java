/**
 */
package com.devepos.adt.searchfavorites.model.searchfavorites;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute#getName
 * <em>Name</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage#getBaseAttribute()
 * @model abstract="true"
 * @generated
 */
public interface IBaseAttribute extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage#getBaseAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute#getName
   * <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // IBaseAttribute
