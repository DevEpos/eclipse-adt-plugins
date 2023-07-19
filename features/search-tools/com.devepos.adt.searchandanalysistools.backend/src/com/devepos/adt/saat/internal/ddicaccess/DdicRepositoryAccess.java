package com.devepos.adt.saat.internal.ddicaccess;

import java.util.Arrays;
import java.util.List;

import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.saat.ddicaccess.IDdicRepositoryAccess;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfo;
import com.devepos.adt.saat.model.cdsanalysis.IEntityFieldInfoResult;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Implementation for DDIC Repository Access
 *
 * @author stockbal
 */
public class DdicRepositoryAccess implements IDdicRepositoryAccess {
  @Override
  public List<IEntityFieldInfo> getColumnInformation(final String destinationId,
      final String objectUri) {

    return accessDdicInformation(destinationId, "getColumns", //$NON-NLS-1$
        objectUri, null, Arrays.asList("noClientCols:X")); //$NON-NLS-1$
  }

  @Override
  public IAdtObjectReference getColumnUri(final String destinationId, final String objectName,
      final String column) {
    final var ddicInfo = accessDdicInformation(destinationId, "getUriForPaths", //$NON-NLS-1$
        null, Arrays.asList(String.format("%s.%s", objectName, column)), null); //$NON-NLS-1$
    if (ddicInfo != null && !ddicInfo.isEmpty()) {
      var firstInfo = ddicInfo.get(0);

      return AdtObjectReferenceModelFactory.createReference(destinationId, firstInfo.getFieldName(),
          firstInfo.getType(), firstInfo.getUri());
    }
    return null;
  }

  /*
   * Retrieves DDIC information
   */
  private List<IEntityFieldInfo> accessDdicInformation(final String destinationId,
      final String accessMode, final String objectUri, final List<String> paths,
      final List<String> filters) {

    final var resourceUri = new DdicRepositoryAccessUriDiscovery(destinationId)
        .createDdicAccessResource(accessMode, objectUri, paths, filters);

    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);
    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(resourceUri, session);
    restResource.addContentHandler(new EntityFieldInfoResultContentHandler());

    try {
      var fieldInfos = restResource.get(null, IEntityFieldInfoResult.class);
      return fieldInfos != null ? fieldInfos.getFieldInfos() : null;
    } catch (final ResourceException exc) {
      exc.printStackTrace();
    }
    return null;
  }

}
