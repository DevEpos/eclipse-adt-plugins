package com.devepos.adt.saat.ui.internal.cdsanalysis;

/**
 * Settings for Where-Used in CDS analysis
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IWhereUsedInCdsSettings {

  /**
   * @return {@code true} if only local associations shall be searched
   */
  boolean isLocalAssociationsOnly();

  /**
   * @return {@code true} if only released usages shall be searched
   */
  boolean isReleasedUsagesOnly();

  /**
   *
   * @return {@code true} if associations shall be searched
   */
  boolean isSearchAssociations();

  /**
   * @return {@code true} if the select from part shall be searched
   */
  boolean isSearchFromPart();

  /**
   * Sets whether to only search in local associations
   *
   * @param localAssociationsOnly {@code true} if only local associations shall be searched
   */
  void setLocalAssociationsOnly(boolean localAssociationsOnly);

  /**
   * Sets whether only released usages shall be searched
   *
   * @param releasedUsagesOnly {@code true} if only released usages shall be searched
   */
  void setReleasedUsagesOnly(boolean releasedUsagesOnly);

  /**
   * Sets whether to search associations
   *
   * @param searchAssociations {@code true} if associations shall be searched
   */
  void setSearchAssociation(boolean searchAssociations);

  /**
   * Sets whether to search the select from part
   *
   * @param searchFrom {@code true} if select from part shall be searched
   */
  void setSearchFromPart(boolean searchFrom);
}
