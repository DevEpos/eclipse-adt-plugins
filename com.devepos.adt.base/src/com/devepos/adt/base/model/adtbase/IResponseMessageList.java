/**
 */
package com.devepos.adt.base.model.adtbase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response Message List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.IResponseMessageList#getMessages
 * <em>Messages</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getResponseMessageList()
 * @model extendedMetaData="kind='elementOnly' name='responseMessages'"
 * @generated
 */
public interface IResponseMessageList extends EObject {
  /**
   * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.base.model.adtbase.IResponseMessage}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Messages</em>' containment reference list.
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getResponseMessageList_Messages()
   * @model containment="true" suppressedSetVisibility="true"
   *        extendedMetaData="kind='element' name='responseMessage' namespace='##targetNamespace'"
   * @generated
   */
  EList<IResponseMessage> getMessages();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Converts message type to status
   *
   * @param pluginId Plugin Id for the status
   * @param message  Message for the status
   *                 <!-- end-model-doc -->
   * @model dataType="com.devepos.adt.base.model.adtbase.IStatus"
   *        pluginIdDataType="org.eclipse.emf.ecore.xml.type.String"
   *        messageDataType="org.eclipse.emf.ecore.xml.type.String"
   * @generated
   */
  IStatus toStatus(String pluginId, String message);

} // IResponseMessageList
