/**
 */
package com.devepos.adt.searchfavorites.model.searchfavorites;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesFactory
 * @model kind="package"
 * @generated
 */
public interface ISearchFavoritesPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNAME = "searchfavorites";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_URI = "http://www.devepos.com/adt/searchfavorites";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_PREFIX = "searchfavorites";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  ISearchFavoritesPackage eINSTANCE = com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage
      .init();

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.BaseAttribute <em>Base
   * Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.BaseAttribute
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getBaseAttribute()
   * @generated
   */
  int BASE_ATTRIBUTE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int BASE_ATTRIBUTE__NAME = 0;

  /**
   * The number of structural features of the '<em>Base Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int BASE_ATTRIBUTE_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Base Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int BASE_ATTRIBUTE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.LongStringAttribute <em>Long
   * String Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.LongStringAttribute
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getLongStringAttribute()
   * @generated
   */
  int LONG_STRING_ATTRIBUTE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int LONG_STRING_ATTRIBUTE__NAME = BASE_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int LONG_STRING_ATTRIBUTE__VALUE = BASE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Long String Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int LONG_STRING_ATTRIBUTE_FEATURE_COUNT = BASE_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Long String Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int LONG_STRING_ATTRIBUTE_OPERATION_COUNT = BASE_ATTRIBUTE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.ListAttribute <em>List
   * Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.ListAttribute
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getListAttribute()
   * @generated
   */
  int LIST_ATTRIBUTE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int LIST_ATTRIBUTE__NAME = BASE_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int LIST_ATTRIBUTE__VALUES = BASE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>List Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int LIST_ATTRIBUTE_FEATURE_COUNT = BASE_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>List Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int LIST_ATTRIBUTE_OPERATION_COUNT = BASE_ATTRIBUTE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.StringAttribute <em>String
   * Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.StringAttribute
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getStringAttribute()
   * @generated
   */
  int STRING_ATTRIBUTE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE__NAME = BASE_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE__VALUE = BASE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_FEATURE_COUNT = BASE_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>String Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_OPERATION_COUNT = BASE_ATTRIBUTE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.IntAttribute <em>Int
   * Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.IntAttribute
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getIntAttribute()
   * @generated
   */
  int INT_ATTRIBUTE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int INT_ATTRIBUTE__NAME = BASE_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int INT_ATTRIBUTE__VALUE = BASE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int INT_ATTRIBUTE_FEATURE_COUNT = BASE_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Int Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int INT_ATTRIBUTE_OPERATION_COUNT = BASE_ATTRIBUTE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.BooleanAttribute <em>Boolean
   * Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.BooleanAttribute
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getBooleanAttribute()
   * @generated
   */
  int BOOLEAN_ATTRIBUTE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE__NAME = BASE_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE__VALUE = BASE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_FEATURE_COUNT = BASE_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Boolean Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_OPERATION_COUNT = BASE_ATTRIBUTE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.MapAttribute <em>Map
   * Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.MapAttribute
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getMapAttribute()
   * @generated
   */
  int MAP_ATTRIBUTE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int MAP_ATTRIBUTE__NAME = BASE_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Entries</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int MAP_ATTRIBUTE__ENTRIES = BASE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Map Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int MAP_ATTRIBUTE_FEATURE_COUNT = BASE_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Map Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int MAP_ATTRIBUTE_OPERATION_COUNT = BASE_ATTRIBUTE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.StringToStringMapEntry
   * <em>String To String Map Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.StringToStringMapEntry
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getStringToStringMapEntry()
   * @generated
   */
  int STRING_TO_STRING_MAP_ENTRY = 7;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_TO_STRING_MAP_ENTRY__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_TO_STRING_MAP_ENTRY__VALUE = 1;

  /**
   * The number of structural features of the '<em>String To String Map Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_TO_STRING_MAP_ENTRY_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>String To String Map Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_TO_STRING_MAP_ENTRY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavorite <em>Search
   * Favorite</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavorite
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getSearchFavorite()
   * @generated
   */
  int SEARCH_FAVORITE = 8;

  /**
   * The feature id for the '<em><b>Search Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FAVORITE__SEARCH_TYPE = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FAVORITE__DESCRIPTION = 1;

  /**
   * The feature id for the '<em><b>Destination Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FAVORITE__DESTINATION_ID = 2;

  /**
   * The feature id for the '<em><b>Project Independent</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FAVORITE__PROJECT_INDEPENDENT = 3;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FAVORITE__ATTRIBUTES = 4;

  /**
   * The number of structural features of the '<em>Search Favorite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FAVORITE_FEATURE_COUNT = 5;

  /**
   * The number of operations of the '<em>Search Favorite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FAVORITE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavorites <em>Search
   * Favorites</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavorites
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getSearchFavorites()
   * @generated
   */
  int SEARCH_FAVORITES = 9;

  /**
   * The feature id for the '<em><b>Favorites</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FAVORITES__FAVORITES = 0;

  /**
   * The number of structural features of the '<em>Search Favorites</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FAVORITES_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Search Favorites</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FAVORITES_OPERATION_COUNT = 0;

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute <em>Base
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Base Attribute</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute
   * @generated
   */
  EClass getBaseAttribute();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute#getName
   * <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute#getName()
   * @see #getBaseAttribute()
   * @generated
   */
  EAttribute getBaseAttribute_Name();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ILongStringAttribute <em>Long
   * String Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Long String Attribute</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ILongStringAttribute
   * @generated
   */
  EClass getLongStringAttribute();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ILongStringAttribute#getValue
   * <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ILongStringAttribute#getValue()
   * @see #getLongStringAttribute()
   * @generated
   */
  EAttribute getLongStringAttribute_Value();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IListAttribute <em>List
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>List Attribute</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IListAttribute
   * @generated
   */
  EClass getListAttribute();

  /**
   * Returns the meta object for the attribute list
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IListAttribute#getValues
   * <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IListAttribute#getValues()
   * @see #getListAttribute()
   * @generated
   */
  EAttribute getListAttribute_Values();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IStringAttribute <em>String
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>String Attribute</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IStringAttribute
   * @generated
   */
  EClass getStringAttribute();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IStringAttribute#getValue
   * <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IStringAttribute#getValue()
   * @see #getStringAttribute()
   * @generated
   */
  EAttribute getStringAttribute_Value();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IIntAttribute <em>Int
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Int Attribute</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IIntAttribute
   * @generated
   */
  EClass getIntAttribute();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IIntAttribute#getValue
   * <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IIntAttribute#getValue()
   * @see #getIntAttribute()
   * @generated
   */
  EAttribute getIntAttribute_Value();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IBooleanAttribute <em>Boolean
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Boolean Attribute</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IBooleanAttribute
   * @generated
   */
  EClass getBooleanAttribute();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IBooleanAttribute#isValue
   * <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IBooleanAttribute#isValue()
   * @see #getBooleanAttribute()
   * @generated
   */
  EAttribute getBooleanAttribute_Value();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IMapAttribute <em>Map
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Map Attribute</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IMapAttribute
   * @generated
   */
  EClass getMapAttribute();

  /**
   * Returns the meta object for the map
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IMapAttribute#getEntries
   * <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the map '<em>Entries</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IMapAttribute#getEntries()
   * @see #getMapAttribute()
   * @generated
   */
  EReference getMapAttribute_Entries();

  /**
   * Returns the meta object for class '{@link java.util.Map.Entry <em>String To String Map
   * Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>String To String Map Entry</em>'.
   * @see java.util.Map.Entry
   * @model keyDataType="org.eclipse.emf.ecore.EString"
   *        valueDataType="org.eclipse.emf.ecore.EString"
   * @generated
   */
  EClass getStringToStringMapEntry();

  /**
   * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see java.util.Map.Entry
   * @see #getStringToStringMapEntry()
   * @generated
   */
  EAttribute getStringToStringMapEntry_Key();

  /**
   * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see java.util.Map.Entry
   * @see #getStringToStringMapEntry()
   * @generated
   */
  EAttribute getStringToStringMapEntry_Value();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite <em>Search
   * Favorite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Favorite</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite
   * @generated
   */
  EClass getSearchFavorite();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite#getSearchType
   * <em>Search Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Search Type</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite#getSearchType()
   * @see #getSearchFavorite()
   * @generated
   */
  EAttribute getSearchFavorite_SearchType();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite#getDescription
   * <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite#getDescription()
   * @see #getSearchFavorite()
   * @generated
   */
  EAttribute getSearchFavorite_Description();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite#getDestinationId
   * <em>Destination Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Destination Id</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite#getDestinationId()
   * @see #getSearchFavorite()
   * @generated
   */
  EAttribute getSearchFavorite_DestinationId();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite#isProjectIndependent
   * <em>Project Independent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Project Independent</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite#isProjectIndependent()
   * @see #getSearchFavorite()
   * @generated
   */
  EAttribute getSearchFavorite_ProjectIndependent();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite#getAttributes
   * <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite#getAttributes()
   * @see #getSearchFavorite()
   * @generated
   */
  EReference getSearchFavorite_Attributes();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites <em>Search
   * Favorites</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Favorites</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites
   * @generated
   */
  EClass getSearchFavorites();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites#getFavorites
   * <em>Favorites</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Favorites</em>'.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites#getFavorites()
   * @see #getSearchFavorites()
   * @generated
   */
  EReference getSearchFavorites_Favorites();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ISearchFavoritesFactory getSearchFavoritesFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each operation of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   *
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.BaseAttribute <em>Base
     * Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.BaseAttribute
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getBaseAttribute()
     * @generated
     */
    EClass BASE_ATTRIBUTE = eINSTANCE.getBaseAttribute();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute BASE_ATTRIBUTE__NAME = eINSTANCE.getBaseAttribute_Name();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.LongStringAttribute
     * <em>Long String Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.LongStringAttribute
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getLongStringAttribute()
     * @generated
     */
    EClass LONG_STRING_ATTRIBUTE = eINSTANCE.getLongStringAttribute();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute LONG_STRING_ATTRIBUTE__VALUE = eINSTANCE.getLongStringAttribute_Value();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.ListAttribute <em>List
     * Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.ListAttribute
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getListAttribute()
     * @generated
     */
    EClass LIST_ATTRIBUTE = eINSTANCE.getListAttribute();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute LIST_ATTRIBUTE__VALUES = eINSTANCE.getListAttribute_Values();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.StringAttribute <em>String
     * Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.StringAttribute
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getStringAttribute()
     * @generated
     */
    EClass STRING_ATTRIBUTE = eINSTANCE.getStringAttribute();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute STRING_ATTRIBUTE__VALUE = eINSTANCE.getStringAttribute_Value();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.IntAttribute <em>Int
     * Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.IntAttribute
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getIntAttribute()
     * @generated
     */
    EClass INT_ATTRIBUTE = eINSTANCE.getIntAttribute();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute INT_ATTRIBUTE__VALUE = eINSTANCE.getIntAttribute_Value();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.BooleanAttribute
     * <em>Boolean Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.BooleanAttribute
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getBooleanAttribute()
     * @generated
     */
    EClass BOOLEAN_ATTRIBUTE = eINSTANCE.getBooleanAttribute();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute BOOLEAN_ATTRIBUTE__VALUE = eINSTANCE.getBooleanAttribute_Value();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.MapAttribute <em>Map
     * Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.MapAttribute
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getMapAttribute()
     * @generated
     */
    EClass MAP_ATTRIBUTE = eINSTANCE.getMapAttribute();

    /**
     * The meta object literal for the '<em><b>Entries</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference MAP_ATTRIBUTE__ENTRIES = eINSTANCE.getMapAttribute_Entries();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.StringToStringMapEntry
     * <em>String To String Map Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.StringToStringMapEntry
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getStringToStringMapEntry()
     * @generated
     */
    EClass STRING_TO_STRING_MAP_ENTRY = eINSTANCE.getStringToStringMapEntry();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute STRING_TO_STRING_MAP_ENTRY__KEY = eINSTANCE.getStringToStringMapEntry_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute STRING_TO_STRING_MAP_ENTRY__VALUE = eINSTANCE.getStringToStringMapEntry_Value();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavorite <em>Search
     * Favorite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavorite
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getSearchFavorite()
     * @generated
     */
    EClass SEARCH_FAVORITE = eINSTANCE.getSearchFavorite();

    /**
     * The meta object literal for the '<em><b>Search Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FAVORITE__SEARCH_TYPE = eINSTANCE.getSearchFavorite_SearchType();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FAVORITE__DESCRIPTION = eINSTANCE.getSearchFavorite_Description();

    /**
     * The meta object literal for the '<em><b>Destination Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FAVORITE__DESTINATION_ID = eINSTANCE.getSearchFavorite_DestinationId();

    /**
     * The meta object literal for the '<em><b>Project Independent</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FAVORITE__PROJECT_INDEPENDENT = eINSTANCE
        .getSearchFavorite_ProjectIndependent();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_FAVORITE__ATTRIBUTES = eINSTANCE.getSearchFavorite_Attributes();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavorites <em>Search
     * Favorites</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavorites
     * @see com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavoritesPackage#getSearchFavorites()
     * @generated
     */
    EClass SEARCH_FAVORITES = eINSTANCE.getSearchFavorites();

    /**
     * The meta object literal for the '<em><b>Favorites</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_FAVORITES__FAVORITES = eINSTANCE.getSearchFavorites_Favorites();

  }

} // ISearchFavoritesPackage
