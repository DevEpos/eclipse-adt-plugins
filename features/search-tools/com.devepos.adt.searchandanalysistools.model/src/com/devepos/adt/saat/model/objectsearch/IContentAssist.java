/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content Assist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImageSource
 * <em>Proposal Image Source</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImageRegistryId
 * <em>Proposal Image Registry Id</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImages <em>Proposal
 * Images</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#isCachingPossible <em>Caching
 * Possible</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getContentAssist()
 * @model abstract="true"
 * @generated
 */
public interface IContentAssist extends EObject {
  /**
   * Returns the value of the '<em><b>Proposal Image Source</b></em>' attribute.
   * The literals are from the enumeration
   * {@link com.devepos.adt.saat.model.objectsearch.ProposalImageSource}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Proposal Image Source</em>' attribute.
   * @see com.devepos.adt.saat.model.objectsearch.ProposalImageSource
   * @see #setProposalImageSource(ProposalImageSource)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getContentAssist_ProposalImageSource()
   * @model extendedMetaData="name='proposalImageSource' kind='attribute'
   *        namespace='##targetNamespace'"
   * @generated
   */
  ProposalImageSource getProposalImageSource();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImageSource
   * <em>Proposal Image Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Proposal Image Source</em>' attribute.
   * @see com.devepos.adt.saat.model.objectsearch.ProposalImageSource
   * @see #getProposalImageSource()
   * @generated
   */
  void setProposalImageSource(ProposalImageSource value);

  /**
   * Returns the value of the '<em><b>Proposal Image Registry Id</b></em>' attribute.
   * The literals are from the enumeration
   * {@link com.devepos.adt.saat.model.objectsearch.ImageRegistryId}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Proposal Image Registry Id</em>' attribute.
   * @see com.devepos.adt.saat.model.objectsearch.ImageRegistryId
   * @see #setProposalImageRegistryId(ImageRegistryId)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getContentAssist_ProposalImageRegistryId()
   * @model extendedMetaData="name='proposalImageRegistryId' kind='attribute'
   *        namespace='##targetNamespace'"
   * @generated
   */
  ImageRegistryId getProposalImageRegistryId();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImageRegistryId
   * <em>Proposal Image Registry Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Proposal Image Registry Id</em>' attribute.
   * @see com.devepos.adt.saat.model.objectsearch.ImageRegistryId
   * @see #getProposalImageRegistryId()
   * @generated
   */
  void setProposalImageRegistryId(ImageRegistryId value);

  /**
   * Returns the value of the '<em><b>Proposal Images</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.saat.model.objectsearch.IImageInfo}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Proposal Images</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getContentAssist_ProposalImages()
   * @model containment="true"
   *        extendedMetaData="name='proposalImage' kind='element' namespace='##targetNamespace'"
   * @generated
   */
  List<IImageInfo> getProposalImages();

  /**
   * Returns the value of the '<em><b>Caching Possible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Caching Possible</em>' attribute.
   * @see #setCachingPossible(boolean)
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getContentAssist_CachingPossible()
   * @model extendedMetaData="name='caching' kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  boolean isCachingPossible();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#isCachingPossible <em>Caching
   * Possible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Caching Possible</em>' attribute.
   * @see #isCachingPossible()
   * @generated
   */
  void setCachingPossible(boolean value);

} // IContentAssist
