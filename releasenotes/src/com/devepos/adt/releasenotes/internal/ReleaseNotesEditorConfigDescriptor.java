package com.devepos.adt.releasenotes.internal;

import org.eclipse.core.runtime.IConfigurationElement;

public class ReleaseNotesEditorConfigDescriptor implements IReleaseNotesConfig {
  public static final String EXTENSION_POINT = "releaseNotes";
  public static final String EXTENSION_ELEMENT = "editorConfig";

  private static final String RELEASE_NOTES_PATH_ATTRIBUTE = "releaseNotesPath";
  private static final String RELEASE_NOTES_ID_ATTRIBUTE = "releaseNotesId";
  private static final String EDITOR_TITLE_ATTRIBUTE = "editorTitle";

  private final IConfigurationElement element;

  public ReleaseNotesEditorConfigDescriptor(final IConfigurationElement element) {
    this.element = element;
  }

  @Override
  public String getEditorTitle() {
    return element.getAttribute(EDITOR_TITLE_ATTRIBUTE);
  }

  @Override
  public String getPlugin() {
    return element.getContributor().getName();
  }

  @Override
  public String getReleaseNotesId() {
    return element.getAttribute(RELEASE_NOTES_ID_ATTRIBUTE);
  }

  @Override
  public String getReleaseNotesPath() {
    return element.getAttribute(RELEASE_NOTES_PATH_ATTRIBUTE);
  }
}
