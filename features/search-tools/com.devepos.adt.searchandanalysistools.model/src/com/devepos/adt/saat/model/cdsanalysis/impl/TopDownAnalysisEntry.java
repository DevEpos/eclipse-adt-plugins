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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry;
import com.devepos.adt.saat.model.cdsanalysis.SqlRelation;
import com.devepos.adt.saat.model.cdsanalysis.TopDownAnalysisEntryType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Down Analysis Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisEntry#getEntryType
 * <em>Entry Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisEntry#getDdlSourceType
 * <em>Ddl Source Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisEntry#getSqlRelation
 * <em>Sql Relation</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisEntry#getAlias
 * <em>Alias</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisEntry#getEntityRef
 * <em>Entity Ref</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.TopDownAnalysisEntry#getChildren
 * <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TopDownAnalysisEntry extends MinimalEObjectImpl.Container implements
    ITopDownAnalysisEntry {
  /**
   * The default value of the '{@link #getEntryType() <em>Entry Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntryType()
   * @generated
   * @ordered
   */
  protected static final TopDownAnalysisEntryType ENTRY_TYPE_EDEFAULT = TopDownAnalysisEntryType.UNSPECIFIED;

  /**
   * The cached value of the '{@link #getEntryType() <em>Entry Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntryType()
   * @generated
   * @ordered
   */
  protected TopDownAnalysisEntryType entryType = ENTRY_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getDdlSourceType() <em>Ddl Source Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDdlSourceType()
   * @generated
   * @ordered
   */
  protected static final String DDL_SOURCE_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDdlSourceType() <em>Ddl Source Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDdlSourceType()
   * @generated
   * @ordered
   */
  protected String ddlSourceType = DDL_SOURCE_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getSqlRelation() <em>Sql Relation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSqlRelation()
   * @generated
   * @ordered
   */
  protected static final SqlRelation SQL_RELATION_EDEFAULT = SqlRelation.UNSPECIFIED;

  /**
   * The cached value of the '{@link #getSqlRelation() <em>Sql Relation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSqlRelation()
   * @generated
   * @ordered
   */
  protected SqlRelation sqlRelation = SQL_RELATION_EDEFAULT;

  /**
   * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected static final String ALIAS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected String alias = ALIAS_EDEFAULT;

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
   * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getChildren()
   * @generated
   * @ordered
   */
  protected EList<ITopDownAnalysisEntry> children;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TopDownAnalysisEntry() {
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
    return ICdsAnalysisPackage.Literals.TOP_DOWN_ANALYSIS_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public TopDownAnalysisEntryType getEntryType() {
    return entryType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setEntryType(final TopDownAnalysisEntryType newEntryType) {
    TopDownAnalysisEntryType oldEntryType = entryType;
    entryType = newEntryType == null ? ENTRY_TYPE_EDEFAULT : newEntryType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTRY_TYPE, oldEntryType, entryType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getDdlSourceType() {
    return ddlSourceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setDdlSourceType(final String newDdlSourceType) {
    String oldDdlSourceType = ddlSourceType;
    ddlSourceType = newDdlSourceType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__DDL_SOURCE_TYPE, oldDdlSourceType,
          ddlSourceType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public SqlRelation getSqlRelation() {
    return sqlRelation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSqlRelation(final SqlRelation newSqlRelation) {
    SqlRelation oldSqlRelation = sqlRelation;
    sqlRelation = newSqlRelation == null ? SQL_RELATION_EDEFAULT : newSqlRelation;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__SQL_RELATION, oldSqlRelation, sqlRelation));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getAlias() {
    return alias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setAlias(final String newAlias) {
    String oldAlias = alias;
    alias = newAlias;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ALIAS, oldAlias, alias));
    }
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
          ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF, oldEntityRef, newEntityRef);
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
            - ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF, null, msgs);
      }
      if (newEntityRef != null) {
        msgs = ((InternalEObject) newEntityRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF, null, msgs);
      }
      msgs = basicSetEntityRef(newEntityRef, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    } else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF, newEntityRef, newEntityRef));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<ITopDownAnalysisEntry> getChildren() {
    if (children == null) {
      children = new EObjectContainmentEList<>(ITopDownAnalysisEntry.class,
          this, ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__CHILDREN);
    }
    return children;
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
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF:
      return basicSetEntityRef(null, msgs);
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__CHILDREN:
      return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
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
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTRY_TYPE:
      return getEntryType();
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__DDL_SOURCE_TYPE:
      return getDdlSourceType();
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__SQL_RELATION:
      return getSqlRelation();
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ALIAS:
      return getAlias();
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF:
      return getEntityRef();
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__CHILDREN:
      return getChildren();
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
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTRY_TYPE:
      setEntryType((TopDownAnalysisEntryType) newValue);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__DDL_SOURCE_TYPE:
      setDdlSourceType((String) newValue);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__SQL_RELATION:
      setSqlRelation((SqlRelation) newValue);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ALIAS:
      setAlias((String) newValue);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF:
      setEntityRef((IAdtObjRef) newValue);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__CHILDREN:
      getChildren().clear();
      getChildren().addAll((Collection<? extends ITopDownAnalysisEntry>) newValue);
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
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTRY_TYPE:
      setEntryType(ENTRY_TYPE_EDEFAULT);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__DDL_SOURCE_TYPE:
      setDdlSourceType(DDL_SOURCE_TYPE_EDEFAULT);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__SQL_RELATION:
      setSqlRelation(SQL_RELATION_EDEFAULT);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ALIAS:
      setAlias(ALIAS_EDEFAULT);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF:
      setEntityRef((IAdtObjRef) null);
      return;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__CHILDREN:
      getChildren().clear();
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
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTRY_TYPE:
      return entryType != ENTRY_TYPE_EDEFAULT;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__DDL_SOURCE_TYPE:
      return DDL_SOURCE_TYPE_EDEFAULT == null ? ddlSourceType != null
          : !DDL_SOURCE_TYPE_EDEFAULT.equals(ddlSourceType);
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__SQL_RELATION:
      return sqlRelation != SQL_RELATION_EDEFAULT;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ALIAS:
      return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__ENTITY_REF:
      return entityRef != null;
    case ICdsAnalysisPackage.TOP_DOWN_ANALYSIS_ENTRY__CHILDREN:
      return children != null && !children.isEmpty();
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
    result.append(" (entryType: ");
    result.append(entryType);
    result.append(", ddlSourceType: ");
    result.append(ddlSourceType);
    result.append(", sqlRelation: ");
    result.append(sqlRelation);
    result.append(", alias: ");
    result.append(alias);
    result.append(')');
    return result.toString();
  }

} // TopDownAnalysisEntry
