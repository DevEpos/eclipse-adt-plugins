package com.devepos.adt.base.system;

import com.devepos.adt.base.internal.system.SystemService;

/**
 * Factory for retrieving instances of the {@link ISystemService}
 *
 * @author stockbal
 *
 */
public class SystemServiceFactory {

  /**
   * Creates new instance of {@link ISystemService}
   *
   * @return new instance of {@link ISystemService}
   */
  public static ISystemService createSystemService() {
    return new SystemService();
  }
}
