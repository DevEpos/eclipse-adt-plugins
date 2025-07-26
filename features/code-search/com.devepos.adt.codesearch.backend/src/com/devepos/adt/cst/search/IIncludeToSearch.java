package com.devepos.adt.cst.search;

/**
 * Source include that shall be considered during a ABAP Code search
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IIncludeToSearch {
  /**
   * Returns the name of the include for the search API
   *
   * @return the name of the include for the search API
   */
  String getApiName();

  /**
   * Returns the bit associated with this include
   *
   * @return the bit associated with this include
   */
  int getBit();

  /**
   * Returns the label of the include to be used in the UI
   *
   * @return the label of the include to be used in the UI
   */
  String getLabel();

  /**
   * Returns the name of the include as specified in the ADT class API
   * 
   */
  String getAdtApiInclName();

  /**
   * Returns label of an include without the mnemonic for the UI
   */
  String getLabelWoMnemonic();
}