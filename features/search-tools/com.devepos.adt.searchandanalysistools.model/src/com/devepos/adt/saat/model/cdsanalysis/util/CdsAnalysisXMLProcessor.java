/**
 */
package com.devepos.adt.saat.model.cdsanalysis.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.devepos.adt.saat.model.cdsanalysis.ICdsAnalysisPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CdsAnalysisXMLProcessor extends XMLProcessor {

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public CdsAnalysisXMLProcessor() {
    super(EPackage.Registry.INSTANCE);
    ICdsAnalysisPackage.eINSTANCE.eClass();
  }

  /**
   * Register for "*" and "xml" file extensions the CdsAnalysisResourceFactory factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations() {
    if (registrations == null) {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new CdsAnalysisResourceFactory());
      registrations.put(STAR_EXTENSION, new CdsAnalysisResourceFactory());
    }
    return registrations;
  }

} // CdsAnalysisXMLProcessor
