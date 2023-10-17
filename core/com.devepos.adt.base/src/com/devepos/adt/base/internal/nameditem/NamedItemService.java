package com.devepos.adt.base.internal.nameditem;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.nameditem.INamedItem;
import com.devepos.adt.base.nameditem.INamedItemService;
import com.devepos.adt.base.nameditem.INamedItemType;
import com.devepos.adt.base.util.AdtUtil;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * Service to retrieve named items
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class NamedItemService implements INamedItemService {

  private final String destination;
  private final IAdtUriTemplateProvider uriTemplateProvider;

  public NamedItemService(final String destination,
      final IAdtUriTemplateProvider uriTemplateProvider) {
    this.destination = destination;
    this.uriTemplateProvider = uriTemplateProvider;
  }

  @Override
  public List<INamedItem> getNamedItems(final INamedItemType type, final int maxResults) {
    return getNamedItems(type, maxResults, null, null, null, null);
  }

  @Override
  public List<INamedItem> getNamedItems(final INamedItemType type, final int maxResults,
      final String name) {
    return getNamedItems(type, maxResults, name, null, null, null);
  }

  @Override
  public List<INamedItem> getNamedItems(final INamedItemType type, final int maxResults,
      final String name, final String description) {
    return getNamedItems(type, maxResults, name, description, null, null);
  }

  @Override
  public List<INamedItem> getNamedItems(final INamedItemType type, final int maxResults,
      final String name, final String description, final String data, final String initialFilter) {

    List<INamedItem> namedItems = null;

    final IAdtUriTemplate template = uriTemplateProvider.getTemplateByDiscoveryTerm(type
        .getDiscoveryTerm());
    if (template != null) {
      if (type.isBuffered()) {
        namedItems = getCachedNamedItems(type, maxResults, initialFilter, template);
      } else {
        namedItems = getFilteredItemsFromBackend(maxResults, name, description, data, template);
      }
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

  private List<INamedItem> getAllItemsFromBackend(final INamedItemType type, final int maxResults,
      final IAdtUriTemplate template) {
    return getFilteredItemsFromBackend(maxResults, null, null, null, template);
  }

  private List<INamedItem> getCachedNamedItems(final INamedItemType type, final int maxResults,
      final String nameFilter, final IAdtUriTemplate template) {
    List<INamedItem> namedItems;
    var cache = NamedItemCache.getInstance();

    if (!StringUtil.isEmpty(nameFilter)) {
      template.set("name", nameFilter);
    }
    var uri = template.expand();
    synchronized (cache) {
      if (cache.containsKey(destination, uri)) {
        namedItems = cache.get(destination, uri);
      } else {
        namedItems = getAllItemsFromBackend(type, maxResults, template);
        if (namedItems != null) {
          cache.insert(destination, uri, namedItems);
        }
      }
    }
    return namedItems;
  }

  private List<INamedItem> getFilteredItemsFromBackend(final int maxResults, final String name,
      final String description, final String data, final IAdtUriTemplate template) {

    fillTemplate(template, maxResults, name, description, data);

    final var resourceUri = URI.create(template.expand());
    final var resource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(resourceUri, AdtSystemSessionFactory.createSystemSessionFactory()
            .createStatelessSession(destination));
    resource.addContentHandler(new NamedItemContentHandler());
    var namedItems = resource.get(null, AdtUtil.getHeaders(), INamedItem[].class);

    return Arrays.asList(namedItems);
  }
}
