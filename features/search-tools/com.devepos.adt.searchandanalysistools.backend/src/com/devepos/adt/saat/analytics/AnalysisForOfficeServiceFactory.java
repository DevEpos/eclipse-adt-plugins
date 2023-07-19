package com.devepos.adt.saat.analytics;

import com.devepos.adt.saat.internal.analytics.AnalysisForOfficeService;

public class AnalysisForOfficeServiceFactory {

  private static IAnalysisForOfficeService INSTANCE;

  public static IAnalysisForOfficeService getService() {
    if (INSTANCE == null) {
      INSTANCE = new AnalysisForOfficeService();
    }
    return INSTANCE;
  }
}
