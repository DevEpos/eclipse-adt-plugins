package com.devepos.adt.searchfavorites.internal;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.searchfavorites.internal.messages.Messages;

/**
 * Exports the current search favorites to the file system
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class ExportFavoritesAction extends Action {
  public ExportFavoritesAction() {
    super(Messages.ExportFavoritesAction_ActionTitle_xmit, AdtBaseUIResources.getImageDescriptor(
        IAdtBaseImages.EXPORT));
  }

  @Override
  public void run() {
    final var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    final var dialog = new FileDialog(shell, SWT.SAVE);
    dialog.setFilterNames(new String[] { "XML (*.xml)", //$NON-NLS-1$
        Messages.ImportFavoritesAction_AllFilesFileType_xmit });
    dialog.setFilterExtensions(new String[] { "*.xml", "*.*" }); //$NON-NLS-1$ //$NON-NLS-2$
    dialog.setFileName("favorites.xml"); //$NON-NLS-1$

    final var exportFileName = dialog.open();
    if (!exportFileName.equals("")) { //$NON-NLS-1$
      final var favorites = Activator.getDefault().getSearchFavoriteManager();
      SearchFavoriteStorage.serialize(favorites, exportFileName);
    }
  }
}
