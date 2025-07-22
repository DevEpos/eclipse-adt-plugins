package com.devepos.adt.cst.search.client;

import java.util.Objects;

public class SearchableObject {

  private String name;
  private String displayName;
  private String uri;
  private String type;
  private SearchObjectFolder folder;

  public SearchableObject(String name, String displayName, String type, String uri,
      SearchObjectFolder folder) {
    this.name = name;
    this.displayName = displayName;
    this.type = type;
    this.uri = uri;
    this.folder = folder;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getURI() {
    return uri;
  }

  public SearchObjectFolder getFolder() {
    return folder;
  }

  @Override
  public int hashCode() {
    return uri != null ? uri.hashCode() : name.hashCode() + type.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof SearchableObject)) {
      return false;
    }
    var other = (SearchableObject) obj;
    return Objects.equals(uri, other.uri);
  }

}
