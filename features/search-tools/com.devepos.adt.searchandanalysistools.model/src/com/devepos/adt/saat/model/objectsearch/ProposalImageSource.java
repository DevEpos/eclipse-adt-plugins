/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Proposal Image Source</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getProposalImageSource()
 * @model
 * @generated
 */
public enum ProposalImageSource implements Enumerator {
  /**
   * The '<em><b>FIXED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #FIXED_VALUE
   * @generated
   * @ordered
   */
  FIXED(0, "FIXED", "FIXED"),

  /**
   * The '<em><b>PROPOSAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #PROPOSAL_VALUE
   * @generated
   * @ordered
   */
  PROPOSAL(1, "PROPOSAL", "PROPOSAL"),

  /**
   * The '<em><b>SAME AS FILTER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #SAME_AS_FILTER_VALUE
   * @generated
   * @ordered
   */
  SAME_AS_FILTER(2, "SAME_AS_FILTER", "SAME_AS_FILTER");

  /**
   * The '<em><b>FIXED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #FIXED
   * @model
   * @generated
   * @ordered
   */
  public static final int FIXED_VALUE = 0;

  /**
   * The '<em><b>PROPOSAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #PROPOSAL
   * @model
   * @generated
   * @ordered
   */
  public static final int PROPOSAL_VALUE = 1;

  /**
   * The '<em><b>SAME AS FILTER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #SAME_AS_FILTER
   * @model
   * @generated
   * @ordered
   */
  public static final int SAME_AS_FILTER_VALUE = 2;

  /**
   * An array of all the '<em><b>Proposal Image Source</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static final ProposalImageSource[] VALUES_ARRAY = new ProposalImageSource[] { FIXED,
      PROPOSAL, SAME_AS_FILTER, };

  /**
   * A public read-only list of all the '<em><b>Proposal Image Source</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<ProposalImageSource> VALUES = Collections
      .unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Proposal Image Source</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ProposalImageSource get(final String literal) {
    for (ProposalImageSource result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Proposal Image Source</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ProposalImageSource getByName(final String name) {
    for (ProposalImageSource result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Proposal Image Source</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ProposalImageSource get(final int value) {
    switch (value) {
    case FIXED_VALUE:
      return FIXED;
    case PROPOSAL_VALUE:
      return PROPOSAL;
    case SAME_AS_FILTER_VALUE:
      return SAME_AS_FILTER;
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
  ProposalImageSource(final int value, final String name, final String literal) {
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

} // ProposalImageSource
