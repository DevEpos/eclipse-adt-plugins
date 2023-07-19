/**
 */
package com.devepos.adt.saat.model.objectsearch;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Values Content Assist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.objectsearch.IFixedValuesContentAssist#getProposals
 * <em>Proposals</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getFixedValuesContentAssist()
 * @model
 * @generated
 */
public interface IFixedValuesContentAssist extends IContentAssist {
  /**
   * Returns the value of the '<em><b>Proposals</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.saat.model.objectsearch.ISimpleContentProposal}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Proposals</em>' containment reference list.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#getFixedValuesContentAssist_Proposals()
   * @model containment="true"
   *        extendedMetaData="kind='element' namespace='##targetNamespace' name='proposal'"
   * @generated
   */
  List<ISimpleContentProposal> getProposals();

} // IFixedValuesContentAssist
