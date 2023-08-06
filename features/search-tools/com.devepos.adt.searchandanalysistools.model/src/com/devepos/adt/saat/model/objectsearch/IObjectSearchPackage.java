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
  String eNS_PREFIX = "objectsearch";

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
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeConfig <em>Search Type
   * Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchTypeConfig
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchTypeConfig()
   * @generated
   */
  int SEARCH_TYPE_CONFIG = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_CONFIG__NAME = 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_CONFIG__LABEL = 1;

  /**
   * The feature id for the '<em><b>Image Info</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_CONFIG__IMAGE_INFO = 2;

  /**
   * The feature id for the '<em><b>Custom Options</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_CONFIG__CUSTOM_OPTIONS = 3;

  /**
   * The feature id for the '<em><b>Output Config</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_CONFIG__OUTPUT_CONFIG = 4;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_CONFIG__INPUTS = 5;

  /**
   * The number of structural features of the '<em>Search Type Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_CONFIG_FEATURE_COUNT = 6;

  /**
   * The number of operations of the '<em>Search Type Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_CONFIG_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInputFieldConfig <em>Search Type
   * Input Field Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInputFieldConfig
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchTypeInputFieldConfig()
   * @generated
   */
  int SEARCH_TYPE_INPUT_FIELD_CONFIG = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT_FIELD_CONFIG__NAME = 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT_FIELD_CONFIG__LABEL = 1;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT_FIELD_CONFIG__MIXED = 2;

  /**
   * The feature id for the '<em><b>Filters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT_FIELD_CONFIG__FILTERS = 3;

  /**
   * The number of structural features of the '<em>Search Type Input Field Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT_FIELD_CONFIG_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Search Type Input Field Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_TYPE_INPUT_FIELD_CONFIG_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig <em>Search Filter
   * Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchFilterConfig()
   * @generated
   */
  int SEARCH_FILTER_CONFIG = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__NAME = 0;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__DATA_TYPE = 1;

  /**
   * The feature id for the '<em><b>Max Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__MAX_LENGTH = 2;

  /**
   * The feature id for the '<em><b>Multiple</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__MULTIPLE = 3;

  /**
   * The feature id for the '<em><b>Negatable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__NEGATABLE = 4;

  /**
   * The feature id for the '<em><b>Key Value Pair</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__KEY_VALUE_PAIR = 5;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__DESCRIPTION = 6;

  /**
   * The feature id for the '<em><b>Long Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__LONG_DESCRIPTION = 7;

  /**
   * The feature id for the '<em><b>Internal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__INTERNAL = 8;

  /**
   * The feature id for the '<em><b>Wildcards Allowed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__WILDCARDS_ALLOWED = 9;

  /**
   * The feature id for the '<em><b>Content Assist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__CONTENT_ASSIST = 10;

  /**
   * The feature id for the '<em><b>Image Info</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG__IMAGE_INFO = 11;

  /**
   * The number of structural features of the '<em>Search Filter Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG_FEATURE_COUNT = 12;

  /**
   * The number of operations of the '<em>Search Filter Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_FILTER_CONFIG_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.impl.ImageInfo
   * <em>Image Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.ImageInfo
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getImageInfo()
   * @generated
   */
  int IMAGE_INFO = 4;

  /**
   * The feature id for the '<em><b>Image Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int IMAGE_INFO__IMAGE_ID = 0;

  /**
   * The feature id for the '<em><b>Image Encoded</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int IMAGE_INFO__IMAGE_ENCODED = 1;

  /**
   * The feature id for the '<em><b>Image Registry Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int IMAGE_INFO__IMAGE_REGISTRY_ID = 2;

  /**
   * The number of structural features of the '<em>Image Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int IMAGE_INFO_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Image Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int IMAGE_INFO_OPERATION_COUNT = 0;

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
  int CONTENT_ASSIST = 5;

  /**
   * The feature id for the '<em><b>Proposal Image Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE = 0;

  /**
   * The feature id for the '<em><b>Proposal Image Registry Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID = 1;

  /**
   * The feature id for the '<em><b>Proposal Images</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST__PROPOSAL_IMAGES = 2;

  /**
   * The feature id for the '<em><b>Caching Possible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST__CACHING_POSSIBLE = 3;

  /**
   * The number of structural features of the '<em>Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CONTENT_ASSIST_FEATURE_COUNT = 4;

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
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.SimpleContentProposal <em>Simple Content
   * Proposal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SimpleContentProposal
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSimpleContentProposal()
   * @generated
   */
  int SIMPLE_CONTENT_PROPOSAL = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SIMPLE_CONTENT_PROPOSAL__NAME = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SIMPLE_CONTENT_PROPOSAL__DESCRIPTION = 1;

  /**
   * The number of structural features of the '<em>Simple Content Proposal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SIMPLE_CONTENT_PROPOSAL_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Simple Content Proposal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SIMPLE_CONTENT_PROPOSAL_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.FixedValuesContentAssist <em>Fixed Values
   * Content Assist</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.FixedValuesContentAssist
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getFixedValuesContentAssist()
   * @generated
   */
  int FIXED_VALUES_CONTENT_ASSIST = 7;

  /**
   * The feature id for the '<em><b>Proposal Image Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int FIXED_VALUES_CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE = CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE;

  /**
   * The feature id for the '<em><b>Proposal Image Registry Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int FIXED_VALUES_CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID = CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID;

  /**
   * The feature id for the '<em><b>Proposal Images</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int FIXED_VALUES_CONTENT_ASSIST__PROPOSAL_IMAGES = CONTENT_ASSIST__PROPOSAL_IMAGES;

  /**
   * The feature id for the '<em><b>Caching Possible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int FIXED_VALUES_CONTENT_ASSIST__CACHING_POSSIBLE = CONTENT_ASSIST__CACHING_POSSIBLE;

  /**
   * The feature id for the '<em><b>Proposals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int FIXED_VALUES_CONTENT_ASSIST__PROPOSALS = CONTENT_ASSIST_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fixed Values Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int FIXED_VALUES_CONTENT_ASSIST_FEATURE_COUNT = CONTENT_ASSIST_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Fixed Values Content Assist</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int FIXED_VALUES_CONTENT_ASSIST_OPERATION_COUNT = CONTENT_ASSIST_OPERATION_COUNT + 0;

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
  int RIS_CONTENT_ASSIST = 8;

  /**
   * The feature id for the '<em><b>Proposal Image Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RIS_CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE = CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE;

  /**
   * The feature id for the '<em><b>Proposal Image Registry Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RIS_CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID = CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID;

  /**
   * The feature id for the '<em><b>Proposal Images</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RIS_CONTENT_ASSIST__PROPOSAL_IMAGES = CONTENT_ASSIST__PROPOSAL_IMAGES;

  /**
   * The feature id for the '<em><b>Caching Possible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RIS_CONTENT_ASSIST__CACHING_POSSIBLE = CONTENT_ASSIST__CACHING_POSSIBLE;

  /**
   * The feature id for the '<em><b>Object Types</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int RIS_CONTENT_ASSIST__OBJECT_TYPES = CONTENT_ASSIST_FEATURE_COUNT + 0;

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
  int NAMED_ITEM_CONTENT_ASSIST = 9;

  /**
   * The feature id for the '<em><b>Proposal Image Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int NAMED_ITEM_CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE = CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE;

  /**
   * The feature id for the '<em><b>Proposal Image Registry Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int NAMED_ITEM_CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID = CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID;

  /**
   * The feature id for the '<em><b>Proposal Images</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int NAMED_ITEM_CONTENT_ASSIST__PROPOSAL_IMAGES = CONTENT_ASSIST__PROPOSAL_IMAGES;

  /**
   * The feature id for the '<em><b>Caching Possible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int NAMED_ITEM_CONTENT_ASSIST__CACHING_POSSIBLE = CONTENT_ASSIST__CACHING_POSSIBLE;

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
  int USER_CONTENT_ASSIST = 10;

  /**
   * The feature id for the '<em><b>Proposal Image Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER_CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE = CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE;

  /**
   * The feature id for the '<em><b>Proposal Image Registry Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER_CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID = CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID;

  /**
   * The feature id for the '<em><b>Proposal Images</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER_CONTENT_ASSIST__PROPOSAL_IMAGES = CONTENT_ASSIST__PROPOSAL_IMAGES;

  /**
   * The feature id for the '<em><b>Caching Possible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int USER_CONTENT_ASSIST__CACHING_POSSIBLE = CONTENT_ASSIST__CACHING_POSSIBLE;

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
  int SEARCH_QUERY_INPUT = 11;

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
   * The feature id for the '<em><b>Type Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__TYPE_LABEL = 1;

  /**
   * The feature id for the '<em><b>Max Rows</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__MAX_ROWS = 2;

  /**
   * The feature id for the '<em><b>Combine Filters With And</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__COMBINE_FILTERS_WITH_AND = 3;

  /**
   * The feature id for the '<em><b>With Api State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__WITH_API_STATE = 4;

  /**
   * The feature id for the '<em><b>Row Limit Disabled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__ROW_LIMIT_DISABLED = 5;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__FIELDS = 6;

  /**
   * The feature id for the '<em><b>Custom Options</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT__CUSTOM_OPTIONS = 7;

  /**
   * The number of structural features of the '<em>Search Query Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_INPUT_FEATURE_COUNT = 8;

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
  int SEARCH_QUERY_FIELD = 12;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD__LABEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD__NAME = 1;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD__VALUES = 2;

  /**
   * The feature id for the '<em><b>Filters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD__FILTERS = 3;

  /**
   * The feature id for the '<em><b>Raw Input</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD__RAW_INPUT = 4;

  /**
   * The number of structural features of the '<em>Search Query Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_QUERY_FIELD_FEATURE_COUNT = 5;

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
  int SEARCH_QUERY_FILTER = 13;

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
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchResult <em>Result</em>}'
   * class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchResult
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getObjectSearchResult()
   * @generated
   */
  int OBJECT_SEARCH_RESULT = 14;

  /**
   * The feature id for the '<em><b>Result Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int OBJECT_SEARCH_RESULT__RESULT_COUNT = 0;

  /**
   * The feature id for the '<em><b>Result Objects</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int OBJECT_SEARCH_RESULT__RESULT_OBJECTS = 1;

  /**
   * The number of structural features of the '<em>Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int OBJECT_SEARCH_RESULT_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int OBJECT_SEARCH_RESULT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchResultOutputConfig <em>Search Result
   * Output Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.SearchResultOutputConfig
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchResultOutputConfig()
   * @generated
   */
  int SEARCH_RESULT_OUTPUT_CONFIG = 15;

  /**
   * The feature id for the '<em><b>List Output Supported</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_RESULT_OUTPUT_CONFIG__LIST_OUTPUT_SUPPORTED = 0;

  /**
   * The feature id for the '<em><b>Grouping Levels</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_RESULT_OUTPUT_CONFIG__GROUPING_LEVELS = 1;

  /**
   * The feature id for the '<em><b>Types For List</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_RESULT_OUTPUT_CONFIG__TYPES_FOR_LIST = 2;

  /**
   * The number of structural features of the '<em>Search Result Output Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_RESULT_OUTPUT_CONFIG_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Search Result Output Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int SEARCH_RESULT_OUTPUT_CONFIG_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.impl.CustomOption
   * <em>Custom Option</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.CustomOption
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getCustomOption()
   * @generated
   */
  int CUSTOM_OPTION = 16;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CUSTOM_OPTION__KEY = 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CUSTOM_OPTION__LABEL = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CUSTOM_OPTION__TYPE = 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CUSTOM_OPTION__DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Option Values</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CUSTOM_OPTION__OPTION_VALUES = 4;

  /**
   * The number of structural features of the '<em>Custom Option</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CUSTOM_OPTION_FEATURE_COUNT = 5;

  /**
   * The number of operations of the '<em>Custom Option</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int CUSTOM_OPTION_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.saat.model.objectsearch.impl.StringToStringMapEntry <em>String To
   * String Map Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.impl.StringToStringMapEntry
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getStringToStringMapEntry()
   * @generated
   */
  int STRING_TO_STRING_MAP_ENTRY = 17;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_TO_STRING_MAP_ENTRY__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_TO_STRING_MAP_ENTRY__VALUE = 1;

  /**
   * The number of structural features of the '<em>String To String Map Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_TO_STRING_MAP_ENTRY_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>String To String Map Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int STRING_TO_STRING_MAP_ENTRY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.ProposalImageSource
   * <em>Proposal Image Source</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.ProposalImageSource
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getProposalImageSource()
   * @generated
   */
  int PROPOSAL_IMAGE_SOURCE = 18;

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
  int FILTER_TYPE = 19;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.ImageRegistryId
   * <em>Image Registry Id</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.ImageRegistryId
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getImageRegistryId()
   * @generated
   */
  int IMAGE_REGISTRY_ID = 20;

  /**
   * The meta object id for the '{@link com.devepos.adt.saat.model.objectsearch.CustomOptionType
   * <em>Custom Option Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.saat.model.objectsearch.CustomOptionType
   * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getCustomOptionType()
   * @generated
   */
  int CUSTOM_OPTION_TYPE = 21;

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
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig <em>Search Type
   * Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Type Config</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig
   * @generated
   */
  EClass getSearchTypeConfig();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getName()
   * @see #getSearchTypeConfig()
   * @generated
   */
  EAttribute getSearchTypeConfig_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getLabel()
   * @see #getSearchTypeConfig()
   * @generated
   */
  EAttribute getSearchTypeConfig_Label();

  /**
   * Returns the meta object for the reference
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getImageInfo <em>Image
   * Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the reference '<em>Image Info</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getImageInfo()
   * @see #getSearchTypeConfig()
   * @generated
   */
  EReference getSearchTypeConfig_ImageInfo();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getCustomOptions <em>Custom
   * Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Custom Options</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getCustomOptions()
   * @see #getSearchTypeConfig()
   * @generated
   */
  EReference getSearchTypeConfig_CustomOptions();

  /**
   * Returns the meta object for the containment reference
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getOutputConfig <em>Output
   * Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>Output Config</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getOutputConfig()
   * @see #getSearchTypeConfig()
   * @generated
   */
  EReference getSearchTypeConfig_OutputConfig();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Inputs</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig#getInputs()
   * @see #getSearchTypeConfig()
   * @generated
   */
  EReference getSearchTypeConfig_Inputs();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig <em>Search Type
   * Input Field Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Type Input Field Config</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig
   * @generated
   */
  EClass getSearchTypeInputFieldConfig();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig#getName
   * <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig#getName()
   * @see #getSearchTypeInputFieldConfig()
   * @generated
   */
  EAttribute getSearchTypeInputFieldConfig_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig#getLabel
   * <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig#getLabel()
   * @see #getSearchTypeInputFieldConfig()
   * @generated
   */
  EAttribute getSearchTypeInputFieldConfig_Label();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig#isMixed
   * <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Mixed</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig#isMixed()
   * @see #getSearchTypeInputFieldConfig()
   * @generated
   */
  EAttribute getSearchTypeInputFieldConfig_Mixed();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig#getFilters
   * <em>Filters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Filters</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig#getFilters()
   * @see #getSearchTypeInputFieldConfig()
   * @generated
   */
  EReference getSearchTypeInputFieldConfig_Filters();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig <em>Search Filter
   * Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Filter Config</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig
   * @generated
   */
  EClass getSearchFilterConfig();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getName()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EAttribute getSearchFilterConfig_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getDataType <em>Data
   * Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Data Type</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getDataType()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EAttribute getSearchFilterConfig_DataType();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getMaxLength <em>Max
   * Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Max Length</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getMaxLength()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EAttribute getSearchFilterConfig_MaxLength();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isMultiple
   * <em>Multiple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Multiple</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isMultiple()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EAttribute getSearchFilterConfig_Multiple();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isNegatable
   * <em>Negatable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Negatable</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isNegatable()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EAttribute getSearchFilterConfig_Negatable();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isKeyValuePair <em>Key
   * Value Pair</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Key Value Pair</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isKeyValuePair()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EAttribute getSearchFilterConfig_KeyValuePair();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getDescription
   * <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getDescription()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EAttribute getSearchFilterConfig_Description();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getLongDescription <em>Long
   * Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Long Description</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getLongDescription()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EAttribute getSearchFilterConfig_LongDescription();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isInternal
   * <em>Internal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Internal</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isInternal()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EAttribute getSearchFilterConfig_Internal();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isWildcardsAllowed
   * <em>Wildcards Allowed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Wildcards Allowed</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#isWildcardsAllowed()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EAttribute getSearchFilterConfig_WildcardsAllowed();

  /**
   * Returns the meta object for the containment reference
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getContentAssist
   * <em>Content Assist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>Content Assist</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getContentAssist()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EReference getSearchFilterConfig_ContentAssist();

  /**
   * Returns the meta object for the reference
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getImageInfo <em>Image
   * Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the reference '<em>Image Info</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig#getImageInfo()
   * @see #getSearchFilterConfig()
   * @generated
   */
  EReference getSearchFilterConfig_ImageInfo();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.saat.model.objectsearch.IImageInfo
   * <em>Image Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Image Info</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IImageInfo
   * @generated
   */
  EClass getImageInfo();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageId <em>Image Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Image Id</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageId()
   * @see #getImageInfo()
   * @generated
   */
  EAttribute getImageInfo_ImageId();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageEncoded <em>Image
   * Encoded</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Image Encoded</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageEncoded()
   * @see #getImageInfo()
   * @generated
   */
  EAttribute getImageInfo_ImageEncoded();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageRegistryId <em>Image
   * Registry Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Image Registry Id</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IImageInfo#getImageRegistryId()
   * @see #getImageInfo()
   * @generated
   */
  EAttribute getImageInfo_ImageRegistryId();

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
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImageSource
   * <em>Proposal Image Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Proposal Image Source</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImageSource()
   * @see #getContentAssist()
   * @generated
   */
  EAttribute getContentAssist_ProposalImageSource();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImageRegistryId
   * <em>Proposal Image Registry Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Proposal Image Registry Id</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImageRegistryId()
   * @see #getContentAssist()
   * @generated
   */
  EAttribute getContentAssist_ProposalImageRegistryId();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImages <em>Proposal
   * Images</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Proposal Images</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IContentAssist#getProposalImages()
   * @see #getContentAssist()
   * @generated
   */
  EReference getContentAssist_ProposalImages();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist#isCachingPossible <em>Caching
   * Possible</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Caching Possible</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IContentAssist#isCachingPossible()
   * @see #getContentAssist()
   * @generated
   */
  EAttribute getContentAssist_CachingPossible();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISimpleContentProposal <em>Simple Content
   * Proposal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Simple Content Proposal</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISimpleContentProposal
   * @generated
   */
  EClass getSimpleContentProposal();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISimpleContentProposal#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISimpleContentProposal#getName()
   * @see #getSimpleContentProposal()
   * @generated
   */
  EAttribute getSimpleContentProposal_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISimpleContentProposal#getDescription
   * <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISimpleContentProposal#getDescription()
   * @see #getSimpleContentProposal()
   * @generated
   */
  EAttribute getSimpleContentProposal_Description();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.IFixedValuesContentAssist <em>Fixed Values
   * Content Assist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Fixed Values Content Assist</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IFixedValuesContentAssist
   * @generated
   */
  EClass getFixedValuesContentAssist();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.IFixedValuesContentAssist#getProposals
   * <em>Proposals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Proposals</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IFixedValuesContentAssist#getProposals()
   * @see #getFixedValuesContentAssist()
   * @generated
   */
  EReference getFixedValuesContentAssist_Proposals();

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
   * Returns the meta object for the attribute list
   * '{@link com.devepos.adt.saat.model.objectsearch.IRisContentAssist#getObjectTypes <em>Object
   * Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute list '<em>Object Types</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IRisContentAssist#getObjectTypes()
   * @see #getRisContentAssist()
   * @generated
   */
  EAttribute getRisContentAssist_ObjectTypes();

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
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getTypeLabel <em>Type
   * Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Type Label</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getTypeLabel()
   * @see #getSearchQueryInput()
   * @generated
   */
  EAttribute getSearchQueryInput_TypeLabel();

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
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isWithApiState <em>With Api
   * State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>With Api State</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isWithApiState()
   * @see #getSearchQueryInput()
   * @generated
   */
  EAttribute getSearchQueryInput_WithApiState();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isRowLimitDisabled <em>Row
   * Limit Disabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Row Limit Disabled</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#isRowLimitDisabled()
   * @see #getSearchQueryInput()
   * @generated
   */
  EAttribute getSearchQueryInput_RowLimitDisabled();

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
   * Returns the meta object for the map
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getCustomOptions <em>Custom
   * Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the map '<em>Custom Options</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryInput#getCustomOptions()
   * @see #getSearchQueryInput()
   * @generated
   */
  EReference getSearchQueryInput_CustomOptions();

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
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getLabel()
   * @see #getSearchQueryField()
   * @generated
   */
  EAttribute getSearchQueryField_Label();

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
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getRawInput <em>Raw
   * Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Raw Input</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryField#getRawInput()
   * @see #getSearchQueryField()
   * @generated
   */
  EAttribute getSearchQueryField_RawInput();

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
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.IObjectSearchResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Result</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchResult
   * @generated
   */
  EClass getObjectSearchResult();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.IObjectSearchResult#getResultCount <em>Result
   * Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Result Count</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchResult#getResultCount()
   * @see #getObjectSearchResult()
   * @generated
   */
  EAttribute getObjectSearchResult_ResultCount();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.saat.model.objectsearch.IObjectSearchResult#getResultObjects <em>Result
   * Objects</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Result Objects</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchResult#getResultObjects()
   * @see #getObjectSearchResult()
   * @generated
   */
  EReference getObjectSearchResult_ResultObjects();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig <em>Search Result
   * Output Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Search Result Output Config</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig
   * @generated
   */
  EClass getSearchResultOutputConfig();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig#isListOutputSupported
   * <em>List Output Supported</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>List Output Supported</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig#isListOutputSupported()
   * @see #getSearchResultOutputConfig()
   * @generated
   */
  EAttribute getSearchResultOutputConfig_ListOutputSupported();

  /**
   * Returns the meta object for the attribute list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig#getGroupingLevels
   * <em>Grouping Levels</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute list '<em>Grouping Levels</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig#getGroupingLevels()
   * @see #getSearchResultOutputConfig()
   * @generated
   */
  EAttribute getSearchResultOutputConfig_GroupingLevels();

  /**
   * Returns the meta object for the attribute list
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig#getTypesForList
   * <em>Types For List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute list '<em>Types For List</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig#getTypesForList()
   * @see #getSearchResultOutputConfig()
   * @generated
   */
  EAttribute getSearchResultOutputConfig_TypesForList();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.saat.model.objectsearch.ICustomOption
   * <em>Custom Option</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Custom Option</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ICustomOption
   * @generated
   */
  EClass getCustomOption();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ICustomOption#getKey()
   * @see #getCustomOption()
   * @generated
   */
  EAttribute getCustomOption_Key();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ICustomOption#getLabel()
   * @see #getCustomOption()
   * @generated
   */
  EAttribute getCustomOption_Label();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ICustomOption#getType()
   * @see #getCustomOption()
   * @generated
   */
  EAttribute getCustomOption_Type();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getDescription
   * <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ICustomOption#getDescription()
   * @see #getCustomOption()
   * @generated
   */
  EAttribute getCustomOption_Description();

  /**
   * Returns the meta object for the map
   * '{@link com.devepos.adt.saat.model.objectsearch.ICustomOption#getOptionValues <em>Option
   * Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the map '<em>Option Values</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ICustomOption#getOptionValues()
   * @see #getCustomOption()
   * @generated
   */
  EReference getCustomOption_OptionValues();

  /**
   * Returns the meta object for class '{@link java.util.Map.Entry <em>String To String Map
   * Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>String To String Map Entry</em>'.
   * @see java.util.Map.Entry
   * @model keyDataType="org.eclipse.emf.ecore.xml.type.String"
   *        keyExtendedMetaData="kind='attribute' namespace='##targetNamespace'"
   *        valueDataType="org.eclipse.emf.ecore.xml.type.String"
   *        valueExtendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  EClass getStringToStringMapEntry();

  /**
   * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see java.util.Map.Entry
   * @see #getStringToStringMapEntry()
   * @generated
   */
  EAttribute getStringToStringMapEntry_Key();

  /**
   * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see java.util.Map.Entry
   * @see #getStringToStringMapEntry()
   * @generated
   */
  EAttribute getStringToStringMapEntry_Value();

  /**
   * Returns the meta object for enum
   * '{@link com.devepos.adt.saat.model.objectsearch.ProposalImageSource <em>Proposal Image
   * Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Proposal Image Source</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ProposalImageSource
   * @generated
   */
  EEnum getProposalImageSource();

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
   * Returns the meta object for enum
   * '{@link com.devepos.adt.saat.model.objectsearch.ImageRegistryId <em>Image Registry Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Image Registry Id</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.ImageRegistryId
   * @generated
   */
  EEnum getImageRegistryId();

  /**
   * Returns the meta object for enum
   * '{@link com.devepos.adt.saat.model.objectsearch.CustomOptionType <em>Custom Option Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Custom Option Type</em>'.
   * @see com.devepos.adt.saat.model.objectsearch.CustomOptionType
   * @generated
   */
  EEnum getCustomOptionType();

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
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeConfig <em>Search Type
     * Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchTypeConfig
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchTypeConfig()
     * @generated
     */
    EClass SEARCH_TYPE_CONFIG = eINSTANCE.getSearchTypeConfig();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_TYPE_CONFIG__NAME = eINSTANCE.getSearchTypeConfig_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_TYPE_CONFIG__LABEL = eINSTANCE.getSearchTypeConfig_Label();

    /**
     * The meta object literal for the '<em><b>Image Info</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_TYPE_CONFIG__IMAGE_INFO = eINSTANCE.getSearchTypeConfig_ImageInfo();

    /**
     * The meta object literal for the '<em><b>Custom Options</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_TYPE_CONFIG__CUSTOM_OPTIONS = eINSTANCE.getSearchTypeConfig_CustomOptions();

    /**
     * The meta object literal for the '<em><b>Output Config</b></em>' containment reference
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_TYPE_CONFIG__OUTPUT_CONFIG = eINSTANCE.getSearchTypeConfig_OutputConfig();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_TYPE_CONFIG__INPUTS = eINSTANCE.getSearchTypeConfig_Inputs();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInputFieldConfig <em>Search
     * Type Input Field Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchTypeInputFieldConfig
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchTypeInputFieldConfig()
     * @generated
     */
    EClass SEARCH_TYPE_INPUT_FIELD_CONFIG = eINSTANCE.getSearchTypeInputFieldConfig();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_TYPE_INPUT_FIELD_CONFIG__NAME = eINSTANCE
        .getSearchTypeInputFieldConfig_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_TYPE_INPUT_FIELD_CONFIG__LABEL = eINSTANCE
        .getSearchTypeInputFieldConfig_Label();

    /**
     * The meta object literal for the '<em><b>Mixed</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_TYPE_INPUT_FIELD_CONFIG__MIXED = eINSTANCE
        .getSearchTypeInputFieldConfig_Mixed();

    /**
     * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_TYPE_INPUT_FIELD_CONFIG__FILTERS = eINSTANCE
        .getSearchTypeInputFieldConfig_Filters();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig <em>Search Filter
     * Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchFilterConfig
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchFilterConfig()
     * @generated
     */
    EClass SEARCH_FILTER_CONFIG = eINSTANCE.getSearchFilterConfig();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER_CONFIG__NAME = eINSTANCE.getSearchFilterConfig_Name();

    /**
     * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER_CONFIG__DATA_TYPE = eINSTANCE.getSearchFilterConfig_DataType();

    /**
     * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER_CONFIG__MAX_LENGTH = eINSTANCE.getSearchFilterConfig_MaxLength();

    /**
     * The meta object literal for the '<em><b>Multiple</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER_CONFIG__MULTIPLE = eINSTANCE.getSearchFilterConfig_Multiple();

    /**
     * The meta object literal for the '<em><b>Negatable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER_CONFIG__NEGATABLE = eINSTANCE.getSearchFilterConfig_Negatable();

    /**
     * The meta object literal for the '<em><b>Key Value Pair</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER_CONFIG__KEY_VALUE_PAIR = eINSTANCE
        .getSearchFilterConfig_KeyValuePair();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER_CONFIG__DESCRIPTION = eINSTANCE.getSearchFilterConfig_Description();

    /**
     * The meta object literal for the '<em><b>Long Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER_CONFIG__LONG_DESCRIPTION = eINSTANCE
        .getSearchFilterConfig_LongDescription();

    /**
     * The meta object literal for the '<em><b>Internal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER_CONFIG__INTERNAL = eINSTANCE.getSearchFilterConfig_Internal();

    /**
     * The meta object literal for the '<em><b>Wildcards Allowed</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_FILTER_CONFIG__WILDCARDS_ALLOWED = eINSTANCE
        .getSearchFilterConfig_WildcardsAllowed();

    /**
     * The meta object literal for the '<em><b>Content Assist</b></em>' containment reference
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_FILTER_CONFIG__CONTENT_ASSIST = eINSTANCE
        .getSearchFilterConfig_ContentAssist();

    /**
     * The meta object literal for the '<em><b>Image Info</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_FILTER_CONFIG__IMAGE_INFO = eINSTANCE.getSearchFilterConfig_ImageInfo();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.ImageInfo <em>Image Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.ImageInfo
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getImageInfo()
     * @generated
     */
    EClass IMAGE_INFO = eINSTANCE.getImageInfo();

    /**
     * The meta object literal for the '<em><b>Image Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute IMAGE_INFO__IMAGE_ID = eINSTANCE.getImageInfo_ImageId();

    /**
     * The meta object literal for the '<em><b>Image Encoded</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute IMAGE_INFO__IMAGE_ENCODED = eINSTANCE.getImageInfo_ImageEncoded();

    /**
     * The meta object literal for the '<em><b>Image Registry Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute IMAGE_INFO__IMAGE_REGISTRY_ID = eINSTANCE.getImageInfo_ImageRegistryId();

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
     * The meta object literal for the '<em><b>Proposal Image Source</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE = eINSTANCE
        .getContentAssist_ProposalImageSource();

    /**
     * The meta object literal for the '<em><b>Proposal Image Registry Id</b></em>' attribute
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID = eINSTANCE
        .getContentAssist_ProposalImageRegistryId();

    /**
     * The meta object literal for the '<em><b>Proposal Images</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference CONTENT_ASSIST__PROPOSAL_IMAGES = eINSTANCE.getContentAssist_ProposalImages();

    /**
     * The meta object literal for the '<em><b>Caching Possible</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CONTENT_ASSIST__CACHING_POSSIBLE = eINSTANCE.getContentAssist_CachingPossible();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SimpleContentProposal <em>Simple Content
     * Proposal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SimpleContentProposal
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSimpleContentProposal()
     * @generated
     */
    EClass SIMPLE_CONTENT_PROPOSAL = eINSTANCE.getSimpleContentProposal();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SIMPLE_CONTENT_PROPOSAL__NAME = eINSTANCE.getSimpleContentProposal_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SIMPLE_CONTENT_PROPOSAL__DESCRIPTION = eINSTANCE
        .getSimpleContentProposal_Description();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.FixedValuesContentAssist <em>Fixed
     * Values Content Assist</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.FixedValuesContentAssist
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getFixedValuesContentAssist()
     * @generated
     */
    EClass FIXED_VALUES_CONTENT_ASSIST = eINSTANCE.getFixedValuesContentAssist();

    /**
     * The meta object literal for the '<em><b>Proposals</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference FIXED_VALUES_CONTENT_ASSIST__PROPOSALS = eINSTANCE
        .getFixedValuesContentAssist_Proposals();

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
     * The meta object literal for the '<em><b>Object Types</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute RIS_CONTENT_ASSIST__OBJECT_TYPES = eINSTANCE.getRisContentAssist_ObjectTypes();

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
     * The meta object literal for the '<em><b>Type Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_INPUT__TYPE_LABEL = eINSTANCE.getSearchQueryInput_TypeLabel();

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
     * The meta object literal for the '<em><b>With Api State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_INPUT__WITH_API_STATE = eINSTANCE.getSearchQueryInput_WithApiState();

    /**
     * The meta object literal for the '<em><b>Row Limit Disabled</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_INPUT__ROW_LIMIT_DISABLED = eINSTANCE
        .getSearchQueryInput_RowLimitDisabled();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_QUERY_INPUT__FIELDS = eINSTANCE.getSearchQueryInput_Fields();

    /**
     * The meta object literal for the '<em><b>Custom Options</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SEARCH_QUERY_INPUT__CUSTOM_OPTIONS = eINSTANCE.getSearchQueryInput_CustomOptions();

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
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_FIELD__LABEL = eINSTANCE.getSearchQueryField_Label();

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
     * The meta object literal for the '<em><b>Raw Input</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_QUERY_FIELD__RAW_INPUT = eINSTANCE.getSearchQueryField_RawInput();

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
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchResult <em>Result</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchResult
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getObjectSearchResult()
     * @generated
     */
    EClass OBJECT_SEARCH_RESULT = eINSTANCE.getObjectSearchResult();

    /**
     * The meta object literal for the '<em><b>Result Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute OBJECT_SEARCH_RESULT__RESULT_COUNT = eINSTANCE.getObjectSearchResult_ResultCount();

    /**
     * The meta object literal for the '<em><b>Result Objects</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference OBJECT_SEARCH_RESULT__RESULT_OBJECTS = eINSTANCE
        .getObjectSearchResult_ResultObjects();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.SearchResultOutputConfig <em>Search
     * Result Output Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.SearchResultOutputConfig
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getSearchResultOutputConfig()
     * @generated
     */
    EClass SEARCH_RESULT_OUTPUT_CONFIG = eINSTANCE.getSearchResultOutputConfig();

    /**
     * The meta object literal for the '<em><b>List Output Supported</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_RESULT_OUTPUT_CONFIG__LIST_OUTPUT_SUPPORTED = eINSTANCE
        .getSearchResultOutputConfig_ListOutputSupported();

    /**
     * The meta object literal for the '<em><b>Grouping Levels</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_RESULT_OUTPUT_CONFIG__GROUPING_LEVELS = eINSTANCE
        .getSearchResultOutputConfig_GroupingLevels();

    /**
     * The meta object literal for the '<em><b>Types For List</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute SEARCH_RESULT_OUTPUT_CONFIG__TYPES_FOR_LIST = eINSTANCE
        .getSearchResultOutputConfig_TypesForList();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.CustomOption <em>Custom Option</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.CustomOption
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getCustomOption()
     * @generated
     */
    EClass CUSTOM_OPTION = eINSTANCE.getCustomOption();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CUSTOM_OPTION__KEY = eINSTANCE.getCustomOption_Key();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CUSTOM_OPTION__LABEL = eINSTANCE.getCustomOption_Label();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CUSTOM_OPTION__TYPE = eINSTANCE.getCustomOption_Type();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute CUSTOM_OPTION__DESCRIPTION = eINSTANCE.getCustomOption_Description();

    /**
     * The meta object literal for the '<em><b>Option Values</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference CUSTOM_OPTION__OPTION_VALUES = eINSTANCE.getCustomOption_OptionValues();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.impl.StringToStringMapEntry <em>String To
     * String Map Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.impl.StringToStringMapEntry
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getStringToStringMapEntry()
     * @generated
     */
    EClass STRING_TO_STRING_MAP_ENTRY = eINSTANCE.getStringToStringMapEntry();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute STRING_TO_STRING_MAP_ENTRY__KEY = eINSTANCE.getStringToStringMapEntry_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute STRING_TO_STRING_MAP_ENTRY__VALUE = eINSTANCE.getStringToStringMapEntry_Value();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.ProposalImageSource <em>Proposal Image
     * Source</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.ProposalImageSource
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getProposalImageSource()
     * @generated
     */
    EEnum PROPOSAL_IMAGE_SOURCE = eINSTANCE.getProposalImageSource();

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

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.ImageRegistryId <em>Image Registry Id</em>}'
     * enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.ImageRegistryId
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getImageRegistryId()
     * @generated
     */
    EEnum IMAGE_REGISTRY_ID = eINSTANCE.getImageRegistryId();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.saat.model.objectsearch.CustomOptionType <em>Custom Option
     * Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.saat.model.objectsearch.CustomOptionType
     * @see com.devepos.adt.saat.model.objectsearch.impl.ObjectSearchPackage#getCustomOptionType()
     * @generated
     */
    EEnum CUSTOM_OPTION_TYPE = eINSTANCE.getCustomOptionType();

  }

} // IObjectSearchPackage
