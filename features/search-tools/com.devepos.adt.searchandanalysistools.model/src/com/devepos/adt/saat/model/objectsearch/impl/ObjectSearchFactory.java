/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.devepos.adt.saat.model.objectsearch.FilterType;
import com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchFactory;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.IRisContentAssist;
import com.devepos.adt.saat.model.objectsearch.ISearchConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchFilter;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryField;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryInput;
import com.devepos.adt.saat.model.objectsearch.ISearchResult;
import com.devepos.adt.saat.model.objectsearch.ISearchType;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeInput;
import com.devepos.adt.saat.model.objectsearch.IUserContentAssist;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ObjectSearchFactory extends EFactoryImpl implements IObjectSearchFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static IObjectSearchFactory init() {
    try {
      IObjectSearchFactory theObjectSearchFactory = (IObjectSearchFactory) EPackage.Registry.INSTANCE
          .getEFactory(IObjectSearchPackage.eNS_URI);
      if (theObjectSearchFactory != null) {
        return theObjectSearchFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ObjectSearchFactory();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public ObjectSearchFactory() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EObject create(final EClass eClass) {
    switch (eClass.getClassifierID()) {
    case IObjectSearchPackage.SEARCH_CONFIG:
      return createSearchConfig();
    case IObjectSearchPackage.SEARCH_TYPE:
      return createSearchType();
    case IObjectSearchPackage.SEARCH_TYPE_INPUT:
      return createSearchTypeInput();
    case IObjectSearchPackage.SEARCH_FILTER:
      return createSearchFilter();
    case IObjectSearchPackage.RIS_CONTENT_ASSIST:
      return createRisContentAssist();
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST:
      return createNamedItemContentAssist();
    case IObjectSearchPackage.USER_CONTENT_ASSIST:
      return createUserContentAssist();
    case IObjectSearchPackage.SEARCH_QUERY_INPUT:
      return createSearchQueryInput();
    case IObjectSearchPackage.SEARCH_QUERY_FIELD:
      return createSearchQueryField();
    case IObjectSearchPackage.SEARCH_QUERY_FILTER:
      return createSearchQueryFilter();
    case IObjectSearchPackage.SEARCH_RESULT:
      return createSearchResult();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object createFromString(final EDataType eDataType, final String initialValue) {
    switch (eDataType.getClassifierID()) {
    case IObjectSearchPackage.FILTER_TYPE:
      return createFilterTypeFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String convertToString(final EDataType eDataType, final Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    case IObjectSearchPackage.FILTER_TYPE:
      return convertFilterTypeToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchConfig createSearchConfig() {
    SearchConfig searchConfig = new SearchConfig();
    return searchConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchType createSearchType() {
    SearchType searchType = new SearchType();
    return searchType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchTypeInput createSearchTypeInput() {
    SearchTypeInput searchTypeInput = new SearchTypeInput();
    return searchTypeInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchFilter createSearchFilter() {
    SearchFilter searchFilter = new SearchFilter();
    return searchFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IRisContentAssist createRisContentAssist() {
    RisContentAssist risContentAssist = new RisContentAssist();
    return risContentAssist;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public INamedItemContentAssist createNamedItemContentAssist() {
    NamedItemContentAssist namedItemContentAssist = new NamedItemContentAssist();
    return namedItemContentAssist;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IUserContentAssist createUserContentAssist() {
    UserContentAssist userContentAssist = new UserContentAssist();
    return userContentAssist;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchQueryInput createSearchQueryInput() {
    SearchQueryInput searchQueryInput = new SearchQueryInput();
    return searchQueryInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchQueryField createSearchQueryField() {
    SearchQueryField searchQueryField = new SearchQueryField();
    return searchQueryField;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchQueryFilter createSearchQueryFilter() {
    SearchQueryFilter searchQueryFilter = new SearchQueryFilter();
    return searchQueryFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchResult createSearchResult() {
    SearchResult searchResult = new SearchResult();
    return searchResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public FilterType createFilterTypeFromString(final EDataType eDataType,
      final String initialValue) {
    FilterType result = FilterType.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertFilterTypeToString(final EDataType eDataType, final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IObjectSearchPackage getObjectSearchPackage() {
    return (IObjectSearchPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @deprecated
   * @generated
   */
  @Deprecated
  public static IObjectSearchPackage getPackage() {
    return IObjectSearchPackage.eINSTANCE;
  }

} // ObjectSearchFactory
