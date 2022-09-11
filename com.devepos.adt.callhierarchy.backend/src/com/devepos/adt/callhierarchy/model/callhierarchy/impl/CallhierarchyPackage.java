/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition;
import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyFactory;
import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;
import com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties;
import com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CallhierarchyPackage extends EPackageImpl implements ICallhierarchyPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass hierarchyResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass callPositionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass methodPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass hierarchyResultEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum methodVisibilityEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>
   * Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CallhierarchyPackage() {
    super(eNS_URI, ICallhierarchyFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon
   * which it depends.
   *
   * <p>
   * This method is used to initialize {@link ICallhierarchyPackage#eINSTANCE} when that field is
   * accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain
   * the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ICallhierarchyPackage init() {
    if (isInited) {
      return (ICallhierarchyPackage) EPackage.Registry.INSTANCE.getEPackage(
          ICallhierarchyPackage.eNS_URI);
    }

    // Obtain or create and register package
    Object registeredCallhierarchyPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    CallhierarchyPackage theCallhierarchyPackage = registeredCallhierarchyPackage instanceof CallhierarchyPackage
        ? (CallhierarchyPackage) registeredCallhierarchyPackage
        : new CallhierarchyPackage();

    isInited = true;

    // Initialize simple dependencies
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theCallhierarchyPackage.createPackageContents();

    // Initialize created meta-data
    theCallhierarchyPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCallhierarchyPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ICallhierarchyPackage.eNS_URI, theCallhierarchyPackage);
    return theCallhierarchyPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getHierarchyResult() {
    return hierarchyResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getHierarchyResult_Entries() {
    return (EReference) hierarchyResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResult_OriginType() {
    return (EAttribute) hierarchyResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResult_OriginObjectName() {
    return (EAttribute) hierarchyResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResult_OriginEnclObjectName() {
    return (EAttribute) hierarchyResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getCallPosition() {
    return callPositionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCallPosition_Uri() {
    return (EAttribute) callPositionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCallPosition_Line() {
    return (EAttribute) callPositionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCallPosition_Column() {
    return (EAttribute) callPositionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getMethodProperties() {
    return methodPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getMethodProperties_Final() {
    return (EAttribute) methodPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getMethodProperties_Abstract() {
    return (EAttribute) methodPropertiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getMethodProperties_Redefined() {
    return (EAttribute) methodPropertiesEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getMethodProperties_Handler() {
    return (EAttribute) methodPropertiesEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getMethodProperties_Constructor() {
    return (EAttribute) methodPropertiesEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getMethodProperties_Static() {
    return (EAttribute) methodPropertiesEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getMethodProperties_Visibility() {
    return (EAttribute) methodPropertiesEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getMethodProperties_TestMethod() {
    return (EAttribute) methodPropertiesEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getHierarchyResultEntry() {
    return hierarchyResultEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResultEntry_EnclosedObjectName() {
    return (EAttribute) hierarchyResultEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResultEntry_EnclosedObjectDisplayName() {
    return (EAttribute) hierarchyResultEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResultEntry_Name() {
    return (EAttribute) hierarchyResultEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResultEntry_Type() {
    return (EAttribute) hierarchyResultEntryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResultEntry_Owner() {
    return (EAttribute) hierarchyResultEntryEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResultEntry_PackageName() {
    return (EAttribute) hierarchyResultEntryEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResultEntry_Description() {
    return (EAttribute) hierarchyResultEntryEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResultEntry_Uri() {
    return (EAttribute) hierarchyResultEntryEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getHierarchyResultEntry_ParentUri() {
    return (EAttribute) hierarchyResultEntryEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getHierarchyResultEntry_CallPositions() {
    return (EReference) hierarchyResultEntryEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getHierarchyResultEntry_MethodProperties() {
    return (EReference) hierarchyResultEntryEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getMethodVisibility() {
    return methodVisibilityEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ICallhierarchyFactory getCallhierarchyFactory() {
    return (ICallhierarchyFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package. This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) {
      return;
    }
    isCreated = true;

    // Create classes and their features
    hierarchyResultEClass = createEClass(HIERARCHY_RESULT);
    createEReference(hierarchyResultEClass, HIERARCHY_RESULT__ENTRIES);
    createEAttribute(hierarchyResultEClass, HIERARCHY_RESULT__ORIGIN_TYPE);
    createEAttribute(hierarchyResultEClass, HIERARCHY_RESULT__ORIGIN_OBJECT_NAME);
    createEAttribute(hierarchyResultEClass, HIERARCHY_RESULT__ORIGIN_ENCL_OBJECT_NAME);

    callPositionEClass = createEClass(CALL_POSITION);
    createEAttribute(callPositionEClass, CALL_POSITION__URI);
    createEAttribute(callPositionEClass, CALL_POSITION__LINE);
    createEAttribute(callPositionEClass, CALL_POSITION__COLUMN);

    methodPropertiesEClass = createEClass(METHOD_PROPERTIES);
    createEAttribute(methodPropertiesEClass, METHOD_PROPERTIES__FINAL);
    createEAttribute(methodPropertiesEClass, METHOD_PROPERTIES__ABSTRACT);
    createEAttribute(methodPropertiesEClass, METHOD_PROPERTIES__REDEFINED);
    createEAttribute(methodPropertiesEClass, METHOD_PROPERTIES__HANDLER);
    createEAttribute(methodPropertiesEClass, METHOD_PROPERTIES__CONSTRUCTOR);
    createEAttribute(methodPropertiesEClass, METHOD_PROPERTIES__STATIC);
    createEAttribute(methodPropertiesEClass, METHOD_PROPERTIES__VISIBILITY);
    createEAttribute(methodPropertiesEClass, METHOD_PROPERTIES__TEST_METHOD);

    hierarchyResultEntryEClass = createEClass(HIERARCHY_RESULT_ENTRY);
    createEAttribute(hierarchyResultEntryEClass, HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_NAME);
    createEAttribute(hierarchyResultEntryEClass,
        HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_DISPLAY_NAME);
    createEAttribute(hierarchyResultEntryEClass, HIERARCHY_RESULT_ENTRY__NAME);
    createEAttribute(hierarchyResultEntryEClass, HIERARCHY_RESULT_ENTRY__TYPE);
    createEAttribute(hierarchyResultEntryEClass, HIERARCHY_RESULT_ENTRY__OWNER);
    createEAttribute(hierarchyResultEntryEClass, HIERARCHY_RESULT_ENTRY__PACKAGE_NAME);
    createEAttribute(hierarchyResultEntryEClass, HIERARCHY_RESULT_ENTRY__DESCRIPTION);
    createEAttribute(hierarchyResultEntryEClass, HIERARCHY_RESULT_ENTRY__URI);
    createEAttribute(hierarchyResultEntryEClass, HIERARCHY_RESULT_ENTRY__PARENT_URI);
    createEReference(hierarchyResultEntryEClass, HIERARCHY_RESULT_ENTRY__CALL_POSITIONS);
    createEReference(hierarchyResultEntryEClass, HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES);

    // Create enums
    methodVisibilityEEnum = createEEnum(METHOD_VISIBILITY);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) {
      return;
    }
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE.getEPackage(
        XMLTypePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(hierarchyResultEClass, IHierarchyResult.class, "HierarchyResult", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHierarchyResult_Entries(), getHierarchyResultEntry(), null, "entries", null,
        0, -1, IHierarchyResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHierarchyResult_OriginType(), theXMLTypePackage.getString(), "originType",
        null, 0, 1, IHierarchyResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHierarchyResult_OriginObjectName(), theXMLTypePackage.getString(),
        "originObjectName", null, 0, 1, IHierarchyResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHierarchyResult_OriginEnclObjectName(), theXMLTypePackage.getString(),
        "originEnclObjectName", null, 0, 1, IHierarchyResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(callPositionEClass, ICallPosition.class, "CallPosition", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCallPosition_Uri(), theXMLTypePackage.getAnyURI(), "uri", null, 0, 1,
        ICallPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCallPosition_Line(), theXMLTypePackage.getInt(), "line", null, 0, 1,
        ICallPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCallPosition_Column(), theXMLTypePackage.getInt(), "column", null, 0, 1,
        ICallPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methodPropertiesEClass, IMethodProperties.class, "MethodProperties", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMethodProperties_Final(), theXMLTypePackage.getBoolean(), "final", null, 0, 1,
        IMethodProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMethodProperties_Abstract(), theXMLTypePackage.getBoolean(), "abstract", null,
        0, 1, IMethodProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMethodProperties_Redefined(), theXMLTypePackage.getBoolean(), "redefined",
        null, 0, 1, IMethodProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMethodProperties_Handler(), theXMLTypePackage.getBoolean(), "handler", null,
        0, 1, IMethodProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMethodProperties_Constructor(), theXMLTypePackage.getBoolean(), "constructor",
        null, 0, 1, IMethodProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMethodProperties_Static(), theXMLTypePackage.getBoolean(), "static", null, 0,
        1, IMethodProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMethodProperties_Visibility(), getMethodVisibility(), "visibility", null, 0,
        1, IMethodProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMethodProperties_TestMethod(), theXMLTypePackage.getBoolean(), "testMethod",
        null, 0, 1, IMethodProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hierarchyResultEntryEClass, IHierarchyResultEntry.class, "HierarchyResultEntry",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getHierarchyResultEntry_EnclosedObjectName(), theXMLTypePackage.getString(),
        "enclosedObjectName", null, 0, 1, IHierarchyResultEntry.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHierarchyResultEntry_EnclosedObjectDisplayName(), theXMLTypePackage
        .getString(), "enclosedObjectDisplayName", null, 0, 1, IHierarchyResultEntry.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getHierarchyResultEntry_Name(), theXMLTypePackage.getString(), "name", null, 0,
        1, IHierarchyResultEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHierarchyResultEntry_Type(), theXMLTypePackage.getString(), "type", null, 0,
        1, IHierarchyResultEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHierarchyResultEntry_Owner(), theXMLTypePackage.getString(), "owner", null, 0,
        1, IHierarchyResultEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHierarchyResultEntry_PackageName(), theXMLTypePackage.getString(),
        "packageName", null, 0, 1, IHierarchyResultEntry.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHierarchyResultEntry_Description(), theXMLTypePackage.getString(),
        "description", null, 0, 1, IHierarchyResultEntry.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHierarchyResultEntry_Uri(), theXMLTypePackage.getAnyURI(), "uri", null, 0, 1,
        IHierarchyResultEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHierarchyResultEntry_ParentUri(), theXMLTypePackage.getAnyURI(), "parentUri",
        null, 0, 1, IHierarchyResultEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHierarchyResultEntry_CallPositions(), getCallPosition(), null,
        "callPositions", null, 0, -1, IHierarchyResultEntry.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getHierarchyResultEntry_MethodProperties(), getMethodProperties(), null,
        "methodProperties", null, 0, 1, IHierarchyResultEntry.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(methodVisibilityEEnum, MethodVisibility.class, "MethodVisibility");
    addEEnumLiteral(methodVisibilityEEnum, MethodVisibility.PRIVATE);
    addEEnumLiteral(methodVisibilityEEnum, MethodVisibility.PROTECTED);
    addEEnumLiteral(methodVisibilityEEnum, MethodVisibility.PUBLIC);
    addEEnumLiteral(methodVisibilityEEnum, MethodVisibility.UNKNOWN);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void createExtendedMetaDataAnnotations() {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
    addAnnotation(hierarchyResultEClass, source, new String[] { "kind", "elementOnly", "name",
        "result" });
    addAnnotation(getHierarchyResult_Entries(), source, new String[] { "kind", "element", "name",
        "entry", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResult_OriginType(), source, new String[] { "kind", "attribute",
        "name", "originType", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResult_OriginObjectName(), source, new String[] { "kind", "attribute",
        "name", "originObjectName", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResult_OriginEnclObjectName(), source, new String[] { "kind",
        "attribute", "name", "originEnclObjectName", "namespace", "##targetNamespace" });
    addAnnotation(callPositionEClass, source, new String[] { "kind", "elementOnly", "name",
        "callPosition" });
    addAnnotation(getCallPosition_Uri(), source, new String[] { "kind", "attribute", "name", "uri",
        "namespace", "##targetNamespace" });
    addAnnotation(getCallPosition_Line(), source, new String[] { "kind", "attribute", "name",
        "line", "namespace", "##targetNamespace" });
    addAnnotation(getCallPosition_Column(), source, new String[] { "kind", "attribute", "name",
        "column", "namespace", "##targetNamespace" });
    addAnnotation(methodPropertiesEClass, source, new String[] { "kind", "elementOnly", "name",
        "methodProperties" });
    addAnnotation(getMethodProperties_Final(), source, new String[] { "kind", "attribute", "name",
        "isFinal", "namespace", "##targetNamespace" });
    addAnnotation(getMethodProperties_Abstract(), source, new String[] { "kind", "attribute",
        "name", "isAbstract", "namespace", "##targetNamespace" });
    addAnnotation(getMethodProperties_Redefined(), source, new String[] { "kind", "attribute",
        "name", "isRedefined", "namespace", "##targetNamespace" });
    addAnnotation(getMethodProperties_Handler(), source, new String[] { "kind", "attribute", "name",
        "isHandler", "namespace", "##targetNamespace" });
    addAnnotation(getMethodProperties_Constructor(), source, new String[] { "kind", "attribute",
        "name", "isConstructor", "namespace", "##targetNamespace" });
    addAnnotation(getMethodProperties_Static(), source, new String[] { "kind", "attribute", "name",
        "isStatic", "namespace", "##targetNamespace" });
    addAnnotation(getMethodProperties_Visibility(), source, new String[] { "kind", "attribute",
        "name", "visibility", "namespace", "##targetNamespace" });
    addAnnotation(getMethodProperties_TestMethod(), source, new String[] { "kind", "attribute",
        "name", "isTestMethod", "namespace", "##targetNamespace" });
    addAnnotation(hierarchyResultEntryEClass, source, new String[] { "kind", "elementOnly", "name",
        "entry" });
    addAnnotation(getHierarchyResultEntry_EnclosedObjectName(), source, new String[] { "kind",
        "attribute", "name", "enclObjName", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResultEntry_EnclosedObjectDisplayName(), source, new String[] {
        "kind", "attribute", "name", "enclObjDisplayName", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResultEntry_Name(), source, new String[] { "kind", "attribute",
        "name", "name", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResultEntry_Type(), source, new String[] { "kind", "attribute",
        "name", "type", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResultEntry_Owner(), source, new String[] { "kind", "attribute",
        "name", "owner", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResultEntry_PackageName(), source, new String[] { "kind", "attribute",
        "name", "packageName", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResultEntry_Description(), source, new String[] { "kind", "attribute",
        "name", "description", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResultEntry_Uri(), source, new String[] { "kind", "attribute", "name",
        "uri", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResultEntry_ParentUri(), source, new String[] { "kind", "attribute",
        "name", "parentUri", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResultEntry_CallPositions(), source, new String[] { "kind", "element",
        "name", "callPosition", "namespace", "##targetNamespace" });
    addAnnotation(getHierarchyResultEntry_MethodProperties(), source, new String[] { "kind",
        "element", "name", "methodProperties", "namespace", "##targetNamespace" });
  }

} // CallhierarchyPackage
