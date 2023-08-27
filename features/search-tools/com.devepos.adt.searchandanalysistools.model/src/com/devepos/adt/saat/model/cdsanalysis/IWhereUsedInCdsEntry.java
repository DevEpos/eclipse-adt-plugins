/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Where Used In Cds Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getUri <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getEntityName <em>Entity
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getDdlname
 * <em>Ddlname</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getSourceType <em>Source
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getType
 * <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getApiState <em>Api
 * State</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getChildren
 * <em>Children</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsEntry()
 * @model
 * @generated
 */
public interface IWhereUsedInCdsEntry extends EObject {
  /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #setUri(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsEntry_Uri()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getUri();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getUri <em>Uri</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
  void setUri(String value);

  /**
   * Returns the value of the '<em><b>Entity Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entity Name</em>' attribute.
   * @see #setEntityName(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsEntry_EntityName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getEntityName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getEntityName <em>Entity
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
   * Returns the value of the '<em><b>Ddlname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Ddlname</em>' attribute.
   * @see #setDdlname(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsEntry_Ddlname()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace' name='ddlName'"
   * @generated
   */
  String getDdlname();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getDdlname
   * <em>Ddlname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Ddlname</em>' attribute.
   * @see #getDdlname()
   * @generated
   */
  void setDdlname(String value);

  /**
   * Returns the value of the '<em><b>Source Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Source Type</em>' attribute.
   * @see #setSourceType(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsEntry_SourceType()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getSourceType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getSourceType <em>Source
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
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsEntry_Type()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getType <em>Type</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Api State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Api State</em>' attribute.
   * @see #setApiState(String)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsEntry_ApiState()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getApiState();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getApiState <em>Api
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
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsEntry_Description()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry#getDescription
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
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getWhereUsedInCdsEntry_Children()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='whereUsedInCdsEntry'
   *        namespace='##targetNamespace'"
   * @generated
   */
  List<IWhereUsedInCdsEntry> getChildren();

} // IWhereUsedInCdsEntry
