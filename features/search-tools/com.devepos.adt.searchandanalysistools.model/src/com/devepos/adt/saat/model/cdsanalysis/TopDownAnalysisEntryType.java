/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Top Down Analysis Entry
 * Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getTopDownAnalysisEntryType()
 * @model
 * @generated
 */
public enum TopDownAnalysisEntryType implements Enumerator {
  /**
   * The '<em><b>UNSPECIFIED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #UNSPECIFIED_VALUE
   * @generated
   * @ordered
   */
  UNSPECIFIED(0, "UNSPECIFIED", "UNSPECIFIED"),

  /**
   * The '<em><b>RESULT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #RESULT_VALUE
   * @generated
   * @ordered
   */
  RESULT(1, "RESULT", "RESULT"),

  /**
   * The '<em><b>UNION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #UNION_VALUE
   * @generated
   * @ordered
   */
  UNION(2, "UNION", "UNION"),

  /**
   * The '<em><b>UNION ALL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #UNION_ALL_VALUE
   * @generated
   * @ordered
   */
  UNION_ALL(3, "UNION_ALL", "UNION_ALL"),

  /**
   * The '<em><b>ASSOCIATIONS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #ASSOCIATIONS_VALUE
   * @generated
   * @ordered
   */
  ASSOCIATIONS(4, "ASSOCIATIONS", "ASSOCIATIONS"),

  /**
   * The '<em><b>ENTITY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #ENTITY_VALUE
   * @generated
   * @ordered
   */
  ENTITY(5, "ENTITY", "ENTITY"),

  /**
   * The '<em><b>SELECT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #SELECT_VALUE
   * @generated
   * @ordered
   */
  SELECT(6, "SELECT", "SELECT");

  /**
   * The '<em><b>UNSPECIFIED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #UNSPECIFIED
   * @model
   * @generated
   * @ordered
   */
  public static final int UNSPECIFIED_VALUE = 0;

  /**
   * The '<em><b>RESULT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #RESULT
   * @model
   * @generated
   * @ordered
   */
  public static final int RESULT_VALUE = 1;

  /**
   * The '<em><b>UNION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #UNION
   * @model
   * @generated
   * @ordered
   */
  public static final int UNION_VALUE = 2;

  /**
   * The '<em><b>UNION ALL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #UNION_ALL
   * @model
   * @generated
   * @ordered
   */
  public static final int UNION_ALL_VALUE = 3;

  /**
   * The '<em><b>ASSOCIATIONS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #ASSOCIATIONS
   * @model
   * @generated
   * @ordered
   */
  public static final int ASSOCIATIONS_VALUE = 4;

  /**
   * The '<em><b>ENTITY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #ENTITY
   * @model
   * @generated
   * @ordered
   */
  public static final int ENTITY_VALUE = 5;

  /**
   * The '<em><b>SELECT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #SELECT
   * @model
   * @generated
   * @ordered
   */
  public static final int SELECT_VALUE = 6;

  /**
   * An array of all the '<em><b>Top Down Analysis Entry Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static final TopDownAnalysisEntryType[] VALUES_ARRAY = new TopDownAnalysisEntryType[] {
      UNSPECIFIED, RESULT, UNION, UNION_ALL, ASSOCIATIONS, ENTITY, SELECT, };

  /**
   * A public read-only list of all the '<em><b>Top Down Analysis Entry Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<TopDownAnalysisEntryType> VALUES = Collections.unmodifiableList(Arrays
      .asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Top Down Analysis Entry Type</b></em>' literal with the specified literal
   * value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TopDownAnalysisEntryType get(final String literal) {
    for (TopDownAnalysisEntryType result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Top Down Analysis Entry Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TopDownAnalysisEntryType getByName(final String name) {
    for (TopDownAnalysisEntryType result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Top Down Analysis Entry Type</b></em>' literal with the specified integer
   * value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TopDownAnalysisEntryType get(final int value) {
    switch (value) {
    case UNSPECIFIED_VALUE:
      return UNSPECIFIED;
    case RESULT_VALUE:
      return RESULT;
    case UNION_VALUE:
      return UNION;
    case UNION_ALL_VALUE:
      return UNION_ALL;
    case ASSOCIATIONS_VALUE:
      return ASSOCIATIONS;
    case ENTITY_VALUE:
      return ENTITY;
    case SELECT_VALUE:
      return SELECT;
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
  TopDownAnalysisEntryType(final int value, final String name, final String literal) {
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

} // TopDownAnalysisEntryType
