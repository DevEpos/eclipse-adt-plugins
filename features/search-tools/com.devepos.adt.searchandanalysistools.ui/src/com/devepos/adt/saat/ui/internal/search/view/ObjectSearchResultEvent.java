package com.devepos.adt.saat.ui.internal.search.view;

import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.SearchResultEvent;

import com.sap.adt.tools.core.project.IAbapProject;

public class ObjectSearchResultEvent extends SearchResultEvent {
  private static final long serialVersionUID = -7764832293818857854L;
  private IAbapProject abapProject;
  private boolean cleanup;

  protected ObjectSearchResultEvent(final ISearchResult searchResult) {
    super(searchResult);
  }

  public IAbapProject getAbapProject() {
    return abapProject;
  }

  public boolean isCleanup() {
    return cleanup;
  }

  public void setAbapProject(final IAbapProject abapProject) {
    this.abapProject = abapProject;
  }

  public void setCleanup(final boolean cleanup) {
    this.cleanup = cleanup;
  }
}
