/**
 */
package com.devepos.adt.saat.model.cdsanalysis.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry;
import com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsResult;
import com.devepos.adt.saat.model.cdsanalysis.SqlRelation;
import com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CdsAnalysisFactory extends EFactoryImpl implements ICdsAnalysisFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static ICdsAnalysisFactory init() {
    try {
      ICdsAnalysisFactory theCdsAnalysisFactory = (ICdsAnalysisFactory) EPackage.Registry.INSTANCE
          .getEFactory(ICdsAnalysisPackage.eNS_URI);
      if (theCdsAnalysisFactory != null) {
        return theCdsAnalysisFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CdsAnalysisFactory();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public CdsAnalysisFactory() {
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
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT:
      return createCdsUsedEntitiesResult();
    case ICdsAnalysisPackage.CDS_USED_ENTITY:
      return createCdsUsedEntity();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION:
      return createCdsUsedEntityInformation();
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT:
      return createTopDownAnalysisResult();
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY:
      return createTopDownAnalysisEntry();
    case ICdsAnalysisPackage.CDS_QUERY_NAV_TARGETS:
      return createCdsQueryNavTargets();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO:
      return createEntityFieldInfo();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT:
      return createEntityFieldInfoResult();
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY:
      return createWhereUsedInCdsEntry();
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_RESULT:
      return createWhereUsedInCdsResult();
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
    case ICdsAnalysisPackage.SQL_RELATION:
      return createSqlRelationFromString(eDataType, initialValue);
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY_TYPE:
      return createTopDownAnalysisEntryTypeFromString(eDataType, initialValue);
    case ICdsAnalysisPackage.CDS_QUERY_NAV_TARGET:
      return createCdsQueryNavTargetFromString(eDataType, initialValue);
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
    case ICdsAnalysisPackage.SQL_RELATION:
      return convertSqlRelationToString(eDataType, instanceValue);
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY_TYPE:
      return convertTopDownAnalysisEntryTypeToString(eDataType, instanceValue);
    case ICdsAnalysisPackage.CDS_QUERY_NAV_TARGET:
      return convertCdsQueryNavTargetToString(eDataType, instanceValue);
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
  public ICdsUsedEntitiesResult createCdsUsedEntitiesResult() {
    CdsUsedEntitiesResult cdsUsedEntitiesResult = new CdsUsedEntitiesResult();
    return cdsUsedEntitiesResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ICdsUsedEntity createCdsUsedEntity() {
    CdsUsedEntity cdsUsedEntity = new CdsUsedEntity();
    return cdsUsedEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ICdsUsedEntityInformation createCdsUsedEntityInformation() {
    CdsUsedEntityInformation cdsUsedEntityInformation = new CdsUsedEntityInformation();
    return cdsUsedEntityInformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITopDownAnalysisResult createTopDownAnalysisResult() {
    TopDownAnalysisResult topDownAnalysisResult = new TopDownAnalysisResult();
    return topDownAnalysisResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITopDownAnalysisEntry createTopDownAnalysisEntry() {
    TopDownAnalysisEntry topDownAnalysisEntry = new TopDownAnalysisEntry();
    return topDownAnalysisEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ICdsQueryNavTargets createCdsQueryNavTargets() {
    CdsQueryNavTargets cdsQueryNavTargets = new CdsQueryNavTargets();
    return cdsQueryNavTargets;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IEntityFieldInfoResult createEntityFieldInfoResult() {
    EntityFieldInfoResult entityFieldInfoResult = new EntityFieldInfoResult();
    return entityFieldInfoResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IWhereUsedInCdsEntry createWhereUsedInCdsEntry() {
    WhereUsedInCdsEntry whereUsedInCdsEntry = new WhereUsedInCdsEntry();
    return whereUsedInCdsEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IWhereUsedInCdsResult createWhereUsedInCdsResult() {
    WhereUsedInCdsResult whereUsedInCdsResult = new WhereUsedInCdsResult();
    return whereUsedInCdsResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IEntityFieldInfo createEntityFieldInfo() {
    EntityFieldInfo entityFieldInfo = new EntityFieldInfo();
    return entityFieldInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public SqlRelation createSqlRelationFromString(final EDataType eDataType,
      final String initialValue) {
    SqlRelation result = SqlRelation.get(initialValue);
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
  public String convertSqlRelationToString(final EDataType eDataType, final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public TopDownAnalysisEntryType createTopDownAnalysisEntryTypeFromString(
      final EDataType eDataType, final String initialValue) {
    TopDownAnalysisEntryType result = TopDownAnalysisEntryType.get(initialValue);
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
  public String convertTopDownAnalysisEntryTypeToString(final EDataType eDataType,
      final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public CdsQueryNavTarget createCdsQueryNavTargetFromString(final EDataType eDataType,
      final String initialValue) {
    CdsQueryNavTarget result = CdsQueryNavTarget.get(initialValue);
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
  public String convertCdsQueryNavTargetToString(final EDataType eDataType,
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
  public ICdsAnalysisPackage getCdsAnalysisPackage() {
    return (ICdsAnalysisPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ICdsAnalysisPackage getPackage() {
    return ICdsAnalysisPackage.eINSTANCE;
  }

} // CdsAnalysisFactory
