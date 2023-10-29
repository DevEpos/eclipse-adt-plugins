package com.devepos.adt.searchfavorites.internal;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.searchfavorites.internal.messages.Messages;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

public class FavoritesImporter {
  private final Consumer<List<ISearchFavorite>> afterImport;
  private final Function<ISearchFavorite, Boolean> existenceCheck;

  /**
   * Creates new instance of an importer for Search Favorites
   *
   * @param afterImport    function to be executed after at least one valid favorite has been found
   *                       during import
   * @param existenceCheck check function to be called avoid importing duplicate favorites
   * @throws IllegalArgumentException
   */
  public FavoritesImporter(final Consumer<List<ISearchFavorite>> afterImport,
      final Function<ISearchFavorite, Boolean> existenceCheck) {
    if (afterImport == null) {
      throw new IllegalArgumentException("Parameter 'afterImport' must not be null!"); //$NON-NLS-1$
    }
    this.afterImport = afterImport;
    this.existenceCheck = existenceCheck;
  }

  /**
   * Imports favorites from file
   */
  public void run() {
    final var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    final var dialog = new FileDialog(shell, SWT.OPEN);
    dialog.setFilterNames(new String[] { "XML (*.xml)", //$NON-NLS-1$
        Messages.FavoritesImporter_AllFilesFileType_xmit });
    dialog.setFilterExtensions(new String[] { "*.xml", "*.*" }); //$NON-NLS-1$ //$NON-NLS-2$
    dialog.setFileName("favorites.xml"); //$NON-NLS-1$

    final var importFileName = dialog.open();
    if ("".equals(importFileName)) { //$NON-NLS-1$
      return;
    }

    final var importedFavorites = new SearchFavorites();

    try {
      SearchFavoriteStorage.deserialize(importedFavorites, importFileName);
    } catch (IOException e) {
      MessageDialog.openError(shell, AdtBaseUIResources.getString(
          IAdtBaseStrings.Dialog_Error_xtit), MessageFormat.format(
              Messages.FavoritesImporter_ImportFailed_xmsg, importFileName));
      Activator.getDefault()
          .getLog()
          .log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Favorite Import from file failed!", //$NON-NLS-1$
              e));
      return;
    }

    if (!importedFavorites.hasEntries()) {
      MessageDialog.openInformation(shell, AdtBaseUIResources.getString(
          IAdtBaseStrings.Dialog_Information_xtit),
          Messages.FavoritesImporter_NoFavoritesInFile_xmsg);
      return;
    }

    var favCountInFile = importedFavorites.getFavorites().size();
    var entriesToBeAdded = new ArrayList<ISearchFavorite>();
    var importCount = 0;
    var skippedFavCount = 0;

    for (var newFav : importedFavorites.getFavorites()) {
      if (existenceCheck != null && existenceCheck.apply(newFav)) {
        skippedFavCount++;
        continue;
      }
      entriesToBeAdded.add(newFav);
      importCount++;
    }

    if (importCount > 0) {
      afterImport.accept(entriesToBeAdded);
      StringBuilder importMessage = new StringBuilder().append(MessageFormat.format(
          Messages.FavoritesImporter_ImportSuccess_xmsg, importCount, favCountInFile));
      if (skippedFavCount > 0) {
        importMessage.append("\n") //$NON-NLS-1$
            .append(MessageFormat.format(Messages.FavoritesImporter_ExistingFavoritesSkipped_xmsg,
                skippedFavCount, favCountInFile));
      }
      MessageDialog.openInformation(shell, Messages.FavoritesImporter_ImportSuccess_xtit,
          importMessage.toString());
    } else if (skippedFavCount == favCountInFile) {
      MessageDialog.openInformation(shell, Messages.FavoritesImporter_ImportSuccess_xtit,
          Messages.FavoritesImporter_AllFavoritesSkipped_xmsg);
    } else {
      MessageDialog.openInformation(shell, Messages.FavoritesImporter_ImportSuccess_xtit,
          Messages.FavoritesImporter_NoFavoritesImported_xmsg);
    }
  }

}
