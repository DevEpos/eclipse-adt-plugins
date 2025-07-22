package com.devepos.adt.cst.internal.search.client;

public class Facet {
  private String type;
  private String name;

  public Facet(String type, String name) {
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
