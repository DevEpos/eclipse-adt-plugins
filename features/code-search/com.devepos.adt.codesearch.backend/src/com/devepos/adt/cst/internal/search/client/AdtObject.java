package com.devepos.adt.cst.internal.search.client;

import com.devepos.adt.cst.search.client.AdtPackage;

public class AdtObject {
  private final String uri;
  private final String name;
  private final String type;
  private final AdtPackage parent;
  private final String displayName;

  public AdtObject(final String uri, final String name, final String displayName, final String type,
      final AdtPackage parent) {
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

  public String getDisplayName() {
    return displayName;
  }

  public String getType() {
    return type;
  }

}
