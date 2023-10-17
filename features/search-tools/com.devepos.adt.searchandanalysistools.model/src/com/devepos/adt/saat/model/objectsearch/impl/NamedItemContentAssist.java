/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Item Content Assist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.NamedItemContentAssist#getCategoryScheme
 * <em>Category Scheme</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.NamedItemContentAssist#getCategoryTerm
 * <em>Category Term</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.NamedItemContentAssist#getSecondaryCategoryTerm
 * <em>Secondary Category Term</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.NamedItemContentAssist#getInitialFilter
 * <em>Initial Filter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedItemContentAssist extends ContentAssist implements INamedItemContentAssist {
  /**
   * The default value of the '{@link #getCategoryScheme() <em>Category Scheme</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCategoryScheme()
   * @generated
   * @ordered
   */
  protected static final String CATEGORY_SCHEME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCategoryScheme() <em>Category Scheme</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCategoryScheme()
   * @generated
   * @ordered
   */
  protected String categoryScheme = CATEGORY_SCHEME_EDEFAULT;

  /**
   * The default value of the '{@link #getCategoryTerm() <em>Category Term</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCategoryTerm()
   * @generated
   * @ordered
   */
  protected static final String CATEGORY_TERM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCategoryTerm() <em>Category Term</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCategoryTerm()
   * @generated
   * @ordered
   */
  protected String categoryTerm = CATEGORY_TERM_EDEFAULT;

  /**
   * The default value of the '{@link #getSecondaryCategoryTerm() <em>Secondary Category Term</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSecondaryCategoryTerm()
   * @generated
   * @ordered
   */
  protected static final String SECONDARY_CATEGORY_TERM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSecondaryCategoryTerm() <em>Secondary Category Term</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSecondaryCategoryTerm()
   * @generated
   * @ordered
   */
  protected String secondaryCategoryTerm = SECONDARY_CATEGORY_TERM_EDEFAULT;

  /**
   * The default value of the '{@link #getInitialFilter() <em>Initial Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getInitialFilter()
   * @generated
   * @ordered
   */
  protected static final String INITIAL_FILTER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInitialFilter() <em>Initial Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getInitialFilter()
   * @generated
   * @ordered
   */
  protected String initialFilter = INITIAL_FILTER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected NamedItemContentAssist() {
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
    return IObjectSearchPackage.Literals.NAMED_ITEM_CONTENT_ASSIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getCategoryScheme() {
    return categoryScheme;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCategoryScheme(final String newCategoryScheme) {
    String oldCategoryScheme = categoryScheme;
    categoryScheme = newCategoryScheme;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__CATEGORY_SCHEME, oldCategoryScheme,
          categoryScheme));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getCategoryTerm() {
    return categoryTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCategoryTerm(final String newCategoryTerm) {
    String oldCategoryTerm = categoryTerm;
    categoryTerm = newCategoryTerm;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__CATEGORY_TERM, oldCategoryTerm,
          categoryTerm));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getSecondaryCategoryTerm() {
    return secondaryCategoryTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSecondaryCategoryTerm(final String newSecondaryCategoryTerm) {
    String oldSecondaryCategoryTerm = secondaryCategoryTerm;
    secondaryCategoryTerm = newSecondaryCategoryTerm;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__SECONDARY_CATEGORY_TERM,
          oldSecondaryCategoryTerm, secondaryCategoryTerm));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getInitialFilter() {
    return initialFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setInitialFilter(final String newInitialFilter) {
    String oldInitialFilter = initialFilter;
    initialFilter = newInitialFilter;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__INITIAL_FILTER, oldInitialFilter,
          initialFilter));
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
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__CATEGORY_SCHEME:
      return getCategoryScheme();
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__CATEGORY_TERM:
      return getCategoryTerm();
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__SECONDARY_CATEGORY_TERM:
      return getSecondaryCategoryTerm();
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__INITIAL_FILTER:
      return getInitialFilter();
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
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__CATEGORY_SCHEME:
      setCategoryScheme((String) newValue);
      return;
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__CATEGORY_TERM:
      setCategoryTerm((String) newValue);
      return;
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__SECONDARY_CATEGORY_TERM:
      setSecondaryCategoryTerm((String) newValue);
      return;
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__INITIAL_FILTER:
      setInitialFilter((String) newValue);
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
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__CATEGORY_SCHEME:
      setCategoryScheme(CATEGORY_SCHEME_EDEFAULT);
      return;
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__CATEGORY_TERM:
      setCategoryTerm(CATEGORY_TERM_EDEFAULT);
      return;
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__SECONDARY_CATEGORY_TERM:
      setSecondaryCategoryTerm(SECONDARY_CATEGORY_TERM_EDEFAULT);
      return;
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__INITIAL_FILTER:
      setInitialFilter(INITIAL_FILTER_EDEFAULT);
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
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__CATEGORY_SCHEME:
      return CATEGORY_SCHEME_EDEFAULT == null ? categoryScheme != null
          : !CATEGORY_SCHEME_EDEFAULT.equals(categoryScheme);
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__CATEGORY_TERM:
      return CATEGORY_TERM_EDEFAULT == null ? categoryTerm != null
          : !CATEGORY_TERM_EDEFAULT.equals(categoryTerm);
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__SECONDARY_CATEGORY_TERM:
      return SECONDARY_CATEGORY_TERM_EDEFAULT == null ? secondaryCategoryTerm != null
          : !SECONDARY_CATEGORY_TERM_EDEFAULT.equals(secondaryCategoryTerm);
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST__INITIAL_FILTER:
      return INITIAL_FILTER_EDEFAULT == null ? initialFilter != null
          : !INITIAL_FILTER_EDEFAULT.equals(initialFilter);
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
    result.append(" (categoryScheme: ");
    result.append(categoryScheme);
    result.append(", categoryTerm: ");
    result.append(categoryTerm);
    result.append(", secondaryCategoryTerm: ");
    result.append(secondaryCategoryTerm);
    result.append(", initialFilter: ");
    result.append(initialFilter);
    result.append(')');
    return result.toString();
  }

} // NamedItemContentAssist
