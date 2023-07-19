package com.devepos.adt.base.internal.nameditem;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.devepos.adt.base.nameditem.INamedItem;

public class NamedItemCache {
  private static final String KEY_TEMPLATE = "%s:%s";
  private static NamedItemCache INSTANCE = new NamedItemCache();
  private final Map<String, List<INamedItem>> cache = new ConcurrentHashMap<>();

  public static NamedItemCache getInstance() {
    return INSTANCE;
  }

  public boolean containsKey(final String destinationId, final String uri) {
    return cache.containsKey(String.format(KEY_TEMPLATE, destinationId, uri));
  }

  public List<INamedItem> get(final String destinationId, final String uri) {
    return cache.get(String.format(KEY_TEMPLATE, destinationId, uri));
  }

  public void insert(final String destinationId, final String uri, final List<INamedItem> items) {
    cache.put(String.format(KEY_TEMPLATE, destinationId, uri), items);
  }

  public void remove(final String destinationId, final String uri) {
    cache.remove(String.format(destinationId, uri));
  }
}
