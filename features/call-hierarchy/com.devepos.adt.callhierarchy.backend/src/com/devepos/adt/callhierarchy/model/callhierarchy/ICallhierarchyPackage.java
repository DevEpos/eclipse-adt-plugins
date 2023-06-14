/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyFactory
 * @model kind="package"
 * @generated
 */
public interface ICallhierarchyPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNAME = "callhierarchy";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_URI = "http://www.devepos.com/adt/aht/callhierarchy";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_PREFIX = "hierarchy";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  ICallhierarchyPackage eINSTANCE = com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage
      .init();

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResult <em>Hierarchy
   * Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResult
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage#getHierarchyResult()
   * @generated
   */
  int HIERARCHY_RESULT = 0;

  /**
   * The feature id for the '<em><b>Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT__ENTRIES = 0;

  /**
   * The feature id for the '<em><b>Origin Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT__ORIGIN_TYPE = 1;

  /**
   * The feature id for the '<em><b>Origin Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT__ORIGIN_OBJECT_NAME = 2;

  /**
   * The feature id for the '<em><b>Origin Encl Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT__ORIGIN_ENCL_OBJECT_NAME = 3;

  /**
   * The feature id for the '<em><b>Origin Object Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT__ORIGIN_OBJECT_IDENTIFIER = 4;

  /**
   * The number of structural features of the '<em>Hierarchy Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_FEATURE_COUNT = 5;

  /**
   * The number of operations of the '<em>Hierarchy Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallPosition <em>Call
   * Position</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallPosition
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage#getCallPosition()
   * @generated
   */
  int CALL_POSITION = 1;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CALL_POSITION__URI = 0;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CALL_POSITION__LINE = 1;

  /**
   * The feature id for the '<em><b>Column</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CALL_POSITION__COLUMN = 2;

  /**
   * The number of structural features of the '<em>Call Position</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CALL_POSITION_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Call Position</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CALL_POSITION_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties <em>Method
   * Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage#getMethodProperties()
   * @generated
   */
  int METHOD_PROPERTIES = 2;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int METHOD_PROPERTIES__FINAL = 0;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int METHOD_PROPERTIES__ABSTRACT = 1;

  /**
   * The feature id for the '<em><b>Redefined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int METHOD_PROPERTIES__REDEFINED = 2;

  /**
   * The feature id for the '<em><b>Handler</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int METHOD_PROPERTIES__HANDLER = 3;

  /**
   * The feature id for the '<em><b>Constructor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int METHOD_PROPERTIES__CONSTRUCTOR = 4;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int METHOD_PROPERTIES__STATIC = 5;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int METHOD_PROPERTIES__VISIBILITY = 6;

  /**
   * The feature id for the '<em><b>Test Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int METHOD_PROPERTIES__TEST_METHOD = 7;

  /**
   * The number of structural features of the '<em>Method Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int METHOD_PROPERTIES_FEATURE_COUNT = 8;

  /**
   * The number of operations of the '<em>Method Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int METHOD_PROPERTIES_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry
   * <em>Hierarchy Result Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage#getHierarchyResultEntry()
   * @generated
   */
  int HIERARCHY_RESULT_ENTRY = 3;

  /**
   * The feature id for the '<em><b>Enclosed Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_NAME = 0;

  /**
   * The feature id for the '<em><b>Enclosed Object Display Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_DISPLAY_NAME = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__NAME = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__TYPE = 3;

  /**
   * The feature id for the '<em><b>Owner</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__OWNER = 4;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__PACKAGE_NAME = 5;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__DESCRIPTION = 6;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__URI = 7;

  /**
   * The feature id for the '<em><b>Parent Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__PARENT_URI = 8;

  /**
   * The feature id for the '<em><b>Call Positions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__CALL_POSITIONS = 9;

  /**
   * The feature id for the '<em><b>Method Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES = 10;

  /**
   * The feature id for the '<em><b>Object Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY__OBJECT_IDENTIFIER = 11;

  /**
   * The number of structural features of the '<em>Hierarchy Result Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY_FEATURE_COUNT = 12;

  /**
   * The number of operations of the '<em>Hierarchy Result Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int HIERARCHY_RESULT_ENTRY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility <em>Method
   * Visibility</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage#getMethodVisibility()
   * @generated
   */
  int METHOD_VISIBILITY = 4;

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult <em>Hierarchy
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Hierarchy Result</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult
   * @generated
   */
  EClass getHierarchyResult();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getEntries
   * <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Entries</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getEntries()
   * @see #getHierarchyResult()
   * @generated
   */
  EReference getHierarchyResult_Entries();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginType
   * <em>Origin Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Origin Type</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginType()
   * @see #getHierarchyResult()
   * @generated
   */
  EAttribute getHierarchyResult_OriginType();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginObjectName
   * <em>Origin Object Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Origin Object Name</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginObjectName()
   * @see #getHierarchyResult()
   * @generated
   */
  EAttribute getHierarchyResult_OriginObjectName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginEnclObjectName
   * <em>Origin Encl Object Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Origin Encl Object Name</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginEnclObjectName()
   * @see #getHierarchyResult()
   * @generated
   */
  EAttribute getHierarchyResult_OriginEnclObjectName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginObjectIdentifier
   * <em>Origin Object Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Origin Object Identifier</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginObjectIdentifier()
   * @see #getHierarchyResult()
   * @generated
   */
  EAttribute getHierarchyResult_OriginObjectIdentifier();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition <em>Call
   * Position</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Call Position</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition
   * @generated
   */
  EClass getCallPosition();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition#getUri()
   * @see #getCallPosition()
   * @generated
   */
  EAttribute getCallPosition_Uri();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition#getLine
   * <em>Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Line</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition#getLine()
   * @see #getCallPosition()
   * @generated
   */
  EAttribute getCallPosition_Line();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition#getColumn
   * <em>Column</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Column</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition#getColumn()
   * @see #getCallPosition()
   * @generated
   */
  EAttribute getCallPosition_Column();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties <em>Method
   * Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Method Properties</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties
   * @generated
   */
  EClass getMethodProperties();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isFinal
   * <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isFinal()
   * @see #getMethodProperties()
   * @generated
   */
  EAttribute getMethodProperties_Final();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isAbstract
   * <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isAbstract()
   * @see #getMethodProperties()
   * @generated
   */
  EAttribute getMethodProperties_Abstract();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isRedefined
   * <em>Redefined</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Redefined</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isRedefined()
   * @see #getMethodProperties()
   * @generated
   */
  EAttribute getMethodProperties_Redefined();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isHandler
   * <em>Handler</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Handler</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isHandler()
   * @see #getMethodProperties()
   * @generated
   */
  EAttribute getMethodProperties_Handler();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isConstructor
   * <em>Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Constructor</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isConstructor()
   * @see #getMethodProperties()
   * @generated
   */
  EAttribute getMethodProperties_Constructor();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isStatic
   * <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isStatic()
   * @see #getMethodProperties()
   * @generated
   */
  EAttribute getMethodProperties_Static();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#getVisibility
   * <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#getVisibility()
   * @see #getMethodProperties()
   * @generated
   */
  EAttribute getMethodProperties_Visibility();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isTestMethod
   * <em>Test Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Test Method</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties#isTestMethod()
   * @see #getMethodProperties()
   * @generated
   */
  EAttribute getMethodProperties_TestMethod();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry <em>Hierarchy
   * Result Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Hierarchy Result Entry</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry
   * @generated
   */
  EClass getHierarchyResultEntry();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getEnclosedObjectName
   * <em>Enclosed Object Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Enclosed Object Name</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getEnclosedObjectName()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EAttribute getHierarchyResultEntry_EnclosedObjectName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getEnclosedObjectDisplayName
   * <em>Enclosed Object Display Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Enclosed Object Display Name</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getEnclosedObjectDisplayName()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EAttribute getHierarchyResultEntry_EnclosedObjectDisplayName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getName
   * <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getName()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EAttribute getHierarchyResultEntry_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getType
   * <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getType()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EAttribute getHierarchyResultEntry_Type();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getOwner
   * <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Owner</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getOwner()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EAttribute getHierarchyResultEntry_Owner();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getPackageName
   * <em>Package Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Package Name</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getPackageName()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EAttribute getHierarchyResultEntry_PackageName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getDescription
   * <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getDescription()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EAttribute getHierarchyResultEntry_Description();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getUri
   * <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getUri()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EAttribute getHierarchyResultEntry_Uri();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getParentUri
   * <em>Parent Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Uri</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getParentUri()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EAttribute getHierarchyResultEntry_ParentUri();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getCallPositions
   * <em>Call Positions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Call Positions</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getCallPositions()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EReference getHierarchyResultEntry_CallPositions();

  /**
   * Returns the meta object for the containment reference
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getMethodProperties
   * <em>Method Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>Method Properties</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getMethodProperties()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EReference getHierarchyResultEntry_MethodProperties();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getObjectIdentifier
   * <em>Object Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Object Identifier</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getObjectIdentifier()
   * @see #getHierarchyResultEntry()
   * @generated
   */
  EAttribute getHierarchyResultEntry_ObjectIdentifier();

  /**
   * Returns the meta object for enum
   * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility <em>Method
   * Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Method Visibility</em>'.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility
   * @generated
   */
  EEnum getMethodVisibility();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ICallhierarchyFactory getCallhierarchyFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each operation of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   *
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResult <em>Hierarchy
     * Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResult
     * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage#getHierarchyResult()
     * @generated
     */
    EClass HIERARCHY_RESULT = eINSTANCE.getHierarchyResult();

    /**
     * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference HIERARCHY_RESULT__ENTRIES = eINSTANCE.getHierarchyResult_Entries();

    /**
     * The meta object literal for the '<em><b>Origin Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT__ORIGIN_TYPE = eINSTANCE.getHierarchyResult_OriginType();

    /**
     * The meta object literal for the '<em><b>Origin Object Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT__ORIGIN_OBJECT_NAME = eINSTANCE
        .getHierarchyResult_OriginObjectName();

    /**
     * The meta object literal for the '<em><b>Origin Encl Object Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT__ORIGIN_ENCL_OBJECT_NAME = eINSTANCE
        .getHierarchyResult_OriginEnclObjectName();

    /**
     * The meta object literal for the '<em><b>Origin Object Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT__ORIGIN_OBJECT_IDENTIFIER = eINSTANCE
        .getHierarchyResult_OriginObjectIdentifier();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallPosition <em>Call
     * Position</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallPosition
     * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage#getCallPosition()
     * @generated
     */
    EClass CALL_POSITION = eINSTANCE.getCallPosition();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CALL_POSITION__URI = eINSTANCE.getCallPosition_Uri();

    /**
     * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CALL_POSITION__LINE = eINSTANCE.getCallPosition_Line();

    /**
     * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CALL_POSITION__COLUMN = eINSTANCE.getCallPosition_Column();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties <em>Method
     * Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.MethodProperties
     * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage#getMethodProperties()
     * @generated
     */
    EClass METHOD_PROPERTIES = eINSTANCE.getMethodProperties();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute METHOD_PROPERTIES__FINAL = eINSTANCE.getMethodProperties_Final();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute METHOD_PROPERTIES__ABSTRACT = eINSTANCE.getMethodProperties_Abstract();

    /**
     * The meta object literal for the '<em><b>Redefined</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute METHOD_PROPERTIES__REDEFINED = eINSTANCE.getMethodProperties_Redefined();

    /**
     * The meta object literal for the '<em><b>Handler</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute METHOD_PROPERTIES__HANDLER = eINSTANCE.getMethodProperties_Handler();

    /**
     * The meta object literal for the '<em><b>Constructor</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute METHOD_PROPERTIES__CONSTRUCTOR = eINSTANCE.getMethodProperties_Constructor();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute METHOD_PROPERTIES__STATIC = eINSTANCE.getMethodProperties_Static();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute METHOD_PROPERTIES__VISIBILITY = eINSTANCE.getMethodProperties_Visibility();

    /**
     * The meta object literal for the '<em><b>Test Method</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute METHOD_PROPERTIES__TEST_METHOD = eINSTANCE.getMethodProperties_TestMethod();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry
     * <em>Hierarchy Result Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry
     * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage#getHierarchyResultEntry()
     * @generated
     */
    EClass HIERARCHY_RESULT_ENTRY = eINSTANCE.getHierarchyResultEntry();

    /**
     * The meta object literal for the '<em><b>Enclosed Object Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_NAME = eINSTANCE
        .getHierarchyResultEntry_EnclosedObjectName();

    /**
     * The meta object literal for the '<em><b>Enclosed Object Display Name</b></em>' attribute
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_DISPLAY_NAME = eINSTANCE
        .getHierarchyResultEntry_EnclosedObjectDisplayName();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT_ENTRY__NAME = eINSTANCE.getHierarchyResultEntry_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT_ENTRY__TYPE = eINSTANCE.getHierarchyResultEntry_Type();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT_ENTRY__OWNER = eINSTANCE.getHierarchyResultEntry_Owner();

    /**
     * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT_ENTRY__PACKAGE_NAME = eINSTANCE
        .getHierarchyResultEntry_PackageName();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT_ENTRY__DESCRIPTION = eINSTANCE
        .getHierarchyResultEntry_Description();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT_ENTRY__URI = eINSTANCE.getHierarchyResultEntry_Uri();

    /**
     * The meta object literal for the '<em><b>Parent Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT_ENTRY__PARENT_URI = eINSTANCE.getHierarchyResultEntry_ParentUri();

    /**
     * The meta object literal for the '<em><b>Call Positions</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference HIERARCHY_RESULT_ENTRY__CALL_POSITIONS = eINSTANCE
        .getHierarchyResultEntry_CallPositions();

    /**
     * The meta object literal for the '<em><b>Method Properties</b></em>' containment reference
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES = eINSTANCE
        .getHierarchyResultEntry_MethodProperties();

    /**
     * The meta object literal for the '<em><b>Object Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute HIERARCHY_RESULT_ENTRY__OBJECT_IDENTIFIER = eINSTANCE
        .getHierarchyResultEntry_ObjectIdentifier();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility <em>Method
     * Visibility</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.callhierarchy.model.callhierarchy.MethodVisibility
     * @see com.devepos.adt.callhierarchy.model.callhierarchy.impl.CallhierarchyPackage#getMethodVisibility()
     * @generated
     */
    EEnum METHOD_VISIBILITY = eINSTANCE.getMethodVisibility();

  }

} // ICallhierarchyPackage
