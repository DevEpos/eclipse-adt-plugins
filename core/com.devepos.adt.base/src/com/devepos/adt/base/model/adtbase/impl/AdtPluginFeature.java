/**
 */
package com.devepos.adt.base.model.adtbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory;
import com.devepos.adt.base.model.adtbase.AdtPluginFeatureType;
import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeature;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Adt
 * Plugin Feature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeature#getName <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeature#getEndpoint
 * <em>Endpoint</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeature#getType <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeature#isEnabled
 * <em>Enabled</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeature#getCategory
 * <em>Category</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeature#getDescription
 * <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdtPluginFeature extends MinimalEObjectImpl.Container implements IAdtPluginFeature {
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
   * The default value of the '{@link #getEndpoint() <em>Endpoint</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getEndpoint()
   * @generated
   * @ordered
   */
  protected static final String ENDPOINT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEndpoint() <em>Endpoint</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getEndpoint()
   * @generated
   * @ordered
   */
  protected String endpoint = ENDPOINT_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final AdtPluginFeatureType TYPE_EDEFAULT = AdtPluginFeatureType.BOOLEAN;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected AdtPluginFeatureType type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #isEnabled()
   * @generated
   * @ordered
   */
  protected static final boolean ENABLED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #isEnabled()
   * @generated
   * @ordered
   */
  protected boolean enabled = ENABLED_EDEFAULT;

  /**
   * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected static final AdtPluginFeatureCategory CATEGORY_EDEFAULT = AdtPluginFeatureCategory.NO_CATEGORY;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected AdtPluginFeatureCategory category = CATEGORY_EDEFAULT;

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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected AdtPluginFeature() {
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
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__NAME:
      return getName();
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__ENDPOINT:
      return getEndpoint();
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__TYPE:
      return getType();
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__ENABLED:
      return isEnabled();
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__CATEGORY:
      return getCategory();
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__DESCRIPTION:
      return getDescription();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__ENDPOINT:
      return ENDPOINT_EDEFAULT == null ? endpoint != null : !ENDPOINT_EDEFAULT.equals(endpoint);
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__TYPE:
      return type != TYPE_EDEFAULT;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__ENABLED:
      return enabled != ENABLED_EDEFAULT;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__CATEGORY:
      return category != CATEGORY_EDEFAULT;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__DESCRIPTION:
      return DESCRIPTION_EDEFAULT == null ? description != null
          : !DESCRIPTION_EDEFAULT.equals(description);
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
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__NAME:
      setName((String) newValue);
      return;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__ENDPOINT:
      setEndpoint((String) newValue);
      return;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__TYPE:
      setType((AdtPluginFeatureType) newValue);
      return;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__ENABLED:
      setEnabled((Boolean) newValue);
      return;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__CATEGORY:
      setCategory((AdtPluginFeatureCategory) newValue);
      return;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__DESCRIPTION:
      setDescription((String) newValue);
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
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__NAME:
      setName(NAME_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__ENDPOINT:
      setEndpoint(ENDPOINT_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__TYPE:
      setType(TYPE_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__ENABLED:
      setEnabled(ENABLED_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__CATEGORY:
      setCategory(CATEGORY_EDEFAULT);
      return;
    case IAdtBasePackage.ADT_PLUGIN_FEATURE__DESCRIPTION:
      setDescription(DESCRIPTION_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public AdtPluginFeatureCategory getCategory() {
    return category;
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getEndpoint() {
    return endpoint;
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
  public AdtPluginFeatureType getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCategory(final AdtPluginFeatureCategory newCategory) {
    var oldCategory = category;
    category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.ADT_PLUGIN_FEATURE__CATEGORY, oldCategory, category));
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
          IAdtBasePackage.ADT_PLUGIN_FEATURE__DESCRIPTION, oldDescription, description));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setEnabled(final boolean newEnabled) {
    var oldEnabled = enabled;
    enabled = newEnabled;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.ADT_PLUGIN_FEATURE__ENABLED, oldEnabled, enabled));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setEndpoint(final String newEndpoint) {
    var oldEndpoint = endpoint;
    endpoint = newEndpoint;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.ADT_PLUGIN_FEATURE__ENDPOINT, oldEndpoint, endpoint));
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
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.ADT_PLUGIN_FEATURE__NAME, oldName, name));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setType(final AdtPluginFeatureType newType) {
    var oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAdtBasePackage.ADT_PLUGIN_FEATURE__TYPE, oldType, type));
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
    result.append(" (name: ");
    result.append(name);
    result.append(", endpoint: ");
    result.append(endpoint);
    result.append(", type: ");
    result.append(type);
    result.append(", enabled: ");
    result.append(enabled);
    result.append(", category: ");
    result.append(category);
    result.append(", description: ");
    result.append(description);
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
    return IAdtBasePackage.Literals.ADT_PLUGIN_FEATURE;
  }

} // AdtPluginFeature
