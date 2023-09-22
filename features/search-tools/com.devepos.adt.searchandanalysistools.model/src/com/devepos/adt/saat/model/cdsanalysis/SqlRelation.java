/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Sql Relation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getSqlRelation()
 * @model
 * @generated
 */
public enum SqlRelation implements Enumerator {
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
   * The '<em><b>FROM</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #FROM_VALUE
   * @generated
   * @ordered
   */
  FROM(1, "FROM", "FROM"),

  /**
   * The '<em><b>ASSOCIATION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #ASSOCIATION_VALUE
   * @generated
   * @ordered
   */
  ASSOCIATION(2, "ASSOCIATION", "ASSOCIATION"),

  /**
   * The '<em><b>INNER JOIN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #INNER_JOIN_VALUE
   * @generated
   * @ordered
   */
  INNER_JOIN(3, "INNER_JOIN", "INNER_JOIN"),

  /**
   * The '<em><b>LEFT OUTER JOIN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #LEFT_OUTER_JOIN_VALUE
   * @generated
   * @ordered
   */
  LEFT_OUTER_JOIN(4, "LEFT_OUTER_JOIN", "LEFT_OUTER_JOIN"),

  /**
   * The '<em><b>RIGHT OUTER JOIN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #RIGHT_OUTER_JOIN_VALUE
   * @generated
   * @ordered
   */
  RIGHT_OUTER_JOIN(5, "RIGHT_OUTER_JOIN", "RIGHT_OUTER_JOIN"),

  /**
   * The '<em><b>FULL OUTER JOIN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #FULL_OUTER_JOIN_VALUE
   * @generated
   * @ordered
   */
  FULL_OUTER_JOIN(6, "FULL_OUTER_JOIN", "FULL_OUTER_JOIN"),

  /**
   * The '<em><b>CROSS JOIN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #CROSS_JOIN_VALUE
   * @generated
   * @ordered
   */
  CROSS_JOIN(7, "CROSS_JOIN", "CROSS_JOIN"),
  /**
   * The '<em><b>IMPLEMENTED BY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #IMPLEMENTED_BY_VALUE
   * @generated
   * @ordered
   */
  IMPLEMENTED_BY(8, "IMPLEMENTED_BY", "IMPLEMENTED_BY");

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
   * The '<em><b>FROM</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #FROM
   * @model
   * @generated
   * @ordered
   */
  public static final int FROM_VALUE = 1;

  /**
   * The '<em><b>ASSOCIATION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #ASSOCIATION
   * @model
   * @generated
   * @ordered
   */
  public static final int ASSOCIATION_VALUE = 2;

  /**
   * The '<em><b>INNER JOIN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #INNER_JOIN
   * @model
   * @generated
   * @ordered
   */
  public static final int INNER_JOIN_VALUE = 3;

  /**
   * The '<em><b>LEFT OUTER JOIN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #LEFT_OUTER_JOIN
   * @model
   * @generated
   * @ordered
   */
  public static final int LEFT_OUTER_JOIN_VALUE = 4;

  /**
   * The '<em><b>RIGHT OUTER JOIN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #RIGHT_OUTER_JOIN
   * @model
   * @generated
   * @ordered
   */
  public static final int RIGHT_OUTER_JOIN_VALUE = 5;

  /**
   * The '<em><b>FULL OUTER JOIN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #FULL_OUTER_JOIN
   * @model
   * @generated
   * @ordered
   */
  public static final int FULL_OUTER_JOIN_VALUE = 6;

  /**
   * The '<em><b>CROSS JOIN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #CROSS_JOIN
   * @model
   * @generated
   * @ordered
   */
  public static final int CROSS_JOIN_VALUE = 7;

  /**
   * The '<em><b>IMPLEMENTED BY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #IMPLEMENTED_BY
   * @model
   * @generated
   * @ordered
   */
  public static final int IMPLEMENTED_BY_VALUE = 8;

  /**
   * An array of all the '<em><b>Sql Relation</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static final SqlRelation[] VALUES_ARRAY = new SqlRelation[] { UNSPECIFIED, FROM,
      ASSOCIATION, INNER_JOIN, LEFT_OUTER_JOIN, RIGHT_OUTER_JOIN, FULL_OUTER_JOIN, CROSS_JOIN,
      IMPLEMENTED_BY, };

  /**
   * A public read-only list of all the '<em><b>Sql Relation</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<SqlRelation> VALUES = Collections.unmodifiableList(Arrays.asList(
      VALUES_ARRAY));

  /**
   * Returns the '<em><b>Sql Relation</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static SqlRelation get(final String literal) {
    for (SqlRelation result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Sql Relation</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static SqlRelation getByName(final String name) {
    for (SqlRelation result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Sql Relation</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static SqlRelation get(final int value) {
    switch (value) {
    case UNSPECIFIED_VALUE:
      return UNSPECIFIED;
    case FROM_VALUE:
      return FROM;
    case ASSOCIATION_VALUE:
      return ASSOCIATION;
    case INNER_JOIN_VALUE:
      return INNER_JOIN;
    case LEFT_OUTER_JOIN_VALUE:
      return LEFT_OUTER_JOIN;
    case RIGHT_OUTER_JOIN_VALUE:
      return RIGHT_OUTER_JOIN;
    case FULL_OUTER_JOIN_VALUE:
      return FULL_OUTER_JOIN;
    case CROSS_JOIN_VALUE:
      return CROSS_JOIN;
    case IMPLEMENTED_BY_VALUE:
      return IMPLEMENTED_BY;
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
  SqlRelation(final int value, final String name, final String literal) {
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

} // SqlRelation
