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

import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryField;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryInput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Query Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryInput#getType
 * <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryInput#getMaxRows <em>Max
 * Rows</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryInput#isCombineFiltersWithAnd
 * <em>Combine Filters With And</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryInput#isWithApiState <em>With
 * Api State</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryInput#isRowLimitDisabled
 * <em>Row Limit Disabled</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryInput#getFields
 * <em>Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchQueryInput extends MinimalEObjectImpl.Container implements ISearchQueryInput {
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getMaxRows() <em>Max Rows</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getMaxRows()
   * @generated
   * @ordered
   */
  protected static final int MAX_ROWS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMaxRows() <em>Max Rows</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getMaxRows()
   * @generated
   * @ordered
   */
  protected int maxRows = MAX_ROWS_EDEFAULT;

  /**
   * The default value of the '{@link #isCombineFiltersWithAnd() <em>Combine Filters With And</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isCombineFiltersWithAnd()
   * @generated
   * @ordered
   */
  protected static final boolean COMBINE_FILTERS_WITH_AND_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCombineFiltersWithAnd() <em>Combine Filters With And</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isCombineFiltersWithAnd()
   * @generated
   * @ordered
   */
  protected boolean combineFiltersWithAnd = COMBINE_FILTERS_WITH_AND_EDEFAULT;

  /**
   * The default value of the '{@link #isWithApiState() <em>With Api State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isWithApiState()
   * @generated
   * @ordered
   */
  protected static final boolean WITH_API_STATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWithApiState() <em>With Api State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isWithApiState()
   * @generated
   * @ordered
   */
  protected boolean withApiState = WITH_API_STATE_EDEFAULT;

  /**
   * The default value of the '{@link #isRowLimitDisabled() <em>Row Limit Disabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isRowLimitDisabled()
   * @generated
   * @ordered
   */
  protected static final boolean ROW_LIMIT_DISABLED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRowLimitDisabled() <em>Row Limit Disabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isRowLimitDisabled()
   * @generated
   * @ordered
   */
  protected boolean rowLimitDisabled = ROW_LIMIT_DISABLED_EDEFAULT;

  /**
   * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getFields()
   * @generated
   * @ordered
   */
  protected EList<ISearchQueryField> fields;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected SearchQueryInput() {
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
    return IObjectSearchPackage.Literals.SEARCH_QUERY_INPUT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setType(final String newType) {
    String oldType = type;
    type = newType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_QUERY_INPUT__TYPE, oldType, type));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getMaxRows() {
    return maxRows;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setMaxRows(final int newMaxRows) {
    int oldMaxRows = maxRows;
    maxRows = newMaxRows;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_QUERY_INPUT__MAX_ROWS, oldMaxRows, maxRows));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isCombineFiltersWithAnd() {
    return combineFiltersWithAnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCombineFiltersWithAnd(final boolean newCombineFiltersWithAnd) {
    boolean oldCombineFiltersWithAnd = combineFiltersWithAnd;
    combineFiltersWithAnd = newCombineFiltersWithAnd;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_QUERY_INPUT__COMBINE_FILTERS_WITH_AND,
          oldCombineFiltersWithAnd, combineFiltersWithAnd));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isWithApiState() {
    return withApiState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setWithApiState(final boolean newWithApiState) {
    boolean oldWithApiState = withApiState;
    withApiState = newWithApiState;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_QUERY_INPUT__WITH_API_STATE, oldWithApiState, withApiState));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isRowLimitDisabled() {
    return rowLimitDisabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setRowLimitDisabled(final boolean newRowLimitDisabled) {
    boolean oldRowLimitDisabled = rowLimitDisabled;
    rowLimitDisabled = newRowLimitDisabled;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_QUERY_INPUT__ROW_LIMIT_DISABLED, oldRowLimitDisabled,
          rowLimitDisabled));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<ISearchQueryField> getFields() {
    if (fields == null) {
      fields = new EObjectContainmentEList<>(ISearchQueryField.class, this,
          IObjectSearchPackage.SEARCH_QUERY_INPUT__FIELDS);
    }
    return fields;
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
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__FIELDS:
      return ((InternalEList<?>) getFields()).basicRemove(otherEnd, msgs);
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
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__TYPE:
      return getType();
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__MAX_ROWS:
      return getMaxRows();
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__COMBINE_FILTERS_WITH_AND:
      return isCombineFiltersWithAnd();
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__WITH_API_STATE:
      return isWithApiState();
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__ROW_LIMIT_DISABLED:
      return isRowLimitDisabled();
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__FIELDS:
      return getFields();
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
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__TYPE:
      setType((String) newValue);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__MAX_ROWS:
      setMaxRows((Integer) newValue);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__COMBINE_FILTERS_WITH_AND:
      setCombineFiltersWithAnd((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__WITH_API_STATE:
      setWithApiState((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__ROW_LIMIT_DISABLED:
      setRowLimitDisabled((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__FIELDS:
      getFields().clear();
      getFields().addAll((Collection<? extends ISearchQueryField>) newValue);
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
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__TYPE:
      setType(TYPE_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__MAX_ROWS:
      setMaxRows(MAX_ROWS_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__COMBINE_FILTERS_WITH_AND:
      setCombineFiltersWithAnd(COMBINE_FILTERS_WITH_AND_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__WITH_API_STATE:
      setWithApiState(WITH_API_STATE_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__ROW_LIMIT_DISABLED:
      setRowLimitDisabled(ROW_LIMIT_DISABLED_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__FIELDS:
      getFields().clear();
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
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__TYPE:
      return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__MAX_ROWS:
      return maxRows != MAX_ROWS_EDEFAULT;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__COMBINE_FILTERS_WITH_AND:
      return combineFiltersWithAnd != COMBINE_FILTERS_WITH_AND_EDEFAULT;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__WITH_API_STATE:
      return withApiState != WITH_API_STATE_EDEFAULT;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__ROW_LIMIT_DISABLED:
      return rowLimitDisabled != ROW_LIMIT_DISABLED_EDEFAULT;
    case IObjectSearchPackage.SEARCH_QUERY_INPUT__FIELDS:
      return fields != null && !fields.isEmpty();
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
    result.append(" (type: ");
    result.append(type);
    result.append(", maxRows: ");
    result.append(maxRows);
    result.append(", combineFiltersWithAnd: ");
    result.append(combineFiltersWithAnd);
    result.append(", withApiState: ");
    result.append(withApiState);
    result.append(", rowLimitDisabled: ");
    result.append(rowLimitDisabled);
    result.append(')');
    return result.toString();
  }

} // SearchQueryInput
