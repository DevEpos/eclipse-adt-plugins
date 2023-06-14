/**
 */
package com.devepos.adt.base.model.adtbase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Adt
 * Plugin Feature</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getName <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getEndpoint
 * <em>Endpoint</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getType <em>Type</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#isEnabled <em>Enabled</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getCategory
 * <em>Category</em>}</li>
 * <li>{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature#getDescription
 * <em>Description</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeature()
 * @model extendedMetaData="name='pluginFeature' kind='elementOnly'"
 * @generated
 */
public interface IAdtPluginFeature extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The name of
   * the feature <!-- end-model-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeature_Name()
   * @model unique="false" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='name'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Returns the value of the '<em><b>Endpoint</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> URI
   * Endpoint where feature is used <!-- end-model-doc -->
   *
   * @return the value of the '<em>Endpoint</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeature_Endpoint()
   * @model suppressedSetVisibility="true" extendedMetaData="kind='attribute'
   *        name='endpoint' namespace='##targetNamespace'"
   * @generated
   */
  String getEndpoint();

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute. The literals are
   * from the enumeration
   * {@link com.devepos.adt.base.model.adtbase.AdtPluginFeatureType}. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The data
   * type of the feature <!-- end-model-doc -->
   *
   * @return the value of the '<em>Type</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.AdtPluginFeatureType
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeature_Type()
   * @model unique="false" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='type'
   *        namespace='##targetNamespace'"
   * @generated
   */
  AdtPluginFeatureType getType();

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Optional
   * description of the feature <!-- end-model-doc -->
   *
   * @return the value of the '<em>Description</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeature_Description()
   * @model unique="false" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='description'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getDescription();

  /**
   * Returns the value of the '<em><b>Enabled</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Enabled
   * status of the feature <!-- end-model-doc -->
   *
   * @return the value of the '<em>Enabled</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeature_Enabled()
   * @model suppressedSetVisibility="true" extendedMetaData="kind='attribute'
   *        name='enabled' namespace='##targetNamespace'"
   * @generated
   */
  boolean isEnabled();

  /**
   * Returns the value of the '<em><b>Category</b></em>' attribute. The default
   * value is <code>"NoCategory"</code>. The literals are from the enumeration
   * {@link com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory}. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The
   * category for the feature <!-- end-model-doc -->
   *
   * @return the value of the '<em>Category</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory
   * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage#getAdtPluginFeature_Category()
   * @model default="NoCategory" unique="false" suppressedSetVisibility="true"
   *        extendedMetaData="kind='attribute' name='category'
   *        namespace='##targetNamespace'"
   * @generated
   */
  AdtPluginFeatureCategory getCategory();

} // IAdtPluginFeature
