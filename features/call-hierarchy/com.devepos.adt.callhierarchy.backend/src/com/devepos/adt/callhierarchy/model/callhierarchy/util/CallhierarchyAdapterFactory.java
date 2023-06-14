/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition;
import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;
import com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage
 * @generated
 */
public class CallhierarchyAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected static ICallhierarchyPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public CallhierarchyAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = ICallhierarchyPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is
   * an instance object of the model.
   * <!-- end-user-doc -->
   *
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(final Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected CallhierarchySwitch<Adapter> modelSwitch = new CallhierarchySwitch<>() {
    @Override
    public Adapter caseHierarchyResult(final IHierarchyResult object) {
      return createHierarchyResultAdapter();
    }

    @Override
    public Adapter caseCallPosition(final ICallPosition object) {
      return createCallPositionAdapter();
    }

    @Override
    public Adapter caseMethodProperties(final IMethodProperties object) {
      return createMethodPropertiesAdapter();
    }

    @Override
    public Adapter caseHierarchyResultEntry(final IHierarchyResultEntry object) {
      return createHierarchyResultEntryAdapter();
    }

    @Override
    public Adapter defaultCase(final EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(final Notifier target) {
    return modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult <em>Hierarchy
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult
   * @generated
   */
  public Adapter createHierarchyResultAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition <em>Call
   * Position</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition
   * @generated
   */
  public Adapter createCallPositionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties <em>Method
   * Properties</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties
   * @generated
   */
  public Adapter createMethodPropertiesAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry <em>Hierarchy
   * Result Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry
   * @generated
   */
  public Adapter createHierarchyResultEntryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // CallhierarchyAdapterFactory
