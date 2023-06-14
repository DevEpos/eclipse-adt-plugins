/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage
 * @generated
 */
public interface ICallhierarchyFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  ICallhierarchyFactory eINSTANCE = com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyFactory
      .init();

  /**
   * Returns a new object of class '<em>Hierarchy Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Hierarchy Result</em>'.
   * @generated
   */
  IHierarchyResult createHierarchyResult();

  /**
   * Returns a new object of class '<em>Call Position</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Call Position</em>'.
   * @generated
   */
  ICallPosition createCallPosition();

  /**
   * Returns a new object of class '<em>Method Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Method Properties</em>'.
   * @generated
   */
  IMethodProperties createMethodProperties();

  /**
   * Returns a new object of class '<em>Hierarchy Result Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Hierarchy Result Entry</em>'.
   * @generated
   */
  IHierarchyResultEntry createHierarchyResultEntry();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the package supported by this factory.
   * @generated
   */
  ICallhierarchyPackage getCallhierarchyPackage();

} // ICallhierarchyFactory
