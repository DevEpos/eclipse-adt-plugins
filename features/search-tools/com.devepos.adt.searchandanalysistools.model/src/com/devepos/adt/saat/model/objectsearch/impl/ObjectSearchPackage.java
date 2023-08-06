/**
 */
package com.devepos.adt.saat.model.objectsearch.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.saat.model.objectsearch.CustomOptionType;
import com.devepos.adt.saat.model.objectsearch.FilterType;
import com.devepos.adt.saat.model.objectsearch.IContentAssist;
import com.devepos.adt.saat.model.objectsearch.ICustomOption;
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
import com.devepos.adt.saat.model.objectsearch.ISearchResultOutputConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchTypeInputFieldConfig;
import com.devepos.adt.saat.model.objectsearch.ISimpleContentProposal;
import com.devepos.adt.saat.model.objectsearch.IUserContentAssist;
import com.devepos.adt.saat.model.objectsearch.ImageRegistryId;
import com.devepos.adt.saat.model.objectsearch.ProposalImageSource;

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
  private EClass searchTypeConfigEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchTypeInputFieldConfigEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchFilterConfigEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass imageInfoEClass = null;

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
  private EClass simpleContentProposalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass fixedValuesContentAssistEClass = null;

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
  private EClass objectSearchResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass searchResultOutputConfigEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass customOptionEClass = null;

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
  private EEnum proposalImageSourceEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum filterTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum imageRegistryIdEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum customOptionTypeEEnum = null;

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
    XMLTypePackage.eINSTANCE.eClass();

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
  public EClass getSearchTypeConfig() {
    return searchTypeConfigEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchTypeConfig_Name() {
    return (EAttribute) searchTypeConfigEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchTypeConfig_Label() {
    return (EAttribute) searchTypeConfigEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchTypeConfig_ImageInfo() {
    return (EReference) searchTypeConfigEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchTypeConfig_CustomOptions() {
    return (EReference) searchTypeConfigEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchTypeConfig_OutputConfig() {
    return (EReference) searchTypeConfigEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchTypeConfig_Inputs() {
    return (EReference) searchTypeConfigEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchTypeInputFieldConfig() {
    return searchTypeInputFieldConfigEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchTypeInputFieldConfig_Name() {
    return (EAttribute) searchTypeInputFieldConfigEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchTypeInputFieldConfig_Label() {
    return (EAttribute) searchTypeInputFieldConfigEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchTypeInputFieldConfig_Mixed() {
    return (EAttribute) searchTypeInputFieldConfigEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchTypeInputFieldConfig_Filters() {
    return (EReference) searchTypeInputFieldConfigEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchFilterConfig() {
    return searchFilterConfigEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilterConfig_Name() {
    return (EAttribute) searchFilterConfigEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilterConfig_DataType() {
    return (EAttribute) searchFilterConfigEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilterConfig_MaxLength() {
    return (EAttribute) searchFilterConfigEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilterConfig_Multiple() {
    return (EAttribute) searchFilterConfigEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilterConfig_Negatable() {
    return (EAttribute) searchFilterConfigEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilterConfig_KeyValuePair() {
    return (EAttribute) searchFilterConfigEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilterConfig_Description() {
    return (EAttribute) searchFilterConfigEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilterConfig_LongDescription() {
    return (EAttribute) searchFilterConfigEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilterConfig_Internal() {
    return (EAttribute) searchFilterConfigEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchFilterConfig_WildcardsAllowed() {
    return (EAttribute) searchFilterConfigEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchFilterConfig_ContentAssist() {
    return (EReference) searchFilterConfigEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchFilterConfig_ImageInfo() {
    return (EReference) searchFilterConfigEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getImageInfo() {
    return imageInfoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getImageInfo_ImageId() {
    return (EAttribute) imageInfoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getImageInfo_ImageEncoded() {
    return (EAttribute) imageInfoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getImageInfo_ImageRegistryId() {
    return (EAttribute) imageInfoEClass.getEStructuralFeatures().get(2);
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
  public EAttribute getContentAssist_ProposalImageSource() {
    return (EAttribute) contentAssistEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getContentAssist_ProposalImageRegistryId() {
    return (EAttribute) contentAssistEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getContentAssist_ProposalImages() {
    return (EReference) contentAssistEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getContentAssist_CachingPossible() {
    return (EAttribute) contentAssistEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSimpleContentProposal() {
    return simpleContentProposalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSimpleContentProposal_Name() {
    return (EAttribute) simpleContentProposalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSimpleContentProposal_Description() {
    return (EAttribute) simpleContentProposalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getFixedValuesContentAssist() {
    return fixedValuesContentAssistEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getFixedValuesContentAssist_Proposals() {
    return (EReference) fixedValuesContentAssistEClass.getEStructuralFeatures().get(0);
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
  public EAttribute getRisContentAssist_ObjectTypes() {
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
  public EAttribute getSearchQueryInput_TypeLabel() {
    return (EAttribute) searchQueryInputEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryInput_MaxRows() {
    return (EAttribute) searchQueryInputEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryInput_CombineFiltersWithAnd() {
    return (EAttribute) searchQueryInputEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryInput_WithApiState() {
    return (EAttribute) searchQueryInputEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryInput_RowLimitDisabled() {
    return (EAttribute) searchQueryInputEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchQueryInput_Fields() {
    return (EReference) searchQueryInputEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchQueryInput_CustomOptions() {
    return (EReference) searchQueryInputEClass.getEStructuralFeatures().get(7);
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
  public EAttribute getSearchQueryField_Label() {
    return (EAttribute) searchQueryFieldEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryField_Name() {
    return (EAttribute) searchQueryFieldEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryField_Values() {
    return (EAttribute) searchQueryFieldEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getSearchQueryField_Filters() {
    return (EReference) searchQueryFieldEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchQueryField_RawInput() {
    return (EAttribute) searchQueryFieldEClass.getEStructuralFeatures().get(4);
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
  public EClass getObjectSearchResult() {
    return objectSearchResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getObjectSearchResult_ResultCount() {
    return (EAttribute) objectSearchResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getObjectSearchResult_ResultObjects() {
    return (EReference) objectSearchResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getSearchResultOutputConfig() {
    return searchResultOutputConfigEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchResultOutputConfig_ListOutputSupported() {
    return (EAttribute) searchResultOutputConfigEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchResultOutputConfig_GroupingLevels() {
    return (EAttribute) searchResultOutputConfigEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getSearchResultOutputConfig_TypesForList() {
    return (EAttribute) searchResultOutputConfigEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getCustomOption() {
    return customOptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCustomOption_Key() {
    return (EAttribute) customOptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCustomOption_Label() {
    return (EAttribute) customOptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCustomOption_Type() {
    return (EAttribute) customOptionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCustomOption_Description() {
    return (EAttribute) customOptionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getCustomOption_OptionValues() {
    return (EReference) customOptionEClass.getEStructuralFeatures().get(4);
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
  public EEnum getProposalImageSource() {
    return proposalImageSourceEEnum;
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
  public EEnum getImageRegistryId() {
    return imageRegistryIdEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getCustomOptionType() {
    return customOptionTypeEEnum;
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

    searchTypeConfigEClass = createEClass(SEARCH_TYPE_CONFIG);
    createEAttribute(searchTypeConfigEClass, SEARCH_TYPE_CONFIG__NAME);
    createEAttribute(searchTypeConfigEClass, SEARCH_TYPE_CONFIG__LABEL);
    createEReference(searchTypeConfigEClass, SEARCH_TYPE_CONFIG__IMAGE_INFO);
    createEReference(searchTypeConfigEClass, SEARCH_TYPE_CONFIG__CUSTOM_OPTIONS);
    createEReference(searchTypeConfigEClass, SEARCH_TYPE_CONFIG__OUTPUT_CONFIG);
    createEReference(searchTypeConfigEClass, SEARCH_TYPE_CONFIG__INPUTS);

    searchTypeInputFieldConfigEClass = createEClass(SEARCH_TYPE_INPUT_FIELD_CONFIG);
    createEAttribute(searchTypeInputFieldConfigEClass, SEARCH_TYPE_INPUT_FIELD_CONFIG__NAME);
    createEAttribute(searchTypeInputFieldConfigEClass, SEARCH_TYPE_INPUT_FIELD_CONFIG__LABEL);
    createEAttribute(searchTypeInputFieldConfigEClass, SEARCH_TYPE_INPUT_FIELD_CONFIG__MIXED);
    createEReference(searchTypeInputFieldConfigEClass, SEARCH_TYPE_INPUT_FIELD_CONFIG__FILTERS);

    searchFilterConfigEClass = createEClass(SEARCH_FILTER_CONFIG);
    createEAttribute(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__NAME);
    createEAttribute(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__DATA_TYPE);
    createEAttribute(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__MAX_LENGTH);
    createEAttribute(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__MULTIPLE);
    createEAttribute(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__NEGATABLE);
    createEAttribute(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__KEY_VALUE_PAIR);
    createEAttribute(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__DESCRIPTION);
    createEAttribute(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__LONG_DESCRIPTION);
    createEAttribute(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__INTERNAL);
    createEAttribute(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__WILDCARDS_ALLOWED);
    createEReference(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__CONTENT_ASSIST);
    createEReference(searchFilterConfigEClass, SEARCH_FILTER_CONFIG__IMAGE_INFO);

    imageInfoEClass = createEClass(IMAGE_INFO);
    createEAttribute(imageInfoEClass, IMAGE_INFO__IMAGE_ID);
    createEAttribute(imageInfoEClass, IMAGE_INFO__IMAGE_ENCODED);
    createEAttribute(imageInfoEClass, IMAGE_INFO__IMAGE_REGISTRY_ID);

    contentAssistEClass = createEClass(CONTENT_ASSIST);
    createEAttribute(contentAssistEClass, CONTENT_ASSIST__PROPOSAL_IMAGE_SOURCE);
    createEAttribute(contentAssistEClass, CONTENT_ASSIST__PROPOSAL_IMAGE_REGISTRY_ID);
    createEReference(contentAssistEClass, CONTENT_ASSIST__PROPOSAL_IMAGES);
    createEAttribute(contentAssistEClass, CONTENT_ASSIST__CACHING_POSSIBLE);

    simpleContentProposalEClass = createEClass(SIMPLE_CONTENT_PROPOSAL);
    createEAttribute(simpleContentProposalEClass, SIMPLE_CONTENT_PROPOSAL__NAME);
    createEAttribute(simpleContentProposalEClass, SIMPLE_CONTENT_PROPOSAL__DESCRIPTION);

    fixedValuesContentAssistEClass = createEClass(FIXED_VALUES_CONTENT_ASSIST);
    createEReference(fixedValuesContentAssistEClass, FIXED_VALUES_CONTENT_ASSIST__PROPOSALS);

    risContentAssistEClass = createEClass(RIS_CONTENT_ASSIST);
    createEAttribute(risContentAssistEClass, RIS_CONTENT_ASSIST__OBJECT_TYPES);

    namedItemContentAssistEClass = createEClass(NAMED_ITEM_CONTENT_ASSIST);
    createEAttribute(namedItemContentAssistEClass, NAMED_ITEM_CONTENT_ASSIST__CATEGORY_SCHEME);
    createEAttribute(namedItemContentAssistEClass, NAMED_ITEM_CONTENT_ASSIST__CATEGORY_TERM);
    createEAttribute(namedItemContentAssistEClass,
        NAMED_ITEM_CONTENT_ASSIST__SECONDARY_CATEGORY_TERM);

    userContentAssistEClass = createEClass(USER_CONTENT_ASSIST);

    searchQueryInputEClass = createEClass(SEARCH_QUERY_INPUT);
    createEAttribute(searchQueryInputEClass, SEARCH_QUERY_INPUT__TYPE);
    createEAttribute(searchQueryInputEClass, SEARCH_QUERY_INPUT__TYPE_LABEL);
    createEAttribute(searchQueryInputEClass, SEARCH_QUERY_INPUT__MAX_ROWS);
    createEAttribute(searchQueryInputEClass, SEARCH_QUERY_INPUT__COMBINE_FILTERS_WITH_AND);
    createEAttribute(searchQueryInputEClass, SEARCH_QUERY_INPUT__WITH_API_STATE);
    createEAttribute(searchQueryInputEClass, SEARCH_QUERY_INPUT__ROW_LIMIT_DISABLED);
    createEReference(searchQueryInputEClass, SEARCH_QUERY_INPUT__FIELDS);
    createEReference(searchQueryInputEClass, SEARCH_QUERY_INPUT__CUSTOM_OPTIONS);

    searchQueryFieldEClass = createEClass(SEARCH_QUERY_FIELD);
    createEAttribute(searchQueryFieldEClass, SEARCH_QUERY_FIELD__LABEL);
    createEAttribute(searchQueryFieldEClass, SEARCH_QUERY_FIELD__NAME);
    createEAttribute(searchQueryFieldEClass, SEARCH_QUERY_FIELD__VALUES);
    createEReference(searchQueryFieldEClass, SEARCH_QUERY_FIELD__FILTERS);
    createEAttribute(searchQueryFieldEClass, SEARCH_QUERY_FIELD__RAW_INPUT);

    searchQueryFilterEClass = createEClass(SEARCH_QUERY_FILTER);
    createEAttribute(searchQueryFilterEClass, SEARCH_QUERY_FILTER__NAME);
    createEAttribute(searchQueryFilterEClass, SEARCH_QUERY_FILTER__VALUES);

    objectSearchResultEClass = createEClass(OBJECT_SEARCH_RESULT);
    createEAttribute(objectSearchResultEClass, OBJECT_SEARCH_RESULT__RESULT_COUNT);
    createEReference(objectSearchResultEClass, OBJECT_SEARCH_RESULT__RESULT_OBJECTS);

    searchResultOutputConfigEClass = createEClass(SEARCH_RESULT_OUTPUT_CONFIG);
    createEAttribute(searchResultOutputConfigEClass,
        SEARCH_RESULT_OUTPUT_CONFIG__LIST_OUTPUT_SUPPORTED);
    createEAttribute(searchResultOutputConfigEClass, SEARCH_RESULT_OUTPUT_CONFIG__GROUPING_LEVELS);
    createEAttribute(searchResultOutputConfigEClass, SEARCH_RESULT_OUTPUT_CONFIG__TYPES_FOR_LIST);

    customOptionEClass = createEClass(CUSTOM_OPTION);
    createEAttribute(customOptionEClass, CUSTOM_OPTION__KEY);
    createEAttribute(customOptionEClass, CUSTOM_OPTION__LABEL);
    createEAttribute(customOptionEClass, CUSTOM_OPTION__TYPE);
    createEAttribute(customOptionEClass, CUSTOM_OPTION__DESCRIPTION);
    createEReference(customOptionEClass, CUSTOM_OPTION__OPTION_VALUES);

    stringToStringMapEntryEClass = createEClass(STRING_TO_STRING_MAP_ENTRY);
    createEAttribute(stringToStringMapEntryEClass, STRING_TO_STRING_MAP_ENTRY__KEY);
    createEAttribute(stringToStringMapEntryEClass, STRING_TO_STRING_MAP_ENTRY__VALUE);

    // Create enums
    proposalImageSourceEEnum = createEEnum(PROPOSAL_IMAGE_SOURCE);
    filterTypeEEnum = createEEnum(FILTER_TYPE);
    imageRegistryIdEEnum = createEEnum(IMAGE_REGISTRY_ID);
    customOptionTypeEEnum = createEEnum(CUSTOM_OPTION_TYPE);
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
    XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE.getEPackage(
        XMLTypePackage.eNS_URI);
    IAdtBasePackage theAdtBasePackage = (IAdtBasePackage) EPackage.Registry.INSTANCE.getEPackage(
        IAdtBasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    fixedValuesContentAssistEClass.getESuperTypes().add(getContentAssist());
    risContentAssistEClass.getESuperTypes().add(getContentAssist());
    namedItemContentAssistEClass.getESuperTypes().add(getContentAssist());
    userContentAssistEClass.getESuperTypes().add(getContentAssist());

    // Initialize classes, features, and operations; add parameters
    initEClass(searchConfigEClass, ISearchConfig.class, "SearchConfig", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSearchConfig_SearchTypes(), getSearchTypeConfig(), null, "searchTypes", null,
        0, -1, ISearchConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchTypeConfigEClass, ISearchTypeConfig.class, "SearchTypeConfig", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchTypeConfig_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        ISearchTypeConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchTypeConfig_Label(), ecorePackage.getEString(), "label", null, 0, 1,
        ISearchTypeConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchTypeConfig_ImageInfo(), getImageInfo(), null, "imageInfo", null, 0, 1,
        ISearchTypeConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchTypeConfig_CustomOptions(), getCustomOption(), null, "customOptions",
        null, 0, -1, ISearchTypeConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchTypeConfig_OutputConfig(), getSearchResultOutputConfig(), null,
        "outputConfig", null, 0, 1, ISearchTypeConfig.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getSearchTypeConfig_Inputs(), getSearchTypeInputFieldConfig(), null, "inputs",
        null, 0, -1, ISearchTypeConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchTypeInputFieldConfigEClass, ISearchTypeInputFieldConfig.class,
        "SearchTypeInputFieldConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchTypeInputFieldConfig_Name(), ecorePackage.getEString(), "name", null, 0,
        1, ISearchTypeInputFieldConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchTypeInputFieldConfig_Label(), ecorePackage.getEString(), "label", null,
        0, 1, ISearchTypeInputFieldConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchTypeInputFieldConfig_Mixed(), ecorePackage.getEBoolean(), "mixed", null,
        0, 1, ISearchTypeInputFieldConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchTypeInputFieldConfig_Filters(), getSearchFilterConfig(), null,
        "filters", null, 0, -1, ISearchTypeInputFieldConfig.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(searchFilterConfigEClass, ISearchFilterConfig.class, "SearchFilterConfig",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchFilterConfig_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilterConfig_DataType(), getFilterType(), "dataType", null, 0, 1,
        ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilterConfig_MaxLength(), ecorePackage.getEInt(), "maxLength", null, 0,
        1, ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilterConfig_Multiple(), ecorePackage.getEBoolean(), "multiple", null,
        0, 1, ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilterConfig_Negatable(), ecorePackage.getEBoolean(), "negatable", null,
        0, 1, ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilterConfig_KeyValuePair(), ecorePackage.getEBoolean(), "keyValuePair",
        null, 0, 1, ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilterConfig_Description(), ecorePackage.getEString(), "description",
        null, 0, 1, ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilterConfig_LongDescription(), ecorePackage.getEString(),
        "longDescription", null, 0, 1, ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilterConfig_Internal(), ecorePackage.getEBoolean(), "internal", null,
        0, 1, ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchFilterConfig_WildcardsAllowed(), ecorePackage.getEBoolean(),
        "wildcardsAllowed", null, 0, 1, ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchFilterConfig_ContentAssist(), getContentAssist(), null, "contentAssist",
        null, 0, 1, ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchFilterConfig_ImageInfo(), getImageInfo(), null, "imageInfo", null, 0, 1,
        ISearchFilterConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(imageInfoEClass, IImageInfo.class, "ImageInfo", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImageInfo_ImageId(), ecorePackage.getEString(), "imageId", null, 0, 1,
        IImageInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getImageInfo_ImageEncoded(), ecorePackage.getEString(), "imageEncoded", null, 0,
        1, IImageInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getImageInfo_ImageRegistryId(), getImageRegistryId(), "imageRegistryId", null, 0,
        1, IImageInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(contentAssistEClass, IContentAssist.class, "ContentAssist", IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getContentAssist_ProposalImageSource(), getProposalImageSource(),
        "proposalImageSource", null, 0, 1, IContentAssist.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContentAssist_ProposalImageRegistryId(), getImageRegistryId(),
        "proposalImageRegistryId", null, 0, 1, IContentAssist.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContentAssist_ProposalImages(), getImageInfo(), null, "proposalImages", null,
        0, -1, IContentAssist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContentAssist_CachingPossible(), ecorePackage.getEBoolean(),
        "cachingPossible", null, 0, 1, IContentAssist.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleContentProposalEClass, ISimpleContentProposal.class, "SimpleContentProposal",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleContentProposal_Name(), theXMLTypePackage.getString(), "name", null, 0,
        1, ISimpleContentProposal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleContentProposal_Description(), theXMLTypePackage.getString(),
        "description", null, 0, 1, ISimpleContentProposal.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fixedValuesContentAssistEClass, IFixedValuesContentAssist.class,
        "FixedValuesContentAssist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFixedValuesContentAssist_Proposals(), getSimpleContentProposal(), null,
        "proposals", null, 0, -1, IFixedValuesContentAssist.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(risContentAssistEClass, IRisContentAssist.class, "RisContentAssist", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRisContentAssist_ObjectTypes(), ecorePackage.getEString(), "objectTypes",
        null, 0, -1, IRisContentAssist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
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
    initEAttribute(getSearchQueryInput_TypeLabel(), ecorePackage.getEString(), "typeLabel", null, 0,
        1, ISearchQueryInput.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryInput_MaxRows(), ecorePackage.getEInt(), "maxRows", null, 0, 1,
        ISearchQueryInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryInput_CombineFiltersWithAnd(), ecorePackage.getEBoolean(),
        "combineFiltersWithAnd", null, 0, 1, ISearchQueryInput.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryInput_WithApiState(), ecorePackage.getEBoolean(), "withApiState",
        null, 0, 1, ISearchQueryInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryInput_RowLimitDisabled(), ecorePackage.getEBoolean(),
        "rowLimitDisabled", null, 0, 1, ISearchQueryInput.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchQueryInput_Fields(), getSearchQueryField(), null, "fields", null, 0, -1,
        ISearchQueryInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchQueryInput_CustomOptions(), getStringToStringMapEntry(), null,
        "customOptions", null, 0, -1, ISearchQueryInput.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(searchQueryFieldEClass, ISearchQueryField.class, "SearchQueryField", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchQueryField_Label(), ecorePackage.getEString(), "label", null, 0, 1,
        ISearchQueryField.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryField_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        ISearchQueryField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryField_Values(), ecorePackage.getEString(), "values", null, 0, -1,
        ISearchQueryField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSearchQueryField_Filters(), getSearchQueryFilter(), null, "filters", null, 0,
        -1, ISearchQueryField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryField_RawInput(), theXMLTypePackage.getString(), "rawInput", null,
        0, 1, ISearchQueryField.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(searchQueryFilterEClass, ISearchQueryFilter.class, "SearchQueryFilter", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchQueryFilter_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        ISearchQueryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchQueryFilter_Values(), ecorePackage.getEString(), "values", null, 0, -1,
        ISearchQueryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectSearchResultEClass, IObjectSearchResult.class, "ObjectSearchResult",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObjectSearchResult_ResultCount(), ecorePackage.getEInt(), "resultCount", null,
        0, 1, IObjectSearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectSearchResult_ResultObjects(), theAdtBasePackage.getAdtObjRef(), null,
        "resultObjects", null, 0, -1, IObjectSearchResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(searchResultOutputConfigEClass, ISearchResultOutputConfig.class,
        "SearchResultOutputConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSearchResultOutputConfig_ListOutputSupported(), theXMLTypePackage
        .getBoolean(), "listOutputSupported", null, 0, 1, ISearchResultOutputConfig.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getSearchResultOutputConfig_GroupingLevels(), theXMLTypePackage.getString(),
        "groupingLevels", null, 0, -1, ISearchResultOutputConfig.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSearchResultOutputConfig_TypesForList(), theXMLTypePackage.getString(),
        "typesForList", null, 0, -1, ISearchResultOutputConfig.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(customOptionEClass, ICustomOption.class, "CustomOption", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCustomOption_Key(), theXMLTypePackage.getString(), "key", null, 0, 1,
        ICustomOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCustomOption_Label(), theXMLTypePackage.getString(), "label", null, 0, 1,
        ICustomOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCustomOption_Type(), getCustomOptionType(), "type", null, 0, 1,
        ICustomOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCustomOption_Description(), theXMLTypePackage.getString(), "description",
        null, 0, 1, ICustomOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCustomOption_OptionValues(), getStringToStringMapEntry(), null,
        "optionValues", null, 0, -1, ICustomOption.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(stringToStringMapEntryEClass, Map.Entry.class, "StringToStringMapEntry",
        !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringToStringMapEntry_Key(), theXMLTypePackage.getString(), "key", null, 0,
        1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStringToStringMapEntry_Value(), theXMLTypePackage.getString(), "value", null,
        0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(proposalImageSourceEEnum, ProposalImageSource.class, "ProposalImageSource");
    addEEnumLiteral(proposalImageSourceEEnum, ProposalImageSource.FIXED);
    addEEnumLiteral(proposalImageSourceEEnum, ProposalImageSource.PROPOSAL);
    addEEnumLiteral(proposalImageSourceEEnum, ProposalImageSource.SAME_AS_FILTER);

    initEEnum(filterTypeEEnum, FilterType.class, "FilterType");
    addEEnumLiteral(filterTypeEEnum, FilterType.DEFAULT);
    addEEnumLiteral(filterTypeEEnum, FilterType.DATE);
    addEEnumLiteral(filterTypeEEnum, FilterType.BOOLEAN);

    initEEnum(imageRegistryIdEEnum, ImageRegistryId.class, "ImageRegistryId");
    addEEnumLiteral(imageRegistryIdEEnum, ImageRegistryId.CALLING_PLUGIN);
    addEEnumLiteral(imageRegistryIdEEnum, ImageRegistryId.ADT_OBJECT_TYPE);

    initEEnum(customOptionTypeEEnum, CustomOptionType.class, "CustomOptionType");
    addEEnumLiteral(customOptionTypeEEnum, CustomOptionType.STRING);
    addEEnumLiteral(customOptionTypeEEnum, CustomOptionType.BOOLEAN);

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
    addAnnotation(searchTypeConfigEClass, source, new String[] { "kind", "elementOnly", "name",
        "searchType" });
    addAnnotation(getSearchTypeConfig_Name(), source, new String[] { "name", "name", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchTypeConfig_Label(), source, new String[] { "name", "label", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchTypeConfig_ImageInfo(), source, new String[] { "name", "imageInfo",
        "kind", "element", "namespace", "##targetNamespace" });
    addAnnotation(getSearchTypeConfig_CustomOptions(), source, new String[] { "kind", "element",
        "namespace", "##targetNamespace", "name", "customOption" });
    addAnnotation(getSearchTypeConfig_OutputConfig(), source, new String[] { "kind", "element",
        "name", "resultOutputConfig", "namespace", "##targetNamespace" });
    addAnnotation(getSearchTypeConfig_Inputs(), source, new String[] { "name", "input", "kind",
        "element", "namespace", "##targetNamespace" });
    addAnnotation(searchTypeInputFieldConfigEClass, source, new String[] { "kind", "elementOnly",
        "name", "input" });
    addAnnotation(getSearchTypeInputFieldConfig_Name(), source, new String[] { "name", "name",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchTypeInputFieldConfig_Label(), source, new String[] { "name", "label",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchTypeInputFieldConfig_Mixed(), source, new String[] { "name", "mixed",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchTypeInputFieldConfig_Filters(), source, new String[] { "name", "filter",
        "kind", "element", "namespace", "##targetNamespace" });
    addAnnotation(searchFilterConfigEClass, source, new String[] { "kind", "elementOnly", "name",
        "filter" });
    addAnnotation(getSearchFilterConfig_Name(), source, new String[] { "name", "name", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_DataType(), source, new String[] { "name", "dataType",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_MaxLength(), source, new String[] { "name", "maxLength",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_Multiple(), source, new String[] { "name", "multiple",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_Negatable(), source, new String[] { "name", "negatable",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_KeyValuePair(), source, new String[] { "name",
        "keyValuePair", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_Description(), source, new String[] { "name", "description",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_LongDescription(), source, new String[] { "name",
        "longDescription", "kind", "element", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_Internal(), source, new String[] { "name", "internal",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_WildcardsAllowed(), source, new String[] { "name",
        "patterns", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_ContentAssist(), source, new String[] { "name",
        "contentAssist", "kind", "element", "namespace", "##targetNamespace" });
    addAnnotation(getSearchFilterConfig_ImageInfo(), source, new String[] { "name", "imageInfo",
        "kind", "element", "namespace", "##targetNamespace" });
    addAnnotation(imageInfoEClass, source, new String[] { "kind", "elementOnly", "name",
        "proposalImage" });
    addAnnotation(getImageInfo_ImageId(), source, new String[] { "name", "imageId", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getImageInfo_ImageEncoded(), source, new String[] { "name", "imageEncoded",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getImageInfo_ImageRegistryId(), source, new String[] { "name", "imageRegistryId",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getContentAssist_ProposalImageSource(), source, new String[] { "name",
        "proposalImageSource", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getContentAssist_ProposalImageRegistryId(), source, new String[] { "name",
        "proposalImageRegistryId", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getContentAssist_ProposalImages(), source, new String[] { "name", "proposalImage",
        "kind", "element", "namespace", "##targetNamespace" });
    addAnnotation(getContentAssist_CachingPossible(), source, new String[] { "name", "caching",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(simpleContentProposalEClass, source, new String[] { "kind", "elementOnly", "name",
        "contentProposal" });
    addAnnotation(getSimpleContentProposal_Name(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getSimpleContentProposal_Description(), source, new String[] { "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getFixedValuesContentAssist_Proposals(), source, new String[] { "kind", "element",
        "namespace", "##targetNamespace", "name", "proposal" });
    addAnnotation(getRisContentAssist_ObjectTypes(), source, new String[] { "name", "objectType",
        "kind", "element", "namespace", "##targetNamespace" });
    addAnnotation(getNamedItemContentAssist_CategoryScheme(), source, new String[] { "name",
        "categoryScheme", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getNamedItemContentAssist_CategoryTerm(), source, new String[] { "name",
        "categoryTerm", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getNamedItemContentAssist_SecondaryCategoryTerm(), source, new String[] { "name",
        "secondaryCategoryTerm", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(searchQueryInputEClass, source, new String[] { "kind", "elementOnly", "name",
        "queryInput" });
    addAnnotation(getSearchQueryInput_Type(), source, new String[] { "name", "type", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryInput_MaxRows(), source, new String[] { "name", "maxRows", "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryInput_CombineFiltersWithAnd(), source, new String[] { "name",
        "combineFiltersWithAnd", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryInput_WithApiState(), source, new String[] { "name", "withApiState",
        "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryInput_RowLimitDisabled(), source, new String[] { "name",
        "rowLimitDisabled", "kind", "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryInput_Fields(), source, new String[] { "name", "field", "kind",
        "element", "namespace", "##targetNamespace" });
    addAnnotation(getSearchQueryInput_CustomOptions(), source, new String[] { "kind", "element",
        "namespace", "##targetNamespace", "name", "customOption" });
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
    addAnnotation(objectSearchResultEClass, source, new String[] { "kind", "elementOnly", "name",
        "searchResult" });
    addAnnotation(getObjectSearchResult_ResultCount(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getObjectSearchResult_ResultObjects(), source, new String[] { "name", "adtObjRef",
        "kind", "element", "namespace", "http://www.devepos.com/adt/base" });
    addAnnotation(searchResultOutputConfigEClass, source, new String[] { "kind", "elementOnly",
        "name", "searchResultOutputConfig" });
    addAnnotation(getSearchResultOutputConfig_ListOutputSupported(), source, new String[] { "kind",
        "attribute", "namespace", "##targetNamespace" });
    addAnnotation(getSearchResultOutputConfig_GroupingLevels(), source, new String[] { "kind",
        "element", "namespace", "##targetNamespace", "name", "groupingLevel" });
    addAnnotation(getSearchResultOutputConfig_TypesForList(), source, new String[] { "kind",
        "element", "name", "typeForList", "namespace", "##targetNamespace" });
    addAnnotation(getCustomOption_Description(), source, new String[] { "kind", "element",
        "namespace", "##targetNamespace" });
    addAnnotation(getCustomOption_OptionValues(), source, new String[] { "kind", "element",
        "namespace", "##targetNamespace", "name", "optionValue" });
    addAnnotation(getStringToStringMapEntry_Key(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getStringToStringMapEntry_Value(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
  }

} // ObjectSearchPackage
