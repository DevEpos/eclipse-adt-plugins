
package com.devepos.adt.searchfavorites.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.devepos.adt.base.util.IModificationListener;
import com.devepos.adt.base.util.IModificationListener.ModificationKind;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

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
  public void addFavorite(ISearchFavorite entry, int index) {
    entries.add(index, entry);
    notifyModificationListeners(ModificationKind.ADDED);
  }

  @Override
  public void addFavorites(Collection<ISearchFavorite> list, int index) {
    entries.addAll(index, list);
    notifyModificationListeners(ModificationKind.ADDED);
  }

  @Override
  public void addFavorite(final ISearchFavorite entry) {
    entries.add(entry);
    notifyModificationListeners(ModificationKind.ADDED);
  }

  @Override
  public void addFavorites(Collection<ISearchFavorite> list) {
    entries.addAll(list);
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
        .anyMatch(f -> SearchFavoritesUtil.matchesFavAttributes(f, destinationId, searchType,
            description));
  }

  @Override
  public List<ISearchFavorite> getFavorites() {
    return entries;
  }

  @Override
  public List<ISearchFavorite> getFavorites(boolean ignoreHidden) {
    return ignoreHidden ? entries
        : entries.stream().filter(f -> !f.isHidden()).collect(Collectors.toList());
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

  @Override
  public void removeMatchingEntries(final String destinationId, final String searchType,
      final String description) {
    entries.removeAll(entries.stream()
        .filter(f -> SearchFavoritesUtil.matchesFavAttributes(f, destinationId, searchType,
            description))
        .collect(Collectors.toList()));
  }

}
