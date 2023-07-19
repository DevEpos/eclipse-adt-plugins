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
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Down Analysis Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisResult#getSourceEntity
 * <em>Source Entity</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisResult#getEntries
 * <em>Entries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TopDownAnalysisResult extends MinimalEObjectImpl.Container implements
    ITopDownAnalysisResult {
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
   * The cached value of the '{@link #getEntries() <em>Entries</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntries()
   * @generated
   * @ordered
   */
  protected EList<ITopDownAnalysisEntry> entries;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TopDownAnalysisResult() {
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
    return ICdsAnalysisPackage.Literals.TOP_DOWN_ANALYSIS_RESULT;
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
          ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY, oldSourceEntity,
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
            - ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY, null, msgs);
      }
      if (newSourceEntity != null) {
        msgs = ((InternalEObject) newSourceEntity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY, null, msgs);
      }
      msgs = basicSetSourceEntity(newSourceEntity, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    } else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY, newSourceEntity,
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
  public List<ITopDownAnalysisEntry> getEntries() {
    if (entries == null) {
      entries = new EObjectResolvingEList<>(ITopDownAnalysisEntry.class, this,
          ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__ENTRIES);
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
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY:
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
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY:
      return getSourceEntity();
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__ENTRIES:
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
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY:
      setSourceEntity((IAdtObjRef) newValue);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__ENTRIES:
      getEntries().clear();
      getEntries().addAll((Collection<? extends ITopDownAnalysisEntry>) newValue);
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
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY:
      setSourceEntity((IAdtObjRef) null);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__ENTRIES:
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
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__SOURCE_ENTITY:
      return sourceEntity != null;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_RESULT__ENTRIES:
      return entries != null && !entries.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // TopDownAnalysisResult
