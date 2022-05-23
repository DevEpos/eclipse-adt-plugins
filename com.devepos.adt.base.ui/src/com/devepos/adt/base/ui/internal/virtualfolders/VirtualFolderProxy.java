package com.devepos.adt.base.ui.internal.virtualfolders;

import java.util.List;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.ui.virtualfolders.IVirtualFolderNode;
import com.sap.adt.projectexplorer.ui.internal.virtualfolders.VirtualTreeNode;

/**
 * Proxy class to access properties of a virtual folder node
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
@SuppressWarnings("restriction")
class VirtualFolderProxy implements IVirtualFolderNode {
  private VirtualTreeNode originalNode;

  public VirtualFolderProxy(final VirtualTreeNode node) {
    originalNode = node;
  }

  @Override
  public List<String> getApplicationComponentFilters() {
    return originalNode.getFacetFilter()
        .getValues(originalNode.getFacetProvider().getApplicationComponentFacet());
  }

  @Override
  public List<String> getCreatedFilters() {
    return originalNode.getFacetFilter()
        .getValues(originalNode.getFacetProvider().getCreatedFacet());
  }

  @Override
  public List<String> getPackageFilters() {
    return originalNode.getFacetFilter()
        .getValues(originalNode.getFacetProvider().getPackageFacet());
  }

  @Override
  public IProject getProject() {
    return originalNode.getProject();
  }

  @Override
  public String getSearchString() {
    return originalNode.getSearchString();
  }

  @Override
  public List<String> getTypeFilters() {
    return originalNode.getFacetFilter().getValues(originalNode.getFacetProvider().getTypeFacet());
  }

  @Override
  public List<String> getUserFilters() {
    return originalNode.getFacetFilter().getValues(originalNode.getFacetProvider().getUserFacet());
  }

}
