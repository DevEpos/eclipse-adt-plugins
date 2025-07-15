/**
 */
package com.devepos.adt.cst.model.codesearch;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.cst.model.codesearch.ICodeSearchMatch#getUri <em>Uri</em>}</li>
 * <li>{@link com.devepos.adt.cst.model.codesearch.ICodeSearchMatch#getSnippet
 * <em>Snippet</em>}</li>
 * <li>{@link com.devepos.adt.cst.model.codesearch.ICodeSearchMatch#getLongSnippet <em>Long
 * Snippet</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchMatch()
 * @model extendedMetaData="kind='elementOnly' name='codeSearchMatch'"
 * @generated
 */
public interface ICodeSearchMatch extends EObject {
  /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #setUri(String)
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchMatch_Uri()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
   *        extendedMetaData="kind='attribute' name='uri' namespace='##targetNamespace'"
   * @generated
   */
  String getUri();

  /**
   * Sets the value of the '{@link com.devepos.adt.cst.model.codesearch.ICodeSearchMatch#getUri
   * <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
  void setUri(String value);

  /**
   * Returns the value of the '<em><b>Snippet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Snippet</em>' attribute.
   * @see #setSnippet(String)
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchMatch_Snippet()
   * @model extendedMetaData="kind='element' name='snippet' namespace='##targetNamespace'"
   * @generated
   */
  String getSnippet();

  /**
   * Sets the value of the '{@link com.devepos.adt.cst.model.codesearch.ICodeSearchMatch#getSnippet
   * <em>Snippet</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Snippet</em>' attribute.
   * @see #getSnippet()
   * @generated
   */
  void setSnippet(String value);

  /**
   * Returns the value of the '<em><b>Long Snippet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Long Snippet</em>' attribute.
   * @see #setLongSnippet(String)
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchMatch_LongSnippet()
   * @model extendedMetaData="kind='element' name='longSnippet' namespace='##targetNamespace'"
   * @generated
   */
  String getLongSnippet();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.cst.model.codesearch.ICodeSearchMatch#getLongSnippet <em>Long
   * Snippet</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Long Snippet</em>' attribute.
   * @see #getLongSnippet()
   * @generated
   */
  void setLongSnippet(String value);

} // ICodeSearchMatch
