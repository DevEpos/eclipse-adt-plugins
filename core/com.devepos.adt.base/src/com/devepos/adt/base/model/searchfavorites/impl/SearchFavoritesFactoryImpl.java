/**
 */
package com.devepos.adt.base.model.searchfavorites.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.devepos.adt.base.model.searchfavorites.IBooleanAttribute;
import com.devepos.adt.base.model.searchfavorites.IIntAttribute;
import com.devepos.adt.base.model.searchfavorites.IListAttribute;
import com.devepos.adt.base.model.searchfavorites.ILongStringAttribute;
import com.devepos.adt.base.model.searchfavorites.IMapAttribute;
import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.base.model.searchfavorites.ISearchFavorites;
import com.devepos.adt.base.model.searchfavorites.ISearchFavoritesFactory;
import com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage;
import com.devepos.adt.base.model.searchfavorites.IStringAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SearchFavoritesFactoryImpl extends EFactoryImpl implements ISearchFavoritesFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static ISearchFavoritesFactory init() {
    try {
      ISearchFavoritesFactory theSearchFavoritesFactory = (ISearchFavoritesFactory) EPackage.Registry.INSTANCE
          .getEFactory(ISearchFavoritesPackage.eNS_URI);
      if (theSearchFavoritesFactory != null) {
        return theSearchFavoritesFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SearchFavoritesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public SearchFavoritesFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EObject create(final EClass eClass) {
    switch (eClass.getClassifierID()) {
    case ISearchFavoritesPackage.LONG_STRING_ATTRIBUTE:
      return createLongStringAttribute();
    case ISearchFavoritesPackage.LIST_ATTRIBUTE:
      return createListAttribute();
    case ISearchFavoritesPackage.STRING_ATTRIBUTE:
      return createStringAttribute();
    case ISearchFavoritesPackage.INT_ATTRIBUTE:
      return createIntAttribute();
    case ISearchFavoritesPackage.BOOLEAN_ATTRIBUTE:
      return createBooleanAttribute();
    case ISearchFavoritesPackage.MAP_ATTRIBUTE:
      return createMapAttribute();
    case ISearchFavoritesPackage.STRING_TO_STRING_MAP_ENTRY:
      return (EObject) createStringToStringMapEntry();
    case ISearchFavoritesPackage.SEARCH_FAVORITE:
      return createSearchFavorite();
    case ISearchFavoritesPackage.SEARCH_FAVORITES:
      return createSearchFavorites();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ILongStringAttribute createLongStringAttribute() {
    LongStringAttributeImpl longStringAttribute = new LongStringAttributeImpl();
    return longStringAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IListAttribute createListAttribute() {
    ListAttributeImpl listAttribute = new ListAttributeImpl();
    return listAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IStringAttribute createStringAttribute() {
    StringAttributeImpl stringAttribute = new StringAttributeImpl();
    return stringAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IIntAttribute createIntAttribute() {
    IntAttributeImpl intAttribute = new IntAttributeImpl();
    return intAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IBooleanAttribute createBooleanAttribute() {
    BooleanAttributeImpl booleanAttribute = new BooleanAttributeImpl();
    return booleanAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IMapAttribute createMapAttribute() {
    MapAttributeImpl mapAttribute = new MapAttributeImpl();
    return mapAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public Map.Entry<String, String> createStringToStringMapEntry() {
    StringToStringMapEntryImpl stringToStringMapEntry = new StringToStringMapEntryImpl();
    return stringToStringMapEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchFavorite createSearchFavorite() {
    SearchFavoriteImpl searchFavorite = new SearchFavoriteImpl();
    return searchFavorite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchFavorites createSearchFavorites() {
    SearchFavoritesImpl searchFavorites = new SearchFavoritesImpl();
    return searchFavorites;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchFavoritesPackage getSearchFavoritesPackage() {
    return (ISearchFavoritesPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ISearchFavoritesPackage getPackage() {
    return ISearchFavoritesPackage.eINSTANCE;
  }

} // SearchFavoritesFactoryImpl
