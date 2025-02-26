/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITagExportRequest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag Export Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagExportRequest#getTagIds <em>Tag
 * Ids</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagExportRequest#isIncludeSharedTagsInfo
 * <em>Include Shared Tags Info</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TagExportRequest extends MinimalEObjectImpl.Container implements ITagExportRequest {
  /**
   * The cached value of the '{@link #getTagIds() <em>Tag Ids</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTagIds()
   * @generated
   * @ordered
   */
  protected EList<String> tagIds;

  /**
   * The default value of the '{@link #isIncludeSharedTagsInfo() <em>Include Shared Tags Info</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isIncludeSharedTagsInfo()
   * @generated
   * @ordered
   */
  protected static final boolean INCLUDE_SHARED_TAGS_INFO_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIncludeSharedTagsInfo() <em>Include Shared Tags Info</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isIncludeSharedTagsInfo()
   * @generated
   * @ordered
   */
  protected boolean includeSharedTagsInfo = INCLUDE_SHARED_TAGS_INFO_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TagExportRequest() {
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
    return IAbapTagsPackage.Literals.TAG_EXPORT_REQUEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<String> getTagIds() {
    if (tagIds == null) {
      tagIds = new EDataTypeUniqueEList<>(String.class, this,
          IAbapTagsPackage.TAG_EXPORT_REQUEST__TAG_IDS);
    }
    return tagIds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isIncludeSharedTagsInfo() {
    return includeSharedTagsInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setIncludeSharedTagsInfo(final boolean newIncludeSharedTagsInfo) {
    boolean oldIncludeSharedTagsInfo = includeSharedTagsInfo;
    includeSharedTagsInfo = newIncludeSharedTagsInfo;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAG_EXPORT_REQUEST__INCLUDE_SHARED_TAGS_INFO, oldIncludeSharedTagsInfo,
          includeSharedTagsInfo));
    }
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
    case IAbapTagsPackage.TAG_EXPORT_REQUEST__TAG_IDS:
      return getTagIds();
    case IAbapTagsPackage.TAG_EXPORT_REQUEST__INCLUDE_SHARED_TAGS_INFO:
      return isIncludeSharedTagsInfo();
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
    case IAbapTagsPackage.TAG_EXPORT_REQUEST__TAG_IDS:
      getTagIds().clear();
      getTagIds().addAll((Collection<? extends String>) newValue);
      return;
    case IAbapTagsPackage.TAG_EXPORT_REQUEST__INCLUDE_SHARED_TAGS_INFO:
      setIncludeSharedTagsInfo((Boolean) newValue);
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
    case IAbapTagsPackage.TAG_EXPORT_REQUEST__TAG_IDS:
      getTagIds().clear();
      return;
    case IAbapTagsPackage.TAG_EXPORT_REQUEST__INCLUDE_SHARED_TAGS_INFO:
      setIncludeSharedTagsInfo(INCLUDE_SHARED_TAGS_INFO_EDEFAULT);
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
    case IAbapTagsPackage.TAG_EXPORT_REQUEST__TAG_IDS:
      return tagIds != null && !tagIds.isEmpty();
    case IAbapTagsPackage.TAG_EXPORT_REQUEST__INCLUDE_SHARED_TAGS_INFO:
      return includeSharedTagsInfo != INCLUDE_SHARED_TAGS_INFO_EDEFAULT;
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
    result.append(" (tagIds: ");
    result.append(tagIds);
    result.append(", includeSharedTagsInfo: ");
    result.append(includeSharedTagsInfo);
    result.append(')');
    return result.toString();
  }

} // TagExportRequest
