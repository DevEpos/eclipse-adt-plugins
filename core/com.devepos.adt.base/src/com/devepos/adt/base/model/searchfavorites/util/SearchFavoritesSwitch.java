/**
 */
package com.devepos.adt.base.model.searchfavorites.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.devepos.adt.base.model.searchfavorites.IBaseAttribute;
import com.devepos.adt.base.model.searchfavorites.IBooleanAttribute;
import com.devepos.adt.base.model.searchfavorites.IIntAttribute;
import com.devepos.adt.base.model.searchfavorites.IListAttribute;
import com.devepos.adt.base.model.searchfavorites.ILongStringAttribute;
import com.devepos.adt.base.model.searchfavorites.IMapAttribute;
import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.base.model.searchfavorites.ISearchFavorites;
import com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage;
import com.devepos.adt.base.model.searchfavorites.IStringAttribute;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.base.model.searchfavorites.ISearchFavoritesPackage
 * @generated
 */
public class SearchFavoritesSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected static ISearchFavoritesPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public SearchFavoritesSwitch() {
    if (modelPackage == null) {
      modelPackage = ISearchFavoritesPackage.eINSTANCE;
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Base Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Base Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBaseAttribute(final IBaseAttribute object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanAttribute(final IBooleanAttribute object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntAttribute(final IIntAttribute object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListAttribute(final IListAttribute object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Long String
   * Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Long String
   *         Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLongStringAttribute(final ILongStringAttribute object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Map Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Map Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMapAttribute(final IMapAttribute object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Favorite</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Favorite</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchFavorite(final ISearchFavorite object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Favorites</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Favorites</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchFavorites(final ISearchFavorites object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringAttribute(final IStringAttribute object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String To String Map
   * Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String To String Map
   *         Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringToStringMapEntry(final Map.Entry<String, String> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(final EObject object) {
    return null;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it
   * yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(final int classifierID, final EObject theEObject) {
    switch (classifierID) {
    case ISearchFavoritesPackage.BASE_ATTRIBUTE: {
      IBaseAttribute baseAttribute = (IBaseAttribute) theEObject;
      T result = caseBaseAttribute(baseAttribute);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ISearchFavoritesPackage.LONG_STRING_ATTRIBUTE: {
      ILongStringAttribute longStringAttribute = (ILongStringAttribute) theEObject;
      T result = caseLongStringAttribute(longStringAttribute);
      if (result == null) {
        result = caseBaseAttribute(longStringAttribute);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ISearchFavoritesPackage.LIST_ATTRIBUTE: {
      IListAttribute listAttribute = (IListAttribute) theEObject;
      T result = caseListAttribute(listAttribute);
      if (result == null) {
        result = caseBaseAttribute(listAttribute);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ISearchFavoritesPackage.STRING_ATTRIBUTE: {
      IStringAttribute stringAttribute = (IStringAttribute) theEObject;
      T result = caseStringAttribute(stringAttribute);
      if (result == null) {
        result = caseBaseAttribute(stringAttribute);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ISearchFavoritesPackage.INT_ATTRIBUTE: {
      IIntAttribute intAttribute = (IIntAttribute) theEObject;
      T result = caseIntAttribute(intAttribute);
      if (result == null) {
        result = caseBaseAttribute(intAttribute);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ISearchFavoritesPackage.BOOLEAN_ATTRIBUTE: {
      IBooleanAttribute booleanAttribute = (IBooleanAttribute) theEObject;
      T result = caseBooleanAttribute(booleanAttribute);
      if (result == null) {
        result = caseBaseAttribute(booleanAttribute);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ISearchFavoritesPackage.MAP_ATTRIBUTE: {
      IMapAttribute mapAttribute = (IMapAttribute) theEObject;
      T result = caseMapAttribute(mapAttribute);
      if (result == null) {
        result = caseBaseAttribute(mapAttribute);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ISearchFavoritesPackage.STRING_TO_STRING_MAP_ENTRY: {
      @SuppressWarnings("unchecked")
      Map.Entry<String, String> stringToStringMapEntry = (Map.Entry<String, String>) theEObject;
      T result = caseStringToStringMapEntry(stringToStringMapEntry);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ISearchFavoritesPackage.SEARCH_FAVORITE: {
      ISearchFavorite searchFavorite = (ISearchFavorite) theEObject;
      T result = caseSearchFavorite(searchFavorite);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ISearchFavoritesPackage.SEARCH_FAVORITES: {
      ISearchFavorites searchFavorites = (ISearchFavorites) theEObject;
      T result = caseSearchFavorites(searchFavorites);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(final EPackage ePackage) {
    return ePackage == modelPackage;
  }

} // SearchFavoritesSwitch
