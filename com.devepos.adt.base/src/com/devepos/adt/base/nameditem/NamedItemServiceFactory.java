package com.devepos.adt.base.nameditem;

import java.util.function.Function;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.internal.nameditem.NamedItemService;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.util.IUriDiscovery;

/**
 * Factory to create instances of the {@link INamedItemService}
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class NamedItemServiceFactory {

  /**
   * Creates instance of the {@link INamedItemService}
   *
   * @param destination         ABAP project destination
   * @param uriTemplateProvider provider for URI templates of
   * @return
   */
  public static INamedItemService createService(final String destination,
      final IAdtUriTemplateProvider uriTemplateProvider) {
    return new NamedItemService(destination, uriTemplateProvider);
  }

  /**
   * Creates new template provider for named items
   * 
   * @param projectProvider     ABAP project provider
   * @param uriDiscoveryCreator supplier for URI discovery
   * @return
   */
  public static IAdtUriTemplateProvider createNamedItemUriTemplateProvider(
      final IAbapProjectProvider projectProvider,
      Function<String, IUriDiscovery> uriDiscoveryCreator) {
    return new NamedItemUriTemplateProvider(projectProvider, uriDiscoveryCreator);
  }
}
