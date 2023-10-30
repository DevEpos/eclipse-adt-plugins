/**
 */
package com.devepos.adt.saat.model.cdsanalysis.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cds Used Entity Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getOccurrence
 * <em>Occurrence</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getEntityCount
 * <em>Entity Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getJoinCount
 * <em>Join Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getUnionCount
 * <em>Union Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CdsUsedEntityInformation extends MinimalEObjectImpl.Container
    implements ICdsUsedEntityInformation {
  /**
   * The default value of the '{@link #getOccurrence() <em>Occurrence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOccurrence()
   * @generated
   * @ordered
   */
  protected static final int OCCURRENCE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getOccurrence() <em>Occurrence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOccurrence()
   * @generated
   * @ordered
   */
  protected int occurrence = OCCURRENCE_EDEFAULT;

  /**
   * The default value of the '{@link #getEntityCount() <em>Entity Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntityCount()
   * @generated
   * @ordered
   */
  protected static final int ENTITY_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getEntityCount() <em>Entity Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntityCount()
   * @generated
   * @ordered
   */
  protected int entityCount = ENTITY_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getJoinCount() <em>Join Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getJoinCount()
   * @generated
   * @ordered
   */
  protected static final int JOIN_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getJoinCount() <em>Join Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getJoinCount()
   * @generated
   * @ordered
   */
  protected int joinCount = JOIN_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getUnionCount() <em>Union Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getUnionCount()
   * @generated
   * @ordered
   */
  protected static final int UNION_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getUnionCount() <em>Union Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getUnionCount()
   * @generated
   * @ordered
   */
  protected int unionCount = UNION_COUNT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected CdsUsedEntityInformation() {
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
    return ICdsAnalysisPackage.Literals.CDS_USED_ENTITY_INFORMATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getOccurrence() {
    return occurrence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setOccurrence(final int newOccurrence) {
    int oldOccurrence = occurrence;
    occurrence = newOccurrence;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__OCCURRENCE, oldOccurrence, occurrence));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getEntityCount() {
    return entityCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setEntityCount(final int newEntityCount) {
    int oldEntityCount = entityCount;
    entityCount = newEntityCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__ENTITY_COUNT, oldEntityCount,
          entityCount));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getJoinCount() {
    return joinCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setJoinCount(final int newJoinCount) {
    int oldJoinCount = joinCount;
    joinCount = newJoinCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__JOIN_COUNT, oldJoinCount, joinCount));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getUnionCount() {
    return unionCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setUnionCount(final int newUnionCount) {
    int oldUnionCount = unionCount;
    unionCount = newUnionCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__UNION_COUNT, oldUnionCount, unionCount));
    }
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__OCCURRENCE:
      return getOccurrence();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__ENTITY_COUNT:
      return getEntityCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__JOIN_COUNT:
      return getJoinCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__UNION_COUNT:
      return getUnionCount();
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__OCCURRENCE:
      setOccurrence((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__ENTITY_COUNT:
      setEntityCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__JOIN_COUNT:
      setJoinCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__UNION_COUNT:
      setUnionCount((Integer) newValue);
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__OCCURRENCE:
      setOccurrence(OCCURRENCE_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__ENTITY_COUNT:
      setEntityCount(ENTITY_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__JOIN_COUNT:
      setJoinCount(JOIN_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__UNION_COUNT:
      setUnionCount(UNION_COUNT_EDEFAULT);
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__OCCURRENCE:
      return occurrence != OCCURRENCE_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__ENTITY_COUNT:
      return entityCount != ENTITY_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__JOIN_COUNT:
      return joinCount != JOIN_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__UNION_COUNT:
      return unionCount != UNION_COUNT_EDEFAULT;
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
    result.append(" (occurrence: ");
    result.append(occurrence);
    result.append(", entityCount: ");
    result.append(entityCount);
    result.append(", joinCount: ");
    result.append(joinCount);
    result.append(", unionCount: ");
    result.append(unionCount);
    result.append(')');
    return result.toString();
  }

} // CdsUsedEntityInformation
