/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hierarchy Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResult#getEntries
 * <em>Entries</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResult#getOriginType
 * <em>Origin Type</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResult#getOriginObjectName
 * <em>Origin Object Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResult#getOriginEnclObjectName
 * <em>Origin Encl Object Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResult#getOriginObjectIdentifier
 * <em>Origin Object Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HierarchyResult extends MinimalEObjectImpl.Container implements IHierarchyResult {
  /**
   * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntries()
   * @generated
   * @ordered
   */
  protected EList<IHierarchyResultEntry> entries;

  /**
   * The default value of the '{@link #getOriginType() <em>Origin Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOriginType()
   * @generated
   * @ordered
   */
  protected static final String ORIGIN_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOriginType() <em>Origin Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOriginType()
   * @generated
   * @ordered
   */
  protected String originType = ORIGIN_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getOriginObjectName() <em>Origin Object Name</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOriginObjectName()
   * @generated
   * @ordered
   */
  protected static final String ORIGIN_OBJECT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOriginObjectName() <em>Origin Object Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOriginObjectName()
   * @generated
   * @ordered
   */
  protected String originObjectName = ORIGIN_OBJECT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getOriginEnclObjectName() <em>Origin Encl Object Name</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOriginEnclObjectName()
   * @generated
   * @ordered
   */
  protected static final String ORIGIN_ENCL_OBJECT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOriginEnclObjectName() <em>Origin Encl Object Name</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOriginEnclObjectName()
   * @generated
   * @ordered
   */
  protected String originEnclObjectName = ORIGIN_ENCL_OBJECT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getOriginObjectIdentifier() <em>Origin Object
   * Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOriginObjectIdentifier()
   * @generated
   * @ordered
   */
  protected static final String ORIGIN_OBJECT_IDENTIFIER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOriginObjectIdentifier() <em>Origin Object
   * Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOriginObjectIdentifier()
   * @generated
   * @ordered
   */
  protected String originObjectIdentifier = ORIGIN_OBJECT_IDENTIFIER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected HierarchyResult() {
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
    return ICallhierarchyPackage.Literals.HIERARCHY_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<IHierarchyResultEntry> getEntries() {
    if (entries == null) {
      entries = new EObjectContainmentEList<>(IHierarchyResultEntry.class,
          this, ICallhierarchyPackage.HIERARCHY_RESULT__ENTRIES);
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
  public String getOriginType() {
    return originType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setOriginType(final String newOriginType) {
    String oldOriginType = originType;
    originType = newOriginType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_TYPE, oldOriginType, originType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getOriginObjectName() {
    return originObjectName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setOriginObjectName(final String newOriginObjectName) {
    String oldOriginObjectName = originObjectName;
    originObjectName = newOriginObjectName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_OBJECT_NAME, oldOriginObjectName,
          originObjectName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getOriginEnclObjectName() {
    return originEnclObjectName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setOriginEnclObjectName(final String newOriginEnclObjectName) {
    String oldOriginEnclObjectName = originEnclObjectName;
    originEnclObjectName = newOriginEnclObjectName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_ENCL_OBJECT_NAME, oldOriginEnclObjectName,
          originEnclObjectName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getOriginObjectIdentifier() {
    return originObjectIdentifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setOriginObjectIdentifier(final String newOriginObjectIdentifier) {
    String oldOriginObjectIdentifier = originObjectIdentifier;
    originObjectIdentifier = newOriginObjectIdentifier;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_OBJECT_IDENTIFIER,
          oldOriginObjectIdentifier, originObjectIdentifier));
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
    case ICallhierarchyPackage.HIERARCHY_RESULT__ENTRIES:
      return ((InternalEList<?>) getEntries()).basicRemove(otherEnd, msgs);
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
    case ICallhierarchyPackage.HIERARCHY_RESULT__ENTRIES:
      return getEntries();
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_TYPE:
      return getOriginType();
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_OBJECT_NAME:
      return getOriginObjectName();
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_ENCL_OBJECT_NAME:
      return getOriginEnclObjectName();
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_OBJECT_IDENTIFIER:
      return getOriginObjectIdentifier();
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
    case ICallhierarchyPackage.HIERARCHY_RESULT__ENTRIES:
      getEntries().clear();
      getEntries().addAll((Collection<? extends IHierarchyResultEntry>) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_TYPE:
      setOriginType((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_OBJECT_NAME:
      setOriginObjectName((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_ENCL_OBJECT_NAME:
      setOriginEnclObjectName((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_OBJECT_IDENTIFIER:
      setOriginObjectIdentifier((String) newValue);
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
    case ICallhierarchyPackage.HIERARCHY_RESULT__ENTRIES:
      getEntries().clear();
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_TYPE:
      setOriginType(ORIGIN_TYPE_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_OBJECT_NAME:
      setOriginObjectName(ORIGIN_OBJECT_NAME_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_ENCL_OBJECT_NAME:
      setOriginEnclObjectName(ORIGIN_ENCL_OBJECT_NAME_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_OBJECT_IDENTIFIER:
      setOriginObjectIdentifier(ORIGIN_OBJECT_IDENTIFIER_EDEFAULT);
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
    case ICallhierarchyPackage.HIERARCHY_RESULT__ENTRIES:
      return entries != null && !entries.isEmpty();
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_TYPE:
      return ORIGIN_TYPE_EDEFAULT == null ? originType != null
          : !ORIGIN_TYPE_EDEFAULT.equals(originType);
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_OBJECT_NAME:
      return ORIGIN_OBJECT_NAME_EDEFAULT == null ? originObjectName != null
          : !ORIGIN_OBJECT_NAME_EDEFAULT.equals(originObjectName);
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_ENCL_OBJECT_NAME:
      return ORIGIN_ENCL_OBJECT_NAME_EDEFAULT == null ? originEnclObjectName != null
          : !ORIGIN_ENCL_OBJECT_NAME_EDEFAULT.equals(originEnclObjectName);
    case ICallhierarchyPackage.HIERARCHY_RESULT__ORIGIN_OBJECT_IDENTIFIER:
      return ORIGIN_OBJECT_IDENTIFIER_EDEFAULT == null ? originObjectIdentifier != null
          : !ORIGIN_OBJECT_IDENTIFIER_EDEFAULT.equals(originObjectIdentifier);
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
    result.append(" (originType: ");
    result.append(originType);
    result.append(", originObjectName: ");
    result.append(originObjectName);
    result.append(", originEnclObjectName: ");
    result.append(originEnclObjectName);
    result.append(", originObjectIdentifier: ");
    result.append(originObjectIdentifier);
    result.append(')');
    return result.toString();
  }

} // HierarchyResult
