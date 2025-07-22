package com.devepos.adt.cst.internal.search.client;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.search.client.AdtPackage;
import com.sap.adt.ris.model.facets.IFacetsFactory;
import com.sap.adt.ris.search.objectproperties.AdtRisVfsObjectPropertiesServiceFactory;
import com.sap.adt.tools.core.model.util.ServiceNotAvailableException;

@SuppressWarnings("restriction")
public class PackageUtils {

  public static List<AdtPackage> getPackageHierarchy(String uri, IProgressMonitor m,
      String destination) {
    try {
      var objectPropertiesService = AdtRisVfsObjectPropertiesServiceFactory
          .createVfsObjectPropertiesService(destination);
      var packageFacet = IFacetsFactory.eINSTANCE.createFacet();
      packageFacet.setKey("package");
      var objProperties = objectPropertiesService.readObjectProperties(URI.create(uri),
          List.of(packageFacet), m);
      return objProperties.getObjectPropertiesForFacet("package")
          .stream()
          .map(p -> new AdtPackage(p.uri.toString(), p.name, p.displayName, 0, null))
          .collect(Collectors.toList());

    } catch (ServiceNotAvailableException e) {
      e.printStackTrace();
    }
    return null;
  }
}
