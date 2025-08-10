package com.devepos.adt.cst.search.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.internal.search.client.Facet;
import com.devepos.adt.cst.internal.search.client.IFacetConstants;

public class SearchObjectFolder {
  private String uri;
  private final String displayName;
  private final String name;
  private String facet;
  private String objectPattern;
  private String packageName;
  private List<Facet> facets;
  private final int objectCount;
  private boolean hasChildrenOfSameFacet;

  public interface ISubObjectLoader {
    void load(IProgressMonitor monitor, String destination, IClientCodeSearchConfig specs);
  }

  public SearchObjectFolder(final String uri, final String name, final String displayName,
      final int objectCount) {
    this(name, displayName, objectCount);
    this.uri = uri;
  }

  public SearchObjectFolder(final String name, final String displayName, final int objectCount) {
    this.objectCount = objectCount;
    this.name = name;
    this.displayName = displayName;
  }

  public String getObjectPattern() {
    return objectPattern;
  }

  public void setObjectPattern(final String objectPattern) {
    this.objectPattern = objectPattern;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(final String uri) {
    this.uri = uri;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getName() {
    return name;
  }

  public List<Facet> getFacets() {
    if (facets == null) {
      facets = new ArrayList<>();
    }
    return facets;
  }

  public boolean isPackageFacet() {
    return IFacetConstants.PACKAGE.equals(facet);
  }

  public int getObjectCount() {
    return objectCount;
  }

  public boolean isHasChildrenOfSameFacet() {
    return hasChildrenOfSameFacet;
  }

  public void setHasChildrenOfSameFacet(final boolean hasChildrenOfSameFacet) {
    this.hasChildrenOfSameFacet = hasChildrenOfSameFacet;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(final String packageName) {
    this.packageName = packageName;
  }

  public String getFacet() {
    return facet;
  }

  public void setFacet(final String facet) {
    this.facet = facet;
  }

  @Override
  public int hashCode() {
    return Objects.hash(packageName, facet, name, objectPattern);
  }

  @Override
  public String toString() {
    var result = new StringBuilder();
    result.append("(name: ");
    result.append(name);
    result.append(", facets: ");
    result.append(facets);
    result.append(")");
    return result.toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof SearchObjectFolder)) {
      return false;
    }
    var other = (SearchObjectFolder) obj;
    return Objects.equals(packageName, other.packageName) && Objects.equals(facet, other.facet)
        && Objects.equals(name, other.name) && Objects.equals(objectPattern, other.objectPattern);
  }

}
