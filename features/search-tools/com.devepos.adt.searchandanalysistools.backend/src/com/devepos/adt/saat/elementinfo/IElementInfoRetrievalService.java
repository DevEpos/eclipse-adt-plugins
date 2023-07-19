package com.devepos.adt.saat.elementinfo;

import com.devepos.adt.base.ObjectType;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * Service for reading element information
 *
 * @author stockbal
 */
public interface IElementInfoRetrievalService {

  /**
   * Retrieves some basic information about the given object
   *
   * @param destinationId the destination id of the ABAP Project
   * @param objectName    the name of the object for which the element information
   *                      should be retrieved
   * @param objectType    the type of the object
   * @return the found ADT object ref or <code>null</code>
   */
  IAdtObjRef retrieveBasicElementInformation(final String destinationId, String objectName,
      ObjectType objectType);

  /**
   * Retrieves some basic information about the given object
   *
   * @param destinationId the destination id of the ABAP Project
   * @param uri           the URI of an ADT object
   * @return the found ADT object ref or <code>null</code>
   */
  IAdtObjRef retrieveBasicElementInformation(final String destinationId, String uri);

}