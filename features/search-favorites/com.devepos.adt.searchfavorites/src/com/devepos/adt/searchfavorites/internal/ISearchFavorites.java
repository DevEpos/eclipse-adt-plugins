package com.devepos.adt.searchfavorites.internal;

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
   * @param entry
   */
  void addFavorite(ISearchFavorite entry);

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
   * Returns the favorites of the object search
   *
   * @return
   */
  List<ISearchFavorite> getFavorites();

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
