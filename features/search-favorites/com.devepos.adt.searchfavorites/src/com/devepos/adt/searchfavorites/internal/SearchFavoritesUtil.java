package com.devepos.adt.searchfavorites.internal;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

/**
 * Utility class for {@link ISearchFavorite}
 *
 * @author Ludwig Stockbauer-Muhr
 */
public final class SearchFavoritesUtil {

  /**
   * Returns a display for the given favorite, which can be used in Menus or
   * dialogues
   *
   * @param favorite a object search favorite
   * @return a display for the given favorite, which can be used in Menus or
   *         dialogues
   */
  public static String getFavoriteDisplayName(final ISearchFavorite favorite,
      final SearchFavoriteDescriptor descriptor) {
    // TODO: check if label provider exists via descriptor to change the label of a favorite
    StringBuilder labelBuffer = new StringBuilder();
    labelBuffer.append("["); //$NON-NLS-1$
    if (favorite.isProjectIndependent()) {
      labelBuffer.append("?"); //$NON-NLS-1$
    } else {
      labelBuffer.append(DestinationUtil.getSystemId(favorite.getDestinationId()));
    }
    labelBuffer.append("] "); //$NON-NLS-1$
    labelBuffer.append(favorite.getDescription());
    labelBuffer.append(" ("); //$NON-NLS-1$
    labelBuffer.append(descriptor.getTypeLabel());
    labelBuffer.append(")"); //$NON-NLS-1$
    return labelBuffer.toString();
  }

  /**
   * Checks if the favorite's attributes match the given {@code destinationId}, {@code searchType}
   * and {@code description}
   *
   * @param f             a search favorite
   * @param destinationId destination Id of an ABAP project
   * @param searchType    internal identifier of a search type
   * @param description   description of a search favorite
   * @return {@code true} if the favorite matches the given attributes
   */
  public static boolean matchesFavAttributes(final ISearchFavorite f, final String destinationId,
      final String searchType, final String description) {
    if (!description.equalsIgnoreCase(f.getDescription()) || (((f.getDestinationId() != null) || (destinationId != null)) && !destinationId.equals(f
        .getDestinationId()))) {
      return false;
    }

    return searchType.equals(f.getSearchType());
  }
}
