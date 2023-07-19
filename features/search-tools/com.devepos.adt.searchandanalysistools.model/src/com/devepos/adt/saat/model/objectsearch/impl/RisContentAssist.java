/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.IRisContentAssist;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ris Content Assist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.RisContentAssist#getObjectTypes
 * <em>Object Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RisContentAssist extends ContentAssist implements IRisContentAssist {
  /**
   * The cached value of the '{@link #getObjectTypes() <em>Object Types</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getObjectTypes()
   * @generated
   * @ordered
   */
  protected EList<String> objectTypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected RisContentAssist() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IObjectSearchPackage.Literals.RIS_CONTENT_ASSIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<String> getObjectTypes() {
    if (objectTypes == null) {
      objectTypes = new EDataTypeUniqueEList<>(String.class, this,
          IObjectSearchPackage.RIS_CONTENT_ASSIST__OBJECT_TYPES);
    }
    return objectTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case IObjectSearchPackage.RIS_CONTENT_ASSIST__OBJECT_TYPES:
      return getObjectTypes();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IObjectSearchPackage.RIS_CONTENT_ASSIST__OBJECT_TYPES:
      getObjectTypes().clear();
      getObjectTypes().addAll((Collection<? extends String>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(final int featureID) {
    switch (featureID) {
    case IObjectSearchPackage.RIS_CONTENT_ASSIST__OBJECT_TYPES:
      getObjectTypes().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case IObjectSearchPackage.RIS_CONTENT_ASSIST__OBJECT_TYPES:
      return objectTypes != null && !objectTypes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (objectTypes: ");
    result.append(objectTypes);
    result.append(')');
    return result.toString();
  }

} // RisContentAssist
