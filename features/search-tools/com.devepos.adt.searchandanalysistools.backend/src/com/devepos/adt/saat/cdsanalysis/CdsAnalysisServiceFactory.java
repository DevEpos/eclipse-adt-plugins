package com.devepos.adt.saat.cdsanalysis;

import com.devepos.adt.saat.internal.cdsanalysis.CdsAnalysisService;

public class CdsAnalysisServiceFactory {

  private static ICdsAnalysisService INSTANCE;

  public static ICdsAnalysisService getCdsAnalysisService() {
    if (INSTANCE == null) {
      INSTANCE = new CdsAnalysisService();
    }
    return INSTANCE;
  }
}
