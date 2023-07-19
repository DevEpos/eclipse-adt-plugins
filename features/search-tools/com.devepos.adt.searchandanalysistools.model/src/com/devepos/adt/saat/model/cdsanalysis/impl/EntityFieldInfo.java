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

import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Field Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#getFieldName <em>Field
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#getEntityName <em>Entity
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#getAltEntityName <em>Alt
 * Entity Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#getSourceType <em>Source
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#getType
 * <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#getUri <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#getApiState <em>Api
 * State</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#isKey <em>Key</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#isCalculated
 * <em>Calculated</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.impl.EntityFieldInfo#getChildren
 * <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityFieldInfo extends MinimalEObjectImpl.Container implements IEntityFieldInfo {
  /**
   * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getFieldName()
   * @generated
   * @ordered
   */
  protected static final String FIELD_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getFieldName()
   * @generated
   * @ordered
   */
  protected String fieldName = FIELD_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntityName()
   * @generated
   * @ordered
   */
  protected static final String ENTITY_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntityName()
   * @generated
   * @ordered
   */
  protected String entityName = ENTITY_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getAltEntityName() <em>Alt Entity Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAltEntityName()
   * @generated
   * @ordered
   */
  protected static final String ALT_ENTITY_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAltEntityName() <em>Alt Entity Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAltEntityName()
   * @generated
   * @ordered
   */
  protected String altEntityName = ALT_ENTITY_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSourceType()
   * @generated
   * @ordered
   */
  protected static final String SOURCE_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSourceType()
   * @generated
   * @ordered
   */
  protected String sourceType = SOURCE_TYPE_EDEFAULT;

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
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected static final String URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected String uri = URI_EDEFAULT;

  /**
   * The default value of the '{@link #getApiState() <em>Api State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getApiState()
   * @generated
   * @ordered
   */
  protected static final String API_STATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getApiState() <em>Api State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getApiState()
   * @generated
   * @ordered
   */
  protected String apiState = API_STATE_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #isKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isKey()
   * @generated
   * @ordered
   */
  protected static final boolean KEY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isKey()
   * @generated
   * @ordered
   */
  protected boolean key = KEY_EDEFAULT;

  /**
   * The default value of the '{@link #isCalculated() <em>Calculated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isCalculated()
   * @generated
   * @ordered
   */
  protected static final boolean CALCULATED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCalculated() <em>Calculated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isCalculated()
   * @generated
   * @ordered
   */
  protected boolean calculated = CALCULATED_EDEFAULT;

  /**
   * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getChildren()
   * @generated
   * @ordered
   */
  protected EList<IEntityFieldInfo> children;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected EntityFieldInfo() {
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
    return ICdsAnalysisPackage.Literals.ENTITY_FIELD_INFO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getFieldName() {
    return fieldName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setFieldName(final String newFieldName) {
    String oldFieldName = fieldName;
    fieldName = newFieldName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__FIELD_NAME, oldFieldName, fieldName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getEntityName() {
    return entityName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setEntityName(final String newEntityName) {
    String oldEntityName = entityName;
    entityName = newEntityName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__ENTITY_NAME, oldEntityName, entityName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getAltEntityName() {
    return altEntityName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setAltEntityName(final String newAltEntityName) {
    String oldAltEntityName = altEntityName;
    altEntityName = newAltEntityName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__ALT_ENTITY_NAME, oldAltEntityName, altEntityName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getSourceType() {
    return sourceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSourceType(final String newSourceType) {
    String oldSourceType = sourceType;
    sourceType = newSourceType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__SOURCE_TYPE, oldSourceType, sourceType));
    }
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
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__TYPE, oldType, type));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getUri() {
    return uri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setUri(final String newUri) {
    String oldUri = uri;
    uri = newUri;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__URI, oldUri, uri));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getApiState() {
    return apiState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setApiState(final String newApiState) {
    String oldApiState = apiState;
    apiState = newApiState;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__API_STATE, oldApiState, apiState));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setDescription(final String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__DESCRIPTION, oldDescription, description));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isKey() {
    return key;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setKey(final boolean newKey) {
    boolean oldKey = key;
    key = newKey;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__KEY, oldKey, key));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isCalculated() {
    return calculated;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCalculated(final boolean newCalculated) {
    boolean oldCalculated = calculated;
    calculated = newCalculated;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__CALCULATED, oldCalculated, calculated));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<IEntityFieldInfo> getChildren() {
    if (children == null) {
      children = new EObjectContainmentEList<>(IEntityFieldInfo.class, this,
          ICdsAnalysisPackage.ENTITY_FIELD_INFO__CHILDREN);
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
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__CHILDREN:
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
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__FIELD_NAME:
      return getFieldName();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__ENTITY_NAME:
      return getEntityName();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__ALT_ENTITY_NAME:
      return getAltEntityName();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__SOURCE_TYPE:
      return getSourceType();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__TYPE:
      return getType();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__URI:
      return getUri();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__API_STATE:
      return getApiState();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__DESCRIPTION:
      return getDescription();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__KEY:
      return isKey();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__CALCULATED:
      return isCalculated();
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__CHILDREN:
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
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__FIELD_NAME:
      setFieldName((String) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__ENTITY_NAME:
      setEntityName((String) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__ALT_ENTITY_NAME:
      setAltEntityName((String) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__SOURCE_TYPE:
      setSourceType((String) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__TYPE:
      setType((String) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__URI:
      setUri((String) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__API_STATE:
      setApiState((String) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__DESCRIPTION:
      setDescription((String) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__KEY:
      setKey((Boolean) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__CALCULATED:
      setCalculated((Boolean) newValue);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__CHILDREN:
      getChildren().clear();
      getChildren().addAll((Collection<? extends IEntityFieldInfo>) newValue);
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
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__FIELD_NAME:
      setFieldName(FIELD_NAME_EDEFAULT);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__ENTITY_NAME:
      setEntityName(ENTITY_NAME_EDEFAULT);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__ALT_ENTITY_NAME:
      setAltEntityName(ALT_ENTITY_NAME_EDEFAULT);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__SOURCE_TYPE:
      setSourceType(SOURCE_TYPE_EDEFAULT);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__TYPE:
      setType(TYPE_EDEFAULT);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__URI:
      setUri(URI_EDEFAULT);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__API_STATE:
      setApiState(API_STATE_EDEFAULT);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__DESCRIPTION:
      setDescription(DESCRIPTION_EDEFAULT);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__KEY:
      setKey(KEY_EDEFAULT);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__CALCULATED:
      setCalculated(CALCULATED_EDEFAULT);
      return;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__CHILDREN:
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
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__FIELD_NAME:
      return FIELD_NAME_EDEFAULT == null ? fieldName != null
          : !FIELD_NAME_EDEFAULT.equals(fieldName);
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__ENTITY_NAME:
      return ENTITY_NAME_EDEFAULT == null ? entityName != null
          : !ENTITY_NAME_EDEFAULT.equals(entityName);
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__ALT_ENTITY_NAME:
      return ALT_ENTITY_NAME_EDEFAULT == null ? altEntityName != null
          : !ALT_ENTITY_NAME_EDEFAULT.equals(altEntityName);
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__SOURCE_TYPE:
      return SOURCE_TYPE_EDEFAULT == null ? sourceType != null
          : !SOURCE_TYPE_EDEFAULT.equals(sourceType);
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__TYPE:
      return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__URI:
      return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__API_STATE:
      return API_STATE_EDEFAULT == null ? apiState != null : !API_STATE_EDEFAULT.equals(apiState);
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__DESCRIPTION:
      return DESCRIPTION_EDEFAULT == null ? description != null
          : !DESCRIPTION_EDEFAULT.equals(description);
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__KEY:
      return key != KEY_EDEFAULT;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__CALCULATED:
      return calculated != CALCULATED_EDEFAULT;
    case ICdsAnalysisPackage.ENTITY_FIELD_INFO__CHILDREN:
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
    result.append(" (fieldName: ");
    result.append(fieldName);
    result.append(", entityName: ");
    result.append(entityName);
    result.append(", altEntityName: ");
    result.append(altEntityName);
    result.append(", sourceType: ");
    result.append(sourceType);
    result.append(", type: ");
    result.append(type);
    result.append(", uri: ");
    result.append(uri);
    result.append(", apiState: ");
    result.append(apiState);
    result.append(", description: ");
    result.append(description);
    result.append(", key: ");
    result.append(key);
    result.append(", calculated: ");
    result.append(calculated);
    result.append(')');
    return result.toString();
  }

} // EntityFieldInfo
