package com.devepos.adt.saat.cdsanalysis;

/**
 * Settings for CDS Top-Down Analysis
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface ICdsTopDownSettings {

  /**
   * @return {@code true} if associations should be loaded
   */
  boolean isLoadAssociations();

  /**
   * Sets whether associations shall be loaded
   *
   * @param loadAssociations {@code true} if associations shall be loaded
   */
  void setLoadAssociations(boolean loadAssociations);
}
