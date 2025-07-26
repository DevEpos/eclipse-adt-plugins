package com.devepos.adt.cst.search;

import com.devepos.adt.cst.internal.messages.Messages;

/**
 * Defines include in an ABAP Class
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public enum ClassInclude implements IIncludeToSearch {
  PUBLIC_SECTION("pubSec", null, Messages.ClassInclude_publicSectionInclude_xlbl, 0x10),
  PROTECTED_SECTION("proSec", null, Messages.ClassInclude_protectedSectionInclude_xlbl, 0x20),
  PRIVATE_SECTION("priSec", null, Messages.ClassInclude_privateSectionInclude_xlbl, 0x40),
  METHODS("methods", null, Messages.ClassInclude_methodsIncludes_xlbl, 0x80),
  LOCAL_DEFINITIONS("localDef", "definitions",
      Messages.ClassInclude_localClassDefinitionsInclude_xlbl, 0x100),
  LOCAL_IMPLEMENTATIONS("localImpl", "implementations",
      Messages.ClassInclude_localClassTypesInclude_xlbl, 0x200),
  TESTS("tests", "testclasses", Messages.ClassInclude_testClassesInclude_xlbl, 0x400),
  MACROS("macros", "macros", Messages.ClassInclude_macrosInclude_xlbl, 0x800);

  private final String apiName;
  private final String adtApiInclName;
  private final int bit;
  private final String label;
  private final String labelWoMnemonic;

  ClassInclude(final String apiName, final String adtApiInclName, final String label,
      final int bit) {
    this.apiName = apiName;
    this.label = label;
    this.bit = bit;
    this.adtApiInclName = adtApiInclName;
    labelWoMnemonic = label.replace("&", "");
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
  public String getLabelWoMnemonic() {
    return labelWoMnemonic;
  }

  @Override
  public String getAdtApiInclName() {
    return adtApiInclName;
  }

}
