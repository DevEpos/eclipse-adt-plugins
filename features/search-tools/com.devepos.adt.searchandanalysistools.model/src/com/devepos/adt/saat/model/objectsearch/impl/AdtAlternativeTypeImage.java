/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.saat.model.objectsearch.IAdtAlternativeTypeImage;
import com.devepos.adt.saat.model.objectsearch.IImageInfo;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adt Alternative Type Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.AdtAlternativeTypeImage#getType
 * <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.AdtAlternativeTypeImage#getImgInfo
 * <em>Img Info</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdtAlternativeTypeImage extends MinimalEObjectImpl.Container
    implements IAdtAlternativeTypeImage {
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getImgInfo() <em>Img Info</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getImgInfo()
   * @generated
   * @ordered
   */
  protected IImageInfo imgInfo;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected AdtAlternativeTypeImage() {
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
    return IObjectSearchPackage.Literals.ADT_ALTERNATIVE_TYPE_IMAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setType(final String newType) {
    String oldType = type;
    type = newType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__TYPE, oldType, type));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IImageInfo getImgInfo() {
    if (imgInfo != null && imgInfo.eIsProxy()) {
      InternalEObject oldImgInfo = (InternalEObject) imgInfo;
      imgInfo = (IImageInfo) eResolveProxy(oldImgInfo);
      if (imgInfo != oldImgInfo && eNotificationRequired()) {
        eNotify(new ENotificationImpl(this, Notification.RESOLVE,
            IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__IMG_INFO, oldImgInfo, imgInfo));
      }
    }
    return imgInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public IImageInfo basicGetImgInfo() {
    return imgInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setImgInfo(final IImageInfo newImgInfo) {
    IImageInfo oldImgInfo = imgInfo;
    imgInfo = newImgInfo;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__IMG_INFO, oldImgInfo, imgInfo));
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
    case IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__TYPE:
      return getType();
    case IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__IMG_INFO:
      if (resolve) {
        return getImgInfo();
      }
      return basicGetImgInfo();
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
    case IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__TYPE:
      setType((String) newValue);
      return;
    case IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__IMG_INFO:
      setImgInfo((IImageInfo) newValue);
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
    case IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__TYPE:
      setType(TYPE_EDEFAULT);
      return;
    case IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__IMG_INFO:
      setImgInfo((IImageInfo) null);
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
    case IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__TYPE:
      return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
    case IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE__IMG_INFO:
      return imgInfo != null;
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
    result.append(" (type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} // AdtAlternativeTypeImage
