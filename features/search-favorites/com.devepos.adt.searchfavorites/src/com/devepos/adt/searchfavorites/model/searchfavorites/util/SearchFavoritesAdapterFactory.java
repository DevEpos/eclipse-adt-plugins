/**
 */
package com.devepos.adt.searchfavorites.model.searchfavorites.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IBooleanAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IIntAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IListAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.ILongStringAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IMapAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage;
import com.devepos.adt.searchfavorites.model.searchfavorites.IStringAttribute;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage
 * @generated
 */
public class SearchFavoritesAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected static ISearchFavoritesPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public SearchFavoritesAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = ISearchFavoritesPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is
   * an instance object of the model.
   * <!-- end-user-doc -->
   *
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(final Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected SearchFavoritesSwitch<Adapter> modelSwitch = new SearchFavoritesSwitch<>() {
    @Override
    public Adapter caseBaseAttribute(final IBaseAttribute object) {
      return createBaseAttributeAdapter();
    }

    @Override
    public Adapter caseLongStringAttribute(final ILongStringAttribute object) {
      return createLongStringAttributeAdapter();
    }

    @Override
    public Adapter caseListAttribute(final IListAttribute object) {
      return createListAttributeAdapter();
    }

    @Override
    public Adapter caseStringAttribute(final IStringAttribute object) {
      return createStringAttributeAdapter();
    }

    @Override
    public Adapter caseIntAttribute(final IIntAttribute object) {
      return createIntAttributeAdapter();
    }

    @Override
    public Adapter caseBooleanAttribute(final IBooleanAttribute object) {
      return createBooleanAttributeAdapter();
    }

    @Override
    public Adapter caseMapAttribute(final IMapAttribute object) {
      return createMapAttributeAdapter();
    }

    @Override
    public Adapter caseStringToStringMapEntry(final Map.Entry<String, String> object) {
      return createStringToStringMapEntryAdapter();
    }

    @Override
    public Adapter caseSearchFavorite(final ISearchFavorite object) {
      return createSearchFavoriteAdapter();
    }

    @Override
    public Adapter caseSearchFavorites(final ISearchFavorites object) {
      return createSearchFavoritesAdapter();
    }

    @Override
    public Adapter defaultCase(final EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(final Notifier target) {
    return modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute <em>Base
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute
   * @generated
   */
  public Adapter createBaseAttributeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ILongStringAttribute <em>Long
   * String Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ILongStringAttribute
   * @generated
   */
  public Adapter createLongStringAttributeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IListAttribute <em>List
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IListAttribute
   * @generated
   */
  public Adapter createListAttributeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IStringAttribute <em>String
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IStringAttribute
   * @generated
   */
  public Adapter createStringAttributeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IIntAttribute <em>Int
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IIntAttribute
   * @generated
   */
  public Adapter createIntAttributeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IBooleanAttribute <em>Boolean
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IBooleanAttribute
   * @generated
   */
  public Adapter createBooleanAttributeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.IMapAttribute <em>Map
   * Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.IMapAttribute
   * @generated
   */
  public Adapter createMapAttributeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To String
   * Map Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see java.util.Map.Entry
   * @generated
   */
  public Adapter createStringToStringMapEntryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite <em>Search
   * Favorite</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite
   * @generated
   */
  public Adapter createSearchFavoriteAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites <em>Search
   * Favorites</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites
   * @generated
   */
  public Adapter createSearchFavoritesAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // SearchFavoritesAdapterFactory
