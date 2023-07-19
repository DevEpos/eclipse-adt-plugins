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
import com.devepos.adt.saat.model.objectsearch.IFixedValuesContentAssist;
import com.devepos.adt.saat.model.objectsearch.IImageInfo;
import com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchFactory;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchResult;
import com.devepos.adt.saat.model.objectsearch.IRisContentAssist;
import com.devepos.adt.saat.model.objectsearch.ISearchConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchFilterConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryField;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryInput;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig;
import com.devepos.adt.saat.model.objectsearch.ISimpleContentProposal;
import com.devepos.adt.saat.model.objectsearch.IUserContentAssist;
import com.devepos.adt.saat.model.objectsearch.ImageRegistryId;
import com.devepos.adt.saat.model.objectsearch.ProposalImageSource;

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
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG:
      return createSearchTypeConfig();
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG:
      return createSearchTypeInputFieldConfig();
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG:
      return createSearchFilterConfig();
    case IObjectSearchPackage.IMAGE_INFO:
      return createImageInfo();
    case IObjectSearchPackage.SIMPLE_CONTENT_PROPOSAL:
      return createSimpleContentProposal();
    case IObjectSearchPackage.FIXED_VALUES_CONTENT_ASSIST:
      return createFixedValuesContentAssist();
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
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT:
      return createObjectSearchResult();
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
    case IObjectSearchPackage.PROPOSAL_IMAGE_SOURCE:
      return createProposalImageSourceFromString(eDataType, initialValue);
    case IObjectSearchPackage.FILTER_TYPE:
      return createFilterTypeFromString(eDataType, initialValue);
    case IObjectSearchPackage.IMAGE_REGISTRY_ID:
      return createImageRegistryIdFromString(eDataType, initialValue);
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
    case IObjectSearchPackage.PROPOSAL_IMAGE_SOURCE:
      return convertProposalImageSourceToString(eDataType, instanceValue);
    case IObjectSearchPackage.FILTER_TYPE:
      return convertFilterTypeToString(eDataType, instanceValue);
    case IObjectSearchPackage.IMAGE_REGISTRY_ID:
      return convertImageRegistryIdToString(eDataType, instanceValue);
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
  public ISearchTypeConfig createSearchTypeConfig() {
    SearchTypeConfig searchTypeConfig = new SearchTypeConfig();
    return searchTypeConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchTypeInputFieldConfig createSearchTypeInputFieldConfig() {
    SearchTypeInputFieldConfig searchTypeInputFieldConfig = new SearchTypeInputFieldConfig();
    return searchTypeInputFieldConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISearchFilterConfig createSearchFilterConfig() {
    SearchFilterConfig searchFilterConfig = new SearchFilterConfig();
    return searchFilterConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IImageInfo createImageInfo() {
    ImageInfo imageInfo = new ImageInfo();
    return imageInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISimpleContentProposal createSimpleContentProposal() {
    SimpleContentProposal simpleContentProposal = new SimpleContentProposal();
    return simpleContentProposal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IFixedValuesContentAssist createFixedValuesContentAssist() {
    FixedValuesContentAssist fixedValuesContentAssist = new FixedValuesContentAssist();
    return fixedValuesContentAssist;
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
  public IObjectSearchResult createObjectSearchResult() {
    ObjectSearchResult objectSearchResult = new ObjectSearchResult();
    return objectSearchResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public ProposalImageSource createProposalImageSourceFromString(final EDataType eDataType,
      final String initialValue) {
    ProposalImageSource result = ProposalImageSource.get(initialValue);
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
  public String convertProposalImageSourceToString(final EDataType eDataType,
      final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
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
  public ImageRegistryId createImageRegistryIdFromString(final EDataType eDataType,
      final String initialValue) {
    ImageRegistryId result = ImageRegistryId.get(initialValue);
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
  public String convertImageRegistryIdToString(final EDataType eDataType,
      final Object instanceValue) {
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
