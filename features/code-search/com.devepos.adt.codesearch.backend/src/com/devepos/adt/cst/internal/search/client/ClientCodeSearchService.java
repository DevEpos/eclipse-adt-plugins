package com.devepos.adt.cst.internal.search.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.content.PlainTextContentHandler;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.cst.internal.CodeSearchPlugin;
import com.devepos.adt.cst.internal.search.client.engine.IPatternMatcher;
import com.devepos.adt.cst.internal.search.client.engine.MatcherFactory;
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
import com.sap.adt.communication.message.HeadersFactory;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

public class ClientCodeSearchService implements IClientBasedCodeSearchService {
  private IProject project;
  private final String destinationId;

  public ClientCodeSearchService(final IProject project) {
    this.project = project;
    destinationId = DestinationUtil.getDestinationId(project);
  }

  @Override
  public IClientCodeSearchConfig createConfig() {
    return new ClientCodeSearchConfig();
  }

  @Override
  public List<SearchObjectFolder> findFolders(final IProgressMonitor monitor,
      final IClientCodeSearchConfig config) {
    return new SearchFolderLoader(destinationId, monitor, config).run();
  }

  @Override
  public List<SearchableObject> getObjectsInFolder(SearchObjectFolder folder,
      final IClientCodeSearchConfig config, final IProgressMonitor monitor) {
    return new FolderContentLoader(destinationId, monitor, config).run(folder);
  }

  @Override
  public List<SearchObjectFolder> expandFolder(SearchObjectFolder folder,
      IClientCodeSearchConfig config, IProgressMonitor monitor) {
    var folderLoader = new SearchFolderLoader(destinationId, monitor, config);
    folderLoader.setFacets(new Facet(IFacetConstants.PACKAGE, folder.getName()));
    return folderLoader.run();
  }

  @Override
  public IStatus searchFolders(final IProgressMonitor m, final List<SearchObjectFolder> chunk,
      final IClientCodeSearchConfig config, final ISearchResultReporter reporter) {

    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);
    var pattern = Pattern.compile(config.getPatterns().get(0), Pattern.CASE_INSENSITIVE);

    for (var f : chunk) {
      var codeSearchResult = ICodeSearchFactory.eINSTANCE.createCodeSearchResult();
      var matchCount = 0;
      var searchedLines = 0;
      var searchedObjects = 0;
      var searchedSources = 0;
      var objects = new FolderContentLoader(destinationId, m, config).run(f);
      for (var o : objects) {
        var searchObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
        searchObject.setUri(o.getUri());
        var adtMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
        adtMainObj.setType(o.getType());
        adtMainObj.setName(o.getName());
        adtMainObj.setUri(o.getUri());
        searchObject.setParentUri(f.getUri());
        searchObject.setAdtMainObject(adtMainObj);

        var getClassContent = URI.create(o.getUri() + "/source/main");
        var resource = AdtRestResourceFactory.createRestResourceFactory()
            .createRestResource(getClassContent, session);
        resource.addContentHandler(new PlainTextContentHandler());
        var headerField = HeadersFactory.newField("Accept", new String[] { "text/plain" });
        var requestHeaders = HeadersFactory.newHeaders();
        requestHeaders.addField(headerField);
        try {
          var source = resource.get(m, requestHeaders, String.class);

          var sourceLines = source.split(source.indexOf("\r\n") != -1 ? "\r\n" : "\n");
          for (var i = 0; i < sourceLines.length; i++) {
            var line = sourceLines[i];
            final var matcher = pattern.matcher(line);
            while (matcher.find()) {
              var begin = matcher.start();
              var endOffset = matcher.end();
              var match = ICodeSearchFactory.eINSTANCE.createCodeSearchMatch();
              match.setUri(String.format("%s#start=%d,%d;end=%d,%d", getClassContent.toString(),
                  i + 1, begin, i + 1, endOffset));
              match.setSnippet(line);
              searchObject.getMatches().add(match);
              matchCount++;
            }
          }
          searchedObjects++;
          searchedSources++;
          searchedLines += sourceLines.length;
          if (!searchObject.getMatches().isEmpty()) {
            codeSearchResult.getSearchObjects().add(searchObject);
          }
        } catch (ResourceException exc) {
          CodeSearchPlugin.getDefault()
              .getLog()
              .log(new Status(IStatus.ERROR, CodeSearchPlugin.PLUGIN_ID,
                  String.format("Error during search of object [%s]: %s", o.getType(), o.getName()),
                  exc));
        }
        m.worked(1);
      }

      if (matchCount > 0) {
        if (f.getUri() != null) {
          var packageObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
          packageObject.setUri(f.getUri());
          var packageMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
          packageMainObj.setUri(f.getUri());
          if (f.getFacet().equals(IFacetConstants.PACKAGE)) {
            packageMainObj.setName(f.getName());
            packageMainObj.setDescription(f.getDisplayName());
          } else {
            packageMainObj.setName(f.getPackageName());
          }
          packageMainObj.setType(IAdtObjectTypeConstants.PACKAGE);
          packageObject.setAdtMainObject(packageMainObj);
          codeSearchResult.getSearchObjects().add(packageObject);
        }
      }
      codeSearchResult.setNumberOfResults(matchCount);
      codeSearchResult.setLinesOfSearchedCode(searchedLines);
      codeSearchResult.setNumberOfSearchedObjects(searchedObjects);
      codeSearchResult.setNumberOfSearchedSources(searchedSources);
      reporter.notify(codeSearchResult);
    }
    return Status.OK_STATUS;
  }

  @Override
  public IStatus searchObjects(IProgressMonitor monitor, List<SearchableObject> objects,
      IClientCodeSearchConfig searchConfig, ISearchResultReporter reporter) {

    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);
    // create matchers
    List<IPatternMatcher> matchers = new ArrayList<>();
    for (var pattern : searchConfig.getPatterns()) {
      matchers.add(MatcherFactory.createMatcher(pattern, searchConfig.isIgnoreCaseCheck()));
    }

    var searcherFactory = SourceCodeSearcherFactory.createFactory(matchers, searchConfig);

    for (var o : objects) {
      try {
        var sourceCodeProvider = SearchProviderFactory.getProvider(o.getType(), searchConfig);
        var sourceCodeReader = SourceCodeReaderFactory.getReader(o.getType(), session, monitor,
            searchConfig.isMultilineSearchOption());

        var result = sourceCodeProvider.search(o, sourceCodeReader, searcherFactory);
        if (result.getNumberOfResults() > 0) {
          if (searchConfig.isReadPackageHierarchy()) {
            addPackagesForObject(o, result, result.getSearchObjects().get(0), monitor);
          }
        }
        reporter.notify(result);
      } catch (Exception exc) {
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

  private void addPackagesForObject(SearchableObject o, ICodeSearchResult result,
      ICodeSearchObject searchObject, IProgressMonitor m) {
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
