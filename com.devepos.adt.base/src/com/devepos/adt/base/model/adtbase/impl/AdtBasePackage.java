/**
 */
package com.devepos.adt.base.model.adtbase.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory;
import com.devepos.adt.base.model.adtbase.AdtPluginFeatureType;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeature;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;
import com.devepos.adt.base.model.adtbase.IResponseMessage;
import com.devepos.adt.base.model.adtbase.IResponseMessageList;
import com.devepos.adt.base.model.adtbase.IUser;
import com.devepos.adt.base.model.adtbase.MessageType;
import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class AdtBasePackage extends EPackageImpl implements IAdtBasePackage {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass adtObjRefEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass adtObjRefListEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass userEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass adtPluginFeatureEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass adtPluginFeatureListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass responseMessageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass responseMessageListEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum adtPluginFeatureTypeEEnum = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum adtPluginFeatureCategoryEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum messageTypeEEnum = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EDataType iAdtPluginFeaturesEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EDataType iStatusEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>
   * Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AdtBasePackage() {
    super(eNS_URI, IAdtBaseFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon
   * which it depends.
   *
   * <p>
   * This method is used to initialize {@link IAdtBasePackage#eINSTANCE} when that field is
   * accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain
   * the package.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static IAdtBasePackage init() {
    if (isInited) {
      return (IAdtBasePackage) EPackage.Registry.INSTANCE.getEPackage(IAdtBasePackage.eNS_URI);
    }

    // Obtain or create and register package
    Object registeredAdtBasePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    AdtBasePackage theAdtBasePackage = registeredAdtBasePackage instanceof AdtBasePackage
        ? (AdtBasePackage) registeredAdtBasePackage
        : new AdtBasePackage();

    isInited = true;

    // Initialize simple dependencies
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theAdtBasePackage.createPackageContents();

    // Initialize created meta-data
    theAdtBasePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAdtBasePackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(IAdtBasePackage.eNS_URI, theAdtBasePackage);
    return theAdtBasePackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getAdtObjRef() {
    return adtObjRefEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjRef_Description() {
    return (EAttribute) adtObjRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjRef_Name() {
    return (EAttribute) adtObjRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjRef_AlternativeName() {
    return (EAttribute) adtObjRefEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjRef_PackageName() {
    return (EAttribute) adtObjRefEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjRef_Type() {
    return (EAttribute) adtObjRefEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjRef_Uri() {
    return (EAttribute) adtObjRefEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjRef_ParentUri() {
    return (EAttribute) adtObjRefEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjRef_ParentName() {
    return (EAttribute) adtObjRefEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjRef_Owner() {
    return (EAttribute) adtObjRefEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EOperation getAdtObjRef__GetDisplayName() {
    return adtObjRefEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjRef_TadirType() {
    return (EAttribute) adtObjRefEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getAdtObjRefList() {
    return adtObjRefListEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getAdtObjRefList_ObjectReferences() {
    return (EReference) adtObjRefListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getUser() {
    return userEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getUser_Name() {
    return (EAttribute) userEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getUser_Text() {
    return (EAttribute) userEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getAdtPluginFeature() {
    return adtPluginFeatureEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtPluginFeature_Name() {
    return (EAttribute) adtPluginFeatureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtPluginFeature_Endpoint() {
    return (EAttribute) adtPluginFeatureEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtPluginFeature_Type() {
    return (EAttribute) adtPluginFeatureEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtPluginFeature_Description() {
    return (EAttribute) adtPluginFeatureEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtPluginFeature_Enabled() {
    return (EAttribute) adtPluginFeatureEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtPluginFeature_Category() {
    return (EAttribute) adtPluginFeatureEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getAdtPluginFeatureList() {
    return adtPluginFeatureListEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getAdtPluginFeatureList_Features() {
    return (EReference) adtPluginFeatureListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EOperation getAdtPluginFeatureList__GetFeaturesByEndpoint__String() {
    return adtPluginFeatureListEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getResponseMessage() {
    return responseMessageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getResponseMessage_Type() {
    return (EAttribute) responseMessageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getResponseMessage_Content() {
    return (EAttribute) responseMessageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getResponseMessage_Occurrences() {
    return (EAttribute) responseMessageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EOperation getResponseMessage__GetStatusType() {
    return responseMessageEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getResponseMessageList() {
    return responseMessageListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getResponseMessageList_Messages() {
    return (EReference) responseMessageListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EOperation getResponseMessageList__ToStatus__String_String() {
    return responseMessageListEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getAdtPluginFeatureType() {
    return adtPluginFeatureTypeEEnum;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getAdtPluginFeatureCategory() {
    return adtPluginFeatureCategoryEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getMessageType() {
    return messageTypeEEnum;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EDataType getIAdtPluginFeatures() {
    return iAdtPluginFeaturesEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EDataType getIStatus() {
    return iStatusEDataType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAdtBaseFactory getAdtBaseFactory() {
    return (IAdtBaseFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package. This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) {
      return;
    }
    isCreated = true;

    // Create classes and their features
    adtObjRefEClass = createEClass(ADT_OBJ_REF);
    createEAttribute(adtObjRefEClass, ADT_OBJ_REF__DESCRIPTION);
    createEAttribute(adtObjRefEClass, ADT_OBJ_REF__NAME);
    createEAttribute(adtObjRefEClass, ADT_OBJ_REF__ALTERNATIVE_NAME);
    createEAttribute(adtObjRefEClass, ADT_OBJ_REF__PACKAGE_NAME);
    createEAttribute(adtObjRefEClass, ADT_OBJ_REF__TYPE);
    createEAttribute(adtObjRefEClass, ADT_OBJ_REF__TADIR_TYPE);
    createEAttribute(adtObjRefEClass, ADT_OBJ_REF__URI);
    createEAttribute(adtObjRefEClass, ADT_OBJ_REF__PARENT_URI);
    createEAttribute(adtObjRefEClass, ADT_OBJ_REF__PARENT_NAME);
    createEAttribute(adtObjRefEClass, ADT_OBJ_REF__OWNER);
    createEOperation(adtObjRefEClass, ADT_OBJ_REF___GET_DISPLAY_NAME);

    adtObjRefListEClass = createEClass(ADT_OBJ_REF_LIST);
    createEReference(adtObjRefListEClass, ADT_OBJ_REF_LIST__OBJECT_REFERENCES);

    userEClass = createEClass(USER);
    createEAttribute(userEClass, USER__NAME);
    createEAttribute(userEClass, USER__TEXT);

    adtPluginFeatureEClass = createEClass(ADT_PLUGIN_FEATURE);
    createEAttribute(adtPluginFeatureEClass, ADT_PLUGIN_FEATURE__NAME);
    createEAttribute(adtPluginFeatureEClass, ADT_PLUGIN_FEATURE__ENDPOINT);
    createEAttribute(adtPluginFeatureEClass, ADT_PLUGIN_FEATURE__TYPE);
    createEAttribute(adtPluginFeatureEClass, ADT_PLUGIN_FEATURE__ENABLED);
    createEAttribute(adtPluginFeatureEClass, ADT_PLUGIN_FEATURE__CATEGORY);
    createEAttribute(adtPluginFeatureEClass, ADT_PLUGIN_FEATURE__DESCRIPTION);

    adtPluginFeatureListEClass = createEClass(ADT_PLUGIN_FEATURE_LIST);
    createEReference(adtPluginFeatureListEClass, ADT_PLUGIN_FEATURE_LIST__FEATURES);
    createEOperation(adtPluginFeatureListEClass,
        ADT_PLUGIN_FEATURE_LIST___GET_FEATURES_BY_ENDPOINT__STRING);

    responseMessageEClass = createEClass(RESPONSE_MESSAGE);
    createEAttribute(responseMessageEClass, RESPONSE_MESSAGE__TYPE);
    createEAttribute(responseMessageEClass, RESPONSE_MESSAGE__CONTENT);
    createEAttribute(responseMessageEClass, RESPONSE_MESSAGE__OCCURRENCES);
    createEOperation(responseMessageEClass, RESPONSE_MESSAGE___GET_STATUS_TYPE);

    responseMessageListEClass = createEClass(RESPONSE_MESSAGE_LIST);
    createEReference(responseMessageListEClass, RESPONSE_MESSAGE_LIST__MESSAGES);
    createEOperation(responseMessageListEClass, RESPONSE_MESSAGE_LIST___TO_STATUS__STRING_STRING);

    // Create enums
    adtPluginFeatureTypeEEnum = createEEnum(ADT_PLUGIN_FEATURE_TYPE);
    adtPluginFeatureCategoryEEnum = createEEnum(ADT_PLUGIN_FEATURE_CATEGORY);
    messageTypeEEnum = createEEnum(MESSAGE_TYPE);

    // Create data types
    iAdtPluginFeaturesEDataType = createEDataType(IADT_PLUGIN_FEATURES);
    iStatusEDataType = createEDataType(ISTATUS);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This method is
   * guarded to have no affect on any invocation but its first. <!--
   * begin-user-doc --> <!-- end-user-doc -->
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
    initEClass(adtObjRefEClass, IAdtObjRef.class, "AdtObjRef", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAdtObjRef_Description(), theXMLTypePackage.getString(), "description", null,
        0, 1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjRef_Name(), theXMLTypePackage.getString(), "name", null, 0, 1,
        IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjRef_AlternativeName(), theXMLTypePackage.getString(), "alternativeName",
        null, 0, 1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjRef_PackageName(), theXMLTypePackage.getString(), "packageName", null,
        0, 1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjRef_Type(), theXMLTypePackage.getString(), "type", null, 0, 1,
        IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjRef_TadirType(), theXMLTypePackage.getString(), "tadirType", null, 0, 1,
        IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjRef_Uri(), theXMLTypePackage.getAnyURI(), "uri", null, 0, 1,
        IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjRef_ParentUri(), theXMLTypePackage.getAnyURI(), "parentUri", null, 0, 1,
        IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjRef_ParentName(), theXMLTypePackage.getString(), "parentName", null, 0,
        1, IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjRef_Owner(), theXMLTypePackage.getString(), "owner", null, 0, 1,
        IAdtObjRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getAdtObjRef__GetDisplayName(), theXMLTypePackage.getString(), "getDisplayName",
        0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(adtObjRefListEClass, IAdtObjRefList.class, "AdtObjRefList", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdtObjRefList_ObjectReferences(), getAdtObjRef(), null, "objectReferences",
        null, 1, -1, IAdtObjRefList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(userEClass, IUser.class, "User", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUser_Name(), ecorePackage.getEString(), "name", null, 0, 1, IUser.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getUser_Text(), ecorePackage.getEString(), "text", null, 0, 1, IUser.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(adtPluginFeatureEClass, IAdtPluginFeature.class, "AdtPluginFeature", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAdtPluginFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        IAdtPluginFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtPluginFeature_Endpoint(), ecorePackage.getEString(), "endpoint", null, 0,
        1, IAdtPluginFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtPluginFeature_Type(), getAdtPluginFeatureType(), "type", null, 0, 1,
        IAdtPluginFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtPluginFeature_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1,
        IAdtPluginFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtPluginFeature_Category(), getAdtPluginFeatureCategory(), "category",
        "NoCategory", 0, 1, IAdtPluginFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtPluginFeature_Description(), ecorePackage.getEString(), "description",
        null, 0, 1, IAdtPluginFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(adtPluginFeatureListEClass, IAdtPluginFeatureList.class, "AdtPluginFeatureList",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdtPluginFeatureList_Features(), getAdtPluginFeature(), null, "features",
        null, 0, -1, IAdtPluginFeatureList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    EOperation op = initEOperation(getAdtPluginFeatureList__GetFeaturesByEndpoint__String(),
        getIAdtPluginFeatures(), "getFeaturesByEndpoint", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "endpoint", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(responseMessageEClass, IResponseMessage.class, "ResponseMessage", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResponseMessage_Type(), getMessageType(), "type", null, 0, 1,
        IResponseMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResponseMessage_Content(), theXMLTypePackage.getString(), "content", null, 0,
        1, IResponseMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResponseMessage_Occurrences(), theXMLTypePackage.getInt(), "occurrences",
        null, 0, 1, IResponseMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getResponseMessage__GetStatusType(), theXMLTypePackage.getInt(), "getStatusType",
        0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(responseMessageListEClass, IResponseMessageList.class, "ResponseMessageList",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResponseMessageList_Messages(), getResponseMessage(), null, "messages", null,
        0, -1, IResponseMessageList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = initEOperation(getResponseMessageList__ToStatus__String_String(), getIStatus(), "toStatus",
        0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theXMLTypePackage.getString(), "pluginId", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theXMLTypePackage.getString(), "message", 0, 1, IS_UNIQUE, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(adtPluginFeatureTypeEEnum, AdtPluginFeatureType.class, "AdtPluginFeatureType");
    addEEnumLiteral(adtPluginFeatureTypeEEnum, AdtPluginFeatureType.BOOLEAN);
    addEEnumLiteral(adtPluginFeatureTypeEEnum, AdtPluginFeatureType.STRING);

    initEEnum(adtPluginFeatureCategoryEEnum, AdtPluginFeatureCategory.class,
        "AdtPluginFeatureCategory");
    addEEnumLiteral(adtPluginFeatureCategoryEEnum, AdtPluginFeatureCategory.NO_CATEGORY);
    addEEnumLiteral(adtPluginFeatureCategoryEEnum, AdtPluginFeatureCategory.REQUEST_ATTRIBUTE);
    addEEnumLiteral(adtPluginFeatureCategoryEEnum, AdtPluginFeatureCategory.RESPONSE_ATTRIBUTE);
    addEEnumLiteral(adtPluginFeatureCategoryEEnum, AdtPluginFeatureCategory.URI_PARAMETER);

    initEEnum(messageTypeEEnum, MessageType.class, "MessageType");
    addEEnumLiteral(messageTypeEEnum, MessageType.NONE);
    addEEnumLiteral(messageTypeEEnum, MessageType.INFO);
    addEEnumLiteral(messageTypeEEnum, MessageType.WARNING);
    addEEnumLiteral(messageTypeEEnum, MessageType.ERROR);

    // Initialize data types
    initEDataType(iAdtPluginFeaturesEDataType, IAdtPluginFeatures.class, "IAdtPluginFeatures",
        IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iStatusEDataType, IStatus.class, "IStatus", IS_SERIALIZABLE,
        !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for
   * <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void createExtendedMetaDataAnnotations() {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
    addAnnotation(adtObjRefEClass, source, new String[] { "name", "adtObjRef", "kind",
        "elementOnly" });
    addAnnotation(getAdtObjRef_Description(), source, new String[] { "kind", "attribute", "name",
        "description", "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjRef_Name(), source, new String[] { "kind", "attribute", "name", "name",
        "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjRef_AlternativeName(), source, new String[] { "kind", "attribute",
        "name", "alternativeName", "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjRef_PackageName(), source, new String[] { "kind", "attribute", "name",
        "packageName", "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjRef_Type(), source, new String[] { "kind", "attribute", "name", "type",
        "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjRef_TadirType(), source, new String[] { "kind", "attribute", "name",
        "tadirType", "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjRef_Uri(), source, new String[] { "kind", "attribute", "name", "uri",
        "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjRef_ParentUri(), source, new String[] { "kind", "attribute", "name",
        "parentUri", "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjRef_ParentName(), source, new String[] { "kind", "attribute", "name",
        "parentName", "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjRef_Owner(), source, new String[] { "kind", "attribute", "name", "owner",
        "namespace", "##targetNamespace" });
    addAnnotation(adtObjRefListEClass, source, new String[] { "name", "adtObjRefs", "kind",
        "elementOnly" });
    addAnnotation(getAdtObjRefList_ObjectReferences(), source, new String[] { "kind", "element",
        "name", "adtObjRef", "namespace", "##targetNamespace" });
    addAnnotation(userEClass, source, new String[] { "name", "user", "kind", "elementOnly" });
    addAnnotation(getUser_Name(), source, new String[] { "kind", "attribute", "name", "name",
        "namespace", "##targetNamespace" });
    addAnnotation(getUser_Text(), source, new String[] { "kind", "attribute", "name", "text",
        "namespace", "##targetNamespace" });
    addAnnotation(adtPluginFeatureEClass, source, new String[] { "name", "pluginFeature", "kind",
        "elementOnly" });
    addAnnotation(getAdtPluginFeature_Name(), source, new String[] { "kind", "attribute", "name",
        "name", "namespace", "##targetNamespace" });
    addAnnotation(getAdtPluginFeature_Endpoint(), source, new String[] { "kind", "attribute",
        "name", "endpoint", "namespace", "##targetNamespace" });
    addAnnotation(getAdtPluginFeature_Type(), source, new String[] { "kind", "attribute", "name",
        "type", "namespace", "##targetNamespace" });
    addAnnotation(getAdtPluginFeature_Enabled(), source, new String[] { "kind", "attribute", "name",
        "enabled", "namespace", "##targetNamespace" });
    addAnnotation(getAdtPluginFeature_Category(), source, new String[] { "kind", "attribute",
        "name", "category", "namespace", "##targetNamespace" });
    addAnnotation(getAdtPluginFeature_Description(), source, new String[] { "kind", "attribute",
        "name", "description", "namespace", "##targetNamespace" });
    addAnnotation(adtPluginFeatureListEClass, source, new String[] { "name", "pluginFeatures",
        "kind", "elementOnly" });
    addAnnotation(getAdtPluginFeatureList_Features(), source, new String[] { "kind", "element",
        "name", "pluginFeature", "namespace", "##targetNamespace" });
    addAnnotation(responseMessageEClass, source, new String[] { "kind", "elementOnly", "name",
        "responseMessage" });
    addAnnotation(getResponseMessage_Type(), source, new String[] { "kind", "attribute", "name",
        "type", "namespace", "##targetNamespace" });
    addAnnotation(getResponseMessage_Content(), source, new String[] { "kind", "attribute", "name",
        "content", "namespace", "##targetNamespace" });
    addAnnotation(getResponseMessage_Occurrences(), source, new String[] { "kind", "attribute",
        "name", "occurrences", "namespace", "##targetNamespace" });
    addAnnotation(responseMessageListEClass, source, new String[] { "kind", "elementOnly", "name",
        "responseMessages" });
    addAnnotation(getResponseMessageList_Messages(), source, new String[] { "kind", "element",
        "name", "responseMessage", "namespace", "##targetNamespace" });
  }

} // AdtBasePackage
