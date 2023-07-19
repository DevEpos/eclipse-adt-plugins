package com.devepos.adt.saat.activation;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;

public interface ICdsActivationService {

  /**
   * Tests if CDS Post Activation capabilities are available in the given project
   *
   * @param project ABAP project instance
   * @return status of availability check
   */
  IStatus testCdsPostActivationAvailable(IProject project);

  /**
   * Runs post activation for a single CDS View or a list of CDS Views
   *
   * @param destinationId destination id of an ABAP project
   * @param ddlNames      list of DDL names
   */
  void postActivateCdsViews(String destinationId, List<String> ddlNames);
}
