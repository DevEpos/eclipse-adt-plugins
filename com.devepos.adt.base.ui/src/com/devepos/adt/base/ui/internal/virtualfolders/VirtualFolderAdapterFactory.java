package com.devepos.adt.base.ui.internal.virtualfolders;

import org.eclipse.core.runtime.IAdapterFactory;

import com.devepos.adt.base.ui.virtualfolders.IVirtualFolderNode;
import com.sap.adt.projectexplorer.ui.internal.virtualfolders.VirtualTreeNode;

@SuppressWarnings("restriction")
public class VirtualFolderAdapterFactory implements IAdapterFactory {
  private static final Class<?>[] ADAPTER_LIST;

  static {
    ADAPTER_LIST = new Class[] { IVirtualFolderNode.class };
  }

  @Override
  public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
    if (adapterType != IVirtualFolderNode.class) {
      return null;
    }
    if (adaptableObject instanceof VirtualTreeNode) {
      return adapterType.cast(new VirtualFolderProxy((VirtualTreeNode) adaptableObject));
    }
    return null;
  }

  @Override
  public Class<?>[] getAdapterList() {
    return ADAPTER_LIST;
  }

}
