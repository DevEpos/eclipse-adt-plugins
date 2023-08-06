/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.saat.model.objectsearch.CustomOptionType;
import com.devepos.adt.saat.model.objectsearch.ICustomOption;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.CustomOption#getKey <em>Key</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.CustomOption#getLabel
 * <em>Label</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.CustomOption#getType <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.CustomOption#getDescription
 * <em>Description</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.CustomOption#getOptionValues <em>Option
 * Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CustomOption extends MinimalEObjectImpl.Container implements ICustomOption {
  /**
   * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getKey()
   * @generated
   * @ordered
   */
  protected static final String KEY_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getKey()
   * @generated
   * @ordered
   */
  protected String key = KEY_EDEFAULT;
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
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final CustomOptionType TYPE_EDEFAULT = CustomOptionType.STRING;
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected CustomOptionType type = TYPE_EDEFAULT;
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
   * The cached value of the '{@link #getOptionValues() <em>Option Values</em>}' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getOptionValues()
   * @generated
   * @ordered
   */
  protected EMap<String, String> optionValues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected CustomOption() {
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
    return IObjectSearchPackage.Literals.CUSTOM_OPTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getKey() {
    return key;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setKey(final String newKey) {
    String oldKey = key;
    key = newKey;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IObjectSearchPackage.CUSTOM_OPTION__KEY,
          oldKey, key));
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
          IObjectSearchPackage.CUSTOM_OPTION__LABEL, oldLabel, label));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public CustomOptionType getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setType(final CustomOptionType newType) {
    CustomOptionType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.CUSTOM_OPTION__TYPE, oldType, type));
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
          IObjectSearchPackage.CUSTOM_OPTION__DESCRIPTION, oldDescription, description));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Map<String, String> getOptionValues() {
    if (optionValues == null) {
      optionValues = new EcoreEMap<>(
          IObjectSearchPackage.Literals.STRING_TO_STRING_MAP_ENTRY, StringToStringMapEntry.class,
          this, IObjectSearchPackage.CUSTOM_OPTION__OPTION_VALUES);
    }
    return optionValues.map();
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
    case IObjectSearchPackage.CUSTOM_OPTION__OPTION_VALUES:
      return ((InternalEList<?>) ((EMap.InternalMapView<String, String>) getOptionValues()).eMap())
          .basicRemove(otherEnd, msgs);
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
    case IObjectSearchPackage.CUSTOM_OPTION__KEY:
      return getKey();
    case IObjectSearchPackage.CUSTOM_OPTION__LABEL:
      return getLabel();
    case IObjectSearchPackage.CUSTOM_OPTION__TYPE:
      return getType();
    case IObjectSearchPackage.CUSTOM_OPTION__DESCRIPTION:
      return getDescription();
    case IObjectSearchPackage.CUSTOM_OPTION__OPTION_VALUES:
      if (coreType) {
        return ((EMap.InternalMapView<String, String>) getOptionValues()).eMap();
      }
      return getOptionValues();
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
    case IObjectSearchPackage.CUSTOM_OPTION__KEY:
      setKey((String) newValue);
      return;
    case IObjectSearchPackage.CUSTOM_OPTION__LABEL:
      setLabel((String) newValue);
      return;
    case IObjectSearchPackage.CUSTOM_OPTION__TYPE:
      setType((CustomOptionType) newValue);
      return;
    case IObjectSearchPackage.CUSTOM_OPTION__DESCRIPTION:
      setDescription((String) newValue);
      return;
    case IObjectSearchPackage.CUSTOM_OPTION__OPTION_VALUES:
      ((EStructuralFeature.Setting) ((EMap.InternalMapView<String, String>) getOptionValues())
          .eMap()).set(newValue);
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
    case IObjectSearchPackage.CUSTOM_OPTION__KEY:
      setKey(KEY_EDEFAULT);
      return;
    case IObjectSearchPackage.CUSTOM_OPTION__LABEL:
      setLabel(LABEL_EDEFAULT);
      return;
    case IObjectSearchPackage.CUSTOM_OPTION__TYPE:
      setType(TYPE_EDEFAULT);
      return;
    case IObjectSearchPackage.CUSTOM_OPTION__DESCRIPTION:
      setDescription(DESCRIPTION_EDEFAULT);
      return;
    case IObjectSearchPackage.CUSTOM_OPTION__OPTION_VALUES:
      getOptionValues().clear();
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
    case IObjectSearchPackage.CUSTOM_OPTION__KEY:
      return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
    case IObjectSearchPackage.CUSTOM_OPTION__LABEL:
      return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
    case IObjectSearchPackage.CUSTOM_OPTION__TYPE:
      return type != TYPE_EDEFAULT;
    case IObjectSearchPackage.CUSTOM_OPTION__DESCRIPTION:
      return DESCRIPTION_EDEFAULT == null ? description != null
          : !DESCRIPTION_EDEFAULT.equals(description);
    case IObjectSearchPackage.CUSTOM_OPTION__OPTION_VALUES:
      return optionValues != null && !optionValues.isEmpty();
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
    result.append(" (key: ");
    result.append(key);
    result.append(", label: ");
    result.append(label);
    result.append(", type: ");
    result.append(type);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} // CustomOption
