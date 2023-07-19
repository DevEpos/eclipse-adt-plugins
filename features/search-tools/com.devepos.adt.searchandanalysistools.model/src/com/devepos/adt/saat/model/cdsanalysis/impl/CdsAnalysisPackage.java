/**
 */
package com.devepos.adt.saat.model.cdsanalysis.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget;
import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisFactory;
import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult;
import com.devepos.adt.saat.model.cdsanalysis.SqlRelation;
import com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CdsAnalysisPackage extends EPackageImpl implements ICdsAnalysisPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass cdsUsedEntitiesResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass cdsUsedEntityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass cdsUsedEntityInformationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass topDownAnalysisResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass topDownAnalysisEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass cdsQueryNavTargetsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass entityFieldInfoResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass entityFieldInfoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum sqlRelationEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum topDownAnalysisEntryTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum cdsQueryNavTargetEEnum = null;

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
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CdsAnalysisPackage() {
    super(eNS_URI, ICdsAnalysisFactory.eINSTANCE);
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
   * This method is used to initialize {@link ICdsAnalysisPackage#eINSTANCE} when that field is
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
  public static ICdsAnalysisPackage init() {
    if (isInited) {
      return (ICdsAnalysisPackage) EPackage.Registry.INSTANCE.getEPackage(
          ICdsAnalysisPackage.eNS_URI);
    }

    // Obtain or create and register package
    Object registeredCdsAnalysisPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    CdsAnalysisPackage theCdsAnalysisPackage = registeredCdsAnalysisPackage instanceof CdsAnalysisPackage
        ? (CdsAnalysisPackage) registeredCdsAnalysisPackage
        : new CdsAnalysisPackage();

    isInited = true;

    // Initialize simple dependencies
    IAdtBasePackage.eINSTANCE.eClass();
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theCdsAnalysisPackage.createPackageContents();

    // Initialize created meta-data
    theCdsAnalysisPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCdsAnalysisPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ICdsAnalysisPackage.eNS_URI, theCdsAnalysisPackage);
    return theCdsAnalysisPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getCdsUsedEntitiesResult() {
    return cdsUsedEntitiesResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getCdsUsedEntitiesResult_SourceEntity() {
    return (EReference) cdsUsedEntitiesResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getCdsUsedEntitiesResult_UsedEntities() {
    return (EReference) cdsUsedEntitiesResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getCdsUsedEntity() {
    return cdsUsedEntityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getCdsUsedEntity_EntityRef() {
    return (EReference) cdsUsedEntityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getCdsUsedEntity_UsageInformation() {
    return (EReference) cdsUsedEntityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getCdsUsedEntityInformation() {
    return cdsUsedEntityInformationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCdsUsedEntityInformation_Occurrence() {
    return (EAttribute) cdsUsedEntityInformationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCdsUsedEntityInformation_EntityCount() {
    return (EAttribute) cdsUsedEntityInformationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCdsUsedEntityInformation_JoinCount() {
    return (EAttribute) cdsUsedEntityInformationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCdsUsedEntityInformation_UnionCount() {
    return (EAttribute) cdsUsedEntityInformationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTopDownAnalysisResult() {
    return topDownAnalysisResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTopDownAnalysisResult_SourceEntity() {
    return (EReference) topDownAnalysisResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTopDownAnalysisResult_Entries() {
    return (EReference) topDownAnalysisResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTopDownAnalysisEntry() {
    return topDownAnalysisEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTopDownAnalysisEntry_EntryType() {
    return (EAttribute) topDownAnalysisEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTopDownAnalysisEntry_DdlSourceType() {
    return (EAttribute) topDownAnalysisEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTopDownAnalysisEntry_SqlRelation() {
    return (EAttribute) topDownAnalysisEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTopDownAnalysisEntry_Alias() {
    return (EAttribute) topDownAnalysisEntryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTopDownAnalysisEntry_EntityRef() {
    return (EReference) topDownAnalysisEntryEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTopDownAnalysisEntry_Children() {
    return (EReference) topDownAnalysisEntryEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getCdsQueryNavTargets() {
    return cdsQueryNavTargetsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCdsQueryNavTargets_NavigationTargets() {
    return (EAttribute) cdsQueryNavTargetsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getEntityFieldInfoResult() {
    return entityFieldInfoResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getEntityFieldInfoResult_SourceFieldInfo() {
    return (EReference) entityFieldInfoResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getEntityFieldInfoResult_FieldInfos() {
    return (EReference) entityFieldInfoResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getEntityFieldInfo() {
    return entityFieldInfoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getEntityFieldInfo_FieldName() {
    return (EAttribute) entityFieldInfoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getEntityFieldInfo_EntityName() {
    return (EAttribute) entityFieldInfoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getEntityFieldInfo_AltEntityName() {
    return (EAttribute) entityFieldInfoEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getEntityFieldInfo_SourceType() {
    return (EAttribute) entityFieldInfoEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getEntityFieldInfo_Type() {
    return (EAttribute) entityFieldInfoEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getEntityFieldInfo_Uri() {
    return (EAttribute) entityFieldInfoEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getEntityFieldInfo_ApiState() {
    return (EAttribute) entityFieldInfoEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getEntityFieldInfo_Description() {
    return (EAttribute) entityFieldInfoEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getEntityFieldInfo_Key() {
    return (EAttribute) entityFieldInfoEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getEntityFieldInfo_Calculated() {
    return (EAttribute) entityFieldInfoEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getEntityFieldInfo_Children() {
    return (EReference) entityFieldInfoEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getSqlRelation() {
    return sqlRelationEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getTopDownAnalysisEntryType() {
    return topDownAnalysisEntryTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getCdsQueryNavTarget() {
    return cdsQueryNavTargetEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ICdsAnalysisFactory getCdsAnalysisFactory() {
    return (ICdsAnalysisFactory) getEFactoryInstance();
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
    cdsUsedEntitiesResultEClass = createEClass(CDS_USED_ENTITIES_RESULT);
    createEReference(cdsUsedEntitiesResultEClass, CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY);
    createEReference(cdsUsedEntitiesResultEClass, CDS_USED_ENTITIES_RESULT__USED_ENTITIES);

    cdsUsedEntityEClass = createEClass(CDS_USED_ENTITY);
    createEReference(cdsUsedEntityEClass, CDS_USED_ENTITY__ENTITY_REF);
    createEReference(cdsUsedEntityEClass, CDS_USED_ENTITY__USAGE_INFORMATION);

    cdsUsedEntityInformationEClass = createEClass(CDS_USED_ENTITY_INFORMATION);
    createEAttribute(cdsUsedEntityInformationEClass, CDS_USED_ENTITY_INFORMATION__OCCURRENCE);
    createEAttribute(cdsUsedEntityInformationEClass, CDS_USED_ENTITY_INFORMATION__ENTITY_COUNT);
    createEAttribute(cdsUsedEntityInformationEClass, CDS_USED_ENTITY_INFORMATION__JOIN_COUNT);
    createEAttribute(cdsUsedEntityInformationEClass, CDS_USED_ENTITY_INFORMATION__UNION_COUNT);

    topDownAnalysisResultEClass = createEClass(TOP_DOWN_ANALYSIS_RESULT);
    createEReference(topDownAnalysisResultEClass, TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY);
    createEReference(topDownAnalysisResultEClass, TOP_DOWN_ANALYSIS_RESULT__ENTRIES);

    topDownAnalysisEntryEClass = createEClass(TOP_DOWN_ANALYSIS_ENTRY);
    createEAttribute(topDownAnalysisEntryEClass, TOP_DOWN_ANALYSIS_ENTRY__ENTRY_TYPE);
    createEAttribute(topDownAnalysisEntryEClass, TOP_DOWN_ANALYSIS_ENTRY__DDL_SOURCE_TYPE);
    createEAttribute(topDownAnalysisEntryEClass, TOP_DOWN_ANALYSIS_ENTRY__SQL_RELATION);
    createEAttribute(topDownAnalysisEntryEClass, TOP_DOWN_ANALYSIS_ENTRY__ALIAS);
    createEReference(topDownAnalysisEntryEClass, TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF);
    createEReference(topDownAnalysisEntryEClass, TOP_DOWN_ANALYSIS_ENTRY__CHILDREN);

    cdsQueryNavTargetsEClass = createEClass(CDS_QUERY_NAV_TARGETS);
    createEAttribute(cdsQueryNavTargetsEClass, CDS_QUERY_NAV_TARGETS__NAVIGATION_TARGETS);

    entityFieldInfoEClass = createEClass(ENTITY_FIELD_INFO);
    createEAttribute(entityFieldInfoEClass, ENTITY_FIELD_INFO__FIELD_NAME);
    createEAttribute(entityFieldInfoEClass, ENTITY_FIELD_INFO__ENTITY_NAME);
    createEAttribute(entityFieldInfoEClass, ENTITY_FIELD_INFO__ALT_ENTITY_NAME);
    createEAttribute(entityFieldInfoEClass, ENTITY_FIELD_INFO__SOURCE_TYPE);
    createEAttribute(entityFieldInfoEClass, ENTITY_FIELD_INFO__TYPE);
    createEAttribute(entityFieldInfoEClass, ENTITY_FIELD_INFO__URI);
    createEAttribute(entityFieldInfoEClass, ENTITY_FIELD_INFO__API_STATE);
    createEAttribute(entityFieldInfoEClass, ENTITY_FIELD_INFO__DESCRIPTION);
    createEAttribute(entityFieldInfoEClass, ENTITY_FIELD_INFO__KEY);
    createEAttribute(entityFieldInfoEClass, ENTITY_FIELD_INFO__CALCULATED);
    createEReference(entityFieldInfoEClass, ENTITY_FIELD_INFO__CHILDREN);

    entityFieldInfoResultEClass = createEClass(ENTITY_FIELD_INFO_RESULT);
    createEReference(entityFieldInfoResultEClass, ENTITY_FIELD_INFO_RESULT__SOURCE_FIELD_INFO);
    createEReference(entityFieldInfoResultEClass, ENTITY_FIELD_INFO_RESULT__FIELD_INFOS);

    // Create enums
    sqlRelationEEnum = createEEnum(SQL_RELATION);
    topDownAnalysisEntryTypeEEnum = createEEnum(TOP_DOWN_ANALYSIS_ENTRY_TYPE);
    cdsQueryNavTargetEEnum = createEEnum(CDS_QUERY_NAV_TARGET);
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
    IAdtBasePackage theAdtBasePackage = (IAdtBasePackage) EPackage.Registry.INSTANCE.getEPackage(
        IAdtBasePackage.eNS_URI);
    XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE.getEPackage(
        XMLTypePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(cdsUsedEntitiesResultEClass, ICdsUsedEntitiesResult.class, "CdsUsedEntitiesResult",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCdsUsedEntitiesResult_SourceEntity(), theAdtBasePackage.getAdtObjRef(), null,
        "sourceEntity", null, 0, 1, ICdsUsedEntitiesResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getCdsUsedEntitiesResult_UsedEntities(), getCdsUsedEntity(), null,
        "usedEntities", null, 0, -1, ICdsUsedEntitiesResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(cdsUsedEntityEClass, ICdsUsedEntity.class, "CdsUsedEntity", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCdsUsedEntity_EntityRef(), theAdtBasePackage.getAdtObjRef(), null,
        "entityRef", null, 0, 1, ICdsUsedEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCdsUsedEntity_UsageInformation(), getCdsUsedEntityInformation(), null,
        "usageInformation", null, 0, 1, ICdsUsedEntity.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(cdsUsedEntityInformationEClass, ICdsUsedEntityInformation.class,
        "CdsUsedEntityInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCdsUsedEntityInformation_Occurrence(), ecorePackage.getEInt(), "occurrence",
        null, 0, 1, ICdsUsedEntityInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCdsUsedEntityInformation_EntityCount(), ecorePackage.getEInt(), "entityCount",
        null, 0, 1, ICdsUsedEntityInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCdsUsedEntityInformation_JoinCount(), ecorePackage.getEInt(), "joinCount",
        null, 0, 1, ICdsUsedEntityInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCdsUsedEntityInformation_UnionCount(), ecorePackage.getEInt(), "unionCount",
        null, 0, 1, ICdsUsedEntityInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(topDownAnalysisResultEClass, ITopDownAnalysisResult.class, "TopDownAnalysisResult",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTopDownAnalysisResult_SourceEntity(), theAdtBasePackage.getAdtObjRef(), null,
        "sourceEntity", null, 0, 1, ITopDownAnalysisResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getTopDownAnalysisResult_Entries(), getTopDownAnalysisEntry(), null, "entries",
        null, 0, -1, ITopDownAnalysisResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(topDownAnalysisEntryEClass, ITopDownAnalysisEntry.class, "TopDownAnalysisEntry",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTopDownAnalysisEntry_EntryType(), getTopDownAnalysisEntryType(), "entryType",
        null, 0, 1, ITopDownAnalysisEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTopDownAnalysisEntry_DdlSourceType(), theXMLTypePackage.getString(),
        "ddlSourceType", null, 0, 1, ITopDownAnalysisEntry.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTopDownAnalysisEntry_SqlRelation(), getSqlRelation(), "sqlRelation", null, 0,
        1, ITopDownAnalysisEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTopDownAnalysisEntry_Alias(), theXMLTypePackage.getString(), "alias", null, 0,
        1, ITopDownAnalysisEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTopDownAnalysisEntry_EntityRef(), theAdtBasePackage.getAdtObjRef(), null,
        "entityRef", null, 0, 1, ITopDownAnalysisEntry.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getTopDownAnalysisEntry_Children(), getTopDownAnalysisEntry(), null, "children",
        null, 0, -1, ITopDownAnalysisEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cdsQueryNavTargetsEClass, ICdsQueryNavTargets.class, "CdsQueryNavTargets",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCdsQueryNavTargets_NavigationTargets(), getCdsQueryNavTarget(),
        "navigationTargets", null, 0, -1, ICdsQueryNavTargets.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(entityFieldInfoEClass, IEntityFieldInfo.class, "EntityFieldInfo", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEntityFieldInfo_FieldName(), theXMLTypePackage.getString(), "fieldName", null,
        0, 1, IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntityFieldInfo_EntityName(), theXMLTypePackage.getString(), "entityName",
        null, 0, 1, IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntityFieldInfo_AltEntityName(), theXMLTypePackage.getString(),
        "altEntityName", null, 0, 1, IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntityFieldInfo_SourceType(), theXMLTypePackage.getString(), "sourceType",
        null, 0, 1, IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntityFieldInfo_Type(), theXMLTypePackage.getString(), "type", null, 0, 1,
        IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntityFieldInfo_Uri(), theXMLTypePackage.getString(), "uri", null, 0, 1,
        IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntityFieldInfo_ApiState(), theXMLTypePackage.getString(), "apiState", null,
        0, 1, IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntityFieldInfo_Description(), theXMLTypePackage.getString(), "description",
        null, 0, 1, IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntityFieldInfo_Key(), theXMLTypePackage.getBoolean(), "key", null, 0, 1,
        IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntityFieldInfo_Calculated(), theXMLTypePackage.getBoolean(), "calculated",
        null, 0, 1, IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEntityFieldInfo_Children(), getEntityFieldInfo(), null, "children", null, 0,
        -1, IEntityFieldInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(entityFieldInfoResultEClass, IEntityFieldInfoResult.class, "EntityFieldInfoResult",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEntityFieldInfoResult_SourceFieldInfo(), getEntityFieldInfo(), null,
        "sourceFieldInfo", null, 0, 1, IEntityFieldInfoResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getEntityFieldInfoResult_FieldInfos(), getEntityFieldInfo(), null, "fieldInfos",
        null, 0, -1, IEntityFieldInfoResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(sqlRelationEEnum, SqlRelation.class, "SqlRelation");
    addEEnumLiteral(sqlRelationEEnum, SqlRelation.UNSPECIFIED);
    addEEnumLiteral(sqlRelationEEnum, SqlRelation.FROM);
    addEEnumLiteral(sqlRelationEEnum, SqlRelation.ASSOCIATION);
    addEEnumLiteral(sqlRelationEEnum, SqlRelation.INNER_JOIN);
    addEEnumLiteral(sqlRelationEEnum, SqlRelation.LEFT_OUTER_JOIN);
    addEEnumLiteral(sqlRelationEEnum, SqlRelation.RIGHT_OUTER_JOIN);
    addEEnumLiteral(sqlRelationEEnum, SqlRelation.FULL_OUTER_JOIN);
    addEEnumLiteral(sqlRelationEEnum, SqlRelation.CROSS_JOIN);

    initEEnum(topDownAnalysisEntryTypeEEnum, TopDownAnalysisEntryType.class,
        "TopDownAnalysisEntryType");
    addEEnumLiteral(topDownAnalysisEntryTypeEEnum, TopDownAnalysisEntryType.UNSPECIFIED);
    addEEnumLiteral(topDownAnalysisEntryTypeEEnum, TopDownAnalysisEntryType.RESULT);
    addEEnumLiteral(topDownAnalysisEntryTypeEEnum, TopDownAnalysisEntryType.UNION);
    addEEnumLiteral(topDownAnalysisEntryTypeEEnum, TopDownAnalysisEntryType.UNION_ALL);
    addEEnumLiteral(topDownAnalysisEntryTypeEEnum, TopDownAnalysisEntryType.ASSOCIATIONS);
    addEEnumLiteral(topDownAnalysisEntryTypeEEnum, TopDownAnalysisEntryType.ENTITY);
    addEEnumLiteral(topDownAnalysisEntryTypeEEnum, TopDownAnalysisEntryType.SELECT);

    initEEnum(cdsQueryNavTargetEEnum, CdsQueryNavTarget.class, "CdsQueryNavTarget");
    addEEnumLiteral(cdsQueryNavTargetEEnum, CdsQueryNavTarget.EXCEL);
    addEEnumLiteral(cdsQueryNavTargetEEnum, CdsQueryNavTarget.QUERY_MONITOR);

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
    addAnnotation(cdsUsedEntitiesResultEClass, source, new String[] { "kind", "elementOnly", "name",
        "usedEntitiesResult" });
    addAnnotation(getCdsUsedEntitiesResult_SourceEntity(), source, new String[] { "kind", "element",
        "namespace", "http://www.devepos.com/adt/base", "name", "adtObjRef" });
    addAnnotation(getCdsUsedEntitiesResult_UsedEntities(), source, new String[] { "kind", "element",
        "namespace", "##targetNamespace", "name", "usedEntity" });
    addAnnotation(cdsUsedEntityEClass, source, new String[] { "kind", "elementOnly", "name",
        "usedEntity" });
    addAnnotation(getCdsUsedEntity_EntityRef(), source, new String[] { "kind", "element",
        "namespace", "http://www.devepos.com/adt/base", "name", "adtObjRef" });
    addAnnotation(getCdsUsedEntity_UsageInformation(), source, new String[] { "kind", "element",
        "namespace", "##targetNamespace" });
    addAnnotation(cdsUsedEntityInformationEClass, source, new String[] { "kind", "elementOnly",
        "name", "usageInformation" });
    addAnnotation(getCdsUsedEntityInformation_Occurrence(), source, new String[] { "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getCdsUsedEntityInformation_EntityCount(), source, new String[] { "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getCdsUsedEntityInformation_JoinCount(), source, new String[] { "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getCdsUsedEntityInformation_UnionCount(), source, new String[] { "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(topDownAnalysisResultEClass, source, new String[] { "kind", "elementOnly", "name",
        "topDownResult" });
    addAnnotation(getTopDownAnalysisResult_SourceEntity(), source, new String[] { "kind", "element",
        "namespace", "http://www.devepos.com/adt/base", "name", "adtObjRef" });
    addAnnotation(getTopDownAnalysisResult_Entries(), source, new String[] { "kind", "element",
        "namespace", "##targetNamespace", "name", "resultEntry" });
    addAnnotation(topDownAnalysisEntryEClass, source, new String[] { "kind", "elementOnly", "name",
        "resultEntry" });
    addAnnotation(getTopDownAnalysisEntry_EntryType(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getTopDownAnalysisEntry_DdlSourceType(), source, new String[] { "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getTopDownAnalysisEntry_SqlRelation(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getTopDownAnalysisEntry_Alias(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getTopDownAnalysisEntry_EntityRef(), source, new String[] { "kind", "element",
        "namespace", "http://www.devepos.com/adt/base", "name", "adtObjRef" });
    addAnnotation(getTopDownAnalysisEntry_Children(), source, new String[] { "kind", "element",
        "namespace", "##targetNamespace", "name", "resultEntry" });
    addAnnotation(cdsQueryNavTargetsEClass, source, new String[] { "kind", "elementOnly", "name",
        "navigationTargets" });
    addAnnotation(getCdsQueryNavTargets_NavigationTargets(), source, new String[] { "kind",
        "element", "namespace", "##targetNamespace", "name", "navigationTarget" });
    addAnnotation(entityFieldInfoEClass, source, new String[] { "kind", "elementOnly", "name",
        "entityFieldInfo" });
    addAnnotation(getEntityFieldInfo_FieldName(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getEntityFieldInfo_EntityName(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getEntityFieldInfo_AltEntityName(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getEntityFieldInfo_SourceType(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getEntityFieldInfo_Type(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getEntityFieldInfo_Uri(), source, new String[] { "kind", "attribute", "namespace",
        "##targetNamespace" });
    addAnnotation(getEntityFieldInfo_ApiState(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getEntityFieldInfo_Description(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getEntityFieldInfo_Key(), source, new String[] { "kind", "attribute", "namespace",
        "##targetNamespace", "name", "isKey" });
    addAnnotation(getEntityFieldInfo_Calculated(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace", "name", "isCalculated" });
    addAnnotation(getEntityFieldInfo_Children(), source, new String[] { "kind", "element",
        "namespace", "##targetNamespace", "name", "entityFieldInfo" });
    addAnnotation(entityFieldInfoResultEClass, source, new String[] { "kind", "elementOnly", "name",
        "entityFieldInfos" });
    addAnnotation(getEntityFieldInfoResult_SourceFieldInfo(), source, new String[] { "kind",
        "element", "namespace", "##targetNamespace" });
    addAnnotation(getEntityFieldInfoResult_FieldInfos(), source, new String[] { "kind", "element",
        "name", "entityFieldInfo", "namespace", "##targetNamespace" });
  }

} // CdsAnalysisPackage
