/**
 */
package com.devepos.adt.base.model.adtbase.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeature;
import com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList;
import com.devepos.adt.base.model.adtbase.IUser;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 *
 * @see com.devepos.adt.base.model.adtbase.IAdtBasePackage
 * @generated
 */
public class AdtBaseAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected static IAdtBasePackage modelPackage;

  /**
   * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  public AdtBaseAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = IAdtBasePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object. <!--
   * begin-user-doc --> This implementation returns <code>true</code> if the
   * object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   *
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(final Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected AdtBaseSwitch<Adapter> modelSwitch = new AdtBaseSwitch<>() {
    @Override
    public Adapter caseAdtObjRef(final IAdtObjRef object) {
      return createAdtObjRefAdapter();
    }

    @Override
    public Adapter caseAdtObjRefList(final IAdtObjRefList object) {
      return createAdtObjRefListAdapter();
    }

    @Override
    public Adapter caseUser(final IUser object) {
      return createUserAdapter();
    }

    @Override
    public Adapter caseAdtPluginFeature(final IAdtPluginFeature object) {
      return createAdtPluginFeatureAdapter();
    }

    @Override
    public Adapter caseAdtPluginFeatureList(final IAdtPluginFeatureList object) {
      return createAdtPluginFeatureListAdapter();
    }

    @Override
    public Adapter defaultCase(final EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(final Notifier target) {
    return modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRef <em>Adt Obj Ref</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we
   * can easily ignore cases; it's useful to ignore a case when inheritance will
   * catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRef
   * @generated
   */
  public Adapter createAdtObjRefAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.base.model.adtbase.IAdtObjRefList <em>Adt Obj Ref
   * List</em>}'. <!-- begin-user-doc --> This default implementation returns null
   * so that we can easily ignore cases; it's useful to ignore a case when
   * inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.base.model.adtbase.IAdtObjRefList
   * @generated
   */
  public Adapter createAdtObjRefListAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.base.model.adtbase.IUser <em>User</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch
   * all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.base.model.adtbase.IUser
   * @generated
   */
  public Adapter createUserAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeature <em>Adt Plugin
   * Feature</em>}'. <!-- begin-user-doc --> This default implementation returns
   * null so that we can easily ignore cases; it's useful to ignore a case when
   * inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeature
   * @generated
   */
  public Adapter createAdtPluginFeatureAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList <em>Adt
   * Plugin Feature List</em>}'. <!-- begin-user-doc --> This default
   * implementation returns null so that we can easily ignore cases; it's useful
   * to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.base.model.adtbase.IAdtPluginFeatureList
   * @generated
   */
  public Adapter createAdtPluginFeatureListAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case. <!-- begin-user-doc --> This
   * default implementation returns null. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // AdtBaseAdapterFactory
