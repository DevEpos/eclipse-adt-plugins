/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.atm.model.abaptags.IAbapTagContent;
import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abap Tag Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.AbapTagContent#getTags <em>Tags</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.AbapTagContent#getTaggedObjectInfos <em>Tagged
 * Object Infos</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.AbapTagContent#getSharedTags <em>Shared
 * Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbapTagContent extends MinimalEObjectImpl.Container implements IAbapTagContent {
  /**
   * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTags()
   * @generated
   * @ordered
   */
  protected EList<ITag> tags;

  /**
   * The cached value of the '{@link #getTaggedObjectInfos() <em>Tagged Object Infos</em>}'
   * containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTaggedObjectInfos()
   * @generated
   * @ordered
   */
  protected EList<ITaggedObjectInfo> taggedObjectInfos;

  /**
   * The cached value of the '{@link #getSharedTags() <em>Shared Tags</em>}' containment reference
   * list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getSharedTags()
   * @generated
   * @ordered
   */
  protected EList<ITag> sharedTags;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected AbapTagContent() {
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
    return IAbapTagsPackage.Literals.ABAP_TAG_CONTENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<ITag> getTags() {
    if (tags == null) {
      tags = new EObjectContainmentEList<>(ITag.class, this,
          IAbapTagsPackage.ABAP_TAG_CONTENT__TAGS);
    }
    return tags;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<ITaggedObjectInfo> getTaggedObjectInfos() {
    if (taggedObjectInfos == null) {
      taggedObjectInfos = new EObjectContainmentEList<>(ITaggedObjectInfo.class, this,
          IAbapTagsPackage.ABAP_TAG_CONTENT__TAGGED_OBJECT_INFOS);
    }
    return taggedObjectInfos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<ITag> getSharedTags() {
    if (sharedTags == null) {
      sharedTags = new EObjectContainmentEList<>(ITag.class, this,
          IAbapTagsPackage.ABAP_TAG_CONTENT__SHARED_TAGS);
    }
    return sharedTags;
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
    case IAbapTagsPackage.ABAP_TAG_CONTENT__TAGS:
      return ((InternalEList<?>) getTags()).basicRemove(otherEnd, msgs);
    case IAbapTagsPackage.ABAP_TAG_CONTENT__TAGGED_OBJECT_INFOS:
      return ((InternalEList<?>) getTaggedObjectInfos()).basicRemove(otherEnd, msgs);
    case IAbapTagsPackage.ABAP_TAG_CONTENT__SHARED_TAGS:
      return ((InternalEList<?>) getSharedTags()).basicRemove(otherEnd, msgs);
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
    case IAbapTagsPackage.ABAP_TAG_CONTENT__TAGS:
      return getTags();
    case IAbapTagsPackage.ABAP_TAG_CONTENT__TAGGED_OBJECT_INFOS:
      return getTaggedObjectInfos();
    case IAbapTagsPackage.ABAP_TAG_CONTENT__SHARED_TAGS:
      return getSharedTags();
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
    case IAbapTagsPackage.ABAP_TAG_CONTENT__TAGS:
      getTags().clear();
      getTags().addAll((Collection<? extends ITag>) newValue);
      return;
    case IAbapTagsPackage.ABAP_TAG_CONTENT__TAGGED_OBJECT_INFOS:
      getTaggedObjectInfos().clear();
      getTaggedObjectInfos().addAll((Collection<? extends ITaggedObjectInfo>) newValue);
      return;
    case IAbapTagsPackage.ABAP_TAG_CONTENT__SHARED_TAGS:
      getSharedTags().clear();
      getSharedTags().addAll((Collection<? extends ITag>) newValue);
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
    case IAbapTagsPackage.ABAP_TAG_CONTENT__TAGS:
      getTags().clear();
      return;
    case IAbapTagsPackage.ABAP_TAG_CONTENT__TAGGED_OBJECT_INFOS:
      getTaggedObjectInfos().clear();
      return;
    case IAbapTagsPackage.ABAP_TAG_CONTENT__SHARED_TAGS:
      getSharedTags().clear();
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
    case IAbapTagsPackage.ABAP_TAG_CONTENT__TAGS:
      return tags != null && !tags.isEmpty();
    case IAbapTagsPackage.ABAP_TAG_CONTENT__TAGGED_OBJECT_INFOS:
      return taggedObjectInfos != null && !taggedObjectInfos.isEmpty();
    case IAbapTagsPackage.ABAP_TAG_CONTENT__SHARED_TAGS:
      return sharedTags != null && !sharedTags.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // AbapTagContent
