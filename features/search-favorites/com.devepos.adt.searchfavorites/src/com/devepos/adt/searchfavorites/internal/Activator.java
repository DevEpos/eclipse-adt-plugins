package com.devepos.adt.searchfavorites.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageRegistry;
import org.osgi.framework.BundleContext;

import com.devepos.adt.base.ui.plugin.AbstractAdtUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractAdtUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "com.devepos.adt.searchfavorites"; //$NON-NLS-1$

  // The shared instance
  private static Activator plugin;

  private ISearchFavorites searchFavorites;

  private Map<String, SearchFavoriteDescriptor> searchFavDescriptors;

  /**
   * The constructor
   */
  public Activator() {
    super(PLUGIN_ID);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

  /**
   * @return Returns all search favorites contributed to the workbench.
   */
  public Map<String, SearchFavoriteDescriptor> getSearchFavoriteDescriptors() {
    if (searchFavDescriptors == null) {
      var elements = Platform.getExtensionRegistry()
          .getConfigurationElementsFor(PLUGIN_ID, SearchFavoriteDescriptor.EXTENSION_POINT);
      searchFavDescriptors = createSearchFavoriteDescriptors(elements);
    }
    return searchFavDescriptors;
  }

  /**
   * Returns reference to the favorites of the object search
   *
   * @return
   */
  public ISearchFavorites getSearchFavoriteManager() {
    if (searchFavorites == null) {
      searchFavorites = new SearchFavorites();
      SearchFavoriteStorage.deserialize(searchFavorites);
    }
    return searchFavorites;
  }

  @Override
  public void start(final BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  @Override
  public void stop(final BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  @Override
  protected void initializeImageRegistry(final ImageRegistry reg) {
    registerImage(reg, IImages.MANAGE_SEARCH_FAVORITES, "icons/search_fav.png");
  }

  private Map<String, SearchFavoriteDescriptor> createSearchFavoriteDescriptors(
      final IConfigurationElement[] elements) {
    Map<String, SearchFavoriteDescriptor> descriptors = new HashMap<>();
    for (var element : elements) {
      if (element.getName().equals(SearchFavoriteDescriptor.EXTENSION_ELEMENT)) {
        var descriptor = new SearchFavoriteDescriptor(element);
        descriptors.put(descriptor.getTypeName(), descriptor);
      }
    }
    return descriptors;
  }

}
