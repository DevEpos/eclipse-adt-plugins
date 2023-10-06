/**
 */
package com.devepos.adt.saat.model.cdsanalysis.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cds Used Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntity#getEntityRef <em>Entity
 * Ref</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntity#getUsageInformation
 * <em>Usage Information</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CdsUsedEntity extends MinimalEObjectImpl.Container implements ICdsUsedEntity {
  /**
   * The cached value of the '{@link #getEntityRef() <em>Entity Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntityRef()
   * @generated
   * @ordered
   */
  protected IAdtObjRef entityRef;

  /**
   * The cached value of the '{@link #getUsageInformation() <em>Usage Information</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getUsageInformation()
   * @generated
   * @ordered
   */
  protected ICdsUsedEntityInformation usageInformation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected CdsUsedEntity() {
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
    return ICdsAnalysisPackage.Literals.CDS_USED_ENTITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAdtObjRef getEntityRef() {
    return entityRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public NotificationChain basicSetEntityRef(final IAdtObjRef newEntityRef,
      NotificationChain msgs) {
    IAdtObjRef oldEntityRef = entityRef;
    entityRef = newEntityRef;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY__ENTITY_REF, oldEntityRef, newEntityRef);
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
  public void setEntityRef(final IAdtObjRef newEntityRef) {
    if (newEntityRef != entityRef) {
      NotificationChain msgs = null;
      if (entityRef != null) {
        msgs = ((InternalEObject) entityRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - ICdsAnalysisPackage.CDS_USED_ENTITY__ENTITY_REF, null, msgs);
      }
      if (newEntityRef != null) {
        msgs = ((InternalEObject) newEntityRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - ICdsAnalysisPackage.CDS_USED_ENTITY__ENTITY_REF, null, msgs);
      }
      msgs = basicSetEntityRef(newEntityRef, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    } else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY__ENTITY_REF, newEntityRef, newEntityRef));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ICdsUsedEntityInformation getUsageInformation() {
    if (usageInformation != null && usageInformation.eIsProxy()) {
      InternalEObject oldUsageInformation = (InternalEObject) usageInformation;
      usageInformation = (ICdsUsedEntityInformation) eResolveProxy(oldUsageInformation);
      if (usageInformation != oldUsageInformation && eNotificationRequired()) {
        eNotify(new ENotificationImpl(this, Notification.RESOLVE,
            ICdsAnalysisPackage.CDS_USED_ENTITY__USAGE_INFORMATION, oldUsageInformation,
            usageInformation));
      }
    }
    return usageInformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public ICdsUsedEntityInformation basicGetUsageInformation() {
    return usageInformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setUsageInformation(final ICdsUsedEntityInformation newUsageInformation) {
    ICdsUsedEntityInformation oldUsageInformation = usageInformation;
    usageInformation = newUsageInformation;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY__USAGE_INFORMATION, oldUsageInformation,
          usageInformation));
    }
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY__ENTITY_REF:
      return basicSetEntityRef(null, msgs);
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY__ENTITY_REF:
      return getEntityRef();
    case ICdsAnalysisPackage.CDS_USED_ENTITY__USAGE_INFORMATION:
      if (resolve) {
        return getUsageInformation();
      }
      return basicGetUsageInformation();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case ICdsAnalysisPackage.CDS_USED_ENTITY__ENTITY_REF:
      setEntityRef((IAdtObjRef) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY__USAGE_INFORMATION:
      setUsageInformation((ICdsUsedEntityInformation) newValue);
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY__ENTITY_REF:
      setEntityRef((IAdtObjRef) null);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY__USAGE_INFORMATION:
      setUsageInformation((ICdsUsedEntityInformation) null);
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY__ENTITY_REF:
      return entityRef != null;
    case ICdsAnalysisPackage.CDS_USED_ENTITY__USAGE_INFORMATION:
      return usageInformation != null;
    }
    return super.eIsSet(featureID);
  }

} // CdsUsedEntity
