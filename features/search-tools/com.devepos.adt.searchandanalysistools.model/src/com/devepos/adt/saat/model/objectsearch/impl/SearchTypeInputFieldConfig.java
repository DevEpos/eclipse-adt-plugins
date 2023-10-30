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
import com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Type Input Field Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInputFieldConfig#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInputFieldConfig#getLabel
 * <em>Label</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInputFieldConfig#isMixed
 * <em>Mixed</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInputFieldConfig#getFilters
 * <em>Filters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchTypeInputFieldConfig extends MinimalEObjectImpl.Container
    implements ISearchTypeInputFieldConfig {
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
   * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected static final String LABEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected String label = LABEL_EDEFAULT;

  /**
   * The default value of the '{@link #isMixed() <em>Mixed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isMixed()
   * @generated
   * @ordered
   */
  protected static final boolean MIXED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMixed() <em>Mixed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isMixed()
   * @generated
   * @ordered
   */
  protected boolean mixed = MIXED_EDEFAULT;

  /**
   * The cached value of the '{@link #getFilters() <em>Filters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getFilters()
   * @generated
   * @ordered
   */
  protected EList<ISearchFilterConfig> filters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected SearchTypeInputFieldConfig() {
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
    return IObjectSearchPackage.Literals.SEARCH_TYPE_INPUT_FIELD_CONFIG;
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
          IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__NAME, oldName, name));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getLabel() {
    return label;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setLabel(final String newLabel) {
    String oldLabel = label;
    label = newLabel;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__LABEL, oldLabel, label));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isMixed() {
    return mixed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setMixed(final boolean newMixed) {
    boolean oldMixed = mixed;
    mixed = newMixed;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__MIXED, oldMixed, mixed));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<ISearchFilterConfig> getFilters() {
    if (filters == null) {
      filters = new EObjectContainmentEList<>(ISearchFilterConfig.class, this,
          IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__FILTERS);
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
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__FILTERS:
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
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__NAME:
      return getName();
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__LABEL:
      return getLabel();
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__MIXED:
      return isMixed();
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__FILTERS:
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
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__NAME:
      setName((String) newValue);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__LABEL:
      setLabel((String) newValue);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__MIXED:
      setMixed((Boolean) newValue);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__FILTERS:
      getFilters().clear();
      getFilters().addAll((Collection<? extends ISearchFilterConfig>) newValue);
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
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__NAME:
      setName(NAME_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__LABEL:
      setLabel(LABEL_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__MIXED:
      setMixed(MIXED_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__FILTERS:
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
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__LABEL:
      return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__MIXED:
      return mixed != MIXED_EDEFAULT;
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG__FILTERS:
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
    result.append(", label: ");
    result.append(label);
    result.append(", mixed: ");
    result.append(mixed);
    result.append(')');
    return result.toString();
  }

} // SearchTypeInputFieldConfig
