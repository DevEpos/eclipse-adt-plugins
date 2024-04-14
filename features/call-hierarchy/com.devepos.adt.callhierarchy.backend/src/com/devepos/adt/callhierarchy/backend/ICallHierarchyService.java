package com.devepos.adt.callhierarchy.backend;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.devepos.adt.callhierarchy.model.callhierarchy.IHierarchyResult;

/**
 * Service for ABAP Call hierarchy
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface ICallHierarchyService {

  /**
   * Retrieves call hierarchy for given URI
   *
   * @param destinationId valid destination of an ABAP project
   * @param monitor       progress monitor for call
   * @param queryParams   map of query parameters
   * @return the hierarchy result
   */
  IHierarchyResult getCallHierarchy(String destinationId, IProgressMonitor monitor,
      Map<String, Object> queryParams);

  /**
   * Tests if the feature 'ABAP Call Hierarchy' is available in the given project
   *
   * @param project a valid ABAP project
   * @return status of the test
   */
  IStatus testCallHierarchyFeatureAvailability(IProject project);
}
