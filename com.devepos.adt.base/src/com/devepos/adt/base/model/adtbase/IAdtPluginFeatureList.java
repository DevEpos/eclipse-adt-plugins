/**
 */
package com.devepos.adt.base.model.adtbase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Adt
 * Plugin Feature List</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList#getFeatures
 * <em>Features</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeatureList()
 * @model extendedMetaData="name='pluginFeatures' kind='elementOnly'"
 * @generated
 */
public interface IAdtPluginFeatureList extends EObject {
  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference
   * list. The list contents are of type
   * {@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature}. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> List of
   * features <!-- end-model-doc -->
   *
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeatureList_Features()
   * @model containment="true" suppressedSetVisibility="true"
   *        extendedMetaData="kind='element' name='pluginFeature'
   *        namespace='##targetNamespace'"
   * @generated
   */
  EList<IAdtPluginFeature> getFeatures();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * Retrieves features with a given endpoint
   *
   * @param endpoint the name of a REST endpoint <!-- end-model-doc -->
   * @model dataType="com.devepos.adt.base.model.adtbase.IAdtPluginFeatures"
   * @generated
   */
  IAdtPluginFeatures getFeaturesByEndpoint(String endpoint);

} // IAdtPluginFeatureList
