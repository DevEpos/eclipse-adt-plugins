package com.devepos.adt.cst.ui.internal;

/**
 * Constants to registered images by this plugin
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IImages {

  /**
   * Identifies the general image for the ABAP Code Search
   */
  String CODE_SEARCH = "IMG_CODE_SEARCH";

  /**
   * Identifies image for the status of a transport request (for proposals)
   */
  String STATUS = "IMG_STATUS";
  /**
   * Image to identify transport task
   */
  String TRANSPORT_TASK = "IMG_TRANSPORT_TASK";
  /**
   * Image to identify released transport task
   */
  String TRANSPORT_TASK_RELEASED = "IMG_TRANSPORT_TASK_RELEASED";
  /**
   * Image to identify transport request
   */
  String TRANSPORT_REQUEST = "IMG_TRANSPORT_REQUEST";
  /**
   * Image to identify a released transport request
   */
  String TRANSPORT_REQUEST_RELEASED = "IMG_TRANSPORT_REQUEST_RELEASED";
  /**
   * Overlay image to identify a task/request that was released
   */
  String OVR_TRANSPORT_RELEASED = "IMG_OVR_TRANSPORT_RELEASED";
}
