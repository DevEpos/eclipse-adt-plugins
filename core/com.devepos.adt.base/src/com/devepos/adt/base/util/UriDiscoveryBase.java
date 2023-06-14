package com.devepos.adt.base.util;

import java.net.URI;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;

import com.sap.adt.communication.resources.ResourceForbiddenException;
import com.sap.adt.compatibility.discovery.AdtDiscoveryFactory;
import com.sap.adt.compatibility.discovery.IAdtDiscovery;
import com.sap.adt.compatibility.discovery.IAdtDiscoveryCollectionMember;
import com.sap.adt.compatibility.model.templatelink.IAdtTemplateLink;
import com.sap.adt.compatibility.uritemplate.AdtUriTemplateFactory;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * Base for URI discovery
 *
 * @author stockbal
 */
public abstract class UriDiscoveryBase implements IUriDiscovery {

  private static final String NAMED_ITEM_TEMPLATE = "{?maxItemCount,name,description,data}";
  private final String discoveryScheme;
  protected final IAdtDiscovery discovery;

  protected UriDiscoveryBase(final String destinationId, final String discoveryPath,
      final String discoveryScheme) {
    this.discoveryScheme = discoveryScheme;
    discovery = AdtDiscoveryFactory.createDiscovery(destinationId, URI.create(discoveryPath));
  }

  /**
   * Creates URI from the given URI template
   *
   * @param template URI template
   * @param paramMap map of template parameters
   * @return expanded URI from template
   */
  public URI createUriFromTemplate(final IAdtUriTemplate template,
      final Map<String, Object> paramMap) {
    URI uri = null;
    if (template != null) {
      fillTemplateWithParams(template, paramMap);
      uri = URI.create(template.expand());
    }
    return uri;
  }

  @Override
  public IAdtUriTemplate getNamedItemTemplate(final String discoveryTerm) {
    final URI uri = getUriFromCollectionMember(discoveryTerm);
    return uri != null ? getNamedItemTemplateForUri(uri) : null;
  }

  @Override
  public boolean isResourceDiscoverySuccessful() {
    return discovery != null && discovery.getStatus().isOK();
  }

  /**
   * Fills the template with parameters in provided {@link Map}
   *
   * @param template the ADT URI template
   * @param params   a Map of parameters for the template
   */
  protected void fillTemplateWithParams(final IAdtUriTemplate template,
      final Map<String, Object> params) {
    if (params == null || template == null) {
      return;
    }

    for (final String key : params.keySet()) {
      if (template.containsVariable(key)) {
        fillTemplateValue(template, key, params.get(key));
      }
    }
  }

  protected IAdtUriTemplate getNamedItemTemplateForUri(final URI uri) {
    IAdtUriTemplate uriTemplate = null;
    if (uri != null) {
      uriTemplate = AdtUriTemplateFactory.createUriTemplate(uri.toString() + NAMED_ITEM_TEMPLATE);
    }
    return uriTemplate;
  }

  /**
   * Retrieves an {@link IAdtUriTemplate} for the given <b>scheme</b>, <b>term</b>
   * and <b>relation</b>
   *
   * @param term     the term used to get the collection member
   * @param relation the URL relation to get the correct template link
   * @return
   */
  protected IAdtUriTemplate getTemplate(final String term, final String relation) {
    IAdtUriTemplate template = null;
    final IAdtDiscoveryCollectionMember collectionMember = discovery.getCollectionMember(
        discoveryScheme, term, new NullProgressMonitor());
    if (collectionMember != null) {
      final IAdtTemplateLink templateLink = collectionMember.getTemplateLink(relation);
      if (templateLink != null) {
        template = templateLink.getUriTemplate();
      }
    }
    return template;
  }

  /**
   * Retrieves URI of a collection member for the given term
   *
   * @param discoveryTerm the term to be used to find the collection member
   * @return
   */
  protected URI getUriFromCollectionMember(final String discoveryTerm) {
    URI uri = null;
    try {
      final IAdtDiscoveryCollectionMember collectionMember = discovery.getCollectionMember(
          discoveryScheme, discoveryTerm, null);
      if (collectionMember != null) {
        uri = collectionMember.getUri();
      }
    } catch (final ResourceForbiddenException e) {
      e.printStackTrace();
    }
    return uri;
  }

  private void fillTemplateValue(final IAdtUriTemplate template, final String paramater,
      final Object value) {
    if (value == null) {
      return;
    }
    template.set(paramater, value);
  }
}