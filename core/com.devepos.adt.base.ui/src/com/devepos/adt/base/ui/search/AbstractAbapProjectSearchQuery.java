package com.devepos.adt.base.ui.search;

import org.eclipse.search.ui.ISearchQuery;

import com.sap.adt.tools.core.project.AdtProjectServiceFactory;

/**
 * Abstract query implementation for Search queries that require an ABAP project
 * 
 * @author Ludwig Stockbauer-Muhr
 */
public abstract class AbstractAbapProjectSearchQuery
    implements IAbapProjectSearchQuery, ISearchQuery {

  @Override
  public boolean canRerun() {
    var canRerun = false;
    var project = getProject();
    if (project != null) {
      canRerun = AdtProjectServiceFactory.createProjectService()
          .isProjectAccessible(project)
          .isOK();
    }
    return canRerun;
  }
}
