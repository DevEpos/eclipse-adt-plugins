/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage
 * @generated
 */
public interface ICdsAnalysisFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  ICdsAnalysisFactory eINSTANCE = com.devepos.adt.saat.model.cdsanalysis.impl.CdsAnalysisFactory
      .init();

  /**
   * Returns a new object of class '<em>Cds Used Entities Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Cds Used Entities Result</em>'.
   * @generated
   */
  ICdsUsedEntitiesResult createCdsUsedEntitiesResult();

  /**
   * Returns a new object of class '<em>Cds Used Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Cds Used Entity</em>'.
   * @generated
   */
  ICdsUsedEntity createCdsUsedEntity();

  /**
   * Returns a new object of class '<em>Cds Used Entity Information</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Cds Used Entity Information</em>'.
   * @generated
   */
  ICdsUsedEntityInformation createCdsUsedEntityInformation();

  /**
   * Returns a new object of class '<em>Top Down Analysis Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Top Down Analysis Result</em>'.
   * @generated
   */
  ITopDownAnalysisResult createTopDownAnalysisResult();

  /**
   * Returns a new object of class '<em>Top Down Analysis Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Top Down Analysis Entry</em>'.
   * @generated
   */
  ITopDownAnalysisEntry createTopDownAnalysisEntry();

  /**
   * Returns a new object of class '<em>Cds Query Nav Targets</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Cds Query Nav Targets</em>'.
   * @generated
   */
  ICdsQueryNavTargets createCdsQueryNavTargets();

  /**
   * Returns a new object of class '<em>Entity Field Info Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Entity Field Info Result</em>'.
   * @generated
   */
  IEntityFieldInfoResult createEntityFieldInfoResult();

  /**
   * Returns a new object of class '<em>Entity Field Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Entity Field Info</em>'.
   * @generated
   */
  IEntityFieldInfo createEntityFieldInfo();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the package supported by this factory.
   * @generated
   */
  ICdsAnalysisPackage getCdsAnalysisPackage();

} // ICdsAnalysisFactory
