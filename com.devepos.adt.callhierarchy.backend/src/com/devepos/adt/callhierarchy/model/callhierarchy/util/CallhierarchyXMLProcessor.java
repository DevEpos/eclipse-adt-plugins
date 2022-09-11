/**
 */
package com.devepos.adt.callhierarchy.model.callhierarchy.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.devepos.adt.callhierarchy.model.callhierarchy.ICallhierarchyPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CallhierarchyXMLProcessor extends XMLProcessor {

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public CallhierarchyXMLProcessor() {
    super(EPackage.Registry.INSTANCE);
    ICallhierarchyPackage.eINSTANCE.eClass();
  }

  /**
   * Register for "*" and "xml" file extensions the CallhierarchyResourceFactory factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations() {
    if (registrations == null) {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new CallhierarchyResourceFactory());
      registrations.put(STAR_EXTENSION, new CallhierarchyResourceFactory());
    }
    return registrations;
  }

} // CallhierarchyXMLProcessor
