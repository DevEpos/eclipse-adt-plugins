/**
 */
package com.devepos.adt.saat.model.objectsearch;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content Assist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getEntryImgKey <em>Entry Img
 * Key</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getContentAssist()
 * @model abstract="true"
 * @generated
 */
public interface IContentAssist extends EObject {
  /**
   * Returns the value of the '<em><b>Entry Img Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entry Img Key</em>' attribute.
   * @see #setEntryImgKey(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getContentAssist_EntryImgKey()
   * @model extendedMetaData="name='entryImgKey' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getEntryImgKey();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getEntryImgKey <em>Entry Img
   * Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Entry Img Key</em>' attribute.
   * @see #getEntryImgKey()
   * @generated
   */
  void setEntryImgKey(String value);

} // IContentAssist
