/**
 */
package com.devepos.adt.base.model.adtbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IUser;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>User</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.User#getName <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.User#getText <em>Text</em>}</li>
 * </ul>
 *
 * @generated
 */
public class User extends MinimalEObjectImpl.Container implements IUser {
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getText() <em>Text</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getText()
   * @generated
   * @ordered
   */
  protected static final String TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getText() <em>Text</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getText()
   * @generated
   * @ordered
   */
  protected String text = TEXT_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected User() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IAdtBasePackage.Literals.USER;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setName(final String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.USER__NAME, oldName,
          name));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getText() {
    return text;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setText(final String newText) {
    String oldText = text;
    text = newText;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.USER__TEXT, oldText,
          text));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case IAdtBasePackage.USER__NAME:
      return getName();
    case IAdtBasePackage.USER__TEXT:
      return getText();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IAdtBasePackage.USER__NAME:
      setName((String) newValue);
      return;
    case IAdtBasePackage.USER__TEXT:
      setText((String) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(final int featureID) {
    switch (featureID) {
    case IAdtBasePackage.USER__NAME:
      setName(NAME_EDEFAULT);
      return;
    case IAdtBasePackage.USER__TEXT:
      setText(TEXT_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case IAdtBasePackage.USER__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case IAdtBasePackage.USER__TEXT:
      return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", text: ");
    result.append(text);
    result.append(')');
    return result.toString();
  }

} // User
