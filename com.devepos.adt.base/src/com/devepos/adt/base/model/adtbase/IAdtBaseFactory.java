/**
 */
package com.devepos.adt.base.model.adtbase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage
 * @generated
 */
public interface IAdtBaseFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  IAdtBaseFactory eINSTANCE = com.devepos.adt.base.model.adtbase.impl.AdtBaseFactory.init();

  /**
   * Returns a new object of class '<em>Adt Obj Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Adt Obj Ref</em>'.
   * @generated
   */
  IAdtObjRef createAdtObjRef();

  /**
   * Returns a new object of class '<em>Adt Obj Ref List</em>'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Adt Obj Ref List</em>'.
   * @generated
   */
  IAdtObjRefList createAdtObjRefList();

  /**
   * Returns a new object of class '<em>User</em>'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return a new object of class '<em>User</em>'.
   * @generated
   */
  IUser createUser();

  /**
   * Returns a new object of class '<em>Adt Plugin Feature</em>'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Adt Plugin Feature</em>'.
   * @generated
   */
  IAdtPluginFeature createAdtPluginFeature();

  /**
   * Returns a new object of class '<em>Adt Plugin Feature List</em>'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Adt Plugin Feature List</em>'.
   * @generated
   */
  IAdtPluginFeatureList createAdtPluginFeatureList();

  /**
   * Returns a new object of class '<em>Response Message</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Response Message</em>'.
   * @generated
   */
  IResponseMessage createResponseMessage();

  /**
   * Returns a new object of class '<em>Response Message List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Response Message List</em>'.
   * @generated
   */
  IResponseMessageList createResponseMessageList();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return the package supported by this factory.
   * @generated
   */
  IAdtBasePackage getAdtBasePackage();

} // IAdtBaseFactory
