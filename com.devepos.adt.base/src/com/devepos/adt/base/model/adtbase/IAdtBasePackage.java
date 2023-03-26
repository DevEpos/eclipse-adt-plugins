/**
 */
package com.devepos.adt.base.model.adtbase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBaseFactory
 * @model kind="package"
 * @generated
 */
public interface IAdtBasePackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  String eNAME = "adtbase";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_URI = "http://www.devepos.com/adt/base";

  /**
   * The package namespace name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_PREFIX = "adtbase";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  IAdtBasePackage eINSTANCE = com.devepos.adt.base.model.adtbase.impl.AdtBasePackage.init();

  /**
   * The meta object id for the '{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef <em>Adt
   * Obj Ref</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.base.model.adtbase.impl.AdtObjRef
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtObjRef()
   * @generated
   */
  int ADT_OBJ_REF = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF__DESCRIPTION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF__NAME = 1;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF__PACKAGE_NAME = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF__TYPE = 3;

  /**
   * The feature id for the '<em><b>Tadir Type</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF__TADIR_TYPE = 4;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF__URI = 5;

  /**
   * The feature id for the '<em><b>Parent Uri</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF__PARENT_URI = 6;

  /**
   * The feature id for the '<em><b>Parent Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF__PARENT_NAME = 7;

  /**
   * The feature id for the '<em><b>Owner</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF__OWNER = 8;

  /**
   * The number of structural features of the '<em>Adt Obj Ref</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF_FEATURE_COUNT = 9;

  /**
   * The number of operations of the '<em>Adt Obj Ref</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRefList
   * <em>Adt Obj Ref List</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.base.model.adtbase.impl.AdtObjRefList
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtObjRefList()
   * @generated
   */
  int ADT_OBJ_REF_LIST = 1;

  /**
   * The feature id for the '<em><b>Object References</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF_LIST__OBJECT_REFERENCES = 0;

  /**
   * The number of structural features of the '<em>Adt Obj Ref List</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF_LIST_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Adt Obj Ref List</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJ_REF_LIST_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.base.model.adtbase.impl.User <em>User</em>}'
   * class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.base.model.adtbase.impl.User
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getUser()
   * @generated
   */
  int USER = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER__NAME = 0;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER__TEXT = 1;

  /**
   * The number of structural features of the '<em>User</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>User</em>' class.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeature
   * <em>Adt Plugin Feature</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.base.model.adtbase.impl.AdtPluginFeature
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtPluginFeature()
   * @generated
   */
  int ADT_PLUGIN_FEATURE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE__NAME = 0;

  /**
   * The feature id for the '<em><b>Endpoint</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE__ENDPOINT = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE__TYPE = 2;

  /**
   * The feature id for the '<em><b>Enabled</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE__ENABLED = 3;

  /**
   * The feature id for the '<em><b>Category</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE__CATEGORY = 4;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE__DESCRIPTION = 5;

  /**
   * The number of structural features of the '<em>Adt Plugin Feature</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE_FEATURE_COUNT = 6;

  /**
   * The number of operations of the '<em>Adt Plugin Feature</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeatureList <em>Adt
   * Plugin Feature List</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see com.devepos.adt.base.model.adtbase.impl.AdtPluginFeatureList
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtPluginFeatureList()
   * @generated
   */
  int ADT_PLUGIN_FEATURE_LIST = 4;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE_LIST__FEATURES = 0;

  /**
   * The number of structural features of the '<em>Adt Plugin Feature List</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE_LIST_FEATURE_COUNT = 1;

  /**
   * The operation id for the '<em>Get Features By Endpoint</em>' operation. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE_LIST___GET_FEATURES_BY_ENDPOINT__STRING = 0;

  /**
   * The number of operations of the '<em>Adt Plugin Feature List</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_PLUGIN_FEATURE_LIST_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link com.devepos.adt.base.model.adtbase.impl.ResponseMessage
   * <em>Response Message</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.base.model.adtbase.impl.ResponseMessage
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getResponseMessage()
   * @generated
   */
  int RESPONSE_MESSAGE = 5;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RESPONSE_MESSAGE__TYPE = 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RESPONSE_MESSAGE__CONTENT = 1;

  /**
   * The feature id for the '<em><b>Occurrences</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RESPONSE_MESSAGE__OCCURRENCES = 2;

  /**
   * The number of structural features of the '<em>Response Message</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RESPONSE_MESSAGE_FEATURE_COUNT = 3;

  /**
   * The operation id for the '<em>Get Status Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RESPONSE_MESSAGE___GET_STATUS_TYPE = 0;

  /**
   * The number of operations of the '<em>Response Message</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RESPONSE_MESSAGE_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link com.devepos.adt.base.model.adtbase.impl.ResponseMessageList
   * <em>Response Message List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.base.model.adtbase.impl.ResponseMessageList
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getResponseMessageList()
   * @generated
   */
  int RESPONSE_MESSAGE_LIST = 6;

  /**
   * The feature id for the '<em><b>Messages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RESPONSE_MESSAGE_LIST__MESSAGES = 0;

  /**
   * The number of structural features of the '<em>Response Message List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RESPONSE_MESSAGE_LIST_FEATURE_COUNT = 1;

  /**
   * The operation id for the '<em>To Status</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RESPONSE_MESSAGE_LIST___TO_STATUS__STRING_STRING = 0;

  /**
   * The number of operations of the '<em>Response Message List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RESPONSE_MESSAGE_LIST_OPERATION_COUNT = 1;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.base.model.adtbase.AdtPluginFeatureType <em>Adt
   * Plugin Feature Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see com.devepos.adt.base.model.adtbase.AdtPluginFeatureType
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtPluginFeatureType()
   * @generated
   */
  int ADT_PLUGIN_FEATURE_TYPE = 7;

  /**
   * The meta object id for the '{@link com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory
   * <em>Adt Plugin Feature Category</em>}' enum.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtPluginFeatureCategory()
   * @generated
   */
  int ADT_PLUGIN_FEATURE_CATEGORY = 8;

  /**
   * The meta object id for the '{@link com.devepos.adt.base.model.adtbase.MessageType <em>Message
   * Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.base.model.adtbase.MessageType
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getMessageType()
   * @generated
   */
  int MESSAGE_TYPE = 9;

  /**
   * The meta object id for the '<em>IAdt Plugin Features</em>' data type. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.base.plugin.features.IAdtPluginFeatures
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getIAdtPluginFeatures()
   * @generated
   */
  int IADT_PLUGIN_FEATURES = 10;

  /**
   * The meta object id for the '<em>IStatus</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see org.eclipse.core.runtime.IStatus
   * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getIStatus()
   * @generated
   */
  int ISTATUS = 11;

  /**
   * Returns the meta object for class '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef <em>Adt
   * Obj Ref</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Adt Obj Ref</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef
   * @generated
   */
  EClass getAdtObjRef();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getDescription()
   * @see #getAdtObjRef()
   * @generated
   */
  EAttribute getAdtObjRef_Description();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getName()
   * @see #getAdtObjRef()
   * @generated
   */
  EAttribute getAdtObjRef_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getPackageName <em>Package Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Package Name</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getPackageName()
   * @see #getAdtObjRef()
   * @generated
   */
  EAttribute getAdtObjRef_PackageName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getType <em>Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getType()
   * @see #getAdtObjRef()
   * @generated
   */
  EAttribute getAdtObjRef_Type();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getUri()
   * @see #getAdtObjRef()
   * @generated
   */
  EAttribute getAdtObjRef_Uri();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getParentUri <em>Parent Uri</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Uri</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getParentUri()
   * @see #getAdtObjRef()
   * @generated
   */
  EAttribute getAdtObjRef_ParentUri();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getParentName <em>Parent Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Name</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getParentName()
   * @see #getAdtObjRef()
   * @generated
   */
  EAttribute getAdtObjRef_ParentName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Owner</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getOwner()
   * @see #getAdtObjRef()
   * @generated
   */
  EAttribute getAdtObjRef_Owner();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef#getTadirType <em>Tadir Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Tadir Type</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef#getTadirType()
   * @see #getAdtObjRef()
   * @generated
   */
  EAttribute getAdtObjRef_TadirType();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.base.model.adtbase.IAdtObjRefList
   * <em>Adt Obj Ref List</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Adt Obj Ref List</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRefList
   * @generated
   */
  EClass getAdtObjRefList();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRefList#getObjectReferences <em>Object
   * References</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Object References</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRefList#getObjectReferences()
   * @see #getAdtObjRefList()
   * @generated
   */
  EReference getAdtObjRefList_ObjectReferences();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.base.model.adtbase.IUser <em>User</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>User</em>'.
   * @see com.devepos.adt.base.model.adtbase.IUser
   * @generated
   */
  EClass getUser();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IUser#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.base.model.adtbase.IUser#getName()
   * @see #getUser()
   * @generated
   */
  EAttribute getUser_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IUser#getText <em>Text</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see com.devepos.adt.base.model.adtbase.IUser#getText()
   * @see #getUser()
   * @generated
   */
  EAttribute getUser_Text();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature
   * <em>Adt Plugin Feature</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Adt Plugin Feature</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeature
   * @generated
   */
  EClass getAdtPluginFeature();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getName()
   * @see #getAdtPluginFeature()
   * @generated
   */
  EAttribute getAdtPluginFeature_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getEndpoint <em>Endpoint</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Endpoint</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getEndpoint()
   * @see #getAdtPluginFeature()
   * @generated
   */
  EAttribute getAdtPluginFeature_Endpoint();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getType <em>Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getType()
   * @see #getAdtPluginFeature()
   * @generated
   */
  EAttribute getAdtPluginFeature_Type();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getDescription
   * <em>Description</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getDescription()
   * @see #getAdtPluginFeature()
   * @generated
   */
  EAttribute getAdtPluginFeature_Description();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#isEnabled <em>Enabled</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Enabled</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeature#isEnabled()
   * @see #getAdtPluginFeature()
   * @generated
   */
  EAttribute getAdtPluginFeature_Enabled();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Category</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getCategory()
   * @see #getAdtPluginFeature()
   * @generated
   */
  EAttribute getAdtPluginFeature_Category();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList <em>Adt Plugin Feature
   * List</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Adt Plugin Feature List</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList
   * @generated
   */
  EClass getAdtPluginFeatureList();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList#getFeatures
   * <em>Features</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList#getFeatures()
   * @see #getAdtPluginFeatureList()
   * @generated
   */
  EReference getAdtPluginFeatureList_Features();

  /**
   * Returns the meta object for the
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList#getFeaturesByEndpoint(java.lang.String)
   * <em>Get Features By Endpoint</em>}' operation.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return the meta object for the '<em>Get Features By Endpoint</em>' operation.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList#getFeaturesByEndpoint(java.lang.String)
   * @generated
   */
  EOperation getAdtPluginFeatureList__GetFeaturesByEndpoint__String();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.base.model.adtbase.IResponseMessage
   * <em>Response Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Response Message</em>'.
   * @see com.devepos.adt.base.model.adtbase.IResponseMessage
   * @generated
   */
  EClass getResponseMessage();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IResponseMessage#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see com.devepos.adt.base.model.adtbase.IResponseMessage#getType()
   * @see #getResponseMessage()
   * @generated
   */
  EAttribute getResponseMessage_Type();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IResponseMessage#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see com.devepos.adt.base.model.adtbase.IResponseMessage#getContent()
   * @see #getResponseMessage()
   * @generated
   */
  EAttribute getResponseMessage_Content();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.base.model.adtbase.IResponseMessage#getOccurrences
   * <em>Occurrences</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Occurrences</em>'.
   * @see com.devepos.adt.base.model.adtbase.IResponseMessage#getOccurrences()
   * @see #getResponseMessage()
   * @generated
   */
  EAttribute getResponseMessage_Occurrences();

  /**
   * Returns the meta object for the
   * '{@link com.devepos.adt.base.model.adtbase.IResponseMessage#getStatusType() <em>Get Status
   * Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Get Status Type</em>' operation.
   * @see com.devepos.adt.base.model.adtbase.IResponseMessage#getStatusType()
   * @generated
   */
  EOperation getResponseMessage__GetStatusType();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.base.model.adtbase.IResponseMessageList <em>Response Message
   * List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Response Message List</em>'.
   * @see com.devepos.adt.base.model.adtbase.IResponseMessageList
   * @generated
   */
  EClass getResponseMessageList();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.base.model.adtbase.IResponseMessageList#getMessages
   * <em>Messages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Messages</em>'.
   * @see com.devepos.adt.base.model.adtbase.IResponseMessageList#getMessages()
   * @see #getResponseMessageList()
   * @generated
   */
  EReference getResponseMessageList_Messages();

  /**
   * Returns the meta object for the
   * '{@link com.devepos.adt.base.model.adtbase.IResponseMessageList#toStatus(java.lang.String, java.lang.String)
   * <em>To Status</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>To Status</em>' operation.
   * @see com.devepos.adt.base.model.adtbase.IResponseMessageList#toStatus(java.lang.String,
   *      java.lang.String)
   * @generated
   */
  EOperation getResponseMessageList__ToStatus__String_String();

  /**
   * Returns the meta object for enum
   * '{@link com.devepos.adt.base.model.adtbase.AdtPluginFeatureType <em>Adt Plugin Feature
   * Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Adt Plugin Feature Type</em>'.
   * @see com.devepos.adt.base.model.adtbase.AdtPluginFeatureType
   * @generated
   */
  EEnum getAdtPluginFeatureType();

  /**
   * Returns the meta object for enum
   * '{@link com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory <em>Adt Plugin Feature
   * Category</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Adt Plugin Feature Category</em>'.
   * @see com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory
   * @generated
   */
  EEnum getAdtPluginFeatureCategory();

  /**
   * Returns the meta object for enum '{@link com.devepos.adt.base.model.adtbase.MessageType
   * <em>Message Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Message Type</em>'.
   * @see com.devepos.adt.base.model.adtbase.MessageType
   * @generated
   */
  EEnum getMessageType();

  /**
   * Returns the meta object for data type
   * '{@link com.devepos.adt.base.plugin.features.IAdtPluginFeatures <em>IAdt Plugin
   * Features</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for data type '<em>IAdt Plugin Features</em>'.
   * @see com.devepos.adt.base.plugin.features.IAdtPluginFeatures
   * @model instanceClass="com.devepos.adt.base.plugin.features.IAdtPluginFeatures"
   * @generated
   */
  EDataType getIAdtPluginFeatures();

  /**
   * Returns the meta object for data type '{@link org.eclipse.core.runtime.IStatus
   * <em>IStatus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for data type '<em>IStatus</em>'.
   * @see org.eclipse.core.runtime.IStatus
   * @model instanceClass="org.eclipse.core.runtime.IStatus"
   * @generated
   */
  EDataType getIStatus();

  /**
   * Returns the factory that creates the instances of the model. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the factory that creates the instances of the model.
   * @generated
   */
  IAdtBaseFactory getAdtBaseFactory();

  /**
   * <!-- begin-user-doc --> Defines literals for the meta objects that represent
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
     * The meta object literal for the '{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef
     * <em>Adt Obj Ref</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.impl.AdtObjRef
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtObjRef()
     * @generated
     */
    EClass ADT_OBJ_REF = eINSTANCE.getAdtObjRef();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJ_REF__DESCRIPTION = eINSTANCE.getAdtObjRef_Description();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJ_REF__NAME = eINSTANCE.getAdtObjRef_Name();

    /**
     * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJ_REF__PACKAGE_NAME = eINSTANCE.getAdtObjRef_PackageName();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJ_REF__TYPE = eINSTANCE.getAdtObjRef_Type();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJ_REF__URI = eINSTANCE.getAdtObjRef_Uri();

    /**
     * The meta object literal for the '<em><b>Parent Uri</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJ_REF__PARENT_URI = eINSTANCE.getAdtObjRef_ParentUri();

    /**
     * The meta object literal for the '<em><b>Parent Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJ_REF__PARENT_NAME = eINSTANCE.getAdtObjRef_ParentName();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJ_REF__OWNER = eINSTANCE.getAdtObjRef_Owner();

    /**
     * The meta object literal for the '<em><b>Tadir Type</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJ_REF__TADIR_TYPE = eINSTANCE.getAdtObjRef_TadirType();

    /**
     * The meta object literal for the '{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRefList
     * <em>Adt Obj Ref List</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.impl.AdtObjRefList
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtObjRefList()
     * @generated
     */
    EClass ADT_OBJ_REF_LIST = eINSTANCE.getAdtObjRefList();

    /**
     * The meta object literal for the '<em><b>Object References</b></em>'
     * containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    EReference ADT_OBJ_REF_LIST__OBJECT_REFERENCES = eINSTANCE.getAdtObjRefList_ObjectReferences();

    /**
     * The meta object literal for the '{@link com.devepos.adt.base.model.adtbase.impl.User
     * <em>User</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.impl.User
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getUser()
     * @generated
     */
    EClass USER = eINSTANCE.getUser();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute USER__NAME = eINSTANCE.getUser_Name();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute USER__TEXT = eINSTANCE.getUser_Text();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeature <em>Adt Plugin
     * Feature</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.impl.AdtPluginFeature
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtPluginFeature()
     * @generated
     */
    EClass ADT_PLUGIN_FEATURE = eINSTANCE.getAdtPluginFeature();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_PLUGIN_FEATURE__NAME = eINSTANCE.getAdtPluginFeature_Name();

    /**
     * The meta object literal for the '<em><b>Endpoint</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_PLUGIN_FEATURE__ENDPOINT = eINSTANCE.getAdtPluginFeature_Endpoint();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_PLUGIN_FEATURE__TYPE = eINSTANCE.getAdtPluginFeature_Type();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_PLUGIN_FEATURE__DESCRIPTION = eINSTANCE.getAdtPluginFeature_Description();

    /**
     * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_PLUGIN_FEATURE__ENABLED = eINSTANCE.getAdtPluginFeature_Enabled();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_PLUGIN_FEATURE__CATEGORY = eINSTANCE.getAdtPluginFeature_Category();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeatureList <em>Adt
     * Plugin Feature List</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see com.devepos.adt.base.model.adtbase.impl.AdtPluginFeatureList
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtPluginFeatureList()
     * @generated
     */
    EClass ADT_PLUGIN_FEATURE_LIST = eINSTANCE.getAdtPluginFeatureList();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference ADT_PLUGIN_FEATURE_LIST__FEATURES = eINSTANCE.getAdtPluginFeatureList_Features();

    /**
     * The meta object literal for the '<em><b>Get Features By Endpoint</b></em>' operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EOperation ADT_PLUGIN_FEATURE_LIST___GET_FEATURES_BY_ENDPOINT__STRING = eINSTANCE
        .getAdtPluginFeatureList__GetFeaturesByEndpoint__String();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.base.model.adtbase.impl.ResponseMessage <em>Response Message</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.impl.ResponseMessage
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getResponseMessage()
     * @generated
     */
    EClass RESPONSE_MESSAGE = eINSTANCE.getResponseMessage();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute RESPONSE_MESSAGE__TYPE = eINSTANCE.getResponseMessage_Type();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute RESPONSE_MESSAGE__CONTENT = eINSTANCE.getResponseMessage_Content();

    /**
     * The meta object literal for the '<em><b>Occurrences</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute RESPONSE_MESSAGE__OCCURRENCES = eINSTANCE.getResponseMessage_Occurrences();

    /**
     * The meta object literal for the '<em><b>Get Status Type</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EOperation RESPONSE_MESSAGE___GET_STATUS_TYPE = eINSTANCE.getResponseMessage__GetStatusType();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.base.model.adtbase.impl.ResponseMessageList <em>Response Message
     * List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.impl.ResponseMessageList
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getResponseMessageList()
     * @generated
     */
    EClass RESPONSE_MESSAGE_LIST = eINSTANCE.getResponseMessageList();

    /**
     * The meta object literal for the '<em><b>Messages</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference RESPONSE_MESSAGE_LIST__MESSAGES = eINSTANCE.getResponseMessageList_Messages();

    /**
     * The meta object literal for the '<em><b>To Status</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EOperation RESPONSE_MESSAGE_LIST___TO_STATUS__STRING_STRING = eINSTANCE
        .getResponseMessageList__ToStatus__String_String();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.base.model.adtbase.AdtPluginFeatureType <em>Adt
     * Plugin Feature Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see com.devepos.adt.base.model.adtbase.AdtPluginFeatureType
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtPluginFeatureType()
     * @generated
     */
    EEnum ADT_PLUGIN_FEATURE_TYPE = eINSTANCE.getAdtPluginFeatureType();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory <em>Adt Plugin Feature
     * Category</em>}' enum.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getAdtPluginFeatureCategory()
     * @generated
     */
    EEnum ADT_PLUGIN_FEATURE_CATEGORY = eINSTANCE.getAdtPluginFeatureCategory();

    /**
     * The meta object literal for the '{@link com.devepos.adt.base.model.adtbase.MessageType
     * <em>Message Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.model.adtbase.MessageType
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getMessageType()
     * @generated
     */
    EEnum MESSAGE_TYPE = eINSTANCE.getMessageType();

    /**
     * The meta object literal for the '<em>IAdt Plugin Features</em>' data type.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.base.plugin.features.IAdtPluginFeatures
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getIAdtPluginFeatures()
     * @generated
     */
    EDataType IADT_PLUGIN_FEATURES = eINSTANCE.getIAdtPluginFeatures();

    /**
     * The meta object literal for the '<em>IStatus</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see org.eclipse.core.runtime.IStatus
     * @see com.devepos.adt.base.model.adtbase.impl.AdtBasePackage#getIStatus()
     * @generated
     */
    EDataType ISTATUS = eINSTANCE.getIStatus();

  }

} // IAdtBasePackage
