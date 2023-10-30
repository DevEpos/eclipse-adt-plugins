/**
 */
package com.devepos.adt.base.model.adtbase.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.base.internal.plugin.features.AdtPluginFeatures;
import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeature;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;
import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Adt
 * Plugin Feature List</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.impl.AdtPluginFeatureList#getFeatures
 * <em>Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdtPluginFeatureList extends MinimalEObjectImpl.Container
    implements IAdtPluginFeatureList {
  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<IAdtPluginFeature> features;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected AdtPluginFeatureList() {
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
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_LIST__FEATURES:
      return getFeatures();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
      final NotificationChain msgs) {
    switch (featureID) {
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_LIST__FEATURES:
      return ((InternalEList<?>) getFeatures()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eInvoke(final int operationID, final EList<?> arguments)
      throws InvocationTargetException {
    switch (operationID) {
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_LIST___GET_FEATURES_BY_ENDPOINT__STRING:
      return getFeaturesByEndpoint((String) arguments.get(0));
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
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_LIST__FEATURES:
      return features != null && !features.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_LIST__FEATURES:
      getFeatures().clear();
      getFeatures().addAll((Collection<? extends IAdtPluginFeature>) newValue);
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
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_LIST__FEATURES:
      getFeatures().clear();
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
  public EList<IAdtPluginFeature> getFeatures() {
    if (features == null) {
      features = new EObjectContainmentEList<>(IAdtPluginFeature.class, this,
          IAdtBasePackage.ADT_PLUGIN_FEATURE_LIST__FEATURES);
    }
    return features;
  }

  @Override
  public IAdtPluginFeatures getFeaturesByEndpoint(final String endpoint) {
    if (endpoint == null || endpoint.isEmpty()) {
      return null;
    }
    List<IAdtPluginFeature> filteredFeatures = getFeatures().stream()
        .filter(feature -> endpoint.equals(feature.getEndpoint()))
        .collect(Collectors.toList());
    return !filteredFeatures.isEmpty() ? new AdtPluginFeatures(filteredFeatures) : null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IAdtBasePackage.Literals.ADT_PLUGIN_FEATURE_LIST;
  }

} // AdtPluginFeatureList
