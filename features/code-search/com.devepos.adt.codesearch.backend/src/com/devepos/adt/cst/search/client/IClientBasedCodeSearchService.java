package com.devepos.adt.cst.search.client;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

public interface IClientBasedCodeSearchService {

  /**
   * Loads all packages relevant for the given config
   * 
   * @param monitor the progress monitor
   * @param config  search configuration
   * @return the found packages
   */
  List<SearchObjectFolder> findFolders(IProgressMonitor monitor, IClientCodeSearchConfig config);

  /**
   * Find matches in ABAP Code
   *
   * @param monitor      the progress monitor
   * @param devPackage   the package that should be searched
   * @param searchConfig search configuration
   * @param reporter     result reporter
   */
  IStatus searchFolder(IProgressMonitor monitor, List<SearchObjectFolder> devPackage,
      IClientCodeSearchConfig searchConfig, ISearchResultReporter reporter);

  /**
   * Creates configuration instance for running the client based code search
   */
  IClientCodeSearchConfig createConfig();

}
