/**
 */
package com.devepos.adt.saat.model.objectsearch;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage
 * @generated
 */
public interface IObjectSearchFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  IObjectSearchFactory eINSTANCE = com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchFactory
      .init();

  /**
   * Returns a new object of class '<em>Search Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Config</em>'.
   * @generated
   */
  ISearchConfig createSearchConfig();

  /**
   * Returns a new object of class '<em>Search Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Type</em>'.
   * @generated
   */
  ISearchType createSearchType();

  /**
   * Returns a new object of class '<em>Search Type Input</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Type Input</em>'.
   * @generated
   */
  ISearchTypeInput createSearchTypeInput();

  /**
   * Returns a new object of class '<em>Search Filter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Filter</em>'.
   * @generated
   */
  ISearchFilter createSearchFilter();

  /**
   * Returns a new object of class '<em>Ris Content Assist</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Ris Content Assist</em>'.
   * @generated
   */
  IRisContentAssist createRisContentAssist();

  /**
   * Returns a new object of class '<em>Named Item Content Assist</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Named Item Content Assist</em>'.
   * @generated
   */
  INamedItemContentAssist createNamedItemContentAssist();

  /**
   * Returns a new object of class '<em>User Content Assist</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>User Content Assist</em>'.
   * @generated
   */
  IUserContentAssist createUserContentAssist();

  /**
   * Returns a new object of class '<em>Search Query Input</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Query Input</em>'.
   * @generated
   */
  ISearchQueryInput createSearchQueryInput();

  /**
   * Returns a new object of class '<em>Search Query Field</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Query Field</em>'.
   * @generated
   */
  ISearchQueryField createSearchQueryField();

  /**
   * Returns a new object of class '<em>Search Query Filter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Query Filter</em>'.
   * @generated
   */
  ISearchQueryFilter createSearchQueryFilter();

  /**
   * Returns a new object of class '<em>Search Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Result</em>'.
   * @generated
   */
  ISearchResult createSearchResult();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the package supported by this factory.
   * @generated
   */
  IObjectSearchPackage getObjectSearchPackage();

} // IObjectSearchFactory
