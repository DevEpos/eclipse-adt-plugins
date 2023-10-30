package com.devepos.adt.saat.internal.cdsanalysis;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.util.AdtUtil;
import com.devepos.adt.saat.cdsanalysis.CdsAnalysisFeature;
import com.devepos.adt.saat.cdsanalysis.ICdsAnalysisService;
import com.devepos.adt.saat.cdsanalysis.ICdsFieldAnalysisSettings;
import com.devepos.adt.saat.cdsanalysis.ICdsTopDownSettings;
import com.devepos.adt.saat.cdsanalysis.IWhereUsedInCdsAnalysisConstants;
import com.devepos.adt.saat.internal.Activator;
import com.devepos.adt.saat.internal.ddicaccess.EntityFieldInfoResultContentHandler;
import com.devepos.adt.saat.internal.messages.Messages;
import com.devepos.adt.saat.model.cdsanalysis.ICdsUsedEntitiesResult;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult;
import com.devepos.adt.saat.model.cdsanalysis.ITopDownAnalysisResult;
import com.devepos.adt.saat.model.cdsanalysis.IWhereUsedInCdsResult;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * Provides analysis services for CDS Views
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class CdsAnalysisService implements ICdsAnalysisService {

  @Override
  public IAdtUriTemplate getWhereUsedInCdsAnalysisTemplate(final String destinationId) {
    var discovery = new CdsAnalysisUriDiscovery(destinationId);
    if (!discovery.isResourceDiscoverySuccessful()) {
      return null;
    }
    return discovery
        .getCdsAnalysisTemplate(CdsAnalysisUriDiscovery.DISCOVERY_TEMPLATE_WHERE_USED_IN_FROM);
  }

  @Override
  public IWhereUsedInCdsResult getWhereUsedInResultsForEntity(final String destinationId,
      final String entityName, final boolean searchInFromPart, final boolean localAssociationsOnly,
      final boolean releasedEntitiesOnly, final boolean searchRecursively) {
    var discovery = new CdsAnalysisUriDiscovery(destinationId);

    var paramMap = new HashMap<String, Object>();
    paramMap.put("entityName", entityName);
    paramMap.put("sourceOrigin", searchInFromPart ? "from" : "assoc");
    if (localAssociationsOnly) {
      paramMap.put(IWhereUsedInCdsAnalysisConstants.QUERY_PARAM_LOCAL_DECLARED_ASSOCIATIONS_ONLY,
          "X");
    }
    if (searchRecursively) {
      paramMap.put(IWhereUsedInCdsAnalysisConstants.QUERY_PARAM_SEARCH_RECURSIVELY, "X");
    }
    if (releasedEntitiesOnly) {
      paramMap.put(IWhereUsedInCdsAnalysisConstants.QUERY_PARAM_RELEASED_ENTITIES_ONLY, "X");
    }

    var resourceUri = discovery.createWhereUsedInCdsAnalysisResourceUri(paramMap);
    if (resourceUri != null) {
      final var session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final var restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(resourceUri, session);
      restResource.addContentHandler(new WhereUsedInCdsAnalysisContentHandler());
      return restResource.get(new NullProgressMonitor(), IWhereUsedInCdsResult.class);
    }
    return null;
  }

  @Override
  public ITopDownAnalysisResult loadTopDownAnalysis(final String cdsView,
      final ICdsTopDownSettings settings, final String destinationId) {
    final Map<String, Object> parameters = new HashMap<>();
    if (settings != null && settings.isLoadAssociations()) {
      parameters.put("withAssociations", "X"); //$NON-NLS-1$ //$NON-NLS-2$
    }
    if (cdsView == null) {
      return null;
    }
    final var resourceUri = new CdsAnalysisUriDiscovery(destinationId)
        .createTopDownAnalysisResourceUri(cdsView, parameters);
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);
    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(resourceUri, session);
    restResource.addContentHandler(new CdsTopDownAnalysisContentHandler());

    return restResource.get(null, AdtUtil.getHeaders(), ITopDownAnalysisResult.class);
  }

  @Override
  public IEntityFieldInfoResult loadTopDownFieldAnalysis(final String cdsView, final String field,
      final String destinationId) {
    if (cdsView == null || field == null) {
      return null;
    }

    var discovery = new CdsAnalysisUriDiscovery(destinationId);

    return getFieldAnalysis(destinationId,
        discovery.createFieldTopDownCdsAnalysisResourceUri(cdsView, field));
  }

  @Override
  public ICdsUsedEntitiesResult loadUsedEntitiesAnalysis(final String cdsView,
      final String destinationId) {
    if (cdsView == null) {
      return null;
    }
    final var resourceUri = new CdsAnalysisUriDiscovery(destinationId)
        .createUsedEntitiesAnalysisResourceUri(cdsView, null);
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);
    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(resourceUri, session);
    restResource.addContentHandler(new CdsUsedEntitiesAnalysisContentHandler());

    try {
      return restResource.get(null, AdtUtil.getHeaders(), ICdsUsedEntitiesResult.class);
    } catch (final ResourceException exc) {
      exc.printStackTrace();
    }
    return null;
  }

  @Override
  public IEntityFieldInfoResult loadWhereUsedFieldAnalysis(final String objectName,
      final String field, final ICdsFieldAnalysisSettings settings, final String destinationId) {
    if (objectName == null || field == null) {
      return null;
    }
    final var discovery = new CdsAnalysisUriDiscovery(destinationId);

    boolean isSearchCalcFields = false;
    boolean isSearchDbViews = false;
    if (settings != null) {
      isSearchCalcFields = settings.isSearchInCalcFields();
      isSearchDbViews = settings.isSearchInDatabaseViews();
    }
    final URI resourceUri = discovery.createFieldWhereUsedAnalysisResourceUri(objectName, field,
        isSearchCalcFields, isSearchDbViews);

    return getFieldAnalysis(destinationId, resourceUri);
  }

  @Override
  public IStatus testCdsAnalysisFeatureAvailability(final CdsAnalysisFeature feature,
      final IProject project) {
    final var destinationId = DestinationUtil.getDestinationId(project);
    return testCdsAnalysisFeatureAvailable(destinationId, project.getName(), feature);
  }

  @Override
  public IStatus testCdsAnalysisFeatureAvailability(final CdsAnalysisFeature feature,
      final String destinationId) {
    return testCdsAnalysisFeatureAvailable(destinationId, destinationId, feature);
  }

  /*
   * Retrieves the field analysis result with GET
   */
  private IEntityFieldInfoResult getFieldAnalysis(final String destinationId,
      final URI resourceUri) {

    if (resourceUri == null) {
      return null;
    }
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);
    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(resourceUri, session);
    restResource.addContentHandler(new EntityFieldInfoResultContentHandler());

    try {
      return restResource.get(null, IEntityFieldInfoResult.class);
    } catch (final ResourceException exc) {
      exc.printStackTrace();
    }
    return null;
  }

  private IStatus testCdsAnalysisFeatureAvailable(final String destinationId,
      final String projectName, final CdsAnalysisFeature feature) {
    var discovery = new CdsAnalysisUriDiscovery(destinationId);

    if (!discovery.isResourceDiscoverySuccessful()) {
      return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
          NLS.bind(Messages.FeatureStatus_CdsAnalysisFeatureNotAvailable_xmsg, projectName));
    }

    boolean isFeatureAvailable = true;

    if (feature == CdsAnalysisFeature.GENERAL) {
      isFeatureAvailable = discovery.isCdsFeatureAvailable(CdsAnalysisFeature.GENERAL);
    } else if (feature == CdsAnalysisFeature.FIELD_ANALYSIS) {
      if (!discovery.isCdsFeatureAvailable(CdsAnalysisFeature.FIELD_ANALYSIS_TOP_DOWN)
          && !discovery.isCdsFeatureAvailable(CdsAnalysisFeature.FIELD_ANALYSIS_WHERE_USED)) {
        isFeatureAvailable = false;
      }

    } else if (feature == CdsAnalysisFeature.WHERE_USED) {
      if (!discovery.isCdsFeatureAvailable(CdsAnalysisFeature.WHERE_USED_IN_ASSOC)
          && !discovery.isCdsFeatureAvailable(CdsAnalysisFeature.WHERE_USED_IN_FROM)) {
        isFeatureAvailable = false;

      }
    } else if (!discovery.isCdsFeatureAvailable(feature)) {
      isFeatureAvailable = false;
    }

    return isFeatureAvailable ? Status.OK_STATUS
        : new Status(IStatus.ERROR, Activator.PLUGIN_ID,
            NLS.bind(Messages.FeatureStatus_GeneralFeatureNotAvailable_xmsg, feature.getName(),
                projectName));
  }
}
