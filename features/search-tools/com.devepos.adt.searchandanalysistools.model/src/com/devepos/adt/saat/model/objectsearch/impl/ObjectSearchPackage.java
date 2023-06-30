/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.saat.model.objectsearch.FilterType;
import com.devepos.adt.saat.model.objectsearch.IContentAssist;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ObjectSearchPackage extends EPackageImpl implements IObjectSearchPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchConfigEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchTypeInputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchFilterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass contentAssistEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass risContentAssistEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass namedItemContentAssistEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass userContentAssistEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchQueryInputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchQueryFieldEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchQueryFilterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum filterTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>
   * Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ObjectSearchPackage() {
    super(eNS_URI, IObjectSearchFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon
   * which it depends.
   *
   * <p>
   * This method is used to initialize {@link IObjectSearchPackage#eINSTANCE} when that field is
   * accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain
   * the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static IObjectSearchPackage init() {
    if (isInited) {
      return (IObjectSearchPackage) EPackage.Registry.INSTANCE.getEPackage(
          IObjectSearchPackage.eNS_URI);
    }

    // Obtain or create and register package
    Object registeredObjectSearchPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    ObjectSearchPackage theObjectSearchPackage = registeredObjectSearchPackage instanceof ObjectSearchPackage
        ? (ObjectSearchPackage) registeredObjectSearchPackage
        : new ObjectSearchPackage();

    isInited = true;

    // Initialize simple dependencies
    IAdtBasePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theObjectSearchPackage.createPackageContents();

    // Initialize created meta-data
    theObjectSearchPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theObjectSearchPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(IObjectSearchPackage.eNS_URI, theObjectSearchPackage);
    return theObjectSearchPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchConfig() {
    return searchConfigEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchConfig_SearchTypes() {
    return (EReference) searchConfigEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchType() {
    return searchTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchType_Name() {
    return (EAttribute) searchTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchType_Label() {
    return (EAttribute) searchTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchType_Inputs() {
    return (EReference) searchTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchTypeInput() {
    return searchTypeInputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchTypeInput_Name() {
    return (EAttribute) searchTypeInputEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchTypeInput_Label() {
    return (EAttribute) searchTypeInputEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchTypeInput_Filters() {
    return (EReference) searchTypeInputEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchFilter() {
    return searchFilterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_Name() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_DataType() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_MaxLength() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_Multiple() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_Negatable() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_KeyValuePair() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_LongDescription() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_ImageKey() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_Internal() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_WildcardsAllowed() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilter_CachingPossible() {
    return (EAttribute) searchFilterEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchFilter_ContentAssist() {
    return (EReference) searchFilterEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getContentAssist() {
    return contentAssistEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getContentAssist_EntryImgKey() {
    return (EAttribute) contentAssistEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getRisContentAssist() {
    return risContentAssistEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getRisContentAssist_AdtObjectType() {
    return (EAttribute) risContentAssistEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getNamedItemContentAssist() {
    return namedItemContentAssistEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getNamedItemContentAssist_CategoryScheme() {
    return (EAttribute) namedItemContentAssistEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getNamedItemContentAssist_CategoryTerm() {
    return (EAttribute) namedItemContentAssistEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getNamedItemContentAssist_SecondaryCategoryTerm() {
    return (EAttribute) namedItemContentAssistEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getUserContentAssist() {
    return userContentAssistEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchQueryInput() {
    return searchQueryInputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryInput_Type() {
    return (EAttribute) searchQueryInputEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryInput_MaxRows() {
    return (EAttribute) searchQueryInputEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryInput_CombineFiltersWithAnd() {
    return (EAttribute) searchQueryInputEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchQueryInput_Fields() {
    return (EReference) searchQueryInputEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchQueryField() {
    return searchQueryFieldEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryField_Name() {
    return (EAttribute) searchQueryFieldEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryField_Values() {
    return (EAttribute) searchQueryFieldEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchQueryField_Filters() {
    return (EReference) searchQueryFieldEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchQueryFilter() {
    return searchQueryFilterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryFilter_Name() {
    return (EAttribute) searchQueryFilterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryFilter_Values() {
    return (EAttribute) searchQueryFilterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchResult() {
    return searchResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchResult_ResultObject() {
    return (EReference) searchResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getFilterType() {
    return filterTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IObjectSearchFactory getObjectSearchFactory() {
    return (IObjectSearchFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package. This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) {
      return;
    }
    isCreated = true;

    // Create classes and their features
    searchConfigEClass = createEClass(SEARCH_CONFIG);
    createEReference(searchConfigEClass, SEARCH_CONFIG__SEARCH_TYPES);

    searchTypeEClass = createEClass(SEARCH_TYPE);
    createEAttribute(searchTypeEClass, SEARCH_TYPE__NAME);
    createEAttribute(searchTypeEClass, SEARCH_TYPE__LABEL);
    createEReference(searchTypeEClass, SEARCH_TYPE__INPUTS);

    searchTypeInputEClass = createEClass(SEARCH_TYPE_INPUT);
    createEAttribute(searchTypeInputEClass, SEARCH_TYPE_INPUT__NAME);
    createEAttribute(searchTypeInputEClass, SEARCH_TYPE_INPUT__LABEL);
    createEReference(searchTypeInputEClass, SEARCH_TYPE_INPUT__FILTERS);

    searchFilterEClass = createEClass(SEARCH_FILTER);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__NAME);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__DATA_TYPE);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__MAX_LENGTH);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__MULTIPLE);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__NEGATABLE);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__KEY_VALUE_PAIR);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__LONG_DESCRIPTION);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__IMAGE_KEY);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__INTERNAL);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__WILDCARDS_ALLOWED);
    createEAttribute(searchFilterEClass, SEARCH_FILTER__CACHING_POSSIBLE);
    createEReference(searchFilterEClass, SEARCH_FILTER__CONTENT_ASSIST);

    contentAssistEClass = createEClass(CONTENT_ASSIST);
    createEAttribute(contentAssistEClass, CONTENT_ASSIST__ENTRY_IMG_KEY);

    risContentAssistEClass = createEClass(RIS_CONTENT_ASSIST);
    createEAttribute(risContentAssistEClass, RIS_CONTENT_ASSIST__ADT_OBJECT_TYPE);

    namedItemContentAssistEClass = createEClass(NAMED_ITEM_CONTENT_ASSIST);
    createEAttribute(namedItemContentAssistEClass, NAMED_ITEM_CONTENT_ASSIST__CATEGORY_SCHEME);
    createEAttribute(namedItemContentAssistEClass, NAMED_ITEM_CONTENT_ASSIST__CATEGORY_TERM);
    createEAttribute(namedItemContentAssistEClass,
        NAMED_ITEM_CONTENT_ASSIST__SECONDARY_CATEGORY_TERM);

    userContentAssistEClass = createEClass(USER_CONTENT_ASSIST);

    searchQueryInputEClass = createEClass(SEARCH_QUERY_INPUT);
    createEAttribute(searchQueryInputEClass, SEARCH_QUERY_INPUT__TYPE);
    createEAttribute(searchQueryInputEClass, SEARCH_QUERY_INPUT__MAX_ROWS);
    createEAttribute(searchQueryInputEClass, SEARCH_QUERY_INPUT__COMBINE_FILTERS_WITH_AND);
    createEReference(searchQueryInputEClass, SEARCH_QUERY_INPUT__FIELDS);

    searchQueryFieldEClass = createEClass(SEARCH_QUERY_FIELD);
    createEAttribute(searchQueryFieldEClass, SEARCH_QUERY_FIELD__NAME);
    createEAttribute(searchQueryFieldEClass, SEARCH_QUERY_FIELD__VALUES);
    createEReference(searchQueryFieldEClass, SEARCH_QUERY_FIELD__FILTERS);

    searchQueryFilterEClass = createEClass(SEARCH_QUERY_FILTER);
    createEAttribute(searchQueryFilterEClass, SEARCH_QUERY_FILTER__NAME);
    createEAttribute(searchQueryFilterEClass, SEARCH_QUERY_FILTER__VALUES);

    searchResultEClass = createEClass(SEARCH_RESULT);
    createEReference(searchResultEClass, SEARCH_RESULT__RESULT_OBJECT);

    // Create enums
    filterTypeEEnum = createEEnum(FILTER_TYPE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) {
      return;
    }
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    IAdtBasePackage theAdtBasePackage = (IAdtBasePackage) EPackage.Registry.INSTANCE.getEPackage(
        IAdtBasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    risContentAssistEClass.getESuperTypes().add(getContentAssist());
    namedItemContentAssistEClass.getESuperTypes().add(getContentAssist());
    userContentAssistEClass.getESuperTypes().add(getContentAssist());

    // Initialize classes, features, and operations; add parameters
    initEClass(searchConfigEClass, ISearchConfig.class, "SearchConfig", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSearchConfig_SearchTypes(), getSearchType(), null, "searchTypes", null, 0, -1,
        ISearchConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchTypeEClass, ISearchType.class, "SearchType", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchType_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        ISearchType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchType_Label(), ecorePackage.getEString(), "label", null, 0, 1,
        ISearchType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchType_Inputs(), getSearchTypeInput(), null, "inputs", null, 0, -1,
        ISearchType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchTypeInputEClass, ISearchTypeInput.class, "SearchTypeInput", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchTypeInput_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        ISearchTypeInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchTypeInput_Label(), ecorePackage.getEString(), "label", null, 0, 1,
        ISearchTypeInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchTypeInput_Filters(), getSearchFilter(), null, "filters", null, 0, -1,
        ISearchTypeInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchFilterEClass, ISearchFilter.class, "SearchFilter", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchFilter_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilter_DataType(), getFilterType(), "dataType", null, 0, 1,
        ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilter_MaxLength(), ecorePackage.getEInt(), "maxLength", null, 0, 1,
        ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilter_Multiple(), ecorePackage.getEBoolean(), "multiple", null, 0, 1,
        ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilter_Negatable(), ecorePackage.getEBoolean(), "negatable", null, 0, 1,
        ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilter_KeyValuePair(), ecorePackage.getEBoolean(), "keyValuePair", null,
        0, 1, ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilter_LongDescription(), ecorePackage.getEString(), "longDescription",
        null, 0, 1, ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilter_ImageKey(), ecorePackage.getEString(), "imageKey", null, 0, 1,
        ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilter_Internal(), ecorePackage.getEBoolean(), "internal", null, 0, 1,
        ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilter_WildcardsAllowed(), ecorePackage.getEBoolean(),
        "wildcardsAllowed", null, 0, 1, ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilter_CachingPossible(), ecorePackage.getEBoolean(), "cachingPossible",
        null, 0, 1, ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchFilter_ContentAssist(), getContentAssist(), null, "contentAssist", null,
        0, 1, ISearchFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(contentAssistEClass, IContentAssist.class, "ContentAssist", IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getContentAssist_EntryImgKey(), ecorePackage.getEString(), "entryImgKey", null,
        0, 1, IContentAssist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(risContentAssistEClass, IRisContentAssist.class, "RisContentAssist", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRisContentAssist_AdtObjectType(), ecorePackage.getEString(), "adtObjectType",
        null, 0, 1, IRisContentAssist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedItemContentAssistEClass, INamedItemContentAssist.class,
        "NamedItemContentAssist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedItemContentAssist_CategoryScheme(), ecorePackage.getEString(),
        "categoryScheme", null, 0, 1, INamedItemContentAssist.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNamedItemContentAssist_CategoryTerm(), ecorePackage.getEString(),
        "categoryTerm", null, 0, 1, INamedItemContentAssist.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNamedItemContentAssist_SecondaryCategoryTerm(), ecorePackage.getEString(),
        "secondaryCategoryTerm", null, 0, 1, INamedItemContentAssist.class, !IS_TRANSIENT,
        !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(userContentAssistEClass, IUserContentAssist.class, "UserContentAssist", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(searchQueryInputEClass, ISearchQueryInput.class, "SearchQueryInput", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchQueryInput_Type(), ecorePackage.getEString(), "type", null, 0, 1,
        ISearchQueryInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryInput_MaxRows(), ecorePackage.getEInt(), "maxRows", null, 0, 1,
        ISearchQueryInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryInput_CombineFiltersWithAnd(), ecorePackage.getEBoolean(),
        "combineFiltersWithAnd", null, 0, 1, ISearchQueryInput.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchQueryInput_Fields(), getSearchQueryField(), null, "fields", null, 0, -1,
        ISearchQueryInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchQueryFieldEClass, ISearchQueryField.class, "SearchQueryField", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchQueryField_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        ISearchQueryField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryField_Values(), ecorePackage.getEString(), "values", null, 0, -1,
        ISearchQueryField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchQueryField_Filters(), getSearchQueryFilter(), null, "filters", null, 0,
        -1, ISearchQueryField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchQueryFilterEClass, ISearchQueryFilter.class, "SearchQueryFilter", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchQueryFilter_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        ISearchQueryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryFilter_Values(), ecorePackage.getEString(), "values", null, 0, -1,
        ISearchQueryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchResultEClass, ISearchResult.class, "SearchResult", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSearchResult_ResultObject(), theAdtBasePackage.getAdtObjRef(), null,
        "resultObject", null, 0, -1, ISearchResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(filterTypeEEnum, FilterType.class, "FilterType");
    addEEnumLiteral(filterTypeEEnum, FilterType.DEFAULT);
    addEEnumLiteral(filterTypeEEnum, FilterType.DATE);
    addEEnumLiteral(filterTypeEEnum, FilterType.BOOLEAN);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void createExtendedMetaDataAnnotations() {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
    addAnnotation(searchConfigEClass, source, new String[] { "kind", "elementOnly", "name",
        "searchConfig" });
    addAnnotation(getSearchConfig_SearchTypes(), source, new String[] { "name", "searchType",
        "kind", "element", "namespace", "##targetNamespace" });
    addAnnotation(searchTypeEClass, source, new String[] { "kind", "elementOnly", "name",
        "searchType" });
    addAnnotation(getSearchType_Name(), source, new String[] { "name", "name", "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getSearchType_Label(), source, new String[] { "name", "label", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchType_Inputs(), source, new String[] { "name", "input", "kind", "element",
        "namespace", "##targetNamespace" });
    addAnnotation(searchTypeInputEClass, source, new String[] { "kind", "elementOnly", "name",
        "input" });
    addAnnotation(getSearchTypeInput_Name(), source, new String[] { "name", "name", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchTypeInput_Label(), source, new String[] { "name", "label", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchTypeInput_Filters(), source, new String[] { "name", "filter", "kind",
        "element", "namespace", "##targetNamespace" });
    addAnnotation(searchFilterEClass, source, new String[] { "kind", "elementOnly", "name",
        "filter" });
    addAnnotation(getSearchFilter_Name(), source, new String[] { "name", "name", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilter_DataType(), source, new String[] { "name", "dataType", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilter_MaxLength(), source, new String[] { "name", "maxLength", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilter_Multiple(), source, new String[] { "name", "multiple", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilter_Negatable(), source, new String[] { "name", "negatable", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilter_KeyValuePair(), source, new String[] { "name", "keyValuePair",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilter_LongDescription(), source, new String[] { "name",
        "longDescription", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilter_ImageKey(), source, new String[] { "name", "imageKey", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilter_Internal(), source, new String[] { "name", "internal", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilter_WildcardsAllowed(), source, new String[] { "name", "patterns",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilter_CachingPossible(), source, new String[] { "name", "caching",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getContentAssist_EntryImgKey(), source, new String[] { "name", "entryImgKey",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(risContentAssistEClass, source, new String[] { "kind", "elementOnly", "name",
        "risContentAssist" });
    addAnnotation(getRisContentAssist_AdtObjectType(), source, new String[] { "name",
        "adtObjectType", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(namedItemContentAssistEClass, source, new String[] { "kind", "elementOnly",
        "name", "namedItemContentAssist" });
    addAnnotation(getNamedItemContentAssist_CategoryScheme(), source, new String[] { "name",
        "categoryScheme", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getNamedItemContentAssist_CategoryTerm(), source, new String[] { "name",
        "categoryTerm", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getNamedItemContentAssist_SecondaryCategoryTerm(), source, new String[] { "name",
        "secondaryCategoryTerm", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(userContentAssistEClass, source, new String[] { "kind", "elementOnly", "name",
        "userContentAssist" });
    addAnnotation(searchQueryInputEClass, source, new String[] { "kind", "elementOnly", "name",
        "queryInput" });
    addAnnotation(getSearchQueryInput_Type(), source, new String[] { "name", "type", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryInput_MaxRows(), source, new String[] { "name", "maxRows", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryInput_CombineFiltersWithAnd(), source, new String[] { "name",
        "combineFiltersWithAnd", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryInput_Fields(), source, new String[] { "name", "field", "kind",
        "element", "namespace", "##targetNamespace" });
    addAnnotation(searchQueryFieldEClass, source, new String[] { "kind", "elementOnly", "name",
        "field" });
    addAnnotation(getSearchQueryField_Name(), source, new String[] { "name", "name", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryField_Values(), source, new String[] { "name", "value", "kind",
        "element", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryField_Filters(), source, new String[] { "name", "filter", "kind",
        "element", "namespace", "##targetNamespace" });
    addAnnotation(searchQueryFilterEClass, source, new String[] { "kind", "elementOnly", "name",
        "filter" });
    addAnnotation(getSearchQueryFilter_Name(), source, new String[] { "name", "name", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryFilter_Values(), source, new String[] { "name", "value", "kind",
        "element", "namespace", "##targetNamespace" });
    addAnnotation(searchResultEClass, source, new String[] { "kind", "elementOnly", "name",
        "searchResult" });
    addAnnotation(getSearchResult_ResultObject(), source, new String[] { "name", "resultObject",
        "kind", "element", "namespace", "http://www.devepos.com/adt/base" });
  }

} // ObjectSearchPackage
