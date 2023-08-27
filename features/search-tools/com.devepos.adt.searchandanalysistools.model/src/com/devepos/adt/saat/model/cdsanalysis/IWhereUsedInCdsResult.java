/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Where Used In Cds Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsResult#getEntries
 * <em>Entries</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsResult()
 * @model extendedMetaData="kind='elementOnly' name='whereUsedInCdsResult'"
 * @generated
 */
public interface IWhereUsedInCdsResult extends EObject {
  /**
   * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entries</em>' containment reference list.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsResult_Entries()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='whereUsedInCdsEntry'
   *        namespace='##targetNamespace'"
   * @generated
   */
  List<IWhereUsedInCdsEntry> getEntries();

} // IWhereUsedInCdsResult
