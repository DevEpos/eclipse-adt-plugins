/**
 */
package com.devepos.adt.saat.model.cdsanalysis.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry;
import com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Where Used In Cds Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.WhereUsedInCdsResult#getEntries
 * <em>Entries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhereUsedInCdsResult extends MinimalEObjectImpl.Container
    implements IWhereUsedInCdsResult {
  /**
   * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntries()
   * @generated
   * @ordered
   */
  protected EList<IWhereUsedInCdsEntry> entries;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected WhereUsedInCdsResult() {
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
    return ICdsAnalysisPackage.Literals.WHERE_USED_IN_CDS_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<IWhereUsedInCdsEntry> getEntries() {
    if (entries == null) {
      entries = new EObjectContainmentEList<>(IWhereUsedInCdsEntry.class, this,
          ICdsAnalysisPackage.WHERE_USED_IN_CDS_RESULT__ENTRIES);
    }
    return entries;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
      final NotificationChain msgs) {
    switch (featureID) {
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_RESULT__ENTRIES:
      return ((InternalEList<?>) getEntries()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_RESULT__ENTRIES:
      return getEntries();
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
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_RESULT__ENTRIES:
      getEntries().clear();
      getEntries().addAll((Collection<? extends IWhereUsedInCdsEntry>) newValue);
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
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_RESULT__ENTRIES:
      getEntries().clear();
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
    case ICdsAnalysisPackage.WHERE_USED_IN_CDS_RESULT__ENTRIES:
      return entries != null && !entries.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // WhereUsedInCdsResult
