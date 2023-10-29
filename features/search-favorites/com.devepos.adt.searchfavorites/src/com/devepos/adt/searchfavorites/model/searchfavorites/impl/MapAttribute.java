/**
 */
package com.devepos.adt.searchfavorites.model.searchfavorites.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.searchfavorites.model.searchfavorites.IMapAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.searchfavorites.model.searchfavorites.impl.MapAttribute#getEntries
 * <em>Entries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MapAttribute extends BaseAttribute implements IMapAttribute {
  /**
   * The cached value of the '{@link #getEntries() <em>Entries</em>}' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntries()
   * @generated
   * @ordered
   */
  protected EMap<String, String> entries;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected MapAttribute() {
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
    return ISearchFavoritesPackage.Literals.MAP_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EMap<String, String> getEntries() {
    if (entries == null) {
      entries = new EcoreEMap<>(
          ISearchFavoritesPackage.Literals.STRING_TO_STRING_MAP_ENTRY, StringToStringMapEntry.class,
          this, ISearchFavoritesPackage.MAP_ATTRIBUTE__ENTRIES);
    }
    return entries;
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
    case ISearchFavoritesPackage.MAP_ATTRIBUTE__ENTRIES:
      return ((InternalEList<?>) getEntries()).basicRemove(otherEnd, msgs);
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
    case ISearchFavoritesPackage.MAP_ATTRIBUTE__ENTRIES:
      if (coreType) {
        return getEntries();
      }
      return getEntries().map();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case ISearchFavoritesPackage.MAP_ATTRIBUTE__ENTRIES:
      ((EStructuralFeature.Setting) getEntries()).set(newValue);
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
    case ISearchFavoritesPackage.MAP_ATTRIBUTE__ENTRIES:
      getEntries().clear();
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
    case ISearchFavoritesPackage.MAP_ATTRIBUTE__ENTRIES:
      return entries != null && !entries.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // MapAttribute
