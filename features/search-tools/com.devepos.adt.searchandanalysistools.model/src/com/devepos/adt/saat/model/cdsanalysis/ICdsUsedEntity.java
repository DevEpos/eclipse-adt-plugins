/**
 */
package com.devepos.adt.saat.model.cdsanalysis;

import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cds Used Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity#getEntityRef <em>Entity
 * Ref</em>}</li>
 * <li>{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity#getUsageInformation <em>Usage
 * Information</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntity()
 * @model extendedMetaData="kind='elementOnly' name='usedEntity'"
 * @generated
 */
public interface ICdsUsedEntity extends EObject {
  /**
   * Returns the value of the '<em><b>Entity Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entity Ref</em>' containment reference.
   * @see #setEntityRef(IAdtObjRef)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntity_EntityRef()
   * @model containment="true"
   *        extendedMetaData="kind='element' namespace='http://www.devepos.com/adt/base'
   *        name='adtObjRef'"
   * @generated
   */
  IAdtObjRef getEntityRef();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity#getEntityRef <em>Entity
   * Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Entity Ref</em>' containment reference.
   * @see #getEntityRef()
   * @generated
   */
  void setEntityRef(IAdtObjRef value);

  /**
   * Returns the value of the '<em><b>Usage Information</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Usage Information</em>' reference.
   * @see #setUsageInformation(ICdsUsedEntityInformation)
   * @see com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage#getCdsUsedEntity_UsageInformation()
   * @model extendedMetaData="kind='element' namespace='##targetNamespace'"
   * @generated
   */
  ICdsUsedEntityInformation getUsageInformation();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntity#getUsageInformation <em>Usage
   * Information</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Usage Information</em>' reference.
   * @see #getUsageInformation()
   * @generated
   */
  void setUsageInformation(ICdsUsedEntityInformation value);

} // ICdsUsedEntity
