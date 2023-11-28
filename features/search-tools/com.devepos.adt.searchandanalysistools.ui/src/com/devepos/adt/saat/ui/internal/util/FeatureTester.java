package com.devepos.adt.saat.ui.internal.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.util.IUriDiscovery;
import com.devepos.adt.saat.cdsanalysis.CdsAnalysisFeature;
import com.devepos.adt.saat.cdsanalysis.CdsAnalysisServiceFactory;
import com.devepos.adt.saat.dbbrowserintegration.DbBrowserIntegrationUriDiscovery;
import com.devepos.adt.saat.navtargets.NavigationTargetServiceFactory;
import com.devepos.adt.saat.search.ObjectSearchServiceFactory;
import com.sap.adt.tools.core.project.IAbapProject;

public final class FeatureTester {

  private FeatureTester() {
  }

  /**
   * Checks if the CDS Analysis feature is available for the given project
   *
   * @param project ABAP Project
   * @return <code>true</code> if feature is available
   */
  public static boolean isCdsAnalysisAvailable(final IProject project) {
    return CdsAnalysisServiceFactory.getCdsAnalysisService()
        .testCdsAnalysisFeatureAvailability(CdsAnalysisFeature.GENERAL, project)
        .isOK();
  }

  /**
   * Checks if the CDS Top Down analysis is available in the given project
   *
   * @param project ABAP Project
   * @return <code>true</code> if feature is available
   */
  public static boolean isCdsTopDownAnalysisAvailable(final IProject project) {
    return CdsAnalysisServiceFactory.getCdsAnalysisService()
        .testCdsAnalysisFeatureAvailability(CdsAnalysisFeature.TOP_DOWN, project)
        .isOK();
  }

  /**
   * Checks if the CDS Used Entities Analysis feature is available for the given
   * project
   *
   * @param project ABAP Project
   * @return <code>true</code> if feature is available
   */
  public static boolean isCdsUsedEntitiesAnalysisAvailable(final IProject project) {
    return CdsAnalysisServiceFactory.getCdsAnalysisService()
        .testCdsAnalysisFeatureAvailability(CdsAnalysisFeature.USED_ENTITIES, project)
        .isOK();
  }

  public static boolean isFieldAnalysisAvailable(final IProject project) {
    return CdsAnalysisServiceFactory.getCdsAnalysisService()
        .testCdsAnalysisFeatureAvailability(CdsAnalysisFeature.FIELD_ANALYSIS, project)
        .isOK();
  }

  /**
   * Checks if navigation targets for an ADT object can be determined
   *
   * @param project ABAP Project
   * @return <code>true</code> if feature is available
   */
  public static boolean isNavigationTargetsFeatureAvailable(final IProject project) {
    return NavigationTargetServiceFactory.getService()
        .testNavigationTargetsAvailable(project)
        .isOK();
  }

  /**
   * Checks if the object search is available in the given project
   *
   * @param project ABAP Project
   * @return <code>true</code> if feature is available
   */
  public static boolean isObjectSearchAvailable(final IProject project) {
    return ObjectSearchServiceFactory.getSearchService()
        .testObjectSearchFeatureAvailability(project)
        .isOK();
  }

  /**
   * Returns <code>true</code> if the DB Browser Application is available in the
   * given project
   *
   * @param project the project where the availability of the DB Browser should be
   *                checked
   * @return <code>true</code> if the DB Browser Application is available in the
   *         given project
   */
  public static boolean isSapGuiDbBrowserAvailable(final IProject project) {
    final IAbapProject abapProject = project.getAdapter(IAbapProject.class);
    if (abapProject == null) {
      return false;
    }

    final IUriDiscovery uriDiscovery = new DbBrowserIntegrationUriDiscovery(
        abapProject.getDestinationId());
    return uriDiscovery.isResourceDiscoverySuccessful();
  }

  /**
   * Returns <code>true</code> if the DB Browser integration feature is availabe
   * in the projects of the given ADT Objects
   *
   * @param adtObjects a list of ADT Objects
   * @return <code>true</code> if the DB Browser integration feature is availabe
   *         in the projects of the given ADT Objects
   */
  public static boolean isSapGuiDbBrowserAvailable(final List<IAdtObject> adtObjects) {
    if (adtObjects == null || adtObjects.isEmpty()) {
      return false;
    }
    if (adtObjects.size() == 1) {
      return isSapGuiDbBrowserAvailable(adtObjects.get(0).getProject());
    }
    final Set<IProject> uniqueProjects = new HashSet<>();
    for (final IAdtObject adtObject : adtObjects) {
      uniqueProjects.add(adtObject.getProject());
    }

    for (final IProject project : uniqueProjects) {
      if (!isSapGuiDbBrowserAvailable(project)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isWhereUsedInCdsAnalysisAvailable(final IProject project) {
    return CdsAnalysisServiceFactory.getCdsAnalysisService()
        .testCdsAnalysisFeatureAvailability(CdsAnalysisFeature.WHERE_USED, project)
        .isOK();
  }

}
