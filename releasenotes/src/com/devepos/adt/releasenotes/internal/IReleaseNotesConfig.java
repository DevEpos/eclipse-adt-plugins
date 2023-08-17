package com.devepos.adt.releasenotes.internal;

/**
 * Configuration for release notes of a DevEpos feature
 *
 * @author Ludwig Stockbauer-Muhr
 */
public interface IReleaseNotesConfig {
  /**
   * @return id of the contributing plug-in
   */
  String getPlugin();

  /**
   * @return current id of the release notes of a plug-in
   */
  String getReleaseNotesId();

  /**
   * @return path to the html files of the latest release notes
   */
  String getReleaseNotesPath();

  /**
   * @return the title to be shown in the release notes editor
   */
  String getEditorTitle();
}