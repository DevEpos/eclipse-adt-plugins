/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isFinal
 * <em>Final</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isAbstract
 * <em>Abstract</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isRedefined
 * <em>Redefined</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isHandler
 * <em>Handler</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isConstructor
 * <em>Constructor</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isStatic
 * <em>Static</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#getVisibility
 * <em>Visibility</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isTestMethod
 * <em>Test Method</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getMethodProperties()
 * @model extendedMetaData="kind='elementOnly' name='methodProperties'"
 * @generated
 */
public interface IMethodProperties extends EObject {
  /**
   * Returns the value of the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Final</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getMethodProperties_Final()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='isFinal' namespace='##targetNamespace'"
   * @generated
   */
  boolean isFinal();

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getMethodProperties_Abstract()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='isAbstract' namespace='##targetNamespace'"
   * @generated
   */
  boolean isAbstract();

  /**
   * Returns the value of the '<em><b>Redefined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Redefined</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getMethodProperties_Redefined()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='isRedefined' namespace='##targetNamespace'"
   * @generated
   */
  boolean isRedefined();

  /**
   * Returns the value of the '<em><b>Handler</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Handler</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getMethodProperties_Handler()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='isHandler' namespace='##targetNamespace'"
   * @generated
   */
  boolean isHandler();

  /**
   * Returns the value of the '<em><b>Constructor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Constructor</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getMethodProperties_Constructor()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='isConstructor' namespace='##targetNamespace'"
   * @generated
   */
  boolean isConstructor();

  /**
   * Returns the value of the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Static</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getMethodProperties_Static()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='isStatic' namespace='##targetNamespace'"
   * @generated
   */
  boolean isStatic();

  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The literals are from the enumeration
   * {@link com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getMethodProperties_Visibility()
   * @model suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='visibility' namespace='##targetNamespace'"
   * @generated
   */
  MethodVisibility getVisibility();

  /**
   * Returns the value of the '<em><b>Test Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Test Method</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getMethodProperties_TestMethod()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='isTestMethod' namespace='##targetNamespace'"
   * @generated
   */
  boolean isTestMethod();

} // IMethodProperties
