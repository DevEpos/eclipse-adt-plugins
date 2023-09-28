package com.devepos.adt.searchfavorites.internal;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.searchfavorites.internal.messages.Messages;
import com.devepos.adt.searchfavorites.model.searchfavorites.ISearchFavorite;

/**
 * Imports search favorites from a file
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class ImportFavoritesAction extends Action {

  public ImportFavoritesAction() {
    super(Messages.ImportFavoritesAction_ImportFavoritesAction_xmit, AdtBaseUIResources
        .getImageDescriptor(IAdtBaseImages.IMPORT));
  }

  @Override
  public void run() {
    final var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    final var dialog = new FileDialog(shell, SWT.OPEN);
    dialog.setFilterNames(new String[] { "XML (*.xml)", //$NON-NLS-1$
        Messages.ImportFavoritesAction_AllFilesFileType_xmit });
    dialog.setFilterExtensions(new String[] { "*.xml", "*.*" }); //$NON-NLS-1$ //$NON-NLS-2$
    dialog.setFileName("favorites.xml"); //$NON-NLS-1$

    final var importFileName = dialog.open();
    if (!"".equals(importFileName)) { //$NON-NLS-1$
      final var existingFavorites = Activator.getDefault().getSearchFavoriteManager();
      final var importedFavorites = new SearchFavorites();
      SearchFavoriteStorage.deserialize(importedFavorites, importFileName);
      int importedFavoritesCount = 0;
      int favoritesInImportFile = 0;
      if (importedFavorites.hasEntries()) {
        favoritesInImportFile = importedFavorites.getFavorites().size();
        for (final ISearchFavorite imported : importedFavorites.getFavorites()) {
          if (!existingFavorites.contains(imported.getDestinationId(), imported.getSearchType(),
              imported.getDescription())) {
            existingFavorites.addFavorite(imported);
            importedFavoritesCount++;
          }
        }
        if (importedFavoritesCount > 0) {
          SearchFavoriteStorage.serialize();
        }
        MessageDialog.openInformation(shell, Messages.ImportFavoritesAction_ImportSuccess_xtit, NLS
            .bind(Messages.ImportFavoritesAction_ImportSuccess_xmsg, importedFavoritesCount,
                favoritesInImportFile));
      } else {
        MessageDialog.openInformation(shell, Messages.ImportFavoritesAction_ImportSuccess_xtit,
            Messages.ImportFavoritesAction_NoFavoritesImported_xmsg);
      }
    }

  }
}
