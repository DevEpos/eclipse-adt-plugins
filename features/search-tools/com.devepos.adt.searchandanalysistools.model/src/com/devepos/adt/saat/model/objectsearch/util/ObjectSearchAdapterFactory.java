/**
 */
package com.devepos.adt.saat.model.objectsearch.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage
 * @generated
 */
public class ObjectSearchAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected static IObjectSearchPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public ObjectSearchAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = IObjectSearchPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is
   * an instance object of the model.
   * <!-- end-user-doc -->
   *
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(final Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected ObjectSearchSwitch<Adapter> modelSwitch = new ObjectSearchSwitch<>() {
    @Override
    public Adapter caseSearchConfig(final ISearchConfig object) {
      return createSearchConfigAdapter();
    }

    @Override
    public Adapter caseSearchType(final ISearchType object) {
      return createSearchTypeAdapter();
    }

    @Override
    public Adapter caseSearchTypeInput(final ISearchTypeInput object) {
      return createSearchTypeInputAdapter();
    }

    @Override
    public Adapter caseSearchFilter(final ISearchFilter object) {
      return createSearchFilterAdapter();
    }

    @Override
    public Adapter caseContentAssist(final IContentAssist object) {
      return createContentAssistAdapter();
    }

    @Override
    public Adapter caseRisContentAssist(final IRisContentAssist object) {
      return createRisContentAssistAdapter();
    }

    @Override
    public Adapter caseNamedItemContentAssist(final INamedItemContentAssist object) {
      return createNamedItemContentAssistAdapter();
    }

    @Override
    public Adapter caseUserContentAssist(final IUserContentAssist object) {
      return createUserContentAssistAdapter();
    }

    @Override
    public Adapter caseSearchQueryInput(final ISearchQueryInput object) {
      return createSearchQueryInputAdapter();
    }

    @Override
    public Adapter caseSearchQueryField(final ISearchQueryField object) {
      return createSearchQueryFieldAdapter();
    }

    @Override
    public Adapter caseSearchQueryFilter(final ISearchQueryFilter object) {
      return createSearchQueryFilterAdapter();
    }

    @Override
    public Adapter caseSearchResult(final ISearchResult object) {
      return createSearchResultAdapter();
    }

    @Override
    public Adapter defaultCase(final EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(final Notifier target) {
    return modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchConfig <em>Search Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchConfig
   * @generated
   */
  public Adapter createSearchConfigAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchType <em>Search Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchType
   * @generated
   */
  public Adapter createSearchTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchTypeInput <em>Search Type Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchTypeInput
   * @generated
   */
  public Adapter createSearchTypeInputAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchFilter <em>Search Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchFilter
   * @generated
   */
  public Adapter createSearchFilterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.IContentAssist <em>Content Assist</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.IContentAssist
   * @generated
   */
  public Adapter createContentAssistAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.IRisContentAssist <em>Ris Content
   * Assist</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.IRisContentAssist
   * @generated
   */
  public Adapter createRisContentAssistAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist <em>Named Item Content
   * Assist</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.INamedItemContentAssist
   * @generated
   */
  public Adapter createNamedItemContentAssistAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.IUserContentAssist <em>User Content
   * Assist</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.IUserContentAssist
   * @generated
   */
  public Adapter createUserContentAssistAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryInput <em>Search Query
   * Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryInput
   * @generated
   */
  public Adapter createSearchQueryInputAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryField <em>Search Query
   * Field</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryField
   * @generated
   */
  public Adapter createSearchQueryFieldAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter <em>Search Query
   * Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchQueryFilter
   * @generated
   */
  public Adapter createSearchQueryFilterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.objectsearch.ISearchResult <em>Search Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.objectsearch.ISearchResult
   * @generated
   */
  public Adapter createSearchResultAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // ObjectSearchAdapterFactory
