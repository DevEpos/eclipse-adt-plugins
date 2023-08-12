package com.devepos.adt.base.destinations;

/**
 * Provides information about a destination to an ABAP project
 *
 * @author stockbal
 */
public interface IDestinationProvider {
  /**
   * Returns the destination to an ABAP project
   *
   * @return
   */
  String getDestinationId();

  /**
   * Returns the system part from the destination
   *
   * @return
   */
  String getSystemId();

  /**
   * Sets a new destination Id
   *
   * @param destinationId
   */
  void setDestinationId(String destinationId);
}
