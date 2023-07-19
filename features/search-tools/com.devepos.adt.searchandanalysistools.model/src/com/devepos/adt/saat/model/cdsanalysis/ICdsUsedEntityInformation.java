/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cds Used Entity Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getOccurrence
 * <em>Occurrence</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getEntityCount
 * <em>Entity Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getJoinCount <em>Join
 * Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getUnionCount
 * <em>Union Count</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntityInformation()
 * @model extendedMetaData="kind='elementOnly' name='usageInformation'"
 * @generated
 */
public interface ICdsUsedEntityInformation extends EObject {
  /**
   * Returns the value of the '<em><b>Occurrence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Occurrence</em>' attribute.
   * @see #setOccurrence(int)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntityInformation_Occurrence()
   * @model extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  int getOccurrence();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getOccurrence
   * <em>Occurrence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Occurrence</em>' attribute.
   * @see #getOccurrence()
   * @generated
   */
  void setOccurrence(int value);

  /**
   * Returns the value of the '<em><b>Entity Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entity Count</em>' attribute.
   * @see #setEntityCount(int)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntityInformation_EntityCount()
   * @model extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  int getEntityCount();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getEntityCount
   * <em>Entity Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Entity Count</em>' attribute.
   * @see #getEntityCount()
   * @generated
   */
  void setEntityCount(int value);

  /**
   * Returns the value of the '<em><b>Join Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Join Count</em>' attribute.
   * @see #setJoinCount(int)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntityInformation_JoinCount()
   * @model extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  int getJoinCount();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getJoinCount <em>Join
   * Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Join Count</em>' attribute.
   * @see #getJoinCount()
   * @generated
   */
  void setJoinCount(int value);

  /**
   * Returns the value of the '<em><b>Union Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Union Count</em>' attribute.
   * @see #setUnionCount(int)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntityInformation_UnionCount()
   * @model extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  int getUnionCount();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation#getUnionCount
   * <em>Union Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Union Count</em>' attribute.
   * @see #getUnionCount()
   * @generated
   */
  void setUnionCount(int value);

} // ICdsUsedEntityInformation
