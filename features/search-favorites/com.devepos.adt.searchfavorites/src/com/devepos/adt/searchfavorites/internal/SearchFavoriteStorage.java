package com.devepos.adt.searchfavorites.internal;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;

import com.devepos.adt.base.util.EmfUtils;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavoritesFactory;
import com.devepos.adt.searchfavorites.model.searchfavorites.util.SearchFavoritesResourceFactory;

/**
 * Handles the serializing/deserializing of object search favorites
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFavoriteStorage {
  private static final String FAVORITES = "favorites.xml"; //$NON-NLS-1$

  /**
   * Deserializes the object search favorites into the default location of the
   * Plugin
   *
   * @param favorites the favorite manager where the favorites should deserialized
   *                  into
   */
  public static void deserialize(final ISearchFavorites favorites) {
    try {
      deserialize(favorites, getFavoritesFilePath());
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Deserializes the object search favorites from the file system into the passed
   * {@link ISearchFavorites}
   *
   * @param favorites the favorites where the stored favorites should be
   *                  deserialized into
   * @param filePath  the path to the file where the favorites should be read from
   * @throws IOException
   */
  public static void deserialize(final ISearchFavorites favorites, final String filePath)
      throws IOException {
    if (favorites == null || filePath == null || !new File(filePath).exists()) {
      return;
    }
    // Obtain a new resource set
    final var factory = new SearchFavoritesResourceFactory();
    final var resource = factory.createResource(URI.createFileURI(filePath));
    final var options = EmfUtils.createEmfResourceOptions();
    resource.load(options);
    final var resourceContents = resource.getContents();
    // List of favorites is the root
    if (resourceContents != null && resourceContents.size() == 1) {
      final var root = resourceContents.get(0);
      if (!(root instanceof com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites)) {
        return;
      }
      var modelFavorites = (com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorites) root;
      modelFavorites.getFavorites().forEach(fav -> favorites.addFavorite(fav));
    }

  }

  /**
   * Serializes the object search favorites
   */
  public static void serialize() {
    serialize(Activator.getDefault().getSearchFavoriteManager(), getFavoritesFilePath());
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
    final var resourceFactory = new SearchFavoritesResourceFactory();
    try {
      final var resource = resourceFactory.createResource(URI.createFileURI(filePath));
      final var resourceContents = resource.getContents();
      resourceContents.add(eFavorites);
      final var options = EmfUtils.createEmfResourceOptions();
      resource.save(options);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  /*
   * Returns the favorites file location in the current workspace
   */
  private static String getFavoritesFilePath() {
    final var pluginWorkspacePath = Platform.getStateLocation(Activator.getDefault().getBundle());
    return pluginWorkspacePath.addTrailingSeparator().toOSString() + FAVORITES;
  }

}
