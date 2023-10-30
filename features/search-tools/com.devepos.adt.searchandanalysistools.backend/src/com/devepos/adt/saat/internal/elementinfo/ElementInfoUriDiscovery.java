package com.devepos.adt.saat.internal.elementinfo;

import java.net.URI;
import java.util.Map;

import com.devepos.adt.base.ObjectType;
import com.devepos.adt.saat.internal.SearchToolsUriDiscovery;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * URI discovery for element info
 *
 * @author stockbal
 */
public class ElementInfoUriDiscovery extends SearchToolsUriDiscovery {
  private static final String ELEMENT_INFO_SCHEME_PART = "/elementinfo"; //$NON-NLS-1$
  private static final String DISCOVERY_RELATION_ELEMENT_INFO = RELATIONS_SCHEME_BASE_V2
      + ELEMENT_INFO_SCHEME_PART;
  private static final String DISCOVERY_RELATION_ELEMENT_INFO_BY_URI = DISCOVERY_RELATION_ELEMENT_INFO +
      "/byUri";
  private static final String DISCOVERY_TERM_ELEMENT_INFO = "elementinfo";

  /**
   * Creates new URI discovery for the element information service
   *
   * @param destination
   */
  public ElementInfoUriDiscovery(final String destination) {
    super(destination, SCHEME_URL_BASE_V2 + ELEMENT_INFO_SCHEME_PART);
  }

  /**
   * Creates a valid REST resource URI for the given object URI
   *
   * @param objectUri the URI of an ADT object
   * @param params    map of additional query parameters
   * @return REST resource URI
   */
  public URI createElementInfoResourceUri(final String objectUri,
      final Map<String, Object> params) {
    final IAdtUriTemplate template = getElementInfoByUriTemplate();
    URI uri = null;
    if (template != null) {
      if (template.containsVariable("objectUri")) {
        template.set("objectUri", objectUri);
      }
      fillTemplateWithParams(template, params);
      uri = URI.create(template.expand());
    }
    return uri;
  }

  /**
   * Creates a valid REST resource URI for the given name and object type
   *
   * @param name       the name of the object for which element infos should be
   *                   retrieved
   * @param objectType the type of the object
   * @param params     map of additional query parameters
   * @return REST resource URI
   */
  public URI createElementInfoResourceUri(final String name, final ObjectType objectType,
      final Map<String, Object> params) {
    final IAdtUriTemplate template = getElementInfoTemplate();
    URI uri = null;
    if (template != null) {
      if (template.containsVariable("objectName")) {
        template.set("objectName", name);
      }
      if (template.containsVariable("objectType")) {
        template.set("objectType", objectType.getId());
      }
      fillTemplateWithParams(template, params);
      uri = URI.create(template.expand());
    }
    return uri;
  }

  /**
   * @return ADT URI template for the element information service
   */
  public IAdtUriTemplate getElementInfoByUriTemplate() {
    return getTemplate(DISCOVERY_TERM_ELEMENT_INFO, DISCOVERY_RELATION_ELEMENT_INFO_BY_URI);
  }

  /**
   * @return ADT URI template for the element information service
   */
  public IAdtUriTemplate getElementInfoTemplate() {
    return getTemplate(DISCOVERY_TERM_ELEMENT_INFO, DISCOVERY_RELATION_ELEMENT_INFO);
  }

  /**
   * @return Retrieves Resource URI for the element information service
   */
  public URI getElementInfoUri() {
    return getUriFromCollectionMember(DISCOVERY_TERM_ELEMENT_INFO);
  }
}
