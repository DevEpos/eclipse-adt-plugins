/**
 */
package com.devepos.adt.searchfavorites.model.searchfavorites;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.searchfavorites.model.searchfavorites.IListAttribute#getValues
 * <em>Values</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage#getListAttribute()
 * @model
 * @generated
 */
public interface IListAttribute extends IBaseAttribute {
  /**
   * Returns the value of the '<em><b>Values</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Values</em>' attribute list.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage#getListAttribute_Values()
   * @model extendedMetaData="name='value' kind='element'"
   * @generated
   */
  EList<String> getValues();

} // IListAttribute
