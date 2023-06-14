package com.devepos.adt.callhierarchy.backend;

import com.devepos.adt.callhierarchy.backend.internal.CallHierarchyService;

/**
 * Factory to access hierarchy services
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CallHierarchyServiceFactory {

  public static ICallHierarchyService getHierarchyService() {
    return new CallHierarchyService();
  }
}
