package com.devepos.adt.base.internal.nameditem;

import java.net.URI;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItem;
import com.devepos.adt.base.nameditem.INamedItemService;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.util.AdtUtil;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IRestResource;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * Service to retrieve named items
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class NamedItemService implements INamedItemService {

  private final String destination;
  private IAdtUriTemplateProvider uriTemplateProvider;

  public NamedItemService(final String destination,
      final IAdtUriTemplateProvider uriTemplateProvider) {
    this.destination = destination;
    this.uriTemplateProvider = uriTemplateProvider;
  }

  @Override
  public INamedItem[] getNamedItems(final INamedItemType type, final int maxResults) {
    return getNamedItems(type, maxResults, null, null, null);
  }

  @Override
  public INamedItem[] getNamedItems(final INamedItemType type, final int maxResults,
      final String name) {
    return getNamedItems(type, maxResults, name, null, null);
  }

  @Override
  public INamedItem[] getNamedItems(final INamedItemType type, final int maxResults,
      final String name, final String description) {
    return getNamedItems(type, maxResults, name, description, null);
  }

  @Override
  public INamedItem[] getNamedItems(final INamedItemType type, final int maxResults,
      final String name, final String description, final String data) {
    INamedItem[] namedItems = null;
    final IAdtUriTemplate template = uriTemplateProvider.getTemplateByDiscoveryTerm(type
        .getDiscoveryTerm());
    if (template != null) {
      fillTemplate(template, maxResults, name, description, data);
      final URI resourceUri = URI.create(template.expand());
      // create resource and fire request
      final IRestResource resource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(resourceUri, AdtSystemSessionFactory.createSystemSessionFactory()
              .createStatelessSession(destination));
      resource.addContentHandler(new NamedItemContentHandler());
      namedItems = resource.get(null, AdtUtil.getHeaders(), INamedItem[].class);
    }
    return namedItems;
  }

  /**
   * Fills the template URI with the given parameter values
   */
  private void fillTemplate(final IAdtUriTemplate template, final int maxResults, final String name,
      final String description, final String data) {
    if (maxResults > 0) {
      template.set("maxItemCount", maxResults);
    }
    if (name != null) {
      template.set("name", name);
    }
    if (description != null) {
      template.set("description", description);
    }
    if (data != null) {
      template.set("data", data);
    }
  }
}
