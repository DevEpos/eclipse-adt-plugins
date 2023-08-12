/**
 */
package com.devepos.adt.base.model.adtbase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Adt Plugin Feature Type</b></em>', and utility methods for working
 * with them. <!-- end-user-doc -->
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeatureType()
 * @model
 * @generated
 */
public enum AdtPluginFeatureType implements Enumerator {
  /**
   * The '<em><b>BOOLEAN</b></em>' literal object.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #BOOLEAN_VALUE
   * @generated
   * @ordered
   */
  BOOLEAN(0, "BOOLEAN", "Boolean"),

  /**
   * The '<em><b>STRING</b></em>' literal object.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #STRING_VALUE
   * @generated
   * @ordered
   */
  STRING(1, "STRING", "String");

  /**
   * The '<em><b>BOOLEAN</b></em>' literal value.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #BOOLEAN
   * @model literal="Boolean"
   * @generated
   * @ordered
   */
  public static final int BOOLEAN_VALUE = 0;

  /**
   * The '<em><b>STRING</b></em>' literal value.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #STRING
   * @model literal="String"
   * @generated
   * @ordered
   */
  public static final int STRING_VALUE = 1;

  /**
   * An array of all the '<em><b>Adt Plugin Feature Type</b></em>' enumerators.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static final AdtPluginFeatureType[] VALUES_ARRAY = new AdtPluginFeatureType[] { BOOLEAN,
      STRING, };

  /**
   * A public read-only list of all the '<em><b>Adt Plugin Feature Type</b></em>' enumerators.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<AdtPluginFeatureType> VALUES = Collections.unmodifiableList(Arrays
      .asList(VALUES_ARRAY));

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
   * Only this class can construct instances.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  AdtPluginFeatureType(final int value, final String name, final String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * Returns the '<em><b>Adt Plugin Feature Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AdtPluginFeatureType get(final int value) {
    switch (value) {
    case BOOLEAN_VALUE:
      return BOOLEAN;
    case STRING_VALUE:
      return STRING;
    }
    return null;
  }

  /**
   * Returns the '<em><b>Adt Plugin Feature Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AdtPluginFeatureType get(final String literal) {
    for (AdtPluginFeatureType result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Adt Plugin Feature Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AdtPluginFeatureType getByName(final String name) {
    for (AdtPluginFeatureType result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
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
  public int getValue() {
    return value;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }

} // AdtPluginFeatureType
