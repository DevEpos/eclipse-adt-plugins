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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cds Used Entities Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntitiesResult#getSourceEntity
 * <em>Source Entity</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntitiesResult#getUsedEntities
 * <em>Used Entities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CdsUsedEntitiesResult extends MinimalEObjectImpl.Container implements
    ICdsUsedEntitiesResult {
  /**
   * The cached value of the '{@link #getSourceEntity() <em>Source Entity</em>}' containment
   * reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSourceEntity()
   * @generated
   * @ordered
   */
  protected IAdtObjRef sourceEntity;

  /**
   * The cached value of the '{@link #getUsedEntities() <em>Used Entities</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getUsedEntities()
   * @generated
   * @ordered
   */
  protected EList<ICdsUsedEntity> usedEntities;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected CdsUsedEntitiesResult() {
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
    return ICdsAnalysisPackage.Literals.CDS_USED_ENTITIES_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAdtObjRef getSourceEntity() {
    return sourceEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public NotificationChain basicSetSourceEntity(final IAdtObjRef newSourceEntity,
      NotificationChain msgs) {
    IAdtObjRef oldSourceEntity = sourceEntity;
    sourceEntity = newSourceEntity;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY, oldSourceEntity,
          newSourceEntity);
      if (msgs == null) {
        msgs = notification;
      } else {
        msgs.add(notification);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSourceEntity(final IAdtObjRef newSourceEntity) {
    if (newSourceEntity != sourceEntity) {
      NotificationChain msgs = null;
      if (sourceEntity != null) {
        msgs = ((InternalEObject) sourceEntity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY, null, msgs);
      }
      if (newSourceEntity != null) {
        msgs = ((InternalEObject) newSourceEntity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY, null, msgs);
      }
      msgs = basicSetSourceEntity(newSourceEntity, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    } else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY, newSourceEntity,
          newSourceEntity));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<ICdsUsedEntity> getUsedEntities() {
    if (usedEntities == null) {
      usedEntities = new EObjectResolvingEList<>(ICdsUsedEntity.class, this,
          ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__USED_ENTITIES);
    }
    return usedEntities;
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
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY:
      return basicSetSourceEntity(null, msgs);
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
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY:
      return getSourceEntity();
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__USED_ENTITIES:
      return getUsedEntities();
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
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY:
      setSourceEntity((IAdtObjRef) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__USED_ENTITIES:
      getUsedEntities().clear();
      getUsedEntities().addAll((Collection<? extends ICdsUsedEntity>) newValue);
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
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY:
      setSourceEntity((IAdtObjRef) null);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__USED_ENTITIES:
      getUsedEntities().clear();
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
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__SOURCE_ENTITY:
      return sourceEntity != null;
    case ICdsAnalysisPackage.CDS_USED_ENTITIES_RESULT__USED_ENTITIES:
      return usedEntities != null && !usedEntities.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // CdsUsedEntitiesResult
