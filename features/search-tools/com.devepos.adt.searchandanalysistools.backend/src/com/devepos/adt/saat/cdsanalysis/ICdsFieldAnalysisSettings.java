package com.devepos.adt.saat.cdsanalysis;

/**
 * Settings for CDS Field Analysis
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface ICdsFieldAnalysisSettings {

  /**
   * @return {@code true} if calculated fields will be considered
   */
  boolean isSearchInCalcFields();

  /**
   * @return {@code true} if database views are searched during bottom up
   */
  boolean isSearchInDatabaseViews();

  /**
   * @return {@code true} if the analysis direction is top down,
   *         {@code false} if it is bottom up
   */
  boolean isTopDown();

  /**
   * Sets whether calculated fields should be considered during the search or not
   *
   * @param searchInCalcFields if {@code true} calculated fields will be considered
   */
  void setSearchInCalcFields(boolean searchInCalcFields);

  /**
   * Sets whether db views should be searched in the bottom up analysis
   *
   * @param searchInDbViews if {@code true} database views will be searched
   */
  void setSearchInDatabaseViews(boolean searchInDbViews);

  /**
   * Sets whether the anlysis direction is top down or bottom up
   *
   * @param topDown if {@code true} the analysis direction will be top down,
   *                otherwise bottom up
   */
  void setTopDown(boolean topDown);
}
