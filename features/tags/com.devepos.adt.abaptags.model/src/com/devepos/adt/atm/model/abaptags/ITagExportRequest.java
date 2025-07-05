/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Export Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagExportRequest#getTagIds <em>Tag Ids</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagExportRequest#isIncludeSharedTagsInfo
 * <em>Include Shared Tags Info</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagExportRequest()
 * @model extendedMetaData="kind='elementOnly' name='tagExportRequest'"
 * @generated
 */
public interface ITagExportRequest extends EObject {
  /**
   * Returns the value of the '<em><b>Tag Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tag Ids</em>' attribute list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagExportRequest_TagIds()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' name='tagId' namespace='##targetNamespace'"
   * @generated
   */
  EList<String> getTagIds();

  /**
   * Returns the value of the '<em><b>Include Shared Tags Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Include Shared Tags Info</em>' attribute.
   * @see #setIncludeSharedTagsInfo(boolean)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagExportRequest_IncludeSharedTagsInfo()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'
   *        name='includeSharedTagsInfo'"
   * @generated
   */
  boolean isIncludeSharedTagsInfo();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITagExportRequest#isIncludeSharedTagsInfo
   * <em>Include Shared Tags Info</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Include Shared Tags Info</em>' attribute.
   * @see #isIncludeSharedTagsInfo()
   * @generated
   */
  void setIncludeSharedTagsInfo(boolean value);

} // ITagExportRequest
