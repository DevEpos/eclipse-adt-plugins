package com.devepos.adt.searchfavorites.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
  private static final String BUNDLE_NAME = "com.devepos.adt.searchfavorites.internal.messages.messages"; //$NON-NLS-1$
  public static String SearchFavoriteDescriptor_extensionError_xmsg;
  public static String SearchFavoriteDescriptor_extensionError_xtit;
  public static String SearchFavoritesMenuAction_AllFavsAreHidden_xmit;
  public static String SearchFavoritesMenuAction_MissingPluginForFavSearchType_xmsg;
  public static String SearchFavoritesMenuAction_MissingPluginForFavSearchType_xtit;

  public static String Search_AddToFavorites_xmit;
  public static String Search_CreateFavoriteFromCurrentQuery_xmit;
  public static String Search_NoSearchFavorites_xmit;
  public static String Search_ManageFavorites_xmit;
  public static String Search_SearchFavoritesAction_xtol;

  public static String SearchHistorySelectionDialog_AddFavorite_xbut;

  public static String ExportFavoritesAction_ActionTitle_xmit;

  public static String FavoritesImporter_AllFavoritesSkipped_xmsg;
  public static String FavoritesImporter_AllFilesFileType_xmit;
  public static String FavoritesImporter_ExistingFavoritesSkipped_xmsg;
  public static String FavoritesImporter_ImportFailed_xmsg;
  public static String FavoritesImporter_ImportFavoritesAction_xmit;
  public static String FavoritesImporter_ImportSuccess_xmsg;
  public static String FavoritesImporter_ImportSuccess_xtit;
  public static String FavoritesImporter_NoFavoritesImported_xmsg;
  public static String FavoritesImporter_NoFavoritesInFile_xmsg;

  public static String KeyValueNamedItemFilter_valuePartNotAllowedDuringNegation_xmsg;

  public static String MainPreferencePage_InsertNewFavsAtStart_xchk;
  public static String MainPreferencePage_MakeNewFavsVisible_xchk;
  public static String MainPreferencePage_NewFavSettings_xgrp;
  public static String ManageSearchFavoritesDialog_dialogIntro_xmsg;
  public static String ManageSearchFavoritesDialog_FilteredFavoritesInfo_xlbl;
  public static String ManageSearchFavoritesDialog_HideAll;
  public static String ManageSearchFavoritesDialog_MoveDown_xbtn;
  public static String ManageSearchFavoritesDialog_MovUp_xbtn;
  public static String ManageSearchFavoritesDialog_NoFavoritesAvailable_xlbl;
  public static String ManageSearchFavoritesDialog_removeFavorite_xbut;
  public static String ManageSearchFavoritesDialog_ShowAll_xbtn;
  public static String ManageSearchFavoritesDialog_ShowHidden_xbtn;
  public static String ManageSearchFavoritesDialog_Title_xtit;

  public static String NewSearchFavoriteDialog_CreateFavorite_xbut;
  public static String NewSearchFavoriteDialog_Description_xfld;
  public static String NewSearchFavoriteDialog_DuplicateFavoriteError_xmsg;
  public static String NewSearchFavoriteDialog_FavAlreadyExists_xmsg;
  public static String NewSearchFavoriteDialog_FavAlreadyExists_xtit;
  public static String NewSearchFavoriteDialog_FavoriteSettings_xgrp;
  public static String NewSearchFavoriteDialog_NoDescriptionError_xmsg;
  public static String NewSearchFavoriteDialog_Project_xfld;
  public static String NewSearchFavoriteDialog_ProjectIndependentSetting_xckl;
  public static String NewSearchFavoriteDialog_SearchType_xfld;
  public static String NewSearchFavoriteDialog_Title_xtit;
  public static String NewSearchFavoriteDialog_SearchParameters_xgrp;
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
  }
}
