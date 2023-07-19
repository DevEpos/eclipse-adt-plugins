/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ris Content Assist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IRisContentAssist#getObjectTypes <em>Object
 * Types</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getRisContentAssist()
 * @model
 * @generated
 */
public interface IRisContentAssist extends IContentAssist {
  /**
   * Returns the value of the '<em><b>Object Types</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Object Types</em>' attribute list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getRisContentAssist_ObjectTypes()
   * @model extendedMetaData="name='objectType' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<String> getObjectTypes();

} // IRisContentAssist
