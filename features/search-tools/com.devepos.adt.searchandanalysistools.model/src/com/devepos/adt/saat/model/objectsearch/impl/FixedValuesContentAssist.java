/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.saat.model.objectsearch.IFixedValuesContentAssist;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.ISimpleContentProposal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Values Content Assist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.FixedValuesContentAssist#getProposals
 * <em>Proposals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FixedValuesContentAssist extends ContentAssist implements IFixedValuesContentAssist {
  /**
   * The cached value of the '{@link #getProposals() <em>Proposals</em>}' containment reference
   * list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getProposals()
   * @generated
   * @ordered
   */
  protected EList<ISimpleContentProposal> proposals;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected FixedValuesContentAssist() {
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
    return IObjectSearchPackage.Literals.FIXED_VALUES_CONTENT_ASSIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<ISimpleContentProposal> getProposals() {
    if (proposals == null) {
      proposals = new EObjectContainmentEList<>(ISimpleContentProposal.class,
          this, IObjectSearchPackage.FIXED_VALUES_CONTENT_ASSIST__PROPOSALS);
    }
    return proposals;
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
    case IObjectSearchPackage.FIXED_VALUES_CONTENT_ASSIST__PROPOSALS:
      return ((InternalEList<?>) getProposals()).basicRemove(otherEnd, msgs);
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
    case IObjectSearchPackage.FIXED_VALUES_CONTENT_ASSIST__PROPOSALS:
      return getProposals();
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
    case IObjectSearchPackage.FIXED_VALUES_CONTENT_ASSIST__PROPOSALS:
      getProposals().clear();
      getProposals().addAll((Collection<? extends ISimpleContentProposal>) newValue);
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
    case IObjectSearchPackage.FIXED_VALUES_CONTENT_ASSIST__PROPOSALS:
      getProposals().clear();
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
    case IObjectSearchPackage.FIXED_VALUES_CONTENT_ASSIST__PROPOSALS:
      return proposals != null && !proposals.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // FixedValuesContentAssist
