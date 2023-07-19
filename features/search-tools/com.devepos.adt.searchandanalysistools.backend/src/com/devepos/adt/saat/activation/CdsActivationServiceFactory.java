package com.devepos.adt.saat.activation;

import com.devepos.adt.saat.internal.activation.CdsActivationService;

public class CdsActivationServiceFactory {
  private static ICdsActivationService INSTANCE;

  public static ICdsActivationService getService() {
    if (INSTANCE == null) {
      INSTANCE = new CdsActivationService();
    }

    return INSTANCE;
  }
}
