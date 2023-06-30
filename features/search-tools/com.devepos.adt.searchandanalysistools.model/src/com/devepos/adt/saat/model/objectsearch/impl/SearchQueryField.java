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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryField;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Query Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryField#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryField#getValues
 * <em>Values</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryField#getFilters
 * <em>Filters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchQueryField extends MinimalEObjectImpl.Container implements ISearchQueryField {
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected EList<String> values;

  /**
   * The cached value of the '{@link #getFilters() <em>Filters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getFilters()
   * @generated
   * @ordered
   */
  protected EList<ISearchQueryFilter> filters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected SearchQueryField() {
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
    return IObjectSearchPackage.Literals.SEARCH_QUERY_FIELD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setName(final String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_QUERY_FIELD__NAME, oldName, name));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<String> getValues() {
    if (values == null) {
      values = new EDataTypeUniqueEList<>(String.class, this,
          IObjectSearchPackage.SEARCH_QUERY_FIELD__VALUES);
    }
    return values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<ISearchQueryFilter> getFilters() {
    if (filters == null) {
      filters = new EObjectContainmentEList<>(ISearchQueryFilter.class, this,
          IObjectSearchPackage.SEARCH_QUERY_FIELD__FILTERS);
    }
    return filters;
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
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__FILTERS:
      return ((InternalEList<?>) getFilters()).basicRemove(otherEnd, msgs);
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
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__NAME:
      return getName();
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__VALUES:
      return getValues();
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__FILTERS:
      return getFilters();
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
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__NAME:
      setName((String) newValue);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__VALUES:
      getValues().clear();
      getValues().addAll((Collection<? extends String>) newValue);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__FILTERS:
      getFilters().clear();
      getFilters().addAll((Collection<? extends ISearchQueryFilter>) newValue);
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
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__NAME:
      setName(NAME_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__VALUES:
      getValues().clear();
      return;
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__FILTERS:
      getFilters().clear();
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
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__VALUES:
      return values != null && !values.isEmpty();
    case IObjectSearchPackage.SEARCH_QUERY_FIELD__FILTERS:
      return filters != null && !filters.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", values: ");
    result.append(values);
    result.append(')');
    return result.toString();
  }

} // SearchQueryField
