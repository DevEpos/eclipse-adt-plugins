package com.devepos.adt.cst.search.client;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.cst.internal.search.client.AdtObject;

public class AdtPackage extends AdtObject {
  private int objectCount;
  private List<AdtPackage> subPackages;
  private boolean hasSubPackages;
  private List<AdtPackage> hierarchy;
  private ISubObjectLoader subPackageLoader;

  public interface ISubObjectLoader {
    void load(IProgressMonitor monitor, String destination, IClientCodeSearchConfig specs);
  }

  public AdtPackage(String uri, String name, String displayName, int objectCount,
      AdtPackage parent) {
    super(uri, name, displayName, IAdtObjectTypeConstants.PACKAGE, parent);
    this.objectCount = objectCount;
  }

  public boolean isHasSubPackages() {
    return hasSubPackages;
  }

  public void setHasSubPackages(boolean hasSubPackages) {
    this.hasSubPackages = hasSubPackages;
  }

  public void setSubPackageLoader(ISubObjectLoader loader) {
    this.subPackageLoader = loader;
  }

  public ISubObjectLoader getSubPackageLoader() {
    return subPackageLoader;
  }

  public int getObjectCount() {
    return objectCount;
  }

  public List<AdtPackage> getSubPackages() {
    if (subPackages == null) {
      subPackages = new ArrayList<>();
    }
    return subPackages;
  }

  public void setHierarchy(List<AdtPackage> hierarchy) {
    this.hierarchy = hierarchy;
  }

  public List<AdtPackage> getHierarchy() {
    return hierarchy;
  }
}
