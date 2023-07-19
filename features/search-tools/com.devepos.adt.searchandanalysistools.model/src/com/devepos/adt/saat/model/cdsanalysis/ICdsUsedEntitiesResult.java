/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cds Used Entities Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult#getSourceEntity
 * <em>Source Entity</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult#getUsedEntities <em>Used
 * Entities</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntitiesResult()
 * @model extendedMetaData="kind='elementOnly' name='usedEntitiesResult'"
 * @generated
 */
public interface ICdsUsedEntitiesResult extends EObject {
  /**
   * Returns the value of the '<em><b>Source Entity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Source Entity</em>' containment reference.
   * @see #setSourceEntity(IAdtObjRef)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntitiesResult_SourceEntity()
   * @model containment="true"
   *        extendedMetaData="kind='element' namespace='http://www.devepos.com/adt/base'
   *        name='adtObjRef'"
   * @generated
   */
  IAdtObjRef getSourceEntity();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult#getSourceEntity
   * <em>Source Entity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Source Entity</em>' containment reference.
   * @see #getSourceEntity()
   * @generated
   */
  void setSourceEntity(IAdtObjRef value);

  /**
   * Returns the value of the '<em><b>Used Entities</b></em>' reference list.
   * The list contents are of type {@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Used Entities</em>' reference list.
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntitiesResult_UsedEntities()
   * @model extendedMetaData="kind='element' namespace='##targetNamespace' name='usedEntity'"
   * @generated
   */
  List<ICdsUsedEntity> getUsedEntities();

} // ICdsUsedEntitiesResult
