package com.devepos.adt.cst.search;

import org.eclipse.core.runtime.IStatus;

import com.devepos.adt.cst.model.codesearch.ICodeSearchSettings;

public interface ICodeSearchSettingsService {

  /**
   * Retrieves the project specific settings for the ABAP code search
   *
   * @return the found settings or {@code null}
   */
  ICodeSearchSettings getSettings();

  /**
   * Updates the given code search settings in the ABAP backend
   *
   * @param settings code search settings object
   * @return the status of the update operation
   */
  IStatus updateSettings(ICodeSearchSettings settings);
}
