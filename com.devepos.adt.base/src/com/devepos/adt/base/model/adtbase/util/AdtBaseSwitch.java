/**
 */
package com.devepos.adt.base.model.adtbase.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeature;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;
import com.devepos.adt.base.model.adtbase.IResponseMessage;
import com.devepos.adt.base.model.adtbase.IResponseMessageList;
import com.devepos.adt.base.model.adtbase.IUser;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage
 * @generated
 */
public class AdtBaseSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected static IAdtBasePackage modelPackage;

  /**
   * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   */
  public AdtBaseSwitch() {
    if (modelPackage == null) {
      modelPackage = IAdtBasePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(final EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it
   * yields that result.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(final int classifierID, final EObject theEObject) {
    switch (classifierID) {
    case IAdtBasePackage.ADT_OBJ_REF: {
      IAdtObjRef adtObjRef = (IAdtObjRef) theEObject;
      T result = caseAdtObjRef(adtObjRef);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAdtBasePackage.ADT_OBJ_REF_LIST: {
      IAdtObjRefList adtObjRefList = (IAdtObjRefList) theEObject;
      T result = caseAdtObjRefList(adtObjRefList);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAdtBasePackage.USER: {
      IUser user = (IUser) theEObject;
      T result = caseUser(user);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAdtBasePackage.ADT_PLUGIN_FEATURE: {
      IAdtPluginFeature adtPluginFeature = (IAdtPluginFeature) theEObject;
      T result = caseAdtPluginFeature(adtPluginFeature);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAdtBasePackage.ADT_PLUGIN_FEATURE_LIST: {
      IAdtPluginFeatureList adtPluginFeatureList = (IAdtPluginFeatureList) theEObject;
      T result = caseAdtPluginFeatureList(adtPluginFeatureList);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAdtBasePackage.RESPONSE_MESSAGE: {
      IResponseMessage responseMessage = (IResponseMessage) theEObject;
      T result = caseResponseMessage(responseMessage);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAdtBasePackage.RESPONSE_MESSAGE_LIST: {
      IResponseMessageList responseMessageList = (IResponseMessageList) theEObject;
      T result = caseResponseMessageList(responseMessageList);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Adt Obj Ref</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Adt Obj Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdtObjRef(final IAdtObjRef object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Adt Obj Ref List</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Adt Obj Ref List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdtObjRefList(final IAdtObjRefList object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>User</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>User</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUser(final IUser object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Adt Plugin Feature</em>'.
   * <!-- begin-user-doc --> This implementation returns
   * null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Adt Plugin Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdtPluginFeature(final IAdtPluginFeature object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Adt Plugin Feature
   * List</em>'.
   * <!-- begin-user-doc --> This implementation
   * returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Adt Plugin Feature
   *         List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdtPluginFeatureList(final IAdtPluginFeatureList object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Response Message</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Response Message</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResponseMessage(final IResponseMessage object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Response Message
   * List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Response Message
   *         List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResponseMessageList(final IResponseMessageList object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last
   * case anyway. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(final EObject object) {
    return null;
  }

} // AdtBaseSwitch
