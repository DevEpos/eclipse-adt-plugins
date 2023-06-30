/**
 */
package com.devepos.adt.saat.model.objectsearch.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.devepos.adt.saat.model.objectsearch.IObjectSearchPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ObjectSearchXMLProcessor extends XMLProcessor {

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public ObjectSearchXMLProcessor() {
    super(EPackage.Registry.INSTANCE);
    IObjectSearchPackage.eINSTANCE.eClass();
  }

  /**
   * Register for "*" and "xml" file extensions the ObjectSearchResourceFactory factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations() {
    if (registrations == null) {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new ObjectSearchResourceFactory());
      registrations.put(STAR_EXTENSION, new ObjectSearchResourceFactory());
    }
    return registrations;
  }

} // ObjectSearchXMLProcessor
