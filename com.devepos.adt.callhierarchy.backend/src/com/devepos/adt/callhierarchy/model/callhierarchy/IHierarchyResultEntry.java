/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hierarchy Result Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getEnclosedObjectName
 * <em>Enclosed Object Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getEnclosedObjectDisplayName
 * <em>Enclosed Object Display Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getType
 * <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getOwner
 * <em>Owner</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getPackageName
 * <em>Package Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getUri
 * <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getParentUri
 * <em>Parent Uri</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getCallPositions
 * <em>Call Positions</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry#getMethodProperties
 * <em>Method Properties</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry()
 * @model extendedMetaData="kind='elementOnly' name='entry'"
 * @generated
 */
public interface IHierarchyResultEntry extends EObject {
  /**
   * Returns the value of the '<em><b>Enclosed Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Enclosed Object Name</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_EnclosedObjectName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='enclObjName' namespace='##targetNamespace'"
   * @generated
   */
  String getEnclosedObjectName();

  /**
   * Returns the value of the '<em><b>Enclosed Object Display Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Enclosed Object Display Name</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_EnclosedObjectDisplayName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='enclObjDisplayName'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getEnclosedObjectDisplayName();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Type</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_Type()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='type' namespace='##targetNamespace'"
   * @generated
   */
  String getType();

  /**
   * Returns the value of the '<em><b>Owner</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Owner</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_Owner()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='owner' namespace='##targetNamespace'"
   * @generated
   */
  String getOwner();

  /**
   * Returns the value of the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Package Name</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_PackageName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='packageName' namespace='##targetNamespace'"
   * @generated
   */
  String getPackageName();

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Description</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_Description()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='description' namespace='##targetNamespace'"
   * @generated
   */
  String getDescription();

  /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Uri</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_Uri()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='uri' namespace='##targetNamespace'"
   * @generated
   */
  String getUri();

  /**
   * Returns the value of the '<em><b>Parent Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Uri</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_ParentUri()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='parentUri' namespace='##targetNamespace'"
   * @generated
   */
  String getParentUri();

  /**
   * Returns the value of the '<em><b>Call Positions</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Call Positions</em>' containment reference list.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_CallPositions()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='callPosition' namespace='##targetNamespace'"
   * @generated
   */
  EList<ICallPosition> getCallPositions();

  /**
   * Returns the value of the '<em><b>Method Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Method Properties</em>' containment reference.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResultEntry_MethodProperties()
   * @model containment="true" suppressedSetVisibility="true"
   *        extendedMetaData="kind='element' name='methodProperties' namespace='##targetNamespace'"
   * @generated
   */
  IMethodProperties getMethodProperties();

} // IHierarchyResultEntry
