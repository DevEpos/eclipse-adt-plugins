/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.saat.model.objectsearch.IContentAssist;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content Assist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.ContentAssist#getEntryImgKey <em>Entry
 * Img Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ContentAssist extends MinimalEObjectImpl.Container implements IContentAssist {
  /**
   * The default value of the '{@link #getEntryImgKey() <em>Entry Img Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntryImgKey()
   * @generated
   * @ordered
   */
  protected static final String ENTRY_IMG_KEY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEntryImgKey() <em>Entry Img Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntryImgKey()
   * @generated
   * @ordered
   */
  protected String entryImgKey = ENTRY_IMG_KEY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected ContentAssist() {
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
    return IObjectSearchPackage.Literals.CONTENT_ASSIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getEntryImgKey() {
    return entryImgKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setEntryImgKey(final String newEntryImgKey) {
    String oldEntryImgKey = entryImgKey;
    entryImgKey = newEntryImgKey;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.CONTENT_ASSIST__ENTRY_IMG_KEY, oldEntryImgKey, entryImgKey));
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
    case IObjectSearchPackage.CONTENT_ASSIST__ENTRY_IMG_KEY:
      return getEntryImgKey();
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
    case IObjectSearchPackage.CONTENT_ASSIST__ENTRY_IMG_KEY:
      setEntryImgKey((String) newValue);
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
    case IObjectSearchPackage.CONTENT_ASSIST__ENTRY_IMG_KEY:
      setEntryImgKey(ENTRY_IMG_KEY_EDEFAULT);
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
    case IObjectSearchPackage.CONTENT_ASSIST__ENTRY_IMG_KEY:
      return ENTRY_IMG_KEY_EDEFAULT == null ? entryImgKey != null
          : !ENTRY_IMG_KEY_EDEFAULT.equals(entryImgKey);
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
    result.append(" (entryImgKey: ");
    result.append(entryImgKey);
    result.append(')');
    return result.toString();
  }

} // ContentAssist