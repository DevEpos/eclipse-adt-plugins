package com.devepos.adt.cst.search.client;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

public interface IClientBasedCodeSearchService {

  /**
   * Creates configuration instance for running the client based code search
   */
  IClientCodeSearchConfig createConfig();

  /**
   * Loads all packages relevant for the given config
   *
   * @param monitor the progress monitor
   * @param config  search configuration
   * @return the found packages
   */
  List<SearchObjectFolder> findFolders(IProgressMonitor monitor, IClientCodeSearchConfig config);

  /**
   * Loads all packages relevant for the given config and object pattern
   *
   * @param monitor       the progress monitor
   * @param config        search configuration
   * @param objectPattern the object pattern to be used
   * @return the found packages
   */
  List<SearchObjectFolder> findFolders(IProgressMonitor monitor, IClientCodeSearchConfig config,
      String objectPattern);

  /**
   * Find matches in ABAP Code
   *
   * @param monitor      the progress monitor
   * @param objects      list of objects that should be searched
   * @param searchConfig search configuration
   * @param reporter     result reporter
   */
  IStatus searchObjects(IProgressMonitor monitor, List<SearchableObject> objects,
      IClientCodeSearchConfig searchConfig, ISearchResultReporter reporter);

  /**
   * Expands the given folder and returns the contained objects according to passed folder and
   * search configuration
   *
   * @param folder  the folder to expand
   * @param config  the search configuration
   * @param monitor the progress monitor
   * @return the contained objects in the folder
   */
  List<SearchableObject> getObjectsInFolder(SearchObjectFolder folder,
      final IClientCodeSearchConfig config, final IProgressMonitor monitor);

  /**
   * Expands the given folder and returns the contained sub folders
   *
   * @param folder  the folder to expand
   * @param config  the search configuration
   * @param monitor the progress monitor
   * @return the sub folders of the folder
   */
  List<SearchObjectFolder> expandFolder(SearchObjectFolder folder,
      final IClientCodeSearchConfig config, final IProgressMonitor monitor);

}
