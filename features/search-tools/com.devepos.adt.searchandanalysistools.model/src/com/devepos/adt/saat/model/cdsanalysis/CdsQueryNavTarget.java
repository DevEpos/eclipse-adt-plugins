/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Cds Query Nav Target</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsQueryNavTarget()
 * @model
 * @generated
 */
public enum CdsQueryNavTarget implements Enumerator {
  /**
   * The '<em><b>EXCEL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #EXCEL_VALUE
   * @generated
   * @ordered
   */
  EXCEL(1, "EXCEL", "EXCEL"),

  /**
   * The '<em><b>QUERY MONITOR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #QUERY_MONITOR_VALUE
   * @generated
   * @ordered
   */
  QUERY_MONITOR(2, "QUERY_MONITOR", "QUERY_MONITOR");

  /**
   * The '<em><b>EXCEL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #EXCEL
   * @model
   * @generated
   * @ordered
   */
  public static final int EXCEL_VALUE = 1;

  /**
   * The '<em><b>QUERY MONITOR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #QUERY_MONITOR
   * @model
   * @generated
   * @ordered
   */
  public static final int QUERY_MONITOR_VALUE = 2;

  /**
   * An array of all the '<em><b>Cds Query Nav Target</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static final CdsQueryNavTarget[] VALUES_ARRAY = new CdsQueryNavTarget[] { EXCEL,
      QUERY_MONITOR, };

  /**
   * A public read-only list of all the '<em><b>Cds Query Nav Target</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<CdsQueryNavTarget> VALUES = Collections
      .unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Cds Query Nav Target</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static CdsQueryNavTarget get(final String literal) {
    for (CdsQueryNavTarget result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Cds Query Nav Target</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static CdsQueryNavTarget getByName(final String name) {
    for (CdsQueryNavTarget result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Cds Query Nav Target</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static CdsQueryNavTarget get(final int value) {
    switch (value) {
    case EXCEL_VALUE:
      return EXCEL;
    case QUERY_MONITOR_VALUE:
      return QUERY_MONITOR;
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
  CdsQueryNavTarget(final int value, final String name, final String literal) {
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

} // CdsQueryNavTarget
