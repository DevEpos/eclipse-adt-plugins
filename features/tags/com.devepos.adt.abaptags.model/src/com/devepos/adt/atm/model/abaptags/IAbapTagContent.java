/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abap Tag Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAbapTagContent#getTags <em>Tags</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAbapTagContent#getTaggedObjectInfos <em>Tagged
 * Object Infos</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAbapTagContent#getSharedTags <em>Shared
 * Tags</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAbapTagContent()
 * @model extendedMetaData="kind='elementOnly' name='abapTagContent'"
 * @generated
 */
public interface IAbapTagContent extends EObject {
  /**
   * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.atm.model.abaptags.ITag}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tags</em>' containment reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAbapTagContent_Tags()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='tag' namespace='##targetNamespace'"
   * @generated
   */
  EList<ITag> getTags();

  /**
   * Returns the value of the '<em><b>Tagged Object Infos</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tagged Object Infos</em>' containment reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAbapTagContent_TaggedObjectInfos()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='taggedObjectInfo' namespace='##targetNamespace'"
   * @generated
   */
  EList<ITaggedObjectInfo> getTaggedObjectInfos();

  /**
   * Returns the value of the '<em><b>Shared Tags</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.atm.model.abaptags.ITag}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Shared Tags</em>' containment reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAbapTagContent_SharedTags()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='sharedTag' namespace='##targetNamespace'"
   * @generated
   */
  EList<ITag> getSharedTags();

} // IAbapTagContent
