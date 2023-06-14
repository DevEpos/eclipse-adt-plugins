package com.devepos.adt.base.ui.internal;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.ILaunchable;

public class LaunchableAdapterFactory implements IAdapterFactory {

  @Override
  public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
    return adapterType.cast(new ILaunchable() {
    });
  }

  @Override
  public Class<?>[] getAdapterList() {
    return new Class[] { ILaunchable.class };
  }

}
