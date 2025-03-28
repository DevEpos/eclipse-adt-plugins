/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.saat.model.objectsearch.IImageInfo;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.ISearchConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchConfig#getSearchTypes <em>Search
 * Types</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchConfig#getImageInfos <em>Image
 * Infos</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchConfig extends MinimalEObjectImpl.Container implements ISearchConfig {
  /**
   * The cached value of the '{@link #getSearchTypes() <em>Search Types</em>}' containment reference
   * list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSearchTypes()
   * @generated
   * @ordered
   */
  protected EList<ISearchTypeConfig> searchTypes;

  /**
   * The cached value of the '{@link #getImageInfos() <em>Image Infos</em>}' containment reference
   * list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getImageInfos()
   * @generated
   * @ordered
   */
  protected EList<IImageInfo> imageInfos;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected SearchConfig() {
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
    return IObjectSearchPackage.Literals.SEARCH_CONFIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<ISearchTypeConfig> getSearchTypes() {
    if (searchTypes == null) {
      searchTypes = new EObjectContainmentEList<>(ISearchTypeConfig.class, this,
          IObjectSearchPackage.SEARCH_CONFIG__SEARCH_TYPES);
    }
    return searchTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<IImageInfo> getImageInfos() {
    if (imageInfos == null) {
      imageInfos = new EObjectContainmentEList<>(IImageInfo.class, this,
          IObjectSearchPackage.SEARCH_CONFIG__IMAGE_INFOS);
    }
    return imageInfos;
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
    case IObjectSearchPackage.SEARCH_CONFIG__SEARCH_TYPES:
      return ((InternalEList<?>) getSearchTypes()).basicRemove(otherEnd, msgs);
    case IObjectSearchPackage.SEARCH_CONFIG__IMAGE_INFOS:
      return ((InternalEList<?>) getImageInfos()).basicRemove(otherEnd, msgs);
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
    case IObjectSearchPackage.SEARCH_CONFIG__SEARCH_TYPES:
      return getSearchTypes();
    case IObjectSearchPackage.SEARCH_CONFIG__IMAGE_INFOS:
      return getImageInfos();
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
    case IObjectSearchPackage.SEARCH_CONFIG__SEARCH_TYPES:
      getSearchTypes().clear();
      getSearchTypes().addAll((Collection<? extends ISearchTypeConfig>) newValue);
      return;
    case IObjectSearchPackage.SEARCH_CONFIG__IMAGE_INFOS:
      getImageInfos().clear();
      getImageInfos().addAll((Collection<? extends IImageInfo>) newValue);
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
    case IObjectSearchPackage.SEARCH_CONFIG__SEARCH_TYPES:
      getSearchTypes().clear();
      return;
    case IObjectSearchPackage.SEARCH_CONFIG__IMAGE_INFOS:
      getImageInfos().clear();
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
    case IObjectSearchPackage.SEARCH_CONFIG__SEARCH_TYPES:
      return searchTypes != null && !searchTypes.isEmpty();
    case IObjectSearchPackage.SEARCH_CONFIG__IMAGE_INFOS:
      return imageInfos != null && !imageInfos.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // SearchConfig
