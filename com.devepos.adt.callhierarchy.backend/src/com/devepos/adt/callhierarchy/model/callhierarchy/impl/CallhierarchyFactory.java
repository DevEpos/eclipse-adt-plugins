/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition;
import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyFactory;
import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;
import com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties;
import com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CallhierarchyFactory extends EFactoryImpl implements ICallhierarchyFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static ICallhierarchyFactory init() {
    try {
      ICallhierarchyFactory theCallhierarchyFactory = (ICallhierarchyFactory) EPackage.Registry.INSTANCE
          .getEFactory(ICallhierarchyPackage.eNS_URI);
      if (theCallhierarchyFactory != null) {
        return theCallhierarchyFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CallhierarchyFactory();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public CallhierarchyFactory() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EObject create(final EClass eClass) {
    switch (eClass.getClassifierID()) {
    case ICallhierarchyPackage.HIERARCHY_RESULT:
      return createHierarchyResult();
    case ICallhierarchyPackage.CALL_POSITION:
      return createCallPosition();
    case ICallhierarchyPackage.METHOD_PROPERTIES:
      return createMethodProperties();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY:
      return createHierarchyResultEntry();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object createFromString(final EDataType eDataType, final String initialValue) {
    switch (eDataType.getClassifierID()) {
    case ICallhierarchyPackage.METHOD_VISIBILITY:
      return createMethodVisibilityFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String convertToString(final EDataType eDataType, final Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    case ICallhierarchyPackage.METHOD_VISIBILITY:
      return convertMethodVisibilityToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IHierarchyResult createHierarchyResult() {
    HierarchyResult hierarchyResult = new HierarchyResult();
    return hierarchyResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ICallPosition createCallPosition() {
    CallPosition callPosition = new CallPosition();
    return callPosition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IMethodProperties createMethodProperties() {
    MethodProperties methodProperties = new MethodProperties();
    return methodProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IHierarchyResultEntry createHierarchyResultEntry() {
    HierarchyResultEntry hierarchyResultEntry = new HierarchyResultEntry();
    return hierarchyResultEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public MethodVisibility createMethodVisibilityFromString(final EDataType eDataType,
      final String initialValue) {
    MethodVisibility result = MethodVisibility.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertMethodVisibilityToString(final EDataType eDataType,
      final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ICallhierarchyPackage getCallhierarchyPackage() {
    return (ICallhierarchyPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ICallhierarchyPackage getPackage() {
    return ICallhierarchyPackage.eINSTANCE;
  }

} // CallhierarchyFactory
