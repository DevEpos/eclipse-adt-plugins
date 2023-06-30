/**
 */
package com.devepos.adt.saat.model.objectsearch;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ris Content Assist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IRisContentAssist#getAdtObjectType <em>Adt
 * Object Type</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getRisContentAssist()
 * @model extendedMetaData="kind='elementOnly' name='risContentAssist'"
 * @generated
 */
public interface IRisContentAssist extends IContentAssist {
  /**
   * Returns the value of the '<em><b>Adt Object Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Adt Object Type</em>' attribute.
   * @see #setAdtObjectType(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getRisContentAssist_AdtObjectType()
   * @model extendedMetaData="name='adtObjectType' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getAdtObjectType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.IRisContentAssist#getAdtObjectType <em>Adt
   * Object Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Adt Object Type</em>' attribute.
   * @see #getAdtObjectType()
   * @generated
   */
  void setAdtObjectType(String value);

} // IRisContentAssist
