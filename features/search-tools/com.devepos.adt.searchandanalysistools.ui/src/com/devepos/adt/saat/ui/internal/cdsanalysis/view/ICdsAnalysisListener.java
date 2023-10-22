package com.devepos.adt.saat.ui.internal.cdsanalysis.view;

/**
 * A listener to the changes of a set of CDS analyses
 *
 * @author stockbal
 */
public interface ICdsAnalysisListener {

  /**
   * Notifies listener that analysis was removed
   *
   * @param analysis the removed analysis
   */
  void analysisRemoved(CdsAnalysis analysis);

  /**
   * Notifies listener that an analysis was added
   * 
   * @param analysis the new analysis
   */
  void analysisAdded(CdsAnalysis analysis);
}
