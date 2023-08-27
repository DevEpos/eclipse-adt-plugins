/**
 */
package com.devepos.adt.saat.model.objectsearch.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.devepos.adt.saat.model.objectsearch.IAdtAlternativeTypeImage;
import com.devepos.adt.saat.model.objectsearch.IContentAssist;
import com.devepos.adt.saat.model.objectsearch.ICustomOption;
import com.devepos.adt.saat.model.objectsearch.IFixedValuesContentAssist;
import com.devepos.adt.saat.model.objectsearch.IImageInfo;
import com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist;
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

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage
 * @generated
 */
public class ObjectSearchSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected static IObjectSearchPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public ObjectSearchSwitch() {
    if (modelPackage == null) {
      modelPackage = IObjectSearchPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(final EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it
   * yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(final int classifierID, final EObject theEObject) {
    switch (classifierID) {
    case IObjectSearchPackage.SEARCH_CONFIG: {
      ISearchConfig searchConfig = (ISearchConfig) theEObject;
      T result = caseSearchConfig(searchConfig);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.SEARCH_TYPE_CONFIG: {
      ISearchTypeConfig searchTypeConfig = (ISearchTypeConfig) theEObject;
      T result = caseSearchTypeConfig(searchTypeConfig);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.SEARCH_TYPE_INPUT_FIELD_CONFIG: {
      ISearchTypeInputFieldConfig searchTypeInputFieldConfig = (ISearchTypeInputFieldConfig) theEObject;
      T result = caseSearchTypeInputFieldConfig(searchTypeInputFieldConfig);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.SEARCH_FILTER_CONFIG: {
      ISearchFilterConfig searchFilterConfig = (ISearchFilterConfig) theEObject;
      T result = caseSearchFilterConfig(searchFilterConfig);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.IMAGE_INFO: {
      IImageInfo imageInfo = (IImageInfo) theEObject;
      T result = caseImageInfo(imageInfo);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.CONTENT_ASSIST: {
      IContentAssist contentAssist = (IContentAssist) theEObject;
      T result = caseContentAssist(contentAssist);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.SIMPLE_CONTENT_PROPOSAL: {
      ISimpleContentProposal simpleContentProposal = (ISimpleContentProposal) theEObject;
      T result = caseSimpleContentProposal(simpleContentProposal);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.FIXED_VALUES_CONTENT_ASSIST: {
      IFixedValuesContentAssist fixedValuesContentAssist = (IFixedValuesContentAssist) theEObject;
      T result = caseFixedValuesContentAssist(fixedValuesContentAssist);
      if (result == null) {
        result = caseContentAssist(fixedValuesContentAssist);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.RIS_CONTENT_ASSIST: {
      IRisContentAssist risContentAssist = (IRisContentAssist) theEObject;
      T result = caseRisContentAssist(risContentAssist);
      if (result == null) {
        result = caseContentAssist(risContentAssist);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.NAMED_ITEM_CONTENT_ASSIST: {
      INamedItemContentAssist namedItemContentAssist = (INamedItemContentAssist) theEObject;
      T result = caseNamedItemContentAssist(namedItemContentAssist);
      if (result == null) {
        result = caseContentAssist(namedItemContentAssist);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.USER_CONTENT_ASSIST: {
      IUserContentAssist userContentAssist = (IUserContentAssist) theEObject;
      T result = caseUserContentAssist(userContentAssist);
      if (result == null) {
        result = caseContentAssist(userContentAssist);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.SEARCH_QUERY_INPUT: {
      ISearchQueryInput searchQueryInput = (ISearchQueryInput) theEObject;
      T result = caseSearchQueryInput(searchQueryInput);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.SEARCH_QUERY_FIELD: {
      ISearchQueryField searchQueryField = (ISearchQueryField) theEObject;
      T result = caseSearchQueryField(searchQueryField);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.SEARCH_QUERY_FILTER: {
      ISearchQueryFilter searchQueryFilter = (ISearchQueryFilter) theEObject;
      T result = caseSearchQueryFilter(searchQueryFilter);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.OBJECT_SEARCH_RESULT: {
      IObjectSearchResult objectSearchResult = (IObjectSearchResult) theEObject;
      T result = caseObjectSearchResult(objectSearchResult);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.SEARCH_RESULT_OUTPUT_CONFIG: {
      ISearchResultOutputConfig searchResultOutputConfig = (ISearchResultOutputConfig) theEObject;
      T result = caseSearchResultOutputConfig(searchResultOutputConfig);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.CUSTOM_OPTION: {
      ICustomOption customOption = (ICustomOption) theEObject;
      T result = caseCustomOption(customOption);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.STRING_TO_STRING_MAP_ENTRY: {
      @SuppressWarnings("unchecked")
      Map.Entry<String, String> stringToStringMapEntry = (Map.Entry<String, String>) theEObject;
      T result = caseStringToStringMapEntry(stringToStringMapEntry);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.ADT_ALTERNATIVE_TYPE_IMAGE: {
      IAdtAlternativeTypeImage adtAlternativeTypeImage = (IAdtAlternativeTypeImage) theEObject;
      T result = caseAdtAlternativeTypeImage(adtAlternativeTypeImage);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchConfig(final ISearchConfig object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Type Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Type Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchTypeConfig(final ISearchTypeConfig object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Type Input Field
   * Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Type Input Field
   *         Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchTypeInputFieldConfig(final ISearchTypeInputFieldConfig object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Filter
   * Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Filter
   *         Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchFilterConfig(final ISearchFilterConfig object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Image Info</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Image Info</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImageInfo(final IImageInfo object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Content Assist</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Content Assist</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContentAssist(final IContentAssist object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Content
   * Proposal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Content
   *         Proposal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleContentProposal(final ISimpleContentProposal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fixed Values Content
   * Assist</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fixed Values Content
   *         Assist</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFixedValuesContentAssist(final IFixedValuesContentAssist object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ris Content Assist</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ris Content Assist</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRisContentAssist(final IRisContentAssist object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Item Content
   * Assist</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Item Content
   *         Assist</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedItemContentAssist(final INamedItemContentAssist object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>User Content Assist</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>User Content Assist</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUserContentAssist(final IUserContentAssist object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Query Input</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Query Input</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchQueryInput(final ISearchQueryInput object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Query Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Query Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchQueryField(final ISearchQueryField object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Query Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Query Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchQueryFilter(final ISearchQueryFilter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectSearchResult(final IObjectSearchResult object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Result Output
   * Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Result Output
   *         Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchResultOutputConfig(final ISearchResultOutputConfig object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Custom Option</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Custom Option</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCustomOption(final ICustomOption object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String To String Map
   * Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String To String Map
   *         Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringToStringMapEntry(final Map.Entry<String, String> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Adt Alternative Type
   * Image</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Adt Alternative Type
   *         Image</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdtAlternativeTypeImage(final IAdtAlternativeTypeImage object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(final EObject object) {
    return null;
  }

} // ObjectSearchSwitch
