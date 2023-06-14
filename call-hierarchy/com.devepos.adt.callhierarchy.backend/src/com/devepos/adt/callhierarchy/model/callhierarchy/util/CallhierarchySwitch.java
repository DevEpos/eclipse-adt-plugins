/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition;
import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;
import com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage
 * @generated
 */
public class CallhierarchySwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected static ICallhierarchyPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public CallhierarchySwitch() {
    if (modelPackage == null) {
      modelPackage = ICallhierarchyPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(final EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it
   * yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(final int classifierID, final EObject theEObject) {
    switch (classifierID) {
    case ICallhierarchyPackage.HIERARCHY_RESULT: {
      IHierarchyResult hierarchyResult = (IHierarchyResult) theEObject;
      T result = caseHierarchyResult(hierarchyResult);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICallhierarchyPackage.CALL_POSITION: {
      ICallPosition callPosition = (ICallPosition) theEObject;
      T result = caseCallPosition(callPosition);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICallhierarchyPackage.METHOD_PROPERTIES: {
      IMethodProperties methodProperties = (IMethodProperties) theEObject;
      T result = caseMethodProperties(methodProperties);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY: {
      IHierarchyResultEntry hierarchyResultEntry = (IHierarchyResultEntry) theEObject;
      T result = caseHierarchyResultEntry(hierarchyResultEntry);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hierarchy Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hierarchy Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHierarchyResult(final IHierarchyResult object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Call Position</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Call Position</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCallPosition(final ICallPosition object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Method Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Method Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMethodProperties(final IMethodProperties object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hierarchy Result
   * Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hierarchy Result
   *         Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHierarchyResultEntry(final IHierarchyResultEntry object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(final EObject object) {
    return null;
  }

} // CallhierarchySwitch
