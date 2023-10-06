/**
 */
package com.devepos.adt.saat.model.cdsanalysis.impl;

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

import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Field Info Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfoResult#getSourceFieldInfo
 * <em>Source Field Info</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfoResult#getFieldInfos
 * <em>Field Infos</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityFieldInfoResult extends MinimalEObjectImpl.Container implements
    IEntityFieldInfoResult {
  /**
   * The cached value of the '{@link #getSourceFieldInfo() <em>Source Field Info</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSourceFieldInfo()
   * @generated
   * @ordered
   */
  protected IEntityFieldInfo sourceFieldInfo;

  /**
   * The cached value of the '{@link #getFieldInfos() <em>Field Infos</em>}' containment reference
   * list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getFieldInfos()
   * @generated
   * @ordered
   */
  protected EList<IEntityFieldInfo> fieldInfos;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected EntityFieldInfoResult() {
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
    return ICdsAnalysisPackage.Literals.ENTITY_FIELD_INFO_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IEntityFieldInfo getSourceFieldInfo() {
    if (sourceFieldInfo != null && sourceFieldInfo.eIsProxy()) {
      InternalEObject oldSourceFieldInfo = (InternalEObject) sourceFieldInfo;
      sourceFieldInfo = (IEntityFieldInfo) eResolveProxy(oldSourceFieldInfo);
      if (sourceFieldInfo != oldSourceFieldInfo && eNotificationRequired()) {
        eNotify(new ENotificationImpl(this, Notification.RESOLVE,
            ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__SOURCE_FIELD_INFO, oldSourceFieldInfo,
            sourceFieldInfo));
      }
    }
    return sourceFieldInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public IEntityFieldInfo basicGetSourceFieldInfo() {
    return sourceFieldInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSourceFieldInfo(final IEntityFieldInfo newSourceFieldInfo) {
    IEntityFieldInfo oldSourceFieldInfo = sourceFieldInfo;
    sourceFieldInfo = newSourceFieldInfo;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__SOURCE_FIELD_INFO, oldSourceFieldInfo,
          sourceFieldInfo));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<IEntityFieldInfo> getFieldInfos() {
    if (fieldInfos == null) {
      fieldInfos = new EObjectContainmentEList<>(IEntityFieldInfo.class, this,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__FIELD_INFOS);
    }
    return fieldInfos;
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
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__FIELD_INFOS:
      return ((InternalEList<?>) getFieldInfos()).basicRemove(otherEnd, msgs);
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
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__SOURCE_FIELD_INFO:
      if (resolve) {
        return getSourceFieldInfo();
      }
      return basicGetSourceFieldInfo();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__FIELD_INFOS:
      return getFieldInfos();
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
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__SOURCE_FIELD_INFO:
      setSourceFieldInfo((IEntityFieldInfo) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__FIELD_INFOS:
      getFieldInfos().clear();
      getFieldInfos().addAll((Collection<? extends IEntityFieldInfo>) newValue);
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
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__SOURCE_FIELD_INFO:
      setSourceFieldInfo((IEntityFieldInfo) null);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__FIELD_INFOS:
      getFieldInfos().clear();
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
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__SOURCE_FIELD_INFO:
      return sourceFieldInfo != null;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO_RESULT__FIELD_INFOS:
      return fieldInfos != null && !fieldInfos.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // EntityFieldInfoResult
