/**
 */
package com.devepos.adt.saat.model.cdsanalysis.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;
import com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult;
import com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry;
import com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsResult;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage
 * @generated
 */
public class CdsAnalysisAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected static ICdsAnalysisPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public CdsAnalysisAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = ICdsAnalysisPackage.eINSTANCE;
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
  protected CdsAnalysisSwitch<Adapter> modelSwitch = new CdsAnalysisSwitch<>() {
    @Override
    public Adapter caseCdsUsedEntitiesResult(final ICdsUsedEntitiesResult object) {
      return createCdsUsedEntitiesResultAdapter();
    }

    @Override
    public Adapter caseCdsUsedEntity(final ICdsUsedEntity object) {
      return createCdsUsedEntityAdapter();
    }

    @Override
    public Adapter caseCdsUsedEntityInformation(final ICdsUsedEntityInformation object) {
      return createCdsUsedEntityInformationAdapter();
    }

    @Override
    public Adapter caseTopDownAnalysisResult(final ITopDownAnalysisResult object) {
      return createTopDownAnalysisResultAdapter();
    }

    @Override
    public Adapter caseTopDownAnalysisEntry(final ITopDownAnalysisEntry object) {
      return createTopDownAnalysisEntryAdapter();
    }

    @Override
    public Adapter caseCdsQueryNavTargets(final ICdsQueryNavTargets object) {
      return createCdsQueryNavTargetsAdapter();
    }

    @Override
    public Adapter caseEntityFieldInfo(final IEntityFieldInfo object) {
      return createEntityFieldInfoAdapter();
    }

    @Override
    public Adapter caseEntityFieldInfoResult(final IEntityFieldInfoResult object) {
      return createEntityFieldInfoResultAdapter();
    }

    @Override
    public Adapter caseWhereUsedInCdsEntry(final IWhereUsedInCdsEntry object) {
      return createWhereUsedInCdsEntryAdapter();
    }

    @Override
    public Adapter caseWhereUsedInCdsResult(final IWhereUsedInCdsResult object) {
      return createWhereUsedInCdsResultAdapter();
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
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult <em>Cds Used Entities
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult
   * @generated
   */
  public Adapter createCdsUsedEntitiesResultAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity <em>Cds Used Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity
   * @generated
   */
  public Adapter createCdsUsedEntityAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation <em>Cds Used Entity
   * Information</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntityInformation
   * @generated
   */
  public Adapter createCdsUsedEntityInformationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult <em>Top Down Analysis
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult
   * @generated
   */
  public Adapter createTopDownAnalysisResultAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry <em>Top Down Analysis
   * Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisEntry
   * @generated
   */
  public Adapter createTopDownAnalysisEntryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets <em>Cds Query Nav
   * Targets</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets
   * @generated
   */
  public Adapter createCdsQueryNavTargetsAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult <em>Entity Field Info
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult
   * @generated
   */
  public Adapter createEntityFieldInfoResultAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry <em>Where Used In Cds
   * Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsEntry
   * @generated
   */
  public Adapter createWhereUsedInCdsEntryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsResult <em>Where Used In Cds
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsResult
   * @generated
   */
  public Adapter createWhereUsedInCdsResultAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo <em>Entity Field Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo
   * @generated
   */
  public Adapter createEntityFieldInfoAdapter() {
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

} // CdsAnalysisAdapterFactory
