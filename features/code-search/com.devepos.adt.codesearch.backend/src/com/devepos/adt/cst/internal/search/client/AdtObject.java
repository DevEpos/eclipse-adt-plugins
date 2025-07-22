package com.devepos.adt.cst.internal.search.client;

import com.devepos.adt.cst.search.client.AdtPackage;

public class AdtObject {
  private String uri;
  private String name;
  private String type;
  private AdtPackage parent;
  private String displayName;

  public AdtObject(String uri, String name, String displayName, String type, AdtPackage parent) {
    this.uri = uri;
    this.name = name;
    this.displayName = displayName;
    this.type = type;
    this.parent = parent;
  }

  public String getUri() {
    return uri;
  }

  public String getName() {
    return name;
  }

  public AdtPackage getParent() {
    return parent;
  }
}
