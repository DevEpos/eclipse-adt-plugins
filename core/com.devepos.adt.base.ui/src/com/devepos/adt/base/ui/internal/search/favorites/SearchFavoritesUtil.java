package com.devepos.adt.base.ui.internal.search.favorites;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;

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
    var labelBuffer = new StringBuffer();
    labelBuffer.append("[");
    if (favorite.isProjectIndependent()) {
      labelBuffer.append("?");
    } else {
      labelBuffer.append(DestinationUtil.getSystemId(favorite.getDestinationId()));
    }
    labelBuffer.append("] ");
    labelBuffer.append(favorite.getDescription());
    labelBuffer.append(" (");
    labelBuffer.append(descriptor.getTypeLabel());
    labelBuffer.append(")");
    return labelBuffer.toString();
  }
}
