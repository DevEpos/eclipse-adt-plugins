/**
 */
package com.devepos.adt.base.model.adtbase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.IResponseMessage#getType <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IResponseMessage#getContent <em>Content</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IResponseMessage#getOccurrences
 * <em>Occurrences</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getResponseMessage()
 * @model extendedMetaData="kind='elementOnly' name='responseMessage'"
 * @generated
 */
public interface IResponseMessage extends EObject {

  Throwable getExeption();

  void setException(Throwable exception);

  /**
   * Returns the value of the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Content</em>' attribute.
   * @see #setContent(String)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getResponseMessage_Content()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='content' namespace='##targetNamespace'"
   * @generated
   */
  String getContent();

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IResponseMessage#getContent
   * <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Content</em>' attribute.
   * @see #getContent()
   * @generated
   */
  void setContent(String value);

  /**
   * Returns the value of the '<em><b>Occurrences</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Occurrences</em>' attribute.
   * @see #setOccurrences(int)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getResponseMessage_Occurrences()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='occurrences' namespace='##targetNamespace'"
   * @generated
   */
  int getOccurrences();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.base.model.adtbase.IResponseMessage#getOccurrences
   * <em>Occurrences</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Occurrences</em>' attribute.
   * @see #getOccurrences()
   * @generated
   */
  void setOccurrences(int value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Converts message type to status type
   * <!-- end-model-doc -->
   *
   * @model kind="operation" dataType="org.eclipse.emf.ecore.xml.type.Int"
   * @generated
   */
  int getStatusType();

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.devepos.adt.base.model.adtbase.MessageType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Type</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.MessageType
   * @see #setType(MessageType)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getResponseMessage_Type()
   * @model extendedMetaData="kind='attribute' name='type' namespace='##targetNamespace'"
   * @generated
   */
  MessageType getType();

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IResponseMessage#getType
   * <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.MessageType
   * @see #getType()
   * @generated
   */
  void setType(MessageType value);

} // IResponseMessage
