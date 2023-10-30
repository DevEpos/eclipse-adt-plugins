/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.saat.model.objectsearch.IAdtAlternativeTypeImage;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Result Output Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchResultOutputConfig#isListOutputSupported
 * <em>List Output Supported</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchResultOutputConfig#getGroupingLevels
 * <em>Grouping Levels</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchResultOutputConfig#getTypesForList
 * <em>Types For List</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchResultOutputConfig#getAdtAltTypeImages
 * <em>Adt Alt Type Images</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchResultOutputConfig extends MinimalEObjectImpl.Container
    implements ISearchResultOutputConfig {
  /**
   * The default value of the '{@link #isListOutputSupported() <em>List Output Supported</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isListOutputSupported()
   * @generated
   * @ordered
   */
  protected static final boolean LIST_OUTPUT_SUPPORTED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isListOutputSupported() <em>List Output Supported</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isListOutputSupported()
   * @generated
   * @ordered
   */
  protected boolean listOutputSupported = LIST_OUTPUT_SUPPORTED_EDEFAULT;

  /**
   * The cached value of the '{@link #getGroupingLevels() <em>Grouping Levels</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getGroupingLevels()
   * @generated
   * @ordered
   */
  protected EList<String> groupingLevels;

  /**
   * The cached value of the '{@link #getTypesForList() <em>Types For List</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTypesForList()
   * @generated
   * @ordered
   */
  protected EList<String> typesForList;

  /**
   * The cached value of the '{@link #getAdtAltTypeImages() <em>Adt Alt Type Images</em>}'
   * containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAdtAltTypeImages()
   * @generated
   * @ordered
   */
  protected EList<IAdtAlternativeTypeImage> adtAltTypeImages;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected SearchResultOutputConfig() {
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
    return IObjectSearchPackage.Literals.SEARCH_RESULT_OUTPUT_CONFIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isListOutputSupported() {
    return listOutputSupported;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setListOutputSupported(final boolean newListOutputSupported) {
    boolean oldListOutputSupported = listOutputSupported;
    listOutputSupported = newListOutputSupported;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__LIST_OUTPUT_SUPPORTED,
          oldListOutputSupported, listOutputSupported));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<String> getGroupingLevels() {
    if (groupingLevels == null) {
      groupingLevels = new EDataTypeUniqueEList<>(String.class, this,
          IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__GROUPING_LEVELS);
    }
    return groupingLevels;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<String> getTypesForList() {
    if (typesForList == null) {
      typesForList = new EDataTypeUniqueEList<>(String.class, this,
          IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__TYPES_FOR_LIST);
    }
    return typesForList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<IAdtAlternativeTypeImage> getAdtAltTypeImages() {
    if (adtAltTypeImages == null) {
      adtAltTypeImages = new EObjectContainmentEList<>(IAdtAlternativeTypeImage.class, this,
          IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__ADT_ALT_TYPE_IMAGES);
    }
    return adtAltTypeImages;
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
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__ADT_ALT_TYPE_IMAGES:
      return ((InternalEList<?>) getAdtAltTypeImages()).basicRemove(otherEnd, msgs);
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
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__LIST_OUTPUT_SUPPORTED:
      return isListOutputSupported();
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__GROUPING_LEVELS:
      return getGroupingLevels();
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__TYPES_FOR_LIST:
      return getTypesForList();
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__ADT_ALT_TYPE_IMAGES:
      return getAdtAltTypeImages();
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
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__LIST_OUTPUT_SUPPORTED:
      setListOutputSupported((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__GROUPING_LEVELS:
      getGroupingLevels().clear();
      getGroupingLevels().addAll((Collection<? extends String>) newValue);
      return;
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__TYPES_FOR_LIST:
      getTypesForList().clear();
      getTypesForList().addAll((Collection<? extends String>) newValue);
      return;
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__ADT_ALT_TYPE_IMAGES:
      getAdtAltTypeImages().clear();
      getAdtAltTypeImages().addAll((Collection<? extends IAdtAlternativeTypeImage>) newValue);
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
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__LIST_OUTPUT_SUPPORTED:
      setListOutputSupported(LIST_OUTPUT_SUPPORTED_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__GROUPING_LEVELS:
      getGroupingLevels().clear();
      return;
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__TYPES_FOR_LIST:
      getTypesForList().clear();
      return;
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__ADT_ALT_TYPE_IMAGES:
      getAdtAltTypeImages().clear();
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
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__LIST_OUTPUT_SUPPORTED:
      return listOutputSupported != LIST_OUTPUT_SUPPORTED_EDEFAULT;
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__GROUPING_LEVELS:
      return groupingLevels != null && !groupingLevels.isEmpty();
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__TYPES_FOR_LIST:
      return typesForList != null && !typesForList.isEmpty();
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG__ADT_ALT_TYPE_IMAGES:
      return adtAltTypeImages != null && !adtAltTypeImages.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (listOutputSupported: ");
    result.append(listOutputSupported);
    result.append(", groupingLevels: ");
    result.append(groupingLevels);
    result.append(", typesForList: ");
    result.append(typesForList);
    result.append(')');
    return result.toString();
  }

} // SearchResultOutputConfig
