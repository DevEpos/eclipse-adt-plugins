/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Type Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getName <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getLabel
 * <em>Label</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getImageInfo <em>Image
 * Info</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getInputs
 * <em>Inputs</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchTypeConfig()
 * @model extendedMetaData="kind='elementOnly' name='searchType'"
 * @generated
 */
public interface ISearchTypeConfig extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchTypeConfig_Name()
   * @model extendedMetaData="name='name' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getName
   * <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Label</em>' attribute.
   * @see #setLabel(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchTypeConfig_Label()
   * @model extendedMetaData="name='label' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getLabel <em>Label</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

  /**
   * Returns the value of the '<em><b>Image Info</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Image Info</em>' reference.
   * @see #setImageInfo(IImageInfo)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchTypeConfig_ImageInfo()
   * @model extendedMetaData="name='imageInfo' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  IImageInfo getImageInfo();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getImageInfo <em>Image
   * Info</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Image Info</em>' reference.
   * @see #getImageInfo()
   * @generated
   */
  void setImageInfo(IImageInfo value);

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchTypeConfig_Inputs()
   * @model containment="true"
   *        extendedMetaData="name='input' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<ISearchTypeInputFieldConfig> getInputs();

} // ISearchTypeConfig
