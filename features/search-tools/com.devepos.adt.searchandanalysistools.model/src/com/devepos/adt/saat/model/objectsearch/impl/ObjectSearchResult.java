/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchResult#getResultCount
 * <em>Result Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchResult#getResultObjects
 * <em>Result Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectSearchResult extends MinimalEObjectImpl.Container implements
    IObjectSearchResult {
  /**
   * The default value of the '{@link #getResultCount() <em>Result Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getResultCount()
   * @generated
   * @ordered
   */
  protected static final int RESULT_COUNT_EDEFAULT = 0;
  /**
   * The cached value of the '{@link #getResultCount() <em>Result Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getResultCount()
   * @generated
   * @ordered
   */
  protected int resultCount = RESULT_COUNT_EDEFAULT;
  /**
   * The cached value of the '{@link #getResultObjects() <em>Result Objects</em>}' containment
   * reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getResultObjects()
   * @generated
   * @ordered
   */
  protected EList<IAdtObjRef> resultObjects;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected ObjectSearchResult() {
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
    return IObjectSearchPackage.Literals.OBJECT_SEARCH_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getResultCount() {
    return resultCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setResultCount(final int newResultCount) {
    int oldResultCount = resultCount;
    resultCount = newResultCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_COUNT, oldResultCount, resultCount));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<IAdtObjRef> getResultObjects() {
    if (resultObjects == null) {
      resultObjects = new EObjectContainmentEList<>(IAdtObjRef.class, this,
          IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_OBJECTS);
    }
    return resultObjects;
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
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_OBJECTS:
      return ((InternalEList<?>) getResultObjects()).basicRemove(otherEnd, msgs);
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
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_COUNT:
      return getResultCount();
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_OBJECTS:
      return getResultObjects();
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
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_COUNT:
      setResultCount((Integer) newValue);
      return;
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_OBJECTS:
      getResultObjects().clear();
      getResultObjects().addAll((Collection<? extends IAdtObjRef>) newValue);
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
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_COUNT:
      setResultCount(RESULT_COUNT_EDEFAULT);
      return;
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_OBJECTS:
      getResultObjects().clear();
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
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_COUNT:
      return resultCount != RESULT_COUNT_EDEFAULT;
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT__RESULT_OBJECTS:
      return resultObjects != null && !resultObjects.isEmpty();
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
    result.append(" (resultCount: ");
    result.append(resultCount);
    result.append(')');
    return result.toString();
  }

} // ObjectSearchResult
