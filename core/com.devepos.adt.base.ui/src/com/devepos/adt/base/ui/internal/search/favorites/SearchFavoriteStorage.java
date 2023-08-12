package com.devepos.adt.base.ui.internal.search.favorites;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.devepos.adt.base.model.searchfavorites.ISearchFavoritesFactory;
import com.devepos.adt.base.model.searchfavorites.util.SearchFavoritesResourceFactoryImpl;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;

/**
 * Handles the serializing/deserializing of object search favorites
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFavoriteStorage {
  private static final String FAVORITES = "favorites.xml";

  /**
   * Serializes the object search favorites
   */
  public static void serialize() {
    serialize(AdtBaseUIPlugin.getDefault().getSearchFavoriteManager(), getFavoritesFilePath());
  }

  /**
   * Serializes the given favorites to the users' default plugin location
   *
   * @param favorites the favorites to serialize
   * @param filePath
   */
  public static void serialize(final ISearchFavorites favorites, final String filePath) {
    if (favorites == null || filePath == null) {
      return;
    }
    final var factory = ISearchFavoritesFactory.eINSTANCE;
    final var eFavorites = factory.createSearchFavorites();
    favorites.getFavorites().forEach(f -> eFavorites.getFavorites().add(f));

    // Obtain a new resource set
    final Resource.Factory resourceFactory = new SearchFavoritesResourceFactoryImpl();
    try {
      final Resource resource = resourceFactory.createResource(URI.createFileURI(filePath));
      final EList<EObject> resourceContents = resource.getContents();
      resourceContents.add(eFavorites);
      final Map<String, Object> options = createEmfResourceOptions();
      resource.save(options);
    } catch (final IllegalArgumentException | IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Deserializes the object search favorites into the default location of the
   * Plugin
   *
   * @param favorites the favorite manager where the favorites should deserialized
   *                  into
   */
  public static void deserialize(final ISearchFavorites favorites) {
    deserialize(favorites, getFavoritesFilePath());
  }

  /**
   * Deserializes the object search favorites from the file system into the passed
   * {@link ISearchFavorites}
   *
   * @param favorites the favorites where the stored favorites should be
   *                  deserialized into
   * @param filePath  the path to the file where the favorites should be read from
   */
  public static void deserialize(final ISearchFavorites favorites, final String filePath) {
    if (favorites == null || filePath == null || !new File(filePath).exists()) {
      return;
    }
    // Obtain a new resource set
    final var factory = new SearchFavoritesResourceFactoryImpl();
    try {
      final var resource = factory.createResource(URI.createFileURI(filePath));
      final var options = createEmfResourceOptions();
      resource.load(options);
      final EList<EObject> resourceContents = resource.getContents();
      // List of favorites is the root
      if (resourceContents != null && resourceContents.size() == 1) {
        final var root = resourceContents.get(0);
        if (!(root instanceof com.devepos.adt.base.model.searchfavorites.ISearchFavorites)) {
          return;
        }
        var modelFavorites = (com.devepos.adt.base.model.searchfavorites.ISearchFavorites) root;
        modelFavorites.getFavorites().forEach(fav -> favorites.addFavorite(fav));
      }
    } catch (final IllegalArgumentException | IOException e) {
      e.printStackTrace();
    }
  }

  /*
   * Creates option for loading/saving favorites via EMF
   */
  private static Map<String, Object> createEmfResourceOptions() {
    final HashMap<String, Object> options = new HashMap<>();
    options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
    options.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
    options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
        Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
    return options;
  }

  /*
   * Returns the favorites file location in the current workspace
   */
  private static String getFavoritesFilePath() {
    final IPath pluginWorkspacePath = Platform.getStateLocation(AdtBaseUIPlugin.getDefault()
        .getBundle());
    return pluginWorkspacePath.addTrailingSeparator().toOSString() + FAVORITES;
  }

}