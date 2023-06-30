/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.IRisContentAssist;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ris Content Assist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.RisContentAssist#getAdtObjectType <em>Adt
 * Object Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RisContentAssist extends ContentAssist implements IRisContentAssist {
  /**
   * The default value of the '{@link #getAdtObjectType() <em>Adt Object Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAdtObjectType()
   * @generated
   * @ordered
   */
  protected static final String ADT_OBJECT_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAdtObjectType() <em>Adt Object Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAdtObjectType()
   * @generated
   * @ordered
   */
  protected String adtObjectType = ADT_OBJECT_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected RisContentAssist() {
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
    return IObjectSearchPackage.Literals.RIS_CONTENT_ASSIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getAdtObjectType() {
    return adtObjectType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setAdtObjectType(final String newAdtObjectType) {
    String oldAdtObjectType = adtObjectType;
    adtObjectType = newAdtObjectType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.RIS_CONTENT_ASSIST__ADT_OBJECT_TYPE, oldAdtObjectType,
          adtObjectType));
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
    case IObjectSearchPackage.RIS_CONTENT_ASSIST__ADT_OBJECT_TYPE:
      return getAdtObjectType();
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
    case IObjectSearchPackage.RIS_CONTENT_ASSIST__ADT_OBJECT_TYPE:
      setAdtObjectType((String) newValue);
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
    case IObjectSearchPackage.RIS_CONTENT_ASSIST__ADT_OBJECT_TYPE:
      setAdtObjectType(ADT_OBJECT_TYPE_EDEFAULT);
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
    case IObjectSearchPackage.RIS_CONTENT_ASSIST__ADT_OBJECT_TYPE:
      return ADT_OBJECT_TYPE_EDEFAULT == null ? adtObjectType != null
          : !ADT_OBJECT_TYPE_EDEFAULT.equals(adtObjectType);
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
    result.append(" (adtObjectType: ");
    result.append(adtObjectType);
    result.append(')');
    return result.toString();
  }

} // RisContentAssist
