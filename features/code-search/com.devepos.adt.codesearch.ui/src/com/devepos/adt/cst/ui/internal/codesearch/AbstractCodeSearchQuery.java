package com.devepos.adt.cst.ui.internal.codesearch;

import org.eclipse.core.resources.IProject;
import org.eclipse.search.ui.ISearchResult;

import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.search.AbstractAbapProjectSearchQuery;
import com.devepos.adt.cst.ui.internal.codesearch.result.CodeSearchResult;
import com.devepos.adt.cst.ui.internal.messages.Messages;

public abstract class AbstractCodeSearchQuery extends AbstractAbapProjectSearchQuery {

  public static final String SEARCH_FAVORITE_TYPE = "com.devepos.adt.codesearch";

  protected CodeSearchResult searchResult;
  protected long startTime;
  protected CodeSearchQuerySpecification querySpecs;
  protected boolean continueQuery;
  protected boolean isContinueForCurrentExecution;
  protected boolean finished;

  public AbstractCodeSearchQuery(CodeSearchQuerySpecification specs) {
    this.querySpecs = specs;
  }

  @Override
  public boolean canRunInBackground() {
    return true;
  }

  @Override
  public String getDestinationId() {
    return getProjectProvider().getDestinationId();
  }

  @Override
  public IProject getProject() {
    var pp = getProjectProvider();
    return pp != null && pp.hasProject() ? pp.getProject() : null;
  }

  @Override
  public String getLabel() {
    return Messages.CodeSearchQuery_queryName_xlbl;
  }

  public IAbapProjectProvider getProjectProvider() {
    return querySpecs.getProjectProvider();
  }

  public CodeSearchQuerySpecification getQuerySpecs() {
    return querySpecs;
  }

  @Override
  public ISearchResult getSearchResult() {
    return searchResult;
  }

  public boolean isFinished() {
    return finished;
  }

  public void setContinue(final boolean continueQuery, AbstractCodeSearchQuery codeSearchQuery) {
    this.continueQuery = continueQuery;
  }

  public void setQuerySpecs(final CodeSearchQuerySpecification querySpecs,
      AbstractCodeSearchQuery codeSearchQuery) {
    this.querySpecs = querySpecs;
  }

  protected void start() {
    startTime = System.currentTimeMillis();
  }

  public long getStartTime() {
    return startTime;
  }

  public abstract boolean canContinue();
}