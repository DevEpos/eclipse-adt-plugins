package com.devepos.adt.saat.search;

/**
 * Provides access to config variables that have been set in eclipse.ini
 * 
 * @author stockbal
 */
public class ObjectSearchSystemConfig {

  /**
   * {@code true} if caching for the object search config is disabled
   */
  public static final boolean IS_OBJ_SEARCH_CONFIG_CACHING_DISABLED = Boolean.parseBoolean(System
      .getProperty("com.devepos.adt.objectsearch.configCacheDisabled", Boolean.FALSE.toString()));
}
