package com.devepos.adt.cst.internal.search.client.engine;

import org.eclipse.core.runtime.IProgressMonitor;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;

public class SearchProviderFactory {
  private static final String STRING_SRC_PROVIDER_TYPE = "$STRSRC";

  public static ISearchProvider createProvider(final String type,
      final IClientCodeSearchConfig config, final IProgressMonitor monitor,
      final String destinationId) {
    var mappedType = mapType(type);

    switch (mappedType) {
    case IAdtObjectTypeConstants.CLASS:
      return new AbapClassSearchProvider(config);
    case IAdtObjectTypeConstants.FUNCTION_GROUP:
      return new FugrSearchProvider(config, monitor, destinationId);
    default:
      return new StringSourceSearchProvider();
    }
  }

  private static String mapType(final String type) {
    switch (type) {
    case IAdtObjectTypeConstants.CLASS:
    case IAdtObjectTypeConstants.FUNCTION_GROUP:
      return type;
    default:
      return STRING_SRC_PROVIDER_TYPE;
    }
  }
}
