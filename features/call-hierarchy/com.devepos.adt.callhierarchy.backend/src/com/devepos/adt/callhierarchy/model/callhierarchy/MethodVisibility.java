/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Method Visibility</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage#getMethodVisibility()
 * @model
 * @generated
 */
public enum MethodVisibility implements Enumerator {
  /**
   * The '<em><b>PRIVATE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #PRIVATE_VALUE
   * @generated
   * @ordered
   */
  PRIVATE(1, "PRIVATE", "private"),

  /**
   * The '<em><b>PROTECTED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #PROTECTED_VALUE
   * @generated
   * @ordered
   */
  PROTECTED(2, "PROTECTED", "protected"),

  /**
   * The '<em><b>PUBLIC</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #PUBLIC_VALUE
   * @generated
   * @ordered
   */
  PUBLIC(3, "PUBLIC", "public"),
  /**
   * The '<em><b>UNKNOWN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #UNKNOWN_VALUE
   * @generated
   * @ordered
   */
  UNKNOWN(4, "UNKNOWN", "unknown");

  /**
   * The '<em><b>PRIVATE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #PRIVATE
   * @model literal="private"
   * @generated
   * @ordered
   */
  public static final int PRIVATE_VALUE = 1;

  /**
   * The '<em><b>PROTECTED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #PROTECTED
   * @model literal="protected"
   * @generated
   * @ordered
   */
  public static final int PROTECTED_VALUE = 2;

  /**
   * The '<em><b>PUBLIC</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #PUBLIC
   * @model literal="public"
   * @generated
   * @ordered
   */
  public static final int PUBLIC_VALUE = 3;

  /**
   * The '<em><b>UNKNOWN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #UNKNOWN
   * @model literal="unknown"
   * @generated
   * @ordered
   */
  public static final int UNKNOWN_VALUE = 4;

  /**
   * An array of all the '<em><b>Method Visibility</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static final MethodVisibility[] VALUES_ARRAY = new MethodVisibility[] { PRIVATE,
      PROTECTED, PUBLIC, UNKNOWN, };

  /**
   * A public read-only list of all the '<em><b>Method Visibility</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<MethodVisibility> VALUES = Collections.unmodifiableList(Arrays.asList(
      VALUES_ARRAY));

  /**
   * Returns the '<em><b>Method Visibility</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static MethodVisibility get(final String literal) {
    for (MethodVisibility result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Method Visibility</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static MethodVisibility getByName(final String name) {
    for (MethodVisibility result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Method Visibility</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static MethodVisibility get(final int value) {
    switch (value) {
    case PRIVATE_VALUE:
      return PRIVATE;
    case PROTECTED_VALUE:
      return PROTECTED;
    case PUBLIC_VALUE:
      return PUBLIC;
    case UNKNOWN_VALUE:
      return UNKNOWN;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  MethodVisibility(final int value, final String name, final String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getLiteral() {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }

} // MethodVisibility
