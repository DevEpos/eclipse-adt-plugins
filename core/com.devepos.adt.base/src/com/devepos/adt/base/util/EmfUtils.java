package com.devepos.adt.base.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * Utilities for EMF handling
 */
public class EmfUtils {

  /**
   * Creates EMF resource options for loading/saving emf resources from/to an xml file
   */
  public static Map<String, Object> createEmfResourceOptions() {
    final HashMap<String, Object> options = new HashMap<>();
    options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
    options.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
    options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
        Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
    return options;
  }
}
