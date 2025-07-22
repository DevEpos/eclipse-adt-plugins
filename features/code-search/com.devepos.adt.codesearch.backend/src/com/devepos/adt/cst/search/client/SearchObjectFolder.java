package com.devepos.adt.cst.search.client;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.cst.internal.search.client.Facet;

public class SearchObjectFolder {
  private String uri;
  private String displayName;
  private String name;
  private String facet;
  private String packageName;
  private List<Facet> facets;
  private int objectCount;
  private boolean hasChildrenOfSameFacet;

  public interface ISubObjectLoader {
    void load(IProgressMonitor monitor, String destination, IClientCodeSearchConfig specs);
  }

  public SearchObjectFolder(String name, String displayName, int objectCount) {
    this.objectCount = objectCount;
    this.name = name;
    this.displayName = displayName;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
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

  public int getObjectCount() {
    return objectCount;
  }

  public boolean isHasChildrenOfSameFacet() {
    return hasChildrenOfSameFacet;
  }

  public void setHasChildrenOfSameFacet(boolean hasChildrenOfSameFacet) {
    this.hasChildrenOfSameFacet = hasChildrenOfSameFacet;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getFacet() {
    return facet;
  }

  public void setFacet(String facet) {
    this.facet = facet;
  }

}
