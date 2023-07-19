package com.devepos.adt.saat.ddicaccess;

import com.devepos.adt.saat.internal.ddicaccess.DdicRepositoryAccess;

/**
 * Factory for DDIC Repository Access
 *
 * @author stockbal
 */
public class DdicRepositoryAccessFactory {
  private static IDdicRepositoryAccess INSTANCE;

  /**
   * Creates new instance for DDIC repository access
   *
   * @return
   */
  public static IDdicRepositoryAccess getDdicAccess() {
    if (INSTANCE == null) {
      INSTANCE = new DdicRepositoryAccess();
    }
    return INSTANCE;
  }
}
