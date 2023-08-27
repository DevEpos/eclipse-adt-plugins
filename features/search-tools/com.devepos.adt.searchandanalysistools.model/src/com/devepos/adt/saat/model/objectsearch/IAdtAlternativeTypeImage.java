/**
 */
package com.devepos.adt.saat.model.objectsearch;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adt Alternative Type Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IAdtAlternativeTypeImage#getType
 * <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IAdtAlternativeTypeImage#getImgInfo <em>Img
 * Info</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getAdtAlternativeTypeImage()
 * @model
 * @generated
 */
public interface IAdtAlternativeTypeImage extends EObject {
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getAdtAlternativeTypeImage_Type()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.IAdtAlternativeTypeImage#getType
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
   * Returns the value of the '<em><b>Img Info</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Img Info</em>' reference.
   * @see #setImgInfo(IImageInfo)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getAdtAlternativeTypeImage_ImgInfo()
   * @model extendedMetaData="kind='element' namespace='##targetNamespace'"
   * @generated
   */
  IImageInfo getImgInfo();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.IAdtAlternativeTypeImage#getImgInfo <em>Img
   * Info</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Img Info</em>' reference.
   * @see #getImgInfo()
   * @generated
   */
  void setImgInfo(IImageInfo value);

} // IAdtAlternativeTypeImage
