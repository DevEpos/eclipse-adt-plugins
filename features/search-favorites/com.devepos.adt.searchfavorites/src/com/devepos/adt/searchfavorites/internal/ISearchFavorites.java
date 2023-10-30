package com.devepos.adt.searchfavorites.internal;

import java.util.Collection;
import java.util.List;

import com.devepos.adt.base.util.IModificationProvider;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

/**
 * Manages the favorites of the object search
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface ISearchFavorites extends IModificationProvider<ISearchFavorite> {

  /**
   * Adds the given entry to the search favorites
   *
   * @param entry fav to be added
   */
  void addFavorite(ISearchFavorite entry, int index);

  /**
   * Adds list of favorites at the given index of the existing favorites
   *
   * @param list  list of favorites
   * @param index index where favorites should be inserted
   */
  void addFavorites(Collection<ISearchFavorite> list, int index);

  /**
   * Adds the given entry to the search favorites
   *
   * @param entry fav to be added
   */
  void addFavorite(ISearchFavorite entry);

  /**
   * Adds list of favorites to the end of the existing favorites
   *
   * @param list list of favorites
   */
  void addFavorites(Collection<ISearchFavorite> list);

  /**
   * Returns <code>true</code> if there is favorite with the given description
   *
   * @param destinationId the destination id of the project
   * @param searchType    the object type of the search
   * @param description   the description of a favorite
   * @return <code>true</code> if there is favorite with the given description
   */
  boolean contains(String destinationId, String searchType, String description);

  /**
   * Returns the available search favorite
   *
   * @return list of search favorites
   */
  List<ISearchFavorite> getFavorites();

  /**
   * Returns the available search favorite
   *
   * @param ignoreHidden if <code>true</code> only favorites are not marked as hidden will be
   *                     returned
   * @return list of search favorites
   *
   * @see {@link ISearchFavorite#setHidden(boolean)}
   */
  List<ISearchFavorite> getFavorites(boolean ignoreHidden);

  /**
   * Returns <code>true</code> if there is at least one history entry, otherwise
   * <code>false</code>
   *
   * @return <code>true</code> if there are history entries
   */
  boolean hasEntries();

  /**
   * Removes the given history entry from the history
   *
   * @param historyEntry the history entry to be removed
   */
  void removeFavorite(ISearchFavorite favorite);

  /**
   * Removes favorite entries that match the given criteria
   *
   * @param destinationId the destination id of the project
   * @param searchType    the object type of the search
   * @param description   the description of a favorite
   */
  void removeMatchingEntries(String destinationId, String searchType, String description);

  /**
   * Sets the favorites of the object search
   *
   * @param favorites the {@link List} of search favorites
   */
  void setFavorites(List<ISearchFavorite> favorites);

}
