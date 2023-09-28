/**
 */
package com.devepos.adt.searchfavorites.model.searchfavorites.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SearchFavoritesXMLProcessor extends XMLProcessor {

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public SearchFavoritesXMLProcessor() {
    super(EPackage.Registry.INSTANCE);
    ISearchFavoritesPackage.eINSTANCE.eClass();
  }

  /**
   * Register for "*" and "xml" file extensions the SearchFavoritesResourceFactory factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations() {
    if (registrations == null) {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new SearchFavoritesResourceFactory());
      registrations.put(STAR_EXTENSION, new SearchFavoritesResourceFactory());
    }
    return registrations;
  }

} // SearchFavoritesXMLProcessor
