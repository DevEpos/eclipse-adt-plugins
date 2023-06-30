/**
 */
package com.devepos.adt.saat.model.objectsearch;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchFactory
 * @model kind="package"
 * @generated
 */
public interface IObjectSearchPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNAME = "objectsearch";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_URI = "http://www.devepos.com/adt/objectsearch";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_PREFIX = "saat";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  IObjectSearchPackage eINSTANCE = com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage
      .init();

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchConfig
   * <em>Search Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchConfig
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchConfig()
   * @generated
   */
  int SEARCH_CONFIG = 0;

  /**
   * The feature id for the '<em><b>Search Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_CONFIG__SEARCH_TYPES = 0;

  /**
   * The number of structural features of the '<em>Search Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_CONFIG_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Search Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_CONFIG_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchType
   * <em>Search Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchType
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchType()
   * @generated
   */
  int SEARCH_TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE__NAME = 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE__LABEL = 1;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE__INPUTS = 2;

  /**
   * The number of structural features of the '<em>Search Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Search Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInput
   * <em>Search Type Input</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInput
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchTypeInput()
   * @generated
   */
  int SEARCH_TYPE_INPUT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT__NAME = 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT__LABEL = 1;

  /**
   * The feature id for the '<em><b>Filters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT__FILTERS = 2;

  /**
   * The number of structural features of the '<em>Search Type Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Search Type Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilter
   * <em>Search Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchFilter
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchFilter()
   * @generated
   */
  int SEARCH_FILTER = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__NAME = 0;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__DATA_TYPE = 1;

  /**
   * The feature id for the '<em><b>Max Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__MAX_LENGTH = 2;

  /**
   * The feature id for the '<em><b>Multiple</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__MULTIPLE = 3;

  /**
   * The feature id for the '<em><b>Negatable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__NEGATABLE = 4;

  /**
   * The feature id for the '<em><b>Key Value Pair</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__KEY_VALUE_PAIR = 5;

  /**
   * The feature id for the '<em><b>Long Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__LONG_DESCRIPTION = 6;

  /**
   * The feature id for the '<em><b>Image Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__IMAGE_KEY = 7;

  /**
   * The feature id for the '<em><b>Internal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__INTERNAL = 8;

  /**
   * The feature id for the '<em><b>Wildcards Allowed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__WILDCARDS_ALLOWED = 9;

  /**
   * The feature id for the '<em><b>Caching Possible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__CACHING_POSSIBLE = 10;

  /**
   * The feature id for the '<em><b>Content Assist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER__CONTENT_ASSIST = 11;

  /**
   * The number of structural features of the '<em>Search Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_FEATURE_COUNT = 12;

  /**
   * The number of operations of the '<em>Search Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.impl.ContentAssist
   * <em>Content Assist</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.ContentAssist
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getContentAssist()
   * @generated
   */
  int CONTENT_ASSIST = 4;

  /**
   * The feature id for the '<em><b>Entry Img Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST__ENTRY_IMG_KEY = 0;

  /**
   * The number of structural features of the '<em>Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.RisContentAssist <em>Ris Content
   * Assist</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.RisContentAssist
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getRisContentAssist()
   * @generated
   */
  int RIS_CONTENT_ASSIST = 5;

  /**
   * The feature id for the '<em><b>Entry Img Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RIS_CONTENT_ASSIST__ENTRY_IMG_KEY = CONTENT_ASSIST__ENTRY_IMG_KEY;

  /**
   * The feature id for the '<em><b>Adt Object Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RIS_CONTENT_ASSIST__ADT_OBJECT_TYPE = CONTENT_ASSIST_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Ris Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RIS_CONTENT_ASSIST_FEATURE_COUNT = CONTENT_ASSIST_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Ris Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RIS_CONTENT_ASSIST_OPERATION_COUNT = CONTENT_ASSIST_OPERATION_COUNT + 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.NamedItemContentAssist <em>Named Item
   * Content Assist</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.NamedItemContentAssist
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getNamedItemContentAssist()
   * @generated
   */
  int NAMED_ITEM_CONTENT_ASSIST = 6;

  /**
   * The feature id for the '<em><b>Entry Img Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int NAMED_ITEM_CONTENT_ASSIST__ENTRY_IMG_KEY = CONTENT_ASSIST__ENTRY_IMG_KEY;

  /**
   * The feature id for the '<em><b>Category Scheme</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int NAMED_ITEM_CONTENT_ASSIST__CATEGORY_SCHEME = CONTENT_ASSIST_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Category Term</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int NAMED_ITEM_CONTENT_ASSIST__CATEGORY_TERM = CONTENT_ASSIST_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Secondary Category Term</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int NAMED_ITEM_CONTENT_ASSIST__SECONDARY_CATEGORY_TERM = CONTENT_ASSIST_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Named Item Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int NAMED_ITEM_CONTENT_ASSIST_FEATURE_COUNT = CONTENT_ASSIST_FEATURE_COUNT + 3;

  /**
   * The number of operations of the '<em>Named Item Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int NAMED_ITEM_CONTENT_ASSIST_OPERATION_COUNT = CONTENT_ASSIST_OPERATION_COUNT + 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.UserContentAssist <em>User Content
   * Assist</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.UserContentAssist
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getUserContentAssist()
   * @generated
   */
  int USER_CONTENT_ASSIST = 7;

  /**
   * The feature id for the '<em><b>Entry Img Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER_CONTENT_ASSIST__ENTRY_IMG_KEY = CONTENT_ASSIST__ENTRY_IMG_KEY;

  /**
   * The number of structural features of the '<em>User Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER_CONTENT_ASSIST_FEATURE_COUNT = CONTENT_ASSIST_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>User Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER_CONTENT_ASSIST_OPERATION_COUNT = CONTENT_ASSIST_OPERATION_COUNT + 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryInput <em>Search Query
   * Input</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchQueryInput
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchQueryInput()
   * @generated
   */
  int SEARCH_QUERY_INPUT = 8;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__TYPE = 0;

  /**
   * The feature id for the '<em><b>Max Rows</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__MAX_ROWS = 1;

  /**
   * The feature id for the '<em><b>Combine Filters With And</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__COMBINE_FILTERS_WITH_AND = 2;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__FIELDS = 3;

  /**
   * The number of structural features of the '<em>Search Query Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Search Query Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryField <em>Search Query
   * Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchQueryField
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchQueryField()
   * @generated
   */
  int SEARCH_QUERY_FIELD = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD__NAME = 0;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD__VALUES = 1;

  /**
   * The feature id for the '<em><b>Filters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD__FILTERS = 2;

  /**
   * The number of structural features of the '<em>Search Query Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Search Query Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryFilter <em>Search Query
   * Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchQueryFilter
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchQueryFilter()
   * @generated
   */
  int SEARCH_QUERY_FILTER = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FILTER__NAME = 0;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FILTER__VALUES = 1;

  /**
   * The number of structural features of the '<em>Search Query Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FILTER_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Search Query Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FILTER_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchResult
   * <em>Search Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchResult
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchResult()
   * @generated
   */
  int SEARCH_RESULT = 11;

  /**
   * The feature id for the '<em><b>Result Object</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_RESULT__RESULT_OBJECT = 0;

  /**
   * The number of structural features of the '<em>Search Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_RESULT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Search Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_RESULT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.FilterType
   * <em>Filter Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.FilterType
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getFilterType()
   * @generated
   */
  int FILTER_TYPE = 12;

  /**
   * Returns the meta object for class '{@link com.devepos.adt.saat.model.objectsearch.ISearchConfig
   * <em>Search Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Config</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchConfig
   * @generated
   */
  EClass getSearchConfig();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchConfig#getSearchTypes <em>Search
   * Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Search Types</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchConfig#getSearchTypes()
   * @see #getSearchConfig()
   * @generated
   */
  EReference getSearchConfig_SearchTypes();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.saat.model.objectsearch.ISearchType
   * <em>Search Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Type</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchType
   * @generated
   */
  EClass getSearchType();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchType#getName()
   * @see #getSearchType()
   * @generated
   */
  EAttribute getSearchType_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchType#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchType#getLabel()
   * @see #getSearchType()
   * @generated
   */
  EAttribute getSearchType_Label();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchType#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Inputs</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchType#getInputs()
   * @see #getSearchType()
   * @generated
   */
  EReference getSearchType_Inputs();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInput <em>Search Type Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Type Input</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeInput
   * @generated
   */
  EClass getSearchTypeInput();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInput#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeInput#getName()
   * @see #getSearchTypeInput()
   * @generated
   */
  EAttribute getSearchTypeInput_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInput#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeInput#getLabel()
   * @see #getSearchTypeInput()
   * @generated
   */
  EAttribute getSearchTypeInput_Label();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInput#getFilters <em>Filters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Filters</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeInput#getFilters()
   * @see #getSearchTypeInput()
   * @generated
   */
  EReference getSearchTypeInput_Filters();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter
   * <em>Search Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Filter</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter
   * @generated
   */
  EClass getSearchFilter();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#getName()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#getDataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Data Type</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#getDataType()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_DataType();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#getMaxLength <em>Max
   * Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Max Length</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#getMaxLength()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_MaxLength();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#isMultiple <em>Multiple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Multiple</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#isMultiple()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_Multiple();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#isNegatable <em>Negatable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Negatable</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#isNegatable()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_Negatable();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#isKeyValuePair <em>Key Value
   * Pair</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Key Value Pair</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#isKeyValuePair()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_KeyValuePair();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#getLongDescription <em>Long
   * Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Long Description</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#getLongDescription()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_LongDescription();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#getImageKey <em>Image Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Image Key</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#getImageKey()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_ImageKey();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#isInternal <em>Internal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Internal</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#isInternal()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_Internal();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#isWildcardsAllowed <em>Wildcards
   * Allowed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Wildcards Allowed</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#isWildcardsAllowed()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_WildcardsAllowed();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#isCachingPossible <em>Caching
   * Possible</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Caching Possible</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#isCachingPossible()
   * @see #getSearchFilter()
   * @generated
   */
  EAttribute getSearchFilter_CachingPossible();

  /**
   * Returns the meta object for the containment reference
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter#getContentAssist <em>Content
   * Assist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>Content Assist</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter#getContentAssist()
   * @see #getSearchFilter()
   * @generated
   */
  EReference getSearchFilter_ContentAssist();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist <em>Content Assist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Content Assist</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IContentAssist
   * @generated
   */
  EClass getContentAssist();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getEntryImgKey <em>Entry Img
   * Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Entry Img Key</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IContentAssist#getEntryImgKey()
   * @see #getContentAssist()
   * @generated
   */
  EAttribute getContentAssist_EntryImgKey();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.IRisContentAssist <em>Ris Content
   * Assist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Ris Content Assist</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IRisContentAssist
   * @generated
   */
  EClass getRisContentAssist();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.IRisContentAssist#getAdtObjectType <em>Adt
   * Object Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Adt Object Type</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IRisContentAssist#getAdtObjectType()
   * @see #getRisContentAssist()
   * @generated
   */
  EAttribute getRisContentAssist_AdtObjectType();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist <em>Named Item Content
   * Assist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Named Item Content Assist</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist
   * @generated
   */
  EClass getNamedItemContentAssist();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getCategoryScheme
   * <em>Category Scheme</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Category Scheme</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getCategoryScheme()
   * @see #getNamedItemContentAssist()
   * @generated
   */
  EAttribute getNamedItemContentAssist_CategoryScheme();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getCategoryTerm
   * <em>Category Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Category Term</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getCategoryTerm()
   * @see #getNamedItemContentAssist()
   * @generated
   */
  EAttribute getNamedItemContentAssist_CategoryTerm();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getSecondaryCategoryTerm
   * <em>Secondary Category Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Secondary Category Term</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist#getSecondaryCategoryTerm()
   * @see #getNamedItemContentAssist()
   * @generated
   */
  EAttribute getNamedItemContentAssist_SecondaryCategoryTerm();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.IUserContentAssist <em>User Content
   * Assist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>User Content Assist</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IUserContentAssist
   * @generated
   */
  EClass getUserContentAssist();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput <em>Search Query
   * Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Query Input</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryInput
   * @generated
   */
  EClass getSearchQueryInput();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getType()
   * @see #getSearchQueryInput()
   * @generated
   */
  EAttribute getSearchQueryInput_Type();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getMaxRows <em>Max
   * Rows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Max Rows</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getMaxRows()
   * @see #getSearchQueryInput()
   * @generated
   */
  EAttribute getSearchQueryInput_MaxRows();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isCombineFiltersWithAnd
   * <em>Combine Filters With And</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Combine Filters With And</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isCombineFiltersWithAnd()
   * @see #getSearchQueryInput()
   * @generated
   */
  EAttribute getSearchQueryInput_CombineFiltersWithAnd();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getFields()
   * @see #getSearchQueryInput()
   * @generated
   */
  EReference getSearchQueryInput_Fields();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField <em>Search Query
   * Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Query Field</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryField
   * @generated
   */
  EClass getSearchQueryField();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getName()
   * @see #getSearchQueryField()
   * @generated
   */
  EAttribute getSearchQueryField_Name();

  /**
   * Returns the meta object for the attribute list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getValues()
   * @see #getSearchQueryField()
   * @generated
   */
  EAttribute getSearchQueryField_Values();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getFilters
   * <em>Filters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Filters</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getFilters()
   * @see #getSearchQueryField()
   * @generated
   */
  EReference getSearchQueryField_Filters();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter <em>Search Query
   * Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Query Filter</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter
   * @generated
   */
  EClass getSearchQueryFilter();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter#getName()
   * @see #getSearchQueryFilter()
   * @generated
   */
  EAttribute getSearchQueryFilter_Name();

  /**
   * Returns the meta object for the attribute list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter#getValues()
   * @see #getSearchQueryFilter()
   * @generated
   */
  EAttribute getSearchQueryFilter_Values();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.saat.model.objectsearch.ISearchResult
   * <em>Search Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Result</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchResult
   * @generated
   */
  EClass getSearchResult();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchResult#getResultObject <em>Result
   * Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Result Object</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchResult#getResultObject()
   * @see #getSearchResult()
   * @generated
   */
  EReference getSearchResult_ResultObject();

  /**
   * Returns the meta object for enum '{@link com.devepos.adt.saat.model.objectsearch.FilterType
   * <em>Filter Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Filter Type</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.FilterType
   * @generated
   */
  EEnum getFilterType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the factory that creates the instances of the model.
   * @generated
   */
  IObjectSearchFactory getObjectSearchFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each operation of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   *
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchConfig <em>Search Config</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchConfig
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchConfig()
     * @generated
     */
    EClass SEARCH_CONFIG = eINSTANCE.getSearchConfig();

    /**
     * The meta object literal for the '<em><b>Search Types</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_CONFIG__SEARCH_TYPES = eINSTANCE.getSearchConfig_SearchTypes();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchType <em>Search Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchType
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchType()
     * @generated
     */
    EClass SEARCH_TYPE = eINSTANCE.getSearchType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_TYPE__NAME = eINSTANCE.getSearchType_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_TYPE__LABEL = eINSTANCE.getSearchType_Label();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_TYPE__INPUTS = eINSTANCE.getSearchType_Inputs();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInput <em>Search Type
     * Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInput
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchTypeInput()
     * @generated
     */
    EClass SEARCH_TYPE_INPUT = eINSTANCE.getSearchTypeInput();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_TYPE_INPUT__NAME = eINSTANCE.getSearchTypeInput_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_TYPE_INPUT__LABEL = eINSTANCE.getSearchTypeInput_Label();

    /**
     * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_TYPE_INPUT__FILTERS = eINSTANCE.getSearchTypeInput_Filters();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilter <em>Search Filter</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchFilter
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchFilter()
     * @generated
     */
    EClass SEARCH_FILTER = eINSTANCE.getSearchFilter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__NAME = eINSTANCE.getSearchFilter_Name();

    /**
     * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__DATA_TYPE = eINSTANCE.getSearchFilter_DataType();

    /**
     * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__MAX_LENGTH = eINSTANCE.getSearchFilter_MaxLength();

    /**
     * The meta object literal for the '<em><b>Multiple</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__MULTIPLE = eINSTANCE.getSearchFilter_Multiple();

    /**
     * The meta object literal for the '<em><b>Negatable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__NEGATABLE = eINSTANCE.getSearchFilter_Negatable();

    /**
     * The meta object literal for the '<em><b>Key Value Pair</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__KEY_VALUE_PAIR = eINSTANCE.getSearchFilter_KeyValuePair();

    /**
     * The meta object literal for the '<em><b>Long Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__LONG_DESCRIPTION = eINSTANCE.getSearchFilter_LongDescription();

    /**
     * The meta object literal for the '<em><b>Image Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__IMAGE_KEY = eINSTANCE.getSearchFilter_ImageKey();

    /**
     * The meta object literal for the '<em><b>Internal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__INTERNAL = eINSTANCE.getSearchFilter_Internal();

    /**
     * The meta object literal for the '<em><b>Wildcards Allowed</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__WILDCARDS_ALLOWED = eINSTANCE.getSearchFilter_WildcardsAllowed();

    /**
     * The meta object literal for the '<em><b>Caching Possible</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER__CACHING_POSSIBLE = eINSTANCE.getSearchFilter_CachingPossible();

    /**
     * The meta object literal for the '<em><b>Content Assist</b></em>' containment reference
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_FILTER__CONTENT_ASSIST = eINSTANCE.getSearchFilter_ContentAssist();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.ContentAssist <em>Content Assist</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.ContentAssist
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getContentAssist()
     * @generated
     */
    EClass CONTENT_ASSIST = eINSTANCE.getContentAssist();

    /**
     * The meta object literal for the '<em><b>Entry Img Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CONTENT_ASSIST__ENTRY_IMG_KEY = eINSTANCE.getContentAssist_EntryImgKey();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.RisContentAssist <em>Ris Content
     * Assist</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.RisContentAssist
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getRisContentAssist()
     * @generated
     */
    EClass RIS_CONTENT_ASSIST = eINSTANCE.getRisContentAssist();

    /**
     * The meta object literal for the '<em><b>Adt Object Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute RIS_CONTENT_ASSIST__ADT_OBJECT_TYPE = eINSTANCE.getRisContentAssist_AdtObjectType();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.NamedItemContentAssist <em>Named Item
     * Content Assist</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.NamedItemContentAssist
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getNamedItemContentAssist()
     * @generated
     */
    EClass NAMED_ITEM_CONTENT_ASSIST = eINSTANCE.getNamedItemContentAssist();

    /**
     * The meta object literal for the '<em><b>Category Scheme</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute NAMED_ITEM_CONTENT_ASSIST__CATEGORY_SCHEME = eINSTANCE
        .getNamedItemContentAssist_CategoryScheme();

    /**
     * The meta object literal for the '<em><b>Category Term</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute NAMED_ITEM_CONTENT_ASSIST__CATEGORY_TERM = eINSTANCE
        .getNamedItemContentAssist_CategoryTerm();

    /**
     * The meta object literal for the '<em><b>Secondary Category Term</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute NAMED_ITEM_CONTENT_ASSIST__SECONDARY_CATEGORY_TERM = eINSTANCE
        .getNamedItemContentAssist_SecondaryCategoryTerm();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.UserContentAssist <em>User Content
     * Assist</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.UserContentAssist
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getUserContentAssist()
     * @generated
     */
    EClass USER_CONTENT_ASSIST = eINSTANCE.getUserContentAssist();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryInput <em>Search Query
     * Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchQueryInput
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchQueryInput()
     * @generated
     */
    EClass SEARCH_QUERY_INPUT = eINSTANCE.getSearchQueryInput();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_INPUT__TYPE = eINSTANCE.getSearchQueryInput_Type();

    /**
     * The meta object literal for the '<em><b>Max Rows</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_INPUT__MAX_ROWS = eINSTANCE.getSearchQueryInput_MaxRows();

    /**
     * The meta object literal for the '<em><b>Combine Filters With And</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_INPUT__COMBINE_FILTERS_WITH_AND = eINSTANCE
        .getSearchQueryInput_CombineFiltersWithAnd();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_QUERY_INPUT__FIELDS = eINSTANCE.getSearchQueryInput_Fields();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryField <em>Search Query
     * Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchQueryField
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchQueryField()
     * @generated
     */
    EClass SEARCH_QUERY_FIELD = eINSTANCE.getSearchQueryField();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_FIELD__NAME = eINSTANCE.getSearchQueryField_Name();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_FIELD__VALUES = eINSTANCE.getSearchQueryField_Values();

    /**
     * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_QUERY_FIELD__FILTERS = eINSTANCE.getSearchQueryField_Filters();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchQueryFilter <em>Search Query
     * Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchQueryFilter
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchQueryFilter()
     * @generated
     */
    EClass SEARCH_QUERY_FILTER = eINSTANCE.getSearchQueryFilter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_FILTER__NAME = eINSTANCE.getSearchQueryFilter_Name();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_FILTER__VALUES = eINSTANCE.getSearchQueryFilter_Values();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchResult <em>Search Result</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchResult
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchResult()
     * @generated
     */
    EClass SEARCH_RESULT = eINSTANCE.getSearchResult();

    /**
     * The meta object literal for the '<em><b>Result Object</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_RESULT__RESULT_OBJECT = eINSTANCE.getSearchResult_ResultObject();

    /**
     * The meta object literal for the '{@link com.devepos.adt.saat.model.objectsearch.FilterType
     * <em>Filter Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.FilterType
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getFilterType()
     * @generated
     */
    EEnum FILTER_TYPE = eINSTANCE.getFilterType();

  }

} // IObjectSearchPackage
