/**
 */
package com.devepos.adt.base.model.adtbase.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.base.internal.messages.Messages;
import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IResponseMessage;
import com.devepos.adt.base.model.adtbase.IResponseMessageList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Response Message List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.ResponseMessageList#getMessages
 * <em>Messages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResponseMessageList extends MinimalEObjectImpl.Container
    implements IResponseMessageList {
  /**
   * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getMessages()
   * @generated
   * @ordered
   */
  protected EList<IResponseMessage> messages;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected ResponseMessageList() {
    super();
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
    case IAdtBasePackage.RESPONSE_MESSAGE_LIST__MESSAGES:
      return getMessages();
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
  public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
      final NotificationChain msgs) {
    switch (featureID) {
    case IAdtBasePackage.RESPONSE_MESSAGE_LIST__MESSAGES:
      return ((InternalEList<?>) getMessages()).basicRemove(otherEnd, msgs);
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
  public Object eInvoke(final int operationID, final EList<?> arguments)
      throws InvocationTargetException {
    switch (operationID) {
    case IAdtBasePackage.RESPONSE_MESSAGE_LIST___TO_STATUS__STRING_STRING:
      return toStatus((String) arguments.get(0), (String) arguments.get(1));
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
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case IAdtBasePackage.RESPONSE_MESSAGE_LIST__MESSAGES:
      return messages != null && !messages.isEmpty();
    }
    return super.eIsSet(featureID);
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
    case IAdtBasePackage.RESPONSE_MESSAGE_LIST__MESSAGES:
      getMessages().clear();
      getMessages().addAll((Collection<? extends IResponseMessage>) newValue);
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
    case IAdtBasePackage.RESPONSE_MESSAGE_LIST__MESSAGES:
      getMessages().clear();
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
  public EList<IResponseMessage> getMessages() {
    if (messages == null) {
      messages = new EObjectContainmentEList<>(IResponseMessage.class, this,
          IAdtBasePackage.RESPONSE_MESSAGE_LIST__MESSAGES);
    }
    return messages;
  }

  @Override
  public IStatus toStatus(final String pluginId, final String message) {
    if (messages == null || messages.size() <= 0) {
      return null;
    }
    return new MultiStatus(pluginId, 0, messages.stream().map(m -> {
      String occurrenceIndicator = "";
      if (m.getOccurrences() > 1) {
        occurrenceIndicator = String.format(Messages.ResponseMessageList_MessageMultiplierText_xmsg,
            m.getOccurrences());
      }
      return new Status(m.getStatusType(), pluginId, m.getContent() + occurrenceIndicator);
    }).toArray(IStatus[]::new), message, null);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IAdtBasePackage.Literals.RESPONSE_MESSAGE_LIST;
  }

} // ResponseMessageList
