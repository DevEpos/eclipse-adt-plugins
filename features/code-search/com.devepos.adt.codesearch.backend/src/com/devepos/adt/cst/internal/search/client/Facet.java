package com.devepos.adt.cst.internal.search.client;

public class Facet {
  private final String type;
  private final String name;

  public Facet(final String type, final String name) {
    this.type = type;
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

}
