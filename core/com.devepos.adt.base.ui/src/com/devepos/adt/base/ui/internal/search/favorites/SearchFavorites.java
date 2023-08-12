
package com.devepos.adt.base.ui.internal.search.favorites;

import java.util.ArrayList;
import java.util.List;

import com.devepos.adt.base.model.searchfavorites.ISearchFavorite;
import com.devepos.adt.base.util.IModificationListener;
import com.devepos.adt.base.util.IModificationListener.ModificationKind;

/**
 * Implementation of the {@link ISearchFavorites} of the object search
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class SearchFavorites implements ISearchFavorites {
  private List<ISearchFavorite> entries;
  private final List<IModificationListener<ISearchFavorite>> listeners;

  public SearchFavorites() {
    entries = new ArrayList<>();
    listeners = new ArrayList<>();
  }

  @Override
  public void addFavorite(final ISearchFavorite entry) {
    entries.add(entry);
    notifyModificationListeners(ModificationKind.ADDED);
  }

  @Override
  public void addModificationListener(final IModificationListener<ISearchFavorite> listener) {
    listeners.add(listener);
  }

  @Override
  public boolean contains(final String destinationId, final String searchType,
      final String description) {
    return entries.stream()
        .anyMatch(f -> description.equals(f.getDescription()) && (f.getDestinationId() == null
            && destinationId == null || destinationId.equals(f.getDestinationId())) && searchType
                .equals(f.getSearchType()));
  }

  @Override
  public List<ISearchFavorite> getFavorites() {
    return entries;
  }

  @Override
  public boolean hasEntries() {
    return !entries.isEmpty();
  }

  @Override
  public void removeFavorite(final ISearchFavorite favorite) {
    entries.remove(favorite);
    notifyModificationListeners(ModificationKind.REMOVED);
    if (entries.isEmpty()) {
      notifyModificationListeners(ModificationKind.CLEARED);
    }
  }

  @Override
  public void removeModificationListener(final IModificationListener<ISearchFavorite> listener) {
    listeners.remove(listener);
  }

  @Override
  public void setFavorites(final List<ISearchFavorite> favorites) {
    entries = favorites;
  }

  private void notifyModificationListeners(final ModificationKind kind) {
    if (listeners != null) {
      for (final IModificationListener<?> listener : listeners) {
        listener.modified(kind);
      }
    }
  }

}
