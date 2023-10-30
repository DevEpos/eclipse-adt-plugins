/**
 */
package com.devepos.adt.searchfavorites.model.searchfavorites.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.devepos.adt.searchfavorites.model.searchfavorites.IBaseAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IBooleanAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IIntAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IListAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.ILongStringAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.IMapAttribute;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesFactory;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage;
import com.devepos.adt.searchfavorites.model.searchfavorites.IStringAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SearchFavoritesPackage extends EPackageImpl implements ISearchFavoritesPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass baseAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass longStringAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass listAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass stringAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass intAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass booleanAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass mapAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass stringToStringMapEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchFavoriteEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchFavoritesEClass = null;

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
   * @see com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SearchFavoritesPackage() {
    super(eNS_URI, ISearchFavoritesFactory.eINSTANCE);
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
   * This method is used to initialize {@link ISearchFavoritesPackage#eINSTANCE} when that field is
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
  public static ISearchFavoritesPackage init() {
    if (isInited) {
      return (ISearchFavoritesPackage) EPackage.Registry.INSTANCE
          .getEPackage(ISearchFavoritesPackage.eNS_URI);
    }

    // Obtain or create and register package
    Object registeredSearchFavoritesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    SearchFavoritesPackage theSearchFavoritesPackage = registeredSearchFavoritesPackage instanceof SearchFavoritesPackage
        ? (SearchFavoritesPackage) registeredSearchFavoritesPackage
        : new SearchFavoritesPackage();

    isInited = true;

    // Create package meta-data objects
    theSearchFavoritesPackage.createPackageContents();

    // Initialize created meta-data
    theSearchFavoritesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSearchFavoritesPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ISearchFavoritesPackage.eNS_URI, theSearchFavoritesPackage);
    return theSearchFavoritesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getBaseAttribute() {
    return baseAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getBaseAttribute_Name() {
    return (EAttribute) baseAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getLongStringAttribute() {
    return longStringAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getLongStringAttribute_Value() {
    return (EAttribute) longStringAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getListAttribute() {
    return listAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getListAttribute_Values() {
    return (EAttribute) listAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getStringAttribute() {
    return stringAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getStringAttribute_Value() {
    return (EAttribute) stringAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getIntAttribute() {
    return intAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getIntAttribute_Value() {
    return (EAttribute) intAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getBooleanAttribute() {
    return booleanAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getBooleanAttribute_Value() {
    return (EAttribute) booleanAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getMapAttribute() {
    return mapAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getMapAttribute_Entries() {
    return (EReference) mapAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getStringToStringMapEntry() {
    return stringToStringMapEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getStringToStringMapEntry_Key() {
    return (EAttribute) stringToStringMapEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getStringToStringMapEntry_Value() {
    return (EAttribute) stringToStringMapEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchFavorite() {
    return searchFavoriteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFavorite_SearchType() {
    return (EAttribute) searchFavoriteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFavorite_Description() {
    return (EAttribute) searchFavoriteEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFavorite_DestinationId() {
    return (EAttribute) searchFavoriteEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFavorite_ProjectIndependent() {
    return (EAttribute) searchFavoriteEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFavorite_Hidden() {
    return (EAttribute) searchFavoriteEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchFavorite_Attributes() {
    return (EReference) searchFavoriteEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchFavorites() {
    return searchFavoritesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchFavorites_Favorites() {
    return (EReference) searchFavoritesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchFavoritesFactory getSearchFavoritesFactory() {
    return (ISearchFavoritesFactory) getEFactoryInstance();
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
    baseAttributeEClass = createEClass(BASE_ATTRIBUTE);
    createEAttribute(baseAttributeEClass, BASE_ATTRIBUTE__NAME);

    longStringAttributeEClass = createEClass(LONG_STRING_ATTRIBUTE);
    createEAttribute(longStringAttributeEClass, LONG_STRING_ATTRIBUTE__VALUE);

    listAttributeEClass = createEClass(LIST_ATTRIBUTE);
    createEAttribute(listAttributeEClass, LIST_ATTRIBUTE__VALUES);

    stringAttributeEClass = createEClass(STRING_ATTRIBUTE);
    createEAttribute(stringAttributeEClass, STRING_ATTRIBUTE__VALUE);

    intAttributeEClass = createEClass(INT_ATTRIBUTE);
    createEAttribute(intAttributeEClass, INT_ATTRIBUTE__VALUE);

    booleanAttributeEClass = createEClass(BOOLEAN_ATTRIBUTE);
    createEAttribute(booleanAttributeEClass, BOOLEAN_ATTRIBUTE__VALUE);

    mapAttributeEClass = createEClass(MAP_ATTRIBUTE);
    createEReference(mapAttributeEClass, MAP_ATTRIBUTE__ENTRIES);

    stringToStringMapEntryEClass = createEClass(STRING_TO_STRING_MAP_ENTRY);
    createEAttribute(stringToStringMapEntryEClass, STRING_TO_STRING_MAP_ENTRY__KEY);
    createEAttribute(stringToStringMapEntryEClass, STRING_TO_STRING_MAP_ENTRY__VALUE);

    searchFavoriteEClass = createEClass(SEARCH_FAVORITE);
    createEAttribute(searchFavoriteEClass, SEARCH_FAVORITE__SEARCH_TYPE);
    createEAttribute(searchFavoriteEClass, SEARCH_FAVORITE__DESCRIPTION);
    createEAttribute(searchFavoriteEClass, SEARCH_FAVORITE__DESTINATION_ID);
    createEAttribute(searchFavoriteEClass, SEARCH_FAVORITE__PROJECT_INDEPENDENT);
    createEAttribute(searchFavoriteEClass, SEARCH_FAVORITE__HIDDEN);
    createEReference(searchFavoriteEClass, SEARCH_FAVORITE__ATTRIBUTES);

    searchFavoritesEClass = createEClass(SEARCH_FAVORITES);
    createEReference(searchFavoritesEClass, SEARCH_FAVORITES__FAVORITES);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    longStringAttributeEClass.getESuperTypes().add(getBaseAttribute());
    listAttributeEClass.getESuperTypes().add(getBaseAttribute());
    stringAttributeEClass.getESuperTypes().add(getBaseAttribute());
    intAttributeEClass.getESuperTypes().add(getBaseAttribute());
    booleanAttributeEClass.getESuperTypes().add(getBaseAttribute());
    mapAttributeEClass.getESuperTypes().add(getBaseAttribute());

    // Initialize classes, features, and operations; add parameters
    initEClass(baseAttributeEClass, IBaseAttribute.class, "BaseAttribute", IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBaseAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        IBaseAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(longStringAttributeEClass, ILongStringAttribute.class, "LongStringAttribute",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLongStringAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1,
        ILongStringAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listAttributeEClass, IListAttribute.class, "ListAttribute", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getListAttribute_Values(), ecorePackage.getEString(), "values", null, 0, -1,
        IListAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringAttributeEClass, IStringAttribute.class, "StringAttribute", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1,
        IStringAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(intAttributeEClass, IIntAttribute.class, "IntAttribute", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntAttribute_Value(), ecorePackage.getEInt(), "value", null, 0, 1,
        IIntAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanAttributeEClass, IBooleanAttribute.class, "BooleanAttribute", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanAttribute_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1,
        IBooleanAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mapAttributeEClass, IMapAttribute.class, "MapAttribute", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMapAttribute_Entries(), getStringToStringMapEntry(), null, "entries", null, 0,
        -1, IMapAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringToStringMapEntryEClass, Map.Entry.class, "StringToStringMapEntry",
        !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringToStringMapEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1,
        Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStringToStringMapEntry_Value(), ecorePackage.getEString(), "value", null, 0,
        1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchFavoriteEClass, ISearchFavorite.class, "SearchFavorite", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchFavorite_SearchType(), ecorePackage.getEString(), "searchType", null, 0,
        1, ISearchFavorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFavorite_Description(), ecorePackage.getEString(), "description", null,
        0, 1, ISearchFavorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFavorite_DestinationId(), ecorePackage.getEString(), "destinationId",
        null, 0, 1, ISearchFavorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFavorite_ProjectIndependent(), ecorePackage.getEBoolean(),
        "projectIndependent", null, 0, 1, ISearchFavorite.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFavorite_Hidden(), ecorePackage.getEBoolean(), "hidden", null, 0, 1,
        ISearchFavorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchFavorite_Attributes(), getBaseAttribute(), null, "attributes", null, 0,
        -1, ISearchFavorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchFavoritesEClass, ISearchFavorites.class, "SearchFavorites", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSearchFavorites_Favorites(), getSearchFavorite(), null, "favorites", null, 0,
        -1, ISearchFavorites.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
    addAnnotation(getLongStringAttribute_Value(), source, new String[] { "kind", "element" });
    addAnnotation(getListAttribute_Values(), source,
        new String[] { "name", "value", "kind", "element" });
    addAnnotation(getMapAttribute_Entries(), source,
        new String[] { "kind", "element", "name", "entry" });
    addAnnotation(getSearchFavorite_Attributes(), source,
        new String[] { "kind", "element", "name", "attribute" });
    addAnnotation(getSearchFavorites_Favorites(), source,
        new String[] { "kind", "element", "name", "favorite" });
  }

} // SearchFavoritesPackage
