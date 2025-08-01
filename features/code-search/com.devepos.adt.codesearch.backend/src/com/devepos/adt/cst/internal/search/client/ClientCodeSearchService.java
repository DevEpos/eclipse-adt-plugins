package com.devepos.adt.cst.internal.search.client;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.cst.internal.CodeSearchPlugin;
import com.devepos.adt.cst.internal.search.client.engine.IPatternMatcher;
import com.devepos.adt.cst.internal.search.client.engine.MatcherFactory;
import com.devepos.adt.cst.internal.search.client.engine.PatternUtil;
import com.devepos.adt.cst.internal.search.client.engine.PatternUtil.StaticError;
import com.devepos.adt.cst.internal.search.client.engine.SearchProviderFactory;
import com.devepos.adt.cst.internal.search.client.engine.SourceCodeReaderFactory;
import com.devepos.adt.cst.internal.search.client.engine.SourceCodeSearcherFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchObject;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.search.client.IClientBasedCodeSearchService;
import com.devepos.adt.cst.search.client.IClientCodeSearchConfig;
import com.devepos.adt.cst.search.client.ISearchResultReporter;
import com.devepos.adt.cst.search.client.SearchObjectFolder;
import com.devepos.adt.cst.search.client.SearchableObject;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

public class ClientCodeSearchService implements IClientBasedCodeSearchService {
  private final String destinationId;

  public ClientCodeSearchService(final IProject project) {
    destinationId = DestinationUtil.getDestinationId(project);
  }

  @Override
  public IClientCodeSearchConfig createConfig() {
    return new ClientCodeSearchConfig();
  }

  @Override
  public List<SearchObjectFolder> findFolders(final IProgressMonitor monitor,
      final IClientCodeSearchConfig config) {
    return findFolders(monitor, config, config.getObjectName());
  }

  @Override
  public List<SearchObjectFolder> findFolders(final IProgressMonitor monitor,
      final IClientCodeSearchConfig config, final String objectPattern) {
    return new SearchFolderLoader(destinationId, monitor, config, objectPattern).run();
  }

  @Override
  public List<SearchableObject> getObjectsInFolder(final SearchObjectFolder folder,
      final IClientCodeSearchConfig config, final IProgressMonitor monitor) {
    return new FolderContentLoader(destinationId, monitor, config).run(folder);
  }

  @Override
  public List<SearchObjectFolder> expandFolder(final SearchObjectFolder folder,
      final IClientCodeSearchConfig config, final IProgressMonitor monitor) {
    var folderLoader = new SearchFolderLoader(destinationId, monitor, config,
        folder.getObjectPattern());
    folderLoader.setFacets(new Facet(IFacetConstants.PACKAGE, folder.getName()));
    return folderLoader.run();
  }

  @Override
  public IStatus searchObjects(final IProgressMonitor monitor, final List<SearchableObject> objects,
      final IClientCodeSearchConfig searchConfig, final ISearchResultReporter reporter) {

    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);
    // create matchers
    List<IPatternMatcher> matchers = new ArrayList<>();
    if (searchConfig.isSequentialMatching()) {
      try {
        PatternUtil.parsePatternSequence(searchConfig.getPatterns())
            .forEach(p -> matchers.add(MatcherFactory.createMatcher(p.pattern(),
                searchConfig.isUseRegExp(), searchConfig.isIgnoreCaseCheck(), p.flags())));
      } catch (StaticError e) {
        return new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID, e.getMessage(), e);
      }
    } else {
      searchConfig.getPatterns()
          .forEach(p -> matchers.add(MatcherFactory.createMatcher(p,
              searchConfig.isIgnoreCaseCheck(), searchConfig.isUseRegExp(), 0)));
    }

    var searcherFactory = SourceCodeSearcherFactory.createFactory(matchers, searchConfig);

    for (var o : objects) {
      if (monitor.isCanceled()) {
        return Status.CANCEL_STATUS;
      }
      try {
        var sourceCodeProvider = SearchProviderFactory.getProvider(o.getType(), searchConfig);
        var sourceCodeReader = SourceCodeReaderFactory.getReader(o.getType(), session, monitor,
            searchConfig.isMultilineSearchOption());

        var result = sourceCodeProvider.search(o, sourceCodeReader, searcherFactory);
        if ((result.getNumberOfResults() > 0) && searchConfig.isReadPackageHierarchy()) {
          addPackagesForObject(o, result, result.getSearchObjects().get(0), monitor);
        }
        reporter.notify(result);
      } catch (ResourceException exc) {
        CodeSearchPlugin.getDefault()
            .getLog()
            .log(new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID,
                String.format("Error during search of object [%s]: %s", o.getType(), o.getName()),
                exc));
      }
      monitor.worked(1);
    }
    return Status.OK_STATUS;
  }

  private void addPackagesForObject(final SearchableObject o, final ICodeSearchResult result,
      final ICodeSearchObject searchObject, final IProgressMonitor m) {
    var packages = PackageUtil.getPackageHierarchy(o.getUri(), m, destinationId);
    if (packages == null) {
      return;
    }

    String previousPackURI = null;
    searchObject.setParentUri(packages.get(packages.size() - 1).getUri());
    for (var pack : packages) {
      var packageObj = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
      var packageAdtObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
      packageAdtObj.setUri(pack.getUri());
      packageAdtObj.setName(pack.getName());
      packageAdtObj.setDescription(pack.getDisplayName());
      packageAdtObj.setType(pack.getType());
      packageObj.setAdtMainObject(packageAdtObj);
      packageObj.setParentUri(previousPackURI);
      packageObj.setUri(pack.getUri());
      result.getSearchObjects().add(packageObj);
      previousPackURI = pack.getUri();
    }
  }
}
