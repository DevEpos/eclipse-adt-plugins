/**
 */
package com.devepos.adt.base.model.adtbase.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.devepos.adt.base.model.adtbase.AdtPluginFeatureCategory;
import com.devepos.adt.base.model.adtbase.AdtPluginFeatureType;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeature;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;
import com.devepos.adt.base.model.adtbase.IResponseMessage;
import com.devepos.adt.base.model.adtbase.IResponseMessageList;
import com.devepos.adt.base.model.adtbase.IUser;
import com.devepos.adt.base.model.adtbase.MesssageType;
import com.devepos.adt.base.plugin.features.IAdtPluginFeatures;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class AdtBaseFactory extends EFactoryImpl implements IAdtBaseFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  public static IAdtBaseFactory init() {
    try {
      IAdtBaseFactory theAdtBaseFactory = (IAdtBaseFactory) EPackage.Registry.INSTANCE.getEFactory(
          IAdtBasePackage.eNS_URI);
      if (theAdtBaseFactory != null) {
        return theAdtBaseFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AdtBaseFactory();
  }

  /**
   * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   */
  public AdtBaseFactory() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EObject create(final EClass eClass) {
    switch (eClass.getClassifierID()) {
    case IAdtBasePackage.ADT_OBJ_REF:
      return createAdtObjRef();
    case IAdtBasePackage.ADT_OBJ_REF_LIST:
      return createAdtObjRefList();
    case IAdtBasePackage.USER:
      return createUser();
    case IAdtBasePackage.ADT_PLUGIN_FEATURE:
      return createAdtPluginFeature();
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_LIST:
      return createAdtPluginFeatureList();
    case IAdtBasePackage.RESPONSE_MESSAGE:
      return createResponseMessage();
    case IAdtBasePackage.RESPONSE_MESSAGE_LIST:
      return createResponseMessageList();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object createFromString(final EDataType eDataType, final String initialValue) {
    switch (eDataType.getClassifierID()) {
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_TYPE:
      return createAdtPluginFeatureTypeFromString(eDataType, initialValue);
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_CATEGORY:
      return createAdtPluginFeatureCategoryFromString(eDataType, initialValue);
    case IAdtBasePackage.MESSSAGE_TYPE:
      return createMesssageTypeFromString(eDataType, initialValue);
    case IAdtBasePackage.IADT_PLUGIN_FEATURES:
      return createIAdtPluginFeaturesFromString(eDataType, initialValue);
    case IAdtBasePackage.ISTATUS:
      return createIStatusFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String convertToString(final EDataType eDataType, final Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_TYPE:
      return convertAdtPluginFeatureTypeToString(eDataType, instanceValue);
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_CATEGORY:
      return convertAdtPluginFeatureCategoryToString(eDataType, instanceValue);
    case IAdtBasePackage.MESSSAGE_TYPE:
      return convertMesssageTypeToString(eDataType, instanceValue);
    case IAdtBasePackage.IADT_PLUGIN_FEATURES:
      return convertIAdtPluginFeaturesToString(eDataType, instanceValue);
    case IAdtBasePackage.ISTATUS:
      return convertIStatusToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAdtObjRef createAdtObjRef() {
    AdtObjRef adtObjRef = new AdtObjRef();
    return adtObjRef;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAdtObjRefList createAdtObjRefList() {
    AdtObjRefList adtObjRefList = new AdtObjRefList();
    return adtObjRefList;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IUser createUser() {
    User user = new User();
    return user;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAdtPluginFeature createAdtPluginFeature() {
    AdtPluginFeature adtPluginFeature = new AdtPluginFeature();
    return adtPluginFeature;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAdtPluginFeatureList createAdtPluginFeatureList() {
    AdtPluginFeatureList adtPluginFeatureList = new AdtPluginFeatureList();
    return adtPluginFeatureList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IResponseMessage createResponseMessage() {
    ResponseMessage responseMessage = new ResponseMessage();
    return responseMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IResponseMessageList createResponseMessageList() {
    ResponseMessageList responseMessageList = new ResponseMessageList();
    return responseMessageList;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public AdtPluginFeatureType createAdtPluginFeatureTypeFromString(final EDataType eDataType,
      final String initialValue) {
    AdtPluginFeatureType result = AdtPluginFeatureType.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertAdtPluginFeatureTypeToString(final EDataType eDataType,
      final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public AdtPluginFeatureCategory createAdtPluginFeatureCategoryFromString(
      final EDataType eDataType, final String initialValue) {
    AdtPluginFeatureCategory result = AdtPluginFeatureCategory.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertAdtPluginFeatureCategoryToString(final EDataType eDataType,
      final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public MesssageType createMesssageTypeFromString(final EDataType eDataType,
      final String initialValue) {
    MesssageType result = MesssageType.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertMesssageTypeToString(final EDataType eDataType, final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public IAdtPluginFeatures createIAdtPluginFeaturesFromString(final EDataType eDataType,
      final String initialValue) {
    return (IAdtPluginFeatures) super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertIAdtPluginFeaturesToString(final EDataType eDataType,
      final Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public IStatus createIStatusFromString(final EDataType eDataType, final String initialValue) {
    return (IStatus) super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertIStatusToString(final EDataType eDataType, final Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAdtBasePackage getAdtBasePackage() {
    return (IAdtBasePackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @deprecated
   * @generated
   */
  @Deprecated
  public static IAdtBasePackage getPackage() {
    return IAdtBasePackage.eINSTANCE;
  }

} // AdtBaseFactory
