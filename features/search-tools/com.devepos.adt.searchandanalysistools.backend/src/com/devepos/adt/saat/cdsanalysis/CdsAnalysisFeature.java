package com.devepos.adt.saat.cdsanalysis;

public enum CdsAnalysisFeature {
  GENERAL("CDS Analysis"),
  TOP_DOWN("Top-Down Analysis"),
  WHERE_USED("Where-Used in CDS Analysis"),
  WHERE_USED_IN_FROM("Where-Used in 'from'-part of CDS Analysis"),
  WHERE_USED_IN_ASSOC("Where-Used in 'association'-part of CDS Analysis"),
  USED_ENTITIES("Used Entities of CDS Analsyis"),
  FIELD_ANALYSIS("Field Analysis"),
  FIELD_ANALYSIS_TOP_DOWN("Field Analysis - Top-Down"),
  FIELD_ANALYSIS_WHERE_USED("Field Analysis - Where-Used");

  private String name;

  CdsAnalysisFeature(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}