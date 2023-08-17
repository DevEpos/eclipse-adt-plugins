package com.devepos.adt.releasenotes.internal;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

public class ReleaseNotesEditorInputPersist implements IElementFactory {

  public static String FACTORY_ID = "com.devepos.adt.releasenotes.ReleaseNotesEditorInputPersist";

  public static final String TAB_TITLE_MEMENTO_KEY = "tabTitle";
  public static final String PATH_MEMENTO_KEY = "path";
  public static final String PLUGIN_MEMENTO_KEY = "plugin";

  public static void saveState(final IMemento memento, final ReleaseNotesEditorInput input) {
    if (memento != null && input != null) {
      memento.putString(PLUGIN_MEMENTO_KEY, input.getPlugin());
      memento.putString(PATH_MEMENTO_KEY, input.getPath());
      memento.putString(TAB_TITLE_MEMENTO_KEY, input.getTabTitle());
    }
  }

  @Override
  public IAdaptable createElement(final IMemento memento) {
    if (memento == null) {
      return null;
    }
    String plugin = memento.getString(PLUGIN_MEMENTO_KEY);
    String path = memento.getString(PATH_MEMENTO_KEY);
    String tabTitle = memento.getString(TAB_TITLE_MEMENTO_KEY);

    if (plugin != null && path != null && tabTitle != null && !plugin.isEmpty() && !path.isEmpty()
        && !tabTitle.isEmpty()) {
      try {
        var editorInput = new ReleaseNotesEditorInput(plugin, path, tabTitle);
        return editorInput;
      } catch (Exception exc) {
        Activator.getDefault().logWarning(exc);

        var releaseNotesForPlugin = Activator.getDefault().getLatestReleaseNotesForPlugin(plugin);
        if (releaseNotesForPlugin.isPresent()) {
          try {
            return new ReleaseNotesEditorInput(releaseNotesForPlugin.get());
          } catch (Exception exc2) {
            Activator.getDefault().logWarning(exc2);
          }
        }
        return null;
      }
    } else {
      return null;
    }
  }
}
