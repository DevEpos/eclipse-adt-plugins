/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getKey <em>Key</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getLabel <em>Label</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getType <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getOptionValues <em>Option
 * Values</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getCustomOption()
 * @model
 * @generated
 */
public interface ICustomOption extends EObject {
  /**
   * Returns the value of the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Key</em>' attribute.
   * @see #setKey(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getCustomOption_Key()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   * @generated
   */
  String getKey();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getKey
   * <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Key</em>' attribute.
   * @see #getKey()
   * @generated
   */
  void setKey(String value);

  /**
   * Returns the value of the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Label</em>' attribute.
   * @see #setLabel(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getCustomOption_Label()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getLabel
   * <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration
   * {@link com.devepos.adt.saat.model.objectsearch.CustomOptionType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Type</em>' attribute.
   * @see com.devepos.adt.saat.model.objectsearch.CustomOptionType
   * @see #setType(CustomOptionType)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getCustomOption_Type()
   * @model
   * @generated
   */
  CustomOptionType getType();

  /**
   * Sets the value of the '{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getType
   * <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see com.devepos.adt.saat.model.objectsearch.CustomOptionType
   * @see #getType()
   * @generated
   */
  void setType(CustomOptionType value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getCustomOption_Description()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' namespace='##targetNamespace'"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getDescription
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
   * Returns the value of the '<em><b>Option Values</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type {@link java.lang.String},
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Option Values</em>' map.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getCustomOption_OptionValues()
   * @model mapType="com.devepos.adt.saat.model.objectsearch.StringToStringMapEntry&lt;org.eclipse.emf.ecore.xml.type.String,
   *        org.eclipse.emf.ecore.xml.type.String&gt;"
   *        extendedMetaData="kind='element' namespace='##targetNamespace' name='optionValue'"
   * @generated
   */
  Map<String, String> getOptionValues();

} // ICustomOption
