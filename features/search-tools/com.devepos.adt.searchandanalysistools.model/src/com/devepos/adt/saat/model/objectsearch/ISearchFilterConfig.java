/**
 */
package com.devepos.adt.saat.model.objectsearch;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Filter Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getDataType <em>Data
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getMaxLength <em>Max
 * Length</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isMultiple
 * <em>Multiple</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isNegatable
 * <em>Negatable</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isKeyValuePair <em>Key
 * Value Pair</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getLongDescription
 * <em>Long Description</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isInternal
 * <em>Internal</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isWildcardsAllowed
 * <em>Wildcards Allowed</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getContentAssist
 * <em>Content Assist</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getImageInfo <em>Image
 * Info</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig()
 * @model extendedMetaData="kind='elementOnly' name='filter'"
 * @generated
 */
public interface ISearchFilterConfig extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_Name()
   * @model extendedMetaData="name='name' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getName <em>Name</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Data Type</b></em>' attribute.
   * The literals are from the enumeration
   * {@link com.devepos.adt.saat.model.objectsearch.FilterType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Data Type</em>' attribute.
   * @see com.devepos.adt.saat.model.objectsearch.FilterType
   * @see #setDataType(FilterType)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_DataType()
   * @model extendedMetaData="name='dataType' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  FilterType getDataType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getDataType <em>Data
   * Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Data Type</em>' attribute.
   * @see com.devepos.adt.saat.model.objectsearch.FilterType
   * @see #getDataType()
   * @generated
   */
  void setDataType(FilterType value);

  /**
   * Returns the value of the '<em><b>Max Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Max Length</em>' attribute.
   * @see #setMaxLength(int)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_MaxLength()
   * @model extendedMetaData="name='maxLength' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  int getMaxLength();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getMaxLength <em>Max
   * Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Max Length</em>' attribute.
   * @see #getMaxLength()
   * @generated
   */
  void setMaxLength(int value);

  /**
   * Returns the value of the '<em><b>Multiple</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Multiple</em>' attribute.
   * @see #setMultiple(boolean)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_Multiple()
   * @model extendedMetaData="name='multiple' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  boolean isMultiple();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isMultiple
   * <em>Multiple</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Multiple</em>' attribute.
   * @see #isMultiple()
   * @generated
   */
  void setMultiple(boolean value);

  /**
   * Returns the value of the '<em><b>Negatable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Negatable</em>' attribute.
   * @see #setNegatable(boolean)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_Negatable()
   * @model extendedMetaData="name='negatable' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  boolean isNegatable();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isNegatable
   * <em>Negatable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Negatable</em>' attribute.
   * @see #isNegatable()
   * @generated
   */
  void setNegatable(boolean value);

  /**
   * Returns the value of the '<em><b>Key Value Pair</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Key Value Pair</em>' attribute.
   * @see #setKeyValuePair(boolean)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_KeyValuePair()
   * @model extendedMetaData="name='keyValuePair' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  boolean isKeyValuePair();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isKeyValuePair <em>Key
   * Value Pair</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Key Value Pair</em>' attribute.
   * @see #isKeyValuePair()
   * @generated
   */
  void setKeyValuePair(boolean value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_Description()
   * @model extendedMetaData="name='description' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getDescription
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
   * Returns the value of the '<em><b>Long Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Long Description</em>' attribute.
   * @see #setLongDescription(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_LongDescription()
   * @model extendedMetaData="name='longDescription' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  String getLongDescription();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getLongDescription <em>Long
   * Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Long Description</em>' attribute.
   * @see #getLongDescription()
   * @generated
   */
  void setLongDescription(String value);

  /**
   * Returns the value of the '<em><b>Internal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Internal</em>' attribute.
   * @see #setInternal(boolean)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_Internal()
   * @model extendedMetaData="name='internal' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  boolean isInternal();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isInternal
   * <em>Internal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Internal</em>' attribute.
   * @see #isInternal()
   * @generated
   */
  void setInternal(boolean value);

  /**
   * Returns the value of the '<em><b>Wildcards Allowed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Wildcards Allowed</em>' attribute.
   * @see #setWildcardsAllowed(boolean)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_WildcardsAllowed()
   * @model extendedMetaData="name='patterns' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  boolean isWildcardsAllowed();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isWildcardsAllowed
   * <em>Wildcards Allowed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Wildcards Allowed</em>' attribute.
   * @see #isWildcardsAllowed()
   * @generated
   */
  void setWildcardsAllowed(boolean value);

  /**
   * Returns the value of the '<em><b>Content Assist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Content Assist</em>' containment reference.
   * @see #setContentAssist(IContentAssist)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_ContentAssist()
   * @model containment="true"
   *        extendedMetaData="name='contentAssist' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  IContentAssist getContentAssist();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getContentAssist
   * <em>Content Assist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Content Assist</em>' containment reference.
   * @see #getContentAssist()
   * @generated
   */
  void setContentAssist(IContentAssist value);

  /**
   * Returns the value of the '<em><b>Image Info</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Image Info</em>' reference.
   * @see #setImageInfo(IImageInfo)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getSearchFilterConfig_ImageInfo()
   * @model extendedMetaData="name='imageInfo' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  IImageInfo getImageInfo();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getImageInfo <em>Image
   * Info</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Image Info</em>' reference.
   * @see #getImageInfo()
   * @generated
   */
  void setImageInfo(IImageInfo value);

} // ISearchFilterConfig
