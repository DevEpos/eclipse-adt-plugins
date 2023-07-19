/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Down Analysis Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getEntryType <em>Entry
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getDdlSourceType <em>Ddl
 * Source Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getSqlRelation <em>Sql
 * Relation</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getAlias
 * <em>Alias</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getEntityRef <em>Entity
 * Ref</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getChildren
 * <em>Children</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisEntry()
 * @model extendedMetaData="kind='elementOnly' name='resultEntry'"
 * @generated
 */
public interface ITopDownAnalysisEntry extends EObject {
  /**
   * Returns the value of the '<em><b>Entry Type</b></em>' attribute.
   * The literals are from the enumeration
   * {@link com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entry Type</em>' attribute.
   * @see com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType
   * @see #setEntryType(TopDownAnalysisEntryType)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisEntry_EntryType()
   * @model extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  TopDownAnalysisEntryType getEntryType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getEntryType <em>Entry
   * Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Entry Type</em>' attribute.
   * @see com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType
   * @see #getEntryType()
   * @generated
   */
  void setEntryType(TopDownAnalysisEntryType value);

  /**
   * Returns the value of the '<em><b>Ddl Source Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Ddl Source Type</em>' attribute.
   * @see #setDdlSourceType(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisEntry_DdlSourceType()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getDdlSourceType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getDdlSourceType <em>Ddl
   * Source Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Ddl Source Type</em>' attribute.
   * @see #getDdlSourceType()
   * @generated
   */
  void setDdlSourceType(String value);

  /**
   * Returns the value of the '<em><b>Sql Relation</b></em>' attribute.
   * The literals are from the enumeration
   * {@link com.devepos.adt.saat.model.cdsanalysis.SqlRelation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Sql Relation</em>' attribute.
   * @see com.devepos.adt.saat.model.cdsanalysis.SqlRelation
   * @see #setSqlRelation(SqlRelation)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisEntry_SqlRelation()
   * @model extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  SqlRelation getSqlRelation();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getSqlRelation <em>Sql
   * Relation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Sql Relation</em>' attribute.
   * @see com.devepos.adt.saat.model.cdsanalysis.SqlRelation
   * @see #getSqlRelation()
   * @generated
   */
  void setSqlRelation(SqlRelation value);

  /**
   * Returns the value of the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Alias</em>' attribute.
   * @see #setAlias(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisEntry_Alias()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getAlias();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getAlias <em>Alias</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Alias</em>' attribute.
   * @see #getAlias()
   * @generated
   */
  void setAlias(String value);

  /**
   * Returns the value of the '<em><b>Entity Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entity Ref</em>' containment reference.
   * @see #setEntityRef(IAdtObjRef)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisEntry_EntityRef()
   * @model containment="true"
   *        extendedMetaData="kind='element' namespace='http://www.devepos.com/adt/base'
   *        name='adtObjRef'"
   * @generated
   */
  IAdtObjRef getEntityRef();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry#getEntityRef <em>Entity
   * Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Entity Ref</em>' containment reference.
   * @see #getEntityRef()
   * @generated
   */
  void setEntityRef(IAdtObjRef value);

  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisEntry_Children()
   * @model containment="true"
   *        extendedMetaData="kind='element' namespace='##targetNamespace' name='resultEntry'"
   * @generated
   */
  List<ITopDownAnalysisEntry> getChildren();

} // ITopDownAnalysisEntry
