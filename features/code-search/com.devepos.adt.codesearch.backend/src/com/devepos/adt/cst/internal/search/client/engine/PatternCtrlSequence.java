package com.devepos.adt.cst.internal.search.client.engine;

public enum PatternCtrlSequence {
  BOUNDARY_START("(#b-start)", 0x01),
  BOUNDARY_END("(#b-end)", 0x02),
  MATCH("(#match)", 0x04),
  MATCH_START("(#m-start)", 0x08),
  MATCH_END("(#m-end)", 0x10),
  EXCLUDE("(#exclude)", 0x20);

  PatternCtrlSequence(final String pattern, final int flag) {
    this.pattern = pattern;
    this.flag = flag;
  }

  private final int flag;
  private final String pattern;

  @Override
  public String toString() {
    return pattern;
  }

  public int getFlag() {
    return flag;
  }

}
