package com.devepos.adt.saat.analytics;

import org.eclipse.core.runtime.IProgressMonitor;

public interface IAnalysisForOfficeService {

  /**
   * Retrieves launcher file to open anlytical CDS query
   *
   * @param destinationId destination id of ABAP project
   * @param queryCdsView  name of a CDS view with analytical query annotations
   * @return
   */
  String getSapAoxLauncherContent(String destinationId, IProgressMonitor monitor,
      String queryCdsView);
}
