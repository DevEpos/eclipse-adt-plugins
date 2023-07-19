package com.devepos.adt.saat.navtargets;

import com.devepos.adt.saat.internal.navtargets.NavigationTargetService;

/**
 * Factory for creating instances of {@link INavigationTargetService}
 *
 * @author stockbal
 */
public class NavigationTargetServiceFactory {

  private static INavigationTargetService INSTANCE;

  public static INavigationTargetService getService() {
    if (INSTANCE == null) {
      INSTANCE = new NavigationTargetService();
    }
    return INSTANCE;
  }
}
