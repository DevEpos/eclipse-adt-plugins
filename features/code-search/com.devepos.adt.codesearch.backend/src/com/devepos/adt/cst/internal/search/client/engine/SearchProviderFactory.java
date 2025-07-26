package com.devepos.adt.cst.internal.search.client.engine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;

public class SearchProviderFactory {
  private static final Map<String, ISearchProvider> PROVIDERS = Collections
      .synchronizedMap(new HashMap<>());
  private static final String STRING_SRC_PROVIDER_TYPE = "$STRSRC";

  public static ISearchProvider getProvider(String type, IClientCodeSearchConfig config) {
    var mappedType = mapType(type);

    return createProvider(mappedType, config);
    // var provider = PROVIDERS.get(mappedType);
    // if (provider == null) {
    // provider = createProvider(mappedType, config);
    // PROVIDERS.put(mappedType, provider);
    // }
    // return provider;
  }

  private static ISearchProvider createProvider(String mappedType, IClientCodeSearchConfig config) {
    switch (mappedType) {
    case IAdtObjectTypeConstants.CLASS:
      return new AbapClassSearchProvider(config);
    default:
      return new StringSourceSearchProvider();
    }
    // return new StringSourceSearchProvider();
  }

  private static String mapType(String type) {
    // return STRING_SRC_PROVIDER_TYPE;
    switch (type) {
    case IAdtObjectTypeConstants.CLASS:
      return type;
    default:
      return STRING_SRC_PROVIDER_TYPE;
    }
  }
}
