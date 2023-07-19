/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Field Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getFieldName <em>Field
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getEntityName <em>Entity
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getAltEntityName <em>Alt
 * Entity Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getSourceType <em>Source
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getType <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getUri <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getApiState <em>Api
 * State</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#isKey <em>Key</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#isCalculated
 * <em>Calculated</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getChildren
 * <em>Children</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo()
 * @model extendedMetaData="kind='elementOnly' name='entityFieldInfo'"
 * @generated
 */
public interface IEntityFieldInfo extends EObject {
  /**
   * Returns the value of the '<em><b>Field Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Field Name</em>' attribute.
   * @see #setFieldName(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_FieldName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getFieldName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getFieldName <em>Field
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Field Name</em>' attribute.
   * @see #getFieldName()
   * @generated
   */
  void setFieldName(String value);

  /**
   * Returns the value of the '<em><b>Entity Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entity Name</em>' attribute.
   * @see #setEntityName(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_EntityName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getEntityName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getEntityName <em>Entity
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Entity Name</em>' attribute.
   * @see #getEntityName()
   * @generated
   */
  void setEntityName(String value);

  /**
   * Returns the value of the '<em><b>Alt Entity Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Alt Entity Name</em>' attribute.
   * @see #setAltEntityName(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_AltEntityName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getAltEntityName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getAltEntityName <em>Alt Entity
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Alt Entity Name</em>' attribute.
   * @see #getAltEntityName()
   * @generated
   */
  void setAltEntityName(String value);

  /**
   * Returns the value of the '<em><b>Source Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Source Type</em>' attribute.
   * @see #setSourceType(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_SourceType()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getSourceType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getSourceType <em>Source
   * Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Source Type</em>' attribute.
   * @see #getSourceType()
   * @generated
   */
  void setSourceType(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_Type()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getType
   * <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #setUri(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_Uri()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getUri();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getUri
   * <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
  void setUri(String value);

  /**
   * Returns the value of the '<em><b>Api State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Api State</em>' attribute.
   * @see #setApiState(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_ApiState()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getApiState();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getApiState <em>Api
   * State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Api State</em>' attribute.
   * @see #getApiState()
   * @generated
   */
  void setApiState(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_Description()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#getDescription
   * <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Key</em>' attribute.
   * @see #setKey(boolean)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_Key()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace' name='isKey'"
   * @generated
   */
  boolean isKey();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#isKey
   * <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Key</em>' attribute.
   * @see #isKey()
   * @generated
   */
  void setKey(boolean value);

  /**
   * Returns the value of the '<em><b>Calculated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Calculated</em>' attribute.
   * @see #setCalculated(boolean)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_Calculated()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace' name='isCalculated'"
   * @generated
   */
  boolean isCalculated();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo#isCalculated
   * <em>Calculated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Calculated</em>' attribute.
   * @see #isCalculated()
   * @generated
   */
  void setCalculated(boolean value);

  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getEntityFieldInfo_Children()
   * @model containment="true"
   *        extendedMetaData="kind='element' namespace='##targetNamespace' name='entityFieldInfo'"
   * @generated
   */
  List<IEntityFieldInfo> getChildren();

} // IEntityFieldInfo
