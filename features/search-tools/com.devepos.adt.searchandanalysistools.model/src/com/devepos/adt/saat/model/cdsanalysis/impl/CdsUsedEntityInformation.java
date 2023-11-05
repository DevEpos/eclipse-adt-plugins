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
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getCdsViewCount
 * <em>Cds View Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getTableFunctionCount
 * <em>Table Function Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getViewCount
 * <em>View Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getTableCount
 * <em>Table Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getJoinCount
 * <em>Join Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getSetOperationCount
 * <em>Set Operation Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getGroupByCount
 * <em>Group By Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getFunctionCount
 * <em>Function Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getCaseCount
 * <em>Case Count</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.CdsUsedEntityInformation#getCastCount
 * <em>Cast Count</em>}</li>
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
   * The default value of the '{@link #getCdsViewCount() <em>Cds View Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCdsViewCount()
   * @generated
   * @ordered
   */
  protected static final int CDS_VIEW_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getCdsViewCount() <em>Cds View Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCdsViewCount()
   * @generated
   * @ordered
   */
  protected int cdsViewCount = CDS_VIEW_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getTableFunctionCount() <em>Table Function Count</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTableFunctionCount()
   * @generated
   * @ordered
   */
  protected static final int TABLE_FUNCTION_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTableFunctionCount() <em>Table Function Count</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTableFunctionCount()
   * @generated
   * @ordered
   */
  protected int tableFunctionCount = TABLE_FUNCTION_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getViewCount() <em>View Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getViewCount()
   * @generated
   * @ordered
   */
  protected static final int VIEW_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getViewCount() <em>View Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getViewCount()
   * @generated
   * @ordered
   */
  protected int viewCount = VIEW_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getTableCount() <em>Table Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTableCount()
   * @generated
   * @ordered
   */
  protected static final int TABLE_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTableCount() <em>Table Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTableCount()
   * @generated
   * @ordered
   */
  protected int tableCount = TABLE_COUNT_EDEFAULT;

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
   * The default value of the '{@link #getSetOperationCount() <em>Set Operation Count</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSetOperationCount()
   * @generated
   * @ordered
   */
  protected static final int SET_OPERATION_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSetOperationCount() <em>Set Operation Count</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSetOperationCount()
   * @generated
   * @ordered
   */
  protected int setOperationCount = SET_OPERATION_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getGroupByCount() <em>Group By Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getGroupByCount()
   * @generated
   * @ordered
   */
  protected static final int GROUP_BY_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getGroupByCount() <em>Group By Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getGroupByCount()
   * @generated
   * @ordered
   */
  protected int groupByCount = GROUP_BY_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getFunctionCount() <em>Function Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getFunctionCount()
   * @generated
   * @ordered
   */
  protected static final int FUNCTION_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getFunctionCount() <em>Function Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getFunctionCount()
   * @generated
   * @ordered
   */
  protected int functionCount = FUNCTION_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getCaseCount() <em>Case Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCaseCount()
   * @generated
   * @ordered
   */
  protected static final int CASE_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getCaseCount() <em>Case Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCaseCount()
   * @generated
   * @ordered
   */
  protected int caseCount = CASE_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getCastCount() <em>Cast Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCastCount()
   * @generated
   * @ordered
   */
  protected static final int CAST_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getCastCount() <em>Cast Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCastCount()
   * @generated
   * @ordered
   */
  protected int castCount = CAST_COUNT_EDEFAULT;

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
  public int getCdsViewCount() {
    return cdsViewCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCdsViewCount(final int newCdsViewCount) {
    int oldCdsViewCount = cdsViewCount;
    cdsViewCount = newCdsViewCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CDS_VIEW_COUNT, oldCdsViewCount,
          cdsViewCount));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getTableFunctionCount() {
    return tableFunctionCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setTableFunctionCount(final int newTableFunctionCount) {
    int oldTableFunctionCount = tableFunctionCount;
    tableFunctionCount = newTableFunctionCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__TABLE_FUNCTION_COUNT,
          oldTableFunctionCount, tableFunctionCount));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getViewCount() {
    return viewCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setViewCount(final int newViewCount) {
    int oldViewCount = viewCount;
    viewCount = newViewCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__VIEW_COUNT, oldViewCount, viewCount));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getTableCount() {
    return tableCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setTableCount(final int newTableCount) {
    int oldTableCount = tableCount;
    tableCount = newTableCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__TABLE_COUNT, oldTableCount, tableCount));
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
  public int getSetOperationCount() {
    return setOperationCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSetOperationCount(final int newSetOperationCount) {
    int oldSetOperationCount = setOperationCount;
    setOperationCount = newSetOperationCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__SET_OPERATION_COUNT,
          oldSetOperationCount, setOperationCount));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getGroupByCount() {
    return groupByCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setGroupByCount(final int newGroupByCount) {
    int oldGroupByCount = groupByCount;
    groupByCount = newGroupByCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__GROUP_BY_COUNT, oldGroupByCount,
          groupByCount));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getFunctionCount() {
    return functionCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setFunctionCount(final int newFunctionCount) {
    int oldFunctionCount = functionCount;
    functionCount = newFunctionCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__FUNCTION_COUNT, oldFunctionCount,
          functionCount));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getCaseCount() {
    return caseCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCaseCount(final int newCaseCount) {
    int oldCaseCount = caseCount;
    caseCount = newCaseCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CASE_COUNT, oldCaseCount, caseCount));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getCastCount() {
    return castCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCastCount(final int newCastCount) {
    int oldCastCount = castCount;
    castCount = newCastCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CAST_COUNT, oldCastCount, castCount));
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CDS_VIEW_COUNT:
      return getCdsViewCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__TABLE_FUNCTION_COUNT:
      return getTableFunctionCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__VIEW_COUNT:
      return getViewCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__TABLE_COUNT:
      return getTableCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__JOIN_COUNT:
      return getJoinCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__SET_OPERATION_COUNT:
      return getSetOperationCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__GROUP_BY_COUNT:
      return getGroupByCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__FUNCTION_COUNT:
      return getFunctionCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CASE_COUNT:
      return getCaseCount();
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CAST_COUNT:
      return getCastCount();
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CDS_VIEW_COUNT:
      setCdsViewCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__TABLE_FUNCTION_COUNT:
      setTableFunctionCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__VIEW_COUNT:
      setViewCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__TABLE_COUNT:
      setTableCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__JOIN_COUNT:
      setJoinCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__SET_OPERATION_COUNT:
      setSetOperationCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__GROUP_BY_COUNT:
      setGroupByCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__FUNCTION_COUNT:
      setFunctionCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CASE_COUNT:
      setCaseCount((Integer) newValue);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CAST_COUNT:
      setCastCount((Integer) newValue);
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CDS_VIEW_COUNT:
      setCdsViewCount(CDS_VIEW_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__TABLE_FUNCTION_COUNT:
      setTableFunctionCount(TABLE_FUNCTION_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__VIEW_COUNT:
      setViewCount(VIEW_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__TABLE_COUNT:
      setTableCount(TABLE_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__JOIN_COUNT:
      setJoinCount(JOIN_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__SET_OPERATION_COUNT:
      setSetOperationCount(SET_OPERATION_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__GROUP_BY_COUNT:
      setGroupByCount(GROUP_BY_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__FUNCTION_COUNT:
      setFunctionCount(FUNCTION_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CASE_COUNT:
      setCaseCount(CASE_COUNT_EDEFAULT);
      return;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CAST_COUNT:
      setCastCount(CAST_COUNT_EDEFAULT);
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
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CDS_VIEW_COUNT:
      return cdsViewCount != CDS_VIEW_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__TABLE_FUNCTION_COUNT:
      return tableFunctionCount != TABLE_FUNCTION_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__VIEW_COUNT:
      return viewCount != VIEW_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__TABLE_COUNT:
      return tableCount != TABLE_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__JOIN_COUNT:
      return joinCount != JOIN_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__SET_OPERATION_COUNT:
      return setOperationCount != SET_OPERATION_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__GROUP_BY_COUNT:
      return groupByCount != GROUP_BY_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__FUNCTION_COUNT:
      return functionCount != FUNCTION_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CASE_COUNT:
      return caseCount != CASE_COUNT_EDEFAULT;
    case ICdsAnalysisPackage.CDS_USED_ENTITY_INFORMATION__CAST_COUNT:
      return castCount != CAST_COUNT_EDEFAULT;
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
    result.append(", cdsViewCount: ");
    result.append(cdsViewCount);
    result.append(", tableFunctionCount: ");
    result.append(tableFunctionCount);
    result.append(", viewCount: ");
    result.append(viewCount);
    result.append(", tableCount: ");
    result.append(tableCount);
    result.append(", joinCount: ");
    result.append(joinCount);
    result.append(", setOperationCount: ");
    result.append(setOperationCount);
    result.append(", groupByCount: ");
    result.append(groupByCount);
    result.append(", functionCount: ");
    result.append(functionCount);
    result.append(", caseCount: ");
    result.append(caseCount);
    result.append(", castCount: ");
    result.append(castCount);
    result.append(')');
    return result.toString();
  }

} // CdsUsedEntityInformation
