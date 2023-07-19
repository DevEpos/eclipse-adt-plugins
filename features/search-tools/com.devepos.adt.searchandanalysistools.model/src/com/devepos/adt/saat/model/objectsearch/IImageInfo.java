/**
 */
package com.devepos.adt.saat.model.objectsearch;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageId <em>Image Id</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageEncoded <em>Image
 * Encoded</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageRegistryId <em>Image
 * Registry Id</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getImageInfo()
 * @model extendedMetaData="kind='elementOnly' name='proposalImage'"
 * @generated
 */
public interface IImageInfo extends EObject {
  /**
   * Returns the value of the '<em><b>Image Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Image Id</em>' attribute.
   * @see #setImageId(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getImageInfo_ImageId()
   * @model extendedMetaData="name='imageId' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getImageId();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageId
   * <em>Image Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Image Id</em>' attribute.
   * @see #getImageId()
   * @generated
   */
  void setImageId(String value);

  /**
   * Returns the value of the '<em><b>Image Encoded</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Image Encoded</em>' attribute.
   * @see #setImageEncoded(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getImageInfo_ImageEncoded()
   * @model extendedMetaData="name='imageEncoded' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getImageEncoded();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageEncoded <em>Image
   * Encoded</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Image Encoded</em>' attribute.
   * @see #getImageEncoded()
   * @generated
   */
  void setImageEncoded(String value);

  /**
   * Returns the value of the '<em><b>Image Registry Id</b></em>' attribute.
   * The literals are from the enumeration
   * {@link com.devepos.adt.saat.model.objectsearch.ImageRegistryId}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Image Registry Id</em>' attribute.
   * @see com.devepos.adt.saat.model.objectsearch.ImageRegistryId
   * @see #setImageRegistryId(ImageRegistryId)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getImageInfo_ImageRegistryId()
   * @model extendedMetaData="name='imageRegistryId' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  ImageRegistryId getImageRegistryId();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageRegistryId <em>Image
   * Registry Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Image Registry Id</em>' attribute.
   * @see com.devepos.adt.saat.model.objectsearch.ImageRegistryId
   * @see #getImageRegistryId()
   * @generated
   */
  void setImageRegistryId(ImageRegistryId value);

} // IImageInfo
