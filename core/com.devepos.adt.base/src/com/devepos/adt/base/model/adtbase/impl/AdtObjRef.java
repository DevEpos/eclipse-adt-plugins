/**
 */
package com.devepos.adt.base.model.adtbase.impl;

import java.lang.reflect.InvocationTargetException;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Adt Obj
 * Ref</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getName <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getAlternativeName <em>Alternative
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getPackageName <em>Package
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getType <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getTadirType <em>Tadir
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getUri <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getParentUri <em>Parent
 * Uri</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getParentName <em>Parent
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getOwner <em>Owner</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getCreatedOn <em>Created
 * On</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getChangedBy <em>Changed
 * By</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getChangedOn <em>Changed
 * On</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtObjRef#getProperties
 * <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdtObjRef extends MinimalEObjectImpl.Container implements IAdtObjRef {
  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getAlternativeName() <em>Alternative Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAlternativeName()
   * @generated
   * @ordered
   */
  protected static final String ALTERNATIVE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAlternativeName() <em>Alternative Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAlternativeName()
   * @generated
   * @ordered
   */
  protected String alternativeName = ALTERNATIVE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getPackageName()
   * @generated
   * @ordered
   */
  protected static final String PACKAGE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getPackageName()
   * @generated
   * @ordered
   */
  protected String packageName = PACKAGE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getTadirType() <em>Tadir Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getTadirType()
   * @generated
   * @ordered
   */
  protected static final String TADIR_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTadirType() <em>Tadir Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getTadirType()
   * @generated
   * @ordered
   */
  protected String tadirType = TADIR_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected static final String URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected String uri = URI_EDEFAULT;

  /**
   * The default value of the '{@link #getParentUri() <em>Parent Uri</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentUri()
   * @generated
   * @ordered
   */
  protected static final String PARENT_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentUri() <em>Parent Uri</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentUri()
   * @generated
   * @ordered
   */
  protected String parentUri = PARENT_URI_EDEFAULT;

  /**
   * The default value of the '{@link #getParentName() <em>Parent Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentName()
   * @generated
   * @ordered
   */
  protected static final String PARENT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentName() <em>Parent Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentName()
   * @generated
   * @ordered
   */
  protected String parentName = PARENT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getOwner()
   * @generated
   * @ordered
   */
  protected static final String OWNER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getOwner()
   * @generated
   * @ordered
   */
  protected String owner = OWNER_EDEFAULT;

  /**
   * The default value of the '{@link #getCreatedOn() <em>Created On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCreatedOn()
   * @generated
   * @ordered
   */
  protected static final XMLGregorianCalendar CREATED_ON_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCreatedOn() <em>Created On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCreatedOn()
   * @generated
   * @ordered
   */
  protected XMLGregorianCalendar createdOn = CREATED_ON_EDEFAULT;

  /**
   * The default value of the '{@link #getChangedBy() <em>Changed By</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getChangedBy()
   * @generated
   * @ordered
   */
  protected static final String CHANGED_BY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getChangedBy() <em>Changed By</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getChangedBy()
   * @generated
   * @ordered
   */
  protected String changedBy = CHANGED_BY_EDEFAULT;

  /**
   * The default value of the '{@link #getChangedOn() <em>Changed On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getChangedOn()
   * @generated
   * @ordered
   */
  protected static final XMLGregorianCalendar CHANGED_ON_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getChangedOn() <em>Changed On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getChangedOn()
   * @generated
   * @ordered
   */
  protected XMLGregorianCalendar changedOn = CHANGED_ON_EDEFAULT;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EMap<String, String> properties;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected AdtObjRef() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case IAdtBasePackage.ADT_OBJ_REF__DESCRIPTION:
      return getDescription();
    case IAdtBasePackage.ADT_OBJ_REF__NAME:
      return getName();
    case IAdtBasePackage.ADT_OBJ_REF__ALTERNATIVE_NAME:
      return getAlternativeName();
    case IAdtBasePackage.ADT_OBJ_REF__PACKAGE_NAME:
      return getPackageName();
    case IAdtBasePackage.ADT_OBJ_REF__TYPE:
      return getType();
    case IAdtBasePackage.ADT_OBJ_REF__TADIR_TYPE:
      return getTadirType();
    case IAdtBasePackage.ADT_OBJ_REF__URI:
      return getUri();
    case IAdtBasePackage.ADT_OBJ_REF__PARENT_URI:
      return getParentUri();
    case IAdtBasePackage.ADT_OBJ_REF__PARENT_NAME:
      return getParentName();
    case IAdtBasePackage.ADT_OBJ_REF__OWNER:
      return getOwner();
    case IAdtBasePackage.ADT_OBJ_REF__CREATED_ON:
      return getCreatedOn();
    case IAdtBasePackage.ADT_OBJ_REF__CHANGED_BY:
      return getChangedBy();
    case IAdtBasePackage.ADT_OBJ_REF__CHANGED_ON:
      return getChangedOn();
    case IAdtBasePackage.ADT_OBJ_REF__PROPERTIES:
      if (coreType) {
        return getProperties();
      }
      return getProperties().map();
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
  public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
      final NotificationChain msgs) {
    switch (featureID) {
    case IAdtBasePackage.ADT_OBJ_REF__PROPERTIES:
      return ((InternalEList<?>) getProperties()).basicRemove(otherEnd, msgs);
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
  public Object eInvoke(final int operationID, final EList<?> arguments)
      throws InvocationTargetException {
    switch (operationID) {
    case IAdtBasePackage.ADT_OBJ_REF___GET_DISPLAY_NAME:
      return getDisplayName();
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case IAdtBasePackage.ADT_OBJ_REF__DESCRIPTION:
      return DESCRIPTION_EDEFAULT == null ? description != null
          : !DESCRIPTION_EDEFAULT.equals(description);
    case IAdtBasePackage.ADT_OBJ_REF__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case IAdtBasePackage.ADT_OBJ_REF__ALTERNATIVE_NAME:
      return ALTERNATIVE_NAME_EDEFAULT == null ? alternativeName != null
          : !ALTERNATIVE_NAME_EDEFAULT.equals(alternativeName);
    case IAdtBasePackage.ADT_OBJ_REF__PACKAGE_NAME:
      return PACKAGE_NAME_EDEFAULT == null ? packageName != null
          : !PACKAGE_NAME_EDEFAULT.equals(packageName);
    case IAdtBasePackage.ADT_OBJ_REF__TYPE:
      return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
    case IAdtBasePackage.ADT_OBJ_REF__TADIR_TYPE:
      return TADIR_TYPE_EDEFAULT == null ? tadirType != null
          : !TADIR_TYPE_EDEFAULT.equals(tadirType);
    case IAdtBasePackage.ADT_OBJ_REF__URI:
      return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
    case IAdtBasePackage.ADT_OBJ_REF__PARENT_URI:
      return PARENT_URI_EDEFAULT == null ? parentUri != null
          : !PARENT_URI_EDEFAULT.equals(parentUri);
    case IAdtBasePackage.ADT_OBJ_REF__PARENT_NAME:
      return PARENT_NAME_EDEFAULT == null ? parentName != null
          : !PARENT_NAME_EDEFAULT.equals(parentName);
    case IAdtBasePackage.ADT_OBJ_REF__OWNER:
      return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
    case IAdtBasePackage.ADT_OBJ_REF__CREATED_ON:
      return CREATED_ON_EDEFAULT == null ? createdOn != null
          : !CREATED_ON_EDEFAULT.equals(createdOn);
    case IAdtBasePackage.ADT_OBJ_REF__CHANGED_BY:
      return CHANGED_BY_EDEFAULT == null ? changedBy != null
          : !CHANGED_BY_EDEFAULT.equals(changedBy);
    case IAdtBasePackage.ADT_OBJ_REF__CHANGED_ON:
      return CHANGED_ON_EDEFAULT == null ? changedOn != null
          : !CHANGED_ON_EDEFAULT.equals(changedOn);
    case IAdtBasePackage.ADT_OBJ_REF__PROPERTIES:
      return properties != null && !properties.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IAdtBasePackage.ADT_OBJ_REF__DESCRIPTION:
      setDescription((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__NAME:
      setName((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__ALTERNATIVE_NAME:
      setAlternativeName((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__PACKAGE_NAME:
      setPackageName((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__TYPE:
      setType((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__TADIR_TYPE:
      setTadirType((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__URI:
      setUri((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__PARENT_URI:
      setParentUri((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__PARENT_NAME:
      setParentName((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__OWNER:
      setOwner((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__CREATED_ON:
      setCreatedOn((XMLGregorianCalendar) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__CHANGED_BY:
      setChangedBy((String) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__CHANGED_ON:
      setChangedOn((XMLGregorianCalendar) newValue);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__PROPERTIES:
      ((EStructuralFeature.Setting) getProperties()).set(newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(final int featureID) {
    switch (featureID) {
    case IAdtBasePackage.ADT_OBJ_REF__DESCRIPTION:
      setDescription(DESCRIPTION_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__NAME:
      setName(NAME_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__ALTERNATIVE_NAME:
      setAlternativeName(ALTERNATIVE_NAME_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__PACKAGE_NAME:
      setPackageName(PACKAGE_NAME_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__TYPE:
      setType(TYPE_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__TADIR_TYPE:
      setTadirType(TADIR_TYPE_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__URI:
      setUri(URI_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__PARENT_URI:
      setParentUri(PARENT_URI_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__PARENT_NAME:
      setParentName(PARENT_NAME_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__OWNER:
      setOwner(OWNER_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__CREATED_ON:
      setCreatedOn(CREATED_ON_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__CHANGED_BY:
      setChangedBy(CHANGED_BY_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__CHANGED_ON:
      setChangedOn(CHANGED_ON_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_OBJ_REF__PROPERTIES:
      getProperties().clear();
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
  public String getAlternativeName() {
    return alternativeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getChangedBy() {
    return changedBy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public XMLGregorianCalendar getChangedOn() {
    return changedOn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public XMLGregorianCalendar getCreatedOn() {
    return createdOn;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
   */
  @Override
  public String getDisplayName() {
    var displayName = getAlternativeName();
    return displayName == null ? getName() : displayName;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getOwner() {
    return owner;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getPackageName() {
    return packageName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentName() {
    return parentName;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentUri() {
    return parentUri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EMap<String, String> getProperties() {
    if (properties == null) {
      properties = new EcoreEMap<>(
          IAdtBasePackage.Literals.STRING_TO_STRING_MAP_ENTRY, StringToStringMapEntry.class, this,
          IAdtBasePackage.ADT_OBJ_REF__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getTadirType() {
    return tadirType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
  public void setAlternativeName(final String newAlternativeName) {
    var oldAlternativeName = alternativeName;
    alternativeName = newAlternativeName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.ADT_OBJ_REF__ALTERNATIVE_NAME, oldAlternativeName, alternativeName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setChangedBy(final String newChangedBy) {
    var oldChangedBy = changedBy;
    changedBy = newChangedBy;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__CHANGED_BY,
          oldChangedBy, changedBy));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setChangedOn(final XMLGregorianCalendar newChangedOn) {
    var oldChangedOn = changedOn;
    changedOn = newChangedOn;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__CHANGED_ON,
          oldChangedOn, changedOn));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCreatedOn(final XMLGregorianCalendar newCreatedOn) {
    var oldCreatedOn = createdOn;
    createdOn = newCreatedOn;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__CREATED_ON,
          oldCreatedOn, createdOn));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setDescription(final String newDescription) {
    var oldDescription = description;
    description = newDescription;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.ADT_OBJ_REF__DESCRIPTION, oldDescription, description));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setName(final String newName) {
    var oldName = name;
    name = newName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__NAME,
          oldName, name));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setOwner(final String newOwner) {
    var oldOwner = owner;
    owner = newOwner;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__OWNER,
          oldOwner, owner));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setPackageName(final String newPackageName) {
    var oldPackageName = packageName;
    packageName = newPackageName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.ADT_OBJ_REF__PACKAGE_NAME, oldPackageName, packageName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentName(final String newParentName) {
    var oldParentName = parentName;
    parentName = newParentName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.ADT_OBJ_REF__PARENT_NAME, oldParentName, parentName));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentUri(final String newParentUri) {
    var oldParentUri = parentUri;
    parentUri = newParentUri;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__PARENT_URI,
          oldParentUri, parentUri));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setTadirType(final String newTadirType) {
    var oldTadirType = tadirType;
    tadirType = newTadirType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__TADIR_TYPE,
          oldTadirType, tadirType));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setType(final String newType) {
    var oldType = type;
    type = newType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__TYPE,
          oldType, type));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setUri(final String newUri) {
    var oldUri = uri;
    uri = newUri;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAdtBasePackage.ADT_OBJ_REF__URI,
          oldUri, uri));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    var result = new StringBuilder(super.toString());
    result.append(" (description: ");
    result.append(description);
    result.append(", name: ");
    result.append(name);
    result.append(", alternativeName: ");
    result.append(alternativeName);
    result.append(", packageName: ");
    result.append(packageName);
    result.append(", type: ");
    result.append(type);
    result.append(", tadirType: ");
    result.append(tadirType);
    result.append(", uri: ");
    result.append(uri);
    result.append(", parentUri: ");
    result.append(parentUri);
    result.append(", parentName: ");
    result.append(parentName);
    result.append(", owner: ");
    result.append(owner);
    result.append(", createdOn: ");
    result.append(createdOn);
    result.append(", changedBy: ");
    result.append(changedBy);
    result.append(", changedOn: ");
    result.append(changedOn);
    result.append(')');
    return result.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IAdtBasePackage.Literals.ADT_OBJ_REF;
  }

} // AdtObjRef
