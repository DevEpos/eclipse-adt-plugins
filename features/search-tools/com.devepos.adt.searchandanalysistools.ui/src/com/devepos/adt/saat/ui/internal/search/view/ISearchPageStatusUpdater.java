package com.devepos.adt.saat.ui.internal.search.view;

import org.eclipse.core.runtime.IStatus;

interface ISearchPageStatusUpdater {
  void addStatusSource(String source);

  void removeStatusSource(String source);

  /**
   * Updates the OK status of the search page
   */
  void updateOKStatus();

  /**
   * Validates and sets status in object searchpage
   *
   * @param status status to be set/validated
   * @param source identifies the source of the status
   * @return
   */
  boolean validateAndSetStatus(final IStatus status, final String source);
}
