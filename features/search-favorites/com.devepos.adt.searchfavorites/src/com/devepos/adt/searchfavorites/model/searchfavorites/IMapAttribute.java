/**
 */
package com.devepos.adt.searchfavorites.model.searchfavorites;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.searchfavorites.model.searchfavorites.IMapAttribute#getEntries
 * <em>Entries</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage#getMapAttribute()
 * @model
 * @generated
 */
public interface IMapAttribute extends IBaseAttribute {
  /**
   * Returns the value of the '<em><b>Entries</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type {@link java.lang.String},
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entries</em>' map.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage#getMapAttribute_Entries()
   * @model mapType="com.devepos.adt.searchfavorites.model.searchfavorites.StringToStringMapEntry&lt;org.eclipse.emf.ecore.EString,
   *        org.eclipse.emf.ecore.EString&gt;"
   *        extendedMetaData="kind='element' name='entry'"
   * @generated
   */
  EMap<String, String> getEntries();

} // IMapAttribute
