package com.devepos.adt.base.ui.search;

import org.eclipse.search.ui.ISearchQuery;

/**
 * {@link ISearchQuery} that searches content in a given ABAP project
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface IAbapProjectSearchQuery extends ISearchQuery {
  /**
   * @return destination id of the currently used ABAP project
   */
  String getDestinationId();
}
