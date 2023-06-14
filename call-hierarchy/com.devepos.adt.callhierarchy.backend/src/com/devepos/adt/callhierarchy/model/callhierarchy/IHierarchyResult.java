/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hierarchy Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getEntries
 * <em>Entries</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginType
 * <em>Origin Type</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginObjectName
 * <em>Origin Object Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginEnclObjectName
 * <em>Origin Encl Object Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult#getOriginObjectIdentifier
 * <em>Origin Object Identifier</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResult()
 * @model extendedMetaData="kind='elementOnly' name='result'"
 * @generated
 */
public interface IHierarchyResult extends EObject {
  /**
   * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entries</em>' containment reference list.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResult_Entries()
   * @model containment="true" suppressedSetVisibility="true"
   *        extendedMetaData="kind='element' name='entry' namespace='##targetNamespace'"
   * @generated
   */
  EList<IHierarchyResultEntry> getEntries();

  /**
   * Returns the value of the '<em><b>Origin Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Origin Type</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResult_OriginType()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='originType' namespace='##targetNamespace'"
   * @generated
   */
  String getOriginType();

  /**
   * Returns the value of the '<em><b>Origin Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Origin Object Name</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResult_OriginObjectName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='originObjectName'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getOriginObjectName();

  /**
   * Returns the value of the '<em><b>Origin Encl Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Origin Encl Object Name</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResult_OriginEnclObjectName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='originEnclObjectName'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getOriginEnclObjectName();

  /**
   * Returns the value of the '<em><b>Origin Object Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Origin Object Identifier</em>' attribute.
   * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getHierarchyResult_OriginObjectIdentifier()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='originObjectIdentifier'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getOriginObjectIdentifier();

} // IHierarchyResult
