package com.devepos.adt.searchfavorites.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.searchfavorites.ISearchFavoriteConnector;
import com.devepos.adt.searchfavorites.internal.messages.Messages;

public class SearchFavoriteDescriptor {
  public static final String EXTENSION_POINT = "searchFavorites";
  public static final String EXTENSION_ELEMENT = "searchFavoriteConnector";

  private static final String SEARCH_TYPE_ATTRIBUTE = "searchType";
  private static final String SEARCH_TYPE_LABEL_ATTRIBUTE = "searchTypeLabel";
  private static final String ICON_ATTRIBUTE = "icon";
  private static final String CLASS_ATTRIBUTE = "class";

  private final IConfigurationElement element;
  private ISearchFavoriteConnector favoriteConnector;

  public SearchFavoriteDescriptor(final IConfigurationElement element) {
    this.element = element;
  }

  public ISearchFavoriteConnector getConnector() {
    if (favoriteConnector == null) {
      try {
        favoriteConnector = (ISearchFavoriteConnector) element.createExecutableExtension(
            CLASS_ATTRIBUTE);
      } catch (CoreException e) {
        e.printStackTrace();
        ErrorDialog.openError(getActiveShell(),
            Messages.SearchFavoriteDescriptor_extensionError_xtit,
            Messages.SearchFavoriteDescriptor_extensionError_xmsg, e.getStatus());
      }
    }
    return favoriteConnector;
  }

  public ImageDescriptor getIcon() {
    var iconPath = element.getAttribute(ICON_ATTRIBUTE);
    var bundle = Platform.getBundle(element.getContributor().getName());
    var url = FileLocator.find(bundle, new Path(iconPath), null);
    if (url != null) {
      return ImageDescriptor.createFromURL(url);
    }
    return null;
  }

  public String getTypeLabel() {
    return element.getAttribute(SEARCH_TYPE_LABEL_ATTRIBUTE);
  }

  public String getTypeName() {
    return element.getAttribute(SEARCH_TYPE_ATTRIBUTE);
  }

  private Shell getActiveShell() {
    try {
      return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    } catch (NullPointerException exc) {
    }
    return null;
  }
}
