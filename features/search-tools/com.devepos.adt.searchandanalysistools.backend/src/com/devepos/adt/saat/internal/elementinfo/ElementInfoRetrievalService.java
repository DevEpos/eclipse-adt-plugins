package com.devepos.adt.saat.internal.elementinfo;

import java.net.URI;

import com.devepos.adt.base.ObjectType;
import com.devepos.adt.base.content.AdtObjRefContentHandler;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.saat.elementinfo.IElementInfoRetrievalService;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

/**
 * Service implementation for element information retrieval
 *
 * @author stockbal
 */
public class ElementInfoRetrievalService implements IElementInfoRetrievalService {

  @Override
  public IAdtObjRef retrieveBasicElementInformation(final String destinationId,
      final String objectName, final ObjectType objectType) {
    if (destinationId == null || objectType == null) {
      return null;
    }
    final var uriDiscovery = new ElementInfoUriDiscovery(destinationId);
    if (!uriDiscovery.isResourceDiscoverySuccessful()) {
      return null;
    }

    final URI resourceUri = uriDiscovery.createElementInfoResourceUri(objectName, objectType, null);

    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);
    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(resourceUri, session);
    restResource.addContentHandler(new AdtObjRefContentHandler());

    return restResource.get(null, IAdtObjRef.class);
  }

  @Override
  public IAdtObjRef retrieveBasicElementInformation(final String destinationId, final String uri) {
    if (destinationId == null || uri == null) {
      return null;
    }
    final var uriDiscovery = new ElementInfoUriDiscovery(destinationId);

    final URI resourceUri = uriDiscovery.createElementInfoResourceUri(uri, null);

    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);
    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(resourceUri, session);
    restResource.addContentHandler(new AdtObjRefContentHandler());

    return restResource.get(null, IAdtObjRef.class);
  }

}
