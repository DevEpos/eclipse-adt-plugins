package com.devepos.adt.cst.search;

import com.devepos.adt.cst.internal.messages.Messages;

/**
 * Defines an include of an ABAP function group
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public enum FunctionGroupInclude implements IIncludeToSearch {
  FUNCTION_INCLUDE("func", Messages.FunctionGroupInclude_functionsIncludes_xchk, 0x10),
  NON_FUNCTION_INCLUDE("nonFunc", Messages.FunctionGroupInclude_otherIncludes_xchk, 0x20);

  private final String apiName;
  private final int bit;
  private final String label;
  private final String labelWoMnemonic;

  FunctionGroupInclude(final String apiName, final String label, final int bit) {
    this.apiName = apiName;
    this.label = label;
    this.bit = bit;
    this.labelWoMnemonic = label.replace("&", "");
  }

  @Override
  public String getApiName() {
    return apiName;
  }

  @Override
  public int getBit() {
    return bit;
  }

  @Override
  public String getLabel() {
    return label;
  }

  @Override
  public String getAdtApiInclName() {
    return null;
  }

  @Override
  public String getLabelWoMnemonic() {
    return labelWoMnemonic;
  }
}
