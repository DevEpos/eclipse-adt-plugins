package com.devepos.adt.base.nameditem;

import java.util.function.Function;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.internal.nameditem.NamedItemService;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.util.IUriDiscovery;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * Factory to create instances of the {@link INamedItemService}
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class NamedItemServiceFactory {

  /**
   * Creates new template provider for named items
   *
   * @param projectProvider     ABAP project provider
   * @param uriDiscoveryCreator supplier for URI discovery
   */
  public static IAdtUriTemplateProvider createNamedItemUriTemplateProvider(
      final IAbapProjectProvider projectProvider,
      final Function<String, IUriDiscovery> uriDiscoveryCreator) {
    return new NamedItemUriTemplateProvider(projectProvider, uriDiscoveryCreator);
  }

  /**
   * Creates new template provider for named items
   * 
   * @param project             ABAP project
   * @param uriDiscoveryCreator supplier for URI discovery
   */
  public static IAdtUriTemplateProvider createNamedItemUriTemplateProvider(IProject project,
      final Function<String, IUriDiscovery> uriDiscoveryCreator) {
    final var uriDiscovery = uriDiscoveryCreator.apply(DestinationUtil.getDestinationId(project));
    return new IAdtUriTemplateProvider() {

      @Override
      public IAdtUriTemplate getTemplateByDiscoveryTerm(String discoveryTerm) {
        return uriDiscovery.getNamedItemTemplate(discoveryTerm);
      }
    };
  }

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
}
