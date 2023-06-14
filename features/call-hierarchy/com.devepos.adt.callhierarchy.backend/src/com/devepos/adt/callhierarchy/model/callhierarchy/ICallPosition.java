/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition#getUri
 * <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition#getLine
 * <em>Line</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition#getColumn
 * <em>Column</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getCallPosition()
 * @model extendedMetaData="kind='elementOnly' name='callPosition'"
 * @generated
 */
public interface ICallPosition extends EObject {
  /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Uri</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getCallPosition_Uri()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='uri' namespace='##targetNamespace'"
   * @generated
   */
  String getUri();

  /**
   * Returns the value of the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Line</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getCallPosition_Line()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Int" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='line' namespace='##targetNamespace'"
   * @generated
   */
  int getLine();

  /**
   * Returns the value of the '<em><b>Column</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Column</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getCallPosition_Column()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Int" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='column' namespace='##targetNamespace'"
   * @generated
   */
  int getColumn();

} // ICallPosition
