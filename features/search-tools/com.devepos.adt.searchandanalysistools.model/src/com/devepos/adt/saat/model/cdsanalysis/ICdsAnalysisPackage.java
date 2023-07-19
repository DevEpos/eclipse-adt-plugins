/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

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
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisFactory
 * @model kind="package"
 * @generated
 */
public interface ICdsAnalysisPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNAME = "cdsanalysis";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_URI = "http://www.devepos.com/adt/cdsanalysis";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_PREFIX = "cdsanalysis";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  ICdsAnalysisPackage eINSTANCE = com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage
      .init();

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntitiesResult <em>Cds Used Entities
   * Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntitiesResult
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getCdsUsedEntitiesResult()
   * @generated
   */
  int CDS_USED_ENTITIES_RESULT = 0;

  /**
   * The feature id for the '<em><b>Source Entity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY = 0;

  /**
   * The feature id for the '<em><b>Used Entities</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITIES_RESULT__USED_ENTITIES = 1;

  /**
   * The number of structural features of the '<em>Cds Used Entities Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITIES_RESULT_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Cds Used Entities Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITIES_RESULT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntity
   * <em>Cds Used Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntity
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getCdsUsedEntity()
   * @generated
   */
  int CDS_USED_ENTITY = 1;

  /**
   * The feature id for the '<em><b>Entity Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITY__ENTITY_REF = 0;

  /**
   * The feature id for the '<em><b>Usage Information</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITY__USAGE_INFORMATION = 1;

  /**
   * The number of structural features of the '<em>Cds Used Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITY_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Cds Used Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation <em>Cds Used
   * Entity Information</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getCdsUsedEntityInformation()
   * @generated
   */
  int CDS_USED_ENTITY_INFORMATION = 2;

  /**
   * The feature id for the '<em><b>Occurrence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITY_INFORMATION__OCCURRENCE = 0;

  /**
   * The feature id for the '<em><b>Entity Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITY_INFORMATION__ENTITY_COUNT = 1;

  /**
   * The feature id for the '<em><b>Join Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITY_INFORMATION__JOIN_COUNT = 2;

  /**
   * The feature id for the '<em><b>Union Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITY_INFORMATION__UNION_COUNT = 3;

  /**
   * The number of structural features of the '<em>Cds Used Entity Information</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITY_INFORMATION_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Cds Used Entity Information</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_USED_ENTITY_INFORMATION_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisResult <em>Top Down Analysis
   * Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisResult
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getTopDownAnalysisResult()
   * @generated
   */
  int TOP_DOWN_ANALYSIS_RESULT = 3;

  /**
   * The feature id for the '<em><b>Source Entity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY = 0;

  /**
   * The feature id for the '<em><b>Entries</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_RESULT__ENTRIES = 1;

  /**
   * The number of structural features of the '<em>Top Down Analysis Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_RESULT_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Top Down Analysis Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_RESULT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisEntry <em>Top Down Analysis
   * Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisEntry
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getTopDownAnalysisEntry()
   * @generated
   */
  int TOP_DOWN_ANALYSIS_ENTRY = 4;

  /**
   * The feature id for the '<em><b>Entry Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_ENTRY__ENTRY_TYPE = 0;

  /**
   * The feature id for the '<em><b>Ddl Source Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_ENTRY__DDL_SOURCE_TYPE = 1;

  /**
   * The feature id for the '<em><b>Sql Relation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_ENTRY__SQL_RELATION = 2;

  /**
   * The feature id for the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_ENTRY__ALIAS = 3;

  /**
   * The feature id for the '<em><b>Entity Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF = 4;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_ENTRY__CHILDREN = 5;

  /**
   * The number of structural features of the '<em>Top Down Analysis Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_ENTRY_FEATURE_COUNT = 6;

  /**
   * The number of operations of the '<em>Top Down Analysis Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOP_DOWN_ANALYSIS_ENTRY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsQueryNavTargets <em>Cds Query Nav
   * Targets</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsQueryNavTargets
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getCdsQueryNavTargets()
   * @generated
   */
  int CDS_QUERY_NAV_TARGETS = 5;

  /**
   * The feature id for the '<em><b>Navigation Targets</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_QUERY_NAV_TARGETS__NAVIGATION_TARGETS = 0;

  /**
   * The number of structural features of the '<em>Cds Query Nav Targets</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_QUERY_NAV_TARGETS_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Cds Query Nav Targets</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CDS_QUERY_NAV_TARGETS_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfoResult <em>Entity Field Info
   * Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfoResult
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getEntityFieldInfoResult()
   * @generated
   */
  int ENTITY_FIELD_INFO_RESULT = 7;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo
   * <em>Entity Field Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getEntityFieldInfo()
   * @generated
   */
  int ENTITY_FIELD_INFO = 6;

  /**
   * The feature id for the '<em><b>Field Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__FIELD_NAME = 0;

  /**
   * The feature id for the '<em><b>Entity Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__ENTITY_NAME = 1;

  /**
   * The feature id for the '<em><b>Alt Entity Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__ALT_ENTITY_NAME = 2;

  /**
   * The feature id for the '<em><b>Source Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__SOURCE_TYPE = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__TYPE = 4;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__URI = 5;

  /**
   * The feature id for the '<em><b>Api State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__API_STATE = 6;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__DESCRIPTION = 7;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__KEY = 8;

  /**
   * The feature id for the '<em><b>Calculated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__CALCULATED = 9;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO__CHILDREN = 10;

  /**
   * The number of structural features of the '<em>Entity Field Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO_FEATURE_COUNT = 11;

  /**
   * The number of operations of the '<em>Entity Field Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO_OPERATION_COUNT = 0;

  /**
   * The feature id for the '<em><b>Source Field Info</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO_RESULT__SOURCE_FIELD_INFO = 0;

  /**
   * The feature id for the '<em><b>Field Infos</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO_RESULT__FIELD_INFOS = 1;

  /**
   * The number of structural features of the '<em>Entity Field Info Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO_RESULT_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Entity Field Info Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ENTITY_FIELD_INFO_RESULT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.cdsanalysis.SqlRelation <em>Sql
   * Relation</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.SqlRelation
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getSqlRelation()
   * @generated
   */
  int SQL_RELATION = 8;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType <em>Top Down Analysis
   * Entry Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getTopDownAnalysisEntryType()
   * @generated
   */
  int TOP_DOWN_ANALYSIS_ENTRY_TYPE = 9;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget
   * <em>Cds Query Nav Target</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget
   * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getCdsQueryNavTarget()
   * @generated
   */
  int CDS_QUERY_NAV_TARGET = 10;

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult <em>Cds Used Entities
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Cds Used Entities Result</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult
   * @generated
   */
  EClass getCdsUsedEntitiesResult();

  /**
   * Returns the meta object for the containment reference
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult#getSourceEntity
   * <em>Source Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>Source Entity</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult#getSourceEntity()
   * @see #getCdsUsedEntitiesResult()
   * @generated
   */
  EReference getCdsUsedEntitiesResult_SourceEntity();

  /**
   * Returns the meta object for the reference list
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult#getUsedEntities <em>Used
   * Entities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the reference list '<em>Used Entities</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult#getUsedEntities()
   * @see #getCdsUsedEntitiesResult()
   * @generated
   */
  EReference getCdsUsedEntitiesResult_UsedEntities();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity
   * <em>Cds Used Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Cds Used Entity</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity
   * @generated
   */
  EClass getCdsUsedEntity();

  /**
   * Returns the meta object for the containment reference
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity#getEntityRef <em>Entity
   * Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>Entity Ref</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity#getEntityRef()
   * @see #getCdsUsedEntity()
   * @generated
   */
  EReference getCdsUsedEntity_EntityRef();

  /**
   * Returns the meta object for the reference
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity#getUsageInformation <em>Usage
   * Information</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the reference '<em>Usage Information</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity#getUsageInformation()
   * @see #getCdsUsedEntity()
   * @generated
   */
  EReference getCdsUsedEntity_UsageInformation();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation <em>Cds Used Entity
   * Information</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Cds Used Entity Information</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation
   * @generated
   */
  EClass getCdsUsedEntityInformation();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getOccurrence
   * <em>Occurrence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Occurrence</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getOccurrence()
   * @see #getCdsUsedEntityInformation()
   * @generated
   */
  EAttribute getCdsUsedEntityInformation_Occurrence();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getEntityCount
   * <em>Entity Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Entity Count</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getEntityCount()
   * @see #getCdsUsedEntityInformation()
   * @generated
   */
  EAttribute getCdsUsedEntityInformation_EntityCount();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getJoinCount <em>Join
   * Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Join Count</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getJoinCount()
   * @see #getCdsUsedEntityInformation()
   * @generated
   */
  EAttribute getCdsUsedEntityInformation_JoinCount();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getUnionCount
   * <em>Union Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Union Count</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getUnionCount()
   * @see #getCdsUsedEntityInformation()
   * @generated
   */
  EAttribute getCdsUsedEntityInformation_UnionCount();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult <em>Top Down Analysis
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Top Down Analysis Result</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult
   * @generated
   */
  EClass getTopDownAnalysisResult();

  /**
   * Returns the meta object for the containment reference
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult#getSourceEntity
   * <em>Source Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>Source Entity</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult#getSourceEntity()
   * @see #getTopDownAnalysisResult()
   * @generated
   */
  EReference getTopDownAnalysisResult_SourceEntity();

  /**
   * Returns the meta object for the reference list
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult#getEntries
   * <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the reference list '<em>Entries</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult#getEntries()
   * @see #getTopDownAnalysisResult()
   * @generated
   */
  EReference getTopDownAnalysisResult_Entries();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry <em>Top Down Analysis
   * Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Top Down Analysis Entry</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry
   * @generated
   */
  EClass getTopDownAnalysisEntry();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getEntryType <em>Entry
   * Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Entry Type</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getEntryType()
   * @see #getTopDownAnalysisEntry()
   * @generated
   */
  EAttribute getTopDownAnalysisEntry_EntryType();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getDdlSourceType <em>Ddl
   * Source Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Ddl Source Type</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getDdlSourceType()
   * @see #getTopDownAnalysisEntry()
   * @generated
   */
  EAttribute getTopDownAnalysisEntry_DdlSourceType();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getSqlRelation <em>Sql
   * Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Sql Relation</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getSqlRelation()
   * @see #getTopDownAnalysisEntry()
   * @generated
   */
  EAttribute getTopDownAnalysisEntry_SqlRelation();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Alias</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getAlias()
   * @see #getTopDownAnalysisEntry()
   * @generated
   */
  EAttribute getTopDownAnalysisEntry_Alias();

  /**
   * Returns the meta object for the containment reference
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getEntityRef <em>Entity
   * Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>Entity Ref</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getEntityRef()
   * @see #getTopDownAnalysisEntry()
   * @generated
   */
  EReference getTopDownAnalysisEntry_EntityRef();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getChildren
   * <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getChildren()
   * @see #getTopDownAnalysisEntry()
   * @generated
   */
  EReference getTopDownAnalysisEntry_Children();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets <em>Cds Query Nav
   * Targets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Cds Query Nav Targets</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets
   * @generated
   */
  EClass getCdsQueryNavTargets();

  /**
   * Returns the meta object for the attribute list
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets#getNavigationTargets
   * <em>Navigation Targets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute list '<em>Navigation Targets</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets#getNavigationTargets()
   * @see #getCdsQueryNavTargets()
   * @generated
   */
  EAttribute getCdsQueryNavTargets_NavigationTargets();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult <em>Entity Field Info
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Entity Field Info Result</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult
   * @generated
   */
  EClass getEntityFieldInfoResult();

  /**
   * Returns the meta object for the reference
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult#getSourceFieldInfo
   * <em>Source Field Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the reference '<em>Source Field Info</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult#getSourceFieldInfo()
   * @see #getEntityFieldInfoResult()
   * @generated
   */
  EReference getEntityFieldInfoResult_SourceFieldInfo();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult#getFieldInfos <em>Field
   * Infos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Field Infos</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult#getFieldInfos()
   * @see #getEntityFieldInfoResult()
   * @generated
   */
  EReference getEntityFieldInfoResult_FieldInfos();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo <em>Entity Field Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Entity Field Info</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo
   * @generated
   */
  EClass getEntityFieldInfo();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getFieldName <em>Field
   * Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Field Name</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getFieldName()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EAttribute getEntityFieldInfo_FieldName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getEntityName <em>Entity
   * Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Entity Name</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getEntityName()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EAttribute getEntityFieldInfo_EntityName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getAltEntityName <em>Alt Entity
   * Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Alt Entity Name</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getAltEntityName()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EAttribute getEntityFieldInfo_AltEntityName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getSourceType <em>Source
   * Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Source Type</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getSourceType()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EAttribute getEntityFieldInfo_SourceType();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getType()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EAttribute getEntityFieldInfo_Type();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getUri()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EAttribute getEntityFieldInfo_Uri();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getApiState <em>Api
   * State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Api State</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getApiState()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EAttribute getEntityFieldInfo_ApiState();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getDescription
   * <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getDescription()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EAttribute getEntityFieldInfo_Description();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#isKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#isKey()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EAttribute getEntityFieldInfo_Key();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#isCalculated
   * <em>Calculated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Calculated</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#isCalculated()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EAttribute getEntityFieldInfo_Calculated();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getChildren
   * <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getChildren()
   * @see #getEntityFieldInfo()
   * @generated
   */
  EReference getEntityFieldInfo_Children();

  /**
   * Returns the meta object for enum '{@link com.devepos.adt.saat.model.cdsanalysis.SqlRelation
   * <em>Sql Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Sql Relation</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.SqlRelation
   * @generated
   */
  EEnum getSqlRelation();

  /**
   * Returns the meta object for enum
   * '{@link com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType <em>Top Down Analysis
   * Entry Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Top Down Analysis Entry Type</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType
   * @generated
   */
  EEnum getTopDownAnalysisEntryType();

  /**
   * Returns the meta object for enum
   * '{@link com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget <em>Cds Query Nav
   * Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Cds Query Nav Target</em>'.
   * @see com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget
   * @generated
   */
  EEnum getCdsQueryNavTarget();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ICdsAnalysisFactory getCdsAnalysisFactory();

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
     * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntitiesResult <em>Cds Used
     * Entities Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntitiesResult
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getCdsUsedEntitiesResult()
     * @generated
     */
    EClass CDS_USED_ENTITIES_RESULT = eINSTANCE.getCdsUsedEntitiesResult();

    /**
     * The meta object literal for the '<em><b>Source Entity</b></em>' containment reference
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY = eINSTANCE
        .getCdsUsedEntitiesResult_SourceEntity();

    /**
     * The meta object literal for the '<em><b>Used Entities</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference CDS_USED_ENTITIES_RESULT__USED_ENTITIES = eINSTANCE
        .getCdsUsedEntitiesResult_UsedEntities();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntity <em>Cds Used Entity</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntity
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getCdsUsedEntity()
     * @generated
     */
    EClass CDS_USED_ENTITY = eINSTANCE.getCdsUsedEntity();

    /**
     * The meta object literal for the '<em><b>Entity Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference CDS_USED_ENTITY__ENTITY_REF = eINSTANCE.getCdsUsedEntity_EntityRef();

    /**
     * The meta object literal for the '<em><b>Usage Information</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference CDS_USED_ENTITY__USAGE_INFORMATION = eINSTANCE.getCdsUsedEntity_UsageInformation();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation <em>Cds Used
     * Entity Information</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getCdsUsedEntityInformation()
     * @generated
     */
    EClass CDS_USED_ENTITY_INFORMATION = eINSTANCE.getCdsUsedEntityInformation();

    /**
     * The meta object literal for the '<em><b>Occurrence</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CDS_USED_ENTITY_INFORMATION__OCCURRENCE = eINSTANCE
        .getCdsUsedEntityInformation_Occurrence();

    /**
     * The meta object literal for the '<em><b>Entity Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CDS_USED_ENTITY_INFORMATION__ENTITY_COUNT = eINSTANCE
        .getCdsUsedEntityInformation_EntityCount();

    /**
     * The meta object literal for the '<em><b>Join Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CDS_USED_ENTITY_INFORMATION__JOIN_COUNT = eINSTANCE
        .getCdsUsedEntityInformation_JoinCount();

    /**
     * The meta object literal for the '<em><b>Union Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CDS_USED_ENTITY_INFORMATION__UNION_COUNT = eINSTANCE
        .getCdsUsedEntityInformation_UnionCount();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisResult <em>Top Down
     * Analysis Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisResult
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getTopDownAnalysisResult()
     * @generated
     */
    EClass TOP_DOWN_ANALYSIS_RESULT = eINSTANCE.getTopDownAnalysisResult();

    /**
     * The meta object literal for the '<em><b>Source Entity</b></em>' containment reference
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY = eINSTANCE
        .getTopDownAnalysisResult_SourceEntity();

    /**
     * The meta object literal for the '<em><b>Entries</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TOP_DOWN_ANALYSIS_RESULT__ENTRIES = eINSTANCE.getTopDownAnalysisResult_Entries();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisEntry <em>Top Down
     * Analysis Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisEntry
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getTopDownAnalysisEntry()
     * @generated
     */
    EClass TOP_DOWN_ANALYSIS_ENTRY = eINSTANCE.getTopDownAnalysisEntry();

    /**
     * The meta object literal for the '<em><b>Entry Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOP_DOWN_ANALYSIS_ENTRY__ENTRY_TYPE = eINSTANCE.getTopDownAnalysisEntry_EntryType();

    /**
     * The meta object literal for the '<em><b>Ddl Source Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOP_DOWN_ANALYSIS_ENTRY__DDL_SOURCE_TYPE = eINSTANCE
        .getTopDownAnalysisEntry_DdlSourceType();

    /**
     * The meta object literal for the '<em><b>Sql Relation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOP_DOWN_ANALYSIS_ENTRY__SQL_RELATION = eINSTANCE
        .getTopDownAnalysisEntry_SqlRelation();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOP_DOWN_ANALYSIS_ENTRY__ALIAS = eINSTANCE.getTopDownAnalysisEntry_Alias();

    /**
     * The meta object literal for the '<em><b>Entity Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF = eINSTANCE.getTopDownAnalysisEntry_EntityRef();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TOP_DOWN_ANALYSIS_ENTRY__CHILDREN = eINSTANCE.getTopDownAnalysisEntry_Children();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsQueryNavTargets <em>Cds Query Nav
     * Targets</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsQueryNavTargets
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getCdsQueryNavTargets()
     * @generated
     */
    EClass CDS_QUERY_NAV_TARGETS = eINSTANCE.getCdsQueryNavTargets();

    /**
     * The meta object literal for the '<em><b>Navigation Targets</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CDS_QUERY_NAV_TARGETS__NAVIGATION_TARGETS = eINSTANCE
        .getCdsQueryNavTargets_NavigationTargets();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfoResult <em>Entity Field
     * Info Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfoResult
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getEntityFieldInfoResult()
     * @generated
     */
    EClass ENTITY_FIELD_INFO_RESULT = eINSTANCE.getEntityFieldInfoResult();

    /**
     * The meta object literal for the '<em><b>Source Field Info</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference ENTITY_FIELD_INFO_RESULT__SOURCE_FIELD_INFO = eINSTANCE
        .getEntityFieldInfoResult_SourceFieldInfo();

    /**
     * The meta object literal for the '<em><b>Field Infos</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference ENTITY_FIELD_INFO_RESULT__FIELD_INFOS = eINSTANCE
        .getEntityFieldInfoResult_FieldInfos();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo <em>Entity Field
     * Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getEntityFieldInfo()
     * @generated
     */
    EClass ENTITY_FIELD_INFO = eINSTANCE.getEntityFieldInfo();

    /**
     * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ENTITY_FIELD_INFO__FIELD_NAME = eINSTANCE.getEntityFieldInfo_FieldName();

    /**
     * The meta object literal for the '<em><b>Entity Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ENTITY_FIELD_INFO__ENTITY_NAME = eINSTANCE.getEntityFieldInfo_EntityName();

    /**
     * The meta object literal for the '<em><b>Alt Entity Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ENTITY_FIELD_INFO__ALT_ENTITY_NAME = eINSTANCE.getEntityFieldInfo_AltEntityName();

    /**
     * The meta object literal for the '<em><b>Source Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ENTITY_FIELD_INFO__SOURCE_TYPE = eINSTANCE.getEntityFieldInfo_SourceType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ENTITY_FIELD_INFO__TYPE = eINSTANCE.getEntityFieldInfo_Type();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ENTITY_FIELD_INFO__URI = eINSTANCE.getEntityFieldInfo_Uri();

    /**
     * The meta object literal for the '<em><b>Api State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ENTITY_FIELD_INFO__API_STATE = eINSTANCE.getEntityFieldInfo_ApiState();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ENTITY_FIELD_INFO__DESCRIPTION = eINSTANCE.getEntityFieldInfo_Description();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ENTITY_FIELD_INFO__KEY = eINSTANCE.getEntityFieldInfo_Key();

    /**
     * The meta object literal for the '<em><b>Calculated</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ENTITY_FIELD_INFO__CALCULATED = eINSTANCE.getEntityFieldInfo_Calculated();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference ENTITY_FIELD_INFO__CHILDREN = eINSTANCE.getEntityFieldInfo_Children();

    /**
     * The meta object literal for the '{@link com.devepos.adt.saat.model.cdsanalysis.SqlRelation
     * <em>Sql Relation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.SqlRelation
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getSqlRelation()
     * @generated
     */
    EEnum SQL_RELATION = eINSTANCE.getSqlRelation();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType <em>Top Down Analysis
     * Entry Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getTopDownAnalysisEntryType()
     * @generated
     */
    EEnum TOP_DOWN_ANALYSIS_ENTRY_TYPE = eINSTANCE.getTopDownAnalysisEntryType();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget <em>Cds Query Nav
     * Target</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget
     * @see com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisPackage#getCdsQueryNavTarget()
     * @generated
     */
    EEnum CDS_QUERY_NAV_TARGET = eINSTANCE.getCdsQueryNavTarget();

  }

} // ICdsAnalysisPackage
