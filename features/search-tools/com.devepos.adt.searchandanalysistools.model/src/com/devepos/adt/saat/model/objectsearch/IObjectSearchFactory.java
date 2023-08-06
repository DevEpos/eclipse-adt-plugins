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
   * Returns a new object of class '<em>Search Type Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Type Config</em>'.
   * @generated
   */
  ISearchTypeConfig createSearchTypeConfig();

  /**
   * Returns a new object of class '<em>Search Type Input Field Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Type Input Field Config</em>'.
   * @generated
   */
  ISearchTypeInputFieldConfig createSearchTypeInputFieldConfig();

  /**
   * Returns a new object of class '<em>Search Filter Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Filter Config</em>'.
   * @generated
   */
  ISearchFilterConfig createSearchFilterConfig();

  /**
   * Returns a new object of class '<em>Image Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Image Info</em>'.
   * @generated
   */
  IImageInfo createImageInfo();

  /**
   * Returns a new object of class '<em>Simple Content Proposal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Simple Content Proposal</em>'.
   * @generated
   */
  ISimpleContentProposal createSimpleContentProposal();

  /**
   * Returns a new object of class '<em>Fixed Values Content Assist</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Fixed Values Content Assist</em>'.
   * @generated
   */
  IFixedValuesContentAssist createFixedValuesContentAssist();

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
   * Returns a new object of class '<em>Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Result</em>'.
   * @generated
   */
  IObjectSearchResult createObjectSearchResult();

  /**
   * Returns a new object of class '<em>Search Result Output Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Search Result Output Config</em>'.
   * @generated
   */
  ISearchResultOutputConfig createSearchResultOutputConfig();

  /**
   * Returns a new object of class '<em>Custom Option</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Custom Option</em>'.
   * @generated
   */
  ICustomOption createCustomOption();

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
