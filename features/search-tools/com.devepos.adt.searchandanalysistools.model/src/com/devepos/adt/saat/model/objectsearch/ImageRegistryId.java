/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Image Registry Id</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getImageRegistryId()
 * @model
 * @generated
 */
public enum ImageRegistryId implements Enumerator {
  /**
   * The '<em><b>CALLING PLUGIN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #CALLING_PLUGIN_VALUE
   * @generated
   * @ordered
   */
  CALLING_PLUGIN(0, "CALLING_PLUGIN", "CALLING_PLUGIN"),

  /**
   * The '<em><b>ADT OBJECT TYPE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #ADT_OBJECT_TYPE_VALUE
   * @generated
   * @ordered
   */
  ADT_OBJECT_TYPE(1, "ADT_OBJECT_TYPE", "ADT_OBJECT_TYPE");

  /**
   * The '<em><b>CALLING PLUGIN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #CALLING_PLUGIN
   * @model
   * @generated
   * @ordered
   */
  public static final int CALLING_PLUGIN_VALUE = 0;

  /**
   * The '<em><b>ADT OBJECT TYPE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #ADT_OBJECT_TYPE
   * @model
   * @generated
   * @ordered
   */
  public static final int ADT_OBJECT_TYPE_VALUE = 1;

  /**
   * An array of all the '<em><b>Image Registry Id</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static final ImageRegistryId[] VALUES_ARRAY = new ImageRegistryId[] { CALLING_PLUGIN,
      ADT_OBJECT_TYPE, };

  /**
   * A public read-only list of all the '<em><b>Image Registry Id</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<ImageRegistryId> VALUES = Collections
      .unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Image Registry Id</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ImageRegistryId get(final String literal) {
    for (ImageRegistryId result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Image Registry Id</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ImageRegistryId getByName(final String name) {
    for (ImageRegistryId result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Image Registry Id</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ImageRegistryId get(final int value) {
    switch (value) {
    case CALLING_PLUGIN_VALUE:
      return CALLING_PLUGIN;
    case ADT_OBJECT_TYPE_VALUE:
      return ADT_OBJECT_TYPE;
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
  ImageRegistryId(final int value, final String name, final String literal) {
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

} // ImageRegistryId
