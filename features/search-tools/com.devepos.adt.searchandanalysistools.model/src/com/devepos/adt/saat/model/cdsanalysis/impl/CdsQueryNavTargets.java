/**
 */
package com.devepos.adt.saat.model.cdsanalysis.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget;
import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cds Query Nav Targets</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsQueryNavTargets#getNavigationTargets
 * <em>Navigation Targets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CdsQueryNavTargets extends MinimalEObjectImpl.Container implements
    ICdsQueryNavTargets {
  /**
   * The cached value of the '{@link #getNavigationTargets() <em>Navigation Targets</em>}' attribute
   * list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getNavigationTargets()
   * @generated
   * @ordered
   */
  protected EList<CdsQueryNavTarget> navigationTargets;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected CdsQueryNavTargets() {
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
    return ICdsAnalysisPackage.Literals.CDS_QUERY_NAV_TARGETS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<CdsQueryNavTarget> getNavigationTargets() {
    if (navigationTargets == null) {
      navigationTargets = new EDataTypeUniqueEList<>(CdsQueryNavTarget.class, this,
          ICdsAnalysisPackage.CDS_QUERY_NAV_TARGETS__NAVIGATION_TARGETS);
    }
    return navigationTargets;
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
    case ICdsAnalysisPackage.CDS_QUERY_NAV_TARGETS__NAVIGATION_TARGETS:
      return getNavigationTargets();
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
    case ICdsAnalysisPackage.CDS_QUERY_NAV_TARGETS__NAVIGATION_TARGETS:
      getNavigationTargets().clear();
      getNavigationTargets().addAll((Collection<? extends CdsQueryNavTarget>) newValue);
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
    case ICdsAnalysisPackage.CDS_QUERY_NAV_TARGETS__NAVIGATION_TARGETS:
      getNavigationTargets().clear();
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
    case ICdsAnalysisPackage.CDS_QUERY_NAV_TARGETS__NAVIGATION_TARGETS:
      return navigationTargets != null && !navigationTargets.isEmpty();
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
    result.append(" (navigationTargets: ");
    result.append(navigationTargets);
    result.append(')');
    return result.toString();
  }

} // CdsQueryNavTargets
