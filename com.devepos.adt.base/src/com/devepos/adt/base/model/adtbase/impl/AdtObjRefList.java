/**
 */
package com.devepos.adt.base.model.adtbase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Adt Obj
 * Ref List</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRefList#getObjectReferences
 * <em>Object References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdtObjRefList extends MinimalEObjectImpl.Container implements IAdtObjRefList {
  /**
   * The cached value of the '{@link #getObjectReferences() <em>Object
   * References</em>}' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #getObjectReferences()
   * @generated
   * @ordered
   */
  protected EList<IAdtObjRef> objectReferences;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected AdtObjRefList() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IAdtBasePackage.Literals.ADT_OBJ_REF_LIST;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<IAdtObjRef> getObjectReferences() {
    if (objectReferences == null) {
      objectReferences = new EObjectContainmentEList<>(IAdtObjRef.class, this,
          IAdtBasePackage.ADT_OBJ_REF_LIST__OBJECT_REFERENCES);
    }
    return objectReferences;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
      final NotificationChain msgs) {
    switch (featureID) {
    case IAdtBasePackage.ADT_OBJ_REF_LIST__OBJECT_REFERENCES:
      return ((InternalEList<?>) getObjectReferences()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case IAdtBasePackage.ADT_OBJ_REF_LIST__OBJECT_REFERENCES:
      return getObjectReferences();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IAdtBasePackage.ADT_OBJ_REF_LIST__OBJECT_REFERENCES:
      getObjectReferences().clear();
      getObjectReferences().addAll((Collection<? extends IAdtObjRef>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(final int featureID) {
    switch (featureID) {
    case IAdtBasePackage.ADT_OBJ_REF_LIST__OBJECT_REFERENCES:
      getObjectReferences().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case IAdtBasePackage.ADT_OBJ_REF_LIST__OBJECT_REFERENCES:
      return objectReferences != null && !objectReferences.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // AdtObjRefList
