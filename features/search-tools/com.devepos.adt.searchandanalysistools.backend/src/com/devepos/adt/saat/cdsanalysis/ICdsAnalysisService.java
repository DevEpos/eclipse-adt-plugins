package com.devepos.adt.saat.cdsanalysis;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchResult;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * Provides analysis services for CDS
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface ICdsAnalysisService {
  /**
   * Returns URI query configuration
   *
   * @param destinationId destination id of an ABAP project
   */
  IAdtUriTemplate getWhereUsedInCdsAnalysisTemplate(String destinationId);

  IObjectSearchResult getWhereUsedInResultsForEntity(String destinationId, String entityName,
      boolean searchInFromPart, boolean localAssociationsOnly, boolean releasedEntitiesOnly);

  /**
   * Loads SELECT Part of a single CDS View
   *
   * @param cdsView       the name of the CDS view for which the SELECT part
   *                      should be loaded
   * @param settings      settings object to configure the top down analysis
   * @param destinationId the destination of ID of the ABAP project
   * @return
   */
  ITopDownAnalysisResult loadTopDownAnalysis(String cdsView, ICdsTopDownSettings settings,
      String destinationId);

  /**
   * Loads the complete hierarchy of the given CDS View field
   *
   * @param cdsView       name of the owning CDS view of <code>field</code>
   * @param field         name of a field in the given CDS view
   * @param destinationId the destination id of an ABAP project
   * @return the found field hierarchy information
   */
  IEntityFieldInfoResult loadTopDownFieldAnalysis(String cdsView, String field,
      String destinationId);

  /**
   * Loads Used entities in the dependency tree of the given CDS view
   *
   * @param cdsView       the name of the CDS view for which the Used Entities
   *                      should be analyzed
   * @param destinationId the destination of ID of the ABAP project
   * @return
   */
  ICdsUsedEntitiesResult loadUsedEntitiesAnalysis(String cdsView, String destinationId);

  /**
   * Loads the first level of the Where-Used list of the given field
   *
   * @param objectName       name of the owning Database object of
   *                         <code>field</code>
   * @param field            name of a field in the given CDS view
   * @param searchCalcFields if <code>true</code> calculation fields are also
   *                         searched for usages of the given field
   * @param searchDbViews    if <code>true</code> Database Views are also searched
   *                         for usages of the given field
   * @param destinationId    the destination id of an ABAP project
   * @return the found field hierarchy information
   */
  IEntityFieldInfoResult loadWhereUsedFieldAnalysis(final String objectName, final String field,
      ICdsFieldAnalysisSettings settings, final String destinationId);

  /**
   * Tests if the passed CDS Analysis feature is available in the given project
   *
   * @param feature identifier for CDS Analysis feature
   * @param project ABAP project reference
   * @return {@link Status#OK_STATUS} if feature is available
   */
  IStatus testCdsAnalysisFeatureAvailability(CdsAnalysisFeature feature, IProject project);
}
