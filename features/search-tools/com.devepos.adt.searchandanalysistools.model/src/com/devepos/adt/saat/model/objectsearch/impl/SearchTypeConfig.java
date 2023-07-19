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

import com.devepos.adt.saat.model.objectsearch.IImageInfo;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Type Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeConfig#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeConfig#getLabel
 * <em>Label</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeConfig#getImageInfo <em>Image
 * Info</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeConfig#getInputs
 * <em>Inputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchTypeConfig extends MinimalEObjectImpl.Container implements ISearchTypeConfig {
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
   * The cached value of the '{@link #getImageInfo() <em>Image Info</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getImageInfo()
   * @generated
   * @ordered
   */
  protected IImageInfo imageInfo;

  /**
   * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getInputs()
   * @generated
   * @ordered
   */
  protected EList<ISearchTypeInputFieldConfig> inputs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected SearchTypeConfig() {
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
    return IObjectSearchPackage.Literals.SEARCH_TYPE_CONFIG;
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
          IObjectSearchPackage.SEARCH_TYPE_CONFIG__NAME, oldName, name));
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
          IObjectSearchPackage.SEARCH_TYPE_CONFIG__LABEL, oldLabel, label));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IImageInfo getImageInfo() {
    if (imageInfo != null && imageInfo.eIsProxy()) {
      InternalEObject oldImageInfo = (InternalEObject) imageInfo;
      imageInfo = (IImageInfo) eResolveProxy(oldImageInfo);
      if ((imageInfo != oldImageInfo) && eNotificationRequired()) {
        eNotify(new ENotificationImpl(this, Notification.RESOLVE,
            IObjectSearchPackage.SEARCH_TYPE_CONFIG__IMAGE_INFO, oldImageInfo, imageInfo));
      }
    }
    return imageInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public IImageInfo basicGetImageInfo() {
    return imageInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setImageInfo(final IImageInfo newImageInfo) {
    IImageInfo oldImageInfo = imageInfo;
    imageInfo = newImageInfo;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.SEARCH_TYPE_CONFIG__IMAGE_INFO, oldImageInfo, imageInfo));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<ISearchTypeInputFieldConfig> getInputs() {
    if (inputs == null) {
      inputs = new EObjectContainmentEList<>(
          ISearchTypeInputFieldConfig.class, this, IObjectSearchPackage.SEARCH_TYPE_CONFIG__INPUTS);
    }
    return inputs;
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
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__INPUTS:
      return ((InternalEList<?>) getInputs()).basicRemove(otherEnd, msgs);
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
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__NAME:
      return getName();
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__LABEL:
      return getLabel();
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__IMAGE_INFO:
      if (resolve) {
        return getImageInfo();
      }
      return basicGetImageInfo();
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__INPUTS:
      return getInputs();
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
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__NAME:
      setName((String) newValue);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__LABEL:
      setLabel((String) newValue);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__IMAGE_INFO:
      setImageInfo((IImageInfo) newValue);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__INPUTS:
      getInputs().clear();
      getInputs().addAll((Collection<? extends ISearchTypeInputFieldConfig>) newValue);
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
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__NAME:
      setName(NAME_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__LABEL:
      setLabel(LABEL_EDEFAULT);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__IMAGE_INFO:
      setImageInfo((IImageInfo) null);
      return;
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__INPUTS:
      getInputs().clear();
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
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__LABEL:
      return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__IMAGE_INFO:
      return imageInfo != null;
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG__INPUTS:
      return inputs != null && !inputs.isEmpty();
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
    result.append(')');
    return result.toString();
  }

} // SearchTypeConfig
