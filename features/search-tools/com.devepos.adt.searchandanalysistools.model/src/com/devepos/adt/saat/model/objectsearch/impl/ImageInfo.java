/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.saat.model.objectsearch.IImageInfo;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.ImageRegistryId;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.ImageInfo#getImageId <em>Image
 * Id</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.ImageInfo#getImageEncoded <em>Image
 * Encoded</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.ImageInfo#getImageRegistryId <em>Image
 * Registry Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImageInfo extends MinimalEObjectImpl.Container implements IImageInfo {
  /**
   * The default value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getImageId()
   * @generated
   * @ordered
   */
  protected static final String IMAGE_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getImageId()
   * @generated
   * @ordered
   */
  protected String imageId = IMAGE_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getImageEncoded() <em>Image Encoded</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getImageEncoded()
   * @generated
   * @ordered
   */
  protected static final String IMAGE_ENCODED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImageEncoded() <em>Image Encoded</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getImageEncoded()
   * @generated
   * @ordered
   */
  protected String imageEncoded = IMAGE_ENCODED_EDEFAULT;

  /**
   * The default value of the '{@link #getImageRegistryId() <em>Image Registry Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getImageRegistryId()
   * @generated
   * @ordered
   */
  protected static final ImageRegistryId IMAGE_REGISTRY_ID_EDEFAULT = ImageRegistryId.CALLING_PLUGIN;

  /**
   * The cached value of the '{@link #getImageRegistryId() <em>Image Registry Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getImageRegistryId()
   * @generated
   * @ordered
   */
  protected ImageRegistryId imageRegistryId = IMAGE_REGISTRY_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected ImageInfo() {
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
    return IObjectSearchPackage.Literals.IMAGE_INFO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getImageId() {
    return imageId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setImageId(final String newImageId) {
    String oldImageId = imageId;
    imageId = newImageId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.IMAGE_INFO__IMAGE_ID, oldImageId, imageId));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getImageEncoded() {
    return imageEncoded;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setImageEncoded(final String newImageEncoded) {
    String oldImageEncoded = imageEncoded;
    imageEncoded = newImageEncoded;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.IMAGE_INFO__IMAGE_ENCODED, oldImageEncoded, imageEncoded));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ImageRegistryId getImageRegistryId() {
    return imageRegistryId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setImageRegistryId(final ImageRegistryId newImageRegistryId) {
    ImageRegistryId oldImageRegistryId = imageRegistryId;
    imageRegistryId = newImageRegistryId == null ? IMAGE_REGISTRY_ID_EDEFAULT : newImageRegistryId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.IMAGE_INFO__IMAGE_REGISTRY_ID, oldImageRegistryId, imageRegistryId));
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
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_ID:
      return getImageId();
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_ENCODED:
      return getImageEncoded();
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_REGISTRY_ID:
      return getImageRegistryId();
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
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_ID:
      setImageId((String) newValue);
      return;
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_ENCODED:
      setImageEncoded((String) newValue);
      return;
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_REGISTRY_ID:
      setImageRegistryId((ImageRegistryId) newValue);
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
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_ID:
      setImageId(IMAGE_ID_EDEFAULT);
      return;
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_ENCODED:
      setImageEncoded(IMAGE_ENCODED_EDEFAULT);
      return;
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_REGISTRY_ID:
      setImageRegistryId(IMAGE_REGISTRY_ID_EDEFAULT);
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
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_ID:
      return IMAGE_ID_EDEFAULT == null ? imageId != null : !IMAGE_ID_EDEFAULT.equals(imageId);
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_ENCODED:
      return IMAGE_ENCODED_EDEFAULT == null ? imageEncoded != null
          : !IMAGE_ENCODED_EDEFAULT.equals(imageEncoded);
    case IObjectSearchPackage.IMAGE_INFO__IMAGE_REGISTRY_ID:
      return imageRegistryId != IMAGE_REGISTRY_ID_EDEFAULT;
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
    result.append(" (imageId: ");
    result.append(imageId);
    result.append(", imageEncoded: ");
    result.append(imageEncoded);
    result.append(", imageRegistryId: ");
    result.append(imageRegistryId);
    result.append(')');
    return result.toString();
  }

} // ImageInfo
