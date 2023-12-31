/**
 */
package com.devepos.adt.atm.model.abaptags.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagBase;
import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject;
import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckResult;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeleteRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckResult;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfoList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage
 * @generated
 */
public class AbapTagsAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected static IAbapTagsPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  public AbapTagsAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = IAbapTagsPackage.eINSTANCE;
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
  protected AbapTagsSwitch<Adapter> modelSwitch = new AbapTagsSwitch<>() {
    @Override
    public Adapter caseTagBase(final ITagBase object) {
      return createTagBaseAdapter();
    }

    @Override
    public Adapter caseTag(final ITag object) {
      return createTagAdapter();
    }

    @Override
    public Adapter caseTagList(final ITagList object) {
      return createTagListAdapter();
    }

    @Override
    public Adapter caseAdtObjectTag(final IAdtObjectTag object) {
      return createAdtObjectTagAdapter();
    }

    @Override
    public Adapter caseTagPreviewInfo(final ITagPreviewInfo object) {
      return createTagPreviewInfoAdapter();
    }

    @Override
    public Adapter caseTaggedObject(final ITaggedObject object) {
      return createTaggedObjectAdapter();
    }

    @Override
    public Adapter caseTaggedObjectList(final ITaggedObjectList object) {
      return createTaggedObjectListAdapter();
    }

    @Override
    public Adapter caseTaggedObjectTreeRequest(final ITaggedObjectTreeRequest object) {
      return createTaggedObjectTreeRequestAdapter();
    }

    @Override
    public Adapter caseTaggedObjectSearchParams(final ITaggedObjectSearchParams object) {
      return createTaggedObjectSearchParamsAdapter();
    }

    @Override
    public Adapter caseTagDeletionCheckResult(final ITagDeletionCheckResult object) {
      return createTagDeletionCheckResultAdapter();
    }

    @Override
    public Adapter caseTagDeletionCheckObject(final ITagDeletionCheckObject object) {
      return createTagDeletionCheckObjectAdapter();
    }

    @Override
    public Adapter caseTaggedObjectTreeObject(final ITaggedObjectTreeObject object) {
      return createTaggedObjectTreeObjectAdapter();
    }

    @Override
    public Adapter caseTaggedObjectTreeResult(final ITaggedObjectTreeResult object) {
      return createTaggedObjectTreeResultAdapter();
    }

    @Override
    public Adapter caseTaggedObjectListRequest(final ITaggedObjectListRequest object) {
      return createTaggedObjectListRequestAdapter();
    }

    @Override
    public Adapter caseTaggedObjectInfo(final ITaggedObjectInfo object) {
      return createTaggedObjectInfoAdapter();
    }

    @Override
    public Adapter caseTaggedObjectInfoList(final ITaggedObjectInfoList object) {
      return createTaggedObjectInfoListAdapter();
    }

    @Override
    public Adapter caseTaggedObjectDeletionCheckRequest(
        final ITaggedObjectDeletionCheckRequest object) {
      return createTaggedObjectDeletionCheckRequestAdapter();
    }

    @Override
    public Adapter caseTaggedObjectDeletionCheckResult(
        final ITaggedObjectDeletionCheckResult object) {
      return createTaggedObjectDeletionCheckResultAdapter();
    }

    @Override
    public Adapter caseTaggedObjectDeletionCheckObject(
        final ITaggedObjectDeletionCheckObject object) {
      return createTaggedObjectDeletionCheckObjectAdapter();
    }

    @Override
    public Adapter caseTaggedObjectDeleteRequest(final ITaggedObjectDeleteRequest object) {
      return createTaggedObjectDeleteRequestAdapter();
    }

    @Override
    public Adapter defaultCase(final EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc --> <!--
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
   * '{@link com.devepos.adt.atm.model.abaptags.ITagBase <em>Tag Base</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch
   * all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITagBase
   * @generated
   */
  public Adapter createTagBaseAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITag <em>Tag</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch
   * all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITag
   * @generated
   */
  public Adapter createTagAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag <em>Adt Object Tag</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null
   * so that we can easily ignore cases; it's useful to ignore a case when
   * inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag
   * @generated
   */
  public Adapter createAdtObjectTagAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITagList <em>Tag List</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch
   * all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITagList
   * @generated
   */
  public Adapter createTagListAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITagPreviewInfo <em>Tag Preview Info</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null
   * so that we can easily ignore cases; it's useful to ignore a case when
   * inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITagPreviewInfo
   * @generated
   */
  public Adapter createTagPreviewInfoAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObject <em>Tagged Object</em>}'.
   * <!-- begin-user-doc --> This default implementation returns
   * null so that we can easily ignore cases; it's useful to ignore a case when
   * inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObject
   * @generated
   */
  public Adapter createTaggedObjectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectList <em>Tagged Object List</em>}'.
   * <!-- begin-user-doc --> This default implementation
   * returns null so that we can easily ignore cases; it's useful to ignore a case
   * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectList
   * @generated
   */
  public Adapter createTaggedObjectListAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest <em>Tagged Object Tree
   * Request</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest
   * @generated
   */
  public Adapter createTaggedObjectTreeRequestAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams <em>Tagged Object Search
   * Params</em>}'.
   * <!-- begin-user-doc --> This default
   * implementation returns null so that we can easily ignore cases; it's useful
   * to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams
   * @generated
   */
  public Adapter createTaggedObjectSearchParamsAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckResult <em>Tag Deletion Check
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITagDeletionCheckResult
   * @generated
   */
  public Adapter createTagDeletionCheckResultAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject <em>Tag Deletion Check
   * Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject
   * @generated
   */
  public Adapter createTagDeletionCheckObjectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject <em>Tagged Object Tree
   * Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject
   * @generated
   */
  public Adapter createTaggedObjectTreeObjectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult <em>Tagged Object Tree
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult
   * @generated
   */
  public Adapter createTaggedObjectTreeResultAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest <em>Tagged Object List
   * Request</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest
   * @generated
   */
  public Adapter createTaggedObjectListRequestAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo <em>Tagged Object Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo
   * @generated
   */
  public Adapter createTaggedObjectInfoAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfoList <em>Tagged Object Info
   * List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectInfoList
   * @generated
   */
  public Adapter createTaggedObjectInfoListAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckRequest <em>Tagged Object
   * Deletion Check Request</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckRequest
   * @generated
   */
  public Adapter createTaggedObjectDeletionCheckRequestAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckResult <em>Tagged Object
   * Deletion Check Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckResult
   * @generated
   */
  public Adapter createTaggedObjectDeletionCheckResultAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject <em>Tagged Object
   * Deletion Check Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject
   * @generated
   */
  public Adapter createTaggedObjectDeletionCheckObjectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeleteRequest <em>Tagged Object Delete
   * Request</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectDeleteRequest
   * @generated
   */
  public Adapter createTaggedObjectDeleteRequestAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc --> This
   * default implementation returns null. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // AbapTagsAdapterFactory
