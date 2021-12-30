package com.devepos.adt.base.nameditem;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.internal.nameditem.NamedItemService;

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
}
