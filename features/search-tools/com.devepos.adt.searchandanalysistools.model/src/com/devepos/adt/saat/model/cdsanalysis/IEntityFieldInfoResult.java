/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Field Info Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult#getSourceFieldInfo
 * <em>Source Field Info</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult#getFieldInfos <em>Field
 * Infos</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfoResult()
 * @model extendedMetaData="kind='elementOnly' name='entityFieldInfos'"
 * @generated
 */
public interface IEntityFieldInfoResult extends EObject {
  /**
   * Returns the value of the '<em><b>Source Field Info</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Source Field Info</em>' reference.
   * @see #setSourceFieldInfo(IEntityFieldInfo)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfoResult_SourceFieldInfo()
   * @model extendedMetaData="kind='element' namespace='##targetNamespace'"
   * @generated
   */
  IEntityFieldInfo getSourceFieldInfo();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult#getSourceFieldInfo
   * <em>Source Field Info</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Source Field Info</em>' reference.
   * @see #getSourceFieldInfo()
   * @generated
   */
  void setSourceFieldInfo(IEntityFieldInfo value);

  /**
   * Returns the value of the '<em><b>Field Infos</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Field Infos</em>' containment reference list.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfoResult_FieldInfos()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='entityFieldInfo' namespace='##targetNamespace'"
   * @generated
   */
  List<IEntityFieldInfo> getFieldInfos();

} // IEntityFieldInfoResult
