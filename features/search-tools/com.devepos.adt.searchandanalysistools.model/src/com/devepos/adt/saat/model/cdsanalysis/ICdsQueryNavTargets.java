/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cds Query Nav Targets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ICdsQueryNavTargets#getNavigationTargets
 * <em>Navigation Targets</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsQueryNavTargets()
 * @model extendedMetaData="kind='elementOnly' name='navigationTargets'"
 * @generated
 */
public interface ICdsQueryNavTargets extends EObject {
  /**
   * Returns the value of the '<em><b>Navigation Targets</b></em>' attribute list.
   * The list contents are of type {@link com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget}.
   * The literals are from the enumeration
   * {@link com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Navigation Targets</em>' attribute list.
   * @see com.devepos.adt.saat.model.cdsanalysis.CdsQueryNavTarget
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsQueryNavTargets_NavigationTargets()
   * @model extendedMetaData="kind='element' namespace='##targetNamespace' name='navigationTarget'"
   * @generated
   */
  List<CdsQueryNavTarget> getNavigationTargets();

} // ICdsQueryNavTargets
