package com.devepos.adt.base.ui.internal.projectexplorer.node;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IAdapterFactory;

import com.devepos.adt.base.ui.projectexplorer.node.IAbapRepositoryFolderNode;
import com.sap.adt.projectexplorer.ui.internal.node.AbapFavoritePackagesNode;
import com.sap.adt.projectexplorer.ui.internal.node.AbapRepositoryCategoryFolderNode;
import com.sap.adt.projectexplorer.ui.internal.node.AbapRepositoryPackageNode;
import com.sap.adt.projectexplorer.ui.internal.node.AbapRepositoryTempPackageNode;
import com.sap.adt.projectexplorer.ui.internal.node.AbapRepositoryTypeFolderNode;
import com.sap.adt.projectexplorer.ui.internal.node.AbapSystemLibraryNode;
import com.sap.adt.projectexplorer.ui.node.AbapRepositoryBaseNode;

@SuppressWarnings("restriction")
public class AbapRepositoryFolderAdapterFactory implements IAdapterFactory {
  private static final Class<?>[] ADAPTER_LIST;

  static {
    ADAPTER_LIST = new Class[] { IAbapRepositoryFolderNode.class };
  }

  @Override
  public <T> T getAdapter(final Object adaptableObject, final Class<T> adapterType) {
    if (adapterType != IAbapRepositoryFolderNode.class) {
      return null;
    }
    if (adaptableObject instanceof AbapSystemLibraryNode) {
      return adapterType.cast(new AbapRepositoryFolderProxy(
          ((AbapSystemLibraryNode) adaptableObject).getProject(), null, null, null, null));
    }
    if (adaptableObject instanceof AbapFavoritePackagesNode) {
      var node = (AbapFavoritePackagesNode) adaptableObject;
      var packages = node.getFavoritePackageNames();
      return adapterType.cast(new AbapRepositoryFolderProxy(node.getProject(), null, null, null,
          packages != null && !packages.isEmpty() ? packages.stream().collect(Collectors.toList())
              : null));
    }
    if (adaptableObject instanceof AbapRepositoryPackageNode) {
      var node = (AbapRepositoryPackageNode) adaptableObject;
      return adapterType.cast(
          new AbapRepositoryFolderProxy(node.getProject(), null, null, null, getPackages(node)));
    }
    if (adaptableObject instanceof AbapRepositoryCategoryFolderNode) {
      var node = (AbapRepositoryCategoryFolderNode) adaptableObject;
      return adapterType.cast(new AbapRepositoryFolderProxy(node.getProject(), node.getCategory(),
          null, null, getPackages(node)));
    }
    if (adaptableObject instanceof AbapRepositoryTypeFolderNode) {
      var node = (AbapRepositoryTypeFolderNode) adaptableObject;
      return adapterType.cast(new AbapRepositoryFolderProxy(node.getProject(), null, node.getType(),
          null, getPackages(node)));
    }
    if (adaptableObject instanceof AbapRepositoryTempPackageNode) {
      var node = (AbapRepositoryTempPackageNode) adaptableObject;
      return adapterType.cast(new AbapRepositoryFolderProxy(node.getProject(), null, null,
          node.getOwnerOfLocalObject(), getPackages(node)));
    }
    return null;
  }

  @Override
  public Class<?>[] getAdapterList() {
    return ADAPTER_LIST;
  }

  private List<String> getPackages(final AbapRepositoryBaseNode node) {
    return Arrays.asList(node.getPackageName());
  }

}
