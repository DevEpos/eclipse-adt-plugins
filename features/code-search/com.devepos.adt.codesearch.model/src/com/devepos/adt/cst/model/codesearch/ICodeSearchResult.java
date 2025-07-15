/**
 */
package com.devepos.adt.cst.model.codesearch;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.IResponseMessageList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getSearchObjects <em>Search
 * Objects</em>}</li>
 * <li>{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getResponseMessageList
 * <em>Response Message List</em>}</li>
 * <li>{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getNumberOfResults <em>Number
 * Of Results</em>}</li>
 * <li>{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getNumberOfSearchedObjects
 * <em>Number Of Searched Objects</em>}</li>
 * <li>{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getNumberOfSearchedSources
 * <em>Number Of Searched Sources</em>}</li>
 * <li>{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getLinesOfSearchedCode
 * <em>Lines Of Searched Code</em>}</li>
 * <li>{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getQueryTimeInMs <em>Query Time
 * In Ms</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchResult()
 * @model extendedMetaData="kind='elementOnly' name='result'"
 * @generated
 */
public interface ICodeSearchResult extends EObject {
  /**
   * Returns the value of the '<em><b>Search Objects</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.cst.model.codesearch.ICodeSearchObject}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Search Objects</em>' containment reference list.
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchResult_SearchObjects()
   * @model containment="true" suppressedSetVisibility="true"
   *        extendedMetaData="kind='element' name='searchObject' namespace='##targetNamespace'"
   * @generated
   */
  EList<ICodeSearchObject> getSearchObjects();

  /**
   * Returns the value of the '<em><b>Response Message List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Response Message List</em>' containment reference.
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchResult_ResponseMessageList()
   * @model containment="true" suppressedSetVisibility="true"
   *        extendedMetaData="kind='element' name='responseMessages'
   *        namespace='http://www.devepos.com/adt/base'"
   * @generated
   */
  IResponseMessageList getResponseMessageList();

  /**
   * Returns the value of the '<em><b>Number Of Results</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Number Of Results</em>' attribute.
   * @see #setNumberOfResults(int)
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchResult_NumberOfResults()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='numberOfResults' namespace='##targetNamespace'"
   * @generated
   */
  int getNumberOfResults();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getNumberOfResults <em>Number Of
   * Results</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Number Of Results</em>' attribute.
   * @see #getNumberOfResults()
   * @generated
   */
  void setNumberOfResults(int value);

  /**
   * Returns the value of the '<em><b>Number Of Searched Objects</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Number Of Searched Objects</em>' attribute.
   * @see #setNumberOfSearchedObjects(int)
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchResult_NumberOfSearchedObjects()
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='numberOfSearchedObjects'
   *        namespace='##targetNamespace'"
   * @generated
   */
  int getNumberOfSearchedObjects();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getNumberOfSearchedObjects
   * <em>Number Of Searched Objects</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Number Of Searched Objects</em>' attribute.
   * @see #getNumberOfSearchedObjects()
   * @generated
   */
  void setNumberOfSearchedObjects(int value);

  /**
   * Returns the value of the '<em><b>Number Of Searched Sources</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Number Of Searched Sources</em>' attribute.
   * @see #setNumberOfSearchedSources(int)
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchResult_NumberOfSearchedSources()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='numberOfSearchedSources'
   *        namespace='##targetNamespace'"
   * @generated
   */
  int getNumberOfSearchedSources();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getNumberOfSearchedSources
   * <em>Number Of Searched Sources</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Number Of Searched Sources</em>' attribute.
   * @see #getNumberOfSearchedSources()
   * @generated
   */
  void setNumberOfSearchedSources(int value);

  /**
   * Returns the value of the '<em><b>Lines Of Searched Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Lines Of Searched Code</em>' attribute.
   * @see #setLinesOfSearchedCode(float)
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchResult_LinesOfSearchedCode()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Float"
   *        extendedMetaData="kind='attribute' name='linesOfSearchedCode'
   *        namespace='##targetNamespace'"
   * @generated
   */
  float getLinesOfSearchedCode();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getLinesOfSearchedCode <em>Lines
   * Of Searched Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Lines Of Searched Code</em>' attribute.
   * @see #getLinesOfSearchedCode()
   * @generated
   */
  void setLinesOfSearchedCode(float value);

  /**
   * Returns the value of the '<em><b>Query Time In Ms</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Query Time In Ms</em>' attribute.
   * @see #setQueryTimeInMs(int)
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#getCodeSearchResult_QueryTimeInMs()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='queryTimeInMs' namespace='##targetNamespace'"
   * @generated
   */
  int getQueryTimeInMs();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.cst.model.codesearch.ICodeSearchResult#getQueryTimeInMs <em>Query Time
   * In Ms</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Query Time In Ms</em>' attribute.
   * @see #getQueryTimeInMs()
   * @generated
   */
  void setQueryTimeInMs(int value);

} // ICodeSearchResult
