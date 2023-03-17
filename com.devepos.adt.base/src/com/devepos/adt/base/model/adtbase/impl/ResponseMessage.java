/**
 */
package com.devepos.adt.base.model.adtbase.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IResponseMessage;
import com.devepos.adt.base.model.adtbase.MessageType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Response Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.ResponseMessage#getType <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.ResponseMessage#getContent
 * <em>Content</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.ResponseMessage#getOccurrences
 * <em>Occurrences</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResponseMessage extends MinimalEObjectImpl.Container implements IResponseMessage {
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final MessageType TYPE_EDEFAULT = MessageType.NONE;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected MessageType type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected static final String CONTENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected String content = CONTENT_EDEFAULT;

  /**
   * The default value of the '{@link #getOccurrences() <em>Occurrences</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOccurrences()
   * @generated
   * @ordered
   */
  protected static final int OCCURRENCES_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getOccurrences() <em>Occurrences</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOccurrences()
   * @generated
   * @ordered
   */
  protected int occurrences = OCCURRENCES_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected ResponseMessage() {
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
    return IAdtBasePackage.Literals.RESPONSE_MESSAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public MessageType getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setType(final MessageType newType) {
    MessageType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.RESPONSE_MESSAGE__TYPE,
          oldType, type));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getContent() {
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setContent(final String newContent) {
    String oldContent = content;
    content = newContent;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.RESPONSE_MESSAGE__CONTENT, oldContent, content));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getOccurrences() {
    return occurrences;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setOccurrences(final int newOccurrences) {
    int oldOccurrences = occurrences;
    occurrences = newOccurrences;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.RESPONSE_MESSAGE__OCCURRENCES, oldOccurrences, occurrences));
    }
  }

  @Override
  public int getStatusType() {
    switch (type) {
    case INFO:
      return IStatus.INFO;
    case WARNING:
      return IStatus.WARNING;
    case ERROR:
      return IStatus.ERROR;
    default:
      return IStatus.ERROR;
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
    case IAdtBasePackage.RESPONSE_MESSAGE__TYPE:
      return getType();
    case IAdtBasePackage.RESPONSE_MESSAGE__CONTENT:
      return getContent();
    case IAdtBasePackage.RESPONSE_MESSAGE__OCCURRENCES:
      return getOccurrences();
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
    case IAdtBasePackage.RESPONSE_MESSAGE__TYPE:
      setType((MessageType) newValue);
      return;
    case IAdtBasePackage.RESPONSE_MESSAGE__CONTENT:
      setContent((String) newValue);
      return;
    case IAdtBasePackage.RESPONSE_MESSAGE__OCCURRENCES:
      setOccurrences((Integer) newValue);
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
    case IAdtBasePackage.RESPONSE_MESSAGE__TYPE:
      setType(TYPE_EDEFAULT);
      return;
    case IAdtBasePackage.RESPONSE_MESSAGE__CONTENT:
      setContent(CONTENT_EDEFAULT);
      return;
    case IAdtBasePackage.RESPONSE_MESSAGE__OCCURRENCES:
      setOccurrences(OCCURRENCES_EDEFAULT);
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
    case IAdtBasePackage.RESPONSE_MESSAGE__TYPE:
      return type != TYPE_EDEFAULT;
    case IAdtBasePackage.RESPONSE_MESSAGE__CONTENT:
      return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
    case IAdtBasePackage.RESPONSE_MESSAGE__OCCURRENCES:
      return occurrences != OCCURRENCES_EDEFAULT;
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
  public Object eInvoke(final int operationID, final EList<?> arguments)
      throws InvocationTargetException {
    switch (operationID) {
    case IAdtBasePackage.RESPONSE_MESSAGE___GET_STATUS_TYPE:
      return getStatusType();
    }
    return super.eInvoke(operationID, arguments);
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
    result.append(", content: ");
    result.append(content);
    result.append(", occurrences: ");
    result.append(occurrences);
    result.append(')');
    return result.toString();
  }

} // ResponseMessage
