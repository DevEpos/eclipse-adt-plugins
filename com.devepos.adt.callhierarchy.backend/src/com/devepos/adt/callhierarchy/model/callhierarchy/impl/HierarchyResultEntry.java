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

import com.devepos.adt.callhierarchy.model.callhierarchy.ICallPosition;
import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage;
import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResultEntry;
import com.devepos.adt.callhierarchy.model.callhierarchy.IMethodProperties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hierarchy Result Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getEnclosedObjectName
 * <em>Enclosed Object Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getEnclosedObjectDisplayName
 * <em>Enclosed Object Display Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getType
 * <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getOwner
 * <em>Owner</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getPackageName
 * <em>Package Name</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getUri
 * <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getParentUri
 * <em>Parent Uri</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getCallPositions
 * <em>Call Positions</em>}</li>
 * <li>{@link com.devepos.adt.callhierarchy.model.callhierarchy.impl.HierarchyResultEntry#getMethodProperties
 * <em>Method Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HierarchyResultEntry extends MinimalEObjectImpl.Container implements
    IHierarchyResultEntry {
  /**
   * The default value of the '{@link #getEnclosedObjectName() <em>Enclosed Object Name</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEnclosedObjectName()
   * @generated
   * @ordered
   */
  protected static final String ENCLOSED_OBJECT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEnclosedObjectName() <em>Enclosed Object Name</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEnclosedObjectName()
   * @generated
   * @ordered
   */
  protected String enclosedObjectName = ENCLOSED_OBJECT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getEnclosedObjectDisplayName() <em>Enclosed Object Display
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEnclosedObjectDisplayName()
   * @generated
   * @ordered
   */
  protected static final String ENCLOSED_OBJECT_DISPLAY_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEnclosedObjectDisplayName() <em>Enclosed Object Display
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEnclosedObjectDisplayName()
   * @generated
   * @ordered
   */
  protected String enclosedObjectDisplayName = ENCLOSED_OBJECT_DISPLAY_NAME_EDEFAULT;

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
   * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOwner()
   * @generated
   * @ordered
   */
  protected static final String OWNER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOwner()
   * @generated
   * @ordered
   */
  protected String owner = OWNER_EDEFAULT;

  /**
   * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getPackageName()
   * @generated
   * @ordered
   */
  protected static final String PACKAGE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getPackageName()
   * @generated
   * @ordered
   */
  protected String packageName = PACKAGE_NAME_EDEFAULT;

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
   * The default value of the '{@link #getParentUri() <em>Parent Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentUri()
   * @generated
   * @ordered
   */
  protected static final String PARENT_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentUri() <em>Parent Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentUri()
   * @generated
   * @ordered
   */
  protected String parentUri = PARENT_URI_EDEFAULT;

  /**
   * The cached value of the '{@link #getCallPositions() <em>Call Positions</em>}' containment
   * reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCallPositions()
   * @generated
   * @ordered
   */
  protected EList<ICallPosition> callPositions;

  /**
   * The cached value of the '{@link #getMethodProperties() <em>Method Properties</em>}' containment
   * reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getMethodProperties()
   * @generated
   * @ordered
   */
  protected IMethodProperties methodProperties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected HierarchyResultEntry() {
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
    return ICallhierarchyPackage.Literals.HIERARCHY_RESULT_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getEnclosedObjectName() {
    return enclosedObjectName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setEnclosedObjectName(final String newEnclosedObjectName) {
    String oldEnclosedObjectName = enclosedObjectName;
    enclosedObjectName = newEnclosedObjectName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_NAME, oldEnclosedObjectName,
          enclosedObjectName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getEnclosedObjectDisplayName() {
    return enclosedObjectDisplayName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setEnclosedObjectDisplayName(final String newEnclosedObjectDisplayName) {
    String oldEnclosedObjectDisplayName = enclosedObjectDisplayName;
    enclosedObjectDisplayName = newEnclosedObjectDisplayName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_DISPLAY_NAME,
          oldEnclosedObjectDisplayName, enclosedObjectDisplayName));
    }
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
  public void setName(final String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__NAME, oldName, name));
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
  public void setType(final String newType) {
    String oldType = type;
    type = newType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__TYPE, oldType, type));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getOwner() {
    return owner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void setOwner(final String newOwner) {
    String oldOwner = owner;
    owner = newOwner;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__OWNER, oldOwner, owner));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
  public void setPackageName(final String newPackageName) {
    String oldPackageName = packageName;
    packageName = newPackageName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__PACKAGE_NAME, oldPackageName, packageName));
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
  public void setDescription(final String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__DESCRIPTION, oldDescription, description));
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
  public void setUri(final String newUri) {
    String oldUri = uri;
    uri = newUri;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__URI, oldUri, uri));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
  public void setParentUri(final String newParentUri) {
    String oldParentUri = parentUri;
    parentUri = newParentUri;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__PARENT_URI, oldParentUri, parentUri));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<ICallPosition> getCallPositions() {
    if (callPositions == null) {
      callPositions = new EObjectContainmentEList<>(ICallPosition.class, this,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__CALL_POSITIONS);
    }
    return callPositions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IMethodProperties getMethodProperties() {
    return methodProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public NotificationChain basicSetMethodProperties(final IMethodProperties newMethodProperties,
      NotificationChain msgs) {
    IMethodProperties oldMethodProperties = methodProperties;
    methodProperties = newMethodProperties;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES, oldMethodProperties,
          newMethodProperties);
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
  public void setMethodProperties(final IMethodProperties newMethodProperties) {
    if (newMethodProperties != methodProperties) {
      NotificationChain msgs = null;
      if (methodProperties != null) {
        msgs = ((InternalEObject) methodProperties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES, null, msgs);
      }
      if (newMethodProperties != null) {
        msgs = ((InternalEObject) newMethodProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES, null, msgs);
      }
      msgs = basicSetMethodProperties(newMethodProperties, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    } else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES, newMethodProperties,
          newMethodProperties));
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
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__CALL_POSITIONS:
      return ((InternalEList<?>) getCallPositions()).basicRemove(otherEnd, msgs);
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES:
      return basicSetMethodProperties(null, msgs);
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
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_NAME:
      return getEnclosedObjectName();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_DISPLAY_NAME:
      return getEnclosedObjectDisplayName();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__NAME:
      return getName();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__TYPE:
      return getType();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__OWNER:
      return getOwner();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__PACKAGE_NAME:
      return getPackageName();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__DESCRIPTION:
      return getDescription();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__URI:
      return getUri();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__PARENT_URI:
      return getParentUri();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__CALL_POSITIONS:
      return getCallPositions();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES:
      return getMethodProperties();
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
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_NAME:
      setEnclosedObjectName((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_DISPLAY_NAME:
      setEnclosedObjectDisplayName((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__NAME:
      setName((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__TYPE:
      setType((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__OWNER:
      setOwner((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__PACKAGE_NAME:
      setPackageName((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__DESCRIPTION:
      setDescription((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__URI:
      setUri((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__PARENT_URI:
      setParentUri((String) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__CALL_POSITIONS:
      getCallPositions().clear();
      getCallPositions().addAll((Collection<? extends ICallPosition>) newValue);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES:
      setMethodProperties((IMethodProperties) newValue);
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
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_NAME:
      setEnclosedObjectName(ENCLOSED_OBJECT_NAME_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_DISPLAY_NAME:
      setEnclosedObjectDisplayName(ENCLOSED_OBJECT_DISPLAY_NAME_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__NAME:
      setName(NAME_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__TYPE:
      setType(TYPE_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__OWNER:
      setOwner(OWNER_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__PACKAGE_NAME:
      setPackageName(PACKAGE_NAME_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__DESCRIPTION:
      setDescription(DESCRIPTION_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__URI:
      setUri(URI_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__PARENT_URI:
      setParentUri(PARENT_URI_EDEFAULT);
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__CALL_POSITIONS:
      getCallPositions().clear();
      return;
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES:
      setMethodProperties((IMethodProperties) null);
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
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_NAME:
      return ENCLOSED_OBJECT_NAME_EDEFAULT == null ? enclosedObjectName != null
          : !ENCLOSED_OBJECT_NAME_EDEFAULT.equals(enclosedObjectName);
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__ENCLOSED_OBJECT_DISPLAY_NAME:
      return ENCLOSED_OBJECT_DISPLAY_NAME_EDEFAULT == null ? enclosedObjectDisplayName != null
          : !ENCLOSED_OBJECT_DISPLAY_NAME_EDEFAULT.equals(enclosedObjectDisplayName);
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__TYPE:
      return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__OWNER:
      return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__PACKAGE_NAME:
      return PACKAGE_NAME_EDEFAULT == null ? packageName != null
          : !PACKAGE_NAME_EDEFAULT.equals(packageName);
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__DESCRIPTION:
      return DESCRIPTION_EDEFAULT == null ? description != null
          : !DESCRIPTION_EDEFAULT.equals(description);
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__URI:
      return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__PARENT_URI:
      return PARENT_URI_EDEFAULT == null ? parentUri != null
          : !PARENT_URI_EDEFAULT.equals(parentUri);
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__CALL_POSITIONS:
      return callPositions != null && !callPositions.isEmpty();
    case ICallhierarchyPackage.HIERARCHY_RESULT_ENTRY__METHOD_PROPERTIES:
      return methodProperties != null;
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
    result.append(" (enclosedObjectName: ");
    result.append(enclosedObjectName);
    result.append(", enclosedObjectDisplayName: ");
    result.append(enclosedObjectDisplayName);
    result.append(", name: ");
    result.append(name);
    result.append(", type: ");
    result.append(type);
    result.append(", owner: ");
    result.append(owner);
    result.append(", packageName: ");
    result.append(packageName);
    result.append(", description: ");
    result.append(description);
    result.append(", uri: ");
    result.append(uri);
    result.append(", parentUri: ");
    result.append(parentUri);
    result.append(')');
    return result.toString();
  }

} // HierarchyResultEntry
