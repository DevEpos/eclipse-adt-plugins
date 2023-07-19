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

import com.devepos.adt.saat.model.objectsearch.IContentAssist;
import com.devepos.adt.saat.model.objectsearch.IImageInfo;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.ImageRegistryId;
import com.devepos.adt.saat.model.objectsearch.ProposalImageSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content Assist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.ContentAssist#getProposalImageSource
 * <em>Proposal Image Source</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.ContentAssist#getProposalImageRegistryId
 * <em>Proposal Image Registry Id</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.ContentAssist#getProposalImages
 * <em>Proposal Images</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.impl.ContentAssist#isCachingPossible
 * <em>Caching Possible</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ContentAssist extends MinimalEObjectImpl.Container implements IContentAssist {
  /**
   * The default value of the '{@link #getProposalImageSource() <em>Proposal Image Source</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getProposalImageSource()
   * @generated
   * @ordered
   */
  protected static final ProposalImageSource PROPOSAL_IMAGE_SOURCE_EDEFAULT = ProposalImageSource.FIXED;

  /**
   * The cached value of the '{@link #getProposalImageSource() <em>Proposal Image Source</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getProposalImageSource()
   * @generated
   * @ordered
   */
  protected ProposalImageSource proposalImageSource = PROPOSAL_IMAGE_SOURCE_EDEFAULT;

  /**
   * The default value of the '{@link #getProposalImageRegistryId() <em>Proposal Image Registry
   * Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getProposalImageRegistryId()
   * @generated
   * @ordered
   */
  protected static final ImageRegistryId PROPOSAL_IMAGE_REGISTRY_ID_EDEFAULT = ImageRegistryId.CALLING_PLUGIN;

  /**
   * The cached value of the '{@link #getProposalImageRegistryId() <em>Proposal Image Registry
   * Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getProposalImageRegistryId()
   * @generated
   * @ordered
   */
  protected ImageRegistryId proposalImageRegistryId = PROPOSAL_IMAGE_REGISTRY_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getProposalImages() <em>Proposal Images</em>}' containment
   * reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getProposalImages()
   * @generated
   * @ordered
   */
  protected EList<IImageInfo> proposalImages;

  /**
   * The default value of the '{@link #isCachingPossible() <em>Caching Possible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isCachingPossible()
   * @generated
   * @ordered
   */
  protected static final boolean CACHING_POSSIBLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCachingPossible() <em>Caching Possible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isCachingPossible()
   * @generated
   * @ordered
   */
  protected boolean cachingPossible = CACHING_POSSIBLE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected ContentAssist() {
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
    return IObjectSearchPackage.Literals.CONTENT_ASSIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ProposalImageSource getProposalImageSource() {
    return proposalImageSource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setProposalImageSource(final ProposalImageSource newProposalImageSource) {
    ProposalImageSource oldProposalImageSource = proposalImageSource;
    proposalImageSource = newProposalImageSource == null ? PROPOSAL_IMAGE_SOURCE_EDEFAULT
        : newProposalImageSource;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE, oldProposalImageSource,
          proposalImageSource));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ImageRegistryId getProposalImageRegistryId() {
    return proposalImageRegistryId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setProposalImageRegistryId(final ImageRegistryId newProposalImageRegistryId) {
    ImageRegistryId oldProposalImageRegistryId = proposalImageRegistryId;
    proposalImageRegistryId = newProposalImageRegistryId == null
        ? PROPOSAL_IMAGE_REGISTRY_ID_EDEFAULT
        : newProposalImageRegistryId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID,
          oldProposalImageRegistryId, proposalImageRegistryId));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<IImageInfo> getProposalImages() {
    if (proposalImages == null) {
      proposalImages = new EObjectContainmentEList<>(IImageInfo.class, this,
          IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGES);
    }
    return proposalImages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isCachingPossible() {
    return cachingPossible;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCachingPossible(final boolean newCachingPossible) {
    boolean oldCachingPossible = cachingPossible;
    cachingPossible = newCachingPossible;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IObjectSearchPackage.CONTENT_ASSIST__CACHING_POSSIBLE, oldCachingPossible,
          cachingPossible));
    }
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
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGES:
      return ((InternalEList<?>) getProposalImages()).basicRemove(otherEnd, msgs);
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
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE:
      return getProposalImageSource();
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID:
      return getProposalImageRegistryId();
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGES:
      return getProposalImages();
    case IObjectSearchPackage.CONTENT_ASSIST__CACHING_POSSIBLE:
      return isCachingPossible();
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
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE:
      setProposalImageSource((ProposalImageSource) newValue);
      return;
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID:
      setProposalImageRegistryId((ImageRegistryId) newValue);
      return;
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGES:
      getProposalImages().clear();
      getProposalImages().addAll((Collection<? extends IImageInfo>) newValue);
      return;
    case IObjectSearchPackage.CONTENT_ASSIST__CACHING_POSSIBLE:
      setCachingPossible((Boolean) newValue);
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
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE:
      setProposalImageSource(PROPOSAL_IMAGE_SOURCE_EDEFAULT);
      return;
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID:
      setProposalImageRegistryId(PROPOSAL_IMAGE_REGISTRY_ID_EDEFAULT);
      return;
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGES:
      getProposalImages().clear();
      return;
    case IObjectSearchPackage.CONTENT_ASSIST__CACHING_POSSIBLE:
      setCachingPossible(CACHING_POSSIBLE_EDEFAULT);
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
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE:
      return proposalImageSource != PROPOSAL_IMAGE_SOURCE_EDEFAULT;
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID:
      return proposalImageRegistryId != PROPOSAL_IMAGE_REGISTRY_ID_EDEFAULT;
    case IObjectSearchPackage.CONTENT_ASSIST__PROPOSAL_IMAGES:
      return proposalImages != null && !proposalImages.isEmpty();
    case IObjectSearchPackage.CONTENT_ASSIST__CACHING_POSSIBLE:
      return cachingPossible != CACHING_POSSIBLE_EDEFAULT;
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
    result.append(" (proposalImageSource: ");
    result.append(proposalImageSource);
    result.append(", proposalImageRegistryId: ");
    result.append(proposalImageRegistryId);
    result.append(", cachingPossible: ");
    result.append(cachingPossible);
    result.append(')');
    return result.toString();
  }

} // ContentAssist
