package com.devepos.adt.base.system;

import java.util.List;

import com.devepos.adt.base.model.adtbase.IUser;

/**
 * Access to global ABAP system resources, like Users
 *
 * @author stockbal
 *
 */
public interface ISystemService {

  /**
   * Retrieves list of users
   *
   * @param destinationId destination id for ABAP project
   * @return list of users
   */
  List<IUser> getUsers(String destinationId);
}
