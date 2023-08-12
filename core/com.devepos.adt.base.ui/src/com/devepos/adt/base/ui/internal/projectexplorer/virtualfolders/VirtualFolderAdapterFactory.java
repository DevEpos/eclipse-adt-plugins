package com.devepos.adt.base.ui.internal.projectexplorer.virtualfolders;

import org.eclipse.core.runtime.IAdapterFactory;

import com.devepos.adt.base.ui.projectexplorer.virtualfolders.IVirtualFolderNode;
import com.sap.adt.projectexplorer.ui.internal.virtualfolders.VirtualFolderNode;

@SuppressWarnings("restriction")
public class VirtualFolderAdapterFactory implements IAdapterFactory {
  private static final Class<?>[] ADAPTER_LIST;

  static {
    ADAPTER_LIST = new Class[] { IVirtualFolderNode.class };
  }

  @Override
  public <T> T getAdapter(final Object adaptableObject, final Class<T> adapterType) {
    if (adapterType != IVirtualFolderNode.class) {
      return null;
    }
    if (adaptableObject instanceof VirtualFolderNode) {
      return adapterType.cast(new VirtualFolderProxy((VirtualFolderNode) adaptableObject));
    }
    return null;
  }

  @Override
  public Class<?>[] getAdapterList() {
    return ADAPTER_LIST;
  }

}
