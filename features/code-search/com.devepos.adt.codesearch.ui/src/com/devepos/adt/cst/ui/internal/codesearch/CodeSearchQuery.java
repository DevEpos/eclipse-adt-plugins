package com.devepos.adt.cst.ui.internal.codesearch;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScope;
import com.devepos.adt.cst.search.CodeSearchFactory;
import com.devepos.adt.cst.search.IBackendBasedCodeSearchService;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.codesearch.result.CodeSearchResult;

/**
 * Query for running Code Search in the custom ABAP Code Search ABAP implementation
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CodeSearchQuery extends AbstractCodeSearchQuery {

  private static final int FALLBACK_PACKAGE_SIZE = 100;
  private static final float WORK_UNITS_PACKAGE = 10.0f;

  private int currentOffset;

  public CodeSearchQuery(final CodeSearchQuerySpecification querySpecs) {
    super(querySpecs);
    searchResult = new CodeSearchResult(this);
  }

  @Override
  public boolean canContinue() {
    return true;
  }

  @Override
  public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
    finished = false;
    isContinueForCurrentExecution = continueQuery;
    continueQuery = false;

    if (!isContinueForCurrentExecution) {
      searchResult.reset();
    }

    start();

    // check project availability
    var projectProvider = querySpecs.getProjectProvider();
    if (projectProvider == null) {
      projectProvider = AbapProjectProviderAccessor
          .getProviderForDestination(querySpecs.getDestinationId());
      querySpecs.setProjectProvider(projectProvider);
    }
    final var destinationId = querySpecs.getDestinationId();
    if (destinationId == null) {
      return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID, AdtBaseUIResources
          .format(IAdtBaseStrings.Destinations_DestinationNotValid_xmsg, destinationId));
    }
    var logonStatus = ProjectUtil.ensureLoggedOnToProject(projectProvider.getProject());
    if (!logonStatus.isOK()) {
      return logonStatus;
    }

    var service = CodeSearchFactory.getBackendCodeSearchService(projectProvider.getProject());

    // create the scope to retrieve the number of objects that need / should be searched
    var scopeParameters = querySpecs.createScopeParameters();
    var scope = service.createScope(scopeParameters, monitor);

    if (scope == null || scope.getObjectCount() <= 0) {
      searchResult.setNoObjectsInScope();
    } else {
      searchResult.setObjectScopeCount(scope.getObjectCount());
      startSearchingWithScope(monitor, scope, service, destinationId);
    }
    finished = true;
    return Status.OK_STATUS;
  }

  private void setInitialWorkedValue(final IProgressMonitor monitor, final ICodeSearchScope scope,
      final int workUnits) {
    // update current percentage of progress
    if (currentOffset > 0) {
      var workedUnits = (int) Math
          .ceil((scope.getObjectCount() - currentOffset) / WORK_UNITS_PACKAGE);
      monitor.worked(workUnits - workedUnits);
    }
  }

  private void startSearchingWithScope(final IProgressMonitor monitor, final ICodeSearchScope scope,
      final IBackendBasedCodeSearchService service, final String destinationId) {

    var uriParams = querySpecs.buildSearchUriParameters();
    uriParams.put(SearchParameter.SCOPE_ID.getUriName(), scope.getId());
    uriParams.put(SearchParameter.MAX_OBJECTS.getUriName(), FALLBACK_PACKAGE_SIZE);

    if (!isContinueForCurrentExecution) {
      currentOffset = 0;
    }
    var workUnits = (int) Math.ceil(scope.getObjectCount() / WORK_UNITS_PACKAGE);
    if (workUnits <= 0) {
      workUnits = 1;
    }
    monitor.beginTask("", workUnits);
    setInitialWorkedValue(monitor, scope, workUnits);

    while (currentOffset < scope.getObjectCount()) {
      uriParams.put(SearchParameter.SCOPE_OFFSET.getUriName(), currentOffset);

      var serviceSearchResult = service.search(uriParams, monitor);
      searchResult.addResult(serviceSearchResult);

      monitor.worked(
          (int) Math.ceil(serviceSearchResult.getNumberOfSearchedObjects() / WORK_UNITS_PACKAGE));
      currentOffset += serviceSearchResult.getNumberOfSearchedObjects();
    }
    monitor.done();
  }
}
