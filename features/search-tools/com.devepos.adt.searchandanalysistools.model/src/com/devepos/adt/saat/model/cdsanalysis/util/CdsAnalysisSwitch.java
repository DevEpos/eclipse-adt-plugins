/**
 */
package com.devepos.adt.saat.model.cdsanalysis.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

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
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage
 * @generated
 */
public class CdsAnalysisSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected static ICdsAnalysisPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public CdsAnalysisSwitch() {
    if (modelPackage == null) {
      modelPackage = ICdsAnalysisPackage.eINSTANCE;
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
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT: {
      ICdsUsedEntitiesResult cdsUsedEntitiesResult = (ICdsUsedEntitiesResult) theEObject;
      T result = caseCdsUsedEntitiesResult(cdsUsedEntitiesResult);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICdsAnalysisPackage.CDS_USED_ENTITY: {
      ICdsUsedEntity cdsUsedEntity = (ICdsUsedEntity) theEObject;
      T result = caseCdsUsedEntity(cdsUsedEntity);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION: {
      ICdsUsedEntityInformation cdsUsedEntityInformation = (ICdsUsedEntityInformation) theEObject;
      T result = caseCdsUsedEntityInformation(cdsUsedEntityInformation);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT: {
      ITopDownAnalysisResult topDownAnalysisResult = (ITopDownAnalysisResult) theEObject;
      T result = caseTopDownAnalysisResult(topDownAnalysisResult);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY: {
      ITopDownAnalysisEntry topDownAnalysisEntry = (ITopDownAnalysisEntry) theEObject;
      T result = caseTopDownAnalysisEntry(topDownAnalysisEntry);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICdsAnalysisPackage.CDS_QUERY_NAV_TARGETS: {
      ICdsQueryNavTargets cdsQueryNavTargets = (ICdsQueryNavTargets) theEObject;
      T result = caseCdsQueryNavTargets(cdsQueryNavTargets);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO: {
      IEntityFieldInfo entityFieldInfo = (IEntityFieldInfo) theEObject;
      T result = caseEntityFieldInfo(entityFieldInfo);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT: {
      IEntityFieldInfoResult entityFieldInfoResult = (IEntityFieldInfoResult) theEObject;
      T result = caseEntityFieldInfoResult(entityFieldInfoResult);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_ENTRY: {
      IWhereUsedInCdsEntry whereUsedInCdsEntry = (IWhereUsedInCdsEntry) theEObject;
      T result = caseWhereUsedInCdsEntry(whereUsedInCdsEntry);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_RESULT: {
      IWhereUsedInCdsResult whereUsedInCdsResult = (IWhereUsedInCdsResult) theEObject;
      T result = caseWhereUsedInCdsResult(whereUsedInCdsResult);
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
   * Returns the result of interpreting the object as an instance of '<em>Cds Used Entities
   * Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cds Used Entities
   *         Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCdsUsedEntitiesResult(final ICdsUsedEntitiesResult object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cds Used Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cds Used Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCdsUsedEntity(final ICdsUsedEntity object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cds Used Entity
   * Information</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cds Used Entity
   *         Information</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCdsUsedEntityInformation(final ICdsUsedEntityInformation object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Top Down Analysis
   * Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Top Down Analysis
   *         Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTopDownAnalysisResult(final ITopDownAnalysisResult object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Top Down Analysis
   * Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Top Down Analysis
   *         Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTopDownAnalysisEntry(final ITopDownAnalysisEntry object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cds Query Nav
   * Targets</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cds Query Nav
   *         Targets</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCdsQueryNavTargets(final ICdsQueryNavTargets object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entity Field Info
   * Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entity Field Info
   *         Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntityFieldInfoResult(final IEntityFieldInfoResult object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Where Used In Cds
   * Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Where Used In Cds
   *         Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhereUsedInCdsEntry(final IWhereUsedInCdsEntry object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Where Used In Cds
   * Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Where Used In Cds
   *         Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhereUsedInCdsResult(final IWhereUsedInCdsResult object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entity Field Info</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entity Field Info</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntityFieldInfo(final IEntityFieldInfo object) {
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

} // CdsAnalysisSwitch
