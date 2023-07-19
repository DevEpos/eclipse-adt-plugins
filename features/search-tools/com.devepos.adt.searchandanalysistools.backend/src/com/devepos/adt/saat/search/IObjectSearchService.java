package com.devepos.adt.saat.search;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.IAdtUriTemplateProvider;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.saat.model.objectsearch.IObjectSearchResult;
import com.devepos.adt.saat.model.objectsearch.ISearchConfig;
import com.devepos.adt.saat.model.objectsearch.ISearchQueryInput;

/**
 * Provides Object Search services
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface IObjectSearchService {
  /**
   * Retrieves an URI template provider for named items in the code search context
   *
   * @param projectProvider provides ABAP project
   * @return URI template provider for named items
   */
  IAdtUriTemplateProvider getNamedItemUriTemplateProvider(IAbapProjectProvider projectProvider);

  /**
   * Retrieves object search configuration in the given
   *
   * @param destinationId destination id of ABAP project
   * @return search configuration for a given project
   */
  ISearchConfig getSearchConfig(String destinationId);

  /**
   * Performs Object search in given destination
   *
   * @param destinationId destination Id of ABAP project
   * @param searchInput   input for the search
   * @param monitor       monitor for progress update
   * @return the result of the object search
   */
  IObjectSearchResult search(String destinationId, ISearchQueryInput searchInput,
      IProgressMonitor monitor);

  /**
   * Returns {@link Status#OK_STATUS} if the object search is available in the given project
   *
   * @param project ABAP project
   * @return {@link Status#OK_STATUS} if the object search is available in the given project
   */
  IStatus testObjectSearchFeatureAvailability(final IProject project);
}
