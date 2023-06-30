/**
 */
package com.devepos.adt.saat.model.objectsearch.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.devepos.adt.saat.model.objectsearch.IContentAssist;
import com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist;
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
    case IObjectSearchPackage.SEARCH_TYPE: {
      ISearchType searchType = (ISearchType) theEObject;
      T result = caseSearchType(searchType);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.SEARCH_TYPE_INPUT: {
      ISearchTypeInput searchTypeInput = (ISearchTypeInput) theEObject;
      T result = caseSearchTypeInput(searchTypeInput);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IObjectSearchPackage.SEARCH_FILTER: {
      ISearchFilter searchFilter = (ISearchFilter) theEObject;
      T result = caseSearchFilter(searchFilter);
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
    case IObjectSearchPackage.SEARCH_RESULT: {
      ISearchResult searchResult = (ISearchResult) theEObject;
      T result = caseSearchResult(searchResult);
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
   * Returns the result of interpreting the object as an instance of '<em>Search Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchType(final ISearchType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Type Input</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Type Input</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchTypeInput(final ISearchTypeInput object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Search Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchFilter(final ISearchFilter object) {
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
   * Returns the result of interpreting the object as an instance of '<em>Search Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Search Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSearchResult(final ISearchResult object) {
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
