/**
 */
package com.devepos.adt.base.model.adtbase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>User</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * User
 *
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.IUser#getName <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IUser#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getUser()
 * @model extendedMetaData="name='user' kind='elementOnly'"
 * @generated
 */
public interface IUser extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The name of
   * the user <!-- end-model-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getUser_Name()
   * @model extendedMetaData="kind='attribute' name='name'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The full
   * name / description of the user <!-- end-model-doc -->
   *
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getUser_Text()
   * @model extendedMetaData="kind='attribute' name='text'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IUser#getName <em>Name</em>}'
   * attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Sets the value of the '{@link com.devepos.adt.base.model.adtbase.IUser#getText <em>Text</em>}'
   * attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

} // IUser
