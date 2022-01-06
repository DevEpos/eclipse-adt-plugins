/**
 */
package com.devepos.adt.base.model.adtbase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Adt Plugin Feature Category</b></em>', and utility methods for
 * working with them. <!-- end-user-doc -->
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeatureCategory()
 * @model
 * @generated
 */
public enum AdtPluginFeatureCategory implements Enumerator {
  /**
   * The '<em><b>NO CATEGORY</b></em>' literal object. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #NO_CATEGORY_VALUE
   * @generated
   * @ordered
   */
  NO_CATEGORY(0, "NO_CATEGORY", "NoCategory"),
  /**
   * The '<em><b>REQUEST ATTRIBUTE</b></em>' literal object. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see #REQUEST_ATTRIBUTE_VALUE
   * @generated
   * @ordered
   */
  REQUEST_ATTRIBUTE(1, "REQUEST_ATTRIBUTE", "RequestAttribute"),
  /**
   * The '<em><b>RESPONSE ATTRIBUTE</b></em>' literal object. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see #RESPONSE_ATTRIBUTE_VALUE
   * @generated
   * @ordered
   */
  RESPONSE_ATTRIBUTE(2, "RESPONSE_ATTRIBUTE", "ResponseAttribute"),
  /**
   * The '<em><b>URI PARAMETER</b></em>' literal object. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #URI_PARAMETER_VALUE
   * @generated
   * @ordered
   */
  URI_PARAMETER(3, "URI_PARAMETER", "UriParameter");

  /**
   * The '<em><b>NO CATEGORY</b></em>' literal value. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #NO_CATEGORY
   * @model literal="NoCategory"
   * @generated
   * @ordered
   */
  public static final int NO_CATEGORY_VALUE = 0;

  /**
   * The '<em><b>REQUEST ATTRIBUTE</b></em>' literal value. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see #REQUEST_ATTRIBUTE
   * @model literal="RequestAttribute"
   * @generated
   * @ordered
   */
  public static final int REQUEST_ATTRIBUTE_VALUE = 1;

  /**
   * The '<em><b>RESPONSE ATTRIBUTE</b></em>' literal value. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see #RESPONSE_ATTRIBUTE
   * @model literal="ResponseAttribute"
   * @generated
   * @ordered
   */
  public static final int RESPONSE_ATTRIBUTE_VALUE = 2;

  /**
   * The '<em><b>URI PARAMETER</b></em>' literal value. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #URI_PARAMETER
   * @model literal="UriParameter"
   * @generated
   * @ordered
   */
  public static final int URI_PARAMETER_VALUE = 3;

  /**
   * An array of all the '<em><b>Adt Plugin Feature Category</b></em>'
   * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static final AdtPluginFeatureCategory[] VALUES_ARRAY = new AdtPluginFeatureCategory[] {
      NO_CATEGORY, REQUEST_ATTRIBUTE, RESPONSE_ATTRIBUTE, URI_PARAMETER, };

  /**
   * A public read-only list of all the '<em><b>Adt Plugin Feature
   * Category</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<AdtPluginFeatureCategory> VALUES = Collections.unmodifiableList(Arrays
      .asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Adt Plugin Feature Category</b></em>' literal with the
   * specified literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AdtPluginFeatureCategory get(final String literal) {
    for (AdtPluginFeatureCategory result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Adt Plugin Feature Category</b></em>' literal with the
   * specified name. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AdtPluginFeatureCategory getByName(final String name) {
    for (AdtPluginFeatureCategory result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Adt Plugin Feature Category</b></em>' literal with the
   * specified integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AdtPluginFeatureCategory get(final int value) {
    switch (value) {
    case NO_CATEGORY_VALUE:
      return NO_CATEGORY;
    case REQUEST_ATTRIBUTE_VALUE:
      return REQUEST_ATTRIBUTE;
    case RESPONSE_ATTRIBUTE_VALUE:
      return RESPONSE_ATTRIBUTE;
    case URI_PARAMETER_VALUE:
      return URI_PARAMETER;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  AdtPluginFeatureCategory(final int value, final String name, final String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getLiteral() {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string
   * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }

} // AdtPluginFeatureCategory
