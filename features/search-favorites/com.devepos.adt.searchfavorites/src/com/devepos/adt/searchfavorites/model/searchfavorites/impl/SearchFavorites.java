/**
 */
package com.devepos.adt.searchfavorites.model.searchfavorites.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Favorites</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.SearchFavorites#getFavorites
 * <em>Favorites</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchFavorites extends MinimalEObjectImpl.Container implements ISearchFavorites {
  /**
   * The cached value of the '{@link #getFavorites() <em>Favorites</em>}' containment reference
   * list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getFavorites()
   * @generated
   * @ordered
   */
  protected EList<ISearchFavorite> favorites;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected SearchFavorites() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ISearchFavoritesPackage.Literals.SEARCH_FAVORITES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<ISearchFavorite> getFavorites() {
    if (favorites == null) {
      favorites = new EObjectContainmentEList<>(ISearchFavorite.class, this,
          ISearchFavoritesPackage.SEARCH_FAVORITES__FAVORITES);
    }
    return favorites;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
      final NotificationChain msgs) {
    switch (featureID) {
    case ISearchFavoritesPackage.SEARCH_FAVORITES__FAVORITES:
      return ((InternalEList<?>) getFavorites()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case ISearchFavoritesPackage.SEARCH_FAVORITES__FAVORITES:
      return getFavorites();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case ISearchFavoritesPackage.SEARCH_FAVORITES__FAVORITES:
      getFavorites().clear();
      getFavorites().addAll((Collection<? extends ISearchFavorite>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(final int featureID) {
    switch (featureID) {
    case ISearchFavoritesPackage.SEARCH_FAVORITES__FAVORITES:
      getFavorites().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case ISearchFavoritesPackage.SEARCH_FAVORITES__FAVORITES:
      return favorites != null && !favorites.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // SearchFavorites
