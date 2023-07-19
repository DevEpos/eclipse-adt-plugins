/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Down Analysis Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult#getSourceEntity
 * <em>Source Entity</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult#getEntries
 * <em>Entries</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisResult()
 * @model extendedMetaData="kind='elementOnly' name='topDownResult'"
 * @generated
 */
public interface ITopDownAnalysisResult extends EObject {
  /**
   * Returns the value of the '<em><b>Source Entity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Source Entity</em>' containment reference.
   * @see #setSourceEntity(IAdtObjRef)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisResult_SourceEntity()
   * @model containment="true"
   *        extendedMetaData="kind='element' namespace='http://www.devepos.com/adt/base'
   *        name='adtObjRef'"
   * @generated
   */
  IAdtObjRef getSourceEntity();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult#getSourceEntity
   * <em>Source Entity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Source Entity</em>' containment reference.
   * @see #getSourceEntity()
   * @generated
   */
  void setSourceEntity(IAdtObjRef value);

  /**
   * Returns the value of the '<em><b>Entries</b></em>' reference list.
   * The list contents are of type
   * {@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entries</em>' reference list.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisResult_Entries()
   * @model extendedMetaData="kind='element' namespace='##targetNamespace' name='resultEntry'"
   * @generated
   */
  List<ITopDownAnalysisEntry> getEntries();

} // ITopDownAnalysisResult
