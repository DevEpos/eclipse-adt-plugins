package com.devepos.adt.cst.search.client;

import java.util.Objects;

public class SearchableObject {

  private final String name;
  private final String displayName;
  private String uri;
  private String type;
  private final SearchObjectFolder folder;
  private boolean isSearched = false;

  public SearchableObject(final String name, final String displayName, final String type,
      final String uri, final SearchObjectFolder folder) {
    this.name = name;
    this.displayName = displayName;
    this.type = type;
    this.uri = uri;
    this.folder = folder;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public SearchObjectFolder getFolder() {
    return folder;
  }

  public boolean isSearched() {
    return isSearched;
  }

  public void setSearched(final boolean isSearched) {
    this.isSearched = isSearched;
  }

  @Override
  public int hashCode() {
    return uri != null ? uri.hashCode() : Objects.hash(name, type);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof SearchableObject)) {
      return false;
    }
    var other = (SearchableObject) obj;
    return Objects.equals(uri, other.uri) && Objects.equals(name, other.name)
        && Objects.equals(type, other.type);
  }

}
